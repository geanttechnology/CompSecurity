// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads.identity:
//            Settings, DebugProperties, Log, ThreadUtils, 
//            StringUtils, MetricsCollector, WebUtils, AndroidTargetUtils, 
//            HttpClientWebRequest, HttpURLConnectionWebRequest, ResponseReader

abstract class WebRequest
{
    public static final class HttpMethod extends Enum
    {

        private static final HttpMethod $VALUES[];
        public static final HttpMethod GET;
        public static final HttpMethod POST;
        private final String methodString;

        public static HttpMethod valueOf(String s)
        {
            return (HttpMethod)Enum.valueOf(com/amazon/device/ads/identity/WebRequest$HttpMethod, s);
        }

        public static HttpMethod[] values()
        {
            return (HttpMethod[])$VALUES.clone();
        }

        public String toString()
        {
            return methodString;
        }

        static 
        {
            GET = new HttpMethod("GET", 0, "GET");
            POST = new HttpMethod("POST", 1, "POST");
            $VALUES = (new HttpMethod[] {
                GET, POST
            });
        }

        private HttpMethod(String s, int i, String s1)
        {
            super(s, i);
            methodString = s1;
        }
    }

    static class QueryStringParameters
    {

        private final HashMap params = new HashMap();
        private String rawAppendage;

        void append(StringBuilder stringbuilder)
        {
            if (size() != 0 || !StringUtils.isNullOrEmpty(rawAppendage))
            {
                stringbuilder.append("?");
                boolean flag = true;
                Iterator iterator = params.entrySet().iterator();
                while (iterator.hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        stringbuilder.append("&");
                    }
                    stringbuilder.append((String)entry.getKey());
                    stringbuilder.append("=");
                    stringbuilder.append((String)entry.getValue());
                }
                if (rawAppendage != null && !rawAppendage.equals(""))
                {
                    if (size() != 0)
                    {
                        stringbuilder.append("&");
                    }
                    stringbuilder.append(rawAppendage);
                    return;
                }
            }
        }

        String putUnencoded(String s, String s1)
        {
            s = WebUtils.getURLEncodedString(s);
            putUrlEncoded(s, WebUtils.getURLEncodedString(s1));
            return s;
        }

        void putUrlEncoded(String s, String s1)
        {
            if (StringUtils.isNullOrWhiteSpace(s))
            {
                throw new IllegalArgumentException("The name must not be null or empty string.");
            }
            if (s1 == null)
            {
                params.remove(s);
                return;
            } else
            {
                params.put(s, s1);
                return;
            }
        }

        void setRawAppendage(String s)
        {
            rawAppendage = s;
        }

        int size()
        {
            return params.size();
        }

