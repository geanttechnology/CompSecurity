// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Activity;
import android.content.Context;
import com.groupon.Channel;
import com.groupon.cookies.CookieFactory;
import com.groupon.http.Http;
import com.groupon.models.Place;
import com.groupon.models.category.converter.CategoryConverter;
import com.groupon.models.category.json.Facet;
import com.groupon.models.category.json.FacetsContainer;
import com.groupon.models.country.Country;
import com.groupon.network.HttpResponseException;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function1;
import com.groupon.util.GeoPoint;
import com.groupon.util.GlobalCategoriesRequester;
import com.groupon.util.GoodsCategoriesRequester;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.util.SmuggleDealManager;
import com.groupon.util.SmuggleUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            LoginService

public class CategoryService
{

    private static final String DEAL_CATEGORIES_URL = "https:/deals/categories";
    private CategoryConverter categoryConverter;
    private CookieFactory cookieFactory;
    private final String criteria = "category";
    private CurrentCountryManager currentCountryManager;
    private DeviceInfoUtil deviceInfoUtil;
    private LocationsAutocompleteServiceWrapper locationAutocompleteServiceWrapper;
    private ArraySharedPreferences loginPrefs;
    private LoginService loginService;
    private String referrer;
    private SmuggleDealManager smuggleDealManager;
    private SmuggleUtil smuggleUtil;

    public CategoryService()
    {
    }

