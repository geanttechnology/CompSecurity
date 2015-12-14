// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.millennialmedia.MMLog;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.conn.util.InetAddressUtils;

// Referenced classes of package com.millennialmedia.internal.utils:
//            ThreadUtils, Utils

public class EnvironmentUtils
{
    public static class AvailableCameras
    {

        public boolean backCamera;
        public boolean frontCamera;

        public AvailableCameras()
        {
        }
    }


    private static final String INTERNAL_CACHE_DIR = "/.com.millennialmedia//.internal/";
    private static final String MILLENNIAL_DIRECTORY = "/.com.millennialmedia/";
    public static final String ORIENTATION_LANDSCAPE = "landscape";
    public static final String ORIENTATION_PORTRAIT = "portrait";
    private static final String SCANNABLE_CACHE_DIR = "/millennial_media_cache/";
    private static final String TAG = com/millennialmedia/internal/utils/EnvironmentUtils.getSimpleName();
    private static Application application;
    private static Context applicationContext;
    private static AvailableCameras availableCameras;
    private static Integer cellSignalDbm;
    private static String deviceId;
    private static boolean hasBluetoothPermission;
    private static boolean hasCalendarPermission;
    private static boolean hasExternalStoragePermission;
    private static boolean hasFineLocationPermission;
    private static boolean hasMicrophonePermission;
    private static boolean hasNfcPermission;
    private static boolean hasVibratePermission;
    private static boolean hasWifiStatePermission;
    private static String userAgent;

    public EnvironmentUtils()
    {
    }

    public static boolean areHeadphonesPluggedIn()
    {
        return ((AudioManager)applicationContext.getSystemService("audio")).isWiredHeadsetOn();
    }

    public static String getAaid(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info)
    {
        if (info == null)
        {
            MMLog.e(TAG, "Unable to get aaid value");
            return null;
        } else
        {
            return info.getId();
        }
    }

