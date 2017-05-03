package com.connectto.mobile.repository;

import com.connectto.mobile.entity.XmlTv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IXmlTvRepository extends JpaRepository<XmlTv, Long> {

    public List<XmlTv> getByParams(Map<String, Object> params);

    public List<XmlTv> getByParamsMobile(Map<String, Object> params);

}