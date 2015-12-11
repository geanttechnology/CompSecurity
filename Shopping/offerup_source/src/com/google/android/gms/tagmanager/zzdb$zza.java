// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzdb, DataLayer

final class zzaZD
    implements Runnable
{

    private final long zzaEE;
    private final String zzaZB;
    private final String zzaZC;
    private final long zzaZD;
    private long zzaZE;
    final zzdb zzaZF;
    private final long zzzB = System.currentTimeMillis();

    public final void run()
    {
        if (zzaZD > 0L && zzaZE >= zzaZD)
        {
            if (!"0".equals(zzaZC))
            {
                zzdb.zza(zzaZF).remove(zzaZC);
            }
            return;
        }
        zzaZE = zzaZE + 1L;
        if (zzcu())
        {
            long l = System.currentTimeMillis();
            zzdb.zzb(zzaZF).push(DataLayer.mapOf(new Object[] {
                "event", zzaZB, "gtm.timerInterval", String.valueOf(zzaEE), "gtm.timerLimit", String.valueOf(zzaZD), "gtm.timerStartTime", String.valueOf(zzzB), "gtm.timerCurrentTime", String.valueOf(l), 
                "gtm.timerElapsedTime", String.valueOf(l - zzzB), "gtm.timerEventNumber", String.valueOf(zzaZE), "gtm.triggers", zzaZC
            }));
        }
        zzdb.zzc(zzaZF).postDelayed(this, zzaEE);
    }

    protected final boolean zzcu()
    {
        if (zzdb.zzd(zzaZF))
        {
            return zzdb.zze(zzaZF);
        }
        Object obj = (ActivityManager)zzdb.zzf(zzaZF).getSystemService("activity");
        KeyguardManager keyguardmanager = (KeyguardManager)zzdb.zzf(zzaZF).getSystemService("keyguard");
        PowerManager powermanager = (PowerManager)zzdb.zzf(zzaZF).getSystemService("power");
        for (obj = ((ActivityManager) (obj)).getRunningAppProcesses().iterator(); ((Iterator) (obj)).hasNext();)
        {
            android.app.anager.RunningAppProcessInfo runningappprocessinfo = (android.app.anager.RunningAppProcessInfo)((Iterator) (obj)).next();
            if (Process.myPid() == runningappprocessinfo.pid && runningappprocessinfo.importance == 100 && !keyguardmanager.inKeyguardRestrictedInputMode() && powermanager.isScreenOn())
            {
                return true;
            }
        }

        return false;
    }

    ssInfo(zzdb zzdb1, String s, String s1, long l, long l1)
    {
        zzaZF = zzdb1;
        super();
        zzaZB = s;
        zzaZC = s1;
        zzaEE = l;
        zzaZD = l1;
    }
}
