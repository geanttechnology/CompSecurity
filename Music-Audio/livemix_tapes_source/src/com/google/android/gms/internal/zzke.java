// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzke
{

    private final String zzWq;
    private final int zzWr;
    private final String zzWs;

    public zzke(String s, int i, String s1)
    {
        zzWq = s;
        zzWr = i;
        zzWs = s1;
    }

    public zzke(JSONObject jsonobject)
        throws JSONException
    {
        this(jsonobject.optString("applicationName"), jsonobject.optInt("maxPlayers"), jsonobject.optString("version"));
    }

    public final int getMaxPlayers()
    {
        return zzWr;
    }

    public final String getVersion()
    {
        return zzWs;
    }

    public final String zzml()
    {
        return zzWq;
    }
}
