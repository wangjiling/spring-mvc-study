package com.springapp.mvc.dao;

import com.springapp.mvc.common.FieldConfig;
import com.springapp.mvc.util.PageConfig.FieldType;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.util.PageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;


@Repository
public abstract class ABaseDao<T> {

	@Autowired
	protected MongoTemplate mongoTemplate;

    protected Page<T> getPageList(PageConfig config, long totalCount,
                                  Class<T> cls) {
        Query query = new Query();

        if (!config.getOrderLst().isEmpty())
            query.with(new Sort(config.getOrderLst()));
        List<FieldConfig> lst = config.getFieldList();
        query = getQueryField(query, lst);
        Sort sort = config.getSort();

        query.skip(config.getPageCount() * (config.getCurPage() - 1));
        query.limit(config.getPageCount());
        Pageable pageable = null;
        if (sort != null) {
            pageable = new PageRequest(config.getCurPage(),
                    config.getPageCount(), config.getSort());
        } else {
            pageable = new PageRequest(config.getCurPage(),
                    config.getPageCount());
        }
        return new PageImpl<T>(mongoTemplate.find(query, cls), pageable,
                totalCount);
    }

    protected Query getQueryField(Query fieldQuery, List<FieldConfig> lst) {
        Query query = fieldQuery;
        FieldType type = null;
        for (FieldConfig fieldConfig : lst) {
            type = fieldConfig.getFieldType();
            if (FieldType.EQ == type) {
                query.addCriteria(Criteria.where(fieldConfig.getFieldName())
                        .is(fieldConfig.getFieldValue()));
            } else if (FieldType.GT == type) {
                query.addCriteria(Criteria.where(fieldConfig.getFieldName())
                        .gt(fieldConfig.getFieldValue()));
            } else if (FieldType.GTE == type) {
                query.addCriteria(Criteria.where(fieldConfig.getFieldName())
                        .gte(fieldConfig.getFieldValue()));
            } else if (FieldType.LT == type) {
                query.addCriteria(Criteria.where(fieldConfig.getFieldName())
                        .lt(fieldConfig.getFieldValue()));
            } else if (FieldType.LTE == type) {
                query.addCriteria(Criteria.where(fieldConfig.getFieldName())
                        .lte(fieldConfig.getFieldValue()));
            } else if (FieldType.LIKE == type) {
                //转化成正则表达式
                Pattern pattern = Pattern.compile("^.*" + fieldConfig.getFieldValue() + ".*$", Pattern.CASE_INSENSITIVE);
                query.addCriteria(Criteria.where(fieldConfig.getFieldName()).regex(pattern));
            } else if (FieldType.IN == type) {
                query.addCriteria(Criteria.where(fieldConfig.getFieldName())
                        .in(fieldConfig.getFieldValue()));
            } else if (FieldType.REGEX == type) {
                query.addCriteria(Criteria.where(fieldConfig.getFieldName())
                        .regex(String.valueOf(fieldConfig.getFieldValue())));
            }
        }
        return query;
    }

    protected Update getUpdateByClass(Object obj) {
        String fieldName = null;
        Object fieldValue = null;
        Update update = new Update();
        @SuppressWarnings("rawtypes")
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(Field f : fields){
            f.setAccessible(true);
            fieldName = f.getName();
            if(fieldName.equals("id") || fieldName.equals("serialVersionUID")){
                continue;
            }
            try {
                fieldValue = f.get(obj);
                if(fieldValue instanceof User || fieldValue instanceof List){
                    continue;
                }
                update.set(fieldName, fieldValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return update;
    }
}
