// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

// Referenced classes of package com.google.android.a.a.a:
//            s, d, b, n, 
//            k

public final class q extends s
    implements d
{

    private final String h;
    private final String i;
    private final String j;
    private boolean k;

    public q(Context context, String s1, String s2, String s3, u.a a1, u.b b1)
    {
        super(context, a1, b1);
        h = (String)com.google.android.a.a.a.b.a(s1);
        i = com.google.android.a.a.a.b.a(s2, "callingPackage cannot be null or empty");
        j = com.google.android.a.a.a.b.a(s3, "callingAppVersion cannot be null or empty");
    }

    public final IBinder a()
    {
        j();
        if (k)
        {
            throw new IllegalStateException("Connection client has been released");
        }
        IBinder ibinder;
        try
        {
            ibinder = ((n)k()).a();
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return ibinder;
    }

    protected final volatile IInterface a(IBinder ibinder)
    {
        return n.a.a(ibinder);
    }

    protected final void a(k k1, s.d d1)
    {
        k1.a(d1, 1201, i, j, h, null);
    }

    public final void a(boolean flag)
    {
        if (f())
        {
            try
            {
                ((n)k()).a(flag);
            }
            catch (RemoteException remoteexception) { }
            k = true;
        }
    }

    protected final String b()
    {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    protected final String c()
    {
        return "com.google.android.youtube.api.service.START";
    }

    public final void d()
    {
        if (!k)
        {
            a(true);
        }
        super.d();
    }
}
