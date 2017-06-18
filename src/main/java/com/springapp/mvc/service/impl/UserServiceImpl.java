package com.springapp.mvc.service.impl;

import com.springapp.mvc.common.Operation;
import com.springapp.mvc.dao.impl.UserDaoImpl;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.exception.CustomException;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.util.PageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserService: vincent
 * Date: 14-1-26
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDaoImpl userDao;

    @Override
    public void save(User user) throws CustomException {
        if(null == user){
            throw new CustomException("Object is not Exist");
        }
        userDao.saveObject(saveOrUpdate(user, Operation.create));
    }

    @Override
    public boolean auth(User user) throws CustomException {
        if(null == user){
            throw new CustomException("Object is not Exist");
        }
        User userDb = userDao.findByName(user.getName());

        if(null != userDb && user.getPassword().equals(userDb.getPassword())){
            return true;
        }

        return false;
    }

    private User saveOrUpdate(User user, Operation operation) throws CustomException{
        if(null == user){
            throw new CustomException("Object is not exist");
        }
        User userDb = new User();
        String name = user.getName();
        String password = user.getPassword();

        if(operation.equals(Operation.create)){
            userDb.setName(name);
            userDb.setPassword(password);
            userDao.saveObject(userDb);
        }else if(operation.equals(Operation.update)){
            userDb = userDao.getObject(user.getId());
            if(null == userDb){
                throw new CustomException("Object is not exist");
            }
            userDb.setName(name);
            userDao.updateObject(userDb);
        }
        return userDb;
    }

    @Override
    public Page<User> getListByPage(PageConfig config) throws CustomException{
        return userDao.getObjectByPage(config);
    }

    @Override
    public User findById(String id) {
        User server = new User();
        if(!StringUtils.isEmpty(id)){
            server = userDao.getObject(id);
        }
        return server;
    }

    @Override
    public void delete(String id) throws CustomException {
        if(id == null || id.equals("")){
            throw new CustomException("Object id is error");
        }
        userDao.deleteObject(id);
    }

    @Override
    public void update(User user) throws CustomException {
        if(null == user){
            throw new CustomException("Object is not Exist");
        }
        if(StringUtils.isEmpty(user.getId())){
            throw new CustomException("Object id is error");
        }
        userDao.updateObject(saveOrUpdate(user,Operation.update));
    }
}
