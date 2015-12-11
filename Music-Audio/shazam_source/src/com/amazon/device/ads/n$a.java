// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import java.util.HashMap;

// Referenced classes of package com.amazon.device.ads:
//            g, n, h, cl, 
//            bf, p, k, l, 
//            cs, cn, ac, ck, 
//            at, ae, v

final class a
    implements g
{

    final n a;
    private v b;

    public final void a()
    {
        n.b(a).f.b(.p);
        if (n.e(a) != null)
        {
            a.removeView(n.e(a));
        }
        if (n.f(a) != null)
        {
            n.f(a).a();
        }
        n.a(a, n.b(a).a());
        n.a(a, n.b(a).a());
        Object obj = new android.widget.eLayout.LayoutParams(-1, -1, 17);
        a.addView(n.e(a), ((android.view.Group.LayoutParams) (obj)));
        obj = b;
        a.getAdController().o();
        a.getAdListenerExecutor().a(a, ((v) (obj)));
    }

    public final void a(k k1)
    {
        if (b.equals(k1.a))
        {
            n.g(a);
        }
        a.getAdListenerExecutor().a(a, k1);
    }

    public final void a(l l1)
    {
        switch (b[l1.a.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a.getAdListenerExecutor().a(a);
            return;

        case 2: // '\002'
            a.getAdListenerExecutor().b(a);
            return;

        case 3: // '\003'
            l1 = (Rect)l1.b.a.get("positionOnScreen");
            break;
        }
        a.getAdListenerExecutor().a(a, l1);
    }

    public final void a(v v)
    {
        b = v;
        n.b(a).l();
    }

    public final boolean a(boolean flag)
    {
        n n1;
        boolean flag1;
        flag1 = false;
        n1 = a;
        if (!flag) goto _L2; else goto _L1
_L1:
        n1.f.b("Skipping ad layout preparation steps because the layout is already prepared.", null);
_L6:
        flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!n1.b()) goto _L4; else goto _L3
_L3:
        if (n1.getNeedsToLoadAdOnLayout())
        {
            n1.f.d("Can't load an ad because ad loading is already in progress", null);
            return false;
        }
        if (n1.getAdSize().a())
        {
            n1.f.b("Ad size to be determined automatically.", null);
        }
        if (n1.getParent() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        n1.b = flag;
        if (!n1.getAdSize().a() || !n1.getAdController().w)
        {
            if (n1.isLayoutRequested() && n1.getAdSize().a() && !n1.b)
            {
                n1.d();
                return false;
            }
            if (n1.b)
            {
                n1.f.b("The ad's parent view is missing at load time.", null);
                if (n1.getLayoutParams() == null)
                {
                    ck.a().b.a(.I);
                    n1.a("Can't load an ad because layout parameters are blank. Use setLayoutParams() to specify dimensions for this AdLayout.");
                    return false;
                }
                if (at.a(11))
                {
                    n1.c = ((Activity)n1.a).getWindow().getDecorView().findViewById(0x1020002).getRootView();
                    if (n1.e())
                    {
                        n1.a("Ad load failed because root view could not be obtained from the activity.");
                        return false;
                    }
                    if (n1.c.isLayoutRequested())
                    {
                        n1.f.b("Activity root view layout is requested.", null);
                        n1.d();
                        _cls1 _lcls1 = new _cls1(n1);
                        n1.c.addOnLayoutChangeListener(_lcls1);
                        return false;
                    }
                    n1.c();
                } else
                {
                    n1.c();
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void b()
    {
    }

    public final int c()
    {
        return !n.b(a).x.equals(ae.h) ? 2 : 0;
    }

    public final void d()
    {
    }

    _cls1(n n1)
    {
        a = n1;
        super();
    }
}
