// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import android.support.v7.lk;
import android.support.v7.ll;
import android.support.v7.nz;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zza, zzh

public class zzd extends android.support.v7.od.a
    implements zzh.zza
{

    private final Bundle mExtras;
    private final Object zzpc = new Object();
    private final String zzvK;
    private final List zzvL;
    private final String zzvM;
    private final nz zzvN;
    private final String zzvO;
    private final double zzvP;
    private final String zzvQ;
    private final String zzvR;
    private final zza zzvS;
    private zzh zzvT;

    public zzd(String s, List list, String s1, nz nz, String s2, double d, 
            String s3, String s4, zza zza1, Bundle bundle)
    {
        zzvK = s;
        zzvL = list;
        zzvM = s1;
        zzvN = nz;
        zzvO = s2;
        zzvP = d;
        zzvQ = s3;
        zzvR = s4;
        zzvS = zza1;
        mExtras = bundle;
    }

    public String getBody()
    {
        return zzvM;
    }

    public String getCallToAction()
    {
        return zzvO;
    }

    public String getCustomTemplateId()
    {
        return "";
    }

    public Bundle getExtras()
    {
        return mExtras;
    }

    public String getHeadline()
    {
        return zzvK;
    }

    public List getImages()
    {
        return zzvL;
    }

    public String getPrice()
    {
        return zzvR;
    }

    public double getStarRating()
    {
        return zzvP;
    }

    public String getStore()
    {
        return zzvQ;
    }

    public void zza(zzh zzh)
    {
        synchronized (zzpc)
        {
            zzvT = zzh;
        }
        return;
        zzh;
        obj;
        JVM INSTR monitorexit ;
        throw zzh;
    }

    public nz zzds()
    {
        return zzvN;
    }

    public lk zzdt()
    {
        return ll.a(zzvT);
    }

    public String zzdu()
    {
        return "2";
    }

    public zza zzdv()
    {
        return zzvS;
    }
}
