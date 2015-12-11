// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragmentActivity

public class SearchDeepLinkUtil
{

    static final String ASPECT_NAME_MAKE = "Make";
    static final String ASPECT_NAME_MODEL = "Model";
    static final String ASPECT_NAME_SUBMODEL = "Submodel";
    static final String ASPECT_NAME_YEAR = "Model Year";
    static final String ITEM_LOCATION_CURRENT_COUNTRY = "territory";
    static final String ITEM_LOCATION_CURRENT_SITE = "marketplace";
    static final String ITEM_LOCATION_INTL = "worldwide";
    static final String KEY_BUYING_FORMAT_AUCTION = "LH_Auction";
    static final String KEY_BUYING_FORMAT_BIN = "LH_BIN";
    static final String KEY_BUYING_FORMAT_BO = "LH_BO";
    static final String KEY_CATEGORY_ID0 = "categoryId";
    static final String KEY_CATEGORY_ID0_COMPAT = "_sacat";
    static final String KEY_CATEGORY_ID1 = "categoryId1";
    static final String KEY_CATEGORY_ID2 = "categoryId2";
    static final String KEY_CATEGORY_NAME = "categoryName";
    static final String KEY_END_YEAR = "endYear";
    static final String KEY_FLAG_BOPIS = "LH_BOPIS";
    static final String KEY_FLAG_CHARITY = "LH_Charity";
    static final String KEY_FLAG_EXPEDITED_SHIPPING = "LH_EXPEDITED";
    static final String KEY_FLAG_FREE_SHIPPING = "LH_FS";
    static final String KEY_ITEM_CONDITION = "LH_ItemCondition";
    static final String KEY_ITEM_LOCATION = "itemLocation";
    static final String KEY_KEYWORDS = "keywords";
    static final String KEY_MAKE = "make";
    static final String KEY_MAX_DISTANCE = "maxDistance";
    static final String KEY_MAX_PRICE = "maxPrice";
    static final String KEY_MIN_PRICE = "minPrice";
    static final String KEY_MODEL = "model";
    static final String KEY_PACKED_ASPECTS = "aspects";
    static final String KEY_SEARCH_COMPLETED_ITEMS = "LH_Complete";
    static final String KEY_SEARCH_DESCRIPTION = "LH_TitleDesc";
    static final String KEY_SEARCH_SOLD_ITEMS = "LH_Sold";
    static final String KEY_SELLER = "seller";
    static final String KEY_START_YEAR = "startYear";
    static final String KEY_SUBMODEL = "submodel";
    static final String KEY_USER_POSTAL_CODE = "userPostalCode";
    static final String KEY_YEAR = "year";
    static final String LINK_SEARCH = "item.query";

    public SearchDeepLinkUtil()
    {
    }

    private static void addSingleValueAspectToSearchParameters(Uri uri, SearchParameters searchparameters, String s, String s1, boolean flag)
    {
        uri = uri.getQueryParameter(s);
        if (TextUtils.isEmpty(uri))
        {
            return;
        } else
        {
            s = new ArrayList();
            com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = new com.ebay.common.model.search.EbayAspectHistogram.AspectValue();
            aspectvalue.value = uri;
            aspectvalue.checked = true;
            s.add(aspectvalue);
            uri = new com.ebay.common.model.search.EbayAspectHistogram.Aspect(s1, s);
            uri.suppressDisplay = flag;
            searchparameters.aspectHistogram.add(uri);
            return;
        }
    }

    private static void addYearAspectsToSearchParameters(SearchParameters searchparameters, String s, String s1, List list)
    {
        if (list != null && list.size() >= 1) goto _L2; else goto _L1
_L1:
        boolean flag;
        boolean flag1;
        if (!TextUtils.isEmpty(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!TextUtils.isEmpty(s1))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag || flag1) goto _L4; else goto _L3
_L3:
        return;
_L4:
        int i = Integer.parseInt(s);
        int j = Integer.parseInt(s1);
        s = new ArrayList();
        for (; i <= j; i++)
        {
            s1 = new com.ebay.common.model.search.EbayAspectHistogram.AspectValue();
            s1.value = (new StringBuilder()).append("").append(i).toString();
            s1.checked = true;
            s.add(s1);
        }

        s = new com.ebay.common.model.search.EbayAspectHistogram.Aspect("Model Year", s);
        s.suppressDisplay = true;
        searchparameters.aspectHistogram.add(s);
        return;
_L2:
        s = new ArrayList();
        s1 = list.iterator();
label0:
        do
        {
label1:
            {
                if (!s1.hasNext())
                {
                    break label1;
                }
                list = (String)s1.next();
                if (list.equals("0"))
                {
                    break label0;
                }
                com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = new com.ebay.common.model.search.EbayAspectHistogram.AspectValue();
                aspectvalue.value = (new StringBuilder()).append("").append(list).toString();
                aspectvalue.checked = true;
                s.add(aspectvalue);
            }
        } while (true);
        if (true) goto _L3; else goto _L5
_L5:
        s = new com.ebay.common.model.search.EbayAspectHistogram.Aspect("Model Year", s);
        s.suppressDisplay = true;
        searchparameters.aspectHistogram.add(s);
        return;
    }

