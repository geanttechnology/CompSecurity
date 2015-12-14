// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

class zzwq
{

    private final String zzwq;
    private final String zzxF;
    private final int zzxM;
    private final List zzxN;

    public String getBody()
    {
        return zzwq;
    }

    public int getResponseCode()
    {
        return zzxM;
    }

    public String zzdE()
    {
        return zzxF;
    }

    public Iterable zzdJ()
    {
        return zzxN;
    }

    public (String s, int i, List list, String s1)
    {
        zzxF = s;
        zzxM = i;
        if (list == null)
        {
            zzxN = new ArrayList();
        } else
        {
            zzxN = list;
        }
        zzwq = s1;
    }
}
