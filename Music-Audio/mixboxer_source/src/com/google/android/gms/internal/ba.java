// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.NetworkExtras;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            ct, be, bc

public final class ba extends bb.a
{

    private Map gf;

    public ba()
    {
    }

    private bc m(String s)
        throws RemoteException
    {
        Object obj;
        try
        {
            obj = Class.forName(s, false, com/google/android/gms/internal/ba.getClassLoader());
            if (!com/google/ads/mediation/MediationAdapter.isAssignableFrom(((Class) (obj))))
            {
                ct.v((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(".").toString());
                throw new RemoteException();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ct.v((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(". ").append(((Throwable) (obj)).getMessage()).toString());
            throw new RemoteException();
        }
        obj = (MediationAdapter)((Class) (obj)).newInstance();
        obj = new be(((MediationAdapter) (obj)), (NetworkExtras)gf.get(((MediationAdapter) (obj)).getAdditionalParametersType()));
        return ((bc) (obj));
    }

    public void c(Map map)
    {
        gf = map;
    }

    public bc l(String s)
        throws RemoteException
    {
        return m(s);
    }
}
