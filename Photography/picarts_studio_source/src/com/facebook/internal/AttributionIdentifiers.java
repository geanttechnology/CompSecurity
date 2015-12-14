// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import com.facebook.FacebookException;

// Referenced classes of package com.facebook.internal:
//            Utility

public class AttributionIdentifiers
{

    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 0x36ee80L;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = com/facebook/internal/AttributionIdentifiers.getCanonicalName();
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    public AttributionIdentifiers()
    {
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionidentifiers)
    {
        attributionidentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionidentifiers;
        return attributionidentifiers;
    }

    private static AttributionIdentifiers getAndroidId(Context context)
    {
        AttributionIdentifiers attributionidentifiers = getAndroidIdViaReflection(context);
        Object obj = attributionidentifiers;
        if (attributionidentifiers == null)
        {
            context = getAndroidIdViaService(context);
            obj = context;
            if (context == null)
            {
                obj = new AttributionIdentifiers();
            }
        }
        return ((AttributionIdentifiers) (obj));
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new FacebookException("getAndroidId cannot be called on the main thread.");
        }
          goto _L1
        context;
        Utility.logd("android_id", context);
_L3:
        return null;
_L1:
        Object obj = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] {
            android/content/Context
        });
        if (obj == null) goto _L3; else goto _L2
_L2:
        obj = Utility.invokeMethodQuietly(null, ((java.lang.reflect.Method) (obj)), new Object[] {
            context
        });
        if (!(obj instanceof Integer) || ((Integer)obj).intValue() != 0) goto _L3; else goto _L4
_L4:
        obj = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] {
            android/content/Context
        });
        if (obj == null) goto _L3; else goto _L5
_L5:
        context = ((Context) (Utility.invokeMethodQuietly(null, ((java.lang.reflect.Method) (obj)), new Object[] {
            context
        })));
        if (context == null) goto _L3; else goto _L6
_L6:
        java.lang.reflect.Method method;
        obj = Utility.getMethodQuietly(context.getClass(), "getId", new Class[0]);
        method = Utility.getMethodQuietly(context.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        if (obj == null || method == null) goto _L3; else goto _L7
_L7:
        AttributionIdentifiers attributionidentifiers = new AttributionIdentifiers();
        attributionidentifiers.androidAdvertiserId = (String)Utility.invokeMethodQuietly(context, ((java.lang.reflect.Method) (obj)), new Object[0]);
        attributionidentifiers.limitTracking = ((Boolean)Utility.invokeMethodQuietly(context, method, new Object[0])).booleanValue();
        return null;
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context)
    {
        GoogleAdServiceConnection googleadserviceconnection;
        googleadserviceconnection = new GoogleAdServiceConnection(null);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, googleadserviceconnection, 1))
        {
            break MISSING_BLOCK_LABEL_91;
        }
        AttributionIdentifiers attributionidentifiers;
        GoogleAdInfo googleadinfo = new GoogleAdInfo(googleadserviceconnection.getBinder());
        attributionidentifiers = new AttributionIdentifiers();
        attributionidentifiers.androidAdvertiserId = googleadinfo.getAdvertiserId();
        attributionidentifiers.limitTracking = googleadinfo.isTrackingLimited();
        context.unbindService(googleadserviceconnection);
        return attributionidentifiers;
        Object obj;
        obj;
        Utility.logd("android_id", ((Exception) (obj)));
        context.unbindService(googleadserviceconnection);
        return null;
        obj;
        context.unbindService(googleadserviceconnection);
        throw obj;
    }

    public static AttributionIdentifiers getAttributionIdentifiers(Context context)
    {
        Object obj1 = null;
        if (recentlyFetchedIdentifiers == null || System.currentTimeMillis() - recentlyFetchedIdentifiers.fetchTime >= 0x36ee80L) goto _L2; else goto _L1
_L1:
        Object obj = recentlyFetchedIdentifiers;
_L8:
        return ((AttributionIdentifiers) (obj));
_L2:
        AttributionIdentifiers attributionidentifiers = getAndroidId(context);
        if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) == null) goto _L4; else goto _L3
_L3:
        obj = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
_L7:
        String s = getInstallerPackageName(context);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        attributionidentifiers.androidInstallerPackage = s;
        if (obj != null) goto _L6; else goto _L5
_L5:
        return cacheAndReturnIdentifiers(attributionidentifiers);
_L4:
        if (context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0) == null)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        obj = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
          goto _L7
_L6:
        context = context.getContentResolver().query(((Uri) (obj)), new String[] {
            "aid", "androidid", "limit_tracking"
        }, null, null, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        obj = context;
        if (context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_170;
        }
        obj = context;
        obj1 = cacheAndReturnIdentifiers(attributionidentifiers);
        obj = obj1;
        if (context != null)
        {
            context.close();
            return ((AttributionIdentifiers) (obj1));
        }
          goto _L8
        obj = context;
        int i = context.getColumnIndex("aid");
        obj = context;
        int j = context.getColumnIndex("androidid");
        obj = context;
        int k = context.getColumnIndex("limit_tracking");
        obj = context;
        attributionidentifiers.attributionId = context.getString(i);
        if (j <= 0 || k <= 0)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        obj = context;
        if (attributionidentifiers.getAndroidAdvertiserId() != null)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        obj = context;
        attributionidentifiers.androidAdvertiserId = context.getString(j);
        obj = context;
        attributionidentifiers.limitTracking = Boolean.parseBoolean(context.getString(k));
        if (context != null)
        {
            context.close();
        }
        return cacheAndReturnIdentifiers(attributionidentifiers);
        obj1;
        context = null;
_L12:
        obj = context;
        (new StringBuilder("Caught unexpected exception in getAttributionId(): ")).append(((Exception) (obj1)).toString());
        if (context != null)
        {
            context.close();
        }
        return null;
        context;
        obj = obj1;
_L10:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw context;
        context;
        if (true) goto _L10; else goto _L9
_L9:
        obj1;
        if (true) goto _L12; else goto _L11
_L11:
        obj = null;
          goto _L7
    }

    private static String getInstallerPackageName(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        if (packagemanager != null)
        {
            return packagemanager.getInstallerPackageName(context.getPackageName());
        } else
        {
            return null;
        }
    }

    public String getAndroidAdvertiserId()
    {
        return androidAdvertiserId;
    }

    public String getAndroidInstallerPackage()
    {
        return androidInstallerPackage;
    }

    public String getAttributionId()
    {
        return attributionId;
    }

    public boolean isTrackingLimited()
    {
        return limitTracking;
    }


    /* member class not found */
    class GoogleAdServiceConnection {}


    /* member class not found */
    class GoogleAdInfo {}

}
