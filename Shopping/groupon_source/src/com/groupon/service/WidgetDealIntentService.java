// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.widget.RemoteViews;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.DealsResponse;
import com.groupon.models.division.Division;
import com.groupon.models.error.GrouponException;
import com.groupon.receiver.DealWidgetProvider;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DivisionUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            DealIntentService, LocationService, WidgetRemoteViewsService

public class WidgetDealIntentService extends DealIntentService
{
    private class GetDealsHttp extends SyncHttp
    {

        final WidgetDealIntentService this$0;

        private Object[] createParams()
            throws CountryNotSupportedException
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
            return arraylist.toArray();
        }

        public DealsResponse call()
            throws Exception
        {
            nvps(createParams());
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

        public GetDealsHttp()
        {
            this$0 = WidgetDealIntentService.this;
            String s;
            if (isRtrOnFeaturedEnabled)
            {
                s = "https:/deals/search";
            } else
            {
                s = "https:/deals";
            }
            super(WidgetDealIntentService.this, com/groupon/models/DealsResponse, s);
        }
    }


    private static final String PARAM_SOURCE = "source";
    private static final String PARAM_WIDGET = "widget";

    public WidgetDealIntentService()
    {
        super("DealWidgetProvider$WidgetDealIntentService");
        Ln.d("WidgetDealIntentService Starting", new Object[0]);
    }

    public static Intent newIntent(Context context, Intent intent, String s)
    {
        return (new Intent(context, com/groupon/service/WidgetDealIntentService)).putExtra("android.intent.extra.INTENT", intent).setAction(s);
    }

    public static Intent newIntent(Context context, String s)
    {
        return (new Intent(context, com/groupon/service/WidgetDealIntentService)).setAction(s);
    }

    protected RemoteViews getDealRemoteViews(Context context, boolean flag)
        throws Exception
    {
label0:
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
                if (!(new GetDealsHttp()).call().deals.isEmpty())
                {
                    break label0;
                }
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
        RemoteViews remoteviews1 = new RemoteViews(context.getPackageName(), 0x7f030226);
        remoteviews1.setEmptyView(0x7f10058a, 0x7f10058b);
        Intent intent = new Intent(context, com/groupon/receiver/DealWidgetProvider);
        intent.setAction("dealInfo");
        intent.setData(Uri.parse(intent.toUri(1)));
        remoteviews1.setPendingIntentTemplate(0x7f10058a, PendingIntent.getBroadcast(context, 0, intent, 0x8000000));
        remoteviews1.setRemoteAdapter(0x7f10058a, new Intent(context, com/groupon/service/WidgetRemoteViewsService));
        remoteviews1.setOnClickPendingIntent(0x7f100589, PendingIntent.getBroadcast(context, 0, (new Intent(context, com/groupon/receiver/DealWidgetProvider)).setAction("android.appwidget.action.APPWIDGET_UPDATE"), 0x8000000));
        return remoteviews1;
    }
}
