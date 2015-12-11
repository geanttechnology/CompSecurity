// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

// Referenced classes of package com.ebay.mobile.search:
//            SavedSearchListActivity

public static class _savedSearch
{

    private SavedSearch _savedSearch;
    private SearchParameters _searchParams;
    private Uri _uri;
    private Authentication auth;

    private boolean isLocSet(String s, String s1)
    {
        s = _uri.getQueryParameter(s);
        if (s != null && s.equals("1"))
        {
            s = _uri.getQueryParameter(s1);
            if (s != null)
            {
                if (s.equals("1"))
                {
                    s = EbaySite.US;
                } else
                {
                    s = EbaySite.getInstanceFromId(s);
                }
                if (s != null && _searchParams.countryId.equals(((EbaySite) (s)).localeCountry))
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
        String s = _uri.getQueryParameter("_sacat");
        if (TextUtils.isEmpty(s) || !TextUtils.isDigitsOnly(s)) goto _L2; else goto _L1
_L1:
        _searchParams.category = new EbayCategorySummary(Long.valueOf(s).longValue(), null);
_L4:
        return;
_L2:
        String s1;
        Object obj = _uri.getPathSegments();
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
        _searchParams.category = new EbayCategorySummary(Long.valueOf(s1).longValue(), null);
        return;
    }

    private void setCompletedListings()
    {
        String s = _uri.getQueryParameter("LH_Complete");
        if (s != null && s.equals("1"))
        {
            _searchParams.completedListings = true;
            String s1;
            if (auth == null)
            {
                s1 = null;
            } else
            {
                s1 = auth.iafToken;
            }
            _searchParams.iafToken = s1;
        }
    }

    private void setCondition()
    {
        Object obj = _uri.getQueryParameter("LH_ItemCondition");
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
                    _searchParams.condition = "Unspecified";
                } else
                if (s.equals("1"))
                {
                    _searchParams.condition = "New";
                } else
                if (s.equals("2"))
                {
                    _searchParams.condition = "Used";
                }
            } while (true);
        }
    }

    private void setDescriptionSearch()
    {
        String s = _uri.getQueryParameter("LH_TitleDesc");
        if (s != null && s.equals("1"))
        {
            _searchParams.descriptionSearch = true;
        }
    }

    private void setFreeShipping()
    {
        String s = _uri.getQueryParameter("LH_FS");
        if (s != null && s.equals("1"))
        {
            _searchParams.freeShipping = true;
        }
    }

    private void setKeyword()
    {
        String s = _uri.getQueryParameter("_nkw");
        _searchParams.keywords = s;
        if (TextUtils.isEmpty(s) && !TextUtils.isEmpty(_savedSearch.keywords))
        {
            _searchParams.keywords = _savedSearch.keywords;
        }
    }

    private void setListingFormats()
    {
        Object obj = _uri.getQueryParameter("fslistingtypes");
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
                    _searchParams.buyingFormat = 6;
                    flag = true;
                } else
                if (s1.equalsIgnoreCase("AUCTION_NOT_WITH_BIN"))
                {
                    _searchParams.buyingFormat = 5;
                    flag2 = true;
                }
            } while (true);
            if (flag2 && flag)
            {
                _searchParams.buyingFormat = 7;
            }
        } else
        {
            String s = _uri.getQueryParameter("LH_Auction");
            boolean flag1 = flag5;
            if (s != null)
            {
                flag1 = flag5;
                if (s.equals("1"))
                {
                    _searchParams.buyingFormat = 5;
                    flag1 = true;
                }
            }
            s = _uri.getQueryParameter("LH_BIN");
            boolean flag3 = flag4;
            if (s != null)
            {
                flag3 = flag4;
                if (s.equals("1"))
                {
                    _searchParams.buyingFormat = 6;
                    flag3 = true;
                }
            }
            if (flag1 && flag3)
            {
                _searchParams.buyingFormat = 7;
                return;
            }
        }
    }

    private void setLocation()
    {
        if (isLocSet("LH_LocatedIn", "_salic"))
        {
            _searchParams.searchLocalCountryOnly = true;
        } else
        if (isLocSet("LH_AvailTo", "_saact"))
        {
            _searchParams.searchOtherCountries = true;
            return;
        }
    }

    private void setMaxDistance()
    {
        String s = _uri.getQueryParameter("_fpos");
        String s1 = _uri.getQueryParameter("_sadis");
        try
        {
            if (!TextUtils.isEmpty(s) && !s.equals("Zip code"))
            {
                _searchParams.buyerPostalCode = s;
                if (!TextUtils.isEmpty(s1))
                {
                    _searchParams.maxDistance = Integer.valueOf(s1).intValue();
                }
            }
            return;
        }
        catch (NumberFormatException numberformatexception)
        {
            Log.w("SavedSearchListActivity", (new StringBuilder()).append("maxDistance NumberFormatException: ").append(_savedSearch.query).toString());
        }
    }

    private void setPayWithPaypal()
    {
        String s = _uri.getQueryParameter("LH_PayPal");
        if (s != null && s.equals("1"))
        {
            _searchParams.paypalAccepted = true;
        }
    }

    private void setPrices()
    {
        String s4 = _uri.getQueryParameter("_udhi");
        String s2 = _uri.getQueryParameter("_udlo");
        String s = s4;
        String s1 = s2;
        if (TextUtils.isEmpty(s4))
        {
            s = s4;
            s1 = s2;
            if (TextUtils.isEmpty(s2))
            {
                String s5 = _uri.getQueryParameter("LH_Price");
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
            s3 = _searchParams.country.getCurrency().getCurrencyCode();
            if (!TextUtils.isEmpty(s))
            {
                _searchParams.maxPrice = new ItemCurrency(s3, String.valueOf(NumberFormat.getInstance().parse(s).doubleValue()));
            }
            if (!TextUtils.isEmpty(s1))
            {
                _searchParams.minPrice = new ItemCurrency(s3, String.valueOf(NumberFormat.getInstance().parse(s1).doubleValue()));
            }
            return;
        }
        catch (ParseException parseexception)
        {
            Log.w("SavedSearchListActivity", (new StringBuilder()).append("min/max price ParseException: ").append(_savedSearch.query).toString());
        }
    }

    private void setSellerId()
    {
        String s = _uri.getQueryParameter("_sasl");
        if (s != null)
        {
            _searchParams.sellerId = s;
        }
    }

    private void setSite()
    {
        EbayCountry ebaycountry = EbayCountry.getInstance(EbaySite.getInstanceFromDomain(_uri.getHost(), EbaySite.US));
        _searchParams.country = ebaycountry;
        _searchParams.countryId = ebaycountry.getCountryCode();
        PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getPostalCode();
        if (postalcodespecification != null && ebaycountry.getCountryCode().equals(postalcodespecification.countryCode) && !TextUtils.isEmpty(postalcodespecification.postalCode))
        {
            _searchParams.buyerPostalCode = postalcodespecification.postalCode;
            return;
        } else
        {
            _searchParams.hideShipping = true;
            return;
        }
    }

    private void setSort()
    {
        String s = _uri.getQueryParameter("_sop");
        if (s == null)
        {
            return;
        }
        switch (Integer.valueOf(s).intValue())
        {
        default:
            return;

        case 1: // '\001'
            _searchParams.sortOrder = "EndTimeSoonest";
            return;

        case 12: // '\f'
            _searchParams.sortOrder = "BestMatch";
            return;

        case 15: // '\017'
            _searchParams.sortOrder = "PricePlusShippingLowest";
            return;

        case 16: // '\020'
            _searchParams.sortOrder = "PricePlusShippingHighest";
            return;

        case 10: // '\n'
            _searchParams.sortOrder = "StartTimeNewest";
            return;

        case 7: // '\007'
            _searchParams.sortOrder = "DistanceNearest";
            return;
        }
    }

    void parse()
    {
        setSite();
        setKeyword();
        setCategory();
        setSellerId();
        setPrices();
        setCondition();
        setListingFormats();
        setCompletedListings();
        setFreeShipping();
        setPayWithPaypal();
        setSort();
        setDescriptionSearch();
        setMaxDistance();
        setLocation();
    }

    public (SavedSearch savedsearch, Authentication authentication)
    {
        auth = authentication;
        if (TextUtils.isEmpty(savedsearch.query))
        {
            if (savedsearch.searchParameters != null)
            {
                savedsearch.keywords = savedsearch.searchParameters.keywords;
                _savedSearch.setQueryParsed(true);
                return;
            } else
            {
                Log.w("SavedSearchListActivity", "SearchQueryParser, invalid input saved search: both query and search params are null");
                return;
            }
        }
        try
        {
            _uri = Uri.parse(savedsearch.query.replace("+", "%20"));
            _searchParams = savedsearch.searchParameters;
            _savedSearch = savedsearch;
            parse();
            _savedSearch.setQueryParsed(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SavedSearch savedsearch)
        {
            Log.w("SavedSearchListActivity", (new StringBuilder()).append("MalformedURL: ").append(_savedSearch.query).toString());
        }
    }
}
