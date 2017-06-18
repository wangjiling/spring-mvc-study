package com.springapp.mvc.common;

import com.springapp.mvc.util.PageConfig.FieldType;

/**
 * Created with IntelliJ IDEA.
 * User: vincent
 * Date: 14-3-12
 * Time: 上午10:58
 * To change this template use File | Settings | File Templates.
 */
public class FieldConfig {
    private String fieldName;
    private FieldType fieldType = FieldType.EQ;
    private Object fieldValue;
    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    public FieldType getFieldType() {
        return fieldType;
    }
    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }
    public Object getFieldValue() {
        return fieldValue;
    }
    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }
    public FieldConfig(String fieldName, FieldType fieldType, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.fieldValue = fieldValue;
    }
    public FieldConfig() {
    }
}