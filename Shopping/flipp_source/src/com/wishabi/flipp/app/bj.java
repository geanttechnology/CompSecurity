// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.wishabi.flipp.content.ag;
import com.wishabi.flipp.widget.FlyerToolbar;
import com.wishabi.flipp.widget.ShoppingListPopup;
import com.wishabi.flipp.widget.bh;
import com.wishabi.flipp.widget.bi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.wishabi.flipp.app:
//            bu, bi, FlyerCarouselFragment, bo, 
//            bt, bk, FlippApplication, bm

final class bj
    implements bu
{

    final com.wishabi.flipp.app.bi a;

    bj(com.wishabi.flipp.app.bi bi1)
    {
        a = bi1;
        super();
    }

    public final void a()
    {
        FlyerCarouselFragment.s(a.b);
        FlyerCarouselFragment.r(a.b).a(true);
    }

    public final void a(bo bo1, String s, boolean flag)
    {
        boolean flag2;
        flag2 = true;
        break MISSING_BLOCK_LABEL_3;
        while (!flag) 
        {
            do
            {
                return;
            } while (!FlyerCarouselFragment.l(a.b).equals(s) || FlyerCarouselFragment.o(a.b) == null || FlyerCarouselFragment.b(a.b) == null);
            FlyerCarouselFragment.o(a.b).setProgressVisible(false);
            s = FlyerCarouselFragment.o(a.b);
            int i = FlyerCarouselFragment.b(a.b).e;
            Object obj;
            boolean flag1;
            if (!FlyerCarouselFragment.b(a.b).d)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj = s.getResources();
            if (obj == null || !flag1)
            {
                ((FlyerToolbar) (s)).a.setText(null);
                s.b = true;
            } else
            if (i == 0)
            {
                ((FlyerToolbar) (s)).a.setText(((Resources) (obj)).getString(0x7f0e00fb));
                s.b = true;
            } else
            {
                ((FlyerToolbar) (s)).a.setText(((Resources) (obj)).getQuantityString(0x7f0d0007, i, new Object[] {
                    Integer.valueOf(i)
                }));
                s.b = false;
            }
            s.a();
            FlyerCarouselFragment.o(a.b).setCouponCount(bo1.j.size());
            FlyerCarouselFragment.t(a.b).a(FlyerCarouselFragment.o(a.b), FlyerCarouselFragment.c(a.b));
            FlyerCarouselFragment.a(a.b, FlyerCarouselFragment.c(a.b), false, false);
        }
        s = bo1.j.iterator();
_L4:
        if (!s.hasNext()) goto _L2; else goto _L1
_L1:
        obj = (Long)s.next();
        obj = (bi)bo1.h.get(obj);
        if (obj == null || ag.b(((bt)((bi) (obj)).c).o)) goto _L4; else goto _L3
_L3:
        flag = flag2;
_L6:
        FlippApplication.a(new bk(this, flag));
        return;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(boolean flag, String s, int i)
    {
        if (FlyerCarouselFragment.q(a.b) == bm.b)
        {
            return;
        }
        if (!flag || TextUtils.isEmpty(s) || ag.b(i))
        {
            FlyerCarouselFragment.r(a.b).a(true);
            return;
        } else
        {
            FlyerCarouselFragment.r(a.b).a(s, true);
            return;
        }
    }

    public final boolean a(String s)
    {
        FlyerCarouselFragment.b(a.b, s);
        return true;
    }
}
