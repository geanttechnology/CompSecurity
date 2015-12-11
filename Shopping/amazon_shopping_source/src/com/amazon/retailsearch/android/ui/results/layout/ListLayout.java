// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.view.ViewGroup;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.listadapter.ViewBuilderEntry;
import com.amazon.retailsearch.android.ui.results.ListProduct;
import com.amazon.retailsearch.metrics.impressions.AsinImpressionTracker;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout

public class ListLayout extends StackLayout
{

    public ListLayout(ViewGroup viewgroup, int i, int j, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker)
    {
        super(viewgroup, i, j, resourceprovider, asinimpressiontracker, com.amazon.retailsearch.R.dimen.rs_results_image_width_list, com.amazon.retailsearch.R.dimen.rs_results_image_height_list, com.amazon.retailsearch.R.integer.config_rs_atf_product_count_list);
    }

    protected ViewBuilderEntry createProductCell(Product product)
    {
        return createContentView(2, com/amazon/retailsearch/android/ui/results/ListProduct, createProductViewModel(product));
    }
}
