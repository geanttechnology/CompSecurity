// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.UriRequest;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperSim;
import com.amazon.retailsearch.data.sims.SimilaritiesLoader;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.SimsInteractionListener;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.client.MsaUtil;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            RetailSearchResultView, SimsModel

public class Sims extends LinearLayout
    implements RetailSearchResultView
{
    private class SimsViewCallback
        implements com.amazon.retailsearch.data.sims.SimilaritiesLoader.SimsListener
    {

        private final SimsInteractionListener listener;
        private final String merchantId;
        private final ResourceProvider resourceProvider;
        final Sims this$0;

        private boolean validateSimProduct(Product product)
        {
            return product != null && product.getImage() != null && !TextUtils.isEmpty(product.getAsin()) && !TextUtils.isEmpty(product.getTitle()) && product.getLink() != null && !TextUtils.isEmpty(product.getLink().getUrl());
        }

        public void error(Exception exception)
        {
            platform.invokeLater(exception. new Runnable() {

                final SimsViewCallback this$1;
                final Exception val$e;

                public void run()
                {
                    Sims.log.error("Similarites Error", e);
                    setVisibility(8);
                }

            
            {
                this$1 = final_simsviewcallback;
                e = Exception.this;
                super();
            }
            });
        }

        public void result(SearchResult searchresult)
        {
            platform.invokeLater(searchresult. new Runnable() {

                final SimsViewCallback this$1;
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
                        while (i < simsImageWrapper.getChildCount()) 
                        {
                            ImageWrapperSim imagewrappersim = (ImageWrapperSim)simsImageWrapper.getChildAt(i);
                            if (i < j)
                            {
                                final Product product = (Product)result.getSimilarities().getItems().get(i);
                                if (!validateSimProduct(product))
                                {
                                    imagewrappersim.setVisibility(8);
                                } else
                                {
                                    com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperModel imagewrappermodel = (new com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperModel.Builder()).build(product.getAsin(), product.getTitle(), product.getImage(), null, null, imagewrappersim.hasThumbSwitcher(), imageFactory, resourceProvider, false, null);
                                    imagewrappersim.setVisibility(0);
                                    imagewrappersim.buildView(imagewrappermodel, ResultLayoutType.GalleryView);
                                    imagewrappersim.setOnClickListener(imagewrappersim. new android.view.View.OnClickListener() {

                                        final SimsViewCallback._cls1 this$2;
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
                this$1 = final_simsviewcallback;
                result = SearchResult.this;
                super();
            }
            });
        }





        public SimsViewCallback(ResourceProvider resourceprovider, SimsInteractionListener simsinteractionlistener, String s)
        {
            this$0 = Sims.this;
            super();
            resourceProvider = resourceprovider;
            listener = simsinteractionlistener;
            merchantId = s;
        }
    }


    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/results/views/Sims);
    private final int MAX_SIMS;
    private final ImageRequestFactory imageFactory = new ImageRequestFactory() {

        final Sims this$0;

        public ImageRequest fromUrl(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                return null;
            } else
            {
                return new ImageRequest(new UriRequest(MsaUtil.setImageRes(s, getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_sim_image_height))), 160);
            }
        }

            
            {
                this$0 = Sims.this;
                super();
            }
    };
    RetailSearchAndroidPlatform platform;
    private LinearLayout simsImageWrapper;
    private TextView storeName;
    UserInteractionListener userInteractionListener;

    public Sims(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        MAX_SIMS = getResources().getInteger(com.amazon.retailsearch.R.integer.config_rs_max_sims);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void buildView(final SimsModel model, ResultLayoutType resultlayouttype)
    {
        if (model == null)
        {
            setVisibility(8);
            return;
        }
        setVisibility(4);
        (new Thread(new Runnable() {

            final Sims this$0;
            final SimsModel val$model;

            public void run()
            {
                SimilaritiesLoader.getSims(new SimsViewCallback(model.getResourceProvider(), model.getListener(), model.getMerchantId()), model.getAsin(), MAX_SIMS, model.getMerchantId());
            }

            
            {
                this$0 = Sims.this;
                model = simsmodel;
                super();
            }
        })).start();
        if (TextUtils.isEmpty(model.getStoreName()))
        {
            storeName.setVisibility(8);
            return;
        } else
        {
            storeName.setText(model.getStoreName());
            storeName.setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((SimsModel)obj, resultlayouttype);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        simsImageWrapper = (LinearLayout)findViewById(com.amazon.retailsearch.R.id.rs_sim_image_wrapper);
        storeName = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_sim_store_name);
        simsImageWrapper.removeAllViews();
        for (int i = 0; i < MAX_SIMS; i++)
        {
            LayoutInflater.from(getContext()).inflate(com.amazon.retailsearch.R.layout.rs_results_image_wrapper_sim, simsImageWrapper);
        }

    }





}
