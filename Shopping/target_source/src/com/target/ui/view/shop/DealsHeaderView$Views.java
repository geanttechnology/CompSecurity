// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.view.View;
import com.target.ui.view.a;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.view.shop:
//            DealsHeaderView, DealsNoStoreView, DealsCategoryHeaderView, WeeklyAdView

static class w extends a
{

    View cartwheelButton;
    View mobileCouponsButton;
    DealsNoStoreView noStoreView;
    DealsCategoryHeaderView productErrorHeader;
    TargetErrorView productErrorView;
    WeeklyAdView weeklyAdView;

    w(View view)
    {
        super(view);
    }
}
