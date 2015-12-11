// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Map;
import java.util.Queue;

public interface AuthenticationStrategy
{

    public abstract void authFailed(HttpHost httphost, AuthScheme authscheme, HttpContext httpcontext);

    public abstract void authSucceeded(HttpHost httphost, AuthScheme authscheme, HttpContext httpcontext);

    public abstract Map getChallenges(HttpHost httphost, HttpResponse httpresponse, HttpContext httpcontext)
        throws MalformedChallengeException;

    public abstract boolean isAuthenticationRequested(HttpHost httphost, HttpResponse httpresponse, HttpContext httpcontext);

    public abstract Queue select(Map map, HttpHost httphost, HttpResponse httpresponse, HttpContext httpcontext)
        throws MalformedChallengeException;
}
