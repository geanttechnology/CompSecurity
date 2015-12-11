// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.playlog.internal.LogEvent;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import com.google.android.gms.playlog.internal.zzd;
import com.google.android.gms.playlog.internal.zzf;

public class zzqd
{

    private final zzf zzaRE;
    private PlayLoggerContext zzaRF;

    public zzqd(Context context, int i, String s, String s1, zza zza1, boolean flag, String s2)
    {
        String s3;
        int j;
        s3 = context.getPackageName();
        j = 0;
        int k = context.getPackageManager().getPackageInfo(s3, 0).versionCode;
        j = k;
_L2:
        zzaRF = new PlayLoggerContext(s3, j, i, s, s1, flag);
        zzaRE = new zzf(context, context.getMainLooper(), new zzd(zza1), new com.google.android.gms.common.internal.zzf(null, null, null, 49, null, s3, s2, null));
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.wtf("PlayLogger", "This can't happen.", namenotfoundexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void start()
    {
        zzaRE.start();
    }

    public void stop()
    {
        zzaRE.stop();
    }

    public transient void zza(long l, String s, byte abyte0[], String as[])
    {
        zzaRE.zzb(zzaRF, new LogEvent(l, 0L, s, abyte0, as));
    }

    public transient void zzb(String s, byte abyte0[], String as[])
    {
        zza(System.currentTimeMillis(), s, abyte0, as);
    }

    // Unreferenced inner class com/google/android/gms/internal/zzqd$zza
    /* block-local class not found */
    class zza {}

}
