// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzkp
{

    private final String zzYi;
    private final int zzYj;
    private final String zzYk;

    public zzkp(String s, int i, String s1)
    {
        zzYi = s;
        zzYj = i;
        zzYk = s1;
    }

    public zzkp(JSONObject jsonobject)
        throws JSONException
    {
        this(jsonobject.optString("applicationName"), jsonobject.optInt("maxPlayers"), jsonobject.optString("version"));
    }

    public final int getMaxPlayers()
    {
        return zzYj;
    }

    public final String getVersion()
    {
        return zzYk;
    }

    public final String zzmH()
    {
        return zzYi;
    }
}
