// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.clp;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.target.ui.view.a;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.product.ProductCollectionHeaderView;

// Referenced classes of package com.target.ui.fragment.product.clp:
//            CollectionsListPageFragment

static class productClpHeader extends a
{

    View contentContainer;
    TargetErrorView errorContainer;
    final ProductCollectionHeaderView productClpHeader;
    ListView productListView;
    View progressContainer;

    (Context context, View view)
    {
        super(view);
        productClpHeader = new ProductCollectionHeaderView(context);
    }
}
