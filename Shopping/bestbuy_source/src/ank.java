// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public final class ank
{

    private final aop a;

    public ank(aop aop1)
    {
        a = (aop)ady.a(aop1);
    }

    public LatLng a()
    {
        LatLng latlng;
        try
        {
            latlng = a.c();
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
        return latlng;
    }

    public void a(anh anh1)
    {
        try
        {
            a.a(anh1.a());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (anh anh1)
        {
            throw new anl(anh1);
        }
    }

    public void b()
    {
        try
        {
            a.g();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof ank))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = a.a(((ank)obj).a);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new anl(((RemoteException) (obj)));
        }
        return flag;
    }

    public int hashCode()
    {
        int i;
        try
        {
            i = a.k();
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
        return i;
    }
}