    private ArrayList commonNearbyUrlParameters(Channel channel, GeoPoint geopoint, double d)
    {
        ArrayList arraylist = new ArrayList();
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "context", "mobile"
            }));
        }
        arraylist.addAll(getBasicNearbyUrlParameters(geopoint));
        if (Strings.notEmpty(referrer))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referrer", referrer
            }));
        }
        geopoint = loginPrefs.getString("referralCode", null);
        if (Strings.notEmpty(geopoint))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referral_id", geopoint
            }));
        }
        smuggleUtil.addDealIdsToBeSmuggledToNameValuesList(arraylist, smuggleDealManager.getDealIdsToBeSmuggled(channel.name()));
        arraylist.addAll(Arrays.asList(new String[] {
            "facets", "category"
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "radius", Double.valueOf(d)
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "offset", Integer.valueOf(0), "limit", Integer.valueOf(0)
        }));
        return arraylist;
    }

    private ArrayList getBasicNearbyUrlParameters(GeoPoint geopoint)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "visitor_id", cookieFactory.getBrowserCookie()
        }));
        if (loginService.isLoggedIn())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "email_address", loginService.getEmail()
            }));
        }
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "lat", Float.valueOf(geopoint.getLatitudeDegrees())
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "lng", Float.valueOf(geopoint.getLongitudeDegrees())
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", deviceInfoUtil.getLanguageFromLocale()
        }));
        return arraylist;
    }

    private List getCategoriesFromFacet(FacetsContainer facetscontainer)
    {
        String s = ((Facet)facetscontainer.facets.get(0)).id;
        if (!Strings.equals(s, "category"))
        {
            Ln.w("Categories:expected %s got %s", new Object[] {
                "category", s
            });
        }
        return categoryConverter.fromJson(facetscontainer, 0);
    }

    public void getGlobalCategories(final Context final_context, String s, String s1, int i, Function1 function1, Function1 function1_1)
    {
        final_context = new GlobalCategoriesRequester("https:/deals/search", s, s1, i, function1, function1_1) {

            final CategoryService this$0;
            final Function1 val$errorCallback;
            final Function1 val$successCallback;

            protected void onException(Exception exception)
            {
                int j;
                if (exception instanceof HttpResponseException)
                {
                    j = ((HttpResponseException)exception).getStatusCode();
                } else
                {
                    j = 0;
                }
                switch (j)
                {
                default:
                    ignoreHttpErrors();
                    if (errorCallback != null)
                    {
                        errorCallback.execute(exception);
                    }
                    return;

                case 401: 
                    break;
                }
                if (errorCallback != null)
                {
                    errorCallback.execute(exception);
                }
                super.onException(exception);
            }

            protected void onSuccess(FacetsContainer facetscontainer)
                throws Exception
            {
                super.onSuccess(facetscontainer);
                facetscontainer = getCategoriesFromFacet(facetscontainer);
                successCallback.execute(facetscontainer);
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((FacetsContainer)obj);
            }

            
            {
                this$0 = CategoryService.this;
                successCallback = function1;
                errorCallback = function1_1;
                super(final_context, final_class1, s, s1, s2, i);
            }
        };
        final_context.setLatitude(Double.valueOf(locationAutocompleteServiceWrapper.getCurrentlySelectedPlace().lat));
        final_context.setLongitude(Double.valueOf(locationAutocompleteServiceWrapper.getCurrentlySelectedPlace().lng));
        final_context.execute();
    }

    public void getGoodsCategories(final Context final_context, Function1 function1)
    {
        (new GoodsCategoriesRequester(com/groupon/models/category/json/FacetsContainer, "https:/deals/search", function1) {

            final CategoryService this$0;
            final Function1 val$successCallback;

            protected void onSuccess(FacetsContainer facetscontainer)
                throws Exception
            {
                super.onSuccess(facetscontainer);
                if (successCallback != null)
                {
                    facetscontainer = getCategoriesFromFacet(facetscontainer);
                    successCallback.execute(facetscontainer);
                }
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((FacetsContainer)obj);
            }

            
            {
                this$0 = CategoryService.this;
                successCallback = function1;
                super(final_context, class1, s);
            }
        }).execute();
    }

    public void getNearbyDealCategories(final Activity final_context, Channel channel, GeoPoint geopoint, double d, Function1 function1)
    {
        String s;
        if (currentCountryManager.getCurrentCountry().isRussia())
        {
            s = "https:/now/deals";
        } else
        {
            s = "https:/deals/search";
        }
        if (currentCountryManager.getCurrentCountry().isRussia())
        {
            channel = getBasicNearbyUrlParameters(geopoint);
        } else
        {
            channel = commonNearbyUrlParameters(channel, geopoint, d);
        }
        if (currentCountryManager.getCurrentCountry().isRussia())
        {
            geopoint = com/groupon/models/category/json/Category$List;
        } else
        {
            geopoint = com/groupon/models/category/json/FacetsContainer;
        }
        if (currentCountryManager.getCurrentCountry().isRussia())
        {
            s = "https:/now/categories";
        }
        (new Http(geopoint, s, channel.toArray(), function1) {

            final CategoryService this$0;
            final Function1 val$successCallback;

            protected void onException(Exception exception)
            {
                int i;
                if (exception instanceof HttpResponseException)
                {
                    i = ((HttpResponseException)exception).getStatusCode();
                } else
                {
                    i = 0;
                }
                switch (i)
                {
                default:
                    ignoreHttpErrors();
                    return;

                case 401: 
                    super.onException(exception);
                    break;
                }
            }

            protected void onSuccess(Object obj)
                throws Exception
            {
                if (currentCountryManager.getCurrentCountry().isRussia())
                {
                    obj = categoryConverter.fromJson((com.groupon.models.category.json.Category.List)obj);
                } else
                {
                    obj = (FacetsContainer)obj;
                    obj = getCategoriesFromFacet(((FacetsContainer) (obj)));
                }
                successCallback.execute(obj);
                Ln.d("NearbyDeals:cat:%s", new Object[] {
                    Integer.valueOf(((List) (obj)).size())
                });
            }

            transient 
            {
                this$0 = CategoryService.this;
                successCallback = function1;
                super(final_context, class1, s, aobj);
            }
        }).execute();
    }

    public ArrayList getPopularSearchesCategoriesParameters()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            s = "mobile_all";
        } else
        {
            s = "mobile_search_intl";
        }
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "relevance_context", s, "lat", Float.valueOf(locationAutocompleteServiceWrapper.getSelectedLocationOrDivisionGeoPoint().getLatitudeDegrees()), "lng", Float.valueOf(locationAutocompleteServiceWrapper.getSelectedLocationOrDivisionGeoPoint().getLongitudeDegrees()), "sort", "popularity"
        }));
        return arraylist;
    }

    public void getSearchDealCategories(final Context final_context, Function1 function1)
    {
        (new Http(com/groupon/models/category/json/Category$List, "https:/deals/categories", getPopularSearchesCategoriesParameters().toArray(), function1) {

            final CategoryService this$0;
            final Function1 val$successCallback;

            protected void onSuccess(com.groupon.models.category.json.Category.List list)
                throws Exception
            {
                super.onSuccess(list);
                successCallback.execute(categoryConverter.fromJson(list));
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((com.groupon.models.category.json.Category.List)obj);
            }

            transient 
            {
                this$0 = CategoryService.this;
                successCallback = function1;
                super(final_context, class1, s, aobj);
            }
        }).execute();
    }



}
