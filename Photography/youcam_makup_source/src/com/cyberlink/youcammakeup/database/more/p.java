// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.provider.BaseColumns;

public abstract class p
    implements BaseColumns
{

    public static String[] a()
    {
        return (new String[] {
            "GUID", "PatternType", "Name", "ThumbPath", "Source", "SupportMode", "Version", "ColorImagePath", "ToolImagePath", "IsNew", 
            "SkuGUID", "ExtraData", "ExtStr1", "ExtStr2", "ExtStr3", "ExtInt1", "ExtInt2", "ExtInt3"
        });
    }
}
