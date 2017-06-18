package com.springapp.mvc.dao;

import com.mongodb.WriteResult;
import com.springapp.mvc.common.FieldConfig;
import com.springapp.mvc.util.PageConfig;
import org.springframework.data.domain.Page;

public interface BaseDao<T>{

	
	public void saveObject(T object);

    public long getCount(FieldConfig... fieldConfigs);

    public Page<T> getObjectByPage(PageConfig config);

    public T getObject(String id);

    public void deleteObject(String id);

    public WriteResult updateObject(T object);
	
}
