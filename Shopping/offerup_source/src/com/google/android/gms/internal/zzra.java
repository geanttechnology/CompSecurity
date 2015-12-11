// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzrc, zzmp, zzmn

public class zzra
{

    private final Context mContext;
    private String zzaWs;
    private final zzrc zzbak;
    Map zzbal;
    private final Map zzbam;
    private final zzmn zzpW;

    public zzra(Context context)
    {
        this(context, ((Map) (new HashMap())), new zzrc(context), zzmp.zzqt());
    }

    zzra(Context context, Map map, zzrc zzrc1, zzmn zzmn)
    {
        zzaWs = null;
        zzbal = new HashMap();
        mContext = context;
        zzpW = zzmn;
        zzbak = zzrc1;
        zzbam = map;
    }

    public void zzfm(String s)
    {
        zzaWs = s;
    }
}
