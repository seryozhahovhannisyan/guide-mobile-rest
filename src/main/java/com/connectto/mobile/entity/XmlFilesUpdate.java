package com.connectto.mobile.entity;

import java.util.Date;

/**
 * Created by htdev001 on 2/11/15.
 */
public class XmlFilesUpdate {

    private int id;
    private Date russian_files;
    private Date usa_files;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRussian_files() {
        return russian_files;
    }

    public void setRussian_files(Date russian_files) {
        this.russian_files = russian_files;
    }

    public Date getUsa_files() {
        return usa_files;
    }

    public void setUsa_files(Date usa_files) {
        this.usa_files = usa_files;
    }
}
