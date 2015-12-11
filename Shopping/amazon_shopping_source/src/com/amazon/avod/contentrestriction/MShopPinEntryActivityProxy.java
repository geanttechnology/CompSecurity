// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.contentrestriction;

import com.amazon.avod.clickstream.PageInfo;
import com.amazon.avod.clickstream.PageInfoSource;
import com.amazon.mShop.android.platform.app.ProxyActivity;

public class MShopPinEntryActivityProxy extends ProxyActivity
    implements PageInfoSource
{

    public MShopPinEntryActivityProxy()
    {
    }

    public PageInfo getPageInfo()
    {
        return ((PageInfoSource)getActivityDelegate()).getPageInfo();
    }

    public String toString()
    {
        return String.format("%s@%x (%s)", new Object[] {
            getClass().getSimpleName(), Integer.valueOf(hashCode()), getPageInfo()
        });
    }
}
