// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.app.Activity;

public final class BaiduAutoUpdateUtils extends Enum
{

    public static final BaiduAutoUpdateUtils a;
    private static final BaiduAutoUpdateUtils b[];

    private BaiduAutoUpdateUtils(String s, int i)
    {
        super(s, i);
    }

    public static BaiduAutoUpdateUtils valueOf(String s)
    {
        return (BaiduAutoUpdateUtils)Enum.valueOf(com/pf/common/utility/BaiduAutoUpdateUtils, s);
    }

    public static BaiduAutoUpdateUtils[] values()
    {
        return (BaiduAutoUpdateUtils[])b.clone();
    }

    public void a(Activity activity)
    {
    }

    static 
    {
        a = new BaiduAutoUpdateUtils("INSTANCE", 0);
        b = (new BaiduAutoUpdateUtils[] {
            a
        });
    }
}
