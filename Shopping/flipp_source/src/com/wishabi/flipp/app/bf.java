// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.graphics.RectF;
import com.wishabi.flipp.widget.FlyerToolbar;
import com.wishabi.flipp.widget.FlyerViewGroup;
import com.wishabi.flipp.widget.bh;
import com.wishabi.flipp.widget.bi;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.app:
//            FlyerCarouselFragment, bo

final class bf
    implements bh
{

    final FlyerCarouselFragment a;

    bf(FlyerCarouselFragment flyercarouselfragment)
    {
        a = flyercarouselfragment;
        super();
    }

    public final void a()
    {
        if (FlyerCarouselFragment.b(a) != null) goto _L2; else goto _L1
_L1:
        FlyerViewGroup flyerviewgroup;
        return;
_L2:
        RectF rectf;
        if ((flyerviewgroup = (FlyerViewGroup)FlyerCarouselFragment.b(a).getView()) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        rectf = flyerviewgroup.getVisibleRect();
        Object obj = flyerviewgroup.getHighlightAnnotations();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((List) (obj)).iterator();
        bi bi1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            bi1 = (bi)((Iterator) (obj)).next();
        } while (bi1.a.left < rectf.right);
        rectf = bi1.a(true);
_L4:
        if (rectf != null)
        {
            flyerviewgroup.a(rectf);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        rectf = null;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final void a(FlyerToolbar flyertoolbar)
    {
        while (FlyerCarouselFragment.b(a) == null || (FlyerViewGroup)FlyerCarouselFragment.b(a).getView() == null) 
        {
            return;
        }
        FlyerCarouselFragment flyercarouselfragment = a;
        boolean flag;
        if (!FlyerCarouselFragment.a(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        FlyerCarouselFragment.a(flyercarouselfragment, flag);
        flyertoolbar.setShowCoupon(FlyerCarouselFragment.a(a));
        if (FlyerCarouselFragment.a(a))
        {
            flyertoolbar.setDiscount(0);
        }
        FlyerCarouselFragment.a(a, FlyerCarouselFragment.c(a), false, FlyerCarouselFragment.a(a));
    }

    public final void a(FlyerToolbar flyertoolbar, int i)
    {
        if (i > 0)
        {
            FlyerCarouselFragment.a(a, false);
            flyertoolbar.setShowCoupon(FlyerCarouselFragment.a(a));
        }
        FlyerCarouselFragment.a(a, i, true, true);
    }

    public final void b()
    {
        if (FlyerCarouselFragment.b(a) != null) goto _L2; else goto _L1
_L1:
        FlyerViewGroup flyerviewgroup;
        return;
_L2:
        if ((flyerviewgroup = (FlyerViewGroup)FlyerCarouselFragment.b(a).getView()) == null) goto _L1; else goto _L3
_L3:
        Object obj;
        RectF rectf;
        rectf = flyerviewgroup.getVisibleRect();
        obj = flyerviewgroup.getHighlightAnnotations();
        if (obj == null || ((List) (obj)).isEmpty()) goto _L1; else goto _L4
_L4:
        int i = ((List) (obj)).size() - 1;
_L7:
        bi bi1;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        bi1 = (bi)((List) (obj)).get(i);
        if (bi1.a.right > rectf.left) goto _L6; else goto _L5
_L5:
        obj = bi1.a(true);
        obj.left = ((RectF) (obj)).right - rectf.width();
        float f;
        if (((RectF) (obj)).left > 0.0F)
        {
            f = ((RectF) (obj)).left;
        } else
        {
            f = 0.0F;
        }
        obj.left = f;
_L8:
        if (obj != null)
        {
            flyerviewgroup.a(((RectF) (obj)));
            return;
        }
          goto _L1
_L6:
        i--;
          goto _L7
        obj = null;
          goto _L8
    }
}
