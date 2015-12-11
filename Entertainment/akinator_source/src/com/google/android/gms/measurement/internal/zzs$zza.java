// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzs

public final class zzaNp
{

    private final long zzaNp;
    private boolean zzaNq;
    final zzs zzaNr;
    private long zzavc;
    private final String zzue;

    private void zzzX()
    {
        if (zzaNq)
        {
            return;
        } else
        {
            zzaNq = true;
            zzavc = zzs.zza(zzaNr).getLong(zzue, zzaNp);
            return;
        }
    }

    public long get()
    {
        zzzX();
        return zzavc;
    }

    public void set(long l)
    {
        android.content.eferences.Editor editor = zzs.zza(zzaNr).edit();
        editor.putLong(zzue, l);
        editor.apply();
        zzavc = l;
    }

    public _cls9(zzs zzs1, String s, long l)
    {
        zzaNr = zzs1;
        super();
        zzx.zzcr(s);
        zzue = s;
        zzaNp = l;
    }
}
