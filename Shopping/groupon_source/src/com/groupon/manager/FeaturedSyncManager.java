// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import android.location.Location;
import com.groupon.Channel;
import com.groupon.abtest.GtgAbTestHelper;
import com.groupon.abtest.RtrAbTestHelper;
import com.groupon.models.country.Country;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ApiGenerateShowParamBuilder;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CarouselExecutorManager;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DivisionUtil;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.util.SmuggleDealManager;
import com.groupon.util.SmuggleUtil;
import com.groupon.util.ZeroDay;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            AnyChannelSyncManager, WidgetOnFeaturedSyncHelper

public class FeaturedSyncManager extends AnyChannelSyncManager
{

    private GtgAbTestHelper gtgAbTestHelper;
    private boolean isRtrOnFeaturedEnabled;
    private boolean isShowBadgeOnGAPIFeaturedTab1509USCA;
    private Lazy locationService;
    private ArraySharedPreferences loginPrefs;
    private Lazy loginService;
    private RtrAbTestHelper rtrAbTestHelper;
    private Lazy smuggleDealManager;
    private WidgetOnFeaturedSyncHelper widgetOnFeaturedSyncHelper;
    private Lazy zeroDay;

    public FeaturedSyncManager(Context context)
    {
        super(context, "FEATURED");
        searchCategory = "all";
    }

    public FeaturedSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, CarouselExecutorManager carouselexecutormanager)
    {
        super(context, pausablethreadpoolexecutor, "FEATURED", carouselexecutormanager);
        searchCategory = "all";
    }

    public ArrayList constructTodaysDealUrlNameValuePairs(Location location, String s, ZeroDay zeroday, ArraySharedPreferences arraysharedpreferences, boolean flag, boolean flag1)
        throws CountryNotSupportedException
    {
        ArrayList arraylist = new ArrayList();
        Object obj = (new ApiGenerateShowParamBuilder()).dealOptionGiftWrappingCharge(true).bookingUpdatesSchedulerOptions(true).incentives(((IncentivesUtil)incentivesUtil.get()).isExperimentEnabled()).badges(isShowBadgeOnGAPIFeaturedTab1509USCA).images(true);
        boolean flag2;
        if (gtgAbTestHelper.isGtgPromoCardOnFeatured() && !gtgAbTestHelper.isGtgJumpoffCardOnFeatured())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        obj = ((ApiGenerateShowParamBuilder) (obj)).categorizations(flag2).build();
        arraylist.addAll(((DivisionUtil)divisionUtil.get()).getDivisionNameValuePairs(location));
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", ((DeviceInfoUtil)deviceInfoUtil.get()).getLanguageFromLocale()
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "zero_day", Boolean.valueOf(zeroday.isFirstTimeUser())
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "show", obj
        }));
        if (Strings.notEmpty(s))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referrer", s
            }));
        }
        if (flag)
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "relevance_context", "mobile_featured_intl"
            }));
            if (flag1)
            {
                arraylist.addAll(Arrays.asList(new Serializable[] {
                    "deal_recommendations", Boolean.valueOf(true)
                }));
            }
        }
        if (showSmuggledDeals())
        {
            ((SmuggleUtil)smuggleUtil.get()).addDealIdsToBeSmuggledToNameValuesList(arraylist, ((SmuggleDealManager)smuggleDealManager.get()).getDealIdsToBeSmuggled(Channel.FEATURED.name()));
        }
        if (arraysharedpreferences.contains("zip_code"))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "postal_code", arraysharedpreferences.getString("zip_code", "")
            }));
        }
        if (!isRtrOnFeaturedEnabled && currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "include_travel_bookable_deals", Boolean.valueOf(true)
            }));
        }
        return arraylist;
    }

    protected List getNameValueParams(int i, int j)
    {
        Object obj = ((LocationService)locationService.get()).getLocation();
        try
        {
            obj = constructTodaysDealUrlNameValuePairs(((Location) (obj)), referrer, (ZeroDay)zeroDay.get(), loginPrefs, isRtrOnFeaturedEnabled, ((LoginService)loginService.get()).isLoggedIn());
        }
        catch (CountryNotSupportedException countrynotsupportedexception)
        {
            throw new RuntimeException(countrynotsupportedexception);
        }
        return ((List) (obj));
    }

    protected String getUrl(int i, int j)
    {
        String s;
        if (isRtrOnFeaturedEnabled)
        {
            s = "https:/deals/search";
        } else
        {
            s = "https:/deals";
        }
        return String.format("%s?offset=%s&limit=%s", new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public void init()
    {
label0:
        {
            boolean flag1 = false;
            locationService = new Lazy(context) {

                final FeaturedSyncManager this$0;

            
            {
                this$0 = FeaturedSyncManager.this;
                super(context);
            }
            };
            zeroDay = new Lazy(context) {

                final FeaturedSyncManager this$0;

            
            {
                this$0 = FeaturedSyncManager.this;
                super(context);
            }
            };
            loginService = new Lazy(context) {

                final FeaturedSyncManager this$0;

            
            {
                this$0 = FeaturedSyncManager.this;
                super(context);
            }
            };
            smuggleDealManager = new Lazy(context) {

                final FeaturedSyncManager this$0;

            
            {
                this$0 = FeaturedSyncManager.this;
                super(context);
            }
            };
            isRtrOnFeaturedEnabled = rtrAbTestHelper.isRtrOnFeaturedEnabled();
            AbTestService abtestservice;
            boolean flag;
            if (currentCountryManager.getCurrentCountry().isUSACompatible() && Strings.notEmpty(abTestService.getVariant("megamindOnFeatured1410USCA")) && !abTestService.isVariantEnabled("megamindOnFeatured1410USCA", "Original"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            widgetsSupportedUSA = flag;
            if (currentCountryManager.getCurrentCountry().isMegamindEnabledCountry() && !currentCountryManager.getCurrentCountry().isUSACompatible() && Strings.notEmpty(abTestService.getVariant("megamindOnFeatured1503INTL")) && !abTestService.isVariantEnabled("megamindOnFeatured1503INTL", "Original"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            widgetsSupportedINTL = flag;
            isShowBadgeOnGAPIFeaturedTab1509USCA = abTestService.isVariantEnabledAndUSCA("showBadgeOnGAPIFeaturedTab1509USCA", "on");
            if (!widgetsSupportedUSA)
            {
                flag = flag1;
                if (!widgetsSupportedINTL)
                {
                    break label0;
                }
            }
            flag = true;
        }
        widgetsSupported = flag;
        if (widgetsSupported)
        {
            abtestservice = abTestService;
            String s;
            if (widgetsSupportedUSA)
            {
                s = "megamindOnFeatured1410USCA";
            } else
            {
                s = "megamindOnFeatured1503INTL";
            }
            s = abtestservice.getVariant(s);
            widgetOnFeaturedSyncHelper.setScenarioIdVariantPostfix(s);
            widgetOnFeaturedSyncHelper.setFragmentName(fragmentName);
            setWidgetsSyncHelper(widgetOnFeaturedSyncHelper);
        }
    }
}
