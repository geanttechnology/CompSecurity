// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.text.TextUtils;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.animations.AnimatableResultsImage;
import com.amazon.retailsearch.android.ui.results.layout.LayoutElement;
import com.amazon.retailsearch.android.ui.results.layout.SearchLayout;
import com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperSim;
import com.amazon.retailsearch.interaction.SimsInteractionListener;
import com.amazon.searchapp.retailsearch.model.Product;

public class SimsModel
{
    public static class Builder
    {

        private String asin;
        private SimsInteractionListener listener;
        private String merchantId;
        private ResourceProvider resourceProvider;
        private final RetailSearchLogger retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        private String storeName;

        public SimsModel build(String s, ResourceProvider resourceprovider)
        {
            if (TextUtils.isEmpty(s) || resourceprovider == null)
            {
                return null;
            } else
            {
                asin = s;
                resourceProvider = resourceprovider;
                return new SimsModel(this);
            }
        }

        public Builder setImmersiveViewListener(LayoutElement layoutelement, final SearchLayout searchLayout, final AnimatableResultsImage animatableResultsImage)
        {
            if (layoutelement == null || searchLayout == null)
            {
                return this;
            } else
            {
                listener = layoutelement. new SimsInteractionListener() {

                    final Builder this$0;
                    final AnimatableResultsImage val$animatableResultsImage;
                    final LayoutElement val$contentRowEntry;
                    final SearchLayout val$searchLayout;

                    public void simSelected(Product product, ImageWrapperSim imagewrappersim, String s)
                    {
                        if (animatableResultsImage != null)
                        {
                            animatableResultsImage.positionOverInitialImage(imagewrappersim.getImageView());
                            animatableResultsImage.setAnimationSpeed(500);
                        }
                        searchLayout.addProductAfter(contentRowEntry, product, s);
                        retailSearchLogger.recordSimInteraction();
                    }

            
            {
                this$0 = final_builder;
                animatableResultsImage = animatableresultsimage;
                searchLayout = searchlayout;
                contentRowEntry = LayoutElement.this;
                super();
            }
                };
                return this;
            }
        }

        public Builder setMerchantId(String s)
        {
            merchantId = s;
            return this;
        }

        public Builder setStoreName(String s)
        {
            storeName = s;
            return this;
        }







        public Builder()
        {
        }
    }


    private final String asin;
    private final SimsInteractionListener listener;
    private final String merchantId;
    private final ResourceProvider resourceProvider;
    private final String storeName;

    private SimsModel(Builder builder)
    {
        asin = builder.asin;
        resourceProvider = builder.resourceProvider;
        listener = builder.listener;
        storeName = builder.storeName;
        merchantId = builder.merchantId;
    }


    public String getAsin()
    {
        return asin;
    }

    public SimsInteractionListener getListener()
    {
        return listener;
    }

    public String getMerchantId()
    {
        return merchantId;
    }

    public ResourceProvider getResourceProvider()
    {
        return resourceProvider;
    }

    public String getStoreName()
    {
        return storeName;
    }
}
