// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import java.util.List;

public class zza
{

    private static final int zzwa;
    private static final int zzwb;
    static final int zzwc;
    static final int zzwd;
    private final int mTextColor;
    private final String zzwe;
    private final List zzwf;
    private final int zzwg;
    private final int zzwh;
    private final int zzwi;

    public zza(String s, List list, Integer integer, Integer integer1, Integer integer2, int i)
    {
        zzwe = s;
        zzwf = list;
        int j;
        if (integer != null)
        {
            j = integer.intValue();
        } else
        {
            j = zzwc;
        }
        zzwg = j;
        if (integer1 != null)
        {
            j = integer1.intValue();
        } else
        {
            j = zzwd;
        }
        mTextColor = j;
        if (integer2 != null)
        {
            j = integer2.intValue();
        } else
        {
            j = 12;
        }
        zzwh = j;
        zzwi = i;
    }

    public int getBackgroundColor()
    {
        return zzwg;
    }

    public String getText()
    {
        return zzwe;
    }

    public int getTextColor()
    {
        return mTextColor;
    }

    public int getTextSize()
    {
        return zzwh;
    }

    public List zzds()
    {
        return zzwf;
    }

    public int zzdt()
    {
        return zzwi;
    }

    static 
    {
        zzwa = Color.rgb(12, 174, 206);
        int i = Color.rgb(204, 204, 204);
        zzwb = i;
        zzwc = i;
        zzwd = zzwa;
    }
}
