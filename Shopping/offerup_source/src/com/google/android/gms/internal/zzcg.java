// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzce, zzmn, zzhu, zzca, 
//            zzcd

public class zzcg
{

    private final Object zzpd = new Object();
    boolean zzvA;
    private final List zzvR = new LinkedList();
    private final Map zzvS = new LinkedHashMap();
    private String zzvT;
    private zzce zzvU;
    private zzcg zzvV;

    public zzcg(boolean flag, String s, String s1)
    {
        zzvA = flag;
        zzvS.put("action", s);
        zzvS.put("ad_format", s1);
    }

    public void zzT(String s)
    {
        if (!zzvA)
        {
            return;
        }
        synchronized (zzpd)
        {
            zzvT = s;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public transient boolean zza(zzce zzce1, long l, String as[])
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        int j = as.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        zzce zzce2 = new zzce(l, as[i], zzce1);
        zzvR.add(zzce2);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        JVM INSTR monitorexit ;
        return true;
        zzce1;
        obj;
        JVM INSTR monitorexit ;
        throw zzce1;
    }

    public transient boolean zza(zzce zzce1, String as[])
    {
        if (!zzvA || zzce1 == null)
        {
            return false;
        } else
        {
            return zza(zzce1, zzp.zzbz().elapsedRealtime(), as);
        }
    }

    public zzce zzb(long l)
    {
        if (!zzvA)
        {
            return null;
        } else
        {
            return new zzce(l, null, null);
        }
    }

    public void zzc(zzcg zzcg1)
    {
        synchronized (zzpd)
        {
            zzvV = zzcg1;
        }
        return;
        zzcg1;
        obj;
        JVM INSTR monitorexit ;
        throw zzcg1;
    }

    public zzce zzdn()
    {
        return zzb(zzp.zzbz().elapsedRealtime());
    }

    public void zzdo()
    {
        synchronized (zzpd)
        {
            zzvU = zzdn();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String zzdp()
    {
        Object obj1 = new StringBuilder();
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = zzvR.iterator();
_L2:
        String s;
        zzce zzce1;
        long l;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_118;
            }
            zzce1 = (zzce)iterator.next();
            l = zzce1.getTime();
            s = zzce1.zzdk();
            zzce1 = zzce1.zzdl();
        } while (zzce1 == null || l <= 0L);
        long l1 = zzce1.getTime();
        ((StringBuilder) (obj1)).append(s).append('.').append(l - l1).append(',');
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        zzvR.clear();
        if (TextUtils.isEmpty(zzvT)) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj1)).append(zzvT);
_L6:
        obj1 = ((StringBuilder) (obj1)).toString();
        obj;
        JVM INSTR monitorexit ;
        return ((String) (obj1));
_L4:
        if (((StringBuilder) (obj1)).length() <= 0) goto _L6; else goto _L5
_L5:
        ((StringBuilder) (obj1)).setLength(((StringBuilder) (obj1)).length() - 1);
          goto _L6
    }

    public zzce zzdq()
    {
        zzce zzce1;
        synchronized (zzpd)
        {
            zzce1 = zzvU;
        }
        return zzce1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zze(String s, String s1)
    {
        zzca zzca1;
        while (!zzvA || TextUtils.isEmpty(s1) || (zzca1 = zzp.zzby().zzgo()) == null) 
        {
            return;
        }
        synchronized (zzpd)
        {
            zzca1.zzR(s).zza(zzvS, s, s1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    Map zzn()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = zzp.zzby().zzgo();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        if (zzvV != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        obj1 = zzvS;
        obj;
        JVM INSTR monitorexit ;
        return ((Map) (obj1));
        obj1 = ((zzca) (obj1)).zza(zzvS, zzvV.zzn());
        obj;
        JVM INSTR monitorexit ;
        return ((Map) (obj1));
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
