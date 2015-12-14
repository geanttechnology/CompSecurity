// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.Context;

public class bc
{

    final Context a;

    public bc(Context context)
    {
        a = context;
    }

    public Boolean a()
    {
        if (!Boolean.parseBoolean(a.getString(0x7f070737)))
        {
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(true);
        }
    }
}
