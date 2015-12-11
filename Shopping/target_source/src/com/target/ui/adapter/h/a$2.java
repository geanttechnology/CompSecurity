// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.h;

import com.target.ui.view.shop.DealsHeaderView;
import com.target.ui.view.shop.WeeklyAdCardView;

// Referenced classes of package com.target.ui.adapter.h:
//            a

class sHeaderView
    implements com.target.ui.view.shop.lyAdView.b
{

    final a this$0;
    final DealsHeaderView val$dealsHeaderView;

    public void a(WeeklyAdCardView weeklyadcardview)
    {
        if (com.target.ui.adapter.h.a.a(a.this) == null)
        {
            return;
        } else
        {
            com.target.ui.adapter.h.a.a(a.this).a(val$dealsHeaderView, weeklyadcardview);
            return;
        }
    }

    sHeaderView()
    {
        this$0 = final_a1;
        val$dealsHeaderView = DealsHeaderView.this;
        super();
    }
}
