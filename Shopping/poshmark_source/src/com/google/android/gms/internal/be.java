// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.NetworkExtras;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            da, bi, bg

public final class be extends bf.a
{

    private Map mQ;

    public be()
    {
    }

    private bg n(String s)
        throws RemoteException
    {
        Object obj;
        try
        {
            obj = Class.forName(s, false, com/google/android/gms/internal/be.getClassLoader());
            if (!com/google/ads/mediation/MediationAdapter.isAssignableFrom(((Class) (obj))))
            {
                da.w((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(".").toString());
                throw new RemoteException();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            da.w((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(s).append(". ").append(((Throwable) (obj)).getMessage()).toString());
            throw new RemoteException();
        }
        obj = (MediationAdapter)((Class) (obj)).newInstance();
        obj = new bi(((MediationAdapter) (obj)), (NetworkExtras)mQ.get(((MediationAdapter) (obj)).getAdditionalParametersType()));
        return ((bg) (obj));
    }

    public void c(Map map)
    {
        mQ = map;
    }

    public bg m(String s)
        throws RemoteException
    {
        return n(s);
    }
}
