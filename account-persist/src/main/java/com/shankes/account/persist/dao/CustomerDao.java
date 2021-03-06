package com.shankes.account.persist.dao;

import com.shankes.account.persist.demo.bean.Customer;
import com.shankes.account.persist.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 */
@Repository
public class CustomerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDao.class);

    /**
     * 获取客户列表
     *
     * @param keyword the keyword
     * @return customer list
     */
    public List<Customer> getCustomerList(String keyword) {
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户
     *
     * @param id the id
     * @return customer
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer where id=?";
        return DatabaseHelper.queryEntity(Customer.class, sql, new Object[]{id});
    }

    /**
     * 创建客户
     *
     * @param fieldMap the field map
     * @return boolean
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     *
     * @param id       the id
     * @param fieldMap the field map
     * @return boolean
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     *
     * @param id the id
     * @return boolean
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
