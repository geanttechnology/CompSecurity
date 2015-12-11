// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.RemoteException;
import com.google.android.gms.ads.c.d;
import com.google.android.gms.ads.c.f;
import com.google.android.gms.ads.c.g;
import com.google.android.gms.ads.c.m;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.w;

// Referenced classes of package com.google.android.gms.d:
//            di

public final class dn
    implements d, f, m
{

    g a;
    private final di b;

    public dn(di di1)
    {
        b = di1;
    }

    public final void a()
    {
        w.b("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.e();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void a(int i1)
    {
        w.b("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.a(i1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void a(g g1)
    {
        w.b("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        a = g1;
        try
        {
            b.e();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (g g1)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void b()
    {
        w.b("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.d();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void b(int i1)
    {
        w.b("onAdFailedToLoad must be called on the main UI thread.");
        (new StringBuilder("Adapter called onAdFailedToLoad with error ")).append(i1).append(".");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.a(i1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void c()
    {
        w.b("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.b();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void c(int i1)
    {
        w.b("onAdFailedToLoad must be called on the main UI thread.");
        (new StringBuilder("Adapter called onAdFailedToLoad with error ")).append(i1).append(".");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.a(i1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void d()
    {
        w.b("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.c();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void e()
    {
        w.b("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.a();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void f()
    {
        w.b("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.e();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void g()
    {
        w.b("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.d();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void h()
    {
        w.b("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.b();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void i()
    {
        w.b("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.c();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void j()
    {
        w.b("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.a();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void k()
    {
        w.b("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.d();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void l()
    {
        w.b("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.b();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void m()
    {
        w.b("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.c();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void n()
    {
        w.b("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.a(3);
        try
        {
            b.a();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }
}
