// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzey, zzet, zzen

public final class zzel extends zzem.zza
{

    private Map zzzH;

    public zzel()
    {
    }

    private zzen zzag(String s)
        throws RemoteException
    {
        try
        {
            Object obj = Class.forName(s, false, com/google/android/gms/internal/zzel.getClassLoader());
            if (com/google/ads/mediation/MediationAdapter.isAssignableFrom(((Class) (obj))))
            {
                obj = (MediationAdapter)((Class) (obj)).newInstance();
                return new zzey(((MediationAdapter) (obj)), (NetworkExtras)zzzH.get(((MediationAdapter) (obj)).getAdditionalParametersType()));
            }
            if (com/google/android/gms/ads/mediation/MediationAdapter.isAssignableFrom(((Class) (obj))))
            {
                return new zzet((com.google.android.gms.ads.mediation.MediationAdapter)((Class) (obj)).newInstance());
            } else
            {
                zzb.zzaH((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        }
        catch (Throwable throwable)
        {
            zzb.zzaH((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(". ").append(throwable.getMessage()).toString());
        }
        throw new RemoteException();
    }

    public zzen zzae(String s)
        throws RemoteException
    {
        return zzag(s);
    }

    public boolean zzaf(String s)
        throws RemoteException
    {
        boolean flag;
        try
        {
            flag = com/google/android/gms/ads/mediation/customevent/CustomEvent.isAssignableFrom(Class.forName(s, false, com/google/android/gms/internal/zzel.getClassLoader()));
        }
        catch (Throwable throwable)
        {
            zzb.zzaH((new StringBuilder()).append("Could not load custom event implementation class: ").append(s).append(", assuming old implementation.").toString());
            return false;
        }
        return flag;
    }

    public void zze(Map map)
    {
        zzzH = map;
    }
}
