// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification.getui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.amazon.mShop.control.pushnotification.NotificationSettingController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.publicurl.PublicURLProcessor;
import com.amazon.mShop.pushnotification.NotificationParams;
import com.amazon.mShop.pushnotification.NotificationProvider;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;
import com.igexin.sdk.MessageManager;
import org.json.JSONException;
import org.json.JSONObject;

public class GetuiNotificationProvider
    implements NotificationProvider
{

    private static final String TAG = com/amazon/mShop/pushnotification/getui/GetuiNotificationProvider.getSimpleName();

    public GetuiNotificationProvider()
    {
    }

    public NotificationParams constructNotificationParams(Intent intent)
    {
        intent = new String(intent.getByteArrayExtra("payload"));
        if (!Util.isEmpty(intent)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        String s4;
        obj = new JSONObject(intent);
        s4 = ((JSONObject) (obj)).getString("msg_type");
        if (Util.isEmpty(s4)) goto _L1; else goto _L3
_L3:
        if (!((JSONObject) (obj)).has("alert")) goto _L5; else goto _L4
_L4:
        intent = ((JSONObject) (obj)).getString("alert");
_L29:
        if (!((JSONObject) (obj)).has("marketplace")) goto _L7; else goto _L6
_L6:
        String s1 = ((JSONObject) (obj)).getString("marketplace");
_L30:
        if (!((JSONObject) (obj)).has("ref")) goto _L9; else goto _L8
_L8:
        String s = ((JSONObject) (obj)).getString("ref");
_L31:
        if (!s4.equals("DP")) goto _L11; else goto _L10
_L10:
        if (!((JSONObject) (obj)).has("asin")) goto _L13; else goto _L12
_L12:
        String s2 = ((JSONObject) (obj)).getString("asin");
_L32:
        return new com.amazon.mShop.pushnotification.NotificationParams.ProductDetailNotificationParams(s4, s1, intent, s2, s);
_L11:
        if (!s4.equals("LD")) goto _L15; else goto _L14
_L14:
        if (!((JSONObject) (obj)).has("asin")) goto _L17; else goto _L16
_L16:
        s2 = ((JSONObject) (obj)).getString("asin");
_L33:
        if (!((JSONObject) (obj)).has("browse_node")) goto _L19; else goto _L18
_L18:
        String s3 = ((JSONObject) (obj)).getString("browse_node");
_L34:
        if (!((JSONObject) (obj)).has("browse_node_display_name")) goto _L21; else goto _L20
_L20:
        obj = ((JSONObject) (obj)).getString("browse_node_display_name");
_L35:
        return new com.amazon.mShop.pushnotification.NotificationParams.DealNotificationParams(s4, s1, intent, s2, s3, ((String) (obj)), s);
_L15:
        if (!s4.equals("OD")) goto _L23; else goto _L22
_L22:
        if (!((JSONObject) (obj)).has("order_id")) goto _L25; else goto _L24
_L24:
        s2 = ((JSONObject) (obj)).getString("order_id");
_L36:
        return new com.amazon.mShop.pushnotification.NotificationParams.OrderNotificationParams(s4, s1, intent, s2, s);
_L23:
        if (s4.equals("AD"))
        {
            return new NotificationParams(s4, s1, intent, s);
        }
        if (!s4.equals("SNS")) goto _L27; else goto _L26
_L26:
        if (!((JSONObject) (obj)).has("token"))
        {
            break MISSING_BLOCK_LABEL_499;
        }
        s2 = ((JSONObject) (obj)).getString("token");
_L37:
        return new com.amazon.mShop.pushnotification.NotificationParams.SnsNotificationParams(s4, s1, intent, s, s2);
_L27:
        if (s4.equals("DL"))
        {
            s1 = ((JSONObject) (obj)).getString("url");
            s2 = PublicURLProcessor.getLocaleNameFromUri(Uri.parse(s1));
            return new com.amazon.mShop.pushnotification.NotificationParams.DeepLinkNotificationParams(s4, AppLocale.getInstance().getMarketPlaceIdByLocale(s2), intent, s, s1);
        }
        if (!s4.equals("SL")) goto _L1; else goto _L28
_L28:
        s1 = ((JSONObject) (obj)).getString("url");
        s2 = PublicURLProcessor.getLocaleNameFromUri(Uri.parse(s1));
        intent = new com.amazon.mShop.pushnotification.NotificationParams.SmartLinkNotificationParams(s4, AppLocale.getInstance().getMarketPlaceIdByLocale(s2), intent, s, s1);
        return intent;
        intent;
        return null;
_L5:
        intent = "";
          goto _L29
_L7:
        s1 = "";
          goto _L30
_L9:
        s = "";
          goto _L31
_L13:
        s2 = "";
          goto _L32
_L17:
        s2 = "";
          goto _L33
_L19:
        s3 = "";
          goto _L34
_L21:
        obj = "";
          goto _L35
_L25:
        s2 = "";
          goto _L36
        s2 = "";
          goto _L37
    }

    public String getCurrentMShopRegistrationToken()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("getuiRegistrationId");
    }

    public String getCurrentPushNotificationErrorId()
    {
        if (Util.isEmpty(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("getui_master_app_download_url")))
        {
            return "SERVICE_NOT_AVAILABE";
        } else
        {
            return "MASTER_APP_NOT_FOUND";
        }
    }

    public String getErrorMessage(Context context, String s)
    {
        if ("MASTER_APP_NOT_FOUND".equals(s))
        {
            return context.getResources().getString(com.amazon.mShop.android.lib.R.string.getui_error_download_master_app);
        } else
        {
            return context.getResources().getString(com.amazon.mShop.android.lib.R.string.getui_error_service_not_available);
        }
    }

    public NotificationTarget getNewNotificationTarget(String s)
    {
        if (Util.isEmpty(s))
        {
            s = getCurrentMShopRegistrationToken();
        }
        if (Util.isEmpty(s))
        {
            return null;
        }
        if (DebugSettings.isDebugEnabled())
        {
            Log.d(TAG, (new StringBuilder()).append("GETUI registration id : ").append(s).toString());
        }
        return NotificationSettingController.constructNotificationTarget("com.amazon.mShop.android", 3, s);
    }

    public String getProviderName()
    {
        return "GETUI";
    }

    public void handleClickActionOnErrorButton(Activity activity, String s)
    {
        if (!"MASTER_APP_NOT_FOUND".equals(s)) goto _L2; else goto _L1
_L1:
        s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("getui_master_app_download_url");
        MessageManager.getInstance().startWeb(activity, s);
        RefMarkerObserver.logRefMarker("pn_dl_getui");
_L4:
        activity.finish();
        return;
_L2:
        if ("SERVICE_NOT_AVAILABE".equals(s))
        {
            MessageManager.getInstance().initialize(activity);
            RefMarkerObserver.logRefMarker("pn_getui_unavailable");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean isAvailable(Context context)
    {
        return true;
    }

    public void onMainActivityDestroyed(Context context)
    {
    }

    public void setCurrentMShopRegistrationToken(String s)
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        if (s == null)
        {
            datastore.remove("getuiRegistrationId");
            return;
        } else
        {
            datastore.putString("getuiRegistrationId", s);
            return;
        }
    }

    public void setCurrentPushNotificationErrorId(String s)
    {
    }

    public void startRegister(Context context)
    {
        MessageManager.getInstance().initialize(context);
    }

}
