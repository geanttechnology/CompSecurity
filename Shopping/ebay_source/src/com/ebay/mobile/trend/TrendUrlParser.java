// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.trend;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class TrendUrlParser
{
    class SavedSearchConstants
    {

        public static final String URL_BUYING_FORMATS_ADS = "CLASSIFIED";
        public static final String URL_BUYING_FORMATS_BID = "AUCTION_NOT_WITH_BIN";
        public static final String URL_BUYING_FORMATS_BIN = "AUCTION_WITH_BIN";
        public static final String URL_CONDITION_NEW = "1";
        public static final String URL_CONDITION_UNSPECIFIED = "0";
        public static final String URL_CONDITION_USED = "2";
        public static final String URL_PARAM_ADS = "LH_CAds";
        public static final String URL_PARAM_AVAILABLE_TO = "LH_AvailTo";
        public static final String URL_PARAM_AVAILABLE_TO_COUNTRY = "_saact";
        public static final String URL_PARAM_BID = "LH_Auction";
        public static final String URL_PARAM_BIN = "LH_BIN";
        public static final String URL_PARAM_BUYING_FORMATS = "fslistingtypes";
        public static final String URL_PARAM_CATEGORY = "_sacat";
        public static final String URL_PARAM_COMPLETED = "LH_Complete";
        public static final String URL_PARAM_CONDITION = "LH_ItemCondition";
        public static final String URL_PARAM_DESCRIPTION_SEARCH = "LH_TitleDesc";
        public static final String URL_PARAM_FREE_SHIPPING = "LH_FS";
        public static final String URL_PARAM_KEYWORDS = "_nkw";
        public static final String URL_PARAM_LOCATED_IN = "LH_LocatedIn";
        public static final String URL_PARAM_LOCATED_IN_COUNTRY = "_salic";
        public static final String URL_PARAM_MAX_DISTANCE = "_sadis";
        public static final String URL_PARAM_PAYPAL_ACCEPTED = "LH_PayPal";
        public static final String URL_PARAM_POSTAL_CODE = "_fpos";
        public static final String URL_PARAM_PRICE_MAX = "_udhi";
        public static final String URL_PARAM_PRICE_MIN = "_udlo";
        public static final String URL_PARAM_PRICE_RANGE = "LH_Price";
        public static final String URL_PARAM_SELLER_ID = "_sasl";
        public static final String URL_PARAM_SORT = "_sop";
        public static final String URL_POSTAL_CODE_DEFAULT = "Zip code";
        public static final int URL_SORT_BEST_MATCH = 12;
        public static final int URL_SORT_ENDING_SOONEST = 1;
        public static final int URL_SORT_NEAREST = 7;
        public static final int URL_SORT_NEWLY_LISTED = 10;
        public static final int URL_SORT_PRICE_HIGHEST = 3;
        public static final int URL_SORT_PRICE_LOWEST = 2;
        public static final int URL_SORT_PRICE_PLUS_SHIPPING_HIGHEST = 16;
        public static final int URL_SORT_PRICE_PLUS_SHIPPING_LOWEST = 15;
        final TrendUrlParser this$0;

        SavedSearchConstants()
        {
            this$0 = TrendUrlParser.this;
            super();
        }
    }


    private static final String LOG_TAG = "trendUrlParser";
    private SearchParameters searchParams;
    private Uri uri;

    public TrendUrlParser()
    {
        searchParams = null;
    }

    private boolean isLocSet(String s, String s1)
    {
        s = uri.getQueryParameter(s);
        if (s != null && s.equals("1"))
        {
            s = uri.getQueryParameter(s1);
            if (s != null)
            {
                if (s.equals("1"))
                {
                    s = EbaySite.US;
                } else
                {
                    s = EbaySite.getInstanceFromId(s);
                }
                if (s != null && searchParams.countryId.equals(((EbaySite) (s)).localeCountry))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private List mySplit(String s, String s1)
    {
        s = new StringTokenizer(s, s1);
        s1 = new ArrayList();
        for (; s.hasMoreTokens(); s1.add(s.nextToken())) { }
        return s1;
    }

    private void setCategory()
    {
        String s = uri.getQueryParameter("_sacat");
        if (TextUtils.isEmpty(s) || !TextUtils.isDigitsOnly(s)) goto _L2; else goto _L1
_L1:
        searchParams.category = new EbayCategorySummary(Long.valueOf(s).longValue(), null);
_L4:
        return;
_L2:
        String s1;
        Object obj = uri.getPathSegments();
        if (((List) (obj)).size() <= 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            s1 = (String)((Iterator) (obj)).next();
        } while (TextUtils.isEmpty(s1) || !TextUtils.isDigitsOnly(s1));
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        searchParams.category = new EbayCategorySummary(Long.valueOf(s1).longValue(), null);
        return;
    }

    private void setCondition()
    {
        Object obj = uri.getQueryParameter("LH_ItemCondition");
        if (obj != null)
        {
            obj = mySplit(((String) (obj)), "|").iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((Iterator) (obj)).next();
                if (s.equals("0"))
                {
                    searchParams.condition = "Unspecified";
                } else
                if (s.equals("1"))
                {
                    searchParams.condition = "New";
                } else
                if (s.equals("2"))
                {
                    searchParams.condition = "Used";
                }
            } while (true);
        }
    }

    private void setDescriptionSearch()
    {
        String s = uri.getQueryParameter("LH_TitleDesc");
        if (s != null && s.equals("1"))
        {
            searchParams.descriptionSearch = true;
        }
    }

    private void setFreeShipping()
    {
        String s = uri.getQueryParameter("LH_FS");
        if (s != null && s.equals("1"))
        {
            searchParams.freeShipping = true;
        }
    }

    private void setKeyword()
    {
        String s = uri.getQueryParameter("_nkw");
        SearchParameters searchparameters = searchParams;
        if (s == null)
        {
            s = uri.getLastPathSegment();
        }
        searchparameters.keywords = s;
    }

    private void setListingFormats()
    {
        Object obj = uri.getQueryParameter("fslistingtypes");
        boolean flag5 = false;
        boolean flag2 = false;
        boolean flag4 = false;
        boolean flag = false;
        if (obj != null)
        {
            obj = mySplit(((String) (obj)), "|").iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s1 = (String)((Iterator) (obj)).next();
                if (s1.equalsIgnoreCase("AUCTION_WITH_BIN"))
                {
                    searchParams.buyingFormat = 6;
                    flag = true;
                } else
                if (s1.equalsIgnoreCase("AUCTION_NOT_WITH_BIN"))
                {
                    searchParams.buyingFormat = 5;
                    flag2 = true;
                }
            } while (true);
            if (flag2 && flag)
            {
                searchParams.buyingFormat = 7;
            }
        } else
        {
            String s = uri.getQueryParameter("LH_Auction");
            boolean flag1 = flag5;
            if (s != null)
            {
                flag1 = flag5;
                if (s.equals("1"))
                {
                    searchParams.buyingFormat = 5;
                    flag1 = true;
                }
            }
            s = uri.getQueryParameter("LH_BIN");
            boolean flag3 = flag4;
            if (s != null)
            {
                flag3 = flag4;
                if (s.equals("1"))
                {
                    searchParams.buyingFormat = 6;
                    flag3 = true;
                }
            }
            if (flag1 && flag3)
            {
                searchParams.buyingFormat = 7;
                return;
            }
        }
    }

    private void setLocation()
    {
        if (isLocSet("LH_LocatedIn", "_salic"))
        {
            searchParams.searchLocalCountryOnly = true;
        } else
        if (isLocSet("LH_AvailTo", "_saact"))
        {
            searchParams.searchOtherCountries = true;
            return;
        }
    }

    private void setMaxDistance()
    {
        String s = uri.getQueryParameter("_fpos");
        String s1 = uri.getQueryParameter("_sadis");
        try
        {
            if (!TextUtils.isEmpty(s) && !s.equals("Zip code"))
            {
                searchParams.buyerPostalCode = s;
                if (!TextUtils.isEmpty(s1))
                {
                    searchParams.maxDistance = Integer.valueOf(s1).intValue();
                }
            }
            return;
        }
        catch (NumberFormatException numberformatexception)
        {
            Log.w("trendUrlParser", "max distance ParseException: ");
        }
    }

    private void setPayWithPaypal()
    {
        String s = uri.getQueryParameter("LH_PayPal");
        if (s != null && s.equals("1"))
        {
            searchParams.paypalAccepted = true;
        }
    }

    private void setPrices()
    {
        String s4 = uri.getQueryParameter("_udhi");
        String s2 = uri.getQueryParameter("_udlo");
        String s = s4;
        String s1 = s2;
        if (TextUtils.isEmpty(s4))
        {
            s = s4;
            s1 = s2;
            if (TextUtils.isEmpty(s2))
            {
                String s5 = uri.getQueryParameter("LH_Price");
                s = s4;
                s1 = s2;
                if (!TextUtils.isEmpty(s5))
                {
                    int i = s5.indexOf("..");
                    s = s4;
                    s1 = s2;
                    if (i != -1)
                    {
                        String s3 = s5.substring(0, i);
                        int j = s5.indexOf("@");
                        s = s4;
                        s1 = s3;
                        if (i + 2 < s5.length())
                        {
                            if (j != -1)
                            {
                                s = s5.substring(i + 2, j);
                                s1 = s3;
                            } else
                            {
                                s = s5.substring(i + 2);
                                s1 = s3;
                            }
                        }
                    }
                }
            }
        }
        try
        {
            s3 = searchParams.country.getCurrency().getCurrencyCode();
            if (!TextUtils.isEmpty(s))
            {
                searchParams.maxPrice = new ItemCurrency(s3, String.valueOf(NumberFormat.getInstance().parse(s).doubleValue()));
            }
            if (!TextUtils.isEmpty(s1))
            {
                searchParams.minPrice = new ItemCurrency(s3, String.valueOf(NumberFormat.getInstance().parse(s1).doubleValue()));
            }
            return;
        }
        catch (ParseException parseexception)
        {
            Log.w("trendUrlParser", "min/max price ParseException: ");
        }
    }

    private void setSellerId()
    {
        String s = uri.getQueryParameter("_sasl");
        if (s != null)
        {
            searchParams.sellerId = s;
        }
    }

    private void setSite()
    {
        EbayCountry ebaycountry = EbayCountry.getInstance(EbaySite.getInstanceFromDomain(uri.getHost(), EbaySite.US));
        searchParams.country = ebaycountry;
        searchParams.countryId = ebaycountry.getCountryCode();
        PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getPostalCode();
        if (postalcodespecification != null && ebaycountry.getCountryCode().equals(postalcodespecification.countryCode) && !TextUtils.isEmpty(postalcodespecification.postalCode))
        {
            searchParams.buyerPostalCode = postalcodespecification.postalCode;
            return;
        } else
        {
            searchParams.hideShipping = true;
            return;
        }
    }

    private void setSort()
    {
        String s = uri.getQueryParameter("_sop");
        if (s == null)
        {
            return;
        }
        switch (Integer.valueOf(s).intValue())
        {
        default:
            return;

        case 1: // '\001'
            searchParams.sortOrder = "EndTimeSoonest";
            return;

        case 12: // '\f'
            searchParams.sortOrder = "BestMatch";
            return;

        case 15: // '\017'
            searchParams.sortOrder = "PricePlusShippingLowest";
            return;

        case 16: // '\020'
            searchParams.sortOrder = "PricePlusShippingHighest";
            return;

        case 10: // '\n'
            searchParams.sortOrder = "StartTimeNewest";
            return;

        case 7: // '\007'
            searchParams.sortOrder = "DistanceNearest";
            return;
        }
    }

    public SearchParameters parse(Context context, Uri uri1)
    {
        uri = uri1;
        searchParams = eBayDictionaryProvider.getLockedSearchParameters(context, null);
        setSite();
        setKeyword();
        setCategory();
        setSellerId();
        setPrices();
        setCondition();
        setListingFormats();
        setSort();
        setDescriptionSearch();
        setMaxDistance();
        setLocation();
        return searchParams;
    }
}
