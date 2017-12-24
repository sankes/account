package com.shankes.account.web.config;

import org.apache.log4j.Logger;

/**
 * 系统版本信息。
 *
 * @author shankes
 * @date 12/25/2017
 */
public class VersionInfo {

    protected Logger log = Logger.getLogger(this.getClass());
    private static final String SYSTME_NAME = "系统版本";
    private static final String SERVER_TYPE = "Tomcat 7x";
    private static final String VERSION_DATE = "2017-12-25 00:58:00";
    private static final String VERSION = "1.0.0";

    private VersionInfo() {

    }

    public void printVersionInfo() {
        log.info(SYSTME_NAME + "：" + VERSION + " for " + SERVER_TYPE + " last modified at " + VERSION_DATE);
    }

    public static VersionInfo getCurrentVersion() {
        return VersionInfoInstance.version;
    }

    private static class VersionInfoInstance {
        private static final VersionInfo version = new VersionInfo();
    }
}
