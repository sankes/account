package com.shankes.account.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

/**
 * session过滤器
 *
 * @author shankes
 * @date 12/25/2017
 */
public class SessionFilter implements Filter {

    /**
     * 需要排除的页面
     */

    private String excludedPages;
    private String[] excludedPageArray;

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {

    }

    /**
     * 对session进行判断当前访问是否有登录
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean isExcludedPage = false;
        // 判断是否在过滤url之外
        for (String page : excludedPageArray) {
            if (((HttpServletRequest) request).getServletPath().equals(page)) {
                isExcludedPage = true;
                break;
            }
        }
        // 在过滤url之外
        if (isExcludedPage) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = ((HttpServletRequest) request).getSession();
            // TODO 不在过滤url之外，判断session是否存在
            /*if (session == null || session.getAttribute(KeyConstant.SESSION_KEY_USER) == null) {
                ((HttpServletResponse) response).sendRedirect(" / login.htm");
            } else {
                chain.doFilter(request, response);
            }*/
        }
    }

    /**
     * 初始化函数，获取需要排除在外的url
     *
     * @param fConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        excludedPages = fConfig.getInitParameter("excludedPages");
        if (StringUtils.isNotEmpty(excludedPages)) {
            excludedPageArray = excludedPages.split(",");
        }
    }
}
