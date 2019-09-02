package com.zl.common.filter;

import com.zl.common.converter.UnderLineToCamel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  15:21
 */
@WebFilter(filterName = "HttpFilter", urlPatterns = "/*")
public class HttpFilter implements Filter {
    private static final String CHARSET = "UTF-8";
    private static Logger logger = LoggerFactory.getLogger(HttpFilter.class.getSimpleName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            ModifyHttpRequestParametersWrapper requestWrapper = new ModifyHttpRequestParametersWrapper((HttpServletRequest)request);
            //            ModifyHttpResponseParametersWrapper responseWrapper = new ModifyHttpResponseParametersWrapper((HttpServletResponse)response);
            chain.doFilter(requestWrapper, response);
            //            byte[] content = responseWrapper.getContent();
            //            if (content != null && content.length > 0) {
            //                String outString = new String(content, CHARSET);
            //                outString = UnderLineToCamel.camelTounderLine(outString);
            //                ServletOutputStream out = response.getOutputStream();
            //                out.write(outString.getBytes(CHARSET));
            //                out.flush();
            //                out.close();
            //            }
        }
    }

    private class ModifyHttpRequestParametersWrapper extends HttpServletRequestWrapper {
        private Map<String, String[]> parameterMap;

        public ModifyHttpRequestParametersWrapper(HttpServletRequest request) {
            super(request);
            Map<String, String[]> tmpMap = request.getParameterMap();
            this.parameterMap = new HashMap<>();
            if (null != tmpMap && tmpMap.size() > 0) {
                for (Map.Entry<String, String[]> entry : tmpMap.entrySet()) {
                    this.parameterMap.put(UnderLineToCamel.underLineToCamel(entry.getKey()), entry.getValue());
                }
            }
        }

        @Override
        public String getParameter(String name) {
            String[] results = this.parameterMap.get(name);
            if (null == results || results.length <= 0) {
                return null;
            } else {
                return results[0];
            }
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return this.parameterMap;
        }

        @Override
        public Enumeration<String> getParameterNames() {
            Vector<String> vector = new Vector<>(this.parameterMap.keySet());
            return vector.elements();
        }

        @Override
        public String[] getParameterValues(String name) {
            return this.parameterMap.get(name);
        }
    }

    private class ModifyHttpResponseParametersWrapper extends HttpServletResponseWrapper {
        private ByteArrayOutputStream buffer;
        private ServletOutputStream out;

        /**
         * Constructs a response adaptor wrapping the given response.
         *
         * @param response The response to be wrapped
         * @throws IllegalArgumentException if the response is null
         */
        public ModifyHttpResponseParametersWrapper(HttpServletResponse response) {
            super(response);
            buffer = new ByteArrayOutputStream();
            out = new WrapperOutputStream(buffer);
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return out;
        }

        @Override
        public void flushBuffer() throws IOException {
            if (out != null) {
                out.flush();
            }
        }

        public byte[] getContent() throws IOException {
            flushBuffer();
            return buffer.toByteArray();
        }

        private class WrapperOutputStream extends ServletOutputStream {
            private ByteArrayOutputStream bos;

            public WrapperOutputStream(ByteArrayOutputStream bos) {
                this.bos = bos;
            }

            @Override
            public void write(int b) throws IOException {
                bos.write(b);
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setWriteListener(WriteListener arg0) {
            }
        }
    }
}
