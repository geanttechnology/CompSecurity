// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.google.inject.Injector;
import com.groupon.abtest.RtrAbTestHelper;
import com.groupon.activity.IntentFactory;
import com.groupon.foundations.service.BaseIntentService;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.DealsResponse;
import com.groupon.models.division.Division;
import com.groupon.models.error.GrouponException;
import com.groupon.receiver.DealWidgetProvider;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.countryanddivision.DivisionsService;
import com.groupon.tracking.mobile.sdk.NoScheduledUploadLogger;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DivisionUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedProvider;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            LocationService

public class DealIntentService extends BaseIntentService
{
    private class GetDealsAndCacheHttp extends SyncHttp
    {

        final DealIntentService this$0;

        public DealsResponse call()
            throws Exception
        {
            ArrayList arraylist = divisionUtil.getDivisionNameValuePairs(knownLocation);
            Location location = locationService.getLocation();
            arraylist.addAll(Arrays.asList(new String[] {
                "source", "widget"
            }));
            arraylist.addAll(Arrays.asList(new String[] {
                "lang", ((DeviceInfoUtil)deviceInfoUtil.get()).getLanguageFromLocale()
            }));
            if (location != null)
            {
                arraylist.addAll(Arrays.asList(new Serializable[] {
                    "lat", Double.valueOf(location.getLatitude()), "lng", Double.valueOf(location.getLongitude())
                }));
            }
            if (Strings.notEmpty(referrer))
            {
                arraylist.addAll(Arrays.asList(new String[] {
                    "referrer", referrer
                }));
            }
            nvps(arraylist.toArray());
            Ln.i("Loading deal for uri %s", new Object[] {
                getFullURI()
            });
            return (DealsResponse)super.call();
        }

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public GetDealsAndCacheHttp()
        {
            this$0 = DealIntentService.this;
            String s;
            if (isRtrOnFeaturedEnabled)
            {
                s = "https:/deals/search";
            } else
            {
                s = "https:/deals";
            }
            super(DealIntentService.this, com/groupon/models/DealsResponse, s);
        }
    }


    private static final int INITIAL_DEAL_INDEX = 0;
    private ConnectivityManager connectivityManager;
    protected CurrentDivisionManager currentDivisionManager;
    protected ContextScopedProvider divisionServiceProvider;
    protected DivisionUtil divisionUtil;
    private boolean initialized;
    private IntentFactory intentFactory;
    protected boolean isRtrOnFeaturedEnabled;
    protected Location knownLocation;
    protected LocationService locationService;
    private NoScheduledUploadLogger logger;
    private SharedPreferences prefs;
    protected String referrer;
    private RtrAbTestHelper rtrAbTestHelper;

    public DealIntentService()
    {
        super("DealWidgetProvider$DealIntentService");
        knownLocation = null;
        initialized = false;
        Ln.d("DealIntentService Starting", new Object[0]);
    }

    public DealIntentService(String s)
    {
        super(s);
        knownLocation = null;
        initialized = false;
    }

    private ComponentName getComponentName(Context context)
    {
        return new ComponentName(context, com/groupon/receiver/DealWidgetProvider);
    }

    private RemoteViews getConnectionErrorRemoteViews(Context context)
    {
        return getGenericErrorRemoteViews(context, 0x7f08041d);
    }

    private RemoteViews getDealLoadingRemoteViews(Context context)
    {
        Ln.d("Getting loading remote views.", new Object[0]);
        return new RemoteViews(context.getPackageName(), 0x7f030227);
    }

    private RemoteViews getDealRemoteViews(Context context, int i, boolean flag)
        throws Exception
    {
        Ln.d("Getting deal RemoteViews", new Object[0]);
        RemoteViews remoteviews;
        try
        {
            if (Strings.isEmpty(currentDivisionManager.getCurrentDivision().id))
            {
                knownLocation = locationService.getLocation();
                return getCountryNotFoundDeals(context);
            }
            (new GetDealsAndCacheHttp()).call();
            remoteviews = getNearbyCityRemoteViews(context);
        }
        catch (CountryNotSupportedException countrynotsupportedexception)
        {
            return getNearbyCityRemoteViews(context);
        }
        catch (GrouponException grouponexception)
        {
            if (grouponexception.getStatusCode() == 400)
            {
                return getNearbyCityRemoteViews(context);
            } else
            {
                throw grouponexception;
            }
        }
        return remoteviews;
    }