    public static Intent parseDeepLink(Context context, String s, Uri uri)
    {
        if ("item.query".equals(s)) goto _L2; else goto _L1
_L1:
        context = null;
_L5:
        return context;
_L2:
        Intent intent;
        String s1;
        SearchParameters searchparameters;
        Object obj = MyApp.getApp().getResources();
        s1 = uri.getQueryParameter("keywords");
        searchparameters = eBayDictionaryProvider.getLockedSearchParameters(context, s1);
        if (searchparameters == null)
        {
            return null;
        }
        s = com/ebay/mobile/search/SearchResultFragmentActivity;
        Object obj1 = uri.getQueryParameter("seller");
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            s = com/ebay/mobile/search/SearchResultFragmentActivity$SellerItemsActivity;
        }
        intent = new Intent(context, s);
        intent.putExtra("search_param", searchparameters);
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            searchparameters.sellerId = ((String) (obj1));
        }
        s = uri.getQueryParameter("categoryName");
        context = s;
        if (s == null)
        {
            context = "";
        }
        long l3 = tryParseLong(uri.getQueryParameter("categoryId"), -1L);
        long l1 = l3;
        if (l3 == -1L)
        {
            l1 = tryParseLong(uri.getQueryParameter("_sacat"), -1L);
        }
        if (l1 > -1L)
        {
            searchparameters.category = new EbayCategorySummary(l1, context);
        }
        l1 = tryParseLong(uri.getQueryParameter("categoryId1"), -1L);
        if (l1 > -1L)
        {
            searchparameters.category1 = new EbayCategorySummary(l1, context);
        }
        l1 = tryParseLong(uri.getQueryParameter("categoryId2"), -1L);
        if (l1 > -1L)
        {
            searchparameters.category2 = new EbayCategorySummary(l1, context);
        }
        searchparameters.aspectHistogram = new EbayAspectHistogram();
        searchparameters.aspectHistogram.mergeStrategy = com.ebay.common.model.search.EbayAspectHistogram.HistoMergeStrategy.MERGE_SUPPRESS;
        context = uri.getQueryParameter("startYear");
        s = uri.getQueryParameter("endYear");
        obj1 = uri.getQueryParameters("year");
        boolean flag;
        if (!TextUtils.isEmpty(context) || !TextUtils.isEmpty(s) || obj1 != null && ((List) (obj1)).size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            addYearAspectsToSearchParameters(searchparameters, context, s, ((List) (obj1)));
            addSingleValueAspectToSearchParameters(uri, searchparameters, "make", "Make", true);
            addSingleValueAspectToSearchParameters(uri, searchparameters, "model", "Model", true);
            addSingleValueAspectToSearchParameters(uri, searchparameters, "submodel", "Submodel", true);
            return intent;
        }
        context = uri.getQueryParameter("LH_ItemCondition");
        int i;
        boolean flag2;
        if (!TextUtils.isEmpty(context))
        {
            context = context.toLowerCase(Locale.getDefault());
            Object obj2 = Arrays.asList(((Resources) (obj)).getStringArray(0x7f0e000c));
            s = ((Resources) (obj)).getStringArray(0x7f0e000d);
            i = ((List) (obj2)).indexOf(((Resources) (obj)).getString(0x7f07025a));
            int j = ((List) (obj2)).indexOf(((Resources) (obj)).getString(0x7f07025c));
            int l = ((List) (obj2)).indexOf(((Resources) (obj)).getString(0x7f07025b));
            obj = s[i];
            obj2 = s[j];
            s = s[l];
            if (context.equals("any"))
            {
                searchparameters.condition = null;
            } else
            if (context.equals("new") || tryParseLong(context, -1L) == 3L)
            {
                searchparameters.condition = ((String) (obj));
            } else
            if (context.equals("used") || tryParseLong(context, -1L) == 4L)
            {
                searchparameters.condition = ((String) (obj2));
            } else
            if (context.equals("unspecified") || tryParseLong(context, -1L) == 10L)
            {
                searchparameters.condition = s;
            }
        }
        if (tryParseLong(uri.getQueryParameter("LH_BO"), -1L) == 1L)
        {
            searchparameters.buyingFormat = 7;
            searchparameters.bestOfferOnly = true;
        } else
        if (tryParseLong(uri.getQueryParameter("LH_Auction"), -1L) == 1L)
        {
            searchparameters.buyingFormat = 5;
            searchparameters.bestOfferOnly = false;
        } else
        if (tryParseLong(uri.getQueryParameter("LH_BIN"), -1L) == 1L)
        {
            searchparameters.buyingFormat = 6;
            searchparameters.bestOfferOnly = false;
        }
        if (tryParseLong(uri.getQueryParameter("LH_FS"), -1L) == 1L)
        {
            searchparameters.freeShipping = true;
        }
        if (tryParseLong(uri.getQueryParameter("LH_EXPEDITED"), -1L) == 1L)
        {
            searchparameters.expeditedShipping = true;
        }
        if (tryParseLong(uri.getQueryParameter("LH_Charity"), -1L) == 1L)
        {
            searchparameters.ebayGivingWorks = true;
        }
        context = uri.getQueryParameter("userPostalCode");
        if (!TextUtils.isEmpty(context))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0 || !TextUtils.isEmpty(searchparameters.buyerPostalCode))
        {
            if (i != 0)
            {
                searchparameters.buyerPostalCode = context;
            }
            if (tryParseLong(uri.getQueryParameter("LH_BOPIS"), -1L) == 1L)
            {
                searchparameters.inStorePickupOnly = true;
            }
        }
        context = uri.getQueryParameter("LH_Sold");
        s = uri.getQueryParameter("LH_Complete");
        obj = uri.getQueryParameter("LH_TitleDesc");
        if (!TextUtils.isEmpty(context) || !TextUtils.isEmpty(s) || !TextUtils.isEmpty(((CharSequence) (obj))))
        {
            boolean flag3;
            boolean flag4;
            boolean flag5;
            if (tryParseLong(context, -1L) == 1L)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (flag3 || tryParseLong(s, -1L) == 1L)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            if (!flag4 && tryParseLong(((String) (obj)), -1L) == 1L)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            searchparameters.soldItemsOnly = flag3;
            searchparameters.completedListings = flag4;
            searchparameters.descriptionSearch = flag5;
        }
        s = uri.getQueryParameter("minPrice");
        obj = uri.getQueryParameter("maxPrice");
        if (!TextUtils.isEmpty(s))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (i != 0 || flag2)
        {
            if (searchparameters.minPrice != null)
            {
                context = searchparameters.minPrice.code;
            } else
            if (searchparameters.maxPrice != null)
            {
                context = searchparameters.maxPrice.code;
            } else
            {
                context = searchparameters.country.getCurrency().getCurrencyCode();
            }
            if (i != 0)
            {
                s = new ItemCurrency(context, s);
            } else
            {
                s = null;
            }
            searchparameters.minPrice = s;
            if (flag2)
            {
                context = new ItemCurrency(context, ((String) (obj)));
            } else
            {
                context = null;
            }
            searchparameters.maxPrice = context;
        }
        context = uri.getQueryParameter("aspects");
        if (!TextUtils.isEmpty(context))
        {
            context = context.split("\\|");
            l = context.length;
            i = 0;
            while (i < l) 
            {
                s = context[i];
                obj = uri.getQueryParameter(s);
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    String as[] = ((String) (obj)).split("\\|");
                    ArrayList arraylist = new ArrayList();
                    int i1 = as.length;
                    for (int k = 0; k < i1; k++)
                    {
                        String s2 = as[k];
                        com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = new com.ebay.common.model.search.EbayAspectHistogram.AspectValue();
                        aspectvalue.value = s2;
                        aspectvalue.checked = true;
                        arraylist.add(aspectvalue);
                    }

                    s = new com.ebay.common.model.search.EbayAspectHistogram.Aspect(s, arraylist);
                    searchparameters.aspectHistogram.add(s);
                }
                i++;
            }
        }
        context = uri.getQueryParameter("itemLocation");
        if (!"marketplace".equals(context)) goto _L4; else goto _L3
_L3:
        searchparameters.searchLocalCountryOnly = false;
        searchparameters.searchOtherCountries = false;
_L6:
        long l2 = tryParseLong(uri.getQueryParameter("maxDistance"), -1L);
        if (l2 > 0L)
        {
            searchparameters.maxDistance = (int)l2;
        }
        boolean flag1;
        if (s1 != null && s1.length() > 0 || searchparameters.category != null || !TextUtils.isEmpty(searchparameters.sellerId))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        context = intent;
        if (!(true & flag1))
        {
            return null;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if ("territory".equals(context))
        {
            searchparameters.searchLocalCountryOnly = true;
            searchparameters.searchOtherCountries = false;
        } else
        if ("worldwide".equals(context))
        {
            searchparameters.searchLocalCountryOnly = false;
            searchparameters.searchOtherCountries = true;
        }
          goto _L6
    }

    private static long tryParseLong(String s, long l)
    {
        long l1;
        try
        {
            l1 = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return l;
        }
        return l1;
    }
}
