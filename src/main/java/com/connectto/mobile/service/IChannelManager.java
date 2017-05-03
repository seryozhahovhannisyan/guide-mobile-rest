package com.connectto.mobile.service;

import com.connectto.mobile.common.exception.InternalErrorException;
import com.connectto.mobile.entity.Channel;
import com.connectto.mobile.entity.ChannelCategory;
import com.connectto.mobile.entity.IPTVLanguage;

import java.util.List;
import java.util.Map;


public interface IChannelManager {
    //pagination
    public List<Channel> getByParamsWithSchedule(Map<String, Object> params) throws InternalErrorException;

    public Channel getByChannelIdForMobile(Map<String, Object> params) throws InternalErrorException;

    public List<ChannelCategory> getIptvChannelCategories(Map<String, Object> params) throws InternalErrorException;

    public List<IPTVLanguage> getIPTVLanguages(Map<String, Object> params) throws InternalErrorException;

    public Integer getNewCountByParams(Map<String, Object> params) throws InternalErrorException;

    public List<Integer> getNewIdesByParams(Map<String, Object> params) throws InternalErrorException;

}