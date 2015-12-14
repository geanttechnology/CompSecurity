// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.httpclient.auth.AuthChallengeException;
import org.apache.commons.httpclient.auth.AuthChallengeParser;
import org.apache.commons.httpclient.auth.AuthChallengeProcessor;
import org.apache.commons.httpclient.auth.AuthScheme;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.auth.AuthState;
import org.apache.commons.httpclient.auth.AuthenticationException;
import org.apache.commons.httpclient.auth.CredentialsNotAvailableException;
import org.apache.commons.httpclient.auth.CredentialsProvider;
import org.apache.commons.httpclient.auth.MalformedChallengeException;
import org.apache.commons.httpclient.params.HostParams;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.params.HttpParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpMethod, HttpConnection, HttpState, Header, 
//            HttpException, ConnectMethod, HostConfiguration, HttpMethodBase, 
//            HttpRecoverableException, MethodRetryHandler, HttpMethodRetryHandler, DefaultHttpMethodRetryHandler, 
//            RedirectException, URIException, URI, CircularRedirectException, 
//            InvalidRedirectLocationException, HttpConnectionManager, Credentials

class HttpMethodDirector
{

    private static final Log LOG;
    public static final String PROXY_AUTH_CHALLENGE = "Proxy-Authenticate";
    public static final String PROXY_AUTH_RESP = "Proxy-Authorization";
    public static final String WWW_AUTH_CHALLENGE = "WWW-Authenticate";
    public static final String WWW_AUTH_RESP = "Authorization";
    static Class class$org$apache$commons$httpclient$HttpMethodDirector;
    private AuthChallengeProcessor authProcessor;
    private HttpConnection conn;
    private ConnectMethod connectMethod;
    private HttpConnectionManager connectionManager;
    private HostConfiguration hostConfiguration;
    private HttpClientParams params;
    private Set redirectLocations;
    private boolean releaseConnection;
    private HttpState state;

    public HttpMethodDirector(HttpConnectionManager httpconnectionmanager, HostConfiguration hostconfiguration, HttpClientParams httpclientparams, HttpState httpstate)
    {
        releaseConnection = false;
        authProcessor = null;
        redirectLocations = null;
        connectionManager = httpconnectionmanager;
        hostConfiguration = hostconfiguration;
        params = httpclientparams;
        state = httpstate;
        authProcessor = new AuthChallengeProcessor(params);
    }

    private void applyConnectionParams(HttpMethod httpmethod)
        throws IOException
    {
        int i = 0;
        Object obj = httpmethod.getParams().getParameter("http.socket.timeout");
        httpmethod = ((HttpMethod) (obj));
        if (obj == null)
        {
            httpmethod = ((HttpMethod) (conn.getParams().getParameter("http.socket.timeout")));
        }
        if (httpmethod != null)
        {
            i = ((Integer)httpmethod).intValue();
        }
        conn.setSocketTimeout(i);
    }

    private void authenticate(HttpMethod httpmethod)
    {
        try
        {
            if (conn.isProxied() && !conn.isSecure())
            {
                authenticateProxy(httpmethod);
            }
            authenticateHost(httpmethod);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpMethod httpmethod)
        {
            LOG.error(httpmethod.getMessage(), httpmethod);
        }
    }

