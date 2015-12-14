// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import java.util.List;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            MAPCookieManager

private static class mShouldReturn
{

    private final List mCookies;
    private final boolean mShouldReturn;

    public List getCookies()
    {
        return mCookies;
    }

    public boolean shouldReturnCookies()
    {
        return mShouldReturn;
    }

    (List list, boolean flag)
    {
        mCookies = list;
        mShouldReturn = flag;
    }
}
