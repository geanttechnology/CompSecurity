// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.cookies.CookieFactory;
import com.groupon.models.FilterCategory;
import com.groupon.models.Place;
import com.groupon.models.country.Country;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ApiRequestUtil;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CarouselExecutorManager;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.util.SmuggleDealManager;
import com.groupon.util.SmuggleUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            AnyChannelSyncManager

public class NearbySyncManager extends AnyChannelSyncManager
{

    private static final String ALL = "all";
    private Lazy cookieFactory;
    private Lazy currentCountryManager;
    private Lazy deviceInfoUtil;
    private FilterCategory filterCategory;
    private boolean filterModified;
    private LocationsAutocompleteServiceWrapper locationAutocompleteServiceWrapper;
    private ArraySharedPreferences loginPrefs;
    private Lazy loginService;
    private int radius;
    private GeoPoint searchLocation;
    private String searchOrigin;
    private Lazy smuggleDealManager;

    public NearbySyncManager(Context context)
    {
        super(context, "NEARBY");
        filterModified = false;
        searchCategory = "all";
    }

    public NearbySyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, CarouselExecutorManager carouselexecutormanager)
    {
        super(context, pausablethreadpoolexecutor, "NEARBY", carouselexecutormanager);
        filterModified = false;
        searchCategory = "all";
    }

    private void init()
    {
        loginService = new Lazy(context) {

            final NearbySyncManager this$0;

            
            {
                this$0 = NearbySyncManager.this;
                super(context);
            }
        };
        cookieFactory = new Lazy(context) {

            final NearbySyncManager this$0;

            
            {
                this$0 = NearbySyncManager.this;
                super(context);
            }
        };
        deviceInfoUtil = new Lazy(context) {

            final NearbySyncManager this$0;

            
            {
                this$0 = NearbySyncManager.this;
                super(context);
            }
        };
        currentCountryManager = new Lazy(context) {

            final NearbySyncManager this$0;

            
            {
                this$0 = NearbySyncManager.this;
                super(context);
            }
        };
        smuggleDealManager = new Lazy(context) {

            final NearbySyncManager this$0;

            
            {
                this$0 = NearbySyncManager.this;
                super(context);
            }
        };
    }

    protected ArrayList commonNearbyUrlParameters()
    {
        ArrayList arraylist = new ArrayList();
        if (((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "context", "mobile"
            }));
        }
        arraylist.addAll(getBasicNearbyUrlParameters());
        if (Strings.notEmpty(referrer))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referrer", referrer
            }));
        }
        String s = loginPrefs.getString("referralCode", null);
        if (Strings.notEmpty(s))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referral_id", s
            }));
        }
        return arraylist;
    }

    protected volatile void doSync(Object obj, int i, int j)
        throws Exception
    {
        doSync((Void)obj, i, j);
    }

    protected void doSync(Void void1, int i, int j)
        throws Exception
    {
        if (searchLocation != null)
        {
            super.doSync(void1, i, j);
        }
    }

    protected ArrayList filterParameters()
    {
        ArrayList arraylist = new ArrayList();
        if (Strings.notEmpty(filterCategory.getCategoryId()))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "filters", Strings.join(":", new String[] {
                    "category", filterCategory.getCategoryId()
                })
            }));
        }
        if (Strings.notEmpty(filterCategory.getFacetGroupFiltersForCategory()))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "facet_group_filters", filterCategory.getFacetGroupFiltersForCategory()
            }));
        }
        double d;
        if (radius == 0)
        {
            d = 15D;
        } else
        {
            d = radius;
        }
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "radius", Double.valueOf(d)
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "search_origin", searchOrigin
        }));
        if (Strings.notEmpty(locationAutocompleteServiceWrapper.getCurrentlySelectedPlace().value))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "location-query", locationAutocompleteServiceWrapper.getCurrentlySelectedPlace().value
            }));
            return arraylist;
        } else
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "location-query", locationAutocompleteServiceWrapper.getCurrentLocationOrDivisionPlace().value
            }));
            return arraylist;
        }
    }

    protected ArrayList getBasicNearbyUrlParameters()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "visitor_id", ((CookieFactory)cookieFactory.get()).getBrowserCookie()
        }));
        if (((LoginService)loginService.get()).isLoggedIn())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "email_address", ((LoginService)loginService.get()).getEmail()
            }));
        }
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "lat", Float.valueOf(searchLocation.getLatitudeDegrees())
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "lng", Float.valueOf(searchLocation.getLongitudeDegrees())
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", ((DeviceInfoUtil)deviceInfoUtil.get()).getLanguageFromLocale()
        }));
        return arraylist;
    }

    protected List getNameValueParams(int i, int j)
    {
        ArrayList arraylist = commonNearbyUrlParameters();
        if (filterModified)
        {
            arraylist.addAll(filterParameters());
        }
        arraylist.addAll(ApiRequestUtil.generateSearchShowParameter(((IncentivesUtil)incentivesUtil.get()).isExperimentEnabled(), false, false, false));
        if (showSmuggledDeals())
        {
            ((SmuggleUtil)smuggleUtil.get()).addDealIdsToBeSmuggledToNameValuesList(arraylist, ((SmuggleDealManager)smuggleDealManager.get()).getDealIdsToBeSmuggled(Channel.NEARBY.name()));
        }
        return arraylist;
    }

    protected String getUrl(int i, int j)
    {
        String s;
        if (((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isRussia())
        {
            s = "https:/now/deals";
        } else
        {
            s = "https:/deals/search";
        }
        return String.format("%s?offset=%s&limit=%s", new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public void setFilterCategory(FilterCategory filtercategory)
    {
        filterCategory = filtercategory;
    }

    public void setFilterModified(boolean flag)
    {
        filterModified = flag;
    }

    public void setLocationAutocompleteServiceWrapper(LocationsAutocompleteServiceWrapper locationsautocompleteservicewrapper)
    {
        locationAutocompleteServiceWrapper = locationsautocompleteservicewrapper;
    }

    public void setRadius(int i)
    {
        radius = i;
    }

    public void setSearchLocation(GeoPoint geopoint)
    {
        searchLocation = geopoint;
    }

    public void setSearchOrigin(String s)
    {
        searchOrigin = s;
    }
}
