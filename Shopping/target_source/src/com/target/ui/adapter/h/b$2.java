// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.h;

import com.target.ui.model.shop.a;
import com.target.ui.view.shop.WeeklyAdCardView;
import com.target.ui.view.shop.WeeklyAdView;

// Referenced classes of package com.target.ui.adapter.h:
//            b

class lyAdView
    implements com.target.ui.view.shop.lyAdView.b
{

    final b this$0;
    final a val$element;
    final WeeklyAdView val$weeklyAdView;

    public void a(WeeklyAdCardView weeklyadcardview)
    {
        if (b.c(b.this) == null)
        {
            return;
        } else
        {
            b.c(b.this).a(val$element.a(), val$weeklyAdView, weeklyadcardview);
            return;
        }
    }

    lyAdView()
    {
        this$0 = final_b1;
        val$element = a1;
        val$weeklyAdView = WeeklyAdView.this;
        super();
    }
}
