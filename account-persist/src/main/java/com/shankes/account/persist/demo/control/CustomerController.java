package com.shankes.account.persist.demo.control;

import org.springframework.stereotype.Controller;

/**
 * 处理客户管理相关请求
 */
@Controller
public class CustomerController {

    /**
     * 当接口存在两个实现类的时候必须使用@Qualifier指定注入哪个实现类
     * 否则可以省略
     * 只写@Autowired
     */
    /*@Autowired
    @Qualifier("customerServiceImpl")
    private CustomerDao customerDao;*/
}
