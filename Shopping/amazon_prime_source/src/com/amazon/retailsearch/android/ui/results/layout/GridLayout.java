// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.listadapter.ViewBuilderEntry;
import com.amazon.retailsearch.android.ui.results.GridProduct;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.metrics.impressions.AsinImpressionTracker;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout, StackViewContainer

public class GridLayout extends StackLayout
{

    private static final boolean isImmersiveViewSupported = false;
    private static final boolean isSplitLayout = false;

    public GridLayout(StackViewContainer stackviewcontainer, int i, int j, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker)
    {
        super(stackviewcontainer, i, j, resourceprovider, asinimpressiontracker, ResultLayoutType.GridView, com.amazon.retailsearch.R.integer.config_rs_atf_product_count_grid, false, false);
    }

    protected ViewBuilderEntry createProductCell(Product product, ProductViewModel productviewmodel)
    {
        return createContentView(3, com/amazon/retailsearch/android/ui/results/GridProduct, productviewmodel);
    }
}
