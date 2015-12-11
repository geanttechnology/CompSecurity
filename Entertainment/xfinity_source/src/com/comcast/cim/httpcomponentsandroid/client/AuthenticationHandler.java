// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client;

import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.auth.AuthScheme;
import com.comcast.cim.httpcomponentsandroid.auth.AuthenticationException;
import com.comcast.cim.httpcomponentsandroid.auth.MalformedChallengeException;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.util.Map;

public interface AuthenticationHandler
{

    public abstract Map getChallenges(HttpResponse httpresponse, HttpContext httpcontext)
        throws MalformedChallengeException;

    public abstract boolean isAuthenticationRequested(HttpResponse httpresponse, HttpContext httpcontext);

    public abstract AuthScheme selectScheme(Map map, HttpResponse httpresponse, HttpContext httpcontext)
        throws AuthenticationException;
}
