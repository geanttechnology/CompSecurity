// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;
import java.util.Queue;

// Referenced classes of package cz.msebera.android.httpclient.auth:
//            AuthProtocolState, AuthScheme, AuthScope, Credentials

public class AuthState
{

    private Queue authOptions;
    private AuthScheme authScheme;
    private AuthScope authScope;
    private Credentials credentials;
    private AuthProtocolState state;

    public AuthState()
    {
        state = AuthProtocolState.UNCHALLENGED;
    }

    public Queue getAuthOptions()
    {
        return authOptions;
    }

    public AuthScheme getAuthScheme()
    {
        return authScheme;
    }

    public AuthScope getAuthScope()
    {
        return authScope;
    }

    public Credentials getCredentials()
    {
        return credentials;
    }

    public AuthProtocolState getState()
    {
        return state;
    }

    public boolean hasAuthOptions()
    {
        return authOptions != null && !authOptions.isEmpty();
    }

    public void invalidate()
    {
        reset();
    }

    public boolean isValid()
    {
        return authScheme != null;
    }

    public void reset()
    {
        state = AuthProtocolState.UNCHALLENGED;
        authOptions = null;
        authScheme = null;
        authScope = null;
        credentials = null;
    }

    public void setAuthScheme(AuthScheme authscheme)
    {
        if (authscheme == null)
        {
            reset();
            return;
        } else
        {
            authScheme = authscheme;
            return;
        }
    }

    public void setAuthScope(AuthScope authscope)
    {
        authScope = authscope;
    }

    public void setCredentials(Credentials credentials1)
    {
        credentials = credentials1;
    }

    public void setState(AuthProtocolState authprotocolstate)
    {
        if (authprotocolstate == null)
        {
            authprotocolstate = AuthProtocolState.UNCHALLENGED;
        }
        state = authprotocolstate;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("state:").append(state).append(";");
        if (authScheme != null)
        {
            stringbuilder.append("auth scheme:").append(authScheme.getSchemeName()).append(";");
        }
        if (credentials != null)
        {
            stringbuilder.append("credentials present");
        }
        return stringbuilder.toString();
    }

    public void update(AuthScheme authscheme, Credentials credentials1)
    {
        Args.notNull(authscheme, "Auth scheme");
        Args.notNull(credentials1, "Credentials");
        authScheme = authscheme;
        credentials = credentials1;
        authOptions = null;
    }

    public void update(Queue queue)
    {
        Args.notEmpty(queue, "Queue of auth options");
        authOptions = queue;
        authScheme = null;
        credentials = null;
    }
}