    private void authenticateHost(HttpMethod httpmethod)
        throws AuthenticationException
    {
        if (cleanAuthHeaders(httpmethod, "Authorization")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        obj = httpmethod.getHostAuthState();
        AuthScheme authscheme = ((AuthState) (obj)).getAuthScheme();
        if (authscheme != null && (((AuthState) (obj)).isAuthRequested() || !authscheme.isConnectionBased()))
        {
            Object obj1 = httpmethod.getParams().getVirtualHost();
            obj = obj1;
            if (obj1 == null)
            {
                obj = conn.getHost();
            }
            obj = new AuthScope(((String) (obj)), conn.getPort(), authscheme.getRealm(), authscheme.getSchemeName());
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Authenticating with " + obj);
            }
            obj1 = state.getCredentials(((AuthScope) (obj)));
            if (obj1 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = authscheme.authenticate(((Credentials) (obj1)), httpmethod);
            if (obj != null)
            {
                httpmethod.addRequestHeader(new Header("Authorization", ((String) (obj)), true));
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (!LOG.isWarnEnabled()) goto _L1; else goto _L3
_L3:
        LOG.warn("Required credentials not available for " + obj);
        if (httpmethod.getHostAuthState().isPreemptive())
        {
            LOG.warn("Preemptive authentication requested but no default credentials available");
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void authenticateProxy(HttpMethod httpmethod)
        throws AuthenticationException
    {
        if (cleanAuthHeaders(httpmethod, "Proxy-Authorization")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
        obj1 = httpmethod.getProxyAuthState();
        Object obj = ((AuthState) (obj1)).getAuthScheme();
        if (obj != null && (((AuthState) (obj1)).isAuthRequested() || !((AuthScheme) (obj)).isConnectionBased()))
        {
            obj1 = new AuthScope(conn.getProxyHost(), conn.getProxyPort(), ((AuthScheme) (obj)).getRealm(), ((AuthScheme) (obj)).getSchemeName());
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Authenticating with " + obj1);
            }
            Credentials credentials = state.getProxyCredentials(((AuthScope) (obj1)));
            if (credentials == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = ((AuthScheme) (obj)).authenticate(credentials, httpmethod);
            if (obj != null)
            {
                httpmethod.addRequestHeader(new Header("Proxy-Authorization", ((String) (obj)), true));
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (!LOG.isWarnEnabled()) goto _L1; else goto _L3
_L3:
        LOG.warn("Required proxy credentials not available for " + obj1);
        if (httpmethod.getProxyAuthState().isPreemptive())
        {
            LOG.warn("Preemptive authentication requested but no default proxy credentials available");
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
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

    private boolean cleanAuthHeaders(HttpMethod httpmethod, String s)
    {
        s = httpmethod.getRequestHeaders(s);
        boolean flag = true;
        int i = 0;
        while (i < s.length) 
        {
            Header header = s[i];
            if (header.isAutogenerated())
            {
                httpmethod.removeRequestHeader(header);
            } else
            {
                flag = false;
            }
            i++;
        }
        return flag;
    }

    private boolean executeConnect()
        throws IOException, HttpException
    {
        connectMethod = new ConnectMethod(hostConfiguration);
        connectMethod.getParams().setDefaults(hostConfiguration.getParams());
        do
        {
            do
            {
                if (!conn.isOpen())
                {
                    conn.open();
                }
                if (params.isAuthenticationPreemptive() || state.isAuthenticationPreemptive())
                {
                    LOG.debug("Preemptively sending default basic credentials");
                    connectMethod.getProxyAuthState().setPreemptive();
                    connectMethod.getProxyAuthState().setAuthAttempted(true);
                }
                AuthState authstate;
                boolean flag;
                boolean flag1;
                int i;
                boolean flag2;
                try
                {
                    authenticateProxy(connectMethod);
                }
                catch (AuthenticationException authenticationexception)
                {
                    LOG.error(authenticationexception.getMessage(), authenticationexception);
                }
                applyConnectionParams(connectMethod);
                connectMethod.execute(state, conn);
                i = connectMethod.getStatusCode();
                flag1 = false;
                authstate = connectMethod.getProxyAuthState();
                if (i == 407)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                authstate.setAuthRequested(flag2);
                flag = flag1;
                if (authstate.isAuthRequested())
                {
                    flag = flag1;
                    if (processAuthenticationResponse(connectMethod))
                    {
                        flag = true;
                    }
                }
                if (!flag)
                {
                    if (i >= 200 && i < 300)
                    {
                        conn.tunnelCreated();
                        connectMethod = null;
                        return true;
                    } else
                    {
                        conn.close();
                        return false;
                    }
                }
            } while (connectMethod.getResponseBodyAsStream() == null);
            connectMethod.getResponseBodyAsStream().close();
        } while (true);
    }

    private void executeWithRetry(HttpMethod httpmethod)
        throws IOException, HttpException
    {
        int i = 0;
_L1:
        i++;
        if (LOG.isTraceEnabled())
        {
            LOG.trace("Attempt number " + i + " to process request");
        }
        if (conn.getParams().isStaleCheckingEnabled())
        {
            conn.closeIfStale();
        }
        if (!conn.isOpen())
        {
            conn.open();
            if (conn.isProxied() && conn.isSecure() && !(httpmethod instanceof ConnectMethod) && !executeConnect())
            {
                return;
            }
        }
        applyConnectionParams(httpmethod);
        httpmethod.execute(state, conn);
        return;
        httpmethod;
        IOException ioexception;
        MethodRetryHandler methodretryhandler;
        try
        {
            throw httpmethod;
        }
        // Misplaced declaration of an exception variable
        catch (HttpMethod httpmethod)
        {
            if (conn.isOpen())
            {
                LOG.debug("Closing the connection.");
                conn.close();
            }
            releaseConnection = true;
            throw httpmethod;
        }
        // Misplaced declaration of an exception variable
        catch (HttpMethod httpmethod) { }
        break MISSING_BLOCK_LABEL_276;
        ioexception;
        LOG.debug("Closing the connection.");
        conn.close();
        if (!(httpmethod instanceof HttpMethodBase))
        {
            break MISSING_BLOCK_LABEL_311;
        }
        methodretryhandler = ((HttpMethodBase)httpmethod).getMethodRetryHandler();
        if (methodretryhandler == null)
        {
            break MISSING_BLOCK_LABEL_311;
        }
        if (!methodretryhandler.retryMethod(httpmethod, conn, new HttpRecoverableException(ioexception.getMessage()), i, httpmethod.isRequestSent()))
        {
            LOG.debug("Method retry handler returned false. Automatic recovery will not be attempted");
            throw ioexception;
        }
        break MISSING_BLOCK_LABEL_311;
        if (conn.isOpen())
        {
            LOG.debug("Closing the connection.");
            conn.close();
        }
        releaseConnection = true;
        throw httpmethod;
        HttpMethodRetryHandler httpmethodretryhandler = (HttpMethodRetryHandler)httpmethod.getParams().getParameter("http.method.retry-handler");
        Object obj;
        obj = httpmethodretryhandler;
        if (httpmethodretryhandler != null)
        {
            break MISSING_BLOCK_LABEL_341;
        }
        obj = new DefaultHttpMethodRetryHandler();
        if (!((HttpMethodRetryHandler) (obj)).retryMethod(httpmethod, ioexception, i))
        {
            LOG.debug("Method retry handler returned false. Automatic recovery will not be attempted");
            throw ioexception;
        }
        if (LOG.isInfoEnabled())
        {
            LOG.info("I/O exception (" + ioexception.getClass().getName() + ") caught when processing request: " + ioexception.getMessage());
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug(ioexception.getMessage(), ioexception);
        }
        LOG.info("Retrying request");
          goto _L1
    }

    private void fakeResponse(HttpMethod httpmethod)
        throws IOException, HttpException
    {
        LOG.debug("CONNECT failed, fake the response for the original method");
        if (httpmethod instanceof HttpMethodBase)
        {
            ((HttpMethodBase)httpmethod).fakeResponse(connectMethod.getStatusLine(), connectMethod.getResponseHeaderGroup(), connectMethod.getResponseBodyAsStream());
            httpmethod.getProxyAuthState().setAuthScheme(connectMethod.getProxyAuthState().getAuthScheme());
            connectMethod = null;
            return;
        } else
        {
            releaseConnection = true;
            LOG.warn("Unable to fake response on method as it is not derived from HttpMethodBase.");
            return;
        }
    }

    private boolean isAuthenticationNeeded(HttpMethod httpmethod)
    {
label0:
        {
label1:
            {
                boolean flag1 = false;
                AuthState authstate = httpmethod.getHostAuthState();
                boolean flag;
                if (httpmethod.getStatusCode() == 401)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                authstate.setAuthRequested(flag);
                authstate = httpmethod.getProxyAuthState();
                if (httpmethod.getStatusCode() == 407)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                authstate.setAuthRequested(flag);
                if (!httpmethod.getHostAuthState().isAuthRequested())
                {
                    flag = flag1;
                    if (!httpmethod.getProxyAuthState().isAuthRequested())
                    {
                        break label1;
                    }
                }
                LOG.debug("Authorization required");
                if (!httpmethod.getDoAuthentication())
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        LOG.info("Authentication requested but doAuthentication is disabled");
        return false;
    }

    private boolean isRedirectNeeded(HttpMethod httpmethod)
    {
        httpmethod.getStatusCode();
        JVM INSTR tableswitch 301 307: default 48
    //                   301 50
    //                   302 50
    //                   303 50
    //                   304 48
    //                   305 48
    //                   306 48
    //                   307 50;
           goto _L1 _L2 _L2 _L2 _L1 _L1 _L1 _L2
_L1:
        return false;
_L2:
        LOG.debug("Redirect required");
        if (httpmethod.getFollowRedirects())
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private boolean processAuthenticationResponse(HttpMethod httpmethod)
    {
        LOG.trace("enter HttpMethodBase.processAuthenticationResponse(HttpState, HttpConnection)");
        httpmethod.getStatusCode();
        JVM INSTR lookupswitch 2: default 85
    //                   401: 44
    //                   407: 50;
           goto _L1 _L2 _L3
_L2:
        return processWWWAuthChallenge(httpmethod);
_L3:
        boolean flag = processProxyAuthChallenge(httpmethod);
        return flag;
        httpmethod;
        if (LOG.isErrorEnabled())
        {
            LOG.error(httpmethod.getMessage(), httpmethod);
            return false;
        }
_L1:
        return false;
    }

    private boolean processProxyAuthChallenge(HttpMethod httpmethod)
        throws MalformedChallengeException, AuthenticationException
    {
        Object obj;
        Object obj2;
        obj2 = httpmethod.getProxyAuthState();
        obj = AuthChallengeParser.parseChallenges(httpmethod.getResponseHeaders("Proxy-Authenticate"));
        if (!((Map) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        LOG.debug("Proxy authentication challenge(s) not found");
_L4:
        return false;
_L2:
        Object obj3;
        Object obj1 = null;
        try
        {
            obj = authProcessor.processChallenge(((AuthState) (obj2)), ((Map) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj3)
        {
            obj = obj1;
            if (LOG.isWarnEnabled())
            {
                LOG.warn(((AuthChallengeException) (obj3)).getMessage());
                obj = obj1;
            }
        }
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = new AuthScope(conn.getProxyHost(), conn.getProxyPort(), ((AuthScheme) (obj)).getRealm(), ((AuthScheme) (obj)).getSchemeName());
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Proxy authentication scope: " + obj3);
        }
        if (!((AuthState) (obj2)).isAuthAttempted() || !((AuthScheme) (obj)).isComplete())
        {
            break; /* Loop/switch isn't completed */
        }
        if (promptForProxyCredentials(((AuthScheme) (obj)), httpmethod.getParams(), ((AuthScope) (obj3))) == null)
        {
            if (LOG.isInfoEnabled())
            {
                LOG.info("Failure authenticating with " + obj3);
                return false;
            }
        } else
        {
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        ((AuthState) (obj2)).setAuthAttempted(true);
        obj2 = state.getProxyCredentials(((AuthScope) (obj3)));
        Credentials credentials = ((Credentials) (obj2));
        if (obj2 == null)
        {
            credentials = promptForProxyCredentials(((AuthScheme) (obj)), httpmethod.getParams(), ((AuthScope) (obj3)));
        }
        if (credentials == null)
        {
            if (LOG.isInfoEnabled())
            {
                LOG.info("No credentials available for " + obj3);
                return false;
            }
        } else
        {
            return true;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private boolean processRedirectResponse(HttpMethod httpmethod)
        throws RedirectException
    {
        String s;
        Header header = httpmethod.getResponseHeader("location");
        if (header == null)
        {
            LOG.error("Received redirect response " + httpmethod.getStatusCode() + " but no location header");
            return false;
        }
        s = header.getValue();
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Redirect requested to location '" + s + "'");
        }
        URI uri1 = new URI(conn.getProtocol().getScheme(), null, conn.getHost(), conn.getPort(), httpmethod.getPath());
        URI uri;
        try
        {
            uri = new URI(s, true, httpmethod.getParams().getUriCharset());
        }
        // Misplaced declaration of an exception variable
        catch (HttpMethod httpmethod)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!uri.isRelativeURI()) goto _L2; else goto _L1
_L1:
        if (!params.isParameterTrue("http.protocol.reject-relative-redirect"))
        {
            break MISSING_BLOCK_LABEL_220;
        }
        LOG.warn("Relative redirect location '" + s + "' not allowed");
        return false;
        LOG.debug("Redirect URI is not absolute - parsing as relative");
        uri = new URI(uri1, uri);
_L4:
        httpmethod.setURI(uri);
        hostConfiguration.setHost(uri);
        if (params.isParameterFalse("http.protocol.allow-circular-redirects"))
        {
            if (redirectLocations == null)
            {
                redirectLocations = new HashSet();
            }
            redirectLocations.add(uri1);
            try
            {
                if (uri.hasQuery())
                {
                    uri.setQuery(null);
                }
            }
            // Misplaced declaration of an exception variable
            catch (HttpMethod httpmethod)
            {
                return false;
            }
            if (redirectLocations.contains(uri))
            {
                throw new CircularRedirectException("Circular redirect to '" + uri + "'");
            }
        }
        break; /* Loop/switch isn't completed */
_L2:
        httpmethod.getParams().setDefaults(params);
        if (true) goto _L4; else goto _L3
        httpmethod;
_L6:
        throw new InvalidRedirectLocationException("Invalid redirect location: " + s, s, httpmethod);
_L3:
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Redirecting from '" + uri1.getEscapedURI() + "' to '" + uri.getEscapedURI());
        }
        httpmethod.getHostAuthState().invalidate();
        return true;
        httpmethod;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean processWWWAuthChallenge(HttpMethod httpmethod)
        throws MalformedChallengeException, AuthenticationException
    {
        Object obj;
        AuthState authstate;
        authstate = httpmethod.getHostAuthState();
        obj = AuthChallengeParser.parseChallenges(httpmethod.getResponseHeaders("WWW-Authenticate"));
        if (!((Map) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        LOG.debug("Authentication challenge(s) not found");
_L4:
        return false;
_L2:
        AuthScope authscope;
        String s = null;
        String s1;
        try
        {
            obj = authProcessor.processChallenge(authstate, ((Map) (obj)));
        }
        catch (AuthChallengeException authchallengeexception)
        {
            obj = s;
            if (LOG.isWarnEnabled())
            {
                LOG.warn(authchallengeexception.getMessage());
                obj = s;
            }
        }
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = httpmethod.getParams().getVirtualHost();
        s = s1;
        if (s1 == null)
        {
            s = conn.getHost();
        }
        authscope = new AuthScope(s, conn.getPort(), ((AuthScheme) (obj)).getRealm(), ((AuthScheme) (obj)).getSchemeName());
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Authentication scope: " + authscope);
        }
        if (!authstate.isAuthAttempted() || !((AuthScheme) (obj)).isComplete())
        {
            break; /* Loop/switch isn't completed */
        }
        if (promptForCredentials(((AuthScheme) (obj)), httpmethod.getParams(), authscope) == null)
        {
            if (LOG.isInfoEnabled())
            {
                LOG.info("Failure authenticating with " + authscope);
                return false;
            }
        } else
        {
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        authstate.setAuthAttempted(true);
        Credentials credentials1 = state.getCredentials(authscope);
        Credentials credentials = credentials1;
        if (credentials1 == null)
        {
            credentials = promptForCredentials(((AuthScheme) (obj)), httpmethod.getParams(), authscope);
        }
        if (credentials == null)
        {
            if (LOG.isInfoEnabled())
            {
                LOG.info("No credentials available for " + authscope);
                return false;
            }
        } else
        {
            return true;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private Credentials promptForCredentials(AuthScheme authscheme, HttpParams httpparams, AuthScope authscope)
    {
        LOG.debug("Credentials required");
        Object obj = null;
        httpparams = (CredentialsProvider)httpparams.getParameter("http.authentication.credential-provider");
        if (httpparams != null)
        {
            try
            {
                authscheme = httpparams.getCredentials(authscheme, authscope.getHost(), authscope.getPort(), false);
            }
            // Misplaced declaration of an exception variable
            catch (AuthScheme authscheme)
            {
                LOG.warn(authscheme.getMessage());
                authscheme = obj;
            }
            if (authscheme != null)
            {
                state.setCredentials(authscope, authscheme);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug(authscope + " new credentials given");
                }
            }
            return authscheme;
        } else
        {
            LOG.debug("Credentials provider not available");
            return null;
        }
    }

    private Credentials promptForProxyCredentials(AuthScheme authscheme, HttpParams httpparams, AuthScope authscope)
    {
        LOG.debug("Proxy credentials required");
        Object obj = null;
        httpparams = (CredentialsProvider)httpparams.getParameter("http.authentication.credential-provider");
        if (httpparams != null)
        {
            try
            {
                authscheme = httpparams.getCredentials(authscheme, authscope.getHost(), authscope.getPort(), true);
            }
            // Misplaced declaration of an exception variable
            catch (AuthScheme authscheme)
            {
                LOG.warn(authscheme.getMessage());
                authscheme = obj;
            }
            if (authscheme != null)
            {
                state.setProxyCredentials(authscope, authscheme);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug(authscope + " new credentials given");
                }
            }
            return authscheme;
        } else
        {
            LOG.debug("Proxy credentials provider not available");
            return null;
        }
    }

    public void executeMethod(HttpMethod httpmethod)
        throws IOException, HttpException
    {
        if (httpmethod == null)
        {
            throw new IllegalArgumentException("Method may not be null");
        }
        hostConfiguration.getParams().setDefaults(params);
        httpmethod.getParams().setDefaults(hostConfiguration.getParams());
        Object obj = (Collection)hostConfiguration.getParams().getParameter("http.default-headers");
        if (obj != null)
        {
            for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); httpmethod.addRequestHeader((Header)((Iterator) (obj)).next())) { }
        }
        int k = params.getIntParameter("http.protocol.max-redirects", 100);
        int j = 0;
_L6:
        if (conn != null && !hostConfiguration.hostEquals(conn))
        {
            conn.setLocked(false);
            conn.releaseConnection();
            conn = null;
        }
        if (conn == null)
        {
            conn = connectionManager.getConnectionWithTimeout(hostConfiguration, params.getConnectionManagerTimeout());
            conn.setLocked(true);
            if (params.isAuthenticationPreemptive() || state.isAuthenticationPreemptive())
            {
                LOG.debug("Preemptively sending default basic credentials");
                httpmethod.getHostAuthState().setPreemptive();
                httpmethod.getHostAuthState().setAuthAttempted(true);
                if (conn.isProxied() && !conn.isSecure())
                {
                    httpmethod.getProxyAuthState().setPreemptive();
                    httpmethod.getProxyAuthState().setAuthAttempted(true);
                }
            }
        }
        authenticate(httpmethod);
        executeWithRetry(httpmethod);
        if (connectMethod == null) goto _L2; else goto _L1
_L1:
        fakeResponse(httpmethod);
_L4:
        if (conn != null)
        {
            conn.setLocked(false);
        }
        if ((releaseConnection || httpmethod.getResponseBodyAsStream() == null) && conn != null)
        {
            conn.releaseConnection();
        }
        return;
_L2:
        boolean flag;
        int i;
        boolean flag1;
        flag1 = false;
        i = j;
        flag = flag1;
        if (!isRedirectNeeded(httpmethod))
        {
            break MISSING_BLOCK_LABEL_562;
        }
        i = j;
        flag = flag1;
        if (!processRedirectResponse(httpmethod))
        {
            break MISSING_BLOCK_LABEL_562;
        }
        flag1 = true;
        j++;
        if (j < k)
        {
            break MISSING_BLOCK_LABEL_497;
        }
        LOG.error("Narrowly avoided an infinite loop in execute");
        throw new RedirectException("Maximum redirects (" + k + ") exceeded");
        Exception exception;
        exception;
        if (conn != null)
        {
            conn.setLocked(false);
        }
        if ((releaseConnection || httpmethod.getResponseBodyAsStream() == null) && conn != null)
        {
            conn.releaseConnection();
        }
        throw exception;
        i = j;
        flag = flag1;
        if (!LOG.isDebugEnabled())
        {
            break MISSING_BLOCK_LABEL_562;
        }
        LOG.debug("Execute redirect " + j + " of " + k);
        flag = flag1;
        i = j;
        j = ((flag) ? 1 : 0);
        if (!isAuthenticationNeeded(httpmethod))
        {
            continue; /* Loop/switch isn't completed */
        }
        j = ((flag) ? 1 : 0);
        if (!processAuthenticationResponse(httpmethod))
        {
            continue; /* Loop/switch isn't completed */
        }
        LOG.debug("Retry authentication");
        j = 1;
        if (j == 0) goto _L4; else goto _L3
_L3:
        j = i;
        if (httpmethod.getResponseBodyAsStream() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        httpmethod.getResponseBodyAsStream().close();
        j = i;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public HttpConnectionManager getConnectionManager()
    {
        return connectionManager;
    }

    public HostConfiguration getHostConfiguration()
    {
        return hostConfiguration;
    }

    public HttpParams getParams()
    {
        return params;
    }

    public HttpState getState()
    {
        return state;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$HttpMethodDirector == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.HttpMethodDirector");
            class$org$apache$commons$httpclient$HttpMethodDirector = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$HttpMethodDirector;
        }
        LOG = LogFactory.getLog(class1);
    }
}
