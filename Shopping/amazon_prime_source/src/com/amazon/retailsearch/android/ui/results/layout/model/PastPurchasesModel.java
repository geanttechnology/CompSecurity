// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.model;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Merchant;
import com.amazon.searchapp.retailsearch.model.PastPurchases;
import com.amazon.searchapp.retailsearch.model.PriceInfo;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;
import java.util.List;

public class PastPurchasesModel
{
    public static class Builder
    {

        private PastPurchases pastPurchases;
        private int productImageRes;
        private ResourceProvider resourceProvider;
        private List seeAllLinks;
        private String store;

        public PastPurchasesModel build()
        {
            if (pastPurchases == null || resourceProvider == null || Utils.isEmpty(pastPurchases.getProducts()) || pastPurchases.getProducts().get(0) == null || productImageRes <= 0)
            {
                return null;
            } else
            {
                PastPurchasesModel pastpurchasesmodel = new PastPurchasesModel((Product)pastPurchases.getProducts().get(0), resourceProvider, productImageRes);
                pastpurchasesmodel.setStore(store);
                pastpurchasesmodel.setSeeAllLinks(seeAllLinks);
                return pastpurchasesmodel;
            }
        }

        public Builder setSeeAllLinks(List list)
        {
            seeAllLinks = list;
            return this;
        }

        public Builder setStore(String s)
        {
            store = s;
            return this;
        }

        public Builder(PastPurchases pastpurchases, ResourceProvider resourceprovider, int i)
        {
            pastPurchases = pastpurchases;
            resourceProvider = resourceprovider;
            productImageRes = i;
        }
    }


    private String asin;
    private String buyingPrice;
    private String detailPageUrl;
    private String merchantId;
    private String offerId;
    private String primeBadgeAssetId;
    private Image productImage;
    private ImageRequestFactory productImageFactory;
    private int productImageRes;
    private String productTitle;
    private String purchasedDate;
    private ResourceProvider resourceProvider;
    private List seeAllLinks;
    private String store;

    private PastPurchasesModel(Product product, ResourceProvider resourceprovider, int i)
    {
        resourceProvider = resourceprovider;
        productImageRes = i;
        asin = product.getAsin();
        productTitle = product.getTitle();
        offerId = product.getOfferId();
        productImage = product.getImage();
        purchasedDate = product.getPurchasedDate();
        if (product.getLink() != null)
        {
            detailPageUrl = product.getLink().getUrl();
        }
        if (product.getPrices() != null && product.getPrices().getBuy() != null)
        {
            buyingPrice = product.getPrices().getBuy().getPrice();
        }
        if (product.getShipping() != null && product.getShipping().getPrime() != null && product.getShipping().getPrime().getHasBadge())
        {
            primeBadgeAssetId = product.getShipping().getPrime().getBadgeAssetId();
        }
        if (product.getMerchant() != null)
        {
            merchantId = product.getMerchant().getId();
        }
    }


    private void setSeeAllLinks(List list)
    {
        seeAllLinks = list;
    }

    private void setStore(String s)
    {
        store = s;
    }

    public String getAsin()
    {
        return asin;
    }

    public String getBuyingPrice()
    {
        return buyingPrice;
    }

    public String getDetailPageUrl()
    {
        return detailPageUrl;
    }

    public String getMerchantId()
    {
        return merchantId;
    }

    public String getOfferId()
    {
        return offerId;
    }

    public String getPrimeBadgeAssetId()
    {
        return primeBadgeAssetId;
    }

    public Image getProductImage()
    {
        return productImage;
    }

    public int getProductImageRes()
    {
        return productImageRes;
    }

    public String getProductTitle()
    {
        return productTitle;
    }

    public String getPurchasedDate()
    {
        return purchasedDate;
    }

    public ResourceProvider getResourceProvider()
    {
        return resourceProvider;
    }

    public List getSeeAllLinks()
    {
        return seeAllLinks;
    }

    public String getStore()
    {
        return store;
    }


}
