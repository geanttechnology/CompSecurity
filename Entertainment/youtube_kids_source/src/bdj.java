// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;

final class bdj extends bmr
{

    private String a;
    private String b;
    private bdi c;

    bdj(bdi bdi1, String s, String s1)
    {
        c = bdi1;
        a = s;
        b = s1;
        super();
    }

    private ats c()
    {
        bdi.a(c);
        try
        {
            ats ats1 = bdi.b(c);
            String s = a;
            String s1 = b;
            ats1.a.a(s, s1);
        }
        catch (RemoteException remoteexception)
        {
            bmo.d("RemoteException when using AdShieldClient.setAdSenseDomainAndPath()", remoteexception);
        }
        return bdi.b(c);
    }

    public final Object a()
    {
        return c();
    }
}
