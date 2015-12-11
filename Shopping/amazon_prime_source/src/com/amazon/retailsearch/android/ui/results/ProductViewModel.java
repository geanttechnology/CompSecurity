// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.text.TextUtils;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.retailsearch.android.ui.animations.AnimatableResultsImage;
import com.amazon.retailsearch.android.ui.buttons.AddToCartState;
import com.amazon.retailsearch.android.ui.results.layout.LayoutElement;
import com.amazon.retailsearch.android.ui.results.layout.SearchLayout;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Merchant;
import com.amazon.searchapp.retailsearch.model.Product;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            OfferKey

public class ProductViewModel
{

    private EditionsPriceInfo activeOffer;
    private final Map addToCartStateMap = new HashMap();
    private final AnimatableResultsImage animationImage;
    private final LayoutElement contentRowEntry;
    private final boolean isImmersiveViewSupported;
    private boolean isMultiStoreExpanded;
    private final Product product;
    private final ImageRequestFactory productImageFactory;
    private final ResourceProvider resourceProvider;
    private final Object resultsModel;
    private final SearchLayout searchLayout;
    private String store;
    UserInteractionListener userInteractionListener;

    public ProductViewModel(Product product1, ImageRequestFactory imagerequestfactory, ResourceProvider resourceprovider, boolean flag, LayoutElement layoutelement, SearchLayout searchlayout, AnimatableResultsImage animatableresultsimage, 
            boolean flag1, String s)
    {
        isMultiStoreExpanded = false;
        RetailSearchDaggerGraphController.inject(this);
        product = product1;
        productImageFactory = imagerequestfactory;
        resourceProvider = resourceprovider;
        isImmersiveViewSupported = flag;
        contentRowEntry = layoutelement;
        searchLayout = searchlayout;
        animationImage = animatableresultsimage;
        if (flag1)
        {
            imagerequestfactory = product1;
        } else
        {
            imagerequestfactory = this;
        }
        resultsModel = imagerequestfactory;
        store = s;
        if (product1.getOffers() != null)
        {
            for (product1 = product1.getOffers().iterator(); product1.hasNext(); addToCartStateMap.put(new OfferKey(imagerequestfactory.getAsin(), imagerequestfactory.getMerchantId()), new AddToCartState()))
            {
                imagerequestfactory = (EditionsPriceInfo)product1.next();
            }

        } else
        if (product1.getMerchant() != null)
        {
            addToCartStateMap.put(new OfferKey(product1.getAsin(), product1.getMerchant().getId()), new AddToCartState());
        }
    }

    private AddToCartState getCartState(String s, String s1, String s2)
    {
        AddToCartState addtocartstate1;
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
        {
            addtocartstate1 = null;
        } else
        {
            OfferKey offerkey = new OfferKey(s, s1);
            addtocartstate1 = (AddToCartState)addToCartStateMap.get(offerkey);
            AddToCartState addtocartstate = addtocartstate1;
            if (addtocartstate1 == null)
            {
                addtocartstate = new AddToCartState();
                addToCartStateMap.put(offerkey, addtocartstate);
            }
            addtocartstate1 = addtocartstate;
            if (!addtocartstate.isUpdated())
            {
                addtocartstate1 = addtocartstate;
                if (addtocartstate.getState() != 2)
                {
                    userInteractionListener.updateCartState(s, s1, s2, addtocartstate);
                    return addtocartstate;
                }
            }
        }
        return addtocartstate1;
    }

    public EditionsPriceInfo getActiveOffer()
    {
        return activeOffer;
    }

    public AnimatableResultsImage getAnimationImage()
    {
        return animationImage;
    }

    public LayoutElement getContentRowEntry()
    {
        return contentRowEntry;
    }

    public AddToCartState getOfferCartState(EditionsPriceInfo editionspriceinfo)
    {
        if (editionspriceinfo == null)
        {
            return null;
        } else
        {
            return getCartState(product.getAsin(), editionspriceinfo.getMerchantId(), editionspriceinfo.getOfferId());
        }
    }

    public Product getProduct()
    {
        return product;
    }

    public ImageRequestFactory getProductImageFactory()
    {
        return productImageFactory;
    }

    public ResourceProvider getResourceProvider()
    {
        return resourceProvider;
    }

    public Object getResultsModel()
    {
        return resultsModel;
    }

    public SearchLayout getSearchLayout()
    {
        return searchLayout;
    }

    public String getStore()
    {
        return store;
    }

    public AddToCartState getVisibleOfferCartState()
    {
        if (activeOffer != null && product != null)
        {
            return getCartState(product.getAsin(), activeOffer.getMerchantId(), activeOffer.getOfferId());
        }
        if (product == null || product.getMerchant() == null)
        {
            return null;
        } else
        {
            return getCartState(product.getAsin(), product.getMerchant().getId(), product.getOfferId());
        }
    }

    public void invalidateCartStates()
    {
        for (Iterator iterator = addToCartStateMap.values().iterator(); iterator.hasNext(); ((AddToCartState)iterator.next()).setIsUpdated(false)) { }
    }

    public boolean isImmersiveViewSupported()
    {
        return isImmersiveViewSupported;
    }

    public boolean isMultiStoreExpanded()
    {
        return isMultiStoreExpanded;
    }

    public void setActiveOffer(EditionsPriceInfo editionspriceinfo)
    {
        activeOffer = editionspriceinfo;
    }

    public void setMultiStoreExpanded(boolean flag)
    {
        isMultiStoreExpanded = flag;
    }

    public void updateActiveOffer(String s)
    {
        if (product != null && !Utils.isEmpty(product.getOffers()) && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        EditionsPriceInfo editionspriceinfo;
        Iterator iterator = product.getOffers().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            editionspriceinfo = (EditionsPriceInfo)iterator.next();
        } while (!s.equals(editionspriceinfo.getMerchantId()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        activeOffer = editionspriceinfo;
        return;
    }
}
