// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.CookieManager;
import com.amazon.android.webkit.AmazonCookieManager;

public class AndroidCookieManager extends AmazonCookieManager
{

    public AndroidCookieManager()
    {
    }

    public boolean acceptCookie()
    {
        return CookieManager.getInstance().acceptCookie();
    }

    public String getCookie(String s)
    {
        return CookieManager.getInstance().getCookie(s);
    }

    public boolean hasCookies()
    {
        return CookieManager.getInstance().hasCookies();
    }

    public void removeAllCookie()
    {
        CookieManager.getInstance().removeAllCookie();
    }

    public void removeExpiredCookie()
    {
        CookieManager.getInstance().removeExpiredCookie();
    }

    public void removeSessionCookie()
    {
        CookieManager.getInstance().removeSessionCookie();
    }

    public void setAcceptCookie(boolean flag)
    {
        CookieManager.getInstance().setAcceptCookie(flag);
    }

    public void setCookie(String s, String s1)
    {
        CookieManager.getInstance().setCookie(s, s1);
    }
}
