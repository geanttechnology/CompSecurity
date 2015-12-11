// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsInfoStore, MobileAdsLoggerFactory, StringUtils, WebUtils, 
//            JSONUtils, DisplayUtils, Size, UserAgentManager, 
//            MobileAdsLogger, ConnectionInfo

class DeviceInfo
{

    private static final String LOGTAG = com/amazon/device/ads/DeviceInfo.getSimpleName();
    public static final String ORIENTATION_LANDSCAPE = "landscape";
    public static final String ORIENTATION_PORTRAIT = "portrait";
    public static final String ORIENTATION_UNKNOWN = "unknown";
    private static final String dt = "android";
    private static final String os = "Android";
    private boolean bad_mac;
    private boolean bad_serial;
    private boolean bad_udid;
    private String carrier;
    private String country;
    private final MobileAdsInfoStore infoStore;
    private Size landscapeScreenSize;
    private String language;
    private final MobileAdsLogger logger;
    private boolean macFetched;
    private String make;
    private String model;
    private String osVersion;
    private Size portraitScreenSize;
    private float scalingFactor;
    private String scalingFactorAsString;
    private boolean serialFetched;
    private String sha1_mac;
    private String sha1_serial;
    private String sha1_udid;
    private String udid;
    private boolean udidFetched;
    private UserAgentManager userAgentManager;

    public DeviceInfo(Context context, UserAgentManager useragentmanager)
    {
        this(context, useragentmanager, MobileAdsInfoStore.getInstance(), new MobileAdsLoggerFactory());
    }

    DeviceInfo(Context context, UserAgentManager useragentmanager, MobileAdsInfoStore mobileadsinfostore, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        make = Build.MANUFACTURER;
        model = Build.MODEL;
        osVersion = android.os.Build.VERSION.RELEASE;
        logger = mobileadsloggerfactory.createMobileAdsLogger(LOGTAG);
        infoStore = mobileadsinfostore;
        setCountry();
        setCarrier(context);
        setLanguage();
        setScalingFactor(context);
        userAgentManager = useragentmanager;
    }

    private void setCarrier(Context context)
    {
        context = (TelephonyManager)context.getSystemService("phone");
        if (context != null)
        {
            context = context.getNetworkOperatorName();
            if (context == null || context.length() <= 0)
            {
                context = null;
            }
            carrier = context;
        }
    }

    private void setCountry()
    {
        String s = Locale.getDefault().getCountry();
        if (s == null || s.length() <= 0)
        {
            s = null;
        }
        country = s;
    }

    private void setLanguage()
    {
        String s = Locale.getDefault().getLanguage();
        if (s == null || s.length() <= 0)
        {
            s = null;
        }
        language = s;
    }

    private void setMacAddressIfNotFetched()
    {
        if (!macFetched)
        {
            setMacAddress();
        }
    }

    private void setScalingFactor(Context context)
    {
        if (make.equals("motorola") && model.equals("MB502"))
        {
            scalingFactor = 1.0F;
        } else
        {
            context = (WindowManager)context.getSystemService("window");
            DisplayMetrics displaymetrics = new DisplayMetrics();
            context.getDefaultDisplay().getMetrics(displaymetrics);
            scalingFactor = displaymetrics.scaledDensity;
        }
        scalingFactorAsString = Float.toString(scalingFactor);
    }

