// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.listadapter.ViewBuilderEntry;
import com.amazon.retailsearch.android.ui.results.ContentSwitcher;
import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.GalleryProduct;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.metrics.impressions.AsinImpressionTracker;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout, StackViewContainer

public class GalleryLayout extends StackLayout
{

    private static final boolean isSplitLayout = false;

    public GalleryLayout(StackViewContainer stackviewcontainer, int i, int j, ResourceProvider resourceprovider, AsinImpressionTracker asinimpressiontracker, boolean flag)
    {
        super(stackviewcontainer, i, j, resourceprovider, asinimpressiontracker, ResultLayoutType.GalleryView, com.amazon.retailsearch.R.integer.config_rs_atf_product_count_gallery, false, flag);
    }

    protected ViewBuilderEntry createProductCell(Product product, ProductViewModel productviewmodel)
    {
        if (isImmersiveViewSupported)
        {
            return createContentView(15, com/amazon/retailsearch/android/ui/results/ContentSwitcher, new ContentSwitcherModel(4, com/amazon/retailsearch/android/ui/results/GalleryProduct, productviewmodel));
        } else
        {
            return createContentView(4, com/amazon/retailsearch/android/ui/results/GalleryProduct, productviewmodel);
        }
    }
}
