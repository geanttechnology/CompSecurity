// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.a.a.e;
import com.google.a.a.m;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzcx, zzcv, zzcs

public final class zzcq extends zzcr.zza
{

    private Map zzuY;

    public zzcq()
    {
    }

    private zzcs zzM(String s)
    {
        try
        {
            Object obj = Class.forName(s, false, com/google/android/gms/internal/zzcq.getClassLoader());
            if (com/google/a/a/e.isAssignableFrom(((Class) (obj))))
            {
                obj = (e)((Class) (obj)).newInstance();
                return new zzcx(((e) (obj)), (m)zzuY.get(((e) (obj)).b()));
            }
            if (com/google/android/gms/ads/mediation/MediationAdapter.isAssignableFrom(((Class) (obj))))
            {
                return new zzcv((MediationAdapter)((Class) (obj)).newInstance());
            } else
            {
                zzb.zzan((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        }
        catch (Throwable throwable)
        {
            zzb.zzan((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(". ").append(throwable.getMessage()).toString());
        }
        throw new RemoteException();
    }

    public zzcs zzK(String s)
    {
        return zzM(s);
    }

    public boolean zzL(String s)
    {
        boolean flag;
        try
        {
            flag = com/google/android/gms/ads/mediation/customevent/CustomEvent.isAssignableFrom(Class.forName(s, false, com/google/android/gms/internal/zzcq.getClassLoader()));
        }
        catch (Throwable throwable)
        {
            zzb.zzan((new StringBuilder()).append("Could not load custom event implementation class: ").append(s).append(", assuming old implementation.").toString());
            return false;
        }
        return flag;
    }

    public void zze(Map map)
    {
        zzuY = map;
    }
}
