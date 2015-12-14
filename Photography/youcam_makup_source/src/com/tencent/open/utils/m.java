// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.open.a.k;
import com.tencent.open.b.a;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.open.utils:
//            c, i

public class m
{

    private static final String a = (new StringBuilder()).append("openSDK_LOG.").append(com/tencent/open/utils/m.getName()).toString();
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static int f = -1;
    private static String g;
    private static boolean h = true;
    private static String i = "0123456789ABCDEF";

    public m()
    {
    }

    public static Bundle a(String s)
    {
        Object obj;
        Bundle bundle;
        int j;
        j = 0;
        bundle = new Bundle();
        obj = bundle;
        if (s == null) goto _L2; else goto _L1
_L1:
        int l;
        s = s.split("&");
        l = s.length;
_L3:
        obj = bundle;
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s[j].split("=");
        if (obj.length == 2)
        {
            bundle.putString(URLDecoder.decode(obj[0]), URLDecoder.decode(obj[1]));
        }
        j++;
        if (true) goto _L3; else goto _L2
        s;
        obj = null;
_L2:
        return ((Bundle) (obj));
    }

    public static Bundle a(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8)
    {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", s);
        bundle.putString("code", s1);
        bundle.putString("tmcost", s2);
        bundle.putString("rate", s3);
        bundle.putString("cmd", s4);
        bundle.putString("uin", s5);
        bundle.putString("appid", s6);
        bundle.putString("share_type", s7);
        bundle.putString("detail", s8);
        bundle.putString("os_ver", android.os.Build.VERSION.RELEASE);
        bundle.putString("network", com.tencent.open.b.a.a(com.tencent.open.utils.c.a()));
        bundle.putString("apn", com.tencent.open.b.a.b(com.tencent.open.utils.c.a()));
        bundle.putString("model_name", Build.MODEL);
        bundle.putString("sdk_ver", "2.9.1.lite");
        bundle.putString("packagename", com.tencent.open.utils.c.b());
        bundle.putString("app_ver", d(com.tencent.open.utils.c.a(), com.tencent.open.utils.c.b()));
        return bundle;
    }

    public static Bundle a(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8, String s9, String s10, String s11)
    {
        Bundle bundle = new Bundle();
        bundle.putString("openid", s);
        bundle.putString("report_type", s1);
        bundle.putString("act_type", s2);
        bundle.putString("via", s3);
        bundle.putString("app_id", s4);
        bundle.putString("result", s5);
        bundle.putString("type", s6);
        bundle.putString("login_status", s7);
        bundle.putString("need_user_auth", s8);
        bundle.putString("to_uin", s9);
        bundle.putString("call_source", s10);
        bundle.putString("to_type", s11);
        return bundle;
    }

    public static String a()
    {
        Object obj = NetworkInterface.getNetworkInterfaces();
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        Enumeration enumeration;
        if (!((Enumeration) (obj)).hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_76;
        }
        enumeration = ((NetworkInterface)((Enumeration) (obj)).nextElement()).getInetAddresses();
_L4:
        if (!enumeration.hasMoreElements()) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = (InetAddress)enumeration.nextElement();
        if (inetaddress.isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        obj = inetaddress.getHostAddress().toString();
        return ((String) (obj));
        SocketException socketexception;
        socketexception;
        a("Tencent-Util", socketexception.toString());
        return "";
    }

    public static String a(Bundle bundle)
    {
        if (bundle == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = bundle.keySet().iterator();
        boolean flag = true;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            Object obj1 = bundle.get(((String) (obj)));
            if ((obj1 instanceof String) || (obj1 instanceof String[]))
            {
                if (obj1 instanceof String[])
                {
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        stringbuilder.append("&");
                    }
                    stringbuilder.append((new StringBuilder()).append(URLEncoder.encode(((String) (obj)))).append("=").toString());
                    obj = bundle.getStringArray(((String) (obj)));
                    if (obj != null)
                    {
                        int j = 0;
                        while (j < obj.length) 
                        {
                            if (j == 0)
                            {
                                stringbuilder.append(URLEncoder.encode(obj[j]));
                            } else
                            {
                                stringbuilder.append(URLEncoder.encode((new StringBuilder()).append(",").append(obj[j]).toString()));
                            }
                            j++;
                        }
                    }
                } else
                {
                    if (flag)
                    {
                        flag = false;
                    } else
                    {
                        stringbuilder.append("&");
                    }
                    stringbuilder.append((new StringBuilder()).append(URLEncoder.encode(((String) (obj)))).append("=").append(URLEncoder.encode(bundle.getString(((String) (obj))))).toString());
                }
            }
        } while (true);
        return stringbuilder.toString();
    }

    public static String a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        for (int j = 0; j < abyte0.length; j++)
        {
            String s1 = Integer.toString(abyte0[j] & 0xff, 16);
            String s = s1;
            if (s1.length() == 1)
            {
                s = (new StringBuilder()).append("0").append(s1).toString();
            }
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static JSONObject a(JSONObject jsonobject, String s)
    {
        JSONObject jsonobject1 = jsonobject;
        if (jsonobject == null)
        {
            jsonobject1 = new JSONObject();
        }
        if (s != null)
        {
            jsonobject = s.split("&");
            int l = jsonobject.length;
            int j = 0;
            while (j < l) 
            {
                s = jsonobject[j].split("=");
                if (s.length == 2)
                {
                    try
                    {
                        jsonobject1.put(URLDecoder.decode(s[0]), URLDecoder.decode(s[1]));
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        k.e(a, (new StringBuilder()).append("decodeUrlToJson has exception: ").append(s.getMessage()).toString());
                    }
                }
                j++;
            }
        }
        return jsonobject1;
    }

    private static void a(Context context, String s, String s1, String s2)
    {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(s, s1));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(0x40000000);
        intent.addFlags(0x10000000);
        intent.setData(Uri.parse(s2));
        context.startActivity(intent);
    }

