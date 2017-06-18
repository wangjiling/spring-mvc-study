package com.springapp.mvc.dao.impl;

import com.mongodb.WriteResult;
import com.springapp.mvc.common.FieldConfig;
import com.springapp.mvc.dao.ABaseDao;
import com.springapp.mvc.dao.BaseDao;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.util.PageConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDaoImpl extends ABaseDao<User> implements BaseDao<User> {

	@Override
	public void saveObject(User user){
		mongoTemplate.insert(user);
	}

    public User findByName(String name){
        return mongoTemplate.findOne(new Query(Criteria.where("name").is(name)), User.class);
    }

    @Override
    public long getCount(FieldConfig... fieldConfigs) {
        Query query = new Query();
        List<FieldConfig> lst = new LinkedList<FieldConfig>();
        for(FieldConfig config : fieldConfigs){
            lst.add(config);
        }
        return mongoTemplate.count(getQueryField(query, lst), User.class);
    }

    @Override
    public Page<User> getObjectByPage(PageConfig config){
        long count = getCount(config.getFieldList().toArray(new FieldConfig[]{}));
        return getPageList(config, count , User.class);
    }

    @Override
    public void deleteObject(String id){
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)), User.class);
    }

    @Override
    public User getObject(String id){
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class);
    }

    @Override
    public WriteResult updateObject(User user) {
        return mongoTemplate.updateFirst(new Query(Criteria.where("id").is(user.getId())),
                getUpdateByClass(user)
                ,User.class);
    }

}
