// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import java.util.List;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            MAPCookieManager

private static class mResponseUrl
{

    private final List mCookies;
    private final String mResponseUrl;

    public List getCookies()
    {
        return mCookies;
    }

    public String getResponseUrl()
    {
        return mResponseUrl;
    }

    public Y(List list, String s)
    {
        mCookies = list;
        mResponseUrl = s;
    }
}
