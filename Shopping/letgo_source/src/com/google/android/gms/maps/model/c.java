// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import android.support.v7.zy;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.maps.model:
//            e

public final class c
{

    private final zy a;

    public c(zy zy1)
    {
        a = (zy)x.a(zy1);
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

    public boolean equals(Object obj)
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
            throw new e(((RemoteException) (obj)));
        }
        return flag;
    }

    public int hashCode()
    {
        int i;
        try
        {
            i = a.j();
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
        return i;
    }
}
