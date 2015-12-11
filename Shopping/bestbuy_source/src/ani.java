// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;

public final class ani
{

    private static aod a;

    public static anh a(int i)
    {
        anh anh1;
        try
        {
            anh1 = new anh(a().a(i));
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
        return anh1;
    }

    private static aod a()
    {
        return (aod)ady.a(a, "IBitmapDescriptorFactory is not initialized");
    }

    public static void a(aod aod1)
    {
        if (a != null)
        {
            return;
        } else
        {
            a = (aod)ady.a(aod1);
            return;
        }
    }
}
