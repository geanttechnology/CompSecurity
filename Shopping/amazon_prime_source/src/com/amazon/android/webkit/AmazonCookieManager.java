// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebKitFactories, AmazonWebKitFactory

public abstract class AmazonCookieManager
{

    public AmazonCookieManager()
    {
    }

    public static AmazonCookieManager getInstance()
    {
        return AmazonWebKitFactories.getDefaultFactory().getCookieManager();
    }

    public abstract boolean acceptCookie();

    public abstract String getCookie(String s);

    public abstract boolean hasCookies();

    public abstract void removeAllCookie();

    public abstract void removeExpiredCookie();

    public abstract void removeSessionCookie();

    public abstract void setAcceptCookie(boolean flag);

    public abstract void setCookie(String s, String s1);
}
