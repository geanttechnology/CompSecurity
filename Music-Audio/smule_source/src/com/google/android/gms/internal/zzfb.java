// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.internal:
//            zzfc, zzfd

public class zzfb
{

    private boolean zzAI;
    private final LinkedList zzBA;
    private final String zzBB;
    private final String zzBC;
    private long zzBD;
    private long zzBE;
    private long zzBF;
    private long zzBG;
    private long zzBH;
    private long zzBI;
    private final zzfc zznQ;
    private final Object zzoe;

    public zzfb(zzfc zzfc1, String s, String s1)
    {
        zzoe = new Object();
        zzBD = -1L;
        zzBE = -1L;
        zzAI = false;
        zzBF = -1L;
        zzBG = 0L;
        zzBH = -1L;
        zzBI = -1L;
        zznQ = zzfc1;
        zzBB = s;
        zzBC = s1;
        zzBA = new LinkedList();
    }

    public zzfb(String s, String s1)
    {
        this(zzh.zzaT(), s, s1);
    }

    public Bundle toBundle()
    {
        Object obj = zzoe;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        ArrayList arraylist;
        obj1 = new Bundle();
        ((Bundle) (obj1)).putString("seq_num", zzBB);
        ((Bundle) (obj1)).putString("slotid", zzBC);
        ((Bundle) (obj1)).putBoolean("ismediation", zzAI);
        ((Bundle) (obj1)).putLong("treq", zzBH);
        ((Bundle) (obj1)).putLong("tresponse", zzBI);
        ((Bundle) (obj1)).putLong("timp", zzBE);
        ((Bundle) (obj1)).putLong("tload", zzBF);
        ((Bundle) (obj1)).putLong("pcc", zzBG);
        ((Bundle) (obj1)).putLong("tfetch", zzBD);
        arraylist = new ArrayList();
        for (Iterator iterator = zzBA.iterator(); iterator.hasNext(); arraylist.add(((zza)iterator.next()).toBundle())) { }
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

    public void zze(AdRequestParcel adrequestparcel)
    {
        synchronized (zzoe)
        {
            zzBH = SystemClock.elapsedRealtime();
            zznQ.zzeL().zzb(adrequestparcel, zzBH);
        }
        return;
        adrequestparcel;
        obj;
        JVM INSTR monitorexit ;
        throw adrequestparcel;
    }

    public void zzeD()
    {
        synchronized (zzoe)
        {
            if (zzBI != -1L && zzBE == -1L)
            {
                zzBE = SystemClock.elapsedRealtime();
                zznQ.zza(this);
            }
            zznQ.zzeL().zzeD();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzeE()
    {
        synchronized (zzoe)
        {
            if (zzBI != -1L)
            {
                zza zza1 = new zza();
                zza1.zzeI();
                zzBA.add(zza1);
                zzBG = zzBG + 1L;
                zznQ.zzeL().zzeE();
                zznQ.zza(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzeF()
    {
        synchronized (zzoe)
        {
            if (zzBI != -1L && !zzBA.isEmpty())
            {
                zza zza1 = (zza)zzBA.getLast();
                if (zza1.zzeG() == -1L)
                {
                    zza1.zzeH();
                    zznQ.zza(this);
                }
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzj(long l)
    {
        synchronized (zzoe)
        {
            zzBI = l;
            if (zzBI != -1L)
            {
                zznQ.zza(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzk(long l)
    {
        synchronized (zzoe)
        {
            if (zzBI != -1L)
            {
                zzBD = l;
                zznQ.zza(this);
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
        Object obj = zzoe;
        obj;
        JVM INSTR monitorenter ;
        if (zzBI == -1L)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        zzBF = SystemClock.elapsedRealtime();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        zzBE = zzBF;
        zznQ.zza(this);
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
        synchronized (zzoe)
        {
            if (zzBI != -1L)
            {
                zzAI = flag;
                zznQ.zza(this);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private class zza
    {

        private long zzBJ;
        private long zzBK;

        public Bundle toBundle()
        {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", zzBJ);
            bundle.putLong("tclose", zzBK);
            return bundle;
        }

        public long zzeG()
        {
            return zzBK;
        }

        public void zzeH()
        {
            zzBK = SystemClock.elapsedRealtime();
        }

        public void zzeI()
        {
            zzBJ = SystemClock.elapsedRealtime();
        }

        public zza()
        {
            zzBJ = -1L;
            zzBK = -1L;
        }
    }

}
