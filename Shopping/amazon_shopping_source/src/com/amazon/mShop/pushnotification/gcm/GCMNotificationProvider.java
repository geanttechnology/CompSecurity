// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification.gcm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.amazon.mShop.control.pushnotification.NotificationSettingController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.publicurl.PublicURLProcessor;
import com.amazon.mShop.pushnotification.NotificationParams;
import com.amazon.mShop.pushnotification.NotificationProvider;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;
import com.google.android.gcm.GCMRegistrar;

public class GCMNotificationProvider
    implements NotificationProvider
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();

    public GCMNotificationProvider()
    {
    }

    public NotificationParams constructNotificationParams(Intent intent)
    {
        Object obj;
        String s;
        String s1;
        String s2;
        String s3;
        obj = null;
        s = intent.getStringExtra("msg_type");
        if (Util.isEmpty(s))
        {
            return null;
        }
        s1 = intent.getStringExtra("alert");
        s3 = intent.getStringExtra("marketplace");
        s2 = intent.getStringExtra("ref");
        if (!s.equals("DP")) goto _L2; else goto _L1
_L1:
        obj = new com.amazon.mShop.pushnotification.NotificationParams.ProductDetailNotificationParams(s, s3, s1, intent.getStringExtra("asin"), s2);
_L4:
        return ((NotificationParams) (obj));
_L2:
        if (s.equals("LD"))
        {
            obj = new com.amazon.mShop.pushnotification.NotificationParams.DealNotificationParams(s, s3, s1, intent.getStringExtra("asin"), intent.getStringExtra("browse_node"), intent.getStringExtra("browse_node_display_name"), s2);
        } else
        if (s.equals("OD"))
        {
            obj = new com.amazon.mShop.pushnotification.NotificationParams.OrderNotificationParams(s, s3, s1, intent.getStringExtra("order_id"), s2);
        } else
        if (s.equals("AD"))
        {
            obj = new NotificationParams(s, s3, s1, s2);
        } else
        if (s.equals("SNS"))
        {
            obj = new com.amazon.mShop.pushnotification.NotificationParams.SnsNotificationParams(s, s3, s1, s2, intent.getStringExtra("token"));
        } else
        if (s.equals("DL"))
        {
            intent = intent.getStringExtra("url");
            obj = PublicURLProcessor.getLocaleNameFromUri(Uri.parse(intent));
            obj = new com.amazon.mShop.pushnotification.NotificationParams.DeepLinkNotificationParams(s, AppLocale.getInstance().getMarketPlaceIdByLocale(((String) (obj))), s1, s2, intent);
        } else
        if (s.equals("SL"))
        {
            intent = intent.getStringExtra("url");
            obj = PublicURLProcessor.getLocaleNameFromUri(Uri.parse(intent));
            obj = new com.amazon.mShop.pushnotification.NotificationParams.SmartLinkNotificationParams(s, AppLocale.getInstance().getMarketPlaceIdByLocale(((String) (obj))), s1, s2, intent);
        } else
        if (s.equals("COINS"))
        {
            obj = intent.getStringExtra("url");
            String s4 = intent.getStringExtra("title");
            boolean flag;
            if (!Util.isEmpty(intent.getStringExtra("icon")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = new com.amazon.mShop.pushnotification.NotificationParams.CoinsNotificationParams(s, s3, s4, s1, flag, s2, ((String) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getCurrentMShopRegistrationToken()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("gcmRegistrationId");
    }

    public String getCurrentPushNotificationErrorId()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("gcmErrorId");
    }

    public String getErrorMessage(Context context, String s)
    {
        String s1 = "";
        if (Util.isEmpty(s) || s.equals("SERVICE_NOT_AVAILABLE"))
        {
            s1 = context.getString(com.amazon.mShop.android.lib.R.string.notification_gcm_unavailable);
        } else
        if (s.equals("ACCOUNT_MISSING") || s.equals("AUTHENTICATION_FAILED"))
        {
            return context.getString(com.amazon.mShop.android.lib.R.string.notification_google_account_error);
        }
        return s1;
    }

    public NotificationTarget getNewNotificationTarget(String s)
    {
        if (Util.isEmpty(s))
        {
            s = GCMRegistrar.getRegistrationId((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext());
        }
        if (Util.isEmpty(s))
        {
            return null;
        }
        if (DEBUG)
        {
            Log.d("MShopPushNotificationUtils", (new StringBuilder()).append("GCM registration id : ").append(s).toString());
        }
        return NotificationSettingController.constructNotificationTarget("com.amazon.mShop.android", 1, s);
    }

    public String getProviderName()
    {
        return "GCM";
    }

    public void handleClickActionOnErrorButton(Activity activity, String s)
    {
        activity.finish();
    }

    public boolean isAvailable(Context context)
    {
        boolean flag = false;
        GCMRegistrar.checkDevice(context);
        flag = true;
_L1:
        boolean flag1 = false;
        GCMRegistrar.checkManifest(context);
        flag1 = true;
_L2:
        return flag && flag1;
        UnsupportedOperationException unsupportedoperationexception;
        unsupportedoperationexception;
          goto _L1
        context;
          goto _L2
    }

    public void onMainActivityDestroyed(Context context)
    {
        GCMRegistrar.onDestroy(context);
    }

    public void setCurrentMShopRegistrationToken(String s)
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        if (s == null)
        {
            datastore.remove("gcmRegistrationId");
            return;
        } else
        {
            datastore.putString("gcmRegistrationId", s);
            return;
        }
    }

    public void setCurrentPushNotificationErrorId(String s)
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        if (s == null)
        {
            datastore.remove("gcmErrorId");
            return;
        } else
        {
            datastore.putString("gcmErrorId", s);
            return;
        }
    }

    public void startRegister(Context context)
    {
        if (getNewNotificationTarget(null) != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        GCMRegistrar.register(context, new String[] {
            "16912134167"
        });
        return;
        context;
        Log.e("MShopPushNotificationUtils", context.getMessage());
        return;
    }

}