    private RemoteViews getGenericErrorRemoteViews(Context context, int i)
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030229);
        remoteviews.setTextViewText(0x7f10058c, context.getString(i));
        remoteviews.setOnClickPendingIntent(0x7f10058e, PendingIntent.getBroadcast(context, 0, (new Intent(context, com/groupon/receiver/DealWidgetProvider)).setAction("android.appwidget.action.APPWIDGET_UPDATE"), 0x8000000));
        return remoteviews;
    }

    public static RemoteViews getInitialOptInRemoteViews(Context context)
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f03022a);
        remoteviews.setOnClickPendingIntent(0x7f10058f, PendingIntent.getBroadcast(context, 0, (new Intent(context, com/groupon/receiver/DealWidgetProvider)).setAction("actionOptIn"), 0x8000000));
        remoteviews.setViewVisibility(0x7f100132, 0);
        return remoteviews;
    }

    public static Intent newIntent(Context context, Intent intent, String s)
    {
        return (new Intent(context, com/groupon/service/DealIntentService)).putExtra("android.intent.extra.INTENT", intent).setAction(s);
    }

    public static Intent newIntent(Context context, String s)
    {
        return (new Intent(context, com/groupon/service/DealIntentService)).setAction(s);
    }

    private void showDealLoadingPageIfNecessary()
    {
        if (connectivityManager.getActiveNetworkInfo() != null)
        {
            AppWidgetManager.getInstance(this).updateAppWidget(getComponentName(this), getDealLoadingRemoteViews(this));
        }
    }

    protected RemoteViews getCountryNotFoundDeals(Context context)
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030228);
        remoteviews.setTextViewText(0x7f10058c, getString(0x7f0801a4));
        remoteviews.setOnClickPendingIntent(0x7f10058d, PendingIntent.getBroadcast(context, 0, (new Intent(this, com/groupon/receiver/DealWidgetProvider)).setAction("actionShowCitySelector"), 0x8000000));
        remoteviews.setTextViewText(0x7f10058d, getString(0x7f0803ef));
        return remoteviews;
    }

    protected RemoteViews getDealRemoteViews(Context context, boolean flag)
        throws Exception
    {
        return getDealRemoteViews(context, 0, flag);
    }

    public Injector getInjector()
    {
        return RoboGuice.getInjector(this);
    }

    protected RemoteViews getNearbyCityRemoteViews(Context context)
        throws Exception
    {
        Ln.d("Getting nearby city RemoteViews", new Object[0]);
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030228);
        Object obj = new ArrayList(((DivisionsService)divisionServiceProvider.get(context)).getDivisions());
        if (knownLocation == null)
        {
            knownLocation = locationService.getLocation();
        }
        final HashMap minDistances = new HashMap();
        final double lat;
        final double lng;
        if (knownLocation != null)
        {
            lat = knownLocation.getLatitude();
        } else
        {
            lat = 1.7976931348623157E+308D;
        }
        if (knownLocation != null)
        {
            lng = knownLocation.getLongitude();
        } else
        {
            lng = 1.7976931348623157E+308D;
        }
        Collections.sort(((List) (obj)), new Comparator() {

            final DealIntentService this$0;
            final double val$lat;
            final double val$lng;
            final HashMap val$minDistances;

            public int compare(Division division, Division division1)
            {
                double d1 = 1.7976931348623157E+308D;
                double d;
                double d2;
                if (minDistances.containsKey(division))
                {
                    d = ((Double)minDistances.get(division)).doubleValue();
                } else
                {
                    d = d1;
                    if (division != null)
                    {
                        long l = division1.latE6;
                        long l2 = division1.lngE6;
                        d = d1;
                        if (l != 0L)
                        {
                            d = d1;
                            if (l2 != 0L)
                            {
                                d = Math.min(1.7976931348623157E+308D, Math.sqrt(((double)l - lat) * ((double)l - lat) + ((double)l2 - lng) * ((double)l2 - lng)));
                            }
                        }
                        minDistances.put(division, Double.valueOf(d));
                    }
                }
                d2 = 1.7976931348623157E+308D;
                if (minDistances.containsKey(division1))
                {
                    d1 = ((Double)minDistances.get(division1)).doubleValue();
                } else
                {
                    d1 = d2;
                    if (division1 != null)
                    {
                        long l1 = division1.latE6;
                        long l3 = division1.lngE6;
                        d1 = d2;
                        if (l1 != 0L)
                        {
                            d1 = d2;
                            if (l3 != 0L)
                            {
                                d1 = Math.min(1.7976931348623157E+308D, Math.sqrt(((double)l1 - lat) * ((double)l1 - lat) + ((double)l3 - lng) * ((double)l3 - lng)));
                            }
                        }
                        minDistances.put(division1, Double.valueOf(d1));
                    }
                }
                return Double.compare(d, d1);
            }

            public volatile int compare(Object obj1, Object obj2)
            {
                return compare((Division)obj1, (Division)obj2);
            }

            
            {
                this$0 = DealIntentService.this;
                minDistances = hashmap;
                lat = d;
                lng = d1;
                super();
            }
        });
        Ln.d((new StringBuilder()).append("Number of divisions found: ").append(((List) (obj)).size()).toString(), new Object[0]);
        if (((List) (obj)).size() < 2)
        {
            return getConnectionErrorRemoteViews(context);
        } else
        {
            obj = (Division)((List) (obj)).get(0);
            remoteviews.setOnClickPendingIntent(0x7f10058d, PendingIntent.getBroadcast(context, 0, (new Intent(this, com/groupon/receiver/DealWidgetProvider)).setAction("actionViewNearbyDivision").putExtra("nearbyDivisionJson", Strings.toString(obj)), 0x8000000));
            remoteviews.setTextViewText(0x7f10058d, ((Division) (obj)).name);
            return remoteviews;
        }
    }

    public Intent newServiceIntent(Context context, String s)
    {
        return (new Intent(context, getClass())).setAction(s);
    }

    public void onCreate()
    {
        super.onCreate();
        isRtrOnFeaturedEnabled = rtrAbTestHelper.isRtrOnFeaturedEnabled();
    }

    protected void onHandleIntent(Intent intent)
    {
        AppWidgetManager appwidgetmanager;
        ComponentName componentname;
        ComponentName componentname1;
        AppWidgetManager appwidgetmanager1;
        componentname1 = null;
        appwidgetmanager1 = null;
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        Ln.d("Handling Intent %s", new Object[] {
            intent
        });
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        componentname1 = getComponentName(this);
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        appwidgetmanager1 = AppWidgetManager.getInstance(this);
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        String s = intent.getAction();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_1058;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        boolean flag = prefs.getBoolean("optInViaWidget", false);
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (!s.equals("android.appwidget.action.APPWIDGET_ENABLED"))
        {
            break MISSING_BLOCK_LABEL_136;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        prefs.edit().putBoolean("widgetHasBeenInstalled", true).apply();
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (!s.equals("actionOptIn"))
        {
            break MISSING_BLOCK_LABEL_211;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        prefs.edit().putBoolean("optInViaWidget", true).apply();
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        showDealLoadingPageIfNecessary();
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        try
        {
            startService(newServiceIntent(this, "android.appwidget.action.APPWIDGET_ENABLED"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Ln.e(intent);
        }
        break MISSING_BLOCK_LABEL_328;
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (!s.equals("android.appwidget.action.APPWIDGET_UPDATE"))
        {
            break MISSING_BLOCK_LABEL_346;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (prefs.getBoolean("widgetHasBeenInstalled", false))
        {
            break MISSING_BLOCK_LABEL_346;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        Ln.d((new StringBuilder()).append("Initialized:").append(initialized).toString(), new Object[0]);
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        Ln.d((new StringBuilder()).append("OPT_IN_VIA_WIDGET:").append(flag).toString(), new Object[0]);
        return;
        try
        {
            appwidgetmanager.updateAppWidget(componentname, getConnectionErrorRemoteViews(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Ln.e(intent);
        }
        return;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_398;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        prefs.edit().putBoolean("widgetHasBeenInstalled", true).apply();
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        appwidgetmanager1.updateAppWidget(componentname1, getInitialOptInRemoteViews(this));
        return;
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (s.equals("android.appwidget.action.APPWIDGET_ENABLED"))
        {
            break MISSING_BLOCK_LABEL_448;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (s.equals("android.appwidget.action.APPWIDGET_UPDATE"))
        {
            break MISSING_BLOCK_LABEL_448;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (!s.equals("tryAgain"))
        {
            break MISSING_BLOCK_LABEL_544;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_544;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (initialized)
        {
            break MISSING_BLOCK_LABEL_544;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        Ln.d((new StringBuilder()).append("Initialized:").append(initialized).toString(), new Object[0]);
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        showDealLoadingPageIfNecessary();
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        appwidgetmanager1.updateAppWidget(componentname1, getDealRemoteViews(this, true));
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        initialized = true;
        return;
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (!s.equals("dealInfo"))
        {
            break MISSING_BLOCK_LABEL_675;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        intent = (Intent)intent.getExtras().get("android.intent.extra.INTENT");
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        logger.logClick("", "widget_deal_click", intent.getStringExtra("dealId"), "");
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        intent = (Intent)intent.getExtras().get("next");
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_651;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        startActivity(intent.setFlags(0x10000000));
        return;
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        startActivity(intentFactory.newCarouselIntent().setFlags(0x10000000));
        return;
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (!s.equals("nextDealForward"))
        {
            break MISSING_BLOCK_LABEL_797;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        int i = ((Intent)intent.getExtras().get("android.intent.extra.INTENT")).getIntExtra("dealIndex", 0);
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        Ln.d((new StringBuilder()).append("Navigating to next deal. Deal Index: ").append(i).toString(), new Object[0]);
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        appwidgetmanager1.updateAppWidget(componentname1, getDealRemoteViews(this, i, false));
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        appwidgetmanager1.updateAppWidget(componentname1, getDealRemoteViews(this, i, true));
        return;
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (!s.equals("nextDealBack"))
        {
            break MISSING_BLOCK_LABEL_919;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        i = ((Intent)intent.getExtras().get("android.intent.extra.INTENT")).getIntExtra("dealIndex", 0);
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        Ln.d((new StringBuilder()).append("Navigating to previous deal. Deal Index: ").append(i).toString(), new Object[0]);
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        appwidgetmanager1.updateAppWidget(componentname1, getDealRemoteViews(this, i, false));
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        appwidgetmanager1.updateAppWidget(componentname1, getDealRemoteViews(this, i, true));
        return;
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (!s.equals("actionViewNearbyDivision"))
        {
            break MISSING_BLOCK_LABEL_1012;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        intent = (Division)((Intent)intent.getExtras().get("android.intent.extra.INTENT")).getParcelableExtra("nearbyDivisionJson");
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        currentDivisionManager.setCurrentDivisionAndClearCaches(intent, new Class[0]);
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        showDealLoadingPageIfNecessary();
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        appwidgetmanager1.updateAppWidget(componentname1, getDealRemoteViews(this, true));
        return;
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        if (!s.equals("actionShowCitySelector"))
        {
            break MISSING_BLOCK_LABEL_1058;
        }
        appwidgetmanager = appwidgetmanager1;
        componentname = componentname1;
        startActivity(intentFactory.newSplashIntent().putExtra("dismissKeyguard", true).setFlags(0x10000000));
    }
}
