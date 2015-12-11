// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;

// Referenced classes of package cz.msebera.android.httpclient.auth:
//            AuthScheme, AuthenticationException, Credentials

public interface ContextAwareAuthScheme
    extends AuthScheme
{

    public abstract Header authenticate(Credentials credentials, HttpRequest httprequest, HttpContext httpcontext)
        throws AuthenticationException;
}
