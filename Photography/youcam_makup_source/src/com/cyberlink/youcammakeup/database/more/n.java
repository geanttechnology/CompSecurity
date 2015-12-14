// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.provider.BaseColumns;

public abstract class n
    implements BaseColumns
{

    public static String[] a()
    {
        return (new String[] {
            "palette_guid", "style_guid", "inner_ratio", "feather_strength", "intensity"
        });
    }
}
