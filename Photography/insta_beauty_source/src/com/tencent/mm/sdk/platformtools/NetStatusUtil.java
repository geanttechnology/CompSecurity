// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

public class NetStatusUtil
{

    public static final int CMNET = 6;
    public static final int CMWAP = 5;
    public static final int CTNET = 8;
    public static final int CTWAP = 7;
    public static final int LTE = 10;
    public static final int MOBILE = 9;
    public static final int NET_3G = 4;
    public static final int NON_NETWORK = -1;
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
    public static final int TBACKGROUND_DATA_LIMITED = 2;
    public static final int TBACKGROUND_NOT_LIMITED = 0;
    public static final int TBACKGROUND_PROCESS_LIMITED = 1;
    public static final int TBACKGROUND_WIFI_LIMITED = 3;
    public static final int UNINET = 1;
    public static final int UNIWAP = 2;
    public static final int WAP_3G = 3;
    public static final int WIFI = 0;

    public NetStatusUtil()
    {
    }

    private static Intent a(Context context, String s)
    {
        PackageManager packagemanager;
        List list;
        packagemanager = context.getPackageManager();
        list = packagemanager.getInstalledPackages(0);
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        if (list.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("package  size")).append(list.size()).toString());
        int i = 0;
_L5:
        int j = list.size();
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        Object obj;
        Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("package ")).append(((PackageInfo)list.get(i)).packageName).toString());
        Intent intent = new Intent();
        intent.setPackage(((PackageInfo)list.get(i)).packageName);
        obj = packagemanager.queryIntentActivities(intent, 0);
        if (obj == null) goto _L2; else goto _L1
_L1:
        j = ((List) (obj)).size();
_L3:
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("activityName count ")).append(j).toString());
        int k = 0;
_L4:
        if (k >= j)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        ActivityInfo activityinfo = ((ResolveInfo)((List) (obj)).get(k)).activityInfo;
        if (!activityinfo.name.contains(s))
        {
            break MISSING_BLOCK_LABEL_277;
        }
        obj = new Intent("/");
        ((Intent) (obj)).setComponent(new ComponentName(activityinfo.packageName, activityinfo.name));
        ((Intent) (obj)).setAction("android.intent.action.VIEW");
        context.startActivity(((Intent) (obj)));
        return ((Intent) (obj));
_L2:
        j = 0;
          goto _L3
        k++;
          goto _L4
        Exception exception;
        exception;
        exception.printStackTrace();
_L6:
        i++;
          goto _L5
        exception;
        exception.printStackTrace();
          goto _L6
        context;
        context.printStackTrace();
        return null;
    }

    public static boolean checkFromXml(int i)
    {
        NodeList nodelist;
        runRootCommand();
        nodelist = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(new File("/data/system/netpolicy.xml"))).getDocumentElement().getElementsByTagName("uid-policy");
        int j = 0;
_L2:
        Object obj;
        if (j >= nodelist.getLength())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Element)nodelist.item(j);
        String s = ((Element) (obj)).getAttribute("uid");
        obj = ((Element) (obj)).getAttribute("policy");
        Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("uid is ")).append(s).append("  policy is ").append(((String) (obj))).toString());
        if (!s.equals(Integer.toString(i)))
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (Integer.parseInt(((String) (obj))) == 1)
        {
            return true;
        }
        int k = Integer.parseInt(((String) (obj)));
        if (k == 0)
        {
            return false;
        }
        j++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