    private void setSerial()
    {
        String s = null;
        String s1 = (String)android/os/Build.getDeclaredField("SERIAL").get(android/os/Build);
        s = s1;
_L2:
        if (s == null || s.length() == 0 || s.equalsIgnoreCase("unknown"))
        {
            bad_serial = true;
        } else
        {
            sha1_serial = WebUtils.getURLEncodedString(StringUtils.sha1(s));
        }
        serialFetched = true;
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void setSerialIfNotFetched()
    {
        if (!serialFetched)
        {
            setSerial();
        }
    }

    private void setUdid()
    {
        String s = android.provider.Settings.Secure.getString(infoStore.getApplicationContext().getContentResolver(), "android_id");
        if (StringUtils.isNullOrEmpty(s) || s.equalsIgnoreCase("9774d56d682e549c"))
        {
            udid = null;
            sha1_udid = null;
            bad_udid = true;
        } else
        {
            udid = WebUtils.getURLEncodedString(s);
            sha1_udid = WebUtils.getURLEncodedString(StringUtils.sha1(s));
        }
        udidFetched = true;
    }

    private void setUdidIfNotFetched()
    {
        if (!udidFetched)
        {
            setUdid();
        }
    }

    public String getCarrier()
    {
        return carrier;
    }

    public String getCountry()
    {
        return country;
    }

    public JSONObject getDInfoProperty()
    {
        JSONObject jsonobject = new JSONObject();
        JSONUtils.put(jsonobject, "make", getMake());
        JSONUtils.put(jsonobject, "model", getModel());
        JSONUtils.put(jsonobject, "os", getOS());
        JSONUtils.put(jsonobject, "osVersion", getOSVersion());
        JSONUtils.put(jsonobject, "scalingFactor", getScalingFactorAsString());
        JSONUtils.put(jsonobject, "language", getLanguage());
        JSONUtils.put(jsonobject, "country", getCountry());
        JSONUtils.put(jsonobject, "carrier", getCarrier());
        return jsonobject;
    }

    public String getDeviceType()
    {
        return "android";
    }

    public String getLanguage()
    {
        return language;
    }

    public String getMacSha1()
    {
        setMacAddressIfNotFetched();
        return sha1_mac;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public String getOS()
    {
        return "Android";
    }

    public String getOSVersion()
    {
        return osVersion;
    }

    public String getOrientation()
    {
        switch (DisplayUtils.determineCanonicalScreenOrientation(infoStore.getApplicationContext()))
        {
        default:
            return "unknown";

        case 1: // '\001'
        case 9: // '\t'
            return "portrait";

        case 0: // '\0'
        case 8: // '\b'
            return "landscape";
        }
    }

    public float getScalingFactorAsFloat()
    {
        return scalingFactor;
    }

    public String getScalingFactorAsString()
    {
        return scalingFactorAsString;
    }

    public Size getScreenSize(String s)
    {
        if (s.equals("portrait") && portraitScreenSize != null)
        {
            return portraitScreenSize;
        }
        if (s.equals("landscape") && landscapeScreenSize != null)
        {
            return landscapeScreenSize;
        }
        Object obj = (WindowManager)infoStore.getApplicationContext().getSystemService("window");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager) (obj)).getDefaultDisplay().getMetrics(displaymetrics);
        obj = (new StringBuilder()).append(String.valueOf(displaymetrics.widthPixels)).append("x").append(String.valueOf(displaymetrics.heightPixels)).toString();
        if (s.equals("portrait"))
        {
            portraitScreenSize = new Size(((String) (obj)));
            return portraitScreenSize;
        }
        if (s.equals("landscape"))
        {
            landscapeScreenSize = new Size(((String) (obj)));
            return landscapeScreenSize;
        } else
        {
            return new Size(((String) (obj)));
        }
    }

    public String getSerialSha1()
    {
        setSerialIfNotFetched();
        return sha1_serial;
    }

    public String getUdid()
    {
        setUdidIfNotFetched();
        return udid;
    }

    public String getUdidSha1()
    {
        setUdidIfNotFetched();
        return sha1_udid;
    }

    public String getUserAgentString()
    {
        return userAgentManager.getUserAgentString();
    }

    public boolean isMacBad()
    {
        setMacAddressIfNotFetched();
        return bad_mac;
    }

    public boolean isSerialBad()
    {
        setSerialIfNotFetched();
        return bad_serial;
    }

    public boolean isUdidBad()
    {
        setUdidIfNotFetched();
        return bad_udid;
    }

    public void populateUserAgentString(Context context)
    {
        userAgentManager.populateUserAgentString(context);
    }

    protected void setMacAddress()
    {
        WifiManager wifimanager = (WifiManager)infoStore.getApplicationContext().getSystemService("wifi");
        Object obj1 = null;
        Object obj = obj1;
        if (wifimanager != null)
        {
            try
            {
                obj = wifimanager.getConnectionInfo();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                logger.d("Unable to get Wifi connection information: %s", new Object[] {
                    obj
                });
                obj = obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                logger.d("Unable to get Wifi connection information: %s", new Object[] {
                    obj
                });
                obj = obj1;
            }
        }
        if (obj == null)
        {
            sha1_mac = null;
        } else
        {
            obj = ((WifiInfo) (obj)).getMacAddress();
            if (obj == null || ((String) (obj)).length() == 0)
            {
                sha1_mac = null;
                bad_mac = true;
            } else
            if (!Pattern.compile("((([0-9a-fA-F]){1,2}[-:]){5}([0-9a-fA-F]){1,2})").matcher(((CharSequence) (obj))).find())
            {
                sha1_mac = null;
                bad_mac = true;
            } else
            {
                sha1_mac = WebUtils.getURLEncodedString(StringUtils.sha1(((String) (obj))));
            }
        }
        macFetched = true;
    }

    public void setUserAgentManager(UserAgentManager useragentmanager)
    {
        userAgentManager = useragentmanager;
    }

    public void setUserAgentString(String s)
    {
        userAgentManager.setUserAgentString(s);
    }

    JSONObject toJsonObject(String s)
    {
        JSONObject jsonobject = getDInfoProperty();
        JSONUtils.put(jsonobject, "orientation", s);
        JSONUtils.put(jsonobject, "screenSize", getScreenSize(s).toString());
        JSONUtils.put(jsonobject, "connectionType", (new ConnectionInfo(infoStore)).getConnectionType());
        return jsonobject;
    }

    public String toJsonString()
    {
        return toJsonObject(getOrientation()).toString();
    }

}
