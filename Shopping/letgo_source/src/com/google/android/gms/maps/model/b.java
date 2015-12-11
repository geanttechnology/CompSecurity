// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import android.support.v7.zx;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.maps.model:
//            a, e

public final class b
{

    private static zx a;

    private static zx a()
    {
        return (zx)x.a(a, "IBitmapDescriptorFactory is not initialized");
    }

    public static a a(int i)
    {
        a a1;
        try
        {
            a1 = new a(a().a(i));
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
        return a1;
    }

    public static void a(zx zx1)
    {
        if (a != null)
        {
            return;
        } else
        {
            a = (zx)x.a(zx1);
            return;
        }
    }
}