        QueryStringParameters()
        {
        }
    }

    public class WebRequestException extends Exception
    {

        private final WebRequestStatus status;
        final WebRequest this$0;

        protected WebRequestException(WebRequestStatus webrequeststatus, String s, Throwable throwable)
        {
            this$0 = WebRequest.this;
            super(s, throwable);
            status = webrequeststatus;
        }
    }

    public static class WebRequestFactory
    {

        public WebRequest createWebRequest()
        {
            if (AndroidTargetUtils.isAtOrBelowAndroidAPI$134632())
            {
                return new HttpClientWebRequest();
            } else
            {
                return new HttpURLConnectionWebRequest();
            }
        }

        public WebRequestFactory()
        {
        }
    }

    class WebRequestInputStream extends InputStream
    {

        private final InputStream decoratedStream;
        final WebRequest this$0;

        public void close()
            throws IOException
        {
            decoratedStream.close();
            if (disconnectEnabled)
            {
                closeConnection();
            }
        }

        public int read()
            throws IOException
        {
            return decoratedStream.read();
        }

        public WebRequestInputStream(InputStream inputstream)
        {
            this$0 = WebRequest.this;
            super();
            decoratedStream = inputstream;
        }
    }

    public static final class WebRequestStatus extends Enum
    {

        private static final WebRequestStatus $VALUES[];
        public static final WebRequestStatus INVALID_CLIENT_PROTOCOL;
        public static final WebRequestStatus MALFORMED_URL;
        public static final WebRequestStatus NETWORK_FAILURE;
        public static final WebRequestStatus NETWORK_TIMEOUT;
        public static final WebRequestStatus UNSUPPORTED_ENCODING;

        public static WebRequestStatus valueOf(String s)
        {
            return (WebRequestStatus)Enum.valueOf(com/amazon/device/ads/identity/WebRequest$WebRequestStatus, s);
        }

        public static WebRequestStatus[] values()
        {
            return (WebRequestStatus[])$VALUES.clone();
        }

        static 
        {
            NETWORK_FAILURE = new WebRequestStatus("NETWORK_FAILURE", 0);
            NETWORK_TIMEOUT = new WebRequestStatus("NETWORK_TIMEOUT", 1);
            MALFORMED_URL = new WebRequestStatus("MALFORMED_URL", 2);
            INVALID_CLIENT_PROTOCOL = new WebRequestStatus("INVALID_CLIENT_PROTOCOL", 3);
            UNSUPPORTED_ENCODING = new WebRequestStatus("UNSUPPORTED_ENCODING", 4);
            $VALUES = (new WebRequestStatus[] {
                NETWORK_FAILURE, NETWORK_TIMEOUT, MALFORMED_URL, INVALID_CLIENT_PROTOCOL, UNSUPPORTED_ENCODING
            });
        }

        private WebRequestStatus(String s, int i)
        {
            super(s, i);
        }
    }

    public class WebResponse
    {

        private String httpStatus;
        private int httpStatusCode;
        private WebRequestInputStream inputStream;
        final WebRequest this$0;

        public String getHttpStatus()
        {
            return httpStatus;
        }

        public int getHttpStatusCode()
        {
            return httpStatusCode;
        }

        public ResponseReader getResponseReader()
        {
            ResponseReader responsereader = new ResponseReader(inputStream);
            responsereader.enableLog(logResponseEnabled);
            responsereader.setExternalLogTag(getLogTag());
            return responsereader;
        }

        public boolean isHttpStatusCodeOK()
        {
            return getHttpStatusCode() == 200;
        }

        protected void setHttpStatus(String s)
        {
            httpStatus = s;
        }

        protected void setHttpStatusCode(int i)
        {
            httpStatusCode = i;
        }

        protected void setInputStream(InputStream inputstream)
        {
            inputStream = new WebRequestInputStream(inputstream);
        }

        protected WebResponse()
        {
            this$0 = WebRequest.this;
            super();
        }
    }


    private static final String LOG_TAG = com/amazon/device/ads/identity/WebRequest.getSimpleName();
    private static WebRequestFactory webRequestFactory = new WebRequestFactory();
    String acceptContentType;
    String charset;
    String contentType;
    private boolean disconnectEnabled;
    protected final HashMap headers = new HashMap();
    private HttpMethod httpMethod;
    boolean logRequestBodyEnabled;
    boolean logResponseEnabled;
    private String logTag;
    protected boolean logUrlEnabled;
    private MetricsCollector metricsCollector;
    private String nonSecureHost;
    private String path;
    private int port;
    protected HashMap postParameters;
    protected QueryStringParameters queryStringParameters;
    String requestBody;
    protected boolean secure;
    private String secureHost;
    protected Metrics.MetricType serviceCallLatencyMetric;
    private int timeout;
    private String urlString;

    WebRequest()
    {
        requestBody = null;
        acceptContentType = null;
        contentType = null;
        charset = null;
        urlString = null;
        secureHost = null;
        nonSecureHost = null;
        path = null;
        port = -1;
        httpMethod = HttpMethod.GET;
        timeout = 20000;
        logRequestBodyEnabled = false;
        logResponseEnabled = false;
        logUrlEnabled = false;
        secure = false;
        logTag = LOG_TAG;
        queryStringParameters = new QueryStringParameters();
        postParameters = new HashMap();
        boolean flag = Settings.getInstance().getBoolean("tlsEnabled", false);
        secure = DebugProperties.getInstance().getDebugPropertyAsBoolean("debug.tlsEnabled", flag);
        disconnectEnabled = true;
    }

    public static final WebRequest createJSONGetWebRequest()
    {
        WebRequest webrequest = webRequestFactory.createWebRequest();
        webrequest.setHttpMethod(HttpMethod.GET);
        webrequest.putHeader("Accept", "application/json");
        return webrequest;
    }

    protected void appendQuery(StringBuilder stringbuilder)
    {
        queryStringParameters.append(stringbuilder);
    }

    protected abstract void closeConnection();

    public void convertToJSONPostRequest()
    {
        setHttpMethod(HttpMethod.POST);
        putHeader("Accept", "application/json");
        putHeader("Content-Type", "application/json; charset=UTF-8");
    }

    protected URI createURI(URL url)
        throws URISyntaxException
    {
        return url.toURI();
    }

    protected URL createURL(String s)
        throws MalformedURLException
    {
        return new URL(s);
    }

    protected abstract WebResponse doHttpNetworkCall(URL url)
        throws WebRequestException;

    public void enableLog$1385ff()
    {
        enableLogUrl$1385ff();
        enableLogRequestBody$1385ff();
        enableLogResponse$1385ff();
    }

    public void enableLogRequestBody$1385ff()
    {
        logRequestBodyEnabled = true;
    }

    public void enableLogResponse$1385ff()
    {
        logResponseEnabled = true;
    }

    public void enableLogUrl$1385ff()
    {
        logUrlEnabled = true;
    }

    public String getHost()
    {
        if (secure)
        {
            return secureHost;
        } else
        {
            return nonSecureHost;
        }
    }

    public HttpMethod getHttpMethod()
    {
        return httpMethod;
    }

    protected String getLogTag()
    {
        return logTag;
    }

    public String getPath()
    {
        return path;
    }

    public int getPort()
    {
        return port;
    }

    public String getRequestBody()
    {
        if (getRequestBodyString() != null)
        {
            return getRequestBodyString();
        }
        if (postParameters.isEmpty())
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (Iterator iterator = postParameters.entrySet().iterator(); iterator.hasNext(); stringbuilder.append((String)entry.getKey()).append('=').append((String)entry.getValue()).append(";\n"))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return stringbuilder.toString();
    }

    public String getRequestBodyString()
    {
        return requestBody;
    }

    protected String getScheme()
    {
        if (getUseSecure())
        {
            return "https";
        } else
        {
            return "http";
        }
    }

    protected abstract String getSubLogTag();

    public int getTimeout()
    {
        return timeout;
    }

    protected String getUrl()
    {
        if (urlString != null)
        {
            return urlString;
        }
        StringBuilder stringbuilder = new StringBuilder(getScheme());
        stringbuilder.append("://");
        stringbuilder.append(getHost());
        if (getPort() != -1)
        {
            stringbuilder.append(":");
            stringbuilder.append(getPort());
        }
        stringbuilder.append(getPath());
        appendQuery(stringbuilder);
        return stringbuilder.toString();
    }

    public boolean getUseSecure()
    {
        return secure;
    }

    protected void logUrl(String s)
    {
        if (logUrlEnabled)
        {
            Log.d(getLogTag(), "%s %s", new Object[] {
                getHttpMethod(), s
            });
        }
    }

    public WebResponse makeCall()
        throws WebRequestException
    {
        if (ThreadUtils.isOnMainThread())
        {
            Log.e(logTag, "The network request should not be performed on the main thread.", new Object[0]);
        }
        setContentTypeHeaders();
        Object obj = getUrl();
        URL url;
        try
        {
            url = createURL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(logTag, "Problem with URI syntax: %s", new Object[] {
                malformedurlexception.getMessage()
            });
            throw new WebRequestException(WebRequestStatus.MALFORMED_URL, (new StringBuilder("Could not construct URL from String ")).append(((String) (obj))).toString(), malformedurlexception);
        }
        writeMetricStart(serviceCallLatencyMetric);
        obj = doHttpNetworkCall(url);
        writeMetricStop(serviceCallLatencyMetric);
        if (logResponseEnabled)
        {
            Log.d(LOG_TAG, "Response: %s %s", new Object[] {
                Integer.valueOf(((WebResponse) (obj)).getHttpStatusCode()), ((WebResponse) (obj)).getHttpStatus()
            });
        }
        return ((WebResponse) (obj));
        Object obj1;
        obj1;
        throw obj1;
        obj1;
        writeMetricStop(serviceCallLatencyMetric);
        throw obj1;
    }

    public void putHeader(String s, String s1)
    {
        if (StringUtils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        } else
        {
            headers.put(s, s1);
            return;
        }
    }

    public String putUnencodedQueryParameter(String s, String s1)
    {
        return queryStringParameters.putUnencoded(s, s1);
    }

    public void setAdditionalQueryParamsString(String s)
    {
        queryStringParameters.setRawAppendage(s);
    }

    protected void setContentTypeHeaders()
    {
        if (acceptContentType != null)
        {
            putHeader("Accept", contentType);
        }
        if (contentType != null)
        {
            String s1 = contentType;
            String s = s1;
            if (charset != null)
            {
                s = (new StringBuilder()).append(s1).append("; charset=").append(charset).toString();
            }
            putHeader("Content-Type", s);
        }
    }

    public void setExternalLogTag(String s)
    {
        if (s == null)
        {
            logTag = (new StringBuilder()).append(LOG_TAG).append(" ").append(getSubLogTag()).toString();
            return;
        } else
        {
            logTag = (new StringBuilder()).append(s).append(" ").append(LOG_TAG).append(" ").append(getSubLogTag()).toString();
            return;
        }
    }

    public void setHost(String s)
    {
        if (StringUtils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("The host must not be null.");
        } else
        {
            secureHost = s;
            nonSecureHost = s;
            return;
        }
    }

    public void setHttpMethod(HttpMethod httpmethod)
    {
        if (httpmethod == null)
        {
            throw new IllegalArgumentException("The httpMethod must not be null.");
        } else
        {
            httpMethod = httpmethod;
            return;
        }
    }

    public void setMetricsCollector(MetricsCollector metricscollector)
    {
        metricsCollector = metricscollector;
    }

    public void setPath(String s)
    {
        path = s;
    }

    public void setRequestBodyString(String s)
    {
        requestBody = s;
    }

    public void setServiceCallLatencyMetric(Metrics.MetricType metrictype)
    {
        serviceCallLatencyMetric = metrictype;
    }

    public void setUseSecure(boolean flag)
    {
        secure = flag;
    }

    public String toString()
    {
        return getUrl();
    }

    protected void writeMetricStart(Metrics.MetricType metrictype)
    {
        if (metrictype != null && metricsCollector != null)
        {
            metricsCollector.startMetric(metrictype);
        }
    }

    protected void writeMetricStop(Metrics.MetricType metrictype)
    {
        if (metrictype != null && metricsCollector != null)
        {
            metricsCollector.stopMetric(metrictype);
        }
    }


}
