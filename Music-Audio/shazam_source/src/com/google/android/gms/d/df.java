// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.c.b;
import com.google.android.gms.ads.c.b.a;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            dr, dm, dh

public final class df extends dg.a
{

    public Map a;

    public df()
    {
    }

    private dh c(String s)
    {
        try
        {
            Object obj = Class.forName(s, false, com/google/android/gms/d/df.getClassLoader());
            if (com/google/ads/mediation/MediationAdapter.isAssignableFrom(((Class) (obj))))
            {
                obj = (MediationAdapter)((Class) (obj)).newInstance();
                return new dr(((MediationAdapter) (obj)), (NetworkExtras)a.get(((MediationAdapter) (obj)).getAdditionalParametersType()));
            }
            if (com/google/android/gms/ads/c/b.isAssignableFrom(((Class) (obj))))
            {
                return new dm((b)((Class) (obj)).newInstance());
            } else
            {
                (new StringBuilder("Could not instantiate mediation adapter: ")).append(s).append(" (not a valid adapter).");
                com.google.android.gms.ads.internal.util.client.b.a(5);
                throw new RemoteException();
            }
        }
        catch (Throwable throwable)
        {
            (new StringBuilder("Could not instantiate mediation adapter: ")).append(s).append(". ").append(throwable.getMessage());
        }
        com.google.android.gms.ads.internal.util.client.b.a(5);
        throw new RemoteException();
    }

    public final dh a(String s)
    {
        return c(s);
    }

    public final boolean b(String s)
    {
        boolean flag;
        try
        {
            flag = com/google/android/gms/ads/c/b/a.isAssignableFrom(Class.forName(s, false, com/google/android/gms/d/df.getClassLoader()));
        }
        catch (Throwable throwable)
        {
            (new StringBuilder("Could not load custom event implementation class: ")).append(s).append(", assuming old implementation.");
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return false;
        }
        return flag;
    }
}
