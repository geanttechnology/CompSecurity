// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.target.ui.view.a;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.product.ProductDialogHeaderView;
import com.target.ui.view.product.ProductDialogZipCodeView;
import com.target.ui.view.product.ProductFiatsDialogHeaderView;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductFiatsDialogFragment

static class headerView extends a
{

    ViewGroup contentContainer;
    TargetErrorView errorContainer;
    final ProductDialogHeaderView headerView;
    ListView listView;
    ViewGroup noRelevantStoresContainer;
    ViewGroup progressContainer;
    TextView title;
    ProductDialogZipCodeView zipCodeChooser;

    (Context context, View view)
    {
        super(view);
        headerView = new ProductFiatsDialogHeaderView(context);
    }
}
