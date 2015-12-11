// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.aps.ApplicationProcessServiceApi;
import com.ebay.common.net.api.aps.UserActivitySummary;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.shell.app.BaseService;

public class AppWidgetRemoteService extends BaseService
{

    static final String TAG = com/ebay/mobile/service/AppWidgetRemoteService.getSimpleName();
    ApplicationProcessServiceApi api;
    private final IAppWidgetRemoteService.Stub binder = new IAppWidgetRemoteService.Stub() {

        final AppWidgetRemoteService this$0;

        public int getCurrentEbaySiteId()
            throws RemoteException
        {
            return MyApp.getPrefs().getCurrentCountry().getSiteId();
        }

        public Bitmap getCurrentEbaySiteLogo(int i)
            throws RemoteException
        {
            return BitmapFactory.decodeResource(MyApp.getApp().getResources(), 0x7f0201c5);
        }

        public boolean getCurrentEbaySiteSupportsDeals(int i)
            throws RemoteException
        {
            return DeviceConfiguration.getAsync().get(DcsBoolean.Deals);
        }

        public boolean getCurrentEbaySiteSupportsSelling(int i)
            throws RemoteException
        {
            DcsHelper dcshelper = MyApp.getDeviceConfiguration();
            return dcshelper != null && dcshelper.isSellingEnabled();
        }

        public int[] getUserCounts()
            throws RemoteException
        {
            int ai[] = null;
            Object obj = MyApp.getPrefs().getAuthentication();
            if (obj != null)
            {
                ai = new int[3];
                ai[2] = -1;
                ai[1] = -1;
                ai[0] = -1;
                try
                {
                    obj = api.getUserActivitySummary(((Authentication) (obj)).iafToken, ((Authentication) (obj)).user);
                    ItemCache itemcache = new ItemCache(getApplicationContext());
                    ai[0] = ((UserActivitySummary) (obj)).messagesNewMessageCount;
                    ai[1] = ((UserActivitySummary) (obj)).buyingFeedbackToSend + ((UserActivitySummary) (obj)).buyingPaymentToSend + ((UserActivitySummary) (obj)).buyingOutbidCount + ((UserActivitySummary) (obj)).buyingBestOfferCount + ((UserActivitySummary) (obj)).buyingBidEndingSoonCount + ((UserActivitySummary) (obj)).buyingWatchEndingSoonCount + ((UserActivitySummary) (obj)).sellingFeedbackToSend + ((UserActivitySummary) (obj)).sellingPaymentToReceive + ((UserActivitySummary) (obj)).sellingShippingNeeded + ((UserActivitySummary) (obj)).sellingSellEndingSoonCount;
                    ai[2] = Math.min(101, (int)itemcache.getSavedSearchCountWithNewItems());
                }
                catch (Exception exception)
                {
                    Log.w(AppWidgetRemoteService.TAG, exception.getMessage(), exception);
                    return ai;
                }
            }
            return ai;
        }

            
            {
                this$0 = AppWidgetRemoteService.this;
                super();
            }
    };

    public AppWidgetRemoteService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return binder;
    }

    public void onCreate()
    {
        super.onCreate();
        if (MyApp.getPrefs().isSignedIn())
        {
            api = EbayApiUtil.getApsApi(getEbayContext());
        }
    }

}
