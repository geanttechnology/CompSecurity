// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.provider.BaseColumns;

public abstract class m
    implements BaseColumns
{

    public static String[] a()
    {
        return (new String[] {
            "GUID", "ColorSetGUID", "ColorCount", "Name", "Thumbnail", "Source", "Version", "PaletteOrder", "isNew", "SkuGUID", 
            "ExtraData", "Ext1", "Ext2", "Ext3", "Ext4", "Ext5"
        });
    }
}
