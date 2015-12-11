// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;

// Referenced classes of package com.google.android.gms.internal:
//            bl, kv, f, et, 
//            x, kw, kz, v, 
//            o

public final class r
{

    public AdListener a;
    public f b;
    public String c;
    public AppEventListener d;
    private final bl e = new bl();
    private final Context f;

    public r(Context context)
    {
        f = context;
    }

    private void b(String s)
    {
        if (b == null)
        {
            throw new IllegalStateException((new StringBuilder("The ad unit ID must be set on InterstitialAd before ")).append(s).append(" is called.").toString());
        } else
        {
            return;
        }
    }

    public final void a(AdListener adlistener)
    {
        a = adlistener;
        if (b == null) goto _L2; else goto _L1
_L1:
        f f1 = b;
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        adlistener = new kv(adlistener);
_L3:
        f1.a(adlistener);
_L2:
        return;
        adlistener = null;
          goto _L3
        adlistener;
        et.a("Failed to set the AdListener.", adlistener);
        return;
    }

    public final void a(o o1)
    {
        try
        {
            if (b == null)
            {
                if (c == null)
                {
                    b("loadAd");
                }
                b = kw.a(f, new x(), c, e);
                if (a != null)
                {
                    b.a(new kv(a));
                }
                if (d != null)
                {
                    b.a(new kz(d));
                }
            }
            if (b.a(new v(f, o1)))
            {
                e.a = o1.g;
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            et.a("Failed to load ad.", o1);
        }
    }

    public final void a(String s)
    {
        if (c != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        } else
        {
            c = s;
            return;
        }
    }

    public final boolean a()
    {
        if (b == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = b.c();
        }
        catch (RemoteException remoteexception)
        {
            et.a("Failed to check if ad is ready.", remoteexception);
            return false;
        }
        return flag;
    }

    public final void b()
    {
        try
        {
            b("show");
            b.f();
            return;
        }
        catch (RemoteException remoteexception)
        {
            et.a("Failed to show interstitial.", remoteexception);
        }
    }
}
