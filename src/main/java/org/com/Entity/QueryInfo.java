package org.com.Entity;

import lombok.Data;

import javax.management.Query;

@Data
public class QueryInfo {
    private String querytext;
    private int  pagenum;
    private int  pagesize;
    private String querydata;
    QueryInfo(){}
    public QueryInfo(String querytext, int pagenum, int pagesize,String querydata) {
        this.querytext = querytext;
        this.pagenum = pagenum;
        this.pagesize = pagesize;
        this.querydata = querydata;
    }
}
