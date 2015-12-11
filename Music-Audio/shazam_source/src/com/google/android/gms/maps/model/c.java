// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.maps.model.a.f;

// Referenced classes of package com.google.android.gms.maps.model:
//            d, LatLng

public final class c
{

    public final f a;

    public c(f f1)
    {
        a = (f)w.a(f1);
    }

    public final void a()
    {
        try
        {
            a.a();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new d(remoteexception);
        }
    }

    public final LatLng b()
    {
        LatLng latlng;
        try
        {
            latlng = a.c();
        }
        catch (RemoteException remoteexception)
        {
            throw new d(remoteexception);
        }
        return latlng;
    }

    public final void c()
    {
        try
        {
            a.h();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new d(remoteexception);
        }
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof c))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = a.a(((c)obj).a);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new d(((RemoteException) (obj)));
        }
        return flag;
    }

    public final int hashCode()
    {
        int i;
        try
        {
            i = a.k();
        }
        catch (RemoteException remoteexception)
        {
            throw new d(remoteexception);
        }
        return i;
    }
}
