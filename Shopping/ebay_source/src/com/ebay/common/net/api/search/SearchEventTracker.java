// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.common.analytics.AnalyticsUtilHelper;
import com.ebay.common.content.EbayCguidGetter;
import com.ebay.common.content.EbayCguidPersister;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.search:
//            ISearchEventTracker, SearchParameters, ISearchTracking

public final class SearchEventTracker
    implements ISearchEventTracker
{

    private static final Integer FLAG_EXPANSIONS_SURFACED = Integer.valueOf(420);
    private static final Integer FLAG_SAAS_USED = Integer.valueOf(26);
    public static final String IMPRESSION_SEARCH_RESULTS = "SearchResults";
    private static final String SEARCH_SAAS_FLAGSET_NAME = "MagellanFlags";
    private String appliedAspects;
    private String cachedDominateCategory;
    private final EbayCguidPersister cguidPersister;
    private final EbaySite currentSite;
    private String globalFilters;
    private final SearchParameters params;
    private String sortOrder;
    private Bundle trackingBundle;

    public SearchEventTracker(SearchParameters searchparameters, Bundle bundle, EbaySite ebaysite, EbayCguidPersister ebaycguidpersister)
    {
        appliedAspects = null;
        sortOrder = null;
        globalFilters = null;
        cachedDominateCategory = null;
        params = searchparameters;
        trackingBundle = bundle;
        cguidPersister = ebaycguidpersister;
        currentSite = ebaysite;
        initializeAppliedAspects();
        initializeGlobalFilters();
        initializeSortOrder();
    }

    private static String formatPriceForTracking(ItemCurrency itemcurrency)
    {
        if (itemcurrency == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(itemcurrency.code).append(itemcurrency.value).toString();
        }
    }

    private void initializeAppliedAspects()
    {
        StringBuilder stringbuilder;
        if (params.aspectHistogram == null || params.aspectHistogram.isEmpty())
        {
            break MISSING_BLOCK_LABEL_187;
        }
        stringbuilder = new StringBuilder();
        Iterator iterator = params.aspectHistogram.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)iterator.next();
            StringBuilder stringbuilder1 = new StringBuilder();
            Iterator iterator1 = aspect.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)iterator1.next();
                if (aspectvalue.checked)
                {
                    if (stringbuilder1.length() > 0)
                    {
                        stringbuilder1.append(",");
                    }
                    stringbuilder1.append(aspectvalue.value);
                }
            } while (true);
            if (stringbuilder1.length() > 0)
            {
                stringbuilder.append(aspect.name).append(":").append(stringbuilder1.toString()).append(";");
            }
        } while (true);
        appliedAspects = URLEncoder.encode(stringbuilder.toString(), "UTF-8");
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
    }

    private void initializeGlobalFilters()
    {
        ArrayList arraylist = new ArrayList();
        if (params.condition != null)
        {
            arraylist.add("Condition");
        }
        if (params.searchLocalCountryOnly)
        {
            arraylist.add("Location");
        }
        if (params.buyingFormat != 7)
        {
            arraylist.add("Format");
        }
        if (params.minPrice != null || params.maxPrice != null)
        {
            arraylist.add("Price");
        }
        if (params.freeShipping)
        {
            arraylist.add("FreeShipping");
        }
        if (params.expeditedShipping)
        {
            arraylist.add("ExpeditedShipping");
        }
        if (params.inStorePickupOnly)
        {
            arraylist.add("BOPIS");
        }
        if (params.localPickupOnly)
        {
            arraylist.add("LocalMerchantPickup");
        }
        if (params.ebnOnly)
        {
            arraylist.add("eBayNow");
        }
        if (params.sellerId != null)
        {
            arraylist.add("Seller:Specific");
        }
        if (params.returnsAccepted)
        {
            arraylist.add("ReturnsAccepted");
        }
        if (params.completedListings)
        {
            arraylist.add("CompletedItems");
        }
        if (params.soldItemsOnly)
        {
            arraylist.add("SoldItems");
        }
        if (params.paypalAccepted)
        {
            arraylist.add("PayPal");
        }
        if (params.bestOfferOnly)
        {
            arraylist.add("BestOffer");
        }
        if (params.descriptionSearch)
        {
            arraylist.add("DescriptionSearch");
        }
        if (params.ebayPlusOnly)
        {
            arraylist.add("EbayPlus");
        }
        if (params.ebayGivingWorks)
        {
            arraylist.add("eBayCharity");
        }
        if (arraylist.size() > 0)
        {
            globalFilters = TextUtils.join(",", arraylist);
        }
    }

    private void initializeSortOrder()
    {
        if ("EndTimeSoonest".equals(params.sortOrder))
        {
            sortOrder = "1";
        } else
        {
            if ("StartTimeNewest".equals(params.sortOrder))
            {
                sortOrder = "2";
                return;
            }
            if ("CurrentPriceHighest".equals(params.sortOrder))
            {
                sortOrder = "4";
                return;
            }
            if ("BestMatch".equals(params.sortOrder) || params.sortOrder == null)
            {
                sortOrder = "5";
                return;
            }
            if ("PricePlusShippingLowest".equals(params.sortOrder))
            {
                sortOrder = "6";
                return;
            }
            if ("PricePlusShippingHighest".equals(params.sortOrder))
            {
                sortOrder = "7";
                return;
            }
            if ("DistanceNearest".equals(params.sortOrder))
            {
                sortOrder = "8";
                return;
            }
        }
    }

    public String generateSaaSTrackingHeader(EbayContext ebaycontext, int i, String s)
    {
        s = EbayCguidGetter.get(ebaycontext, cguidPersister, currentSite, s);
        return String.format("guid=%s,cguid=%s,pageid=%s", new Object[] {
            EbayIdentity.getDeviceIdString((Context)ebaycontext.getExtension(android/content/Context)), s, Integer.valueOf(i)
        });
    }

    public void trackFindingResponse(Context context, int i, ISearchTracking isearchtracking)
    {
        EbayCategoryHistogram ebaycategoryhistogram;
        Bundle bundle;
        if ("postalCodeTestQuery".equals(params.keywords))
        {
            return;
        }
        int j = isearchtracking.getTotalCount();
        ebaycategoryhistogram = isearchtracking.getCategories();
        Object obj = isearchtracking.getItemIds();
        Integer integer1 = isearchtracking.getAuctionItemCount();
        Integer integer = isearchtracking.getFixedPriceItemCount();
        bundle = new Bundle();
        bundle.putString("eventName", "SearchResults");
        bundle.putString("cpnip", (new StringBuilder()).append("").append(i).toString());
        if (trackingBundle != null)
        {
            bundle.putAll(trackingBundle);
            trackingBundle = null;
        }
        if (obj != null && !((List) (obj)).isEmpty())
        {
            isearchtracking = new StringBuilder();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); isearchtracking.append(Long.toString(((Long)((Iterator) (obj)).next()).longValue(), 36)).append(',')) { }
            if (isearchtracking.length() > 0)
            {
                isearchtracking.deleteCharAt(isearchtracking.length() - 1);
            }
            bundle.putString("itm", isearchtracking.toString());
        }
        bundle.putString("aa", appliedAspects);
        bundle.putString("gf", globalFilters);
        bundle.putString("sQr", params.keywords);
        bundle.putString("sHit", String.valueOf(j));
        if (integer1 == null)
        {
            isearchtracking = "0";
        } else
        {
            isearchtracking = String.valueOf(integer1);
        }
        bundle.putString("nai", isearchtracking);
        if (integer == null)
        {
            isearchtracking = "0";
        } else
        {
            isearchtracking = String.valueOf(integer);
        }
        bundle.putString("nbi", isearchtracking);
        bundle.putString("sort", sortOrder);
        if (params.category == null) goto _L2; else goto _L1
