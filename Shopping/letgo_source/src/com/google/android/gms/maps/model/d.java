// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import android.support.v7.aab;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.maps.model:
//            e

public final class d
{

    private final aab a;

    public d(aab aab1)
    {
        a = (aab)x.a(aab1);
    }

    public void a()
    {
        try
        {
            a.a();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public String b()
    {
        String s;
        try
        {
            s = a.d();
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
        return s;
    }

    public String c()
    {
        String s;
        try
        {
            s = a.e();
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
        return s;
    }

    public void d()
    {
        try
        {
            a.g();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public void e()
    {
        try
        {
            a.h();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof d))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = a.a(((d)obj).a);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new e(((RemoteException) (obj)));
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
            throw new e(remoteexception);
        }
        return i;
    }
}
