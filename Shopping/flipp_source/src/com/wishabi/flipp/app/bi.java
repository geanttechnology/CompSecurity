// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v13.app.i;
import android.view.ViewGroup;

// Referenced classes of package com.wishabi.flipp.app:
//            bo, FlyerCarouselFragment, bj

final class bi extends i
{

    final FlyerCarouselFragment b;

    bi(FlyerCarouselFragment flyercarouselfragment, FragmentManager fragmentmanager)
    {
        b = flyercarouselfragment;
        super(fragmentmanager);
    }

    public final Fragment a(int j)
    {
        bo bo1 = new bo();
        RectF rectf = new RectF();
        if (FlyerCarouselFragment.p(b).getInt("position") == j)
        {
            rectf.left = FlyerCarouselFragment.p(b).getFloat("left");
            rectf.top = FlyerCarouselFragment.p(b).getFloat("top");
            rectf.right = FlyerCarouselFragment.p(b).getFloat("right");
            rectf.bottom = FlyerCarouselFragment.p(b).getFloat("bottom");
        }
        bo1.f = (com.wishabi.flipp.content.Flyer.Model)FlyerCarouselFragment.e(b)[j];
        bo1.c = rectf;
        return bo1;
    }

    public final Object a(ViewGroup viewgroup, int j)
    {
        viewgroup = (bo)super.a(viewgroup, j);
        viewgroup.a = new bj(this);
        return viewgroup;
    }

    public final int c()
    {
        if (FlyerCarouselFragment.e(b) != null)
        {
            return FlyerCarouselFragment.e(b).length;
        } else
        {
            return 0;
        }
    }
}
