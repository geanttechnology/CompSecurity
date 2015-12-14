// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

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

// Referenced classes of package com.amazon.device.ads.identity:
//            JSONUtils, StringUtils, WebUtils, AmazonRegistration, 
//            IAmazonRegistration, UserAgentManager, Log

class DeviceInfo
{

    private static final String LOG_TAG = com/amazon/device/ads/identity/DeviceInfo.getSimpleName();
    private boolean bad_mac;
    private boolean bad_serial;
    private boolean bad_udid;
    private String carrier;
    private String country;
    private String language;
    private boolean macFetched;
    private String make;
    private String model;
    private String osVersion;
    private float scalingFactor;
    private String scalingFactorAsString;
    private boolean serialFetched;
    private String sha1_mac;
    private String sha1_serial;
    private String sha1_udid;
    private String udid;
    private boolean udidFetched;
    private UserAgentManager userAgentManager;

    protected DeviceInfo()
    {
        make = Build.MANUFACTURER;
        model = Build.MODEL;
        osVersion = android.os.Build.VERSION.RELEASE;
    }

    public DeviceInfo(Context context, UserAgentManager useragentmanager)
    {
        Object obj1 = null;
        super();
        make = Build.MANUFACTURER;
        model = Build.MODEL;
        osVersion = android.os.Build.VERSION.RELEASE;
        Object obj = Locale.getDefault().getCountry();
        if (obj == null || ((String) (obj)).length() <= 0)
        {
            obj = null;
        }
        country = ((String) (obj));
        obj = (TelephonyManager)context.getSystemService("phone");
        if (obj != null)
        {
            obj = ((TelephonyManager) (obj)).getNetworkOperatorName();
            String s;
            if (obj == null || ((String) (obj)).length() <= 0)
            {
                obj = null;
            }
            carrier = ((String) (obj));
        }
        s = Locale.getDefault().getLanguage();
        obj = obj1;
        if (s != null)
        {
            obj = obj1;
            if (s.length() > 0)
            {
                obj = s;
            }
        }
        language = ((String) (obj));
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
        userAgentManager = useragentmanager;
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
        JSONUtils.put(jsonobject, "os", "Android");
        JSONUtils.put(jsonobject, "osVersion", getOSVersion());
        JSONUtils.put(jsonobject, "scalingFactor", getScalingFactorAsString());
        JSONUtils.put(jsonobject, "language", getLanguage());
        JSONUtils.put(jsonobject, "country", getCountry());
        JSONUtils.put(jsonobject, "carrier", getCarrier());
        return jsonobject;
    }

    public String getLanguage()
    {
        return language;
    }

    public String getMacSha1()
    {
        if (!macFetched)
        {
            setMacAddress();
        }
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

    public String getOSVersion()
    {
        return osVersion;
    }

    public String getScalingFactorAsString()
    {
        return scalingFactorAsString;
    }

    public String getSerialSha1()
    {
        if (!serialFetched)
        {
            Object obj;
            try
            {
                obj = (String)android/os/Build.getDeclaredField("SERIAL").get(android/os/Build);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = null;
            }
            if (obj == null || ((String) (obj)).length() == 0 || ((String) (obj)).equalsIgnoreCase("unknown"))
            {
                bad_serial = true;
            } else
            {
                sha1_serial = WebUtils.getURLEncodedString(StringUtils.sha1(((String) (obj))));
            }
            serialFetched = true;
        }
        return sha1_serial;
    }

    public String getUdidSha1()
    {
        if (!udidFetched)
        {
            String s = android.provider.Settings.Secure.getString(AmazonRegistration.getInstance().getApplicationContext().getContentResolver(), "android_id");
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
        return sha1_udid;
    }

    public String getUserAgentString()
    {
        return userAgentManager.getUserAgentString();
    }

    protected void setMacAddress()
    {
        WifiManager wifimanager = (WifiManager)AmazonRegistration.getInstance().getApplicationContext().getSystemService("wifi");
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
                Log.d(LOG_TAG, "Unable to get Wifi connection information: %s", new Object[] {
                    obj
                });
                obj = obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.d(LOG_TAG, "Unable to get Wifi connection information: %s", new Object[] {
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

}
