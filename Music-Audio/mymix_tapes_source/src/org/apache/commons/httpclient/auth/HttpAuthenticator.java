// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.auth:
//            AuthenticationException, AuthScheme, CredentialsNotAvailableException, InvalidCredentialsException, 
//            BasicScheme, MalformedChallengeException, AuthChallengeParser, NTLMScheme, 
//            DigestScheme

public final class HttpAuthenticator
{

    private static final Log LOG;
    public static final String PROXY_AUTH = "Proxy-Authenticate";
    public static final String PROXY_AUTH_RESP = "Proxy-Authorization";
    public static final String WWW_AUTH = "WWW-Authenticate";
    public static final String WWW_AUTH_RESP = "Authorization";
    static Class class$org$apache$commons$httpclient$auth$HttpAuthenticator;

    public HttpAuthenticator()
    {
    }

    public static boolean authenticate(AuthScheme authscheme, HttpMethod httpmethod, HttpConnection httpconnection, HttpState httpstate)
        throws AuthenticationException
    {
        LOG.trace("enter HttpAuthenticator.authenticate(AuthScheme, HttpMethod, HttpConnection, HttpState)");
        return doAuthenticate(authscheme, httpmethod, httpconnection, httpstate, false);
    }

    public static boolean authenticateDefault(HttpMethod httpmethod, HttpConnection httpconnection, HttpState httpstate)
        throws AuthenticationException
    {
        LOG.trace("enter HttpAuthenticator.authenticateDefault(HttpMethod, HttpConnection, HttpState)");
        return doAuthenticateDefault(httpmethod, httpconnection, httpstate, false);
    }

    public static boolean authenticateProxy(AuthScheme authscheme, HttpMethod httpmethod, HttpConnection httpconnection, HttpState httpstate)
        throws AuthenticationException
    {
        LOG.trace("enter HttpAuthenticator.authenticateProxy(AuthScheme, HttpMethod, HttpState)");
        return doAuthenticate(authscheme, httpmethod, httpconnection, httpstate, true);
    }

    public static boolean authenticateProxyDefault(HttpMethod httpmethod, HttpConnection httpconnection, HttpState httpstate)
        throws AuthenticationException
    {
        LOG.trace("enter HttpAuthenticator.authenticateProxyDefault(HttpMethod, HttpState)");
        return doAuthenticateDefault(httpmethod, httpconnection, httpstate, true);
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

    private static boolean doAuthenticate(AuthScheme authscheme, HttpMethod httpmethod, HttpConnection httpconnection, HttpState httpstate, boolean flag)
        throws AuthenticationException
    {
        if (authscheme == null)
        {
            throw new IllegalArgumentException("Authentication scheme may not be null");
        }
        if (httpmethod == null)
        {
            throw new IllegalArgumentException("HTTP method may not be null");
        }
        if (httpstate == null)
        {
            throw new IllegalArgumentException("HTTP state may not be null");
        }
        String s = null;
        String s1;
        if (httpconnection != null)
        {
            if (flag)
            {
                s = httpconnection.getProxyHost();
            } else
            {
                s1 = httpmethod.getParams().getVirtualHost();
                s = s1;
                if (s1 == null)
                {
                    s = httpconnection.getHost();
                }
            }
        }
        s1 = authscheme.getRealm();
        if (LOG.isDebugEnabled())
        {
            httpconnection = new StringBuffer();
            httpconnection.append("Using credentials for ");
            if (s1 == null)
            {
                httpconnection.append("default");
            } else
            {
                httpconnection.append('\'');
                httpconnection.append(s1);
                httpconnection.append('\'');
            }
            httpconnection.append(" authentication realm at ");
            httpconnection.append(s);
            LOG.debug(httpconnection.toString());
        }
        if (flag)
        {
            httpconnection = httpstate.getProxyCredentials(s1, s);
        } else
        {
            httpconnection = httpstate.getCredentials(s1, s);
        }
        if (httpconnection == null)
        {
            authscheme = new StringBuffer();
            authscheme.append("No credentials available for the ");
            if (s1 == null)
            {
                authscheme.append("default");
            } else
            {
                authscheme.append('\'');
                authscheme.append(s1);
                authscheme.append('\'');
            }
            authscheme.append(" authentication realm at ");
            authscheme.append(s);
            throw new CredentialsNotAvailableException(authscheme.toString());
        }
        httpconnection = authscheme.authenticate(httpconnection, httpmethod);
        if (httpconnection != null)
        {
            if (flag)
            {
                authscheme = "Proxy-Authorization";
            } else
            {
                authscheme = "Authorization";
            }
            httpmethod.addRequestHeader(new Header(authscheme, httpconnection, true));
            return true;
        } else
        {
            return false;
        }
    }

    private static boolean doAuthenticateDefault(HttpMethod httpmethod, HttpConnection httpconnection, HttpState httpstate, boolean flag)
        throws AuthenticationException
    {
        if (httpmethod == null)
        {
            throw new IllegalArgumentException("HTTP method may not be null");
        }
        if (httpstate == null)
        {
            throw new IllegalArgumentException("HTTP state may not be null");
        }
        String s = null;
        if (httpconnection != null)
        {
            if (flag)
            {
                s = httpconnection.getProxyHost();
            } else
            {
                s = httpconnection.getHost();
            }
        }
        if (flag)
        {
            httpconnection = httpstate.getProxyCredentials(null, s);
        } else
        {
            httpconnection = httpstate.getCredentials(null, s);
        }
        if (httpconnection != null)
        {
            if (!(httpconnection instanceof UsernamePasswordCredentials))
            {
                throw new InvalidCredentialsException("Credentials cannot be used for basic authentication: " + httpconnection.toString());
            }
            httpstate = BasicScheme.authenticate((UsernamePasswordCredentials)httpconnection, httpmethod.getParams().getCredentialCharset());
            if (httpstate != null)
            {
                if (flag)
                {
                    httpconnection = "Proxy-Authorization";
                } else
                {
                    httpconnection = "Authorization";
                }
                httpmethod.addRequestHeader(new Header(httpconnection, httpstate, true));
                return true;
            }
        }
        return false;
    }

    public static AuthScheme selectAuthScheme(Header aheader[])
        throws MalformedChallengeException
    {
        LOG.trace("enter HttpAuthenticator.selectAuthScheme(Header[])");
        if (aheader == null)
        {
            throw new IllegalArgumentException("Array of challenges may not be null");
        }
        if (aheader.length == 0)
        {
            throw new IllegalArgumentException("Array of challenges may not be empty");
        }
        HashMap hashmap = new HashMap(aheader.length);
        for (int i = 0; i < aheader.length; i++)
        {
            String s = aheader[i].getValue();
            hashmap.put(AuthChallengeParser.extractScheme(s), s);
        }

        aheader = (String)hashmap.get("ntlm");
        if (aheader != null)
        {
            return new NTLMScheme(aheader);
        }
        aheader = (String)hashmap.get("digest");
        if (aheader != null)
        {
            return new DigestScheme(aheader);
        }
        aheader = (String)hashmap.get("basic");
        if (aheader != null)
        {
            return new BasicScheme(aheader);
        } else
        {
            throw new UnsupportedOperationException("Authentication scheme(s) not supported: " + hashmap.toString());
        }
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$auth$HttpAuthenticator == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.auth.HttpAuthenticator");
            class$org$apache$commons$httpclient$auth$HttpAuthenticator = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$auth$HttpAuthenticator;
        }
        LOG = LogFactory.getLog(class1);
    }
}
