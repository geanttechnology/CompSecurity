// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh
{

    private static final String zzPy[] = {
        "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"
    };
    private static final Map zzPz;

    public static String zzaj(int i)
    {
        if (i < 0 || i >= zzPy.length)
        {
            return null;
        } else
        {
            return zzPy[i];
        }
    }

    public static int zzbx(String s)
    {
        Integer integer = (Integer)zzPz.get(s);
        if (integer == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("[").append(s).append("] is not a valid global search section name").toString());
        } else
        {
            return integer.intValue();
        }
    }

    public static int zzlc()
    {
        return zzPy.length;
    }

    static 
    {
        int i = 0;
        zzPz = new HashMap(zzPy.length);
        for (; i < zzPy.length; i++)
        {
            zzPz.put(zzPy[i], Integer.valueOf(i));
        }

    }
}
