package com.connectto.mobile.service;

import com.connectto.mobile.common.exception.DataNotFoundException;
import com.connectto.mobile.common.exception.InternalErrorException;
import com.connectto.mobile.entity.XmlTv;

import java.util.List;
import java.util.Map;

public interface IXmlTvManager {

    public XmlTv getById(long id) throws InternalErrorException, DataNotFoundException;

    public List<XmlTv> getByParamsForMobile(Map<String, Object> params) throws InternalErrorException;

}