// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcm;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zza, zzh

public class zze extends com.google.android.gms.internal.zzcs.zza
    implements zzh.zza
{

    private final Bundle mExtras;
    private final Object zzpd = new Object();
    private final String zzwo;
    private final List zzwp;
    private final String zzwq;
    private final String zzws;
    private final zza zzww;
    private zzh zzwx;
    private final zzcm zzwy;
    private final String zzwz;

    public zze(String s, List list, String s1, zzcm zzcm, String s2, String s3, zza zza1, 
            Bundle bundle)
    {
        zzwo = s;
        zzwp = list;
        zzwq = s1;
        zzwy = zzcm;
        zzws = s2;
        zzwz = s3;
        zzww = zza1;
        mExtras = bundle;
    }

    public String getAdvertiser()
    {
        return zzwz;
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

    public zzcm zzdA()
    {
        return zzwy;
    }

    public zzd zzdx()
    {
        return com.google.android.gms.dynamic.zze.zzy(zzwx);
    }

    public String zzdy()
    {
        return "1";
    }

    public zza zzdz()
    {
        return zzww;
    }
}
