// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.rest;

import android.content.Context;
import com.gimbal.internal.persistance.b;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public final class a
    implements ClientHttpRequestInterceptor
{

    private b a;

    public a(b b1)
    {
        a = b1;
    }

    public final ClientHttpResponse intercept(HttpRequest httprequest, byte abyte0[], ClientHttpRequestExecution clienthttprequestexecution)
    {
        String s1 = com.gimbal.internal.proximity.core.a.a.b.a.getPackageName();
        String s = a.b();
        Object obj = s;
        if (s == null)
        {
            obj = "NO_API_KEY_SET";
        }
        obj = new HttpBasicAuthentication(s1, ((String) (obj)));
        httprequest.getHeaders().setAuthorization(((org.springframework.http.HttpAuthentication) (obj)));
        return clienthttprequestexecution.execute(httprequest, abyte0);
    }
}
