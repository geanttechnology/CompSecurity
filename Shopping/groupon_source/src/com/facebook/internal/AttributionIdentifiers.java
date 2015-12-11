// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookException;

// Referenced classes of package com.facebook.internal:
//            Utility

public class AttributionIdentifiers
{

    private static final String TAG = com/facebook/internal/AttributionIdentifiers.getCanonicalName();
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    public AttributionIdentifiers()
    {
    }

    private static AttributionIdentifiers getAndroidId(Context context)
    {
        AttributionIdentifiers attributionidentifiers = new AttributionIdentifiers();
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new FacebookException("getAndroidId cannot be called on the main thread.");
        }
          goto _L1
        context;
        Utility.logd("android_id", context);
_L3:
        return attributionidentifiers;
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
        attributionidentifiers.androidAdvertiserId = (String)Utility.invokeMethodQuietly(context, ((java.lang.reflect.Method) (obj)), new Object[0]);
        attributionidentifiers.limitTracking = ((Boolean)Utility.invokeMethodQuietly(context, method, new Object[0])).booleanValue();
        return attributionidentifiers;
    }

    public static AttributionIdentifiers getAttributionIdentifiers(Context context)
    {
        if (recentlyFetchedIdentifiers == null || System.currentTimeMillis() - recentlyFetchedIdentifiers.fetchTime >= 0x36ee80L) goto _L2; else goto _L1
_L1:
        context = recentlyFetchedIdentifiers;
_L8:
        return context;
_L2:
        Cursor cursor;
        Cursor cursor1;
        Object obj;
        AttributionIdentifiers attributionidentifiers;
        Object obj1;
        Object obj2;
        attributionidentifiers = getAndroidId(context);
        obj2 = null;
        obj1 = null;
        obj = null;
        cursor = obj1;
        cursor1 = obj2;
        if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) == null) goto _L4; else goto _L3
_L3:
        cursor = obj1;
        cursor1 = obj2;
        obj = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
_L6:
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = attributionidentifiers;
        if (false)
        {
            throw new NullPointerException();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        cursor = obj1;
        cursor1 = obj2;
        if (context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        cursor = obj1;
        cursor1 = obj2;
        obj = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
        if (true) goto _L6; else goto _L5
_L5:
        cursor = obj1;
        cursor1 = obj2;
        obj = context.getContentResolver().query(((Uri) (obj)), new String[] {
            "aid", "androidid", "limit_tracking"
        }, null, null, null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        boolean flag = ((Cursor) (obj)).moveToFirst();
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        context = attributionidentifiers;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            return attributionidentifiers;
        }
        if (true) goto _L8; else goto _L7
_L7:
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        int k = ((Cursor) (obj)).getColumnIndex("aid");
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        int i = ((Cursor) (obj)).getColumnIndex("androidid");
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        int j = ((Cursor) (obj)).getColumnIndex("limit_tracking");
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        attributionidentifiers.attributionId = ((Cursor) (obj)).getString(k);
        if (i <= 0 || j <= 0)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        if (attributionidentifiers.getAndroidAdvertiserId() != null)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        attributionidentifiers.androidAdvertiserId = ((Cursor) (obj)).getString(i);
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        attributionidentifiers.limitTracking = Boolean.parseBoolean(((Cursor) (obj)).getString(j));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        attributionidentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionidentifiers;
        return attributionidentifiers;
        context;
        cursor1 = cursor;
        Log.d(TAG, (new StringBuilder()).append("Caught unexpected exception in getAttributionId(): ").append(context.toString()).toString());
        context = null;
        if (cursor == null) goto _L8; else goto _L9
_L9:
        cursor.close();
        return null;
        context;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw context;
    }

    public String getAndroidAdvertiserId()
    {
        return androidAdvertiserId;
    }

    public String getAttributionId()
    {
        return attributionId;
    }

    public boolean isTrackingLimited()
    {
        return limitTracking;
    }

}
