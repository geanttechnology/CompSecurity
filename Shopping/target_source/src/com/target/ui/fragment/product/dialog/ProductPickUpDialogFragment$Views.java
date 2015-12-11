// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.target.ui.view.a;
import com.target.ui.view.product.FixedHeightListView;
import com.target.ui.view.product.ProductDialogErrorView;
import com.target.ui.view.product.ProductDialogHeaderView;
import com.target.ui.view.product.ProductDialogZipCodeView;
import com.target.ui.view.product.ProductPickUpDialogHeaderView;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductPickUpDialogFragment

static class headerView extends a
{

    Button addToCart;
    ViewGroup contentContainer;
    ProductDialogErrorView errorContainer;
    final ProductDialogHeaderView headerView;
    FixedHeightListView listView;
    ViewGroup noRelevantStoresContainer;
    ViewGroup progressContainer;
    final View rootView;
    TextView title;
    ProductDialogZipCodeView zipCodeView;

    (Context context, View view)
    {
        super(view);
        rootView = view;
        headerView = new ProductPickUpDialogHeaderView(context);
    }
}
