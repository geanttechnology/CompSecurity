// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzg;
import com.google.android.gms.common.stats.zzi;

// Referenced classes of package com.google.android.gms.internal:
//            zznc, zznb, zzlr, zzmx

public class zzqy
{

    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private final Context mContext;
    private final android.os.PowerManager.WakeLock zzaVs;
    private WorkSource zzaVt;
    private final int zzaVu;
    private final String zzaVv;
    private boolean zzaVw;
    private int zzaVx;
    private int zzaVy;
    private final String zzaia;

    public zzqy(Context context, int i, String s)
    {
        this(context, i, s, null, null);
    }

    public zzqy(Context context, int i, String s, String s1, String s2)
    {
        zzaVw = true;
        zzx.zzh(s, "Wake lock name can NOT be empty");
        zzaVu = i;
        zzaia = s;
        zzaVv = s1;
        mContext = context.getApplicationContext();
        zzaVs = ((PowerManager)context.getSystemService("power")).newWakeLock(i, s);
        if (zznc.zzar(mContext))
        {
            s = s2;
            if (zznb.zzcA(s2))
            {
                if (zzd.zzaeK && zzlr.isInitialized())
                {
                    Log.e(TAG, (new StringBuilder("callingPackage is not supposed to be empty for wakelock ")).append(zzaia).append("!").toString(), new IllegalArgumentException());
                    s = "com.google.android.gms";
                } else
                {
                    s = context.getPackageName();
                }
            }
            zzaVt = zznc.zzm(context, s);
            zzc(zzaVt);
        }
    }

    private void zzeu(String s)
    {
        String s1;
        boolean flag;
        flag = zzev(s);
        s1 = zzj(s, flag);
        if (DEBUG)
        {
            Log.d(TAG, (new StringBuilder("Release:\n mWakeLockName: ")).append(zzaia).append("\n mSecondaryName: ").append(zzaVv).append("\nmReferenceCounted: ").append(zzaVw).append("\nreason: ").append(s).append("\n mOpenEventCount").append(zzaVy).append("\nuseWithReason: ").append(flag).append("\ntrackingName: ").append(s1).toString());
        }
        this;
        JVM INSTR monitorenter ;
        int i;
        if (!zzaVw)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        i = zzaVx - 1;
        zzaVx = i;
        if (i == 0 || flag)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        if (zzaVw || zzaVy != 1)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        com.google.android.gms.common.stats.zzi.zzqr().zza(mContext, zzg.zza(zzaVs, s1), 8, zzaia, s1, zzaVu, zznc.zzb(zzaVt));
        zzaVy = zzaVy - 1;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    private boolean zzev(String s)
    {
        return !TextUtils.isEmpty(s) && !s.equals(zzaVv);
    }

    private void zzi(String s, long l)
    {
        String s1;
        boolean flag;
        flag = zzev(s);
        s1 = zzj(s, flag);
        if (DEBUG)
        {
            Log.d(TAG, (new StringBuilder("Acquire:\n mWakeLockName: ")).append(zzaia).append("\n mSecondaryName: ").append(zzaVv).append("\nmReferenceCounted: ").append(zzaVw).append("\nreason: ").append(s).append("\nmOpenEventCount").append(zzaVy).append("\nuseWithReason: ").append(flag).append("\ntrackingName: ").append(s1).append("\ntimeout: ").append(l).toString());
        }
        this;
        JVM INSTR monitorenter ;
        int i;
        if (!zzaVw)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        i = zzaVx;
        zzaVx = i + 1;
        if (i == 0 || flag)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        if (zzaVw || zzaVy != 0)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        com.google.android.gms.common.stats.zzi.zzqr().zza(mContext, zzg.zza(zzaVs, s1), 7, zzaia, s1, zzaVu, zznc.zzb(zzaVt), l);
        zzaVy = zzaVy + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    private String zzj(String s, boolean flag)
    {
        if (zzaVw)
        {
            if (flag)
            {
                return s;
            } else
            {
                return zzaVv;
            }
        } else
        {
            return zzaVv;
        }
    }

    public void acquire(long l)
    {
        if (!zzmx.zzqx() && zzaVw)
        {
            Log.wtf(TAG, (new StringBuilder("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ")).append(zzaia).toString());
        }
        zzi(null, l);
        zzaVs.acquire(l);
    }

    public boolean isHeld()
    {
        return zzaVs.isHeld();
    }

    public void release()
    {
        zzeu(null);
        zzaVs.release();
    }

    public void setReferenceCounted(boolean flag)
    {
        zzaVs.setReferenceCounted(flag);
        zzaVw = flag;
    }

    public void zzc(WorkSource worksource)
    {
        if (zznc.zzar(mContext) && worksource != null)
        {
            if (zzaVt != null)
            {
                zzaVt.add(worksource);
            } else
            {
                zzaVt = worksource;
            }
            zzaVs.setWorkSource(zzaVt);
        }
    }

}