_L1:
        bundle.putString("cat", String.valueOf(params.category.id));
_L4:
        AnalyticsUtilHelper.sendTrackingEvent(bundle, context);
        return;
_L2:
        if (!TextUtils.isEmpty(cachedDominateCategory))
        {
            bundle.putString("tcatid", cachedDominateCategory);
        } else
        if (ebaycategoryhistogram != null && ebaycategoryhistogram.categories != null && ebaycategoryhistogram.categories.size() > 0 && ((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)ebaycategoryhistogram.categories.get(0)).children != null && ((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)ebaycategoryhistogram.categories.get(0)).children.size() > 0)
        {
            cachedDominateCategory = String.valueOf(((com.ebay.common.model.search.EbayCategoryHistogram.Category)((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)ebaycategoryhistogram.categories.get(0)).children.get(0)).id);
            bundle.putString("tcatid", cachedDominateCategory);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void trackResponse(Context context, int i, ISearchTracking isearchtracking)
    {
        if ("postalCodeTestQuery".equals(params.keywords))
        {
            return;
        }
        String s = isearchtracking.getTrackingResponseHeader();
        String s1 = isearchtracking.getRequestCorrelationId();
        Bundle bundle = new Bundle();
        bundle.putString("eventName", "SearchResults");
        bundle.putString("cpnip", (new StringBuilder()).append("").append(i).toString());
        if (trackingBundle != null)
        {
            bundle.putAll(trackingBundle);
            trackingBundle = null;
        }
        if (params.ebayPlusOnly)
        {
            isearchtracking = "1";
        } else
        {
            isearchtracking = "0";
        }
        bundle.putString("plusfilter", isearchtracking);
        if (!TextUtils.isEmpty(s))
        {
            bundle.putString("trknvpsvc", s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            bundle.putString("rq", s1);
        }
        bundle.putString("aa", appliedAspects);
        bundle.putString("gf", globalFilters);
        bundle.putString("sort", sortOrder);
        bundle.putString("mnprc", formatPriceForTracking(params.minPrice));
        bundle.putString("mxprc", formatPriceForTracking(params.maxPrice));
        AnalyticsUtilHelper.sendTrackingEvent(bundle, context);
    }

}
