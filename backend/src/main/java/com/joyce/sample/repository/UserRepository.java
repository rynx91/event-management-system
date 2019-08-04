package com.joyce.sample.repository;

import com.joyce.sample.entity.UserBean;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<UserBean, String> {

    public void delete(UserBean userBean);

    public List<UserBean> findAll();

    public UserBean getByUserId(String userId);

    public UserBean save(UserBean userBean);
}
