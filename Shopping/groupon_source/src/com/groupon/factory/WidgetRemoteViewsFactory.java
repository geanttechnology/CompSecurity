// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.factory;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.widget.RemoteViews;
import com.groupon.Channel;
import com.groupon.abtest.RtrAbTestHelper;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Price;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.country.Country;
import com.groupon.models.dealsearch.DealSearchResponse;
import com.groupon.models.dealsearch.DealSearchResponseWrapper;
import com.groupon.models.dealsearch.DisplayOptions;
import com.groupon.models.dealsearch.Options;
import com.groupon.models.division.Division;
import com.groupon.receiver.DealWidgetProvider;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DivisionUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class WidgetRemoteViewsFactory
    implements android.widget.RemoteViewsService.RemoteViewsFactory
{

    private static final int DOWNLOAD_LIMIT = 4;
    private static final String FEATURED = "featured";
    private static final String GETAWAYS = "getaways";
    private static final int MAX_PER_CATEGORY = 3;
    private int appWidgetId;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private DeviceInfoUtil deviceInfoUtil;
    private DivisionUtil divisionUtil;
    private IntentFactory intentFactory;
    private boolean isRtrOnFeaturedEnabled;
    private Location knownLocation;
    private LocationService locationService;
    private Logger logger;
    private int numItems;
    int numberPerCategoty[] = {
        3, 3, 3
    };
    private String referrer;
    private RtrAbTestHelper rtrAbTestHelper;

    public WidgetRemoteViewsFactory(Context context1, Intent intent)
    {
        knownLocation = null;
        numItems = 9;
        context = context1;
        appWidgetId = intent.getIntExtra("appWidgetId", 0);
        RoboGuice.getInjector(context1).injectMembers(this);
        Ln.d((new StringBuilder()).append("WidgetFactory created for: ").append(appWidgetId).toString(), new Object[0]);
    }

    private void displayErrorMessage()
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030229);
        remoteviews.setTextViewText(0x7f10058c, context.getString(0x7f08041d));
        remoteviews.setOnClickPendingIntent(0x7f10058e, PendingIntent.getBroadcast(context, 0, (new Intent(context, com/groupon/receiver/DealWidgetProvider)).setAction("android.appwidget.action.APPWIDGET_UPDATE"), 0x8000000));
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, com/groupon/receiver/DealWidgetProvider), remoteviews);
    }

    private RemoteViews getBlankCard()
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030224);
        remoteviews.setViewVisibility(0x7f100581, 8);
        return remoteviews;
    }

    private List getChannelDeals(String s)
    {
        if ((!Strings.equalsIgnoreCase(s, Channel.TRAVEL.toString()) || currentCountryManager.getCurrentCountry().isTravelChannelEnabled()) && (!Strings.equalsIgnoreCase(s, Channel.SHOPPING.toString()) || currentCountryManager.getCurrentCountry().isShoppingChannelEnabled())) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        ArrayList arraylist = new ArrayList();
        if (currentCountryManager.getCurrentCountry().isUSACompatible()) goto _L4; else goto _L3
_L3:
        if (!currentCountryManager.getCurrentCountry().isJapan()) goto _L6; else goto _L5
_L5:
        String s1 = "https:/deals";
_L7:
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", deviceInfoUtil.getLanguageFromLocale()
        }));
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "channel_id", s
            }));
        }
        if (currentCountryManager.getCurrentCountry().isRussia())
        {
            break MISSING_BLOCK_LABEL_181;
        }
        s = s1;
        if (!currentCountryManager.getCurrentCountry().isLATAMCompatible())
        {
            break MISSING_BLOCK_LABEL_222;
        }
        s = currentDivisionManager.getCurrentDivision();
        String s2 = ((Division) (s)).id;
        arraylist.addAll(Arrays.asList(new String[] {
            "division_id", s.getIdOrParentId()
        }));
        s = s1;
_L8:
        if (Strings.notEmpty(referrer))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referrer", referrer
            }));
        }
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "offset", Integer.valueOf(0), "limit", Integer.valueOf(4)
        }));
        if (!Strings.isEmpty(s))
        {
            return ((DealSearchResponseWrapper)(new SyncHttp(context, com/groupon/models/dealsearch/DealSearchResponseWrapper, s, arraylist.toArray())).call()).deals;
        }
          goto _L1
