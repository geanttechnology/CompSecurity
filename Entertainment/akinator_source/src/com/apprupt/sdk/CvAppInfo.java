// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvAppsList, CvGeoLocation, CvFeaturesList, 
//            CvHash, CvCrypto, Connectivity

class CvAppInfo
{

    private static CvAppInfo instance;
    private String advIdent;
    private String advIdentMD5;
    private String advIdentSHA1;
    private String ahMD5;
    private String ahSHA1;
    private String appId;
    private String appName;
    final CvAppsList appsList;
    private String carrier;
    private String imei;
    private final Logger.log log;
    private Context mContext;
    private String mac;
    private String macMD5;
    private String macSHA1;
    private boolean optOut;
    private float pixelRatio;
    private int screenHeight;
    private int screenWidth;
    private String simCardSerial;
    private String udid;
    private String udidMD5;
    private String udidSHA1;
    private String userAgent;

    private CvAppInfo(Context context)
    {
        mac = "";
        udid = "";
        imei = "";
        simCardSerial = "";
        udidMD5 = "";
        advIdent = "";
        advIdentMD5 = "";
        advIdentSHA1 = "";
        udidSHA1 = "";
        macMD5 = "";
        macSHA1 = "";
        appId = "";
        appName = "";
        userAgent = (new StringBuilder()).append("Mozilla/5.0 (Linux; Android ").append(android.os.Build.VERSION.RELEASE).append("; Build/").append(Build.ID).append("; ").append(Build.BRAND).append(") ").append("AppleWebKit/unknown (KHTML, like Gecko) Chrome/unknown Mobile ").append("Safari/unknown").toString();
        ahSHA1 = "";
        ahMD5 = "";
        carrier = "";
        optOut = false;
        screenWidth = 0;
        screenHeight = 0;
        pixelRatio = 0.0F;
        log = Logger.get("APP_INFO");
        log.v(new Object[] {
            (new StringBuilder()).append("Initializing CvAppInfo on android ").append(android.os.Build.VERSION.INCREMENTAL).append(" ").append(android.os.Build.VERSION.CODENAME).append(" (API ").append(android.os.Build.VERSION.SDK_INT).append(")").toString()
        });
        appsList = new CvAppsList(context);
        buildUserAgent(context);
        this;
        JVM INSTR monitorenter ;
        mContext = context.getApplicationContext();
        determineAdvIdent();
        CvGeoLocation.startListener(context);
        obtainMacAddress(context);
        obtainTelephonyIds(context);
        obtainUdid(context);
        ApplicationInfo applicationinfo = context.getApplicationInfo();
        appId = applicationinfo.packageName;
        appName = applicationinfo.name;
        buildAndroidHash();
        findCarrier(context);
        setupScreenValues();
        this;
        JVM INSTR monitorexit ;
        if (!isPhone())
        {
            CvFeaturesList.DEFAULT_SET[0] = CvFeaturesList.DEFAULT_SET[0] & -3;
        }
        return;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void _buildUserAgent(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        try
        {
            userAgent = (new WebView(context)).getSettings().getUserAgentString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void buildAndroidHash()
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            obj = Build.CPU_ABI;
        } else
        {
            obj = new StringBuilder();
            for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++)
            {
                if (i > 0)
                {
                    ((StringBuilder) (obj)).append(",");
                }
                ((StringBuilder) (obj)).append(Build.SUPPORTED_ABIS[i]);
            }

            obj = ((StringBuilder) (obj)).toString();
        }
        obj = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s", new Object[] {
            mac, udid, udid, simCardSerial, imei, Build.BOARD, obj, Build.DEVICE, Long.toString(Build.TIME), Build.MODEL
        });
        ahSHA1 = CvHash.SHA1(((String) (obj)));
        ahMD5 = CvHash.SHA1(((String) (obj)));
    }

    private String buildUid()
    {
        Object obj;
        try
        {
            obj = new JSONObject();
            ((JSONObject) (obj)).put("udid_md5", udidMD5);
            ((JSONObject) (obj)).put("udid_sha1", udidSHA1);
            ((JSONObject) (obj)).put("mac_md5", macMD5);
            ((JSONObject) (obj)).put("mac_sha1", macSHA1);
            ((JSONObject) (obj)).put("advident", advIdent);
            ((JSONObject) (obj)).put("advident_sha1", advIdentSHA1);
            ((JSONObject) (obj)).put("advident_md5", advIdentMD5);
            obj = CvCrypto.encode(((JSONObject) (obj)).toString().getBytes());
        }
        catch (JSONException jsonexception)
        {
            log.e(new Object[] {
                "Caught exception while building UID object", jsonexception
            });
            return "";
        }
        return ((String) (obj));
    }

    private void buildUserAgent(Context context)
    {
        if (Looper.getMainLooper().getThread() != Thread.currentThread())
        {
            _buildUserAgent(context);
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(new _cls2(context));
            return;
        }
    }

    private void createMACHashes()
    {
        if (!mac.matches("^[0-9a-fA-F]{2}([^0-9a-fA-F][0-9a-fA-F]{2}){5}$")) goto _L2; else goto _L1
_L1:
        String as[] = mac.split("[^0-9a-fA-F]");
_L4:
        byte abyte0[];
        abyte0 = new byte[as.length];
        for (int i = 0; i < as.length; i++)
        {
            abyte0[i] = (byte)((Character.digit(as[i].charAt(0), 16) << 4) + Character.digit(as[i].charAt(1), 16));
        }

        break MISSING_BLOCK_LABEL_201;
_L2:
        if (!mac.matches("^[0-9a-fA-F]{12}$"))
        {
            break; /* Loop/switch isn't completed */
        }
        abyte0 = new String[6];
        int k = 0;
        int j = 0;
        do
        {
            as = abyte0;
            if (k >= 6)
            {
                break;
            }
            abyte0[k] = mac.substring(j, j + 2);
            k++;
            j += 2;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        log.w(new Object[] {
            (new StringBuilder()).append("MAC incorrect or has strange formatting: ").append(mac).append(", cannot extract data for hashes").toString()
        });
        mac = "00:00:00:00:00:00";
        macSHA1 = "";
        macMD5 = "";
        return;
        macSHA1 = CvHash.SHA1(abyte0);
        macMD5 = CvHash.MD5(abyte0);
        return;
    }

    private void determineAdvIdent()
    {
        log.e(new Object[] {
            "DETERMINING ADVIDENT!"
        });
        (new Thread(new _cls1())).start();
    }

    private void findCarrier(Context context)
    {
        Object obj = (TelephonyManager)context.getSystemService("phone");
        context = null;
        if (obj != null)
        {
            context = ((TelephonyManager) (obj)).getNetworkOperatorName();
        }
        obj = context;
        if (context == null)
        {
            obj = "";
        }
        carrier = ((String) (obj));
    }

    static CvAppInfo getInstance()
    {
        return instance;
    }

    static void initialize(Context context)
    {
        if (instance != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        com/apprupt/sdk/CvAppInfo;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new CvAppInfo(context);
        }
        com/apprupt/sdk/CvAppInfo;
        JVM INSTR monitorexit ;
        return;
        context;
        com/apprupt/sdk/CvAppInfo;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void obtainMacAddress(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != -1)
        {
            context = (WifiManager)context.getSystemService("wifi");
            if (context != null)
            {
                context = context.getConnectionInfo();
                if (context != null)
                {
                    mac = context.getMacAddress();
                    log.v(new Object[] {
                        (new StringBuilder()).append("Got mac address: ").append(mac).append(" (").append(context.getMacAddress()).append(")").toString()
                    });
                } else
                {
                    log.e(new Object[] {
                        "Cannot get connection info"
                    });
                }
            } else
            {
                log.e(new Object[] {
                    "Cannot get WifiManager"
                });
            }
        } else
        {
            log.e(new Object[] {
                "ACCESS_WIFI_STATE permission is missing"
            });
        }
        if (mac == null || mac.length() == 0)
        {
            mac = readMacFromFile(String.format("et%s", new Object[] {
                String.format("h%d", new Object[] {
                    Integer.valueOf(0)
                })
            }));
        }
        if (mac == null || mac.length() == 0)
        {
            mac = readMacFromFile(String.format("et%s", new Object[] {
                String.format("h%d", new Object[] {
                    Integer.valueOf(1)
                })
            }));
        }
        if (mac == null || mac.length() == 0)
        {
            mac = "00:00:00:00:00:00";
            macMD5 = "";
            macSHA1 = "";
            Logger.get().w(new Object[] {
                "WiFi interface MAC address unavailable."
            });
            return;
        } else
        {
            createMACHashes();
            log.v(new Object[] {
                (new StringBuilder()).append("MAC: ").append(mac).toString()
            });
            return;
        }
    }

    private void obtainTelephonyIds(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != -1)
        {
            context = (TelephonyManager)context.getSystemService("phone");
            imei = context.getDeviceId();
            simCardSerial = context.getSimSerialNumber();
            log.v(new Object[] {
                (new StringBuilder()).append("IMEI: ").append(imei).toString()
            });
            log.v(new Object[] {
                (new StringBuilder()).append("SIM card serial number: ").append(simCardSerial).toString()
            });
            return;
        } else
        {
            imei = "";
            simCardSerial = "";
            return;
        }
    }

    private void obtainUdid(Context context)
    {
        String s;
        String s1;
        int i;
        s = null;
        i = 0;
        s1 = "";
_L7:
        if (s != null && s.length() != 0 && !s.equals("9774d56d682e549c")) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 0 2: default 56
    //                   0 138
    //                   1 162
    //                   2 189;
           goto _L3 _L4 _L5 _L6
_L3:
        udidSHA1 = "";
        udidMD5 = "";
        udid = "";
        log.e(new Object[] {
            (new StringBuilder()).append("ANDROID_ID unavailable or invalid: ").append(android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id")).toString()
        });
        Logger.get().w(new Object[] {
            "ANDROID_ID unavailable or invalid."
        });
        return;
_L4:
        s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        s1 = "Secure.ANDROID_ID";
_L8:
        i++;
          goto _L7
_L5:
        Object obj = (String)android/os/Build.getField("SERIAL").get(null);
        s1 = "Build.SERIAL";
        s = ((String) (obj));
          goto _L8
_L6:
        obj = Class.forName("android.os.SystemProperties");
        obj = (String)((Class) (obj)).getMethod("get", new Class[] {
            java/lang/String
        }).invoke(obj, new Object[] {
            "ro.serialno"
        });
        s1 = "SystemProperties.ro.serialno";
        s = ((String) (obj));
          goto _L8
_L2:
        log.v(new Object[] {
            (new StringBuilder()).append("UDID from ").append(s1).append(": ").append(s).toString()
        });
        udid = s;
        udidMD5 = CvHash.MD5(udid);
        udidSHA1 = CvHash.SHA1(udid);
        return;
        Exception exception;
        exception;
          goto _L8
        exception;
          goto _L8
    }

    private String readMacFromFile(String s)
    {
        Object obj;
        String s2;
        Object obj1;
        Object obj2;
        obj = new ArrayList();
        ((List) (obj)).add(String.format("s%s", new Object[] {
            "ys"
        }));
        ((List) (obj)).add(String.format("c%sss", new Object[] {
            "la"
        }));
        ((List) (obj)).add(String.format("n%st", new Object[] {
            "e"
        }));
        ((List) (obj)).add(s);
        ((List) (obj)).add(String.format("ad%sss", new Object[] {
            "dre"
        }));
        s = new StringBuilder();
        String s1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); s.append(s1))
        {
            s1 = (String)((Iterator) (obj)).next();
            s.append("/");
        }

        obj2 = String.format("%s", new Object[] {
            s.toString()
        });
        obj1 = null;
        s2 = null;
        s = s2;
        obj = obj1;
        obj2 = new FileInputStream(new File(((String) (obj2))));
        s = s2;
        obj = obj1;
        s2 = stream2string(((InputStream) (obj2))).trim();
        s = s2;
        obj = s2;
        ((FileInputStream) (obj2)).close();
        s = s2;
