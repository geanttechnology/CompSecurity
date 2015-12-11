// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web:
//            CollectionMap, UrlMaker, WebRequest, ServiceClient, 
//            HttpMethod, UrlEncodedFormContent, ServiceException, HttpHeader, 
//            CookieUtil, ServiceCallInterceptor, WebResponse, ServiceCallListener, 
//            ObjectParser, RequestContent

public abstract class ServiceCall
    implements Callable
{

    private final ServiceClient client;
    private volatile boolean closed;
    private RequestContent content;
    private CollectionMap cookies;
    private final String defaultMethod;
    private final String defaultPath;
    private CollectionMap headers;
    private String host;
    private final ServiceCallListener listener;
    private String method;
    private CollectionMap parameters;
    private String path;
    private int port;
    private UrlMaker requestUrl;
    private final Class resultClass;
    private String scheme;
    private Boolean secure;
    private String userAgent;
    private String userInfo;
    private volatile WebRequest webRequest;

    protected ServiceCall(ServiceClient serviceclient, ServiceCallListener servicecalllistener, String s, String s1, Class class1)
    {
        port = -1;
        parameters = new CollectionMap();
        cookies = new CollectionMap();
        headers = new CollectionMap();
        client = serviceclient;
        listener = servicecalllistener;
        defaultMethod = s;
        defaultPath = s1;
        resultClass = class1;
    }

    private void applyUrl(UrlMaker urlmaker)
    {
        if (scheme == null)
        {
            scheme = urlmaker.getScheme();
        }
        if (userInfo == null)
        {
            userInfo = urlmaker.getUserInfo();
        }
        if (host == null)
        {
            host = urlmaker.getHost();
        }
        if (port == -1)
        {
            port = urlmaker.getPort();
        }
        if (path == null)
        {
            path = urlmaker.getPath();
        }
        parameters.setDefault(urlmaker.getQuery());
    }

    private void applyUrl(String s)
        throws IOException
    {
        try
        {
            applyUrl(new UrlMaker(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IOException(s);
        }
    }

    public void abort()
    {
        this;
        JVM INSTR monitorenter ;
        if (!closed && webRequest != null)
        {
            webRequest.abort();
        }
        closed = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected String buildBaseUrl()
        throws IOException
    {
        if (secure != null)
        {
            if (secure.booleanValue())
            {
                return client.getSecureUrl();
            } else
            {
                return client.getInsecureUrl();
            }
        } else
        {
            return client.getBaseUrl();
        }
    }

    protected RequestContent buildContent()
    {
        if (!HttpMethod.POST.getName().equals(method))
        {
            return null;
        } else
        {
            return new UrlEncodedFormContent(parameters);
        }
    }

    protected void buildCookies(CollectionMap collectionmap)
    {
    }

    protected void buildHeaders(CollectionMap collectionmap)
    {
    }

    protected String buildHost()
    {
        return null;
    }

    protected String buildMethod()
    {
        return null;
    }

    protected void buildParameters(CollectionMap collectionmap)
        throws ServiceException
    {
    }

    protected String buildPath()
        throws ServiceException
    {
        return null;
    }

    protected int buildPort()
    {
        return -1;
    }

    public UrlMaker buildRequestUrl()
    {
        UrlMaker urlmaker = new UrlMaker();
        urlmaker.setScheme(scheme);
        urlmaker.setUserInfo(userInfo);
        urlmaker.setHost(host);
        urlmaker.setPort(port);
        urlmaker.setPath(path);
        if (!HttpMethod.POST.getName().equals(method))
        {
            urlmaker.setQuery(parameters);
        }
        return urlmaker;
    }

    protected String buildScheme()
    {
        return null;
    }

    protected void buildServiceCall()
        throws IOException
    {
        if (method == null)
        {
            method = buildMethod();
            if (method == null)
            {
                method = defaultMethod;
            }
        }
        Object obj = buildBaseUrl();
        if (obj != null)
        {
            applyUrl(((String) (obj)));
        }
        if (scheme == null)
        {
            scheme = buildScheme();
        }
        if (userInfo == null)
        {
            userInfo = buildUserInfo();
        }
        if (host == null)
        {
            host = buildHost();
        }
        if (port == -1)
        {
            port = buildPort();
        }
        if (path == null)
        {
            path = buildPath();
            if (path == null)
            {
                path = defaultPath;
            }
        }
        obj = new CollectionMap();
        buildParameters(((CollectionMap) (obj)));
        parameters = CollectionMap.merge(client.getParameters(), ((CollectionMap) (obj)), parameters);
        if (userAgent == null)
        {
            userAgent = buildUserAgent();
            if (userAgent == null)
            {
                userAgent = getClient().getUserAgent();
            }
        }
        obj = new CollectionMap();
        buildCookies(((CollectionMap) (obj)));
        cookies = CollectionMap.merge(client.getCookies(), ((CollectionMap) (obj)), cookies);
        obj = new CollectionMap();
        buildHeaders(((CollectionMap) (obj)));
        headers = CollectionMap.merge(client.getHeaders(), ((CollectionMap) (obj)), headers);
        content = buildContent();
    }

    protected String buildUserAgent()
    {
        return null;
    }

    protected String buildUserInfo()
    {
        return null;
    }

    protected WebRequest buildWebRequest()
        throws IOException
    {
        WebRequest webrequest = new WebRequest(client.getWebClient());
        webrequest.setMethod(method);
        requestUrl = buildRequestUrl();
        webrequest.setUrl(requestUrl.build());
        if (userAgent != null && !headers.containsKey(HttpHeader.USER_AGENT.getName()))
        {
            headers.set(HttpHeader.USER_AGENT.getName(), userAgent);
        }
        if (!cookies.isEmpty() && !headers.containsKey(HttpHeader.COOKIE.getName()))
        {
            headers.set(HttpHeader.COOKIE.getName(), CookieUtil.createRequestHeader(cookies));
        }
        webrequest.setHeaders(headers);
        webrequest.setContent(content);
        return webrequest;
    }

    public Object call()
        throws IOException
    {
        return execute();
    }

    public void disconnect()
    {
        this;
        JVM INSTR monitorenter ;
        if (!closed && webRequest != null)
        {
            webRequest.disconnect();
        }
        closed = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Object execute()
        throws IOException
    {
        onBeginRequest();
        this;
        JVM INSTR monitorenter ;
        if (!closed)
        {
            buildServiceCall();
            if (client.getServiceCallInterceptor() != null)
            {
                client.getServiceCallInterceptor().process(this);
            }
            webRequest = buildWebRequest();
        }
        this;
        JVM INSTR monitorexit ;
        Object obj;
        Object obj2;
        obj2 = null;
        obj = obj2;
        if (closed)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        obj = obj2;
        InputStream inputstream;
        if (webRequest == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        obj = webRequest.getResponse();
        inputstream = ((WebResponse) (obj)).getContent();
        obj2 = readResponse(((WebResponse) (obj)).getStatusCode(), ((WebResponse) (obj)).getStatusLine(), inputstream);
        onResult(obj2);
        obj = obj2;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        inputstream.close();
        obj = obj2;
        closed = true;
        onEndRequest();
        return obj;
        Object obj1;
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        if (!(obj1 instanceof IOException))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        obj1 = (IOException)obj1;
_L1:
        onRequestError(((Exception) (obj1)));
        throw obj1;
        obj1;
        closed = true;
        onEndRequest();
        throw obj1;
        obj1;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        inputstream.close();
        throw obj1;
        obj1 = new IOException(((Throwable) (obj1)));
          goto _L1
    }

    protected ServiceClient getClient()
    {
        return client;
    }

    public final CollectionMap getCookies()
    {
        return cookies;
    }

    protected String getDefaultMethod()
    {
        return defaultMethod;
    }

    protected String getDefaultPath()
    {
        return defaultPath;
    }

    public final CollectionMap getHeaders()
    {
        return headers;
    }

    public String getHost()
    {
        return host;
    }

    protected ServiceCallListener getListener()
    {
        return listener;
    }

    public final String getMethod()
    {
        return method;
    }

    public final CollectionMap getParameters()
    {
        return parameters;
    }

    public final String getPath()
    {
        return path;
    }

    public int getPort()
    {
        return port;
    }

    public final UrlMaker getRequestUrl()
    {
        return requestUrl;
    }

    protected final Class getResultClass()
    {
        return resultClass;
    }

    public String getScheme()
    {
        return scheme;
    }

    public final Boolean getSecure()
    {
        return secure;
    }

    public final String getUserAgent()
    {
        return userAgent;
    }

    public String getUserInfo()
    {
        return userInfo;
    }

    protected void onBeginRequest()
    {
        if (listener != null)
        {
            listener.startRequest();
        }
    }

    protected void onEndRequest()
    {
        if (listener != null)
        {
            listener.endRequest();
        }
    }

    protected void onRequestError(Exception exception)
    {
        if (listener != null)
        {
            listener.error(exception);
        }
    }

    protected void onResult(Object obj)
    {
        if (listener != null)
        {
            listener.result(obj);
        }
    }

    protected Object readResponse(int i, String s, InputStream inputstream)
        throws IOException
    {
        if (inputstream != null)
        {
            return client.getObjectParser().parse(inputstream, resultClass);
        } else
        {
            return null;
        }
    }

    public final void setCookies(CollectionMap collectionmap)
    {
        cookies = collectionmap;
    }

    public final void setHeaders(CollectionMap collectionmap)
    {
        headers = collectionmap;
    }

    public void setHost(String s)
    {
        host = s;
    }

    public final void setMethod(String s)
    {
        method = s;
    }

    public final void setParameters(CollectionMap collectionmap)
    {
        parameters = collectionmap;
    }

    public final void setPath(String s)
    {
        path = s;
    }

    public void setPort(int i)
    {
        port = i;
    }

    public void setScheme(String s)
    {
        scheme = s;
    }

    public void setSecure(Boolean boolean1)
    {
        secure = boolean1;
    }

    public final void setUserAgent(String s)
    {
        userAgent = s;
    }

    public void setUserInfo(String s)
    {
        userInfo = s;
    }
}
