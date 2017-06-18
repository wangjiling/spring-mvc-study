package com.springapp.mvc.util;

import com.springapp.mvc.common.FieldConfig;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vincent
 * Date: 14-3-12
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("serial")
public class PageConfig implements Serializable {

    public enum SearchCondition{
        And,Or
    }

    public enum FieldType{
        LT,GT,LTE,GTE,IN,EQ,LIKE,REGEX
    }

    public static final int DEFAULT_PAGE_SIZE = 3;									//每页显示消息条数

    private int curPage = 1; 														//当前页号（默认为1）
    private int pageCount = DEFAULT_PAGE_SIZE;

    private List<Sort.Order> orderLst = new ArrayList<Sort.Order>();
    private List<FieldConfig> listFieldConfig = new LinkedList<FieldConfig>();		//用于存放字段具体信息

    private SearchCondition condition = SearchCondition.And;						//搜索条件：与或关系

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Sort.Order> getOrderLst() {
        return orderLst;
    }

    public void setOrderLst(List<Sort.Order> orderLst) {
        this.orderLst = orderLst;
    }

    public void addFieldConfig(FieldConfig fieldConfig){
        this.listFieldConfig.add(fieldConfig);
    }

    public void clearFieldConfig(){
        listFieldConfig.clear();
    }

    public List<FieldConfig> getFieldList(){
        return this.listFieldConfig;
    }

    public void addOrder(Sort.Order order){
        orderLst.add(order);
    }

    public void clearOrder(){
        orderLst.clear();
    }

    public Sort getSort(){
        if(orderLst.isEmpty())
            return null;
        return new Sort(orderLst);
    }

    public SearchCondition getCondition() {
        return condition;
    }

    public void setCondition(SearchCondition condition) {
        this.condition = condition;
    }

}