    public static void a(String s, String s1)
    {
        if (h)
        {
            k.b(s, s1);
        }
    }

    public static boolean a(Context context)
    {
        boolean flag1;
        flag1 = false;
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context != null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        context = context.getAllNetworkInfo();
        flag = flag1;
        if (context == null)
        {
            continue;
        }
        int j = 0;
        do
        {
            flag = flag1;
            if (j >= context.length)
            {
                continue;
            }
            if (context[j].isConnectedOrConnecting())
            {
                return true;
            }
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean a(Context context, String s)
    {
        boolean flag = c(context);
        if (!flag) goto _L2; else goto _L1
_L1:
        a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", s);
          goto _L3
_L2:
        a(context, "com.android.browser", "com.android.browser.BrowserActivity", s);
          goto _L3
        Exception exception;
        exception;
_L4:
        if (flag)
        {
            try
            {
                a(context, "com.android.browser", "com.android.browser.BrowserActivity", s);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                try
                {
                    a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", s);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    try
                    {
                        a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", s);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        return false;
                    }
                }
            }
        } else
        {
            try
            {
                a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", s);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                try
                {
                    a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", s);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return false;
                }
            }
        }
        break; /* Loop/switch isn't completed */
        exception;
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        return true;
    }

    public static Bundle b(String s)
    {
        s = s.replace("auth://", "http://");
        Bundle bundle;
        try
        {
            s = new URL(s);
            bundle = a(s.getQuery());
            bundle.putAll(a(s.getRef()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new Bundle();
        }
        return bundle;
    }

    public static String b(Context context)
    {
        if (context == null)
        {
            return "";
        }
        Object obj;
        context = (LocationManager)context.getSystemService("location");
        obj = new Criteria();
        ((Criteria) (obj)).setCostAllowed(false);
        ((Criteria) (obj)).setAccuracy(2);
        obj = context.getBestProvider(((Criteria) (obj)), true);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        context = context.getLastKnownLocation(((String) (obj)));
        if (context == null)
        {
            return "";
        }
        double d1 = context.getLatitude();
        double d2 = context.getLongitude();
        g = (new StringBuilder()).append(d1).append("*").append(d2).toString();
        context = g;
        return context;
        context;
        k.b("getLocation", "getLocation>>>", context);
        return "";
    }

    public static void b(Context context, String s)
    {
        if (context == null)
        {
            return;
        }
        try
        {
            context = context.getPackageManager().getPackageInfo(s, 0);
            c = ((PackageInfo) (context)).versionName;
            b = c.substring(0, c.lastIndexOf('.'));
            e = c.substring(c.lastIndexOf('.') + 1, c.length());
            f = ((PackageInfo) (context)).versionCode;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            k.e(a, (new StringBuilder()).append("getPackageInfo has exception: ").append(context.getMessage()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            k.e(a, (new StringBuilder()).append("getPackageInfo has exception: ").append(context.getMessage()).toString());
        }
    }

    public static String c(Context context, String s)
    {
        if (context == null)
        {
            return "";
        } else
        {
            b(context, s);
            return c;
        }
    }

    public static JSONObject c(String s)
    {
        s = s.replace("auth://", "http://");
        JSONObject jsonobject;
        try
        {
            s = new URL(s);
            jsonobject = a(((JSONObject) (null)), s.getQuery());
            a(jsonobject, s.getRef());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new JSONObject();
        }
        return jsonobject;
    }

    private static boolean c(Context context)
    {
        boolean flag1 = false;
        String s;
        Signature asignature[];
        boolean flag;
        boolean flag2;
        try
        {
            context = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            s = ((PackageInfo) (context)).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        flag = flag1;
        if (com.tencent.open.utils.i.a(s, "4.3") < 0)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        flag = flag1;
        if (s.startsWith("4.4"))
        {
            break MISSING_BLOCK_LABEL_102;
        }
        asignature = ((PackageInfo) (context)).signatures;
        flag = flag1;
        if (asignature == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        context = MessageDigest.getInstance("MD5");
        context.update(asignature[0].toByteArray());
        asignature = a(context.digest());
        context.reset();
        flag2 = asignature.equals("d8391a394d4a179e6fe7bdb8a301258b");
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
        return flag;
        context;
        k.e(a, (new StringBuilder()).append("isQQBrowerAvailable has exception: ").append(context.getMessage()).toString());
        return false;
    }

    public static String d(Context context, String s)
    {
        if (context == null)
        {
            return "";
        } else
        {
            b(context, s);
            return b;
        }
    }

    public static JSONObject d(String s)
    {
        String s1 = s;
        if (s.equals("false"))
        {
            s1 = "{value : false}";
        }
        s = s1;
        if (s1.equals("true"))
        {
            s = "{value : true}";
        }
        s1 = s;
        if (s.contains("allback("))
        {
            s1 = s.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        s = s1;
        if (s1.contains("online[0]="))
        {
            s = (new StringBuilder()).append("{online:").append(s1.charAt(s1.length() - 2)).append("}").toString();
        }
        return new JSONObject(s);
    }

    public static String e(Context context, String s)
    {
        if (context == null)
        {
            return "";
        } else
        {
            d = d(context, s);
            return d;
        }
    }

    public static byte[] e(String s)
    {
        try
        {
            s = s.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

}
