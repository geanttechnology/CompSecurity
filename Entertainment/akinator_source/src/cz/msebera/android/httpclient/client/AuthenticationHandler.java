// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Map;

public interface AuthenticationHandler
{

    public abstract Map getChallenges(HttpResponse httpresponse, HttpContext httpcontext)
        throws MalformedChallengeException;

    public abstract boolean isAuthenticationRequested(HttpResponse httpresponse, HttpContext httpcontext);

    public abstract AuthScheme selectScheme(Map map, HttpResponse httpresponse, HttpContext httpcontext)
        throws AuthenticationException;
}
