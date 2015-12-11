// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.app.AlertDialog;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.b.q;
import com.wishabi.flipp.content.FlyerActivityIntent;
import com.wishabi.flipp.content.a;
import com.wishabi.flipp.content.c;
import com.wishabi.flipp.widget.aa;
import com.wishabi.flipp.widget.ae;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.app:
//            z, n, PrintCouponActivity, e, 
//            q, p

final class o
    implements ae
{

    final n a;

    o(n n1)
    {
        a = n1;
        super();
    }

    public final void a()
    {
        a.a(com/wishabi/flipp/app/z, null);
    }

    public final void a(int i)
    {
        Activity activity;
        activity = a.getActivity();
        break MISSING_BLOCK_LABEL_8;
        if (activity != null && com.wishabi.flipp.app.n.a(a) != null)
        {
            c c1 = com.wishabi.flipp.app.n.a(a).d(i);
            if (c1 != null)
            {
                com.wishabi.flipp.content.a.a(c1, true, p.e);
                activity.startActivity(com.wishabi.flipp.app.PrintCouponActivity.a());
                return;
            }
        }
        return;
    }

    public final void a(int i, int j)
    {
        Activity activity;
        activity = a.getActivity();
        break MISSING_BLOCK_LABEL_8;
        if (activity != null && com.wishabi.flipp.app.n.a(a) != null && n.b(a) != null)
        {
            Object obj = com.wishabi.flipp.app.n.a(a).d(i);
            if (obj != null)
            {
                obj = (ArrayList)n.b(a).get(Integer.valueOf(((c) (obj)).a));
                if (obj != null && !((ArrayList) (obj)).isEmpty() && j < ((ArrayList) (obj)).size())
                {
                    activity.startActivity(new FlyerActivityIntent(activity, (com.wishabi.flipp.content.o)((ArrayList) (obj)).get(j)));
                    activity.overridePendingTransition(0x7f040001, 0x7f040002);
                    return;
                }
            }
        }
        return;
    }

    public final void a(int i, boolean flag)
    {
        if (a.getActivity() != null && com.wishabi.flipp.app.n.a(a) != null)
        {
            c c1 = com.wishabi.flipp.app.n.a(a).d(i);
            if (c1 != null)
            {
                com.wishabi.flipp.content.a.a(c1, flag, p.e);
                return;
            }
        }
    }

    public final void b(int i)
    {
        if (a.getActivity() != null && com.wishabi.flipp.app.n.a(a) != null)
        {
            Object obj = com.wishabi.flipp.app.n.a(a).d(i);
            if (obj != null)
            {
                com.wishabi.flipp.b.a.a.a(((c) (obj)), q.b, p.e);
                obj = com.wishabi.flipp.app.e.a(((c) (obj)).n);
                a.a(com/wishabi/flipp/app/e, ((android.os.Bundle) (obj)));
                return;
            }
        }
    }

    public final void c(int i)
    {
        Activity activity = a.getActivity();
        if (activity == null)
        {
            return;
        } else
        {
            (new android.app.AlertDialog.Builder(activity)).setTitle(0x7f0e0084).setMessage(0x7f0e0082).setPositiveButton(0x7f0e0083, new com.wishabi.flipp.app.q(this, i)).setNegativeButton(0x7f0e0081, new com.wishabi.flipp.app.p(this)).create().show();
            return;
        }
    }
}
