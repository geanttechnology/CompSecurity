// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.results.ContentSwitcher;
import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.ProductView;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.android.ui.results.layout.ImmersiveProduct;
import com.amazon.retailsearch.data.stores.StoreManager;
import com.amazon.retailsearch.interaction.MultiStoreOfferInteractionListener;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import java.util.List;

public class MultiStoreModel
{
    public static class Builder
    {

        public MultiStoreModel build(StoreManager storemanager, ResourceProvider resourceprovider, ProductGestureListener productgesturelistener, ProductView productview, List list, int i, ContentSwitcher contentswitcher, 
                ProductViewModel productviewmodel)
        {
            if (storemanager == null || resourceprovider == null || productgesturelistener == null || productview == null || Utils.isEmpty(list) || contentswitcher == null || productviewmodel == null)
            {
                return null;
            } else
            {
                MultiStoreModel multistoremodel = new MultiStoreModel();
                multistoremodel.setStoreManager(storemanager);
                multistoremodel.setResourceProvider(resourceprovider);
                multistoremodel.setGestureListener(productgesturelistener);
                multistoremodel.setOfferList(list);
                multistoremodel.setNumVisibleOffers(i);
                multistoremodel.setProductView(productview);
                multistoremodel.setListener(productview. new MultiStoreOfferInteractionListener() {

                    final Builder this$0;
                    final ProductView val$productView;

                    public void offerSelected(EditionsPriceInfo editionspriceinfo)
                    {
                        productView.getModel().setActiveOffer(editionspriceinfo);
                        editionspriceinfo = new ContentSwitcherModel(5, com/amazon/retailsearch/android/ui/results/layout/ImmersiveProduct, productView.getModel());
                        productView.switchViewTypes(editionspriceinfo);
                        productView.scrollIntoView();
                    }

            
            {
                this$0 = final_builder;
                productView = ProductView.this;
                super();
            }
                });
                multistoremodel.setContentSwitcher(contentswitcher);
                multistoremodel.setProductViewModel(productviewmodel);
                return multistoremodel;
            }
        }

        public Builder()
        {
        }
    }


    private ContentSwitcher contentSwitcher;
    private ProductGestureListener gestureListener;
    private MultiStoreOfferInteractionListener listener;
    private int numVisibleOffers;
    private List offerList;
    private ProductView productView;
    private ProductViewModel productViewModel;
    private ResourceProvider resourceProvider;
    private StoreManager storeManager;

    public MultiStoreModel()
    {
    }

    private void setContentSwitcher(ContentSwitcher contentswitcher)
    {
        contentSwitcher = contentswitcher;
    }

    private void setGestureListener(ProductGestureListener productgesturelistener)
    {
        gestureListener = productgesturelistener;
    }

    private void setListener(MultiStoreOfferInteractionListener multistoreofferinteractionlistener)
    {
        listener = multistoreofferinteractionlistener;
    }

    private void setNumVisibleOffers(int i)
    {
        numVisibleOffers = i;
    }

    private void setOfferList(List list)
    {
        offerList = list;
    }

    private void setProductView(ProductView productview)
    {
        productView = productview;
    }

    private void setProductViewModel(ProductViewModel productviewmodel)
    {
        productViewModel = productviewmodel;
    }

    private void setResourceProvider(ResourceProvider resourceprovider)
    {
        resourceProvider = resourceprovider;
    }

    private void setStoreManager(StoreManager storemanager)
    {
        storeManager = storemanager;
    }

    public ContentSwitcher getContentSwitcher()
    {
        return contentSwitcher;
    }

    public ProductGestureListener getGestureListener()
    {
        return gestureListener;
    }

    public MultiStoreOfferInteractionListener getListener()
    {
        return listener;
    }

    public int getNumVisibleOffers()
    {
        return numVisibleOffers;
    }

    public List getOfferList()
    {
        return offerList;
    }

    public ProductView getProductView()
    {
        return productView;
    }

    public ProductViewModel getProductViewModel()
    {
        return productViewModel;
    }

    public ResourceProvider getResourceProvider()
    {
        return resourceProvider;
    }

    public StoreManager getStoreManager()
    {
        return storeManager;
    }









}
