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

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            MultiStoreOfferModel

public static class _cls1.val.resources
{

    private MultiStoreOfferInteractionListener listener;
    private ition offerPosition;
    private boolean showBorder;

    public MultiStoreOfferModel build(StoreManager storemanager, final Resources resources, ResourceProvider resourceprovider, EditionsPriceInfo editionspriceinfo, ProductViewModel productviewmodel, ProductView productview, int i)
    {
        boolean flag = true;
        if (storemanager == null || resources == null || resourceprovider == null || editionspriceinfo == null || productviewmodel == null || productview == null || showBorder && offerPosition == null)
        {
            return null;
        }
        MultiStoreOfferModel multistoreoffermodel = new MultiStoreOfferModel();
        MultiStoreOfferModel.access$000(multistoreoffermodel, new ImageRequestFactory() {

            final MultiStoreOfferModel.Builder this$0;
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
                this$0 = MultiStoreOfferModel.Builder.this;
                resources = resources1;
                super();
            }
        });
        MultiStoreOfferModel.access$100(multistoreoffermodel, resourceprovider);
        MultiStoreOfferModel.access$200(multistoreoffermodel, editionspriceinfo);
        MultiStoreOfferModel.access$300(multistoreoffermodel, listener);
        MultiStoreOfferModel.access$400(multistoreoffermodel, editionspriceinfo.getPrice());
        if (!TextUtils.isEmpty(editionspriceinfo.getUnitPrice()))
        {
            multistoreoffermodel.setUnitOrIssuePrice(editionspriceinfo.getUnitPrice());
        } else
        if (!TextUtils.isEmpty(editionspriceinfo.getIssuePrice()))
        {
            multistoreoffermodel.setUnitOrIssuePrice(editionspriceinfo.getIssuePrice());
        }
        multistoreoffermodel.setListPrice(editionspriceinfo.getListPrice());
        MultiStoreOfferModel.access$500(multistoreoffermodel, storemanager.getStoreBadgeUrl(editionspriceinfo.getMerchantId()));
        MultiStoreOfferModel.access$600(multistoreoffermodel, productviewmodel);
        MultiStoreOfferModel.access$700(multistoreoffermodel, productview);
        MultiStoreOfferModel.access$800(multistoreoffermodel, offerPosition);
        MultiStoreOfferModel.access$900(multistoreoffermodel, showBorder);
        if (i <= 1)
        {
            flag = false;
        }
        multistoreoffermodel.setHasMultipleOffers(flag);
        return multistoreoffermodel;
    }

    public ltipleOffers setListener(MultiStoreOfferInteractionListener multistoreofferinteractionlistener)
    {
        listener = multistoreofferinteractionlistener;
        return this;
    }

    public ition setOfferPosition(ition ition)
    {
        offerPosition = ition;
        return this;
    }

    public offerPosition setShowBorder(boolean flag)
    {
        showBorder = flag;
        return this;
    }

    public _cls1.val.resources()
    {
    }
}
