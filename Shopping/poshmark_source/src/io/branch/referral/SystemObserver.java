// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.jar.JarFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ApkParser, PrefHelper

class SystemObserver
{

    public static final String BLANK = "bnc_no_value";
    private static final int STATE_FRESH_INSTALL = 0;
    private static final int STATE_NO_CHANGE = 1;
    private static final int STATE_UPDATE = 2;
    private Context context_;
    private boolean isRealHardwareId;

    public SystemObserver(Context context)
    {
        context_ = context;
        isRealHardwareId = true;
    }

    private boolean isLowOnMemory()
    {
        ActivityManager activitymanager = (ActivityManager)context_.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        activitymanager.getMemoryInfo(memoryinfo);
        return memoryinfo.lowMemory;
    }

    public String getAdvertisingId()
    {
        Object obj;
        try
        {
            obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                context_
            });
            obj = (String)obj.getClass().getMethod("getId", new Class[0]).invoke(obj, new Object[0]);
        }
        catch (IllegalStateException illegalstateexception)
        {
            illegalstateexception.printStackTrace();
            return null;
        }
        catch (Exception exception)
        {
            return null;
        }
        return ((String) (obj));
    }

    public String getAppVersion()
    {
        try
        {
            PackageInfo packageinfo = context_.getPackageManager().getPackageInfo(context_.getPackageName(), 0);
            if (packageinfo.versionName != null)
            {
                return packageinfo.versionName;
            }
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return "bnc_no_value";
        }
        return "bnc_no_value";
    }

    public boolean getBluetoothPresent()
    {
        BluetoothAdapter bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothadapter == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        boolean flag = bluetoothadapter.isEnabled();
        return flag;
        SecurityException securityexception;
        securityexception;
        return false;
    }

    public String getBluetoothVersion()
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            if (android.os.Build.VERSION.SDK_INT >= 18 && context_.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))
            {
                return "ble";
            }
            if (context_.getPackageManager().hasSystemFeature("android.hardware.bluetooth"))
            {
                return "classic";
            }
        }
        return "bnc_no_value";
    }

    public String getCarrier()
    {
        Object obj = (TelephonyManager)context_.getSystemService("phone");
        if (obj != null)
        {
            obj = ((TelephonyManager) (obj)).getNetworkOperatorName();
            if (obj != null)
            {
                return ((String) (obj));
            }
        }
        return "bnc_no_value";
    }

    public int getLATValue()
    {
        boolean flag;
        try
        {
            Object obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                context_
            });
            flag = ((Boolean)obj.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        }
        catch (IllegalStateException illegalstateexception)
        {
            illegalstateexception.printStackTrace();
            return 0;
        }
        catch (Exception exception)
        {
            return 0;
        }
        return !flag ? 0 : 1;
    }

    public JSONArray getListOfApps()
    {
        Object obj;
        JSONArray jsonarray;
        PackageManager packagemanager;
        jsonarray = new JSONArray();
        packagemanager = context_.getPackageManager();
        obj = packagemanager.getInstalledApplications(128);
        if (obj == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = ((List) (obj)).iterator();
_L8:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        JSONObject jsonobject;
        ApplicationInfo applicationinfo;
        applicationinfo = (ApplicationInfo)iterator.next();
        if ((applicationinfo.flags & 1) == 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        jsonobject = new JSONObject();
        obj = applicationinfo.loadLabel(packagemanager);
        if (obj != null) goto _L5; else goto _L4
_L4:
        obj = null;
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        jsonobject.put("name", obj);
        obj = applicationinfo.packageName;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        jsonobject.put(Defines.Jsonkey.AppIdentifier.getKey(), obj);
        obj = getURIScheme(((String) (obj)));
        if (!((String) (obj)).equals("bnc_no_value"))
        {
            jsonobject.put(Defines.Jsonkey.URIScheme.getKey(), obj);
        }
        obj = applicationinfo.publicSourceDir;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        jsonobject.put("public_source_dir", obj);
        obj = applicationinfo.sourceDir;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        jsonobject.put("source_dir", obj);
        obj = packagemanager.getPackageInfo(applicationinfo.packageName, 4096);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        if (((PackageInfo) (obj)).versionCode >= 9)
        {
            jsonobject.put("install_date", ((PackageInfo) (obj)).firstInstallTime);
            jsonobject.put("last_update_date", ((PackageInfo) (obj)).lastUpdateTime);
        }
        jsonobject.put("version_code", ((PackageInfo) (obj)).versionCode);
        if (((PackageInfo) (obj)).versionName != null)
        {
            jsonobject.put("version_name", ((PackageInfo) (obj)).versionName);
        }
        jsonobject.put(Defines.Jsonkey.OS.getKey(), getOS());
        jsonarray.put(jsonobject);
        continue; /* Loop/switch isn't completed */
_L5:
        obj = ((CharSequence) (obj)).toString();
        if (true) goto _L6; else goto _L2
_L2:
        return jsonarray;
        Object obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean getNFCPresent()
    {
        boolean flag;
        try
        {
            flag = context_.getPackageManager().hasSystemFeature("android.hardware.nfc");
        }
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }

    public String getOS()
    {
        return "Android";
    }

    public int getOSVersion()
    {
        return android.os.Build.VERSION.SDK_INT;
    }

    public String getPhoneBrand()
    {
        return Build.MANUFACTURER;
    }

    public String getPhoneModel()
    {
        return Build.MODEL;
    }

    public DisplayMetrics getScreenDisplay()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context_.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

    public boolean getTelephonePresent()
    {
        boolean flag;
        try
        {
            flag = context_.getPackageManager().hasSystemFeature("android.hardware.telephony");
        }
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }

    public String getURIScheme()
    {
        return getURIScheme(context_.getPackageName());
    }

    public String getURIScheme(String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        String s1 = "bnc_no_value";
        obj = s1;
        if (isLowOnMemory())
        {
            break MISSING_BLOCK_LABEL_178;
        }
        obj = context_.getPackageManager();
        obj1 = s1;
        InputStream inputstream;
        byte abyte0[];
        String s2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        try
        {
            s = ((PackageManager) (obj)).getApplicationInfo(s, 0).publicSourceDir;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return ((String) (obj1));
        }
        obj4 = null;
        obj2 = null;
        obj3 = null;
        obj1 = null;
        obj = null;
        obj6 = null;
        obj5 = null;
        abyte0 = null;
        inputstream = null;
        s = new JarFile(s);
        obj = obj6;
        obj1 = obj5;
        inputstream = abyte0;
        obj2 = s.getInputStream(s.getEntry("AndroidManifest.xml"));
        obj = obj2;
        obj1 = obj2;
        inputstream = ((InputStream) (obj2));
        abyte0 = new byte[((InputStream) (obj2)).available()];
        obj = obj2;
        obj1 = obj2;
        inputstream = ((InputStream) (obj2));
        ((InputStream) (obj2)).read(abyte0);
        obj = obj2;
        obj1 = obj2;
        inputstream = ((InputStream) (obj2));
        s2 = (new ApkParser()).decompressXML(abyte0);
        obj = s2;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        obj1 = obj;
        ((InputStream) (obj2)).close();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        obj1 = obj;
        s.close();
_L2:
        return ((String) (obj));
        s;
        return ((String) (obj));
        s;
        s = obj3;
_L9:
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        obj1 = s1;
        inputstream.close();
        obj = s1;
        if (s == null) goto _L2; else goto _L1
_L1:
        obj1 = s1;
        s.close();
        return "bnc_no_value";
        s;
        s = obj4;
        obj = obj1;
_L8:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        obj1 = s1;
        ((InputStream) (obj)).close();
        obj = s1;
        if (s == null) goto _L2; else goto _L3
_L3:
        obj1 = s1;
        s.close();
        return "bnc_no_value";
        s;
_L7:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        obj1 = s1;
        ((InputStream) (obj)).close();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        obj1 = s1;
        ((JarFile) (obj2)).close();
_L5:
        obj1 = s1;
        throw s;
        obj;
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
        obj2 = s;
        s = ((String) (obj1));
        if (true) goto _L7; else goto _L6
_L6:
        s;
        return "bnc_no_value";
        obj;
        obj = obj1;
          goto _L8
        s;
        return "bnc_no_value";
        obj;
          goto _L9
        return ((String) (obj));
    }

    public String getUniqueID(boolean flag)
    {
        if (context_ != null)
        {
            String s = null;
            if (!flag)
            {
                s = android.provider.Settings.Secure.getString(context_.getContentResolver(), "android_id");
            }
            String s1 = s;
            if (s == null)
            {
                s1 = UUID.randomUUID().toString();
                isRealHardwareId = false;
            }
            return s1;
        } else
        {
            return "bnc_no_value";
        }
    }

    public int getUpdateState(boolean flag)
    {
        Object obj;
        String s;
        obj = PrefHelper.getInstance(context_);
        s = getAppVersion();
        if (!"bnc_no_value".equals(((PrefHelper) (obj)).getAppVersion())) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            ((PrefHelper) (obj)).setAppVersion(s);
        }
        if (android.os.Build.VERSION.SDK_INT < 9) goto _L4; else goto _L3
_L3:
        long l;
        long l1;
        obj = context_.getPackageManager().getPackageInfo(context_.getPackageName(), 0);
        l = ((PackageInfo) (obj)).lastUpdateTime;
        l1 = ((PackageInfo) (obj)).firstInstallTime;
        if (l == l1) goto _L6; else goto _L5
_L5:
        return 2;
_L6:
        return 0;
        obj;
_L4:
        return 0;
_L2:
        if (!((PrefHelper) (obj)).getAppVersion().equals(s))
        {
            if (flag)
            {
                ((PrefHelper) (obj)).setAppVersion(s);
                return 2;
            }
        } else
        {
            return 1;
        }
        if (true) goto _L5; else goto _L7
_L7:
    }

    public boolean getWifiConnected()
    {
        if (context_.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
        {
            return ((ConnectivityManager)context_.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
        } else
        {
            return false;
        }
    }

    public boolean hasRealHardwareId()
    {
        return isRealHardwareId;
    }

    public boolean isSimulator()
    {
        return Build.FINGERPRINT.contains("generic");
    }
}