_L6:
        s1 = String.format("https:/channels/%s/deals", new Object[] {
            s
        });
          goto _L7
_L4:
        s1 = "https:/deals";
        arraylist.addAll(divisionUtil.getDivisionNameValuePairs(null));
        arraylist.addAll(Arrays.asList(new String[] {
            "channel_id", s
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", deviceInfoUtil.getLanguageFromLocale()
        }));
        s = s1;
          goto _L8
        s;
        return null;
          goto _L7
    }

    private List getFeaturedDeals()
    {
        Object obj1 = null;
        Object obj2;
        if (Strings.isEmpty(currentDivisionManager.getCurrentDivision().id))
        {
            knownLocation = locationService.getLocation();
        }
        obj2 = context;
        Object obj;
        if (isRtrOnFeaturedEnabled)
        {
            obj = "https:/deals/search";
        } else
        {
            obj = "https:/deals";
        }
        try
        {
            obj2 = (new SyncHttp(((Context) (obj2)), com/groupon/models/dealsearch/DealSearchResponseWrapper, ((String) (obj))) {

                final WidgetRemoteViewsFactory this$0;

                public DealSearchResponseWrapper call()
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
                    arraylist.addAll(Arrays.asList(new Serializable[] {
                        "offset", Integer.valueOf(0), "limit", Integer.valueOf(4)
                    }));
                    nvps(arraylist.toArray());
                    Ln.i("Loading deal for uri %s", new Object[] {
                        getFullURI()
                    });
                    return (DealSearchResponseWrapper)super.call();
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = WidgetRemoteViewsFactory.this;
                super(context1, class1, s);
            }
            }).call();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        obj = obj1;
        if (((DealSearchResponseWrapper) (obj2)).deals != null)
        {
            if (((DealSearchResponseWrapper) (obj2)).deals.isEmpty())
            {
                return null;
            }
            obj = ((DealSearchResponseWrapper) (obj2)).deals;
        }
        return ((List) (obj));
    }

    protected RemoteViews getCard(DealSearchResponse dealsearchresponse, List list, CurrentCountryManager currentcountrymanager)
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030224);
        list = new SyncHttp(context, android/graphics/Bitmap, dealsearchresponse.largeImageUrl);
        Options options;
        boolean flag;
        boolean flag1;
        try
        {
            remoteviews.setImageViewBitmap(0x7f100121, (Bitmap)list.call());
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            Ln.e(list, "Could not load image.", new Object[0]);
        }
        options = (Options)dealsearchresponse.options.get(0);
        currentcountrymanager = dealsearchresponse.announcementTitle;
        list = currentcountrymanager;
        if (Strings.isEmpty(currentcountrymanager))
        {
            list = dealsearchresponse.title;
        }
        remoteviews.setTextViewText(0x7f10007a, list);
        list = options.price;
        currentcountrymanager = dealsearchresponse.displayOptions;
        flag1 = false;
        flag = false;
        if (currentcountrymanager != null)
        {
            currentcountrymanager = currentcountrymanager.iterator();
            do
            {
                flag1 = flag;
                if (!currentcountrymanager.hasNext())
                {
                    break;
                }
                DisplayOptions displayoptions = (DisplayOptions)currentcountrymanager.next();
                if (Strings.equalsIgnoreCase(displayoptions.name, "discount"))
                {
                    flag = displayoptions.enabled;
                }
            } while (true);
        }
        remoteviews.setTextViewText(0x7f100125, ((Price) (list)).formattedAmount.toString().replace("\"", ""));
        if (flag1)
        {
            remoteviews.setTextViewText(0x7f10046c, options.value.formattedAmount.toString().replace("\"", ""));
        }
        flag = Strings.equalsIgnoreCase("closed", dealsearchresponse.status);
        flag1 = dealsearchresponse.isSoldOut;
        byte byte0 = 8;
        list = null;
        if (flag || flag1)
        {
            byte0 = 0;
            if (flag1)
            {
                list = context.getResources().getString(0x7f0803b2);
            } else
            {
                list = context.getResources().getString(0x7f080125);
            }
        }
        remoteviews.setViewVisibility(0x7f1003ed, byte0);
        if (!Strings.isEmpty(list))
        {
            remoteviews.setTextViewText(0x7f1003ed, list);
        }
        list = intentFactory.newSplashIntent(intentFactory.newDealIntent(dealsearchresponse, Channel.WIDGET, true).setFlags(0x4000000));
        list.putExtra("dismissKeyguard", true);
        dealsearchresponse = (new Intent(context, com/groupon/receiver/DealWidgetProvider)).setAction("dealInfo").putExtra("next", list).putExtra("dealId", dealsearchresponse.id);
        dealsearchresponse.setData(Uri.parse(dealsearchresponse.toUri(1)));
        remoteviews.setOnClickFillInIntent(0x7f1001f5, dealsearchresponse);
        return remoteviews;
    }

    public int getCount()
    {
        return numItems;
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public RemoteViews getLoadingView()
    {
        return null;
    }

    public RemoteViews getViewAt(int i)
    {
        Object obj;
        Object obj1;
        Context context1;
        Object obj2;
        boolean flag;
        Ln.d((new StringBuilder()).append("WidgetFactory getview called: ").append(i).toString(), new Object[0]);
        context1 = null;
        obj = context1;
        try
        {
            flag = currentCountryManager.getCurrentCountry().isUSACompatible();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            numItems = 9;
            displayErrorMessage();
            return ((RemoteViews) (obj));
        }
        obj = context1;
        obj2 = new HashMap();
        obj = context1;
        obj1 = getFeaturedDeals();
        obj = context1;
        ((HashMap) (obj2)).put("featured", obj1);
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        obj = context1;
        numItems = 0;
_L22:
        obj = context1;
        numberPerCategoty[0] = numItems;
        if (!flag) goto _L4; else goto _L3
_L3:
        obj = context1;
        obj1 = Channel.GOODS.toString();
_L17:
        obj = context1;
        ((HashMap) (obj2)).put("goods", getChannelDeals(((String) (obj1))));
        obj = context1;
        if (((HashMap) (obj2)).get("goods") != null) goto _L6; else goto _L5
_L5:
        obj = context1;
        numItems = numItems + 0;
_L18:
        obj = context1;
        numberPerCategoty[1] = numItems;
        if (!flag) goto _L8; else goto _L7
_L7:
        obj = context1;
        obj1 = Channel.GETAWAYS.toString();
_L19:
        obj = context1;
        ((HashMap) (obj2)).put("getaways", getChannelDeals(((String) (obj1))));
        obj = context1;
        if (((HashMap) (obj2)).get("getaways") != null) goto _L10; else goto _L9
_L9:
        obj = context1;
        numItems = numItems + 0;
_L20:
        obj = context1;
        numberPerCategoty[2] = numItems;
        obj = context1;
        if (numItems != 0)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        obj = context1;
        numItems = 9;
        obj = context1;
        displayErrorMessage();
        obj = context1;
        if (i >= numberPerCategoty[0]) goto _L12; else goto _L11
_L11:
        obj = context1;
        obj2 = (DealSearchResponse)((List)((HashMap) (obj2)).get("featured")).get(i);
        if (obj2 == null) goto _L14; else goto _L13
_L13:
        obj = context1;
        obj1 = getCard(((DealSearchResponse) (obj2)), null, currentCountryManager);
        if (i != 0) goto _L16; else goto _L15
_L15:
        obj = obj1;
        ((RemoteViews) (obj1)).setTextViewText(0x7f100582, context.getString(0x7f0801b2).toUpperCase());
        obj = obj1;
        ((RemoteViews) (obj1)).setViewVisibility(0x7f100582, 0);
        obj = obj1;
        tracking(((DealSearchResponse) (obj2)), i);
        return ((RemoteViews) (obj1));
_L2:
        obj = context1;
        numItems = Math.min(((List) (obj1)).size(), 3);
        continue; /* Loop/switch isn't completed */
_L4:
        obj = context1;
        obj1 = Channel.SHOPPING.toString();
          goto _L17
_L6:
        obj = context1;
        int j = numItems;
        obj = context1;
        numItems = Math.min(((List)((HashMap) (obj2)).get("goods")).size(), 3) + j;
          goto _L18
_L8:
        obj = context1;
        obj1 = Channel.TRAVEL.toString();
          goto _L19
_L10:
        obj = context1;
        j = numItems;
        obj = context1;
        numItems = Math.min(((List)((HashMap) (obj2)).get("getaways")).size(), 3) + j;
          goto _L20
_L16:
        obj = obj1;
        ((RemoteViews) (obj1)).setViewVisibility(0x7f100582, 8);
        return ((RemoteViews) (obj1));
_L14:
        obj = context1;
        return getBlankCard();
_L12:
        obj = context1;
        if (i < numberPerCategoty[0])
        {
            break MISSING_BLOCK_LABEL_701;
        }
        obj = context1;
        if (i >= numberPerCategoty[1])
        {
            break MISSING_BLOCK_LABEL_701;
        }
        obj = context1;
        obj2 = (DealSearchResponse)((List)((HashMap) (obj2)).get("goods")).get(i - numberPerCategoty[0]);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_693;
        }
        obj = context1;
        obj1 = getCard(((DealSearchResponse) (obj2)), null, currentCountryManager);
        obj = obj1;
        if (i != numberPerCategoty[0])
        {
            break MISSING_BLOCK_LABEL_680;
        }
        if (flag)
        {
            j = 0x7f080206;
        } else
        {
            j = 0x7f08044b;
        }
        obj = obj1;
        ((RemoteViews) (obj1)).setTextViewText(0x7f100582, context.getString(j).toUpperCase());
        obj = obj1;
        ((RemoteViews) (obj1)).setViewVisibility(0x7f100582, 0);
        obj = obj1;
        tracking(((DealSearchResponse) (obj2)), i);
        return ((RemoteViews) (obj1));
        obj = obj1;
        ((RemoteViews) (obj1)).setViewVisibility(0x7f100582, 8);
        return ((RemoteViews) (obj1));
        obj = context1;
        return getBlankCard();
        obj = context1;
        if (i < numberPerCategoty[1])
        {
            break MISSING_BLOCK_LABEL_879;
        }
        obj = context1;
        if (i >= numberPerCategoty[2])
        {
            break MISSING_BLOCK_LABEL_879;
        }
        obj = context1;
        obj2 = (DealSearchResponse)((List)((HashMap) (obj2)).get("getaways")).get(i - numberPerCategoty[1]);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_871;
        }
        obj = context1;
        obj1 = getCard(((DealSearchResponse) (obj2)), null, currentCountryManager);
        obj = obj1;
        if (i != numberPerCategoty[1])
        {
            break MISSING_BLOCK_LABEL_858;
        }
        obj = obj1;
        context1 = context;
        obj = obj1;
        if (currentCountryManager.getCurrentCountry().isGetawaysTitle())
        {
            j = 0x7f0801e5;
        } else
        {
            j = 0x7f0803e7;
        }
        obj = obj1;
        ((RemoteViews) (obj1)).setTextViewText(0x7f100582, context1.getString(j).toUpperCase());
        obj = obj1;
        ((RemoteViews) (obj1)).setViewVisibility(0x7f100582, 0);
        obj = obj1;
        tracking(((DealSearchResponse) (obj2)), i);
        return ((RemoteViews) (obj1));
        obj = obj1;
        ((RemoteViews) (obj1)).setViewVisibility(0x7f100582, 8);
        return ((RemoteViews) (obj1));
        obj = context1;
        return getBlankCard();
        obj = context1;
        obj1 = getBlankCard();
        return ((RemoteViews) (obj1));
        if (true) goto _L22; else goto _L21
_L21:
    }

    public int getViewTypeCount()
    {
        return 1;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public void onCreate()
    {
        isRtrOnFeaturedEnabled = rtrAbTestHelper.isRtrOnFeaturedEnabled();
        Ln.d((new StringBuilder()).append("WidgetFactory onCreate called for widget id: ").append(appWidgetId).toString(), new Object[0]);
    }

    public void onDataSetChanged()
    {
        Ln.d("WidgetFactory onDataSetChanged", new Object[0]);
    }

    public void onDestroy()
    {
        Ln.d((new StringBuilder()).append("WidgetFactory destroy called for widget id:").append(appWidgetId).toString(), new Object[0]);
    }

    public void tracking(DealSearchResponse dealsearchresponse, int i)
    {
        if (!dealsearchresponse.dealImpression)
        {
            String s = dealsearchresponse.id;
            String s1 = dealsearchresponse.uuid;
            logger.logDealImpression("", Channel.WIDGET.toString(), Channel.WIDGET.toString(), s, i, 0.0F, s1, Logger.NULL_NST_FIELD);
            dealsearchresponse.dealImpression = true;
        }
    }




}
