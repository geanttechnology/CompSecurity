// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

public class HttpAuthenticator
{

    public HttpClientAndroidLog log;

    public HttpAuthenticator()
    {
        this(null);
    }

    public HttpAuthenticator(HttpClientAndroidLog httpclientandroidlog)
    {
        if (httpclientandroidlog == null)
        {
            httpclientandroidlog = new HttpClientAndroidLog(getClass());
        }
        log = httpclientandroidlog;
    }

    private Header doAuth(AuthScheme authscheme, Credentials credentials, HttpRequest httprequest, HttpContext httpcontext)
        throws AuthenticationException
    {
        if (authscheme instanceof ContextAwareAuthScheme)
        {
            return ((ContextAwareAuthScheme)authscheme).authenticate(credentials, httprequest, httpcontext);
        } else
        {
            return authscheme.authenticate(credentials, httprequest);
        }
    }

    private void ensureAuthScheme(AuthScheme authscheme)
    {
        Asserts.notNull(authscheme, "Auth scheme");
    }

    public void generateAuthResponse(HttpRequest httprequest, AuthState authstate, HttpContext httpcontext)
        throws HttpException, IOException
    {
        AuthScheme authscheme;
        Credentials credentials;
        authscheme = authstate.getAuthScheme();
        credentials = authstate.getCredentials();
        static class _cls1
        {

            static final int $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[];

            static 
            {
                $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = new int[AuthProtocolState.values().length];
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.CHALLENGED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.HANDSHAKE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.SUCCESS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.FAILURE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.UNCHALLENGED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.cz.msebera.android.httpclient.auth.AuthProtocolState[authstate.getState().ordinal()];
        JVM INSTR tableswitch 1 4: default 52
    //                   1 91
    //                   2 52
    //                   3 74
    //                   4 73;
           goto _L1 _L2 _L1 _L3 _L4
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        if (authscheme == null)
        {
            break; /* Loop/switch isn't completed */
        }
        httprequest.addHeader(doAuth(authscheme, credentials, httprequest, httpcontext));
_L5:
        return;
_L3:
        ensureAuthScheme(authscheme);
        if (authscheme.isConnectionBased())
        {
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        Queue queue = authstate.getAuthOptions();
        if (queue != null)
        {
            while (!queue.isEmpty()) 
            {
                Object obj = (AuthOption)queue.remove();
                authscheme = ((AuthOption) (obj)).getAuthScheme();
                obj = ((AuthOption) (obj)).getCredentials();
                authstate.update(authscheme, ((Credentials) (obj)));
                if (log.isDebugEnabled())
                {
                    log.debug((new StringBuilder()).append("Generating response to an authentication challenge using ").append(authscheme.getSchemeName()).append(" scheme").toString());
                }
                try
                {
                    httprequest.addHeader(doAuth(authscheme, ((Credentials) (obj)), httprequest, httpcontext));
                    return;
                }
                catch (AuthenticationException authenticationexception)
                {
                    if (log.isWarnEnabled())
                    {
                        log.warn((new StringBuilder()).append(authscheme).append(" authentication error: ").append(authenticationexception.getMessage()).toString());
                    }
                }
            }
        } else
        {
            ensureAuthScheme(authscheme);
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
        httprequest;
        if (!log.isErrorEnabled()) goto _L5; else goto _L6
_L6:
        log.error((new StringBuilder()).append(authscheme).append(" authentication error: ").append(httprequest.getMessage()).toString());
        return;
        if (true) goto _L1; else goto _L7
_L7:
    }

    public boolean handleAuthChallenge(HttpHost httphost, HttpResponse httpresponse, AuthenticationStrategy authenticationstrategy, AuthState authstate, HttpContext httpcontext)
    {
        Map map;
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append(httphost.toHostString()).append(" requested authentication").toString());
        }
        map = authenticationstrategy.getChallenges(httphost, httpresponse, httpcontext);
        if (!map.isEmpty())
        {
            break MISSING_BLOCK_LABEL_72;
        }
        log.debug("Response contains no authentication challenges");
        return false;
        AuthScheme authscheme = authstate.getAuthScheme();
        _cls1..SwitchMap.cz.msebera.android.httpclient.auth.AuthProtocolState[authstate.getState().ordinal()];
        JVM INSTR tableswitch 1 5: default 417
    //                   1 257
    //                   2 257
    //                   3 202
    //                   4 420
    //                   5 296;
           goto _L1 _L2 _L2 _L3 _L4 _L5
_L1:
        httphost = authenticationstrategy.select(map, httphost, httpresponse, httpcontext);
        if (httphost == null) goto _L7; else goto _L6
_L6:
        if (httphost.isEmpty()) goto _L7; else goto _L8
_L8:
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Selected authentication options: ").append(httphost).toString());
        }
        authstate.setState(AuthProtocolState.CHALLENGED);
        authstate.update(httphost);
        return true;
_L3:
        try
        {
            authstate.reset();
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            if (log.isWarnEnabled())
            {
                log.warn((new StringBuilder()).append("Malformed challenge: ").append(httphost.getMessage()).toString());
            }
            authstate.reset();
            return false;
        }
          goto _L1
_L2:
        if (authscheme != null) goto _L5; else goto _L9
_L9:
        log.debug("Auth scheme is null");
        authenticationstrategy.authFailed(httphost, null, httpcontext);
        authstate.reset();
        authstate.setState(AuthProtocolState.FAILURE);
        return false;
_L5:
        if (authscheme == null) goto _L1; else goto _L10
_L10:
        Header header = (Header)map.get(authscheme.getSchemeName().toLowerCase(Locale.ENGLISH));
        if (header == null) goto _L12; else goto _L11
_L11:
        log.debug("Authorization challenge processed");
        authscheme.processChallenge(header);
        if (!authscheme.isComplete()) goto _L14; else goto _L13
_L13:
        log.debug("Authentication failed");
        authenticationstrategy.authFailed(httphost, authstate.getAuthScheme(), httpcontext);
        authstate.reset();
        authstate.setState(AuthProtocolState.FAILURE);
        return false;
_L14:
        authstate.setState(AuthProtocolState.HANDSHAKE);
        return true;
_L12:
        authstate.reset();
          goto _L1
_L7:
        return false;
_L4:
        return false;
    }

    public boolean isAuthenticationRequested(HttpHost httphost, HttpResponse httpresponse, AuthenticationStrategy authenticationstrategy, AuthState authstate, HttpContext httpcontext)
    {
        if (authenticationstrategy.isAuthenticationRequested(httphost, httpresponse, httpcontext))
        {
            log.debug("Authentication required");
            if (authstate.getState() == AuthProtocolState.SUCCESS)
            {
                authenticationstrategy.authFailed(httphost, authstate.getAuthScheme(), httpcontext);
            }
            return true;
        }
        _cls1..SwitchMap.cz.msebera.android.httpclient.auth.AuthProtocolState[authstate.getState().ordinal()];
        JVM INSTR tableswitch 1 3: default 88
    //                   1 98
    //                   2 98
    //                   3 96;
           goto _L1 _L2 _L2 _L3
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        authstate.setState(AuthProtocolState.UNCHALLENGED);
_L5:
        return false;
_L2:
        log.debug("Authentication succeeded");
        authstate.setState(AuthProtocolState.SUCCESS);
        authenticationstrategy.authSucceeded(httphost, authstate.getAuthScheme(), httpcontext);
        if (true) goto _L5; else goto _L4
_L4:
    }
}
