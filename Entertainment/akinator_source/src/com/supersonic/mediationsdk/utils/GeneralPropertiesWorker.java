// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import com.supersonic.mediationsdk.sdk.GeneralProperties;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

// Referenced classes of package com.supersonic.mediationsdk.utils:
//            SupersonicUtils

public class GeneralPropertiesWorker
    implements Runnable
{

    private final String ADVERTISING_ID;
    private final String ADVERTISING_ID_IS_LIMIT_TRACKING;
    private final String ANDROID_OS_VERSION;
    private final String APPLICATION_KEY;
    private final String BATTERY_LEVEL;
    private final String BUNDLE_ID;
    private final String CONNECTION_TYPE;
    private final String DEVICE_MODEL;
    private final String DEVICE_OEM;
    private final String DEVICE_OS;
    private final String EXTERNAL_FREE_MEMORY;
    private final String INTERNAL_FREE_MEMORY;
    private final String LANGUAGE;
    private final String LOCATION_LAT;
    private final String LOCATION_LON;
    private final String MOBILE_CARRIER;
    private final String SDK_VERSION;
    private final String TAG;
    private final String TIME_ZONE;
    private Activity mActivity;
    private Context mContext;

    private GeneralPropertiesWorker()
    {
        TAG = getClass().getSimpleName();
        BUNDLE_ID = "bundleId";
        ADVERTISING_ID = "advertisingId";
        ADVERTISING_ID_IS_LIMIT_TRACKING = "isLimitAdTrackingEnabled";
        APPLICATION_KEY = "appKey";
        DEVICE_OS = "deviceOS";
        ANDROID_OS_VERSION = "osVersion";
        CONNECTION_TYPE = "connectionType";
        SDK_VERSION = "sdkVersion";
        LANGUAGE = "language";
        DEVICE_OEM = "deviceOEM";
        DEVICE_MODEL = "deviceModel";
        MOBILE_CARRIER = "mobileCarrier";
        EXTERNAL_FREE_MEMORY = "externalFreeMemory";
        INTERNAL_FREE_MEMORY = "internalFreeMemory";
        BATTERY_LEVEL = "battery";
        LOCATION_LAT = "lat";
        LOCATION_LON = "lon";
        TIME_ZONE = "timeZone";
    }

    public GeneralPropertiesWorker(Activity activity)
    {
        TAG = getClass().getSimpleName();
        BUNDLE_ID = "bundleId";
        ADVERTISING_ID = "advertisingId";
        ADVERTISING_ID_IS_LIMIT_TRACKING = "isLimitAdTrackingEnabled";
        APPLICATION_KEY = "appKey";
        DEVICE_OS = "deviceOS";
        ANDROID_OS_VERSION = "osVersion";
        CONNECTION_TYPE = "connectionType";
        SDK_VERSION = "sdkVersion";
        LANGUAGE = "language";
        DEVICE_OEM = "deviceOEM";
        DEVICE_MODEL = "deviceModel";
        MOBILE_CARRIER = "mobileCarrier";
        EXTERNAL_FREE_MEMORY = "externalFreeMemory";
        INTERNAL_FREE_MEMORY = "internalFreeMemory";
        BATTERY_LEVEL = "battery";
        LOCATION_LAT = "lat";
        LOCATION_LON = "lon";
        TIME_ZONE = "timeZone";
        mContext = activity.getApplicationContext();
        mActivity = activity;
    }

    private Map collectInformation()
    {
        HashMap hashmap = new HashMap();
        String s = getBundleId();
        if (!TextUtils.isEmpty(s))
        {
            hashmap.put("bundleId", s);
        }
        hashmap.put("appKey", getApplicationKey(mContext));
        String as[] = getAdvertisingIdInfo();
        if (as != null && as.length == 2)
        {
            hashmap.put("advertisingId", as[0]);
            hashmap.put("isLimitAdTrackingEnabled", as[1]);
        }
        hashmap.put("deviceOS", getDeviceOS());
        if (!TextUtils.isEmpty(getAndroidVersion()))
        {
            hashmap.put("osVersion", getAndroidVersion());
        }
        as = getConnectionType();
        if (!TextUtils.isEmpty(as))
        {
            hashmap.put("connectionType", as);
        }
        hashmap.put("sdkVersion", getSDKVersion());
        as = getLanguage();
        if (!TextUtils.isEmpty(as))
        {
            hashmap.put("language", as);
        }
        as = getDeviceOEM();
        if (!TextUtils.isEmpty(as))
        {
            hashmap.put("deviceOEM", as);
        }
        as = getDeviceModel();
        if (!TextUtils.isEmpty(as))
        {
            hashmap.put("deviceModel", as);
        }
        as = getMobileCarrier();
        if (!TextUtils.isEmpty(as))
        {
            hashmap.put("mobileCarrier", as);
        }
        as = getInternalStorageFreeSize();
        if (!TextUtils.isEmpty(as))
        {
            hashmap.put("internalFreeMemory", as);
        }
        as = getExternalStorageFreeSize();
        if (!TextUtils.isEmpty(as))
        {
            hashmap.put("externalFreeMemory", as);
        }
        as = getBatteryLevel();
        if (!TextUtils.isEmpty(as))
        {
            hashmap.put("battery", as);
        }
        as = getLastKnownLocation();
        if (as != null && as.length == 2 && !TextUtils.isEmpty(as[0]) && !TextUtils.isEmpty(as[1]))
        {
            hashmap.put("lat", as[0]);
            hashmap.put("lon", as[1]);
        }
        as = getTimeZone();
        if (!TextUtils.isEmpty(as))
        {
            hashmap.put("timeZone", as);
        }
        return hashmap;
    }

    private String[] getAdvertisingIdInfo()
    {
        Object obj;
        Object obj2;
        obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        obj = ((Class) (obj)).getMethod("getAdvertisingIdInfo", new Class[] {
            android/content/Context
        }).invoke(obj, new Object[] {
            mActivity
        });
        obj2 = obj.getClass().getMethod("getId", new Class[0]);
        Method method = obj.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
        obj2 = ((Method) (obj2)).invoke(obj, new Object[0]).toString();
        boolean flag = ((Boolean)method.invoke(obj, new Object[0])).booleanValue();
        if (TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            break MISSING_BLOCK_LABEL_150;
        }
        obj = (new StringBuilder()).append("").append(flag).toString();
        return (new String[] {
            obj2, obj
        });
        Object obj1;
        obj1;
        SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "getAdvertisingIdInfo()", ((Throwable) (obj1)));
_L2:
        return new String[0];
        obj1;
        SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "getAdvertisingIdInfo()", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "getAdvertisingIdInfo()", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "getAdvertisingIdInfo()", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "getAdvertisingIdInfo()", ((Throwable) (obj1)));
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String getAndroidVersion()
    {
        String s;
        try
        {
            s = android.os.Build.VERSION.RELEASE;
            int i = android.os.Build.VERSION.SDK_INT;
            s = (new StringBuilder()).append("").append(i).append("(").append(s).append(")").toString();
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    private String getApplicationKey(Context context)
    {
        return SupersonicUtils.getSupersonicApplicationKey(context);
    }

    private String getBatteryLevel()
    {
        String s1 = "";
        float f;
        String s;
        int i;
        int j;
        try
        {
            Intent intent = mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            i = intent.getIntExtra("level", -1);
            j = intent.getIntExtra("scale", -1);
        }
        catch (Exception exception)
        {
            SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(TAG).append(":getBatteryLevel()").toString(), exception);
            return "";
        }
        s = s1;
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        s = s1;
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        f = (float)i / (float)j;
        s = String.valueOf(f * 100F);
        return s;
    }

    private String getBundleId()
    {
        String s;
        try
        {
            s = mContext.getPackageName();
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    private String getConnectionType()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        String s;
        int i;
        if (!networkinfo.isConnected())
        {
            break MISSING_BLOCK_LABEL_124;
        }
        s = networkinfo.getTypeName();
        i = networkinfo.getType();
        if (i == 0)
        {
            try
            {
                TelephonyManager telephonymanager = (TelephonyManager)mContext.getSystemService("phone");
                return (new StringBuilder()).append("").append(telephonymanager.getNetworkType()).toString();
            }
            catch (Exception exception)
            {
                SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(TAG).append(":getConnectionType()").toString(), exception);
            }
        } else
        if (i == 1)
        {
            return "wifi";
        } else
        {
            return s;
        }
        return "";
    }

    private String getDeviceModel()
    {
        String s;
        try
        {
            s = Build.MODEL;
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    private String getDeviceOEM()
    {
        String s;
        try
        {
            s = Build.MANUFACTURER;
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    private String getDeviceOS()
    {
        return "Android";
    }

    private String getExternalStorageFreeSize()
    {
        if (isExternalStorageAbvailable())
        {
            StatFs statfs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long l = statfs.getBlockSize();
            long l1 = statfs.getAvailableBlocks();
            return (new StringBuilder()).append("").append((l1 * l) / 0x100000L).toString();
        } else
        {
            return "";
        }
    }

    private String getInternalStorageFreeSize()
    {
        Object obj;
        try
        {
            obj = new StatFs(Environment.getDataDirectory().getPath());
            long l = ((StatFs) (obj)).getBlockSize();
            long l1 = ((StatFs) (obj)).getAvailableBlocks();
            obj = (new StringBuilder()).append("").append((l1 * l) / 0x100000L).toString();
        }
        catch (Exception exception)
        {
            return "";
        }
        return ((String) (obj));
    }

    private String getLanguage()
    {
        String s;
        try
        {
            s = Locale.getDefault().getLanguage().toString();
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    private String[] getLastKnownLocation()
    {
        String as[];
        String as1[];
        long l;
        as1 = new String[0];
        l = 0x8000000000000000L;
        as = as1;
        LocationManager locationmanager;
        if (!locationPermissionGranted())
        {
            break MISSING_BLOCK_LABEL_155;
        }
        locationmanager = (LocationManager)mContext.getApplicationContext().getSystemService("location");
        Object obj = null;
        Iterator iterator = locationmanager.getAllProviders().iterator();
_L2:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_112;
            }
            as = locationmanager.getLastKnownLocation((String)iterator.next());
        } while (as == null);
        if (as.getTime() > l)
        {
            obj = as;
            double d;
            double d1;
            try
            {
                l = ((Location) (obj)).getTime();
            }
            catch (Exception exception)
            {
                SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(TAG).append(":getLastLocation()").toString(), exception);
                return new String[0];
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        as = as1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        d = ((Location) (obj)).getLatitude();
        d1 = ((Location) (obj)).getLongitude();
        as = new String[2];
        as[0] = String.valueOf(d);
        as[1] = String.valueOf(d1);
        return as;
    }

    private String getMobileCarrier()
    {
        String s1 = "";
        String s;
        Object obj;
        boolean flag;
        try
        {
            obj = (TelephonyManager)mContext.getSystemService("phone");
        }
        catch (Exception exception)
        {
            SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(TAG).append(":getMobileCarrier()").toString(), exception);
            return "";
        }
        s = s1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj = ((TelephonyManager) (obj)).getNetworkOperatorName();
        flag = ((String) (obj)).equals("");
        s = s1;
        if (!flag)
        {
            s = ((String) (obj));
        }
        return s;
    }

    private String getSDKVersion()
    {
        return SupersonicUtils.getSDKVersion();
    }

    private String getTimeZone()
    {
        String s;
        String s1;
        StringBuilder stringbuilder;
        int i;
        try
        {
            TimeZone timezone = TimeZone.getDefault();
            i = timezone.getOffset(GregorianCalendar.getInstance(timezone).getTimeInMillis());
            s1 = String.format("%02d:%02d", new Object[] {
                Integer.valueOf(Math.abs(i / 0x36ee80)), Integer.valueOf(Math.abs((i / 60000) % 60))
            });
            stringbuilder = new StringBuilder();
        }
        catch (Exception exception)
        {
            return "";
        }
        if (i >= 0)
        {
            s = "+";
        } else
        {
            s = "-";
        }
        s = stringbuilder.append(s).append(s1).toString();
        return (new StringBuilder()).append("GMT").append(s).toString();
    }

    private boolean isExternalStorageAbvailable()
    {
        boolean flag;
        try
        {
            flag = Environment.getExternalStorageState().equals("mounted");
        }
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }

    private boolean locationPermissionGranted()
    {
        boolean flag = false;
        int i;
        try
        {
            i = mContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        }
        catch (Exception exception)
        {
            return false;
        }
        if (i == 0)
        {
            flag = true;
        }
        return flag;
    }

    public void run()
    {
        Map map = collectInformation();
        GeneralProperties.getProperties().putKeys(map);
    }
}
