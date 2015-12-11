// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.ui.animations.AnimatableResultsImage;
import com.amazon.retailsearch.android.ui.results.layout.LayoutElement;
import com.amazon.retailsearch.android.ui.results.layout.SearchLayout;
import com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperSim;
import com.amazon.retailsearch.interaction.SimsInteractionListener;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            SimsModel

class val.contentRowEntry
    implements SimsInteractionListener
{

    final nteraction this$0;
    final AnimatableResultsImage val$animatableResultsImage;
    final LayoutElement val$contentRowEntry;
    final SearchLayout val$searchLayout;

    public void simSelected(Product product, ImageWrapperSim imagewrappersim, String s)
    {
        if (val$animatableResultsImage != null)
        {
            val$animatableResultsImage.positionOverInitialImage(imagewrappersim.getImageView());
            val$animatableResultsImage.setAnimationSpeed(500);
        }
        val$searchLayout.addProductAfter(val$contentRowEntry, product, s);
        cess._mth500(this._cls0.this).recordSimInteraction();
    }

    m()
    {
        this$0 = final_m;
        val$animatableResultsImage = animatableresultsimage;
        val$searchLayout = searchlayout;
        val$contentRowEntry = LayoutElement.this;
        super();
    }
}
