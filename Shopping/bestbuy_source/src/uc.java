// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ay;

public class uc
{

    private final wc a;
    private final Context b;
    private final tj c;
    private ol d;
    private tq e;
    private String f;
    private String g;
    private or h;
    private pi i;
    private pg j;
    private os k;
    private ou l;

    public uc(Context context)
    {
        this(context, tj.a(), null);
    }

    public uc(Context context, tj tj1, os os)
    {
        a = new wc();
        b = context;
        c = tj1;
        k = os;
    }

    private void b(String s)
    {
        if (f == null)
        {
            c(s);
        }
        e = th.a(b, new ay(), f, a);
        if (d != null)
        {
            e.a(new tg(d));
        }
        if (h != null)
        {
            e.a(new tm(h));
        }
        if (j != null)
        {
            e.a(new yy(j));
        }
        if (i != null)
        {
            e.a(new zd(i), g);
        }
        if (l != null)
        {
            e.a(new up(l));
        }
    }

    private void c(String s)
    {
        if (e == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("The ad unit ID must be set on InterstitialAd before ").append(s).append(" is called.").toString());
        } else
        {
            return;
        }
    }

    public void a()
    {
        try
        {
            c("show");
            e.f();
            return;
        }
        catch (RemoteException remoteexception)
        {
            acb.d("Failed to show interstitial.", remoteexception);
        }
    }

    public void a(String s)
    {
        if (f != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        } else
        {
            f = s;
            return;
        }
    }

    public void a(ol ol)
    {
        d = ol;
        if (e == null) goto _L2; else goto _L1
_L1:
        tq tq1 = e;
        if (ol == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        ol = new tg(ol);
_L3:
        tq1.a(ol);
_L2:
        return;
        ol = null;
          goto _L3
        ol;
        acb.d("Failed to set the AdListener.", ol);
        return;
    }

    public void a(tz tz1)
    {
        try
        {
            if (e == null)
            {
                b("loadAd");
            }
            if (e.a(c.a(b, tz1)))
            {
                a.a(tz1.i());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (tz tz1)
        {
            acb.d("Failed to load ad.", tz1);
        }
    }
}
