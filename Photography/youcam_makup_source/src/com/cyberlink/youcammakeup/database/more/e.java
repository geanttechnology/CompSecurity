// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.provider.BaseColumns;

public abstract class e
    implements BaseColumns
{

    public static String[] a()
    {
        return (new String[] {
            "GUID", "PresetGUID", "PatternGUID", "EffectType", "ColorCount", "ColorSetGUID", "Intensity", "ListOrder", "ExtraData", "Ext_1", 
            "Ext_2"
        });
    }
}
