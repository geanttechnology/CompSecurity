// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmy;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzf, zzaf, zzy, zzm, 
//            zzo

public class zzr
{

    private final zzf zzLf;
    private volatile Boolean zzNT;
    private String zzNU;
    private Set zzNV;

    protected zzr(zzf zzf1)
    {
        zzx.zzw(zzf1);
        zzLf = zzf1;
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
        obj = zzLf.getContext().getApplicationInfo();
        s = zzmy.zzj(zzLf.getContext(), Process.myPid());
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
        if ((zzNT == null || !zzNT.booleanValue()) && "com.google.android.gms.analytics".equals(s))
        {
            zzNT = Boolean.TRUE;
        }
        if (zzNT == null)
        {
            zzNT = Boolean.TRUE;
            zzLf.zziu().zzbe("My process not in the list of running processes");
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

    public boolean zzjC()
    {
        return ((Boolean)zzy.zzOf.get()).booleanValue();
    }

    public int zzjD()
    {
        return ((Integer)zzy.zzOy.get()).intValue();
    }

    public int zzjE()
    {
        return ((Integer)zzy.zzOC.get()).intValue();
    }

    public int zzjF()
    {
        return ((Integer)zzy.zzOD.get()).intValue();
    }

    public int zzjG()
    {
        return ((Integer)zzy.zzOE.get()).intValue();
    }

    public long zzjH()
    {
        return ((Long)zzy.zzOn.get()).longValue();
    }

    public long zzjI()
    {
        return ((Long)zzy.zzOm.get()).longValue();
    }

    public long zzjJ()
    {
        return ((Long)zzy.zzOq.get()).longValue();
    }

    public long zzjK()
    {
        return ((Long)zzy.zzOr.get()).longValue();
    }

    public int zzjL()
    {
        return ((Integer)zzy.zzOs.get()).intValue();
    }

    public int zzjM()
    {
        return ((Integer)zzy.zzOt.get()).intValue();
    }

    public long zzjN()
    {
        return (long)((Integer)zzy.zzOG.get()).intValue();
    }

    public String zzjO()
    {
        return (String)zzy.zzOv.get();
    }

    public String zzjP()
    {
        return (String)zzy.zzOu.get();
    }

    public String zzjQ()
    {
        return (String)zzy.zzOw.get();
    }

    public String zzjR()
    {
        return (String)zzy.zzOx.get();
    }

    public zzm zzjS()
    {
        return zzm.zzbj((String)zzy.zzOz.get());
    }

    public zzo zzjT()
    {
        return zzo.zzbk((String)zzy.zzOA.get());
    }

    public Set zzjU()
    {
        String s = (String)zzy.zzOF.get();
        if (zzNV == null || zzNU == null || !zzNU.equals(s))
        {
            String as[] = TextUtils.split(s, ",");
            HashSet hashset = new HashSet();
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String s1 = as[i];
                try
                {
                    hashset.add(Integer.valueOf(Integer.parseInt(s1)));
                }
                catch (NumberFormatException numberformatexception) { }
                i++;
            }
            zzNU = s;
            zzNV = hashset;
        }
        return zzNV;
    }

    public long zzjV()
    {
        return ((Long)zzy.zzOO.get()).longValue();
    }

    public long zzjW()
    {
        return ((Long)zzy.zzOP.get()).longValue();
    }

    public long zzjX()
    {
        return ((Long)zzy.zzOS.get()).longValue();
    }

    public int zzjY()
    {
        return ((Integer)zzy.zzOj.get()).intValue();
    }

    public int zzjZ()
    {
        return ((Integer)zzy.zzOl.get()).intValue();
    }

    public String zzka()
    {
        return "google_analytics_v4.db";
    }

    public String zzkb()
    {
        return "google_analytics2_v4.db";
    }

    public long zzkc()
    {
        return 0x5265c00L;
    }

    public int zzkd()
    {
        return ((Integer)zzy.zzOI.get()).intValue();
    }

    public int zzke()
    {
        return ((Integer)zzy.zzOJ.get()).intValue();
    }

    public long zzkf()
    {
        return ((Long)zzy.zzOK.get()).longValue();
    }

    public long zzkg()
    {
        return ((Long)zzy.zzOT.get()).longValue();
    }
}
