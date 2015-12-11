// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.Queue;

abstract class RequestAuthenticationBase
    implements HttpRequestInterceptor
{

    final HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    public RequestAuthenticationBase()
    {
    }

    private Header authenticate(AuthScheme authscheme, Credentials credentials, HttpRequest httprequest, HttpContext httpcontext)
        throws AuthenticationException
    {
        Asserts.notNull(authscheme, "Auth scheme");
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

    void process(AuthState authstate, HttpRequest httprequest, HttpContext httpcontext)
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
                    $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.FAILURE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.SUCCESS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.CHALLENGED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.cz.msebera.android.httpclient.auth.AuthProtocolState[authstate.getState().ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 69
    //                   2 70
    //                   3 87;
           goto _L1 _L2 _L3 _L4
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        if (authscheme == null)
        {
            break; /* Loop/switch isn't completed */
        }
        httprequest.addHeader(authenticate(authscheme, credentials, httprequest, httpcontext));
_L5:
        return;
_L3:
        ensureAuthScheme(authscheme);
        if (authscheme.isConnectionBased())
        {
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
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
                    httprequest.addHeader(authenticate(authscheme, ((Credentials) (obj)), httprequest, httpcontext));
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
        authstate;
        if (!log.isErrorEnabled()) goto _L5; else goto _L6
_L6:
        log.error((new StringBuilder()).append(authscheme).append(" authentication error: ").append(authstate.getMessage()).toString());
        return;
        if (true) goto _L1; else goto _L7
_L7:
    }
}
