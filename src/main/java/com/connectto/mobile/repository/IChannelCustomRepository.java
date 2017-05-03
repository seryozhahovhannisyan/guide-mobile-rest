package com.connectto.mobile.repository;

import com.connectto.mobile.entity.Channel;
import com.connectto.mobile.entity.ChannelCategory;
import com.connectto.mobile.entity.IPTVLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IChannelCustomRepository<Channel, Long> {

    public List<Channel> getByParamsWithSchedule(Map<String, Object> params);

    public Channel getByChannelIdForMobile(Map<String, Object> params);

    public Integer getNewCountByParams(Map<String, Object> params);

    public List<Integer> getNewIdesByParams(Map<String, Object> params);

    public List<ChannelCategory> getIptvChannelCategories(Map<String, Object> params);

    public List<IPTVLanguage> getIPTVLanguages(Map<String, Object> params);

    public Integer getChannelIdByXMLTVChannelId(int xmlTvChannelId);

    public boolean isChannelExists(int xmlTvChannelId);

}