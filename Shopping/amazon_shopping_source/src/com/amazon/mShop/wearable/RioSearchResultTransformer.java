// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable;

import android.text.TextUtils;
import com.amazon.mShop.wearable.model.WearableSearchResult;
import com.amazon.rio.j2me.client.services.mShop.Badge;
import com.amazon.rio.j2me.client.services.mShop.BadgeInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.HyperText;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import com.amazon.rio.j2me.client.services.mShop.ShippingOffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class RioSearchResultTransformer
{

    private static final Set EXCLUDED_GROUPS;

    public RioSearchResultTransformer()
    {
    }

    public WearableSearchResult apply(SearchResult searchresult)
    {
        Object obj = searchresult.getBasicProduct();
        String s = ((BasicProductInfo) (obj)).getProductGroupId();
        BasicOfferListing basicofferlisting;
        if (!TextUtils.isEmpty(s) && !EXCLUDED_GROUPS.contains(s))
        {
            if ((basicofferlisting = searchresult.getBasicOffer()) != null)
            {
                searchresult = new WearableSearchResult();
                Iterator iterator = basicofferlisting.getAvailabilityMessages().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    HyperText hypertext = (HyperText)iterator.next();
                    if (hypertext.getText() == null || !hypertext.getText().toLowerCase(Locale.US).contains("out of stock"))
                    {
                        continue;
                    }
                    searchresult.setOutOfStock(true);
                    break;
                } while (true);
                searchresult.setName(((BasicProductInfo) (obj)).getTitle());
                if (((BasicProductInfo) (obj)).getVariationPriceRange() != null)
                {
                    searchresult.setVariations(true);
                    searchresult.setAsin(((BasicProductInfo) (obj)).getVariationParentAsin());
                    searchresult.setPrice(((BasicProductInfo) (obj)).getVariationPriceRange());
                } else
                {
                    searchresult.setAsin(((BasicProductInfo) (obj)).getAsin());
                }
                searchresult.setBindingSymbol(((BasicProductInfo) (obj)).getShortDescription());
                searchresult.setImageUrl(((BasicProductInfo) (obj)).getImageUrl());
                if (((BasicProductInfo) (obj)).getAverageOverallRating() != null)
                {
                    searchresult.setAvgRating(((BasicProductInfo) (obj)).getAverageOverallRating().intValue());
                }
                searchresult.setReviewCount(((BasicProductInfo) (obj)).getCustomerReviewsCount());
                searchresult.setOfferId(basicofferlisting.getOfferId());
                if (!searchresult.isVariations())
                {
                    searchresult.setPrice(basicofferlisting.getPrice());
                }
                obj = basicofferlisting.getShippingOffer();
                if (obj != null)
                {
                    searchresult.setShippingOffer(((ShippingOffer) (obj)).getGetItText());
                    searchresult.setShippingCost(((ShippingOffer) (obj)).getPrice());
                }
                if (basicofferlisting.getBadgeInfo() != null && basicofferlisting.getBadgeInfo().getBadge() != null)
                {
                    obj = basicofferlisting.getBadgeInfo().getBadge().getType();
                    if ("PRIME".equals(obj))
                    {
                        searchresult.setPrime(true);
                    }
                    if ("ADD_ON".equals(obj))
                    {
                        searchresult.setAddOnItem(true);
                    }
                    searchresult.setBadge(((String) (obj)));
                }
                if (s != null)
                {
                    searchresult.setGroup(s);
                }
                searchresult.determineBuyable();
                return searchresult;
            }
        }
        return null;
    }

    static 
    {
        HashSet hashset = new HashSet();
        hashset.add("mobile_application");
        EXCLUDED_GROUPS = Collections.unmodifiableSet(hashset);
    }
}
