// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

public final class zzax
{

    private final String zzqS;
    private final JSONObject zzqT;
    private final String zzqU;
    private final String zzqV;
    private final boolean zzqW;

    public zzax(String s, VersionInfoParcel versioninfoparcel, String s1, JSONObject jsonobject, boolean flag)
    {
        zzqV = versioninfoparcel.zzJu;
        zzqT = jsonobject;
        zzqU = s;
        zzqS = s1;
        zzqW = flag;
    }

    public final String zzbU()
    {
        return zzqS;
    }

    public final String zzbV()
    {
        return zzqV;
    }

    public final JSONObject zzbW()
    {
        return zzqT;
    }

    public final String zzbX()
    {
        return zzqU;
    }

    public final boolean zzbY()
    {
        return zzqW;
    }
}