_L2:
        log.e(new Object[] {
            (new StringBuilder()).append("DATA: ").append(s).toString()
        });
        return s;
        obj;
        log.e(new Object[] {
            "Error while reading mac from file", obj
        });
        continue; /* Loop/switch isn't completed */
        s;
        log.e(new Object[] {
            (new StringBuilder()).append("Error while reading mac from file (").append(s.getClass().getName()).append(")").toString(), s
        });
        s = ((String) (obj));
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void setupScreenValues()
    {
        DisplayMetrics displaymetrics = mContext.getResources().getDisplayMetrics();
        pixelRatio = displaymetrics.density;
        screenWidth = (int)((float)displaymetrics.widthPixels / pixelRatio);
        screenHeight = (int)((float)displaymetrics.heightPixels / pixelRatio);
    }

    private String stream2string(InputStream inputstream)
        throws IOException
    {
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        StringBuilder stringbuilder = new StringBuilder();
        do
        {
            String s = inputstream.readLine();
            if (s != null)
            {
                stringbuilder.append(s).append("\n");
            } else
            {
                return stringbuilder.toString();
            }
        } while (true);
    }

    Connectivity connectivity()
    {
        return new Connectivity(mContext);
    }

    String getAndroidMD5Hash()
    {
        return ahMD5;
    }

    String getAndroidSHA1Hash()
    {
        return ahSHA1;
    }

    String getAppId()
    {
        return appId;
    }

    String getAppName()
    {
        return appName;
    }

    String getBSSID()
    {
        if (mContext.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != -1)
        {
            Object obj = (WifiManager)mContext.getSystemService("wifi");
            if (obj != null)
            {
                obj = ((WifiManager) (obj)).getConnectionInfo();
                if (obj != null)
                {
                    obj = ((WifiInfo) (obj)).getBSSID();
                    if (obj != null)
                    {
                        return ((String) (obj));
                    }
                    log.w(new Object[] {
                        "BSSID is null"
                    });
                } else
                {
                    log.e(new Object[] {
                        "Cannot get connection info"
                    });
                }
            } else
            {
                log.e(new Object[] {
                    "Cannot get WifiManager"
                });
            }
        } else
        {
            log.e(new Object[] {
                "ACCESS_WIFI_STATE permission is missing"
            });
        }
        return "";
    }

    String getCarrier()
    {
        return carrier;
    }

    String getCountryCode()
    {
        return Locale.getDefault().getCountry();
    }

    float getDensity()
    {
        return pixelRatio;
    }

    String getDeviceInfo()
    {
        String s = "";
        if (!isTablet()) goto _L2; else goto _L1
_L1:
        s = "Android Tablet";
_L4:
        return String.format("%s;%s;%s", new Object[] {
            s, getUnitModel(), getUnitFirmware()
        });
_L2:
        if (isPhone())
        {
            s = "Android Phone";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    String getIMEI()
    {
        return imei;
    }

    String getLanguageCode()
    {
        return Locale.getDefault().getLanguage();
    }

    String getLocaleId()
    {
        return Locale.getDefault().toString();
    }

    String getMacMD5()
    {
        return macMD5;
    }

    String getMacSHA1()
    {
        return macSHA1;
    }

    String getScreenInfo()
    {
        return String.format("%dx%d;24;%.2f", new Object[] {
            Integer.valueOf(screenWidth), Integer.valueOf(screenHeight), Float.valueOf(pixelRatio)
        });
    }

    String getSimCardSerial()
    {
        return simCardSerial;
    }

    String getUdidMD5()
    {
        return udidMD5;
    }

    String getUdidSHA1()
    {
        return udidSHA1;
    }

    String getUid()
    {
        return buildUid();
    }

    String getUnitFirmware()
    {
        return String.format("Android %s", new Object[] {
            android.os.Build.VERSION.RELEASE
        });
    }

    String getUnitKind()
    {
        return String.format("%s %s", new Object[] {
            Build.MANUFACTURER, Build.DEVICE
        });
    }

    String getUnitModel()
    {
        return Build.MODEL;
    }

    String getUserAgent()
    {
        log.e(new Object[] {
            (new StringBuilder()).append("Returning userAgent ").append(userAgent).toString()
        });
        return userAgent;
    }

    boolean isPhone()
    {
        return ((TelephonyManager)mContext.getSystemService("phone")).getPhoneType() != 0;
    }

    boolean isTablet()
    {
        return (mContext.getResources().getConfiguration().screenLayout & 0xf) >= 3;
    }

    boolean optedOut()
    {
        return optOut;
    }




/*
    static String access$102(CvAppInfo cvappinfo, String s)
    {
        cvappinfo.advIdent = s;
        return s;
    }

*/


/*
    static boolean access$202(CvAppInfo cvappinfo, boolean flag)
    {
        cvappinfo.optOut = flag;
        return flag;
    }

*/



/*
    static String access$402(CvAppInfo cvappinfo, String s)
    {
        cvappinfo.advIdentMD5 = s;
        return s;
    }

*/


/*
    static String access$502(CvAppInfo cvappinfo, String s)
    {
        cvappinfo.advIdentSHA1 = s;
        return s;
    }

*/


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