_L1:
        return false;
    }

    public static void dumpNetStatus(Context context)
    {
        try
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("isAvailable ")).append(context.isAvailable()).toString());
            Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("isConnected ")).append(context.isConnected()).toString());
            Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("isRoaming ")).append(context.isRoaming()).toString());
            Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("isFailover ")).append(context.isFailover()).toString());
            Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("getSubtypeName ")).append(context.getSubtypeName()).toString());
            Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("getExtraInfo ")).append(context.getExtraInfo()).toString());
            Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("activeNetInfo ")).append(context.toString()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static int getBackgroundLimitType(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        int i;
        Object obj = Class.forName("android.app.ActivityManagerNative");
        obj = ((Class) (obj)).getMethod("getDefault", new Class[0]).invoke(obj, new Object[0]);
        i = ((Integer)obj.getClass().getMethod("getProcessLimit", new Class[0]).invoke(obj, new Object[0])).intValue();
        if (i == 0)
        {
            return 1;
        }
        break MISSING_BLOCK_LABEL_75;
        Exception exception;
        exception;
        exception.printStackTrace();
        i = getWifiSleeepPolicy(context);
        if (i == 2)
        {
            return 0;
        }
        if (i == 1 || i == 0)
        {
            return 3;
        }
        break MISSING_BLOCK_LABEL_103;
        context;
        context.printStackTrace();
        return 0;
    }

    public static int getNetType(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return -1;
        }
        context = context.getActiveNetworkInfo();
        if (context == null)
        {
            return -1;
        }
        if (context.getType() == 1)
        {
            return 0;
        }
        Log.d("MicroMsg.NetStatusUtil", (new StringBuilder("activeNetInfo.getExtraInfo()  ")).append(context.getExtraInfo()).toString());
        Log.d("MicroMsg.NetStatusUtil", (new StringBuilder("activeNetInfo.getType()  ")).append(context.getType()).toString());
        if (context.getExtraInfo() != null)
        {
            if (context.getExtraInfo().equals("uninet"))
            {
                return 1;
            }
            if (context.getExtraInfo().equals("uniwap"))
            {
                return 2;
            }
            if (context.getExtraInfo().equals("3gwap"))
            {
                return 3;
            }
            if (context.getExtraInfo().equals("3gnet"))
            {
                return 4;
            }
            if (context.getExtraInfo().equals("cmwap"))
            {
                return 5;
            }
            if (context.getExtraInfo().equals("cmnet"))
            {
                return 6;
            }
            if (context.getExtraInfo().equals("ctwap"))
            {
                return 7;
            }
            if (context.getExtraInfo().equals("ctnet"))
            {
                return 8;
            }
            if (context.getExtraInfo().equals("LTE"))
            {
                return 10;
            }
        }
        return 9;
    }

    public static String getNetTypeString(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return "NON_NETWORK";
        }
        context = context.getActiveNetworkInfo();
        if (context == null)
        {
            return "NON_NETWORK";
        }
        if (context.getType() == 1)
        {
            return "WIFI";
        }
        Log.d("MicroMsg.NetStatusUtil", (new StringBuilder("activeNetInfo.getExtraInfo()  ")).append(context.getExtraInfo()).toString());
        Log.d("MicroMsg.NetStatusUtil", (new StringBuilder("activeNetInfo.getType()  ")).append(context.getType()).toString());
        if (context.getExtraInfo() != null)
        {
            return context.getExtraInfo();
        } else
        {
            return "MOBILE";
        }
    }

    public static int getWifiSleeepPolicy(Context context)
    {
        return android.provider.Settings.System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
    }

    public static boolean is2G(int i)
    {
        return i == 1 || i == 2 || i == 5 || i == 6 || i == 7 || i == 8;
    }

    public static boolean is2G(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context.getType() == 1)
        {
            return false;
        }
        int i;
        if (context.getSubtype() == 2)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        i = context.getSubtype();
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        return true;
        context;
        context.printStackTrace();
        return false;
    }

    public static boolean is3G(int i)
    {
        return i == 3 || i == 4;
    }

    public static boolean is3G(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context.getType() == 1)
        {
            return false;
        }
        int i;
        if (context.getSubtype() < 5)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        i = context.getSubtype();
        if (i < 13)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_49;
        context;
        context.printStackTrace();
        return false;
    }

    public static boolean is4G(int i)
    {
        return i == 10;
    }

    public static boolean is4G(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context.getType() == 1)
        {
            return false;
        }
        int i = context.getSubtype();
        if (i >= 13)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_41;
        context;
        context.printStackTrace();
        return false;
    }

    public static boolean isConnected(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean flag;
        try
        {
            flag = context.isConnected();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return flag;
    }

    public static boolean isImmediatelyDestroyActivities(Context context)
    {
        boolean flag = false;
        if (android.provider.Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isLimited(int i)
    {
        return i == 2 || i == 1 || i == 3;
    }

    public static boolean isMobile(int i)
    {
        return is3G(i) || is2G(i) || is4G(i);
    }

    public static boolean isMobile(Context context)
    {
        int i = getNetType(context);
        return is3G(i) || is2G(i) || is4G(i);
    }

    public static boolean isRestrictBacground(Context context)
    {
        int i = context.getApplicationInfo().uid;
        int j;
        Object obj = Class.forName("android.net.NetworkPolicyManager");
        context = ((Context) (((Class) (obj)).getMethod("getSystemService", new Class[] {
            android/content/Context
        }).invoke(obj, new Object[] {
            context
        })));
        obj = ((Class) (obj)).getDeclaredField("mService");
        ((Field) (obj)).setAccessible(true);
        context = ((Context) (((Field) (obj)).get(context)));
        j = ((Integer)context.getClass().getMethod("getUidPolicy", new Class[] {
            Integer.TYPE
        }).invoke(context, new Object[] {
            Integer.valueOf(i)
        })).intValue();
        Log.e("MicroMsg.NetStatusUtil", (new StringBuilder("policy is ")).append(j).toString());
        if (j == 1)
        {
            return true;
        }
        if (j == 0)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_145;
        context;
        context.printStackTrace();
        return checkFromXml(i);
    }

    public static boolean isWap(int i)
    {
        return i == 2 || i == 5 || i == 7 || i == 3;
    }

    public static boolean isWap(Context context)
    {
        return isWap(getNetType(context));
    }

    public static boolean isWifi(int i)
    {
        return i == 0;
    }

    public static boolean isWifi(Context context)
    {
        return isWifi(getNetType(context));
    }

    public static boolean runRootCommand()
    {
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        Object obj = Runtime.getRuntime().exec("su");
        Object obj4;
        try
        {
            obj1 = new DataOutputStream(((Process) (obj)).getOutputStream());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj4)
        {
            obj1 = null;
            obj2 = obj;
            obj = obj4;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj1 = null;
            obj2 = obj;
            obj = exception;
        }
        ((DataOutputStream) (obj1)).writeBytes("exit\n");
        ((DataOutputStream) (obj1)).flush();
        ((Process) (obj)).waitFor();
        ((DataOutputStream) (obj1)).close();
        if (obj != null)
        {
            try
            {
                ((Process) (obj)).destroy();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        return true;
        obj;
        obj1 = null;
_L4:
        Log.d("MicroMsg.NetStatusUtil", (new StringBuilder("the device is not rooted\uFF0C error message\uFF1A ")).append(((Exception) (obj)).getMessage()).toString());
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        ((DataOutputStream) (obj1)).close();
        if (obj2 != null)
        {
            try
            {
                ((Process) (obj2)).destroy();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        return false;
        obj;
        Object obj3 = null;
        obj2 = obj1;
        obj1 = obj3;
_L2:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        ((DataOutputStream) (obj1)).close();
        if (obj2 != null)
        {
            try
            {
                ((Process) (obj2)).destroy();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((Exception) (obj1)).printStackTrace();
            }
        }
        throw obj;
        obj4;
        obj2 = obj;
        obj = obj4;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj4;
        obj2 = obj;
        obj = obj4;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void startSettingItent(Context context, int i)
    {
        switch (i)
        {
        case 0: // '\0'
        default:
            return;

        case 2: // '\002'
            try
            {
                Intent intent = new Intent("/");
                intent.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
                intent.setAction("android.intent.action.VIEW");
                context.startActivity(intent);
                return;
            }
            catch (Exception exception) { }
            try
            {
                Intent intent1 = new Intent("/");
                intent1.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
                intent1.setAction("android.intent.action.VIEW");
                context.startActivity(intent1);
                return;
            }
            catch (Exception exception1)
            {
                a(context, "ManageAccountsSettings");
            }
            return;

        case 1: // '\001'
            try
            {
                Intent intent2 = new Intent("/");
                intent2.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
                intent2.setAction("android.intent.action.VIEW");
                context.startActivity(intent2);
                return;
            }
            catch (Exception exception2)
            {
                a(context, "DevelopmentSettings");
            }
            return;

        case 3: // '\003'
            break;
        }
        try
        {
            Intent intent3 = new Intent();
            intent3.setAction("android.settings.WIFI_IP_SETTINGS");
            context.startActivity(intent3);
            return;
        }
        catch (Exception exception3)
        {
            a(context, "AdvancedSettings");
        }
    }
}
