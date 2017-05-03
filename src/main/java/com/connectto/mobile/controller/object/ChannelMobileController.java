package com.connectto.mobile.controller.object;
import com.connectto.mobile.common.exception.DataNotFoundException;
import com.connectto.mobile.common.exception.InternalErrorException;
import com.connectto.mobile.common.exception.PermissionDeniedException;
import com.connectto.mobile.common.util.CollectionHelper;
import com.connectto.mobile.common.util.StringHelper;
import com.connectto.mobile.controller.BaseController;
import com.connectto.mobile.entity.FavoriteBlock;
import com.connectto.mobile.service.IChannelManager;
import com.connectto.mobile.service.IFavoriteBlockManager;
import com.connectto.mobile.service.IXmlTvManager;
import org.apache.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by htdev001 on 2/11/15.
 */
public class ChannelMobileController extends BaseController {

    private static final Logger logger = Logger.getLogger(ChannelMobileController.class.getSimpleName());
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static final int DB_STATICS_FALSE = 0;
    public static final int DB_STATICS_TRUE = 1;
    
    private static int paginationGuideCount = 1;
    public static final String channelLogoPath = "https://www.connecttotv.com/staticData/iptv/channalImages/";
    private String blockDefaultPassword = "1111";
     private String SUCCESS = "SUCCESS";


