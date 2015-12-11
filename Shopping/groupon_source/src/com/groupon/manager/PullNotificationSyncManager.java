// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import android.location.Location;
import com.groupon.Channel;
import com.groupon.abtest.RtrAbTestHelper;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
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
//            AnyChannelSyncManager

public class PullNotificationSyncManager extends AnyChannelSyncManager
{

    private DeviceInfoUtil deviceInfoUtil;
    private boolean isRtrOnFeaturedEnabled;
    private LocationService locationService;
    private ArraySharedPreferences loginPrefs;
    private LoginService loginService;
    private RtrAbTestHelper rtrAbTestHelper;
    private SmuggleDealManager smuggleDealManager;
    private ZeroDay zeroDay;

    public PullNotificationSyncManager(Context context)
    {
        super(context, "PULLNOTIFICATION");
        searchCategory = "all";
    }

    public PullNotificationSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, CarouselExecutorManager carouselexecutormanager)
    {
        super(context, pausablethreadpoolexecutor, "PULLNOTIFICATION", carouselexecutormanager);
        searchCategory = "all";
    }

    public ArrayList constructTodaysDealUrlNameValuePairs(Location location, String s, ZeroDay zeroday, ArraySharedPreferences arraysharedpreferences, boolean flag, boolean flag1)
        throws CountryNotSupportedException
    {
        ArrayList arraylist = new ArrayList();
        String s1 = (new ApiGenerateShowParamBuilder()).dealOptionGiftWrappingCharge(true).bookingUpdatesSchedulerOptions(true).incentives(((IncentivesUtil)incentivesUtil.get()).isExperimentEnabled()).build();
        arraylist.addAll(((DivisionUtil)divisionUtil.get()).getDivisionNameValuePairs(location));
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", deviceInfoUtil.getLanguageFromLocale()
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "zero_day", Boolean.valueOf(zeroday.isFirstTimeUser())
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "show", s1
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "relevance_context", "mobile_push"
        }));
        if (Strings.notEmpty(s))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referrer", s
            }));
        }
        ((SmuggleUtil)smuggleUtil.get()).addDealIdsToBeSmuggledToNameValuesList(arraylist, smuggleDealManager.getDealIdsToBeSmuggled(Channel.FEATURED.name()));
        if (arraysharedpreferences.contains("zip_code"))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "postal_code", arraysharedpreferences.getString("zip_code", "")
            }));
        }
        return arraylist;
    }

    protected List getNameValueParams(int i, int j)
    {
        Object obj = locationService.getLocation();
        try
        {
            obj = constructTodaysDealUrlNameValuePairs(((Location) (obj)), referrer, zeroDay, loginPrefs, isRtrOnFeaturedEnabled, loginService.isLoggedIn());
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
            s, Integer.valueOf(0), Integer.valueOf(1)
        });
    }

    public void init()
    {
        isRtrOnFeaturedEnabled = rtrAbTestHelper.isRtrOnFeaturedEnabled();
    }

    protected boolean requiresRedirectLogging()
    {
        return false;
    }
}
