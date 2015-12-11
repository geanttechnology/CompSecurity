// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;

final class bdk extends bmr
{

    private bdi a;

    bdk(bdi bdi1)
    {
        a = bdi1;
        super();
    }

    private String c()
    {
        String s;
        try
        {
            s = ((ats)bdi.c(a).b_()).a.a();
        }
        catch (RemoteException remoteexception)
        {
            bmo.d("RemoteException when using AdShieldClient.getSignalsUrlKey()", remoteexception);
            return "ms";
        }
        return s;
    }

    public final Object a()
    {
        return c();
    }
}
