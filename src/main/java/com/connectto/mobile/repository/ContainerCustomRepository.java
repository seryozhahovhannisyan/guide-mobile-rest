package com.connectto.mobile.repository;

import com.connectto.mobile.common.exception.InternalErrorException;

import java.util.List;
import java.util.Map;

/**
 * Created by Arthur on 7/13/2016.
 */
public interface ContainerCustomRepository<T, Long> {

    List<T> getByParams(String operator, Map queryMap) throws InternalErrorException;

    List<Long> getIdesByParams(String operator, Map queryMap) throws InternalErrorException;

    Long getCountByParams(String operator, Map queryMap) throws InternalErrorException;
}
