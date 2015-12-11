// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmy;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzx, zzp, zzk, zzv, 
//            zzn, zzab, zzag, zzu, 
//            zzs

public class zzc extends zzx
{

    static final String zzaLT;
    private Boolean zzNT;

    zzc(zzv zzv)
    {
        super(zzv);
    }

    public volatile Context getContext()
    {
        return super.getContext();
    }

    public volatile void zzir()
    {
        super.zzir();
    }

    public volatile void zzis()
    {
        super.zzis();
    }

    public volatile zzmn zzit()
    {
        return super.zzit();
    }

    public boolean zzjA()
    {
        return zzd.zzaeK;
    }

    public boolean zzjB()
    {
        if (zzNT != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (zzNT != null) goto _L4; else goto _L3
_L3:
        String s;
        Object obj;
        obj = getContext().getApplicationInfo();
        s = zzmy.zzj(getContext(), Process.myPid());
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = ((ApplicationInfo) (obj)).processName;
        if (obj == null) goto _L8; else goto _L7
_L7:
        if (!((String) (obj)).equals(s)) goto _L8; else goto _L9
_L9:
        boolean flag = true;
_L11:
        zzNT = Boolean.valueOf(flag);
_L6:
        if (zzNT == null)
        {
            zzNT = Boolean.TRUE;
            zzyd().zzzK().zzec("My process not in the list of running processes");
        }
_L4:
        this;
        JVM INSTR monitorexit ;
_L2:
        return zzNT.booleanValue();
_L8:
        flag = false;
        if (true) goto _L11; else goto _L10
_L10:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    long zzjV()
    {
        return ((Long)zzk.zzaMC.get()).longValue();
    }

    public String zzka()
    {
        return "google_app_measurement.db";
    }

    public String zzkb()
    {
        return "google_app_measurement2.db";
    }

    public long zzkg()
    {
        return Math.max(0L, ((Long)zzk.zzaMr.get()).longValue());
    }

    String zzyS()
    {
        return (String)zzk.zzaMp.get();
    }

    public int zzyT()
    {
        return 24;
    }

    int zzyU()
    {
        return 36;
    }

    int zzyV()
    {
        return 36;
    }

    int zzyW()
    {
        return 20;
    }

    long zzyX()
    {
        return 0x36ee80L;
    }

    long zzyY()
    {
        return 60000L;
    }

    long zzyZ()
    {
        return 61000L;
    }

    public volatile zzp zzyd()
    {
        return super.zzyd();
    }

    long zzza()
    {
        return ((Long)zzk.zzaMq.get()).longValue();
    }

    public long zzzb()
    {
        return (long)(GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000);
    }

    public long zzzc()
    {
        return ((Long)zzk.zzaMB.get()).longValue();
    }

    public long zzzd()
    {
        return ((Long)zzk.zzaMx.get()).longValue();
    }

    public long zzze()
    {
        return 20L;
    }

    public int zzzf()
    {
        return ((Integer)zzk.zzaMs.get()).intValue();
    }

    public int zzzg()
    {
        return Math.max(0, ((Integer)zzk.zzaMt.get()).intValue());
    }

    public String zzzh()
    {
        return (String)zzk.zzaMu.get();
    }

    public long zzzi()
    {
        return Math.max(0L, ((Long)zzk.zzaMv.get()).longValue());
    }

    public long zzzj()
    {
        return Math.max(0L, ((Long)zzk.zzaMw.get()).longValue());
    }

    public long zzzk()
    {
        return Math.max(0L, ((Long)zzk.zzaMy.get()).longValue());
    }

    public long zzzl()
    {
        return Math.max(0L, ((Long)zzk.zzaMz.get()).longValue());
    }

    public int zzzm()
    {
        return Math.min(20, Math.max(0, ((Integer)zzk.zzaMA.get()).intValue()));
    }

    public volatile void zzzn()
    {
        super.zzzn();
    }

    public volatile zzn zzzo()
    {
        return super.zzzo();
    }

    public volatile zzab zzzp()
    {
        return super.zzzp();
    }

    public volatile zzag zzzq()
    {
        return super.zzzq();
    }

    public volatile zzu zzzr()
    {
        return super.zzzr();
    }

    public volatile zzs zzzs()
    {
        return super.zzzs();
    }

    public volatile zzc zzzt()
    {
        return super.zzzt();
    }

    static 
    {
        zzaLT = String.valueOf(GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    }
}
