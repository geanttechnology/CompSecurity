// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            Settings, DebugProperties, ThreadUtils, Utils, 
//            Log, MetricsCollector, HttpClientWebRequest, HttpURLConnectionWebRequest

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
            return (HttpMethod)Enum.valueOf(com/amazon/device/ads/WebRequest$HttpMethod, s);
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
            if (size() != 0 || !Utils.isNullOrEmpty(rawAppendage))
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

        String get(String s)
        {
            if (Utils.isNullOrWhiteSpace(s))
            {
                throw new IllegalArgumentException("The name must not be null or empty string.");
            } else
            {
                return (String)params.get(s);
            }
        }

        String putUnencoded(String s, String s1)
        {
            s = Utils.getURLEncodedString(s);
            putUrlEncoded(s, Utils.getURLEncodedString(s1));
            return s;
        }

        void putUrlEncoded(String s, String s1)
        {
            if (Utils.isNullOrWhiteSpace(s))
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

        void putUrlEncoded(String s, boolean flag)
        {
            putUrlEncoded(s, Boolean.toString(flag));
        }

        void putUrlEncodedIfNotNullOrEmpty(String s, String s1)
        {
            boolean flag;
            if (!Utils.isNullOrEmpty(s1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            putUrlEncodedIfTrue(s, s1, flag);
        }

        void putUrlEncodedIfTrue(String s, String s1, boolean flag)
        {
            if (flag)
            {
                putUrlEncoded(s, s1);
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

        private static final long serialVersionUID = 0xbae28aed93d1c9f4L;
        private final WebRequestStatus status;
        final WebRequest this$0;

        public WebRequestStatus getStatus()
        {
            return status;
        }

        protected WebRequestException(WebRequestStatus webrequeststatus, String s)
        {
            this(webrequeststatus, s, null);
        }

        protected WebRequestException(WebRequestStatus webrequeststatus, String s, Throwable throwable)
        {
            this$0 = WebRequest.this;
            super(s, throwable);
            status = webrequeststatus;
        }
    }

    static class WebRequestFactory
    {

        public WebRequest createWebRequest()
        {
            if (android.os.Build.VERSION.SDK_INT < 8)
            {
                return new HttpClientWebRequest();
            } else
            {
                return new HttpURLConnectionWebRequest();
            }
        }

        WebRequestFactory()
        {
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
            return (WebRequestStatus)Enum.valueOf(com/amazon/device/ads/WebRequest$WebRequestStatus, s);
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

        private String body;
        private String httpStatus;
        private int httpStatusCode;
        private InputStream inputStream;
        private boolean logEnabled;
        private String logTag;
        final WebRequest this$0;

        protected void enableLog(boolean flag)
        {
            logEnabled = flag;
        }

        public String getBody()
        {
            if (body == null)
            {
                readResponseString();
            }
            return body;
        }

        public String getHttpStatus()
        {
            return httpStatus;
        }

        public int getHttpStatusCode()
        {
            return httpStatusCode;
        }

        public JSONObject getJSONObjectBody()
        {
            if (getBody() == null)
            {
                return null;
            }
            JSONObject jsonobject;
            try
            {
                jsonobject = new JSONObject(getBody());
            }
            catch (JSONException jsonexception)
            {
                Log.e(getLogTag(), "Unable to parse the body into a JSONObject.");
                return null;
            }
            return jsonobject;
        }

        public boolean isHttpStatusCodeOK()
        {
            return getHttpStatusCode() == 200;
        }

        protected void readResponseString()
        {
            if (inputStream == null) goto _L2; else goto _L1
_L1:
            StringBuilder stringbuilder;
            byte abyte0[];
            stringbuilder = new StringBuilder();
            abyte0 = new byte[4096];
_L5:
            int i = inputStream.read(abyte0);
            if (i == -1) goto _L4; else goto _L3
_L3:
            stringbuilder.append(new String(abyte0, 0, i));
              goto _L5
            Object obj;
            obj;
            Log.e(logTag, "Unable to read the stream from the network.");
            try
            {
                inputStream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(logTag, "IOException while trying to close the stream");
            }
            setBody(stringbuilder.toString());
            if (logEnabled)
            {
                Log.d(WebRequest.LOG_TAG, "Response: %s", new Object[] {
                    getBody()
                });
            }
_L2:
            return;
_L4:
            try
            {
                inputStream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(logTag, "IOException while trying to close the stream");
            }
            setBody(stringbuilder.toString());
            if (!logEnabled) goto _L2; else goto _L6
_L6:
            Log.d(WebRequest.LOG_TAG, "Response: %s", new Object[] {
                getBody()
            });
            return;
            obj;
            try
            {
                inputStream.close();
            }
            catch (IOException ioexception)
            {
                Log.e(logTag, "IOException while trying to close the stream");
            }
            setBody(stringbuilder.toString());
            if (logEnabled)
            {
                Log.d(WebRequest.LOG_TAG, "Response: %s", new Object[] {
                    getBody()
                });
            }
            throw obj;
        }

        protected void setBody(String s)
        {
            body = s;
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
            inputStream = inputstream;
        }

        protected void setLogTag(String s)
        {
            logTag = s;
        }

        protected WebResponse()
        {
            this$0 = WebRequest.this;
            super();
            logTag = WebRequest.LOG_TAG;
        }
    }


    private static final String CHARSET_KEY = "charset";
    public static final String CHARSET_UTF_16 = "UTF-16";
    public static final String CHARSET_UTF_8 = "UTF-8";
    public static final String CONTENT_TYPE_CSS = "text/css";
    public static final String CONTENT_TYPE_HTML = "text/html";
    public static final String CONTENT_TYPE_JAVASCRIPT = "application/javascript";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_PLAIN_TEXT = "text/plain";
    public static final int DEFAULT_PORT = -1;
    public static final int DEFAULT_TIMEOUT = 20000;
    private static final String HEADER_ACCEPT_KEY = "Accept";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String LOG_TAG = com/amazon/device/ads/WebRequest.getSimpleName();
    private static WebRequestFactory webRequestFactory = new WebRequestFactory();
    String acceptContentType;
    String charset;
    String contentType;
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

    protected WebRequest()
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
        secure = DebugProperties.getDebugPropertyAsBoolean("debug.tlsEnabled", Settings.getInstance().getBoolean("tlsEnabled", false));
    }

    public static final WebRequest createJSONGetWebRequest()
    {
        WebRequest webrequest = createNewWebRequest();
        webrequest.setHttpMethod(HttpMethod.GET);
        webrequest.putHeader("Accept", "application/json");
        return webrequest;
    }

    public static final WebRequest createJSONPostWebRequest()
    {
        WebRequest webrequest = createNewWebRequest();
        webrequest.convertToJSONPostRequest();
        return webrequest;
    }

    public static final WebRequest createNewWebRequest()
    {
        return webRequestFactory.createWebRequest();
    }

    public static final void executeWebRequestInThread(String s)
    {
        ThreadUtils.executeRunnable(new Runnable(s) {

            final String val$url;

            public void run()
            {
                WebRequest webrequest = WebRequest.createNewWebRequest();
                webrequest.enableLog(true);
                webrequest.setUrlString(url);
                try
                {
                    webrequest.makeCall();
                    return;
                }
                catch (WebRequestException webrequestexception)
                {
                    return;
                }
            }

            
            {
                url = s;
                super();
            }
        });
    }

    static void setWebRequestFactory(WebRequestFactory webrequestfactory)
    {
        webRequestFactory = webrequestfactory;
    }

    protected void appendQuery(StringBuilder stringbuilder)
    {
        queryStringParameters.append(stringbuilder);
    }

    public void convertToJSONPostRequest()
    {
        setHttpMethod(HttpMethod.POST);
        putHeader("Accept", "application/json");
        putHeader("Content-Type", "application/json; charset=UTF-8");
    }

    protected URI createURI(String s)
        throws MalformedURLException, URISyntaxException
    {
        return createURI(createURL(s));
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

    protected URI createUri()
        throws URISyntaxException, MalformedURLException
    {
        return (new URL(getUrlString())).toURI();
    }

    protected abstract WebResponse doHttpNetworkCall(URL url)
        throws WebRequestException;

    public void enableLog(boolean flag)
    {
        enableLogUrl(flag);
        enableLogRequestBody(flag);
        enableLogResponse(flag);
    }

    public void enableLogRequestBody(boolean flag)
    {
        logRequestBodyEnabled = flag;
    }

    public void enableLogResponse(boolean flag)
    {
        logResponseEnabled = flag;
    }

    public void enableLogUrl(boolean flag)
    {
        logUrlEnabled = flag;
    }

    public String getAcceptContentType()
    {
        return acceptContentType;
    }

    public String getCharset()
    {
        return charset;
    }

    public String getContentType()
    {
        return contentType;
    }

    public String getHeader(String s)
    {
        if (Utils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        } else
        {
            return (String)headers.get(s);
        }
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

    public String getPostParameter(String s)
    {
        if (Utils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        } else
        {
            return (String)postParameters.get(s);
        }
    }

    public String getQueryParameter(String s)
    {
        return queryStringParameters.get(s);
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

    public String getUrlString()
    {
        return urlString;
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
            Log.e(logTag, "The network request should not be performed on the main thread.");
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
            throw new WebRequestException(WebRequestStatus.MALFORMED_URL, (new StringBuilder()).append("Could not construct URL from String ").append(((String) (obj))).toString(), malformedurlexception);
        }
        writeMetricStart(serviceCallLatencyMetric);
        obj = doHttpNetworkCall(url);
        writeMetricStop(serviceCallLatencyMetric);
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
        if (Utils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        } else
        {
            headers.put(s, s1);
            return;
        }
    }

    public void putPostParameter(String s, String s1)
    {
        if (Utils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        if (s1 == null)
        {
            postParameters.remove(s);
            return;
        } else
        {
            postParameters.put(s, s1);
            return;
        }
    }

    public String putUnencodedQueryParameter(String s, String s1)
    {
        return queryStringParameters.putUnencoded(s, s1);
    }

    public void putUrlEncodedQueryParameter(String s, String s1)
    {
        queryStringParameters.putUrlEncoded(s, s1);
    }

    public void setAcceptContentType(String s)
    {
        acceptContentType = contentType;
    }

    public void setAdditionalQueryParamsString(String s)
    {
        queryStringParameters.setRawAppendage(s);
    }

    public void setCharset(String s)
    {
        charset = s;
    }

    public void setContentType(String s)
    {
        contentType = s;
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
        if (Utils.isNullOrWhiteSpace(s))
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

    public void setNonSecureHost(String s)
    {
        if (Utils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("The host must not be null.");
        } else
        {
            nonSecureHost = s;
            return;
        }
    }

    public void setPath(String s)
    {
        path = s;
    }

    public void setPort(int i)
    {
        port = i;
    }

    public void setQueryStringParameters(QueryStringParameters querystringparameters)
    {
        queryStringParameters = querystringparameters;
    }

    public void setRequestBodyString(String s)
    {
        requestBody = s;
    }

    public void setSecureHost(String s)
    {
        if (Utils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("The host must not be null.");
        } else
        {
            secureHost = s;
            return;
        }
    }

    public void setServiceCallLatencyMetric(Metrics.MetricType metrictype)
    {
        serviceCallLatencyMetric = metrictype;
    }

    public void setTimeout(int i)
    {
        timeout = i;
    }

    public void setUrlString(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (secure)
            {
                s1 = s;
                if (s.startsWith("http:"))
                {
                    s1 = s.replaceFirst("http", "https");
                }
            }
        }
        urlString = s1;
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
