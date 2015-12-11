// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.internal:
//            zzhu, zzhv

public class zzht
{
    private static final class zza
    {

        private long zzHN;
        private long zzHO;

        public Bundle toBundle()
        {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", zzHN);
            bundle.putLong("tclose", zzHO);
            return bundle;
        }

        public long zzgi()
        {
            return zzHO;
        }

        public void zzgj()
        {
            zzHO = SystemClock.elapsedRealtime();
        }

        public void zzgk()
        {
            zzHN = SystemClock.elapsedRealtime();
        }

        public zza()
        {
            zzHN = -1L;
            zzHO = -1L;
        }
    }


    private boolean zzGb;
    private final LinkedList zzHE;
    private final String zzHF;
    private final String zzHG;
    private long zzHH;
    private long zzHI;
    private long zzHJ;
    private long zzHK;
    private long zzHL;
    private long zzHM;
    private final zzhu zzpV;
    private final Object zzpd;

    public zzht(zzhu zzhu1, String s, String s1)
    {
        zzpd = new Object();
        zzHH = -1L;
        zzHI = -1L;
        zzGb = false;
        zzHJ = -1L;
        zzHK = 0L;
        zzHL = -1L;
        zzHM = -1L;
        zzpV = zzhu1;
        zzHF = s;
        zzHG = s1;
        zzHE = new LinkedList();
    }

    public zzht(String s, String s1)
    {
        this(zzp.zzby(), s, s1);
    }

    public Bundle toBundle()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        ArrayList arraylist;
        obj1 = new Bundle();
        ((Bundle) (obj1)).putString("seq_num", zzHF);
        ((Bundle) (obj1)).putString("slotid", zzHG);
        ((Bundle) (obj1)).putBoolean("ismediation", zzGb);
        ((Bundle) (obj1)).putLong("treq", zzHL);
        ((Bundle) (obj1)).putLong("tresponse", zzHM);
        ((Bundle) (obj1)).putLong("timp", zzHI);
        ((Bundle) (obj1)).putLong("tload", zzHJ);
        ((Bundle) (obj1)).putLong("pcc", zzHK);
        ((Bundle) (obj1)).putLong("tfetch", zzHH);
        arraylist = new ArrayList();
        for (Iterator iterator = zzHE.iterator(); iterator.hasNext(); arraylist.add(((zza)iterator.next()).toBundle())) { }
        break MISSING_BLOCK_LABEL_158;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        ((Bundle) (obj1)).putParcelableArrayList("tclick", arraylist);
        obj;
        JVM INSTR monitorexit ;
        return ((Bundle) (obj1));
    }

    public void zzgf()
    {
        synchronized (zzpd)
        {
            if (zzHM != -1L && zzHI == -1L)
            {
                zzHI = SystemClock.elapsedRealtime();
                zzpV.zza(this);
            }
            zzpV.zzgn().zzgf();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzgg()
    {
        synchronized (zzpd)
        {
            if (zzHM != -1L)
            {
                zza zza1 = new zza();
                zza1.zzgk();
                zzHE.add(zza1);
                zzHK = zzHK + 1L;
                zzpV.zzgn().zzgg();
                zzpV.zza(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzgh()
    {
        synchronized (zzpd)
        {
            if (zzHM != -1L && !zzHE.isEmpty())
            {
                zza zza1 = (zza)zzHE.getLast();
                if (zza1.zzgi() == -1L)
                {
                    zza1.zzgj();
                    zzpV.zza(this);
                }
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzi(AdRequestParcel adrequestparcel)
    {
        synchronized (zzpd)
        {
            zzHL = SystemClock.elapsedRealtime();
            zzpV.zzgn().zzb(adrequestparcel, zzHL);
        }
        return;
        adrequestparcel;
        obj;
        JVM INSTR monitorexit ;
        throw adrequestparcel;
    }

    public void zzl(long l)
    {
        synchronized (zzpd)
        {
            zzHM = l;
            if (zzHM != -1L)
            {
                zzpV.zza(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzm(long l)
    {
        synchronized (zzpd)
        {
            if (zzHM != -1L)
            {
                zzHH = l;
                zzpV.zza(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzy(boolean flag)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzHM == -1L)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        zzHJ = SystemClock.elapsedRealtime();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        zzHI = zzHJ;
        zzpV.zza(this);
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzz(boolean flag)
    {
        synchronized (zzpd)
        {
            if (zzHM != -1L)
            {
                zzGb = flag;
                zzpV.zza(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
