// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperSim;
import com.amazon.retailsearch.interaction.SimsInteractionListener;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            Sims

private class merchantId
    implements com.amazon.retailsearch.data.sims.sListener
{

    private final SimsInteractionListener listener;
    private final String merchantId;
    private final ResourceProvider resourceProvider;
    final Sims this$0;

    private boolean validateSimProduct(Product product)
    {
        return product != null && product.getImage() != null && !TextUtils.isEmpty(product.getAsin()) && !TextUtils.isEmpty(product.getTitle()) && product.getLink() != null && !TextUtils.isEmpty(product.getLink().getUrl());
    }

    public void error(final Exception e)
    {
        platform.invokeLater(new Runnable() {

            final Sims.SimsViewCallback this$1;
            final Exception val$e;

            public void run()
            {
                Sims.access$700().error("Similarites Error", e);
                setVisibility(8);
            }

            
            {
                this$1 = Sims.SimsViewCallback.this;
                e = exception;
                super();
            }
        });
    }

    public void result(final SearchResult result)
    {
        platform.invokeLater(new Runnable() {

            final Sims.SimsViewCallback this$1;
            final SearchResult val$result;

            public void run()
            {
                if (result == null || result.getSimilarities() == null || Utils.isEmpty(result.getSimilarities().getItems()))
                {
                    setVisibility(8);
                } else
                {
                    setVisibility(0);
                    int j = result.getSimilarities().getItems().size();
                    int i = 0;
                    while (i < Sims.access$100(this$0).getChildCount()) 
                    {
                        ImageWrapperSim imagewrappersim = (ImageWrapperSim)Sims.access$100(this$0).getChildAt(i);
                        if (i < j)
                        {
                            final Product product = (Product)result.getSimilarities().getItems().get(i);
                            if (!validateSimProduct(product))
                            {
                                imagewrappersim.setVisibility(8);
                            } else
                            {
                                com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperModel imagewrappermodel = (new com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperModel.Builder()).build(product.getAsin(), product.getTitle(), product.getImage(), null, null, imagewrappersim.hasThumbSwitcher(), Sims.access$300(this$0), resourceProvider, false, null);
                                imagewrappersim.setVisibility(0);
                                imagewrappersim.buildView(imagewrappermodel, ResultLayoutType.GalleryView);
                                imagewrappersim.setOnClickListener(imagewrappersim. new android.view.View.OnClickListener() {

                                    final _cls1 this$2;
                                    final ImageWrapperSim val$imageWrapper;
                                    final Product val$product;

                                    public void onClick(View view)
                                    {
                                        if (listener != null)
                                        {
                                            listener.simSelected(product, imageWrapper, merchantId);
                                        }
                                    }

            
            {
                this$2 = final__pcls1;
                product = product1;
                imageWrapper = ImageWrapperSim.this;
                super();
            }
                                });
                            }
                        } else
                        {
                            imagewrappersim.setVisibility(8);
                        }
                        i++;
                    }
                }
            }

            
            {
                this$1 = Sims.SimsViewCallback.this;
                result = searchresult;
                super();
            }
        });
    }





    public _cls2.val.e(ResourceProvider resourceprovider, SimsInteractionListener simsinteractionlistener, String s)
    {
        this$0 = Sims.this;
        super();
        resourceProvider = resourceprovider;
        listener = simsinteractionlistener;
        merchantId = s;
    }
}
