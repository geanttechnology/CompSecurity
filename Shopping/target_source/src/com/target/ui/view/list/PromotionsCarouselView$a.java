// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import com.target.mothership.model.promotion.interfaces.PromotionDetail;
import com.target.ui.view.common.ViewPagerIndicator;
import java.util.List;

// Referenced classes of package com.target.ui.view.list:
//            PromotionsCarouselView

private class <init>
    implements android.support.v4.view.<init>
{

    final PromotionsCarouselView this$0;

    public void a(int i)
    {
        PromotionsCarouselView.a(PromotionsCarouselView.this).indicator.a(i);
        PromotionsCarouselView.a(PromotionsCarouselView.this).indicator.setContentDescription(((PromotionDetail)PromotionsCarouselView.b(PromotionsCarouselView.this).get(i)).a());
    }

    public void a(int i, float f, int j)
    {
    }

    public void b(int i)
    {
    }

    private PromotionDetail()
    {
        this$0 = PromotionsCarouselView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
