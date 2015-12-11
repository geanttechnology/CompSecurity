// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.res.Resources;
import android.text.TextUtils;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.UriRequest;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.retailsearch.android.ui.results.ProductView;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.data.stores.StoreManager;
import com.amazon.retailsearch.interaction.MultiStoreOfferInteractionListener;
import com.amazon.searchapp.retailsearch.client.MsaUtil;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;

public class MultiStoreOfferModel
{
    public static class Builder
    {

        private MultiStoreOfferInteractionListener listener;
        private OfferPosition offerPosition;
        private boolean showBorder;

        public MultiStoreOfferModel build(StoreManager storemanager, Resources resources, ResourceProvider resourceprovider, EditionsPriceInfo editionspriceinfo, ProductViewModel productviewmodel, ProductView productview, int i)
        {
            boolean flag = true;
            if (storemanager == null || resources == null || resourceprovider == null || editionspriceinfo == null || productviewmodel == null || productview == null || showBorder && offerPosition == null)
            {
                return null;
            }
            MultiStoreOfferModel multistoreoffermodel = new MultiStoreOfferModel();
            multistoreoffermodel.setImageFactory(resources. new ImageRequestFactory() {

                final Builder this$0;
                final Resources val$resources;

                public ImageRequest fromUrl(String s)
                {
                    if (TextUtils.isEmpty(s))
                    {
                        return null;
                    } else
                    {
                        return new ImageRequest(new UriRequest(MsaUtil.setImageRes(s, resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_multi_store_image_height))), 160);
                    }
                }

            
            {
                this$0 = final_builder;
                resources = Resources.this;
                super();
            }
            });
            multistoreoffermodel.setResourceProvider(resourceprovider);
            multistoreoffermodel.setOffer(editionspriceinfo);
            multistoreoffermodel.setListener(listener);
            multistoreoffermodel.setPrice(editionspriceinfo.getPrice());
            if (!TextUtils.isEmpty(editionspriceinfo.getUnitPrice()))
            {
                multistoreoffermodel.setUnitOrIssuePrice(editionspriceinfo.getUnitPrice());
            } else
            if (!TextUtils.isEmpty(editionspriceinfo.getIssuePrice()))
            {
                multistoreoffermodel.setUnitOrIssuePrice(editionspriceinfo.getIssuePrice());
            }
            multistoreoffermodel.setListPrice(editionspriceinfo.getListPrice());
            multistoreoffermodel.setBadgeUrl(storemanager.getStoreBadgeUrl(editionspriceinfo.getMerchantId()));
            multistoreoffermodel.setProductViewModel(productviewmodel);
            multistoreoffermodel.setProductView(productview);
            multistoreoffermodel.setOfferPosition(offerPosition);
            multistoreoffermodel.setShowBorder(showBorder);
            if (i <= 1)
            {
                flag = false;
            }
            multistoreoffermodel.setHasMultipleOffers(flag);
            return multistoreoffermodel;
        }

        public Builder setListener(MultiStoreOfferInteractionListener multistoreofferinteractionlistener)
        {
            listener = multistoreofferinteractionlistener;
            return this;
        }

        public Builder setOfferPosition(OfferPosition offerposition)
        {
            offerPosition = offerposition;
            return this;
        }

        public Builder setShowBorder(boolean flag)
        {
            showBorder = flag;
            return this;
        }

        public Builder()
        {
        }
    }

    public static final class OfferPosition extends Enum
    {

        private static final OfferPosition $VALUES[];
        public static final OfferPosition BOTTOM;
        public static final OfferPosition MIDDLE;
        public static final OfferPosition TOP;

        public static OfferPosition valueOf(String s)
        {
            return (OfferPosition)Enum.valueOf(com/amazon/retailsearch/android/ui/results/views/MultiStoreOfferModel$OfferPosition, s);
        }

        public static OfferPosition[] values()
        {
            return (OfferPosition[])$VALUES.clone();
        }

        static 
        {
            TOP = new OfferPosition("TOP", 0);
            BOTTOM = new OfferPosition("BOTTOM", 1);
            MIDDLE = new OfferPosition("MIDDLE", 2);
            $VALUES = (new OfferPosition[] {
                TOP, BOTTOM, MIDDLE
            });
        }

        private OfferPosition(String s, int i)
        {
            super(s, i);
        }
    }


    private String badgeUrl;
    private boolean hasMultipleOffers;
    private ImageRequestFactory imageFactory;
    private String listPrice;
    private MultiStoreOfferInteractionListener listener;
    private EditionsPriceInfo offer;
    private OfferPosition offerPosition;
    private String price;
    private ProductView productView;
    private ProductViewModel productViewModel;
    private ResourceProvider resourceProvider;
    private boolean showBorder;
    private String unitOrIssuePrice;

    public MultiStoreOfferModel()
    {
    }

    private void setBadgeUrl(String s)
    {
        badgeUrl = s;
    }

    private void setImageFactory(ImageRequestFactory imagerequestfactory)
    {
        imageFactory = imagerequestfactory;
    }

    private void setListener(MultiStoreOfferInteractionListener multistoreofferinteractionlistener)
    {
        listener = multistoreofferinteractionlistener;
    }

    private void setOffer(EditionsPriceInfo editionspriceinfo)
    {
        offer = editionspriceinfo;
    }

    private void setOfferPosition(OfferPosition offerposition)
    {
        offerPosition = offerposition;
    }

    private void setPrice(String s)
    {
        price = s;
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

    private void setShowBorder(boolean flag)
    {
        showBorder = flag;
    }

    public String getBadgeUrl()
    {
        return badgeUrl;
    }

    public ImageRequestFactory getImageFactory()
    {
        return imageFactory;
    }

    public String getListPrice()
    {
        return listPrice;
    }

    public MultiStoreOfferInteractionListener getListener()
    {
        return listener;
    }

    public EditionsPriceInfo getOffer()
    {
        return offer;
    }

    public OfferPosition getOfferPosition()
    {
        return offerPosition;
    }

    public String getPrice()
    {
        return price;
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

    public String getUnitOrIssuePrice()
    {
        return unitOrIssuePrice;
    }

    public boolean hasMultipleOffers()
    {
        return hasMultipleOffers;
    }

    public boolean isShowBorder()
    {
        return showBorder;
    }

    public void setHasMultipleOffers(boolean flag)
    {
        hasMultipleOffers = flag;
    }

    protected void setListPrice(String s)
    {
        listPrice = s;
    }

    protected void setUnitOrIssuePrice(String s)
    {
        unitOrIssuePrice = s;
    }










}
