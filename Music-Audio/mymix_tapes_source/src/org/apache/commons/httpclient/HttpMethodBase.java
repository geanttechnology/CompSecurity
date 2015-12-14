// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collection;
import org.apache.commons.httpclient.auth.AuthState;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.cookie.CookieVersionSupport;
import org.apache.commons.httpclient.cookie.MalformedCookieException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.httpclient.util.ExceptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpMethod, HeaderGroup, URIException, URI, 
//            HttpException, ProtocolException, HttpConnection, HttpState, 
//            HttpVersion, Wire, WireLogInputStream, StatusLine, 
//            Header, HeaderElement, ChunkedInputStream, AutoCloseInputStream, 
//            ContentLengthInputStream, Cookie, NameValuePair, HostConfiguration, 
//            HttpContentTooLargeException, HttpHost, HttpParser, NoHttpResponseException, 
//            MethodRetryHandler

public abstract class HttpMethodBase
    implements HttpMethod
{

    private static final int DEFAULT_INITIAL_BUFFER_SIZE = 4096;
    private static final Log LOG;
    private static final int RESPONSE_WAIT_TIME_MS = 3000;
    static Class class$org$apache$commons$httpclient$HttpMethodBase;
    private volatile boolean aborted;
    private boolean connectionCloseForced;
    private CookieSpec cookiespec;
    private boolean doAuthentication;
    protected HttpVersion effectiveVersion;
    private boolean followRedirects;
    private AuthState hostAuthState;
    private HttpHost httphost;
    private MethodRetryHandler methodRetryHandler;
    private HttpMethodParams params;
    private String path;
    private AuthState proxyAuthState;
    private String queryString;
    private int recoverableExceptionCount;
    private HeaderGroup requestHeaders;
    private boolean requestSent;
    private byte responseBody[];
    private HttpConnection responseConnection;
    private HeaderGroup responseHeaders;
    private InputStream responseStream;
    private HeaderGroup responseTrailerHeaders;
    protected StatusLine statusLine;
    private boolean used;

    public HttpMethodBase()
    {
        requestHeaders = new HeaderGroup();
        statusLine = null;
        responseHeaders = new HeaderGroup();
        responseTrailerHeaders = new HeaderGroup();
        path = null;
        queryString = null;
        responseStream = null;
        responseConnection = null;
        responseBody = null;
        followRedirects = false;
        doAuthentication = true;
        params = new HttpMethodParams();
        hostAuthState = new AuthState();
        proxyAuthState = new AuthState();
        used = false;
        recoverableExceptionCount = 0;
        httphost = null;
        connectionCloseForced = false;
        effectiveVersion = null;
        aborted = false;
        requestSent = false;
        cookiespec = null;
    }

    public HttpMethodBase(String s)
        throws IllegalArgumentException, IllegalStateException
    {
        requestHeaders = new HeaderGroup();
        statusLine = null;
        responseHeaders = new HeaderGroup();
        responseTrailerHeaders = new HeaderGroup();
        path = null;
        queryString = null;
        responseStream = null;
        responseConnection = null;
        responseBody = null;
        followRedirects = false;
        doAuthentication = true;
        params = new HttpMethodParams();
        hostAuthState = new AuthState();
        proxyAuthState = new AuthState();
        used = false;
        recoverableExceptionCount = 0;
        httphost = null;
        connectionCloseForced = false;
        effectiveVersion = null;
        aborted = false;
        requestSent = false;
        cookiespec = null;
        if (s == null) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        s1 = s;
        s2 = s;
        if (!s.equals("")) goto _L3; else goto _L2
_L3:
        s2 = s1;
        try
        {
            setURI(new URI(s1, true, getParams().getUriCharset()));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException("Invalid uri '" + s2 + "': " + s.getMessage());
        }
_L2:
        s1 = "/";
        if (true) goto _L3; else goto _L4
_L4:
    }

    private static boolean canResponseHaveBody(int i)
    {
        LOG.trace("enter HttpMethodBase.canResponseHaveBody(int)");
        boolean flag = true;
        if (i >= 100 && i <= 199 || i == 204 || i == 304)
        {
            flag = false;
        }
        return flag;
    }

    private void checkExecuteConditions(HttpState httpstate, HttpConnection httpconnection)
        throws HttpException
    {
        if (httpstate == null)
        {
            throw new IllegalArgumentException("HttpState parameter may not be null");
        }
        if (httpconnection == null)
        {
            throw new IllegalArgumentException("HttpConnection parameter may not be null");
        }
        if (aborted)
        {
            throw new IllegalStateException("Method has been aborted");
        }
        if (!validate())
        {
            throw new ProtocolException("HttpMethodBase object not valid");
        } else
        {
            return;
        }
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    private void ensureConnectionRelease()
    {
        if (responseConnection != null)
        {
            responseConnection.releaseConnection();
            responseConnection = null;
        }
    }

    protected static String generateRequestLine(HttpConnection httpconnection, String s, String s1, String s2, String s3)
    {
        LOG.trace("enter HttpMethodBase.generateRequestLine(HttpConnection, String, String, String, String)");
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(s);
        stringbuffer.append(" ");
        if (!httpconnection.isTransparent())
        {
            s = httpconnection.getProtocol();
            stringbuffer.append(s.getScheme().toLowerCase());
            stringbuffer.append("://");
            stringbuffer.append(httpconnection.getHost());
            if (httpconnection.getPort() != -1 && httpconnection.getPort() != s.getDefaultPort())
            {
                stringbuffer.append(":");
                stringbuffer.append(httpconnection.getPort());
            }
        }
        if (s1 == null)
        {
            stringbuffer.append("/");
        } else
        {
            if (!httpconnection.isTransparent() && !s1.startsWith("/"))
            {
                stringbuffer.append("/");
            }
            stringbuffer.append(s1);
        }
        if (s2 != null)
        {
            if (s2.indexOf("?") != 0)
            {
                stringbuffer.append("?");
            }
            stringbuffer.append(s2);
        }
        stringbuffer.append(" ");
        stringbuffer.append(s3);
        stringbuffer.append("\r\n");
        return stringbuffer.toString();
    }

    private CookieSpec getCookieSpec(HttpState httpstate)
    {
        if (cookiespec == null)
        {
            int i = httpstate.getCookiePolicy();
            if (i == -1)
            {
                cookiespec = CookiePolicy.getCookieSpec(params.getCookiePolicy());
            } else
            {
                cookiespec = CookiePolicy.getSpecByPolicy(i);
            }
            cookiespec.setValidDateFormats((Collection)params.getParameter("http.dateparser.patterns"));
        }
        return cookiespec;
    }

    private String getRequestLine(HttpConnection httpconnection)
    {
        return generateRequestLine(httpconnection, getName(), getPath(), getQueryString(), effectiveVersion.toString());
    }

    private InputStream readResponseBody(HttpConnection httpconnection)
        throws HttpException, IOException
    {
        LOG.trace("enter HttpMethodBase.readResponseBody(HttpConnection)");
        responseBody = null;
        InputStream inputstream = httpconnection.getResponseInputStream();
        Object obj = inputstream;
        if (Wire.CONTENT_WIRE.enabled())
        {
            obj = new WireLogInputStream(inputstream, Wire.CONTENT_WIRE);
        }
        boolean flag = canResponseHaveBody(statusLine.getStatusCode());
        inputstream = null;
        Header header1 = responseHeaders.getFirstHeader("Transfer-Encoding");
        if (header1 != null)
        {
            String s = header1.getValue();
            if (!"chunked".equalsIgnoreCase(s) && !"identity".equalsIgnoreCase(s) && LOG.isWarnEnabled())
            {
                LOG.warn("Unsupported transfer encoding: " + s);
            }
            HeaderElement aheaderelement[] = header1.getElements();
            int i = aheaderelement.length;
            if (i > 0 && "chunked".equalsIgnoreCase(aheaderelement[i - 1].getName()))
            {
                if (httpconnection.isResponseAvailable(httpconnection.getParams().getSoTimeout()))
                {
                    httpconnection = new ChunkedInputStream(((InputStream) (obj)), this);
                } else
                {
                    if (getParams().isParameterTrue("http.protocol.strict-transfer-encoding"))
                    {
                        throw new ProtocolException("Chunk-encoded body declared but not sent");
                    }
                    LOG.warn("Chunk-encoded body missing");
                    httpconnection = inputstream;
                }
            } else
            {
                LOG.info("Response content is not chunk-encoded");
                setConnectionCloseForced(true);
                httpconnection = ((HttpConnection) (obj));
            }
        } else
        {
            long l = getResponseContentLength();
            if (l == -1L)
            {
                if (flag && effectiveVersion.greaterEquals(HttpVersion.HTTP_1_1))
                {
                    Header header = responseHeaders.getFirstHeader("Connection");
                    httpconnection = null;
                    if (header != null)
                    {
                        httpconnection = header.getValue();
                    }
                    if (!"close".equalsIgnoreCase(httpconnection))
                    {
                        LOG.info("Response content length is not known");
                        setConnectionCloseForced(true);
                    }
                }
                httpconnection = ((HttpConnection) (obj));
            } else
            {
                httpconnection = new ContentLengthInputStream(((InputStream) (obj)), l);
            }
        }
        if (!flag)
        {
            httpconnection = null;
        }
        if (httpconnection != null)
        {
            return new AutoCloseInputStream(httpconnection, new _cls1());
        } else
        {
            return httpconnection;
        }
    }

    private boolean responseAvailable()
    {
        return responseBody != null || responseStream != null;
    }

    public void abort()
    {
        if (!aborted)
        {
            aborted = true;
            HttpConnection httpconnection = responseConnection;
            if (httpconnection != null)
            {
                httpconnection.close();
                return;
            }
        }
    }

    protected void addCookieRequestHeader(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.addCookieRequestHeader(HttpState, HttpConnection)");
        Header aheader[] = getRequestHeaderGroup().getHeaders("Cookie");
        for (int i = 0; i < aheader.length; i++)
        {
            Header header = aheader[i];
            if (header.isAutogenerated())
            {
                getRequestHeaderGroup().removeHeader(header);
            }
        }

        CookieSpec cookiespec1 = getCookieSpec(httpstate);
        String s1 = params.getVirtualHost();
        String s = s1;
        if (s1 == null)
        {
            s = httpconnection.getHost();
        }
        httpstate = cookiespec1.match(s, httpconnection.getPort(), getPath(), httpconnection.isSecure(), httpstate.getCookies());
        if (httpstate != null && httpstate.length > 0)
        {
            if (getParams().isParameterTrue("http.protocol.single-cookie-header"))
            {
                httpconnection = cookiespec1.formatCookies(httpstate);
                getRequestHeaderGroup().addHeader(new Header("Cookie", httpconnection, true));
            } else
            {
                int k = 0;
                while (k < httpstate.length) 
                {
                    httpconnection = cookiespec1.formatCookie(httpstate[k]);
                    getRequestHeaderGroup().addHeader(new Header("Cookie", httpconnection, true));
                    k++;
                }
            }
            if (cookiespec1 instanceof CookieVersionSupport)
            {
                httpconnection = (CookieVersionSupport)cookiespec1;
                int l = httpconnection.getVersion();
                boolean flag = false;
                for (int j = 0; j < httpstate.length; j++)
                {
                    if (l != httpstate[j].getVersion())
                    {
                        flag = true;
                    }
                }

                if (flag)
                {
                    getRequestHeaderGroup().addHeader(httpconnection.getVersionHeader());
                }
            }
        }
    }

    protected void addHostRequestHeader(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.addHostRequestHeader(HttpState, HttpConnection)");
        httpstate = params.getVirtualHost();
        Object obj;
        int i;
        if (httpstate != null)
        {
            LOG.debug("Using virtual host name: " + httpstate);
        } else
        {
            httpstate = httpconnection.getHost();
        }
        i = httpconnection.getPort();
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Adding Host request header");
        }
        obj = httpstate;
        if (httpconnection.getProtocol().getDefaultPort() != i)
        {
            obj = httpstate + ":" + i;
        }
        setRequestHeader("Host", ((String) (obj)));
    }

    protected void addProxyConnectionHeader(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.addProxyConnectionHeader(HttpState, HttpConnection)");
        if (!httpconnection.isTransparent() && getRequestHeader("Proxy-Connection") == null)
        {
            addRequestHeader("Proxy-Connection", "Keep-Alive");
        }
    }

    public void addRequestHeader(String s, String s1)
    {
        addRequestHeader(new Header(s, s1));
    }

    public void addRequestHeader(Header header)
    {
        LOG.trace("HttpMethodBase.addRequestHeader(Header)");
        if (header == null)
        {
            LOG.debug("null header value ignored");
            return;
        } else
        {
            getRequestHeaderGroup().addHeader(header);
            return;
        }
    }

    protected void addRequestHeaders(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.addRequestHeaders(HttpState, HttpConnection)");
        addUserAgentRequestHeader(httpstate, httpconnection);
        addHostRequestHeader(httpstate, httpconnection);
        addCookieRequestHeader(httpstate, httpconnection);
        addProxyConnectionHeader(httpstate, httpconnection);
    }

    public void addResponseFooter(Header header)
    {
        getResponseTrailerHeaderGroup().addHeader(header);
    }

    protected void addUserAgentRequestHeader(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.addUserAgentRequestHeaders(HttpState, HttpConnection)");
        if (getRequestHeader("User-Agent") == null)
        {
            httpconnection = (String)getParams().getParameter("http.useragent");
            httpstate = httpconnection;
            if (httpconnection == null)
            {
                httpstate = "Jakarta Commons-HttpClient";
            }
            setRequestHeader("User-Agent", httpstate);
        }
    }

    protected void checkNotUsed()
        throws IllegalStateException
    {
        if (used)
        {
            throw new IllegalStateException("Already used.");
        } else
        {
            return;
        }
    }

    protected void checkUsed()
        throws IllegalStateException
    {
        if (!used)
        {
            throw new IllegalStateException("Not Used.");
        } else
        {
            return;
        }
    }

    public int execute(HttpState httpstate, HttpConnection httpconnection)
        throws HttpException, IOException
    {
        LOG.trace("enter HttpMethodBase.execute(HttpState, HttpConnection)");
        responseConnection = httpconnection;
        checkExecuteConditions(httpstate, httpconnection);
        statusLine = null;
        connectionCloseForced = false;
        httpconnection.setLastResponseInputStream(null);
        if (effectiveVersion == null)
        {
            effectiveVersion = params.getVersion();
        }
        writeRequest(httpstate, httpconnection);
        requestSent = true;
        readResponse(httpstate, httpconnection);
        used = true;
        return statusLine.getStatusCode();
    }

    void fakeResponse(StatusLine statusline, HeaderGroup headergroup, InputStream inputstream)
    {
        used = true;
        statusLine = statusline;
        responseHeaders = headergroup;
        responseBody = null;
        responseStream = inputstream;
    }

    public String getAuthenticationRealm()
    {
        return hostAuthState.getRealm();
    }

    protected String getContentCharSet(Header header)
    {
        LOG.trace("enter getContentCharSet( Header contentheader )");
        Object obj = null;
        String s = obj;
        if (header != null)
        {
            header = header.getElements();
            s = obj;
            if (header.length == 1)
            {
                header = header[0].getParameterByName("charset");
                s = obj;
                if (header != null)
                {
                    s = header.getValue();
                }
            }
        }
        header = s;
        if (s == null)
        {
            String s1 = getParams().getContentCharset();
            header = s1;
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Default charset used: " + s1);
                header = s1;
            }
        }
        return header;
    }

    public boolean getDoAuthentication()
    {
        return doAuthentication;
    }

    public HttpVersion getEffectiveVersion()
    {
        return effectiveVersion;
    }

    public boolean getFollowRedirects()
    {
        return followRedirects;
    }

    public AuthState getHostAuthState()
    {
        return hostAuthState;
    }

    public HostConfiguration getHostConfiguration()
    {
        HostConfiguration hostconfiguration = new HostConfiguration();
        hostconfiguration.setHost(httphost);
        return hostconfiguration;
    }

    public MethodRetryHandler getMethodRetryHandler()
    {
        return methodRetryHandler;
    }

    public abstract String getName();

    public HttpMethodParams getParams()
    {
        return params;
    }

    public String getPath()
    {
        if (path == null || path.equals(""))
        {
            return "/";
        } else
        {
            return path;
        }
    }

    public AuthState getProxyAuthState()
    {
        return proxyAuthState;
    }

    public String getProxyAuthenticationRealm()
    {
        return proxyAuthState.getRealm();
    }

    public String getQueryString()
    {
        return queryString;
    }

    public int getRecoverableExceptionCount()
    {
        return recoverableExceptionCount;
    }

    public String getRequestCharSet()
    {
        return getContentCharSet(getRequestHeader("Content-Type"));
    }

    public Header getRequestHeader(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return getRequestHeaderGroup().getCondensedHeader(s);
        }
    }

    protected HeaderGroup getRequestHeaderGroup()
    {
        return requestHeaders;
    }

    public Header[] getRequestHeaders()
    {
        return getRequestHeaderGroup().getAllHeaders();
    }

    public Header[] getRequestHeaders(String s)
    {
        return getRequestHeaderGroup().getHeaders(s);
    }

    public byte[] getResponseBody()
        throws IOException
    {
        if (responseBody == null)
        {
            InputStream inputstream = getResponseBodyAsStream();
            if (inputstream != null)
            {
                long l = getResponseContentLength();
                if (l > 0x7fffffffL)
                {
                    throw new IOException("Content too large to be buffered: " + l + " bytes");
                }
                int i = getParams().getIntParameter("http.method.response.buffer.warnlimit", 0x100000);
                if (l == -1L || l > (long)i)
                {
                    LOG.warn("Going to buffer response body of large or unknown size. Using getResponseBodyAsStream instead is recommended.");
                }
                LOG.debug("Buffering response body");
                ByteArrayOutputStream bytearrayoutputstream;
                byte abyte0[];
                if (l > 0L)
                {
                    i = (int)l;
                } else
                {
                    i = 4096;
                }
                bytearrayoutputstream = new ByteArrayOutputStream(i);
                abyte0 = new byte[4096];
                do
                {
                    i = inputstream.read(abyte0);
                    if (i <= 0)
                    {
                        break;
                    }
                    bytearrayoutputstream.write(abyte0, 0, i);
                } while (true);
                bytearrayoutputstream.close();
                setResponseStream(null);
                responseBody = bytearrayoutputstream.toByteArray();
            }
        }
        return responseBody;
    }

    public byte[] getResponseBody(int i)
        throws IOException
    {
label0:
        {
            if (i < 0)
            {
                throw new IllegalArgumentException("maxlen must be positive");
            }
            if (responseBody != null)
            {
                break label0;
            }
            InputStream inputstream = getResponseBodyAsStream();
            if (inputstream == null)
            {
                break label0;
            }
            long l = getResponseContentLength();
            if (l != -1L && l > (long)i)
            {
                throw new HttpContentTooLargeException("Content-Length is " + l, i);
            }
            LOG.debug("Buffering response body");
            ByteArrayOutputStream bytearrayoutputstream;
            byte abyte0[];
            int j;
            if (l > 0L)
            {
                j = (int)l;
            } else
            {
                j = 4096;
            }
            bytearrayoutputstream = new ByteArrayOutputStream(j);
            abyte0 = new byte[2048];
            j = 0;
            do
            {
                int k = inputstream.read(abyte0, 0, Math.min(abyte0.length, i - j));
                if (k != -1)
                {
                    bytearrayoutputstream.write(abyte0, 0, k);
                    k = j + k;
                    j = k;
                    if (k < i)
                    {
                        continue;
                    }
                    j = k;
                }
                setResponseStream(null);
                if (j == i && inputstream.read() != -1)
                {
                    throw new HttpContentTooLargeException("Content-Length not known but larger than " + i, i);
                }
                break;
            } while (true);
            responseBody = bytearrayoutputstream.toByteArray();
        }
        return responseBody;
    }

    public InputStream getResponseBodyAsStream()
        throws IOException
    {
        if (responseStream != null)
        {
            return responseStream;
        }
        if (responseBody != null)
        {
            ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(responseBody);
            LOG.debug("re-creating response stream from byte array");
            return bytearrayinputstream;
        } else
        {
            return null;
        }
    }

    public String getResponseBodyAsString()
        throws IOException
    {
        byte abyte0[] = null;
        if (responseAvailable())
        {
            abyte0 = getResponseBody();
        }
        if (abyte0 != null)
        {
            return EncodingUtil.getString(abyte0, getResponseCharSet());
        } else
        {
            return null;
        }
    }

    public String getResponseBodyAsString(int i)
        throws IOException
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("maxlen must be positive");
        }
        byte abyte0[] = null;
        if (responseAvailable())
        {
            abyte0 = getResponseBody(i);
        }
        if (abyte0 != null)
        {
            return EncodingUtil.getString(abyte0, getResponseCharSet());
        } else
        {
            return null;
        }
    }

    public String getResponseCharSet()
    {
        return getContentCharSet(getResponseHeader("Content-Type"));
    }

    public long getResponseContentLength()
    {
        Header aheader[] = getResponseHeaderGroup().getHeaders("Content-Length");
        if (aheader.length != 0) goto _L2; else goto _L1
_L1:
        return -1L;
_L2:
        int i;
        if (aheader.length > 1)
        {
            LOG.warn("Multiple content-length headers detected");
        }
        i = aheader.length - 1;
_L4:
        Header header;
        if (i < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        header = aheader[i];
        long l = Long.parseLong(header.getValue());
        return l;
        NumberFormatException numberformatexception;
        numberformatexception;
        if (LOG.isWarnEnabled())
        {
            LOG.warn("Invalid content-length value: " + numberformatexception.getMessage());
        }
        i--;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
    }

    public Header getResponseFooter(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return getResponseTrailerHeaderGroup().getCondensedHeader(s);
        }
    }

    public Header[] getResponseFooters()
    {
        return getResponseTrailerHeaderGroup().getAllHeaders();
    }

    public Header getResponseHeader(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return getResponseHeaderGroup().getCondensedHeader(s);
        }
    }

    protected HeaderGroup getResponseHeaderGroup()
    {
        return responseHeaders;
    }

    public Header[] getResponseHeaders()
    {
        return getResponseHeaderGroup().getAllHeaders();
    }

    public Header[] getResponseHeaders(String s)
    {
        return getResponseHeaderGroup().getHeaders(s);
    }

    protected InputStream getResponseStream()
    {
        return responseStream;
    }

    protected HeaderGroup getResponseTrailerHeaderGroup()
    {
        return responseTrailerHeaders;
    }

    public int getStatusCode()
    {
        return statusLine.getStatusCode();
    }

    public StatusLine getStatusLine()
    {
        return statusLine;
    }

    public String getStatusText()
    {
        return statusLine.getReasonPhrase();
    }

    public URI getURI()
        throws URIException
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (httphost != null)
        {
            stringbuffer.append(httphost.getProtocol().getScheme());
            stringbuffer.append("://");
            stringbuffer.append(httphost.getHostName());
            int i = httphost.getPort();
            if (i != -1 && i != httphost.getProtocol().getDefaultPort())
            {
                stringbuffer.append(":");
                stringbuffer.append(i);
            }
        }
        stringbuffer.append(path);
        if (queryString != null)
        {
            stringbuffer.append('?');
            stringbuffer.append(queryString);
        }
        String s = getParams().getUriCharset();
        return new URI(stringbuffer.toString(), true, s);
    }

    public boolean hasBeenUsed()
    {
        return used;
    }

    public boolean isAborted()
    {
        return aborted;
    }

    protected boolean isConnectionCloseForced()
    {
        return connectionCloseForced;
    }

    public boolean isHttp11()
    {
        return params.getVersion().equals(HttpVersion.HTTP_1_1);
    }

    public boolean isRequestSent()
    {
        return requestSent;
    }

    public boolean isStrictMode()
    {
        return false;
    }

    protected void processCookieHeaders(CookieSpec cookiespec1, Header aheader[], HttpState httpstate, HttpConnection httpconnection)
    {
        LOG.trace("enter HttpMethodBase.processCookieHeaders(Header[], HttpState, HttpConnection)");
        String s1 = params.getVirtualHost();
        String s = s1;
        if (s1 == null)
        {
            s = httpconnection.getHost();
        }
label0:
        for (int i = 0; i < aheader.length; i++)
        {
            Header header = aheader[i];
            Cookie cookie = null;
            Object obj;
            int j;
            try
            {
                obj = cookiespec1.parse(s, httpconnection.getPort(), getPath(), httpconnection.isSecure(), header);
            }
            catch (MalformedCookieException malformedcookieexception1)
            {
                obj = cookie;
                if (LOG.isWarnEnabled())
                {
                    LOG.warn("Invalid cookie header: \"" + header.getValue() + "\". " + malformedcookieexception1.getMessage());
                    obj = cookie;
                }
            }
            if (obj == null)
            {
                continue;
            }
            j = 0;
            do
            {
                if (j >= obj.length)
                {
                    continue label0;
                }
                cookie = obj[j];
                try
                {
                    cookiespec1.validate(s, httpconnection.getPort(), getPath(), httpconnection.isSecure(), cookie);
                    httpstate.addCookie(cookie);
                    if (LOG.isDebugEnabled())
                    {
                        LOG.debug("Cookie accepted: \"" + cookiespec1.formatCookie(cookie) + "\"");
                    }
                }
                catch (MalformedCookieException malformedcookieexception)
                {
                    if (LOG.isWarnEnabled())
                    {
                        LOG.warn("Cookie rejected: \"" + cookiespec1.formatCookie(cookie) + "\". " + malformedcookieexception.getMessage());
                    }
                }
                j++;
            } while (true);
        }

    }

    protected void processResponseBody(HttpState httpstate, HttpConnection httpconnection)
    {
    }

    protected void processResponseHeaders(HttpState httpstate, HttpConnection httpconnection)
    {
        LOG.trace("enter HttpMethodBase.processResponseHeaders(HttpState, HttpConnection)");
        CookieSpec cookiespec1 = getCookieSpec(httpstate);
        processCookieHeaders(cookiespec1, getResponseHeaderGroup().getHeaders("set-cookie"), httpstate, httpconnection);
        if ((cookiespec1 instanceof CookieVersionSupport) && ((CookieVersionSupport)cookiespec1).getVersion() > 0)
        {
            processCookieHeaders(cookiespec1, getResponseHeaderGroup().getHeaders("set-cookie2"), httpstate, httpconnection);
        }
    }

    protected void processStatusLine(HttpState httpstate, HttpConnection httpconnection)
    {
    }

    protected void readResponse(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.readResponse(HttpState, HttpConnection)");
        do
        {
            if (statusLine != null)
            {
                break;
            }
            readStatusLine(httpstate, httpconnection);
            processStatusLine(httpstate, httpconnection);
            readResponseHeaders(httpstate, httpconnection);
            processResponseHeaders(httpstate, httpconnection);
            int i = statusLine.getStatusCode();
            if (i >= 100 && i < 200)
            {
                if (LOG.isInfoEnabled())
                {
                    LOG.info("Discarding unexpected response: " + statusLine.toString());
                }
                statusLine = null;
            }
        } while (true);
        readResponseBody(httpstate, httpconnection);
        processResponseBody(httpstate, httpconnection);
    }

    protected void readResponseBody(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.readResponseBody(HttpState, HttpConnection)");
        httpstate = readResponseBody(httpconnection);
        if (httpstate == null)
        {
            responseBodyConsumed();
            return;
        } else
        {
            httpconnection.setLastResponseInputStream(httpstate);
            setResponseStream(httpstate);
            return;
        }
    }

    protected void readResponseHeaders(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.readResponseHeaders(HttpState,HttpConnection)");
        getResponseHeaderGroup().clear();
        httpstate = HttpParser.parseHeaders(httpconnection.getResponseInputStream(), getParams().getHttpElementCharset());
        getResponseHeaderGroup().setHeaders(httpstate);
    }

    protected void readStatusLine(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.readStatusLine(HttpState, HttpConnection)");
        int j = getParams().getIntParameter("http.protocol.status-line-garbage-limit", 0x7fffffff);
        int i = 0;
        do
        {
            httpstate = httpconnection.readLine(getParams().getHttpElementCharset());
            if (httpstate == null && i == 0)
            {
                throw new NoHttpResponseException("The server " + httpconnection.getHost() + " failed to respond");
            }
            if (Wire.HEADER_WIRE.enabled())
            {
                Wire.HEADER_WIRE.input(httpstate + "\r\n");
            }
            if (httpstate != null && StatusLine.startsWithHTTP(httpstate))
            {
                statusLine = new StatusLine(httpstate);
                httpstate = statusLine.getHttpVersion();
                if (getParams().isParameterFalse("http.protocol.unambiguous-statusline") && httpstate.equals("HTTP"))
                {
                    getParams().setVersion(HttpVersion.HTTP_1_0);
                    if (LOG.isWarnEnabled())
                    {
                        LOG.warn("Ambiguous status line (HTTP protocol version missing):" + statusLine.toString());
                    }
                    return;
                } else
                {
                    effectiveVersion = HttpVersion.parse(httpstate);
                    return;
                }
            }
            if (httpstate == null || i >= j)
            {
                throw new ProtocolException("The server " + httpconnection.getHost() + " failed to respond with a valid HTTP response");
            }
            i++;
        } while (true);
    }

    public void recycle()
    {
        LOG.trace("enter HttpMethodBase.recycle()");
        releaseConnection();
        path = null;
        followRedirects = false;
        doAuthentication = true;
        queryString = null;
        getRequestHeaderGroup().clear();
        getResponseHeaderGroup().clear();
        getResponseTrailerHeaderGroup().clear();
        statusLine = null;
        effectiveVersion = null;
        aborted = false;
        used = false;
        params = new HttpMethodParams();
        responseBody = null;
        recoverableExceptionCount = 0;
        connectionCloseForced = false;
        hostAuthState.invalidate();
        proxyAuthState.invalidate();
        cookiespec = null;
        requestSent = false;
    }

    public void releaseConnection()
    {
        InputStream inputstream = responseStream;
        Exception exception;
        if (inputstream != null)
        {
            try
            {
                responseStream.close();
            }
            catch (IOException ioexception) { }
            finally
            {
                ensureConnectionRelease();
            }
        }
        ensureConnectionRelease();
        return;
        throw exception;
    }

    public void removeRequestHeader(String s)
    {
        s = getRequestHeaderGroup().getHeaders(s);
        for (int i = 0; i < s.length; i++)
        {
            getRequestHeaderGroup().removeHeader(s[i]);
        }

    }

    public void removeRequestHeader(Header header)
    {
        if (header == null)
        {
            return;
        } else
        {
            getRequestHeaderGroup().removeHeader(header);
            return;
        }
    }

    protected void responseBodyConsumed()
    {
        responseStream = null;
        if (responseConnection == null) goto _L2; else goto _L1
_L1:
        responseConnection.setLastResponseInputStream(null);
        if (!shouldCloseConnection(responseConnection)) goto _L4; else goto _L3
_L3:
        responseConnection.close();
_L2:
        connectionCloseForced = false;
        ensureConnectionRelease();
        return;
_L4:
        try
        {
            if (responseConnection.isResponseAvailable())
            {
                if (getParams().isParameterTrue("http.protocol.warn-extra-input"))
                {
                    LOG.warn("Extra response data detected - closing connection");
                }
                responseConnection.close();
            }
        }
        catch (IOException ioexception)
        {
            LOG.warn(ioexception.getMessage());
            responseConnection.close();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void setConnectionCloseForced(boolean flag)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Force-close connection: " + flag);
        }
        connectionCloseForced = flag;
    }

    public void setDoAuthentication(boolean flag)
    {
        doAuthentication = flag;
    }

    public void setFollowRedirects(boolean flag)
    {
        followRedirects = flag;
    }

    public void setHostConfiguration(HostConfiguration hostconfiguration)
    {
        if (hostconfiguration != null)
        {
            httphost = new HttpHost(hostconfiguration.getHost(), hostconfiguration.getPort(), hostconfiguration.getProtocol());
            return;
        } else
        {
            httphost = null;
            return;
        }
    }

    public void setHttp11(boolean flag)
    {
        if (flag)
        {
            params.setVersion(HttpVersion.HTTP_1_1);
            return;
        } else
        {
            params.setVersion(HttpVersion.HTTP_1_0);
            return;
        }
    }

    public void setMethodRetryHandler(MethodRetryHandler methodretryhandler)
    {
        methodRetryHandler = methodretryhandler;
    }

    public void setParams(HttpMethodParams httpmethodparams)
    {
        if (httpmethodparams == null)
        {
            throw new IllegalArgumentException("Parameters may not be null");
        } else
        {
            params = httpmethodparams;
            return;
        }
    }

    public void setPath(String s)
    {
        path = s;
    }

    public void setQueryString(String s)
    {
        queryString = s;
    }

    public void setQueryString(NameValuePair anamevaluepair[])
    {
        LOG.trace("enter HttpMethodBase.setQueryString(NameValuePair[])");
        queryString = EncodingUtil.formUrlEncode(anamevaluepair, "UTF-8");
    }

    public void setRequestHeader(String s, String s1)
    {
        setRequestHeader(new Header(s, s1));
    }

    public void setRequestHeader(Header header)
    {
        Header aheader[] = getRequestHeaderGroup().getHeaders(header.getName());
        for (int i = 0; i < aheader.length; i++)
        {
            getRequestHeaderGroup().removeHeader(aheader[i]);
        }

        getRequestHeaderGroup().addHeader(header);
    }

    protected void setResponseStream(InputStream inputstream)
    {
        responseStream = inputstream;
    }

    public void setStrictMode(boolean flag)
    {
        if (flag)
        {
            params.makeStrict();
            return;
        } else
        {
            params.makeLenient();
            return;
        }
    }

    public void setURI(URI uri)
        throws URIException
    {
        if (uri.isAbsoluteURI())
        {
            httphost = new HttpHost(uri);
        }
        String s;
        if (uri.getPath() == null)
        {
            s = "/";
        } else
        {
            s = uri.getEscapedPath();
        }
        setPath(s);
        setQueryString(uri.getEscapedQuery());
    }

    protected boolean shouldCloseConnection(HttpConnection httpconnection)
    {
        if (!isConnectionCloseForced()) goto _L2; else goto _L1
_L1:
        LOG.debug("Should force-close connection.");
_L4:
        return true;
_L2:
        Object obj;
        obj = null;
        if (!httpconnection.isTransparent())
        {
            obj = responseHeaders.getFirstHeader("proxy-connection");
        }
        httpconnection = ((HttpConnection) (obj));
        if (obj == null)
        {
            httpconnection = responseHeaders.getFirstHeader("connection");
        }
        obj = httpconnection;
        if (httpconnection == null)
        {
            obj = requestHeaders.getFirstHeader("connection");
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        if (!((Header) (obj)).getValue().equalsIgnoreCase("close"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Should close connection in response to directive: " + ((Header) (obj)).getValue());
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (((Header) (obj)).getValue().equalsIgnoreCase("keep-alive"))
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Should NOT close connection in response to directive: " + ((Header) (obj)).getValue());
            }
            return false;
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Unknown directive: " + ((Header) (obj)).toExternalForm());
        }
        LOG.debug("Resorting to protocol version default close connection policy");
        if (!effectiveVersion.greaterEquals(HttpVersion.HTTP_1_1)) goto _L6; else goto _L5
_L5:
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Should NOT close connection, using " + effectiveVersion.toString());
        }
_L8:
        return effectiveVersion.lessEquals(HttpVersion.HTTP_1_0);
_L6:
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Should close connection, using " + effectiveVersion.toString());
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean validate()
    {
        return true;
    }

    protected void writeRequest(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        String s;
        HttpVersion httpversion;
        LOG.trace("enter HttpMethodBase.writeRequest(HttpState, HttpConnection)");
        writeRequestLine(httpstate, httpconnection);
        writeRequestHeaders(httpstate, httpconnection);
        httpconnection.writeLine();
        if (Wire.HEADER_WIRE.enabled())
        {
            Wire.HEADER_WIRE.output("\r\n");
        }
        httpversion = getParams().getVersion();
        Header header = getRequestHeader("Expect");
        s = null;
        if (header != null)
        {
            s = header.getValue();
        }
        if (s == null || s.compareToIgnoreCase("100-continue") != 0) goto _L2; else goto _L1
_L1:
        if (!httpversion.greaterEquals(HttpVersion.HTTP_1_1)) goto _L4; else goto _L3
_L3:
        int i;
        httpconnection.flushRequestOutputStream();
        i = httpconnection.getParams().getSoTimeout();
        httpconnection.setSocketTimeout(3000);
        readStatusLine(httpstate, httpconnection);
        processStatusLine(httpstate, httpconnection);
        readResponseHeaders(httpstate, httpconnection);
        processResponseHeaders(httpstate, httpconnection);
        if (statusLine.getStatusCode() != 100) goto _L6; else goto _L5
_L5:
        statusLine = null;
        LOG.debug("OK to continue received");
        httpconnection.setSocketTimeout(i);
_L2:
        writeRequestBody(httpstate, httpconnection);
        httpconnection.flushRequestOutputStream();
        return;
_L6:
        httpconnection.setSocketTimeout(i);
        return;
        InterruptedIOException interruptedioexception;
        interruptedioexception;
        if (!ExceptionUtil.isSocketTimeoutException(interruptedioexception))
        {
            throw interruptedioexception;
        }
        break MISSING_BLOCK_LABEL_217;
        httpstate;
        httpconnection.setSocketTimeout(i);
        throw httpstate;
        removeRequestHeader("Expect");
        LOG.info("100 (continue) read timeout. Resume sending the request");
        httpconnection.setSocketTimeout(i);
        continue; /* Loop/switch isn't completed */
_L4:
        removeRequestHeader("Expect");
        LOG.info("'Expect: 100-continue' handshake is only supported by HTTP/1.1 or higher");
        if (true) goto _L2; else goto _L7
_L7:
    }

    protected boolean writeRequestBody(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        return true;
    }

    protected void writeRequestHeaders(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.writeRequestHeaders(HttpState,HttpConnection)");
        addRequestHeaders(httpstate, httpconnection);
        httpstate = getParams().getHttpElementCharset();
        Header aheader[] = getRequestHeaders();
        for (int i = 0; i < aheader.length; i++)
        {
            String s = aheader[i].toExternalForm();
            if (Wire.HEADER_WIRE.enabled())
            {
                Wire.HEADER_WIRE.output(s);
            }
            httpconnection.print(s, httpstate);
        }

    }

    protected void writeRequestLine(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter HttpMethodBase.writeRequestLine(HttpState, HttpConnection)");
        httpstate = getRequestLine(httpconnection);
        if (Wire.HEADER_WIRE.enabled())
        {
            Wire.HEADER_WIRE.output(httpstate);
        }
        httpconnection.print(httpstate, getParams().getHttpElementCharset());
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$HttpMethodBase == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.HttpMethodBase");
            class$org$apache$commons$httpclient$HttpMethodBase = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$HttpMethodBase;
        }
        LOG = LogFactory.getLog(class1);
    }

    private class _cls1
        implements ResponseConsumedWatcher
    {

        private final HttpMethodBase this$0;

        public void responseConsumed()
        {
            responseBodyConsumed();
        }

        _cls1()
        {
            this$0 = HttpMethodBase.this;
        }
    }

}
