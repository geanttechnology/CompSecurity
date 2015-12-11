// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;

// Referenced classes of package com.google.android.gms.internal:
//            zzqd

public class zzqc
    implements zzqd.zza
{

    private final zzqd zzaRC;
    private boolean zzaRD;

    public zzqc(Context context, int i)
    {
        this(context, i, null);
    }

    public zzqc(Context context, int i, String s)
    {
        this(context, i, s, null, true);
    }

    public zzqc(Context context, int i, String s, String s1, boolean flag)
    {
        String s2;
        if (context != context.getApplicationContext())
        {
            s2 = context.getClass().getName();
        } else
        {
            s2 = "OneTimePlayLogger";
        }
        zzaRC = new zzqd(context, i, s, s1, this, flag, s2);
        zzaRD = true;
    }

    private void zzBq()
    {
        if (!zzaRD)
        {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        } else
        {
            return;
        }
    }

    public void send()
    {
        zzBq();
        zzaRC.start();
        zzaRD = false;
    }

    public void zzBr()
    {
        zzaRC.stop();
    }

    public void zzBs()
    {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }

    public transient void zza(String s, byte abyte0[], String as[])
    {
        zzBq();
        zzaRC.zzb(s, abyte0, as);
    }

    public void zzf(PendingIntent pendingintent)
    {
        Log.w("OneTimePlayLogger", (new StringBuilder()).append("logger connection failed: ").append(pendingintent).toString());
    }
}
