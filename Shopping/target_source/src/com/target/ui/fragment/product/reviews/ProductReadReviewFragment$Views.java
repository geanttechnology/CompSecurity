// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.reviews;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.target.ui.view.a;
import com.target.ui.view.common.b;
import com.target.ui.view.product.PlpGridFooterView;
import com.target.ui.view.review.ProductReviewHeaderView;

// Referenced classes of package com.target.ui.fragment.product.reviews:
//            ProductReadReviewFragment

static class footerView extends a
{

    b errorContainer;
    final PlpGridFooterView footerView;
    final ProductReviewHeaderView headerView;
    ListView listView;

    (Context context, View view)
    {
        super(view);
        headerView = new ProductReviewHeaderView(context);
        footerView = new PlpGridFooterView(context);
    }
}
