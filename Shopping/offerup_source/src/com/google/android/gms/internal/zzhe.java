// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public class zzhe extends com.google.android.gms.ads.internal.reward.client.zza.zza
{

    private final int zzGV;
    private final String zzGq;

    public zzhe(String s, int i)
    {
        zzGq = s;
        zzGV = i;
    }

    public int getAmount()
    {
        return zzGV;
    }

    public String getType()
    {
        return zzGq;
    }
}
