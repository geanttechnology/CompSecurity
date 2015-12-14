// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

public abstract class CustomRedirectHandler
    implements RedirectHandler
{

    private static final int MAX_REDIRECT_COUNT = 15;
    private static final String TAG = com/sina/weibo/sdk/net/CustomRedirectHandler.getCanonicalName();
    int redirectCount;
    String redirectUrl;
    private String tempRedirectUrl;

    public CustomRedirectHandler()
    {
    }

    public URI getLocationURI(HttpResponse httpresponse, HttpContext httpcontext)
    {
        LogUtil.d(TAG, (new StringBuilder("CustomRedirectHandler getLocationURI getRedirectUrl : ")).append(tempRedirectUrl).toString());
        if (!TextUtils.isEmpty(tempRedirectUrl))
        {
            return URI.create(tempRedirectUrl);
        } else
        {
            return null;
        }
    }

    public int getRedirectCount()
    {
        return redirectCount;
    }

    public String getRedirectUrl()
    {
        return redirectUrl;
    }

    public boolean isRedirectRequested(HttpResponse httpresponse, HttpContext httpcontext)
    {
        int i = httpresponse.getStatusLine().getStatusCode();
        if (i == 301 || i == 302)
        {
            tempRedirectUrl = httpresponse.getFirstHeader("Location").getValue();
            if (!TextUtils.isEmpty(tempRedirectUrl) && redirectCount < 15 && shouldRedirectUrl(tempRedirectUrl))
            {
                redirectCount = redirectCount + 1;
                return true;
            }
        } else
        if (i == 200)
        {
            redirectUrl = tempRedirectUrl;
        } else
        {
            onReceivedException();
        }
        return false;
    }

    public abstract void onReceivedException();

    public abstract boolean shouldRedirectUrl(String s);

}
