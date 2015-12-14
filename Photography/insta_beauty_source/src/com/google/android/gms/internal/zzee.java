// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import azd;
import azj;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzel, zzej, zzeg

public final class zzee extends zzef.zza
{

    private Map zzyd;

    public zzee()
    {
    }

    private zzeg zzaa(String s)
    {
        try
        {
            Object obj = Class.forName(s, false, com/google/android/gms/internal/zzee.getClassLoader());
            if (azd.isAssignableFrom(((Class) (obj))))
            {
                obj = (azd)((Class) (obj)).newInstance();
                return new zzel(((azd) (obj)), (azj)zzyd.get(((azd) (obj)).b()));
            }
            if (com/google/android/gms/ads/mediation/MediationAdapter.isAssignableFrom(((Class) (obj))))
            {
                return new zzej((MediationAdapter)((Class) (obj)).newInstance());
            } else
            {
                zzb.zzaC((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        }
        catch (Throwable throwable)
        {
            zzb.zzaC((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(". ").append(throwable.getMessage()).toString());
        }
        throw new RemoteException();
    }

    public zzeg zzY(String s)
    {
        return zzaa(s);
    }

    public boolean zzZ(String s)
    {
        boolean flag;
        try
        {
            flag = com/google/android/gms/ads/mediation/customevent/CustomEvent.isAssignableFrom(Class.forName(s, false, com/google/android/gms/internal/zzee.getClassLoader()));
        }
        catch (Throwable throwable)
        {
            zzb.zzaC((new StringBuilder()).append("Could not load custom event implementation class: ").append(s).append(", assuming old implementation.").toString());
            return false;
        }
        return flag;
    }

    public void zzf(Map map)
    {
        zzyd = map;
    }
}
