// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            zzbm

public class zzbh
{

    private final Object zzpd = new Object();
    private final int zzrN;
    private final int zzrO;
    private final int zzrP;
    private final zzbm zzrQ;
    private ArrayList zzrR;
    private int zzrS;
    private int zzrT;
    private int zzrU;
    private int zzrV;
    private String zzrW;

    public zzbh(int i, int j, int k, int l)
    {
        zzrR = new ArrayList();
        zzrS = 0;
        zzrT = 0;
        zzrU = 0;
        zzrW = "";
        zzrN = i;
        zzrO = j;
        zzrP = k;
        zzrQ = new zzbm(l);
    }

    private String zza(ArrayList arraylist, int i)
    {
        if (arraylist.isEmpty())
        {
            arraylist = "";
        } else
        {
            Object obj = new StringBuffer();
            arraylist = arraylist.iterator();
            do
            {
                if (!arraylist.hasNext())
                {
                    break;
                }
                ((StringBuffer) (obj)).append((String)arraylist.next());
                ((StringBuffer) (obj)).append(' ');
            } while (((StringBuffer) (obj)).length() <= i);
            ((StringBuffer) (obj)).deleteCharAt(((StringBuffer) (obj)).length() - 1);
            obj = ((StringBuffer) (obj)).toString();
            arraylist = ((ArrayList) (obj));
            if (((String) (obj)).length() >= i)
            {
                return ((String) (obj)).substring(0, i);
            }
        }
        return arraylist;
    }

    private void zzx(String s)
    {
        if (s == null || s.length() < zzrP)
        {
            return;
        }
        synchronized (zzpd)
        {
            zzrR.add(s);
            zzrS = zzrS + s.length();
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof zzbh)
        {
            if (obj == this)
            {
                return true;
            }
            obj = (zzbh)obj;
            if (((zzbh) (obj)).zzcm() != null && ((zzbh) (obj)).zzcm().equals(zzcm()))
            {
                return true;
            }
        }
        return false;
    }

    public int getScore()
    {
        return zzrV;
    }

    public int hashCode()
    {
        return zzcm().hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("ActivityContent fetchId: ").append(zzrT).append(" score:").append(zzrV).append(" total_length:").append(zzrS).append("\n text: ").append(zza(zzrR, 200)).append("\n signture: ").append(zzrW).toString();
    }

    int zza(int i, int j)
    {
        return zzrN * i + zzrO * j;
    }

    public boolean zzcl()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzrU == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String zzcm()
    {
        return zzrW;
    }

    public void zzcn()
    {
        synchronized (zzpd)
        {
            zzrV = zzrV - 100;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzco()
    {
        synchronized (zzpd)
        {
            zzrU = zzrU - 1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzcp()
    {
        synchronized (zzpd)
        {
            zzrU = zzrU + 1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzcq()
    {
        synchronized (zzpd)
        {
            int i = zza(zzrS, zzrT);
            if (i > zzrV)
            {
                zzrV = i;
                zzrW = zzrQ.zza(zzrR);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    int zzcr()
    {
        return zzrS;
    }

    public void zzg(int i)
    {
        zzrT = i;
    }

    public void zzv(String s)
    {
        zzx(s);
        synchronized (zzpd)
        {
            if (zzrU < 0)
            {
                zzb.zzaF("ActivityContent: negative number of WebViews.");
            }
            zzcq();
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzw(String s)
    {
        zzx(s);
    }
}
