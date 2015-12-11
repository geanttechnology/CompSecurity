// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.plp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.ConfigurableDropShadowView;
import com.target.ui.view.TargetFloatingActionButton;
import com.target.ui.view.a;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.product.PlpRefineHeaderView;

// Referenced classes of package com.target.ui.fragment.product.plp:
//            ProductSummaryPageFragment

static class I extends a
{

    View contentContainer;
    TargetErrorView errorContainer;
    RecyclerView mGridRecyclerView;
    RecyclerView mListRecyclerView;
    ConfigurableDropShadowView mockActionBarDropShadow;
    BitmapImageView plpBannerImageView;
    View progressContainer;
    TargetFloatingActionButton refineFloatingActionButton;
    PlpRefineHeaderView refineHeaderView;

    I(View view)
    {
        super(view);
    }
}
