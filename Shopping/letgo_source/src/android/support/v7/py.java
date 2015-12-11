// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            kk, qk, kq, qf, 
//            qa

public final class py extends pz.a
{

    private Map a;

    public py()
    {
    }

    private qa c(String s)
        throws RemoteException
    {
        try
        {
            Object obj = Class.forName(s, false, android/support/v7/py.getClassLoader());
            if (android/support/v7/kk.isAssignableFrom(((Class) (obj))))
            {
                obj = (kk)((Class) (obj)).newInstance();
                return new qk(((kk) (obj)), (kq)a.get(((kk) (obj)).b()));
            }
            if (com/google/android/gms/ads/mediation/MediationAdapter.isAssignableFrom(((Class) (obj))))
            {
                return new qf((MediationAdapter)((Class) (obj)).newInstance());
            } else
            {
                zzb.zzaE((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        }
        catch (Throwable throwable)
        {
            zzb.zzaE((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(". ").append(throwable.getMessage()).toString());
        }
        throw new RemoteException();
    }

    public qa a(String s)
        throws RemoteException
    {
        return c(s);
    }

    public void a(Map map)
    {
        a = map;
    }

    public boolean b(String s)
        throws RemoteException
    {
        boolean flag;
        try
        {
            flag = com/google/android/gms/ads/mediation/customevent/CustomEvent.isAssignableFrom(Class.forName(s, false, android/support/v7/py.getClassLoader()));
        }
        catch (Throwable throwable)
        {
            zzb.zzaE((new StringBuilder()).append("Could not load custom event implementation class: ").append(s).append(", assuming old implementation.").toString());
            return false;
        }
        return flag;
    }
}
