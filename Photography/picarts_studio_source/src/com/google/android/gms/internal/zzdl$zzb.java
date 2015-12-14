// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.net.URL;
import java.util.ArrayList;

class zzxI
{

    private final String zzxF;
    private final URL zzxG;
    private final ArrayList zzxH;
    private final String zzxI;

    public String zzdE()
    {
        return zzxF;
    }

    public URL zzdF()
    {
        return zzxG;
    }

    public ArrayList zzdG()
    {
        return zzxH;
    }

    public String zzdH()
    {
        return zzxI;
    }

    public (String s, URL url, ArrayList arraylist, String s1)
    {
        zzxF = s;
        zzxG = url;
        if (arraylist == null)
        {
            zzxH = new ArrayList();
        } else
        {
            zzxH = arraylist;
        }
        zzxI = s1;
    }
}