    public static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info getAdInfo()
    {
        if (ThreadUtils.isUiThread())
        {
            MMLog.e(TAG, "Unable to get AdInfo instance on UI thread!");
        } else
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(applicationContext) == 0)
        {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
            try
            {
                info = AdvertisingIdClient.getAdvertisingIdInfo(applicationContext);
            }
            catch (IOException ioexception)
            {
                MMLog.e(TAG, "Unable to get google play services advertising info, google play services (e.g., the old version of the service doesn't support getting advertising ID)", ioexception);
                return null;
            }
            catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
            {
                MMLog.e(TAG, "Unable to get google play services advertising info, google play services is not available", googleplayservicesnotavailableexception);
                return null;
            }
            catch (IllegalStateException illegalstateexception)
            {
                MMLog.e(TAG, "Unable to get google play services advertising info, illegal state", illegalstateexception);
                return null;
            }
            catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
            {
                MMLog.e(TAG, "Unable to get google play services advertising info, google play services is not installed, up-to-date, or enabled", googleplayservicesrepairableexception);
                return null;
            }
            return info;
        }
        return null;
    }

    public static String getAppId()
    {
        return applicationContext.getPackageName();
    }

    public static Application getApplication()
    {
        return application;
    }

    public static Context getApplicationContext()
    {
        return applicationContext;
    }

    public static String getApplicationName()
    {
        Object obj;
        try
        {
            obj = applicationContext.getPackageManager();
            obj = ((PackageManager) (obj)).getApplicationLabel(((PackageManager) (obj)).getApplicationInfo(applicationContext.getPackageName(), 0)).toString();
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            MMLog.e(TAG, "Unable to determine package name", namenotfoundexception);
            return null;
        }
        return ((String) (obj));
    }

    public static AvailableCameras getAvailableCameras()
    {
        return availableCameras;
    }

    public static long getAvailableExternalStorageSize()
    {
        if (isExternalStorageReadable())
        {
            return getAvailableSize(Environment.getExternalStorageDirectory().getAbsolutePath());
        } else
        {
            return 0L;
        }
    }

    public static long getAvailableInternalStorageSize()
    {
        return getAvailableSize(Environment.getRootDirectory().getAbsolutePath());
    }

    private static long getAvailableSize(String s)
    {
        s = new StatFs(s);
        long l = s.getBlockSize();
        return (long)s.getAvailableBlocks() * l;
    }

    public static long getAvailableStorageSize()
    {
        return 0L + getAvailableInternalStorageSize() + getAvailableExternalStorageSize();
    }

    private static Intent getBatteryIntent()
    {
        return applicationContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public static Integer getBatteryLevel()
    {
        Intent intent = getBatteryIntent();
        if (intent != null)
        {
            int i = intent.getIntExtra("scale", -1);
            int j = intent.getIntExtra("level", -1);
            if (i != -1 && j != -1)
            {
                return Integer.valueOf(Math.round(100F * ((float)j / (float)i)));
            }
        }
        return null;
    }

    public static File getCacheDirectory()
    {
        if (isExternalStorageWritable())
        {
            return getExternalCacheDirectory(false);
        } else
        {
            return getInternalCacheDirectory();
        }
    }

    public static String getCellSignalDbm()
    {
        if (cellSignalDbm != null)
        {
            return cellSignalDbm.toString();
        } else
        {
            return null;
        }
    }

    public static int getConfigOrientationFromRequestedOrientation(int i)
    {
        switch (i)
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 10: // '\n'
        default:
            return getCurrentConfigOrientation();

        case 0: // '\0'
        case 6: // '\006'
        case 8: // '\b'
        case 11: // '\013'
            return 2;

        case 1: // '\001'
        case 7: // '\007'
        case 9: // '\t'
        case 12: // '\f'
            return 1;

        case -1: 
            return 0;
        }
    }

    public static int getCurrentConfigOrientation()
    {
        return applicationContext.getResources().getConfiguration().orientation;
    }

    public static String getCurrentConfigOrientationString()
    {
        switch (applicationContext.getResources().getConfiguration().orientation)
        {
        default:
            return getNaturalConfigOrientationString();

        case 1: // '\001'
            return "portrait";

        case 2: // '\002'
            return "landscape";
        }
    }

    static String getDeviceId()
    {
        Object obj2 = null;
        com/millennialmedia/internal/utils/EnvironmentUtils;
        JVM INSTR monitorenter ;
        if (deviceId == null) goto _L2; else goto _L1
_L1:
        Object obj = deviceId;
_L4:
        com/millennialmedia/internal/utils/EnvironmentUtils;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L2:
        String s = android.provider.Settings.Secure.getString(applicationContext.getContentResolver(), "android_id");
        obj = obj2;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new StringBuilder("mmh_");
        ((StringBuilder) (obj)).append(Utils.byteArrayToHex(MessageDigest.getInstance("MD5").digest(s.getBytes())));
        ((StringBuilder) (obj)).append("_");
        ((StringBuilder) (obj)).append(Utils.byteArrayToHex(MessageDigest.getInstance("SHA1").digest(s.getBytes())));
        deviceId = ((StringBuilder) (obj)).toString();
        obj = deviceId;
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        MMLog.e(TAG, (new StringBuilder()).append("Exception calculating device id hash with ANDROID_ID <").append(s).append(">").toString(), ((Throwable) (obj1)));
        obj1 = obj2;
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        throw obj1;
    }

    public static float getDisplayDensity()
    {
        return applicationContext.getResources().getDisplayMetrics().density;
    }

    public static int getDisplayDensityDpi()
    {
        return applicationContext.getResources().getDisplayMetrics().densityDpi;
    }

    public static int getDisplayHeight()
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            Display display = ((WindowManager)applicationContext.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            display.getRealSize(point);
            return point.y;
        } else
        {
            return applicationContext.getResources().getDisplayMetrics().heightPixels;
        }
    }

    public static int getDisplayWidth()
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            Display display = ((WindowManager)applicationContext.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            display.getRealSize(point);
            return point.x;
        } else
        {
            return applicationContext.getResources().getDisplayMetrics().widthPixels;
        }
    }

    public static File getExternalCacheDirectory(boolean flag)
    {
        File file = Environment.getExternalStorageDirectory();
        if (file != null)
        {
            Object obj;
            if (flag)
            {
                obj = "/millennial_media_cache/";
            } else
            {
                obj = "/.com.millennialmedia//.internal/";
            }
            obj = new File(file, ((String) (obj)));
            if ((((File) (obj)).exists() || ((File) (obj)).mkdirs()) && ((File) (obj)).isDirectory())
            {
                return ((File) (obj));
            }
        }
        return null;
    }

    public static String getHashedDeviceId(String s)
    {
        Object obj = null;
        com/millennialmedia/internal/utils/EnvironmentUtils;
        JVM INSTR monitorenter ;
        String s2 = android.provider.Settings.Secure.getString(applicationContext.getContentResolver(), "android_id");
        if (s2 != null) goto _L2; else goto _L1
_L1:
        s = obj;
_L4:
        com/millennialmedia/internal/utils/EnvironmentUtils;
        JVM INSTR monitorexit ;
        return s;
_L2:
        String s1 = Utils.byteArrayToHex(MessageDigest.getInstance(s).digest(s2.getBytes())).toString();
        s = s1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        MMLog.e(TAG, (new StringBuilder()).append("Exception calculating <").append(s).append("> hashed device id with ANDROID_ID <").append(s2).append(">").toString(), exception);
        s = obj;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public static File getInternalCacheDirectory()
    {
        File file = new File(applicationContext.getFilesDir(), "/.com.millennialmedia//.internal/");
        if ((file.exists() || file.mkdirs()) && file.isDirectory())
        {
            return file;
        } else
        {
            return null;
        }
    }

    public static String getIpAddress()
    {
        Object obj = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
_L2:
        Iterator iterator;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_120;
        }
        iterator = Collections.list(((NetworkInterface)((Iterator) (obj)).next()).getInetAddresses()).iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = (InetAddress)iterator.next();
        if (inetaddress.isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        obj = inetaddress.getHostAddress().toUpperCase();
        if (InetAddressUtils.isIPv4Address(((String) (obj))))
        {
            return ((String) (obj));
        }
        int i = ((String) (obj)).indexOf('%');
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        try
        {
            obj = ((String) (obj)).substring(0, i);
            break MISSING_BLOCK_LABEL_122;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.e(TAG, "Unable to determine IP address for device", ((Throwable) (obj)));
        }
        return null;
        return ((String) (obj));
    }

    public static String getLocaleCountry()
    {
        return Locale.getDefault().getCountry();
    }

    public static String getLocaleLanguage()
    {
        return Locale.getDefault().getLanguage();
    }

    public static Location getLocation()
    {
        if (hasFineLocationPermission)
        {
            LocationManager locationmanager = (LocationManager)applicationContext.getSystemService("location");
            if (locationmanager != null)
            {
                return locationmanager.getLastKnownLocation("passive");
            }
        }
        return null;
    }

    public static String getMacAddress()
    {
        if (hasWifiStatePermission)
        {
            return ((WifiManager)applicationContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } else
        {
            return null;
        }
    }

    public static Integer getMcc()
    {
        Object obj;
        obj = applicationContext.getResources().getConfiguration();
        if (((Configuration) (obj)).mcc != 0)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        obj = getNetworkOperator();
        if (obj == null || ((String) (obj)).length() < 6)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        int i = Integer.parseInt(((String) (obj)).substring(0, 3));
        return Integer.valueOf(i);
        obj;
        MMLog.w(TAG, "Unable to parse mcc from network operator", ((Throwable) (obj)));
        MMLog.w(TAG, "Unable to retrieve mcc");
        return null;
        return Integer.valueOf(((Configuration) (obj)).mcc);
    }

    public static File getMillennialDir()
    {
        File file = new File((new StringBuilder()).append(applicationContext.getFilesDir()).append("/.com.millennialmedia/").toString());
        file.mkdirs();
        return file;
    }

    public static Integer getMnc()
    {
        Object obj;
        obj = applicationContext.getResources().getConfiguration();
        if (((Configuration) (obj)).mnc != 0)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        obj = getNetworkOperator();
        if (obj == null || ((String) (obj)).length() < 6)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        int i = Integer.parseInt(((String) (obj)).substring(3));
        return Integer.valueOf(i);
        obj;
        MMLog.w(TAG, "Unable to parse mnc from network operator", ((Throwable) (obj)));
        MMLog.w(TAG, "Unable to retrieve mnc");
        return null;
        return Integer.valueOf(((Configuration) (obj)).mnc);
    }

    public static int getNaturalConfigOrientation()
    {
        WindowManager windowmanager = (WindowManager)applicationContext.getSystemService("window");
        Configuration configuration = applicationContext.getResources().getConfiguration();
        for (int i = windowmanager.getDefaultDisplay().getRotation(); configuration.orientation == 2 && (i == 0 || i == 2) || configuration.orientation == 1 && (i == 1 || i == 3);)
        {
            return 2;
        }

        return 1;
    }

    public static String getNaturalConfigOrientationString()
    {
        if (getNaturalConfigOrientation() == 2)
        {
            return "landscape";
        } else
        {
            return "portrait";
        }
    }

    public static String getNetworkConnectionType()
    {
        Object obj = (ConnectivityManager)applicationContext.getSystemService("connectivity");
        if (obj == null)
        {
            return "unknown";
        }
        obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
        if (obj != null && ((NetworkInfo) (obj)).isConnected())
        {
            int i = ((NetworkInfo) (obj)).getType();
            if (i == 1)
            {
                return "wifi";
            }
            if (i == 0)
            {
                switch (((NetworkInfo) (obj)).getSubtype())
                {
                default:
                    return "unknown";

                case 7: // '\007'
                    return "1xrtt";

                case 4: // '\004'
                    return "cdma";

                case 2: // '\002'
                    return "edge";

                case 14: // '\016'
                    return "ehrpd";

                case 5: // '\005'
                    return "evdo_0";

                case 6: // '\006'
                    return "evdo_a";

                case 12: // '\f'
                    return "evdo_b";

                case 1: // '\001'
                    return "gprs";

                case 8: // '\b'
                    return "hsdpa";

                case 10: // '\n'
                    return "hspa";

                case 15: // '\017'
                    return "hspap";

                case 9: // '\t'
                    return "hsupa";

                case 11: // '\013'
                    return "iden";

                case 13: // '\r'
                    return "lte";

                case 3: // '\003'
                    return "umts";
                }
            } else
            {
                return "unknown";
            }
        } else
        {
            return "offline";
        }
    }

    public static String getNetworkOperator()
    {
        return ((TelephonyManager)applicationContext.getSystemService("phone")).getNetworkOperator();
    }

    public static String getNetworkOperatorName()
    {
        return ((TelephonyManager)applicationContext.getSystemService("phone")).getNetworkOperatorName();
    }

    public static String getUserAgent()
    {
        if (userAgent != null)
        {
            return userAgent;
        }
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            userAgent = WebSettings.getDefaultUserAgent(applicationContext);
        } else
        {
            userAgent = (new WebView(applicationContext)).getSettings().getUserAgentString();
        }
        return userAgent;
    }

    public static int getVolume(int i)
    {
        AudioManager audiomanager = (AudioManager)applicationContext.getSystemService("audio");
        int j = audiomanager.getStreamMaxVolume(i);
        if (j < 1)
        {
            return 0;
        } else
        {
            float f = 100F / (float)j;
            return (int)((float)audiomanager.getStreamVolume(i) * f);
        }
    }

    public static boolean hasBluetooth()
    {
        return applicationContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    public static boolean hasBluetoothPermission()
    {
        return hasBluetoothPermission;
    }

    public static boolean hasCalendarPermission()
    {
        return hasCalendarPermission;
    }

    public static boolean hasCamera()
    {
        return availableCameras.backCamera || availableCameras.frontCamera;
    }

    public static boolean hasFineLocationPermission()
    {
        return hasFineLocationPermission;
    }

    public static boolean hasGps()
    {
        return applicationContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
    }

    public static boolean hasMicrophone()
    {
        return applicationContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    public static boolean hasMicrophonePermission()
    {
        return hasMicrophonePermission;
    }

    public static boolean hasNfc()
    {
        return applicationContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
    }

    public static boolean hasNfcPermission()
    {
        return hasNfcPermission;
    }

    public static boolean hasVibratePermission()
    {
        return hasVibratePermission;
    }

    public static void init(Activity activity)
    {
        application = activity.getApplication();
        applicationContext = activity.getApplicationContext();
        int i;
        int j;
        boolean flag;
        if (applicationContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasExternalStoragePermission = flag;
        if (applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasWifiStatePermission = flag;
        if (applicationContext.checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasCalendarPermission = flag;
        if (applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasFineLocationPermission = flag;
        if (applicationContext.checkCallingOrSelfPermission("android.permission.VIBRATE") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasVibratePermission = flag;
        if (applicationContext.checkCallingOrSelfPermission("android.permission.BLUETOOTH") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasBluetoothPermission = flag;
        if (applicationContext.checkCallingOrSelfPermission("android.permission.NFC") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasNfcPermission = flag;
        if (applicationContext.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasMicrophonePermission = flag;
        ((TelephonyManager)activity.getSystemService("phone")).listen(new PhoneStateListener() {

            public void onSignalStrengthsChanged(SignalStrength signalstrength)
            {
                super.onSignalStrengthsChanged(signalstrength);
                if (signalstrength.isGsm())
                {
                    EnvironmentUtils.cellSignalDbm = Integer.valueOf(signalstrength.getGsmSignalStrength() * 2 - 113);
                } else
                {
                    EnvironmentUtils.cellSignalDbm = Integer.valueOf(signalstrength.getCdmaDbm());
                }
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(EnvironmentUtils.TAG, (new StringBuilder()).append("Cell signal DBM updated to: ").append(EnvironmentUtils.cellSignalDbm).toString());
                }
            }

        }, 256);
        ThreadUtils.runOnWorkerThread(new Runnable() {

            public void run()
            {
                com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = EnvironmentUtils.getAdInfo();
                MMLog.i(EnvironmentUtils.TAG, (new StringBuilder()).append("AAID: ").append(EnvironmentUtils.getAaid(info)).toString());
                MMLog.i(EnvironmentUtils.TAG, (new StringBuilder()).append("Limit ad tracking enabled: ").append(EnvironmentUtils.isLimitAdTrackingEnabled(info)).toString());
            }

        });
        availableCameras = new AvailableCameras();
        availableCameras.frontCamera = false;
        availableCameras.backCamera = false;
        activity = new android.hardware.Camera.CameraInfo();
        j = Camera.getNumberOfCameras();
        i = 0;
        while (i < j) 
        {
            Camera.getCameraInfo(i, activity);
            if (((android.hardware.Camera.CameraInfo) (activity)).facing == 1)
            {
                availableCameras.frontCamera = true;
            } else
            if (((android.hardware.Camera.CameraInfo) (activity)).facing == 0)
            {
                availableCameras.backCamera = true;
            }
            i++;
        }
        MMLog.i(TAG, (new StringBuilder()).append("Environment initialized with the following data.\n\tMillennial Media Ad SDK version: 6.1.0-5323db4\n\tAndroid SDK version: ").append(android.os.Build.VERSION.SDK_INT).append("\n\tApplication name: ").append(getApplicationName()).append("\n\tApplication id: ").append(getAppId()).append("\n\tLocale country ").append(getLocaleCountry()).append("\n\tLocale language: ").append(getLocaleLanguage()).append("\n\tUser agent: ").append(getUserAgent()).append("\n\tExternal storage available: ").append(isExternalStorageReadable()).append("\n\tDisplay width: ").append(getDisplayWidth()).append("\n\tDisplay height: ").append(getDisplayHeight()).append("\n\tDisplay density: ").append(getDisplayDensity()).append("\n\tDisplay dpi: ").append(getDisplayDensityDpi()).append("\n\tNatural screen orientation: ").append(getNaturalConfigOrientationString()).append("\n\tWRITE_EXTERNAL_STORAGE permission available: ").append(hasExternalStoragePermission).append("\n\tACCESS_WIFI_STATE permission available: ").append(hasWifiStatePermission).append("\n\tWRITE_CALENDAR permission available: ").append(hasCalendarPermission).append("\n\tACCESS_FINE_LOCATION permission available: ").append(hasFineLocationPermission).append("\n\tVIBRATE permission available: ").append(hasVibratePermission).append("\n\tBLUETOOTH permission available: ").append(hasBluetoothPermission).append("\n\tNFC permission available: ").append(hasNfcPermission).append("\n\tRECORD_AUDIO permission available: ").append(hasMicrophonePermission).append("\n\tFront camera available: ").append(availableCameras.frontCamera).append("\n\tBack camera available: ").append(availableCameras.backCamera).append("\n\n").toString());
    }

    public static boolean isCalendarSupported()
    {
        return android.os.Build.VERSION.SDK_INT >= 14;
    }

    public static boolean isDevicePlugged()
    {
        for (Intent intent = getBatteryIntent(); intent == null || intent.getIntExtra("plugged", 0) == 0;)
        {
            return false;
        }

        return true;
    }

    public static boolean isExternalStorageReadable()
    {
        String s = Environment.getExternalStorageState();
        return hasExternalStoragePermission && ("mounted".equals(s) || "mounted_ro".equals(s));
    }

    public static boolean isExternalStorageSupported()
    {
        return hasExternalStoragePermission;
    }

    public static boolean isExternalStorageWritable()
    {
        String s = Environment.getExternalStorageState();
        return hasExternalStoragePermission && "mounted".equals(s);
    }

    public static boolean isLimitAdTrackingEnabled(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info)
    {
        if (info == null)
        {
            MMLog.e(TAG, "Unable to get limit ad tracking value, ad info is null");
            return false;
        } else
        {
            return info.isLimitAdTrackingEnabled();
        }
    }

    public static boolean isNetworkAvailable()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)applicationContext.getSystemService("connectivity");
        if (connectivitymanager != null) goto _L2; else goto _L1
_L1:
        NetworkInfo anetworkinfo[];
        return false;
_L2:
        if ((anetworkinfo = connectivitymanager.getAllNetworkInfo()) != null)
        {
            int i = 0;
            while (i < anetworkinfo.length) 
            {
                if (anetworkinfo[i].getState() == android.net.NetworkInfo.State.CONNECTED)
                {
                    return true;
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static boolean isSmsSupported()
    {
        return applicationContext.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    public static boolean isTelSupported()
    {
        return applicationContext.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }




/*
    static Integer access$002(Integer integer)
    {
        cellSignalDbm = integer;
        return integer;
    }

*/

}
