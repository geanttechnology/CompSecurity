// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.appstore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.webkit.CookieManager;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ConfigUtils;

public class AppstoreUtils
{

    private static final UserListener APPSTORE_COOKIE_USER_LISTENER = new UserListener() {

        private void setAppstoreDeviceInfoCookie()
        {
            AppstoreUtils.setAppstoreDeviceInfoCookie((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext());
        }

        public void userSignedIn(User user)
        {
            setAppstoreDeviceInfoCookie();
        }

        public void userSignedOut()
        {
            setAppstoreDeviceInfoCookie();
        }

        public void userUpdated(User user)
        {
            setAppstoreDeviceInfoCookie();
        }

    };
    private static final Uri APPSTORE_DEVICE_INFO_COOKIE_PROVIDER = Uri.parse("content://com.amazon.mas.client.framework.DeviceInfoCookieContentProvider");
    private static final String TAG = com/amazon/mShop/appstore/AppstoreUtils.getSimpleName();
    private static boolean sAppStoreInitialized = false;

    public AppstoreUtils()
    {
    }

    private static String getAppstoreDeviceInfoCookie(Context context)
    {
        context = context.getContentResolver().query(APPSTORE_DEVICE_INFO_COOKIE_PROVIDER, null, null, null, null);
        if (context == null)
        {
            if (DebugSettings.isDebugEnabled())
            {
                Log.e(TAG, "Cursor returned from content provider is empty.");
            }
            return null;
        }
        String s;
        context.moveToFirst();
        s = context.getString(context.getColumnIndex("cookie"));
        if (DebugSettings.isDebugEnabled())
        {
            Log.d(TAG, String.format("Appstore device info cookie fetched: %s.", new Object[] {
                s
            }));
        }
        context.close();
        return s;
        Exception exception;
        exception;
        context.close();
        throw exception;
    }

    public static boolean isAppstoreAvailable()
    {
        return ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasAppstore) && sAppStoreInitialized;
    }

    public static void setAppstoreDeviceInfoCookie(Context context)
    {
        String s = CookieBridge.getCookieDomain(context, true);
        context = getAppstoreDeviceInfoCookie(context);
        if (context != null)
        {
            CookieManager.getInstance().setCookie((new StringBuilder()).append("www").append(s).toString(), context);
        }
    }

    public static void setAppstoreInitialized()
    {
        sAppStoreInitialized = true;
    }

    public static void setUpAppstoreDeviceInfoCookieListener()
    {
        User.addUserListener(APPSTORE_COOKIE_USER_LISTENER);
    }

}
