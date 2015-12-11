// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.bi;
import android.support.v4.view.dn;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            h, CollapsingToolbarLayout, AppBarLayout, n, 
//            ca, k

final class o
    implements h
{

    private CollapsingToolbarLayout a;

    private o(CollapsingToolbarLayout collapsingtoolbarlayout)
    {
        a = collapsingtoolbarlayout;
        super();
    }

    o(CollapsingToolbarLayout collapsingtoolbarlayout, byte byte0)
    {
        this(collapsingtoolbarlayout);
    }

    public final void a(AppBarLayout appbarlayout, int i)
    {
        View view;
        n n1;
        ca ca1;
        int j;
        int j1;
        int l = 0;
        CollapsingToolbarLayout.b(a, i);
        int k1;
        if (CollapsingToolbarLayout.a(a) != null)
        {
            j = CollapsingToolbarLayout.a(a).b();
        } else
        {
            j = 0;
        }
        j1 = appbarlayout.getTotalScrollRange();
        k1 = a.getChildCount();
        if (l >= k1)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        view = a.getChildAt(l);
        n1 = (n)view.getLayoutParams();
        ca1 = CollapsingToolbarLayout.a(view);
        switch (n1.a)
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_158;
_L4:
        l++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_49;
_L1:
        if ((a.getHeight() - j) + i >= view.getHeight())
        {
            ca1.a(-i);
        }
        continue; /* Loop/switch isn't completed */
        float f = -i;
        ca1.a(Math.round(n1.b * f));
        if (true) goto _L4; else goto _L3
_L3:
        int i1;
        int l1;
        if (CollapsingToolbarLayout.b(a) != null || CollapsingToolbarLayout.c(a) != null)
        {
            if (a.getHeight() + i < a.getScrimTriggerOffset() + j)
            {
                CollapsingToolbarLayout.d(a);
            } else
            {
                CollapsingToolbarLayout.e(a);
            }
        }
        if (CollapsingToolbarLayout.c(a) != null && j > 0)
        {
            bi.d(a);
        }
        i1 = a.getHeight();
        l1 = bi.p(a);
        CollapsingToolbarLayout.f(a).a((float)Math.abs(i) / (float)(i1 - l1 - j));
        if (Math.abs(i) == j1)
        {
            bi.f(appbarlayout, appbarlayout.getTargetElevation());
            return;
        } else
        {
            bi.f(appbarlayout, 0.0F);
            return;
        }
    }
}