    /*private IChannelManager channelManager;
    private IXmlTvManager xmlTvManager;
    private IFavoriteBlockManager favoriteBlockManager;    
    
    public String mobileChannelExistCount() {

        
        try {

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("deleted", DB_STATICS_FALSE);
            params.put("partition_id", partitionId);
            params.put("userId", userId);
            if (!CollectionHelper.isEmpty(existsChannelIdes)) {
                params.put("existsChannelIdes", existsChannelIdes);
            }
            if (channelUpdateDate != null) {
                params.put("channelUpdateDate", channelUpdateDate);
            }


            newChannelsCount = channelManager.getNewCountByParams(params);
            
        } catch (InternalErrorException e) {
            logger.error(e);
        }

        return SUCCESS;
    }

    public String mobileChannelIdes() {

        logger.info("mobileNewChannelIdes");

        User user = getSessionUser();
        if (user == null) {
            return SUCCESS;
        }

        int partitionId = user.getPartitionId();
        long userId = user.getId();

        if (partitionId == 0) {
            return SUCCESS;
        }

        try {

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("deleted", DB_STATICS_FALSE);
            params.put("partition_id", partitionId);
            params.put("userId", userId);
            if (!CollectionHelper.isEmpty(existsChannelIdes)) {
                params.put("existsChannelIdes", existsChannelIdes);
            }
            if (channelUpdateDate != null) {
                params.put("channelUpdateDate", channelUpdateDate);
            }

            newChannelIdes = channelManager.getNewIdesByParams(params);
            
        } catch (InternalErrorException e) {
            logger.error(e);
        }

        return SUCCESS;
    }

    public String mobileLoadPrimaryChannel() {

        logger.info("mobileLoadPrimaryChannel");
        User user = getSessionUser();


        if (user == null) {
            return SUCCESS;
        }

        int partitionId = user.getPartitionId();
        long userId = user.getId();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("deleted", DB_STATICS_FALSE);
        params.put("partition_id", partitionId);
        params.put("userId", userId);
        params.put("channelId", channel_id);
        params.put("channelLogoPath", channelLogoPath);

        try {

            channel = channelManager.getByChannelIdForMobile(params);
        } catch (InternalErrorException e) {
            logger.error(e);
        }

        return SUCCESS;
    }

    public String mobileLoadChannelSchedules() {

        logger.info("mobileLoadChannelSchedules");
        int partitionId = getSessionPartition();

        if (partitionId == 0) {
            return SUCCESS;
        }

        if (xml_channel_id == null || xml_channel_id == 0) {
            return SUCCESS;
        }


        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xml_channel_id", xml_channel_id);
        params.put("periodStart", periodStart);//2012
        params.put("periodEnd", periodEnd);
        params.put("deleted", DB_STATICS_FALSE);

        int paginationCount = 10;
        if (currentPage != null) {
            if (currentPage < 2) {
                currentPage = 1;
            }
            params.put("limit", paginationCount);
            params.put("offset", (currentPage - 1) * paginationCount);
        }

        //load pagination
        //int paginationCount = Initializer.getPaginationGuideCount();
        //params.put("limit", paginationCount);
        //params.put("offset", (currentPage - 1) * paginationCount);

        try {

            params.put("partition_id", partitionId);

            xmlTvs = xmlTvManager.getByParamsForMobile(params);

            if (currentPage != null) {
                //load pagination
                if (CollectionHelper.isEmpty(xmlTvs) || xmlTvs.size() < paginationCount) {
                    isLast = 1;
                } else {
                    currentPage++;
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }

        return SUCCESS;
    }
    *//*need to test*//*

    *//**
     * For first (just one time) time loaded channels, with "all" schedule
     *
     * @return
     *//*
    @Deprecated
    public String mobileGuideChannels() {

        logger.info("loadChannels");

        int partitionId = getSessionPartition();

        if (partitionId == 0) {
            return SUCCESS;
        }

        try {


            Map<String, Object> params = new HashMap<String, Object>();
            params.put("deleted", DB_STATICS_FALSE);
            params.put("partition_id", partitionId);

            channelDtos = channelManager.getDtosByParams(params);
        } catch (InternalErrorException e) {
            logger.error(e);
        }

        return SUCCESS;
    }

    @Deprecated
    public String mobileLoadChannels() {

        logger.info("mobileLoadChannels");

        int partitionId = getSessionPartition();

        if (partitionId == 0) {
            return SUCCESS;
        }

        if (currentPage < 2) {
            currentPage = 1;
        }

        try {

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("deleted", DB_STATICS_FALSE);
            params.put("partition_id", partitionId);
            params.put("updated_date", schedule_updated_date);
            if (!CollectionHelper.isEmpty(existsChannelIdes)) {
                params.put("existsChannelIdes", existsChannelIdes);
            }

            int paginationCount = paginationGuideCount;

            params.put("limit", paginationCount);
            params.put("offset", (currentPage - 1) * paginationCount);

            channels = channelManager.getByParamsWithSchedule(params);

            if (CollectionHelper.isEmpty(channels) || channels.size() < paginationCount) {
                isLast = 1;
            } else {
                currentPage++;
            }
            
        } catch (InternalErrorException e) {
            logger.error(e);
        }

        return SUCCESS;
    }


    public String mobileLoadScheduleById() {

        logger.info("mobileLoadScheduleById");
        
        int partitionId = getSessionPartition();

        if (partitionId == 0) {
            return SUCCESS;
        }

        if (scheduleId == null) {
            return SUCCESS;
        }

        try {
            schedule = xmlTvManager.getById(scheduleId);
        } catch (InternalErrorException e) {
            logger.error(e);
        } catch (DataNotFoundException e) {
            logger.error(e);
        }

        return SUCCESS;
    }

    public String mobileChannelCategories() {
        logger.info("mobileChannelCategories");
        int partitionId = getSessionPartition();

        if (partitionId == 0) {
            return SUCCESS;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("partitionId", partitionId);

        try {
            channelCategories = channelManager.getIptvChannelCategories(params);
        } catch (InternalErrorException e) {
            logger.error(e);
        }

        return SUCCESS;
    }

    public String mobileIPTVLanguages() {
        logger.info("mobileChannelCategories");
        int partitionId = getSessionPartition();

        if (partitionId == 0) {
            return SUCCESS;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("partitionId", partitionId);

        try {
            iptvLanguages = channelManager.getIPTVLanguages(params);
        } catch (InternalErrorException e) {
            logger.error(e);
        }

        return SUCCESS;
    }

    public String favorite() {

        logger.info("favorite");
        User user = getSessionUser();

        if (user == null) {
            return SUCCESS;
        }

        int partitionId = user.getPartitionId();
        long userId = user.getId();
        if (channel_id == null || channel_id < 1) {
            logger.error("Incorrect incoming channelId");
            return SUCCESS;
        }

        Date currentDate = new Date(System.currentTimeMillis());

        FavoriteBlock favoriteBlock = new FavoriteBlock();

        favoriteBlock.setChannelId(channel_id);

        favoriteBlock.setFavoriteDateTime(currentDate);
        favoriteBlock.setPartitionId(partitionId);
        favoriteBlock.setUserId(userId);
        favoriteBlock.setFavorite(1);

        try {

            favoriteBlockManager.favorite(favoriteBlock);

        } catch (InternalErrorException e) {
            logger.error(e);
        } catch (DataNotFoundException e) {
            logger.error(e);
        } catch (PermissionDeniedException e) {
            logger.error(e);
        }

        return SUCCESS;
    }

    public String unFavorite() {

        logger.info("unFavorite");
        User user = getSessionUser();

        if (user == null) {
            return SUCCESS;
        }

        int partitionId = user.getPartitionId();
        long userId = user.getId();
        if (channel_id == null || channel_id < 1) {
            logger.error("Incorrect incoming channelId");
            return SUCCESS;
        }

        Date currentDate = new Date(System.currentTimeMillis());

        FavoriteBlock favoriteBlock = new FavoriteBlock();

        favoriteBlock.setChannelId(channel_id);

        favoriteBlock.setFavoriteDateTime(currentDate);
        favoriteBlock.setPartitionId(partitionId);
        favoriteBlock.setUserId(userId);
        favoriteBlock.setFavorite(0);

        try {

            favoriteBlockManager.unFavorite(favoriteBlock);

        } catch (InternalErrorException e) {
            logger.error(e);
        } catch (DataNotFoundException e) {
            logger.error(e);
        } catch (PermissionDeniedException e) {
            logger.error(e);
        }

        return SUCCESS;
    }

    public String block() {

        logger.info("block");
        User user = getSessionUser();

        if (user == null) {
            return SUCCESS;
        }

        int partitionId = user.getPartitionId();
        long userId = user.getId();
        if (channel_id == null || channel_id < 1) {
            logger.error("Incorrect incoming channelId");
            return SUCCESS;
        }

        if (StringHelper.isBlank(blockPassword)) {
            blockPassword = blockDefaultPassword;
        }


        Date currentDate = new Date(System.currentTimeMillis());

        FavoriteBlock favoriteBlock = new FavoriteBlock();

        favoriteBlock.setChannelId(channel_id);
        favoriteBlock.setBlockDateTime(currentDate);
        favoriteBlock.setPartitionId(partitionId);
        favoriteBlock.setUserId(userId);
        favoriteBlock.setBlock(1);
        favoriteBlock.setBlockPassword(blockPassword);

        try {

            favoriteBlockManager.block(favoriteBlock);

        } catch (InternalErrorException e) {
            logger.error(e);
        } catch (DataNotFoundException e) {
            logger.error(e);
        } catch (PermissionDeniedException e) {
            logger.error(e);
        }

        return SUCCESS;
    }

    public String unBlock() {

        logger.info("unBlock");
        User user = getSessionUser();

        if (user == null) {
            return SUCCESS;
        }

        int partitionId = user.getPartitionId();
        long userId = user.getId();
        if (channel_id == null || channel_id < 1) {
            logger.error("Incorrect incoming channelId");
            return SUCCESS;
        }

        if (StringHelper.isBlank(blockPassword)) {
            return SUCCESS;
        }

        Date currentDate = new Date(System.currentTimeMillis());

        FavoriteBlock favoriteBlock = new FavoriteBlock();
        favoriteBlock.setChannelId(channel_id);
        favoriteBlock.setBlockDateTime(currentDate);
        favoriteBlock.setPartitionId(partitionId);
        favoriteBlock.setUserId(userId);
        favoriteBlock.setBlock(0);
        favoriteBlock.setBlockPassword(blockPassword);

        try {

            favoriteBlockManager.unblock(favoriteBlock);

        } catch (InternalErrorException e) {
            logger.error(e);
        } catch (DataNotFoundException e) {
            logger.error(e);
        } catch (PermissionDeniedException e) {
            logger.error(e);
        }

        return SUCCESS;
    }*/
    
    
}
