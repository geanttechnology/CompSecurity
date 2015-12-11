// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmm;
import com.google.android.gms.internal.zzmr;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.stats:
//            zzd, WakeLockEvent

public class zzi
{

    private static String TAG = "WakeLockTracker";
    private static Integer zzahE;
    private static zzi zzaii = new zzi();

    public zzi()
    {
    }

    private static int getLogLevel()
    {
        int i;
        try
        {
            if (zzmm.zzjA())
            {
                return ((Integer)zzc.zzb.zzahH.get()).intValue();
            }
            i = zzd.LOG_LEVEL_OFF;
        }
        catch (SecurityException securityexception)
        {
            return zzd.LOG_LEVEL_OFF;
        }
        return i;
    }

    private static boolean zzam(Context context)
    {
        if (zzahE == null)
        {
            zzahE = Integer.valueOf(getLogLevel());
        }
        return zzahE.intValue() != zzd.LOG_LEVEL_OFF;
    }

    public static zzi zzqr()
    {
        return zzaii;
    }

    public void zza(Context context, String s, int i, String s1, String s2, int j, List list)
    {
        zza(context, s, i, s1, s2, j, list, 0L);
    }

    public void zza(Context context, String s, int i, String s1, String s2, int j, List list, 
            long l)
    {
        if (zzam(context))
        {
            if (TextUtils.isEmpty(s))
            {
                Log.e(TAG, (new StringBuilder("missing wakeLock key. ")).append(s).toString());
                return;
            }
            long l1 = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i)
            {
                s = new WakeLockEvent(l1, i, s1, j, list, s, SystemClock.elapsedRealtime(), zzmr.zzao(context), s2, context.getPackageName(), zzmr.zzap(context), l);
                try
                {
                    context.startService((new Intent()).setComponent(zzd.zzahN).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", s));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.wtf(TAG, context);
                }
                return;
            }
        }
    }

}
