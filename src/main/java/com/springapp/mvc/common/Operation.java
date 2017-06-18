package com.springapp.mvc.common;

/**
 * Created with IntelliJ IDEA.
 * User: yqq
 * Date: 13-12-17
 * Time: 下午2:32
 * To change this template use File | Settings | File Templates.
 */
public enum Operation {
    create,update,delete;


    public enum Status{
        success,error
    }
    /**
     * sort type
     */
    public enum SortType{
         asc,desc
    }

    /**
     * sort by
     */
    public enum SortBy{
         id,name,time,ip,port
    }

    public enum UserRole{
        admin, staff
    }
}
