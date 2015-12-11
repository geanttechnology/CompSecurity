// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;

public final class wq
    implements pb, pd
{

    private final wl a;

    public wq(wl wl1)
    {
        a = wl1;
    }

    public void a(pa pa)
    {
        ady.b("onAdLoaded must be called on the main UI thread.");
        acb.a("Adapter called onAdLoaded.");
        try
        {
            a.e();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pa pa)
        {
            acb.d("Could not call onAdLoaded.", pa);
        }
    }

    public void a(pa pa, int i)
    {
        ady.b("onAdFailedToLoad must be called on the main UI thread.");
        acb.a((new StringBuilder()).append("Adapter called onAdFailedToLoad with error. ").append(i).toString());
        try
        {
            a.a(i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pa pa)
        {
            acb.d("Could not call onAdFailedToLoad.", pa);
        }
    }

    public void a(pc pc)
    {
        ady.b("onAdLoaded must be called on the main UI thread.");
        acb.a("Adapter called onAdLoaded.");
        try
        {
            a.e();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pc pc)
        {
            acb.d("Could not call onAdLoaded.", pc);
        }
    }

    public void a(pc pc, int i)
    {
        ady.b("onAdFailedToLoad must be called on the main UI thread.");
        acb.a((new StringBuilder()).append("Adapter called onAdFailedToLoad with error ").append(i).append(".").toString());
        try
        {
            a.a(i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pc pc)
        {
            acb.d("Could not call onAdFailedToLoad.", pc);
        }
    }

    public void b(pa pa)
    {
        ady.b("onAdOpened must be called on the main UI thread.");
        acb.a("Adapter called onAdOpened.");
        try
        {
            a.d();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pa pa)
        {
            acb.d("Could not call onAdOpened.", pa);
        }
    }

    public void b(pc pc)
    {
        ady.b("onAdOpened must be called on the main UI thread.");
        acb.a("Adapter called onAdOpened.");
        try
        {
            a.d();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pc pc)
        {
            acb.d("Could not call onAdOpened.", pc);
        }
    }

    public void c(pa pa)
    {
        ady.b("onAdClosed must be called on the main UI thread.");
        acb.a("Adapter called onAdClosed.");
        try
        {
            a.b();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pa pa)
        {
            acb.d("Could not call onAdClosed.", pa);
        }
    }

    public void c(pc pc)
    {
        ady.b("onAdClosed must be called on the main UI thread.");
        acb.a("Adapter called onAdClosed.");
        try
        {
            a.b();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pc pc)
        {
            acb.d("Could not call onAdClosed.", pc);
        }
    }

    public void d(pa pa)
    {
        ady.b("onAdLeftApplication must be called on the main UI thread.");
        acb.a("Adapter called onAdLeftApplication.");
        try
        {
            a.c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pa pa)
        {
            acb.d("Could not call onAdLeftApplication.", pa);
        }
    }

    public void d(pc pc)
    {
        ady.b("onAdLeftApplication must be called on the main UI thread.");
        acb.a("Adapter called onAdLeftApplication.");
        try
        {
            a.c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pc pc)
        {
            acb.d("Could not call onAdLeftApplication.", pc);
        }
    }

    public void e(pa pa)
    {
        ady.b("onAdClicked must be called on the main UI thread.");
        acb.a("Adapter called onAdClicked.");
        try
        {
            a.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (pa pa)
        {
            acb.d("Could not call onAdClicked.", pa);
        }
    }
}
