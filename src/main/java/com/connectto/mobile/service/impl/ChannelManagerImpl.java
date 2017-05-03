package com.connectto.mobile.service.impl;

import com.connectto.mobile.common.exception.InternalErrorException;
import com.connectto.mobile.common.util.CollectionHelper;
import com.connectto.mobile.entity.*;
import com.connectto.mobile.repository.IChannelCustomRepository;
import com.connectto.mobile.repository.IFavoriteBlockRepository;
import com.connectto.mobile.repository.IXmlFilesUpdateRepository;
import com.connectto.mobile.repository.IXmlTvRepository;
import com.connectto.mobile.service.IChannelManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class ChannelManagerImpl implements IChannelManager {

//    @Autowired
//    private IChannelCustomRepository channelDao;

    @Autowired
    private IFavoriteBlockRepository favoriteBlockDao;

    @Autowired
    private IXmlTvRepository xmlTvDao;

    @Autowired
    private IXmlFilesUpdateRepository xmlFilesUpdateDao;  

    @Override
    public List<ChannelCategory> getIptvChannelCategories(Map<String, Object> params) throws InternalErrorException {
        try {
            return null;//channelDao.getIptvChannelCategories(params);
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }

    @Override
    public List<IPTVLanguage> getIPTVLanguages(Map<String, Object> params) throws InternalErrorException {
        try {
            return null;// channelDao.getIPTVLanguages(params);
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }

    @Override
    //existence channelIdes
    public Integer getNewCountByParams(Map<String, Object> params) throws InternalErrorException {
        try {
            Integer newIptvChannelsCount = null;//channelDao.getNewCountByParams(params);
            newIptvChannelsCount += favoriteBlockDao.getCountByParams(params);
            return newIptvChannelsCount;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }

    @Override
    public List<Integer> getNewIdesByParams(Map<String, Object> params) throws InternalErrorException {
        List<Integer> ides = new ArrayList<>(100);
        try {

            //ides.addAll(channelDao.getNewIdesByParams(params));
            if(!CollectionHelper.isEmpty(ides)){
                params.put("notin",ides);
            }


            ides.addAll(favoriteBlockDao.getIdesByParams(params));
            return ides;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }

    @Override
    public List<Channel> getByParamsWithSchedule(Map<String, Object> params) throws InternalErrorException {
        try {
            List<Channel> channels = null;//channelDao.getByParamsWithSchedule(params);

            if (!CollectionHelper.isEmpty(channels)) {
                for (Channel channel : channels) {
                    XmlFilesUpdate firstXmlFilesUpdate = xmlFilesUpdateDao.findOne(1l);

                    Date updated_date = (Date) params.get("updated_date");
                    List<Integer> file_types = get_xml_files_updates_types(firstXmlFilesUpdate, updated_date);

                    if (!CollectionHelper.isEmpty(file_types)) {
                        params.put("file_types", file_types);

                        List<Integer> channelIdes = new ArrayList<Integer>();
                        Integer channelId = null;//channelDao.getChannelIdByXMLTVChannelId(channel.getXmlChannelId());
                        if (channelId != null && channelId > 0) {
                            channelIdes.add(channelId);

                            params.put("channelIdes", channelIdes);

                            Date periodStart = null;
                            Date periodEnd = null;

                            int countDayScheduleCreation = 7;//guideSetup.getCountDayScheduleCreation();
                            if (countDayScheduleCreation == 7) {//prev

//                                periodStart = Utils.getWeekStartDay();
//                                periodEnd = Utils.getWeekEndDay();

                            }  else {
                                throw new InternalErrorException("The period loading note marked");
                            }

                            params.put("periodStart", periodStart);
                            params.put("periodEnd", periodEnd);

                            params.remove("limit");
                            params.remove("offset");
                            List<XmlTv> xmlTvs = xmlTvDao.getByParams(params);
                            //channel.setXmlTvs(xmlTvs);
                        }
                    }
                }
            }
            return channels;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }

    @Override
    public Channel getByChannelIdForMobile(Map<String, Object> params) throws InternalErrorException {
        try {
            return null;//channelDao.getByChannelIdForMobile(params);
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }


    private List<Integer> get_xml_files_updates_types(XmlFilesUpdate firstXmlFilesUpdate, Date client_schedule_updated_date) {

        Date server_dates_for_russian_files = firstXmlFilesUpdate.getRussianFile();
        Date server_dates_for_usa_files = firstXmlFilesUpdate.getUsaFile();

        List<Integer> ret_value = new ArrayList<Integer>();

        if (client_schedule_updated_date == null) {
            client_schedule_updated_date = new Date(System.currentTimeMillis());
        }

        if (client_schedule_updated_date.compareTo(server_dates_for_russian_files) < 0)
            ret_value.add(1);

        if (client_schedule_updated_date.compareTo(server_dates_for_usa_files) < 0)
            ret_value.add(2);

        return ret_value;
    }
}