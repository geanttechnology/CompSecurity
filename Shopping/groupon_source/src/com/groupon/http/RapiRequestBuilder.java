// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.content.Context;
import com.groupon.cookies.CookieFactory;
import com.groupon.models.Place;
import com.groupon.models.category.Category;
import com.groupon.models.search.domain.FacetFilter;
import com.groupon.models.search.domain.Filter;
import com.groupon.models.search.domain.SortMethod;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CountryUtil;
import com.groupon.util.RapiRequestProperties;
import com.groupon.util.ShowPropertyParam;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class RapiRequestBuilder
{
    public static class Band
    {

        public static final String MESSAGE = "message";

        private Band()
        {
        }
    }

    public static class Facet
    {

        public static final String BOOKABLE = "bookable";
        public static final String BRAND = "brand_uuid";
        public static final String CATEGORY_ATTRIBUTES = "category_attributes";
        public static final String CATEGORY_SUB_SUB2 = "topcategory|category|subcategory|subcategory2";
        public static final String DISTANCE = "distance";
        public static final String PRICE = "price";

        private Facet()
        {
        }
    }

    public static class Filter
    {

        public static final String BOOKABLE = "bookable";
        public static final String BUFFER = "buffer";
        public static final String CATEGORY = "category";
        public static final String PARTY_SIZE = "partySize";
        public static final String TIME = "time";

        private Filter()
        {
        }
    }

    public static class Filter.Category
    {

        public static final String ALL = "all";
        public static final String BEAUTY_AND_SPAS = "beauty-and-spas";
        public static final String FOOD_AND_DRINK = "food-and-drink";
        public static final String HAIR_REMOVAL = "hair-removal";
        public static final String HAIR_SALONS = "hair-salons";
        public static final String MASSAGE = "massage";
        public static final String NAIL_SALONS = "nail-salons";
        public static final String SKIN_CARE = "skin-care";

        private Filter.Category()
        {
        }
    }

    public static class PageType
    {

        public static final String ALL = "all";
        public static final String FEATURED = "featured";
        public static final String GETAWAYS = "getaways";
        public static final String GOODS = "goods";
        public static final String LOCAL = "local";
        public static final String SEARCH = "search";

        private PageType()
        {
        }
    }

    public static class Platform
    {

        public static final String ANDCON = "andcon";

        private Platform()
        {
        }
    }

    public static class Show
    {

        public static final String BANDS = "bands";
        public static final String COLLECTIONS = "collections";
        public static final String DEALS = "deals";
        public static final String FINDERS = "finders";
        public static final String MERCHANTS = "merchants";
        public static final String U_BADGES = "_badges";
        public static final String _METADATA = "_metadata";

        private Show()
        {
        }
    }


    public static final String BOOKABLE = "bookable";
    public static final String CADATRON_CLIENT_ID = "deck_client_id";
    public static final String CATEGORY = "category";
    private static final int CHILD_CATEGORY_LEVEL = 2;
    public static final String CLL = "cll";
    public static final String CONSUMER_ID = "consumer_id";
    public static final String DECK_ID = "deck_id";
    public static final String ELL = "ell";
    public static final String FACET_FILTER = "facet_filter";
    public static final String FILTER = "filter";
    public static final String LIMIT = "limit";
    public static final String LOCALE = "locale";
    public static final String OFFSET = "offset";
    public static final String PAGE_TYPE = "page_type";
    public static final String PLATFORM = "platform";
    public static final String QUERY = "query";
    public static final String RADIUS_KM = "radius_km";
    private static final int ROOT_CATEGORY_LEVEL = 1;
    public static final String SEGMENT_LIMIT = "segment_limit";
    public static final String SHOW = "show";
    public static final String SMUGGLE = "smuggle";
    public static final String SORT = "sort";
    public static final String SUBCATEGORY = "subcategory";
    public static final String TOP_CATEGORY_FORMAT = "topcategory:%1$s";
    public static final String VISITOR_ID = "visitor_id";
    private CookieFactory cookieFactory;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private LoginService loginService;
    private RapiRequestProperties requestProperties;

    public RapiRequestBuilder(Context context, RapiRequestProperties rapirequestproperties)
    {
        requestProperties = rapirequestproperties;
        RoboGuice.getInjector(context).injectMembers(this);
    }

    private String buildShowParams()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = requestProperties.showParams.iterator(); iterator.hasNext(); arraylist.add(((ShowPropertyParam)iterator.next()).asUrlParam())) { }
        return Strings.join(";", arraylist);
    }

    private String getFilterNameForCategoryEntry(java.util.Map.Entry entry)
    {
        int i = ((Integer)entry.getValue()).intValue();
        if (i == 1)
        {
            return "category";
        }
        if (i == 2)
        {
            return "subcategory";
        } else
        {
            return (new StringBuilder()).append("subcategory").append(i - 1).toString();
        }
    }

    public Object[] build()
    {
        ArrayList arraylist;
        String s;
        Object obj;
        Object obj1;
        String s1;
        Object obj2;
        arraylist = new ArrayList();
        if (requestProperties == null)
        {
            return arraylist.toArray();
        }
        obj2 = requestProperties.expressedLocation;
        Place place = requestProperties.currentLocation;
        obj1 = requestProperties.searchQuery;
        s1 = requestProperties.currentCategoryId;
        obj = requestProperties.selectedCategory;
        s = requestProperties.availableFacetGroupFiltersFromDeepLink;
        arraylist.addAll(Arrays.asList(new String[] {
            "platform", "andcon"
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "limit", Integer.valueOf(requestProperties.limit)
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "offset", Integer.valueOf(requestProperties.offset)
        }));
        String s2 = buildShowParams();
        if (Strings.notEmpty(s2))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "show", s2
            }));
        }
        if (Strings.notEmpty(requestProperties.pageType))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "page_type", requestProperties.pageType
            }));
        }
        if (obj2 != null)
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "ell", String.format(Locale.US, "%f,%f", new Object[] {
                    Double.valueOf(((Place) (obj2)).lat), Double.valueOf(((Place) (obj2)).lng)
                })
            }));
        }
        if (place != null)
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "cll", String.format(Locale.US, "%f,%f", new Object[] {
                    Double.valueOf(place.lat), Double.valueOf(place.lng)
                })
            }));
        }
        obj2 = loginService.getConsumerId();
        if (obj2 != null && !((String) (obj2)).isEmpty())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "consumer_id", obj2
            }));
        }
        obj2 = currentCountryManager.getCurrentCountry();
        if (obj2 != null)
        {
            obj2 = countryUtil.getCountryLocale(((com.groupon.models.country.Country) (obj2)));
            if (obj2 != null)
            {
                arraylist.addAll(Arrays.asList(new Serializable[] {
                    "locale", obj2
                }));
            }
        }
        obj2 = cookieFactory.getBrowserCookie();
        if (Strings.notEmpty(obj2))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "visitor_id", obj2
            }));
        }
        if (requestProperties.findShowParam("collections") != null)
        {
            obj2 = requestProperties.deckId;
            if (Strings.notEmpty(obj2))
            {
                arraylist.addAll(Arrays.asList(new String[] {
                    "deck_id", obj2
                }));
                arraylist.addAll(Arrays.asList(new String[] {
                    "deck_client_id", "852e9f0d-2049-41be-a7e6-a9e3750c0c05"
                }));
            }
        }
        if (requestProperties.findShowParam("finders") != null)
        {
            obj2 = requestProperties.bookable;
            if (Strings.notEmpty(obj2))
            {
                arraylist.addAll(Arrays.asList(new String[] {
                    "bookable", obj2
                }));
            }
        }
        if (requestProperties.radiusKm > 0)
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "radius_km", Integer.valueOf(requestProperties.radiusKm)
            }));
        }
        obj2 = new ArrayList();
        if (requestProperties.searchChannelFilter == null) goto _L2; else goto _L1
_L1:
        ((ArrayList) (obj2)).add(String.format("topcategory:%1$s", new Object[] {
            requestProperties.searchChannelFilter
        }));
_L9:
        if (!Strings.notEmpty(obj1)) goto _L4; else goto _L3
_L3:
        if (!Strings.notEmpty(s1)) goto _L6; else goto _L5
_L5:
        ((ArrayList) (obj2)).add((new StringBuilder()).append("category:").append(s1).toString());
_L4:
        if (requestProperties != null && requestProperties.filters.size() > 0)
        {
            for (obj = requestProperties.filters.iterator(); ((Iterator) (obj)).hasNext(); ((ArrayList) (obj2)).add(((com.groupon.models.search.domain.Filter)((Iterator) (obj)).next()).asUrlParam())) { }
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (obj != null)
        {
            com.groupon.models.category.Category category = (com.groupon.models.category.Category)((java.util.Map.Entry) (obj)).getKey();
            if (category != null && category.parent != null && category.parent.id != null)
            {
                ((ArrayList) (obj2)).add(String.format("topcategory:%1$s", new Object[] {
                    category.parent.id
                }));
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (obj != null)
        {
            if (!((com.groupon.models.category.Category)((java.util.Map.Entry) (obj)).getKey()).isAllDeals)
            {
                obj1 = new StringBuilder(getFilterNameForCategoryEntry(((java.util.Map.Entry) (obj))));
                ((StringBuilder) (obj1)).append(":");
                ((StringBuilder) (obj1)).append(((com.groupon.models.category.Category)((java.util.Map.Entry) (obj)).getKey()).id);
                ((ArrayList) (obj2)).add(((StringBuilder) (obj1)).toString());
            }
        } else
        if (Strings.isEmpty(s))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "query", obj1
            }));
        }
        if (true) goto _L4; else goto _L7
_L7:
        if (Strings.notEmpty(requestProperties.finderCardFilter))
        {
            ((ArrayList) (obj2)).add(requestProperties.finderCardFilter);
        }
        if (!((ArrayList) (obj2)).isEmpty())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "filter", Strings.join(" AND ", ((java.util.Collection) (obj2)))
            }));
        }
        ArrayList arraylist1 = new ArrayList();
        if (requestProperties != null && requestProperties.facetFilters.size() > 0)
        {
            ArrayList arraylist2 = new ArrayList();
            for (Iterator iterator = requestProperties.facetFilters.iterator(); iterator.hasNext(); arraylist2.add(((FacetFilter)iterator.next()).asUrlParam())) { }
            arraylist1.add(Strings.join(",", arraylist2));
        }
        if (Strings.notEmpty(s))
        {
            arraylist1.add(s);
        }
        if (arraylist1.size() != 0)
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "facet_filter", Strings.join(",", arraylist1)
            }));
        }
        if (requestProperties != null && requestProperties.sortMethod != null && requestProperties.sortMethod != com.groupon.models.search.domain.SortMethod.Methods.RELEVANCE)
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "sort", requestProperties.sortMethod.id
            }));
        }
        if (!requestProperties.smuggledDeals.isEmpty())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "smuggle", Strings.join(",", requestProperties.smuggledDeals)
            }));
        }
        if (requestProperties.segmentLimit > 0)
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "segment_limit", Integer.valueOf(requestProperties.segmentLimit)
            }));
        }
        return arraylist.toArray();
        if (true) goto _L9; else goto _L8
_L8:
    }
}
