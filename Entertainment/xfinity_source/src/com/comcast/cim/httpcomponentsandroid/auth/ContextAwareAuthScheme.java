// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.auth;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.auth:
//            AuthScheme, AuthenticationException, Credentials

public interface ContextAwareAuthScheme
    extends AuthScheme
{

    public abstract Header authenticate(Credentials credentials, HttpRequest httprequest, HttpContext httpcontext)
        throws AuthenticationException;
}
