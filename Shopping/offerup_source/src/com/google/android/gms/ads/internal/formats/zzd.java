// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcm;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zza, zzh

public class zzd extends com.google.android.gms.internal.zzcq.zza
    implements zzh.zza
{

    private final Bundle mExtras;
    private final Object zzpd = new Object();
    private final String zzwo;
    private final List zzwp;
    private final String zzwq;
    private final zzcm zzwr;
    private final String zzws;
    private final double zzwt;
    private final String zzwu;
    private final String zzwv;
    private final zza zzww;
    private zzh zzwx;

    public zzd(String s, List list, String s1, zzcm zzcm, String s2, double d, 
            String s3, String s4, zza zza1, Bundle bundle)
    {
        zzwo = s;
        zzwp = list;
        zzwq = s1;
        zzwr = zzcm;
        zzws = s2;
        zzwt = d;
        zzwu = s3;
        zzwv = s4;
        zzww = zza1;
        mExtras = bundle;
    }

    public String getBody()
    {
        return zzwq;
    }

    public String getCallToAction()
    {
        return zzws;
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
        return zzwo;
    }

    public List getImages()
    {
        return zzwp;
    }

    public String getPrice()
    {
        return zzwv;
    }

    public double getStarRating()
    {
        return zzwt;
    }

    public String getStore()
    {
        return zzwu;
    }

    public void zza(zzh zzh)
    {
        synchronized (zzpd)
        {
            zzwx = zzh;
        }
        return;
        zzh;
        obj;
        JVM INSTR monitorexit ;
        throw zzh;
    }

    public zzcm zzdw()
    {
        return zzwr;
    }

    public com.google.android.gms.dynamic.zzd zzdx()
    {
        return zze.zzy(zzwx);
    }

    public String zzdy()
    {
        return "2";
    }

    public zza zzdz()
    {
        return zzww;
    }
}
