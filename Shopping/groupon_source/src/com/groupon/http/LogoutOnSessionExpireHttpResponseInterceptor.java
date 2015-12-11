// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import com.groupon.service.LoginService;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;
import java.io.IOException;
import roboguice.util.Ln;

public class LogoutOnSessionExpireHttpResponseInterceptor
    implements Interceptor
{

    private LoginService loginService;

    public LogoutOnSessionExpireHttpResponseInterceptor()
    {
    }

    public Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
        throws IOException
    {
        chain = chain.proceed(chain.request());
        if (chain.code() == 401 && loginService.isLoggedIn())
        {
            Ln.e("Session has expired.  This shouldn't happen.  Forcing logout and hoping for the best", new Object[0]);
            loginService.clearAuthToken();
        }
        return chain;
    }
}
