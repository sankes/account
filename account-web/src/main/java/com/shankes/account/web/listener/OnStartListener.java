package com.shankes.account.web.listener;

import com.shankes.account.web.config.VersionInfo;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 平台启动监听，主要负责打印版本信息、加载配置文件缓存、加载表缓存以及初始化服务上下文信息。
 *
 * @author shankes
 * @date 12/25/2017
 */
public class OnStartListener implements ServletContextListener {

    private Logger log = Logger.getLogger(OnStartListener.class);

    private long start = 0L;

    /**
     * 清理资源
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        log.info("注销自定义监听器（OnStartListener）");
        long stop = System.currentTimeMillis();
        long used = (stop - start) / 1000;
        int hour = (int) (used / 3600);
        int minutes = (int) (used % 3600) / 60;
        int second = minutes % 60;
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sdate = formate.format(new Date(start));
        String edate = formate.format(new Date(stop));
        log.info("服务启动时间：" + sdate + ",服务停止时间：" + edate + ",共运行" + hour + "小时"
                + minutes + "分" + second + "秒.");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {

        start = System.currentTimeMillis();
        log.info("自定义监听器（OnStartListener）初始化 --------> 开始");

        // 输出版本信息
        VersionInfo.getCurrentVersion().printVersionInfo();
        // 初始化服务平台信息
        // 加载配置缓存
        // 初始化启动参数
        // 加载表缓存

        log.info("自定义监听器（OnStartListener）初始化 --------> 结束");
        long free_mem = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        long max_mem = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        long total_mem = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        log.info("服务启动完成!");
        log.info("服务启动占用内存:" + total_mem + "MB,最大内存:" + max_mem + "MB,空闲可用内存：" + free_mem + "MB");
    }
}
