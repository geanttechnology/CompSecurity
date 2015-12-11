// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh
{

    private static final String zzQD[] = {
        "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"
    };
    private static final Map zzQE;

    public static String zzak(int i)
    {
        if (i < 0 || i >= zzQD.length)
        {
            return null;
        } else
        {
            return zzQD[i];
        }
    }

    public static int zzbz(String s)
    {
        Integer integer = (Integer)zzQE.get(s);
        if (integer == null)
        {
            throw new IllegalArgumentException((new StringBuilder("[")).append(s).append("] is not a valid global search section name").toString());
        } else
        {
            return integer.intValue();
        }
    }

    public static int zzls()
    {
        return zzQD.length;
    }

    static 
    {
        int i = 0;
        zzQE = new HashMap(zzQD.length);
        for (; i < zzQD.length; i++)
        {
            zzQE.put(zzQD[i], Integer.valueOf(i));
        }

    }
}
