package com.springapp.mvc.service;

import com.springapp.mvc.entity.User;
import com.springapp.mvc.exception.CustomException;
import com.springapp.mvc.util.PageConfig;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserService: vincent
 * Date: 14-1-26
 * Time: 下午5:04
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    void save(User user) throws CustomException;

    boolean auth(User user) throws CustomException;

    User findById(String id);

    Page<User> getListByPage(PageConfig config) throws CustomException;

    void delete(String id) throws CustomException;

    void update(User user) throws CustomException;

}
