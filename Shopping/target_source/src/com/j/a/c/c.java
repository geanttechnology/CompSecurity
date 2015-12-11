// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.c;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.j.a.d.e;
import com.j.a.g.m;
import com.j.a.g.w;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.c:
//            b, e

public class c
{

    private final Context a;
    private final String b;
    private final String c;
    private final String d;
    private final Integer e;
    private final DisplayMetrics f;
    private HashMap g;

    public c(Context context)
    {
        Object obj;
        Object obj3;
        obj3 = null;
        super();
        g = null;
        a = context;
        obj = context.getPackageManager();
        Object obj1;
        PackageInfo packageinfo;
        packageinfo = ((PackageManager) (obj)).getPackageInfo(context.getPackageName(), 0);
        obj1 = ((PackageManager) (obj)).getApplicationInfo(context.getApplicationInfo().processName, 0);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj = (String)((PackageManager) (obj)).getApplicationLabel(((ApplicationInfo) (obj1)));
        obj1 = ((ApplicationInfo) (obj1)).processName;
_L10:
        if (packageinfo == null) goto _L4; else goto _L3
_L3:
        Object obj2 = packageinfo.versionName;
        int i = packageinfo.versionCode;
        Integer integer = Integer.valueOf(i);
        obj3 = obj2;
        obj2 = integer;
_L8:
        String s = ((String) (obj1));
        obj1 = obj;
        obj = s;
_L6:
        b();
        b = ((String) (obj1));
        d = ((String) (obj3));
        e = ((Integer) (obj2));
        c = ((String) (obj));
        f = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(f);
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        obj = null;
        obj1 = null;
        obj2 = null;
_L7:
        w.b((new StringBuilder()).append("System Context does not exist: ").append(namenotfoundexception.toString()).toString());
        namenotfoundexception = ((android.content.pm.PackageManager.NameNotFoundException) (obj2));
        obj2 = null;
        if (true) goto _L6; else goto _L5
_L5:
        namenotfoundexception;
        obj1 = obj;
        obj = null;
        obj2 = null;
          goto _L7
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1;
        namenotfoundexception1;
        namenotfoundexception = ((android.content.pm.PackageManager.NameNotFoundException) (obj));
        obj2 = null;
        obj = obj1;
        obj1 = namenotfoundexception;
        namenotfoundexception = namenotfoundexception1;
          goto _L7
        namenotfoundexception1;
        namenotfoundexception = ((android.content.pm.PackageManager.NameNotFoundException) (obj));
        obj = obj1;
        obj1 = namenotfoundexception;
        namenotfoundexception = namenotfoundexception1;
          goto _L7
_L4:
        obj2 = null;
        if (true) goto _L8; else goto _L2
_L2:
        obj1 = null;
        obj = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public Map a()
    {
        HashMap hashmap = new HashMap();
        Object obj1 = com.j.a.d.e.e();
        Object obj;
        if (((e) (obj1)).g())
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        hashmap.put("lv", obj);
        if (((e) (obj1)).f() != null)
        {
            hashmap.put("t", com.j.a.d.e.e().f());
        }
        if (b != null)
        {
            hashmap.put("an", b);
        }
        if (d != null)
        {
            hashmap.put("av", d);
        }
        if (e != null)
        {
            hashmap.put("ab", e);
        }
        if (c != null)
        {
            hashmap.put("ai", c);
        }
        hashmap.put("sdk", e.a.a());
        hashmap.put("os", "Android");
        if (android.os.Build.VERSION.RELEASE != null)
        {
            obj = android.os.Build.VERSION.RELEASE;
        } else
        {
            obj = "unknown";
        }
        hashmap.put("osv", obj);
        if (Build.MANUFACTURER == null)
        {
            obj = "UNKNOWN";
        } else
        {
            obj = Build.MANUFACTURER;
        }
        hashmap.put("ma", obj);
        if (Build.BRAND == null)
        {
            obj = "UNKNOWN";
        } else
        {
            obj = Build.BRAND;
        }
        hashmap.put("br", obj);
        if (Build.MODEL == null)
        {
            obj = "UNKNOWN";
        } else
        {
            obj = Build.MODEL;
        }
        hashmap.put("d", obj);
        hashmap.put("alg", Locale.getDefault().getLanguage());
        hashmap.put("alg3", Locale.getDefault().getISO3Language());
        hashmap.put("con", Locale.getDefault().getCountry());
        hashmap.put("con3", Locale.getDefault().getISO3Country());
        hashmap.put("sdpi", Integer.valueOf(f.densityDpi));
        hashmap.put("sh", Integer.valueOf(f.heightPixels));
        hashmap.put("sw", Integer.valueOf(f.widthPixels));
        hashmap.put("tz", TimeZone.getDefault().getDisplayName(false, 0));
        hashmap.put("tzs", Integer.valueOf(TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        hashmap.put("tzn", TimeZone.getDefault().getID());
        obj = g();
        if (obj != null)
        {
            hashmap.put("ca", obj);
        }
        obj = f();
        if (obj != null)
        {
            hashmap.put("rd", obj);
        }
        obj = d();
        if (obj != null)
        {
            hashmap.put("ad", ((Map) (obj)).get("id"));
            hashmap.put("adt", ((Map) (obj)).get("type"));
        }
        hashmap.put("n", h());
        obj1 = ((e) (obj1)).k();
        if (obj1 != null)
        {
            d d1 = ((com.j.a.c.e) (obj1)).c();
            obj = ((com.j.a.c.e) (obj1)).i();
            obj1 = ((com.j.a.c.e) (obj1)).b();
            if (d1 != null && d1.has("_id"))
            {
                try
                {
                    hashmap.put("pid", d1.getString("_id"));
                }
                catch (JSONException jsonexception1)
                {
                    w.b("Getting project_id", jsonexception1);
                }
            }
            if (obj != null && ((JSONObject) (obj)).has("_id"))
            {
                try
                {
                    hashmap.put("au", ((JSONObject) (obj)).getString("_id"));
                }
                catch (JSONException jsonexception)
                {
                    w.b("Getting appUser_id", jsonexception);
                }
            }
            if (obj1 != null)
            {
                hashmap.put("sid", obj1);
            }
        }
        return hashmap;
    }

    public void a(StringBuilder stringbuilder)
    {
        m.a(a(), stringbuilder);
    }

    public void b()
    {
        Object obj;
label0:
        {
            if (g == null && com.j.a.d.e.e().o() != null)
            {
                obj = com.j.a.d.e.e().o().getSharedPreferences("TAPLYTICS_PREFS", 0);
                if (obj != null)
                {
                    break label0;
                }
                g = c();
            }
            return;
        }
        String s = ((SharedPreferences) (obj)).getString("ID", null);
        obj = ((SharedPreferences) (obj)).getString("TYPE", null);
        HashMap hashmap = new HashMap();
        if (s == null || obj == null)
        {
            g = c();
            return;
        } else
        {
            hashmap.put("id", s);
            hashmap.put("type", obj);
            g = hashmap;
            return;
        }
    }

    public HashMap c()
    {
        Object obj2;
        HashMap hashmap;
        obj2 = null;
        if (g != null)
        {
            return g;
        }
        hashmap = new HashMap();
        if (!m.a(a, "android.permission.READ_PHONE_STATE")) goto _L2; else goto _L1
_L1:
        String s1 = ((TelephonyManager)a.getSystemService("phone")).getDeviceId();
        String s = "UUID";
_L13:
        Object obj;
        Object obj1;
        obj = s;
        obj1 = s1;
        if (s1 != null) goto _L4; else goto _L3
_L3:
        obj = s;
        obj1 = s1;
        if (android.os.Build.VERSION.SDK_INT < 9) goto _L4; else goto _L5
_L5:
        s1 = e();
        s = "anBuildSerial";
        obj = s;
        obj1 = s1;
        if (!s1.equalsIgnoreCase("unknown")) goto _L4; else goto _L6
_L6:
        obj = obj2;
        obj1 = s;
_L11:
        s = ((String) (obj1));
        obj1 = obj;
        if (obj == null)
        {
            try
            {
                obj1 = android.provider.Settings.Secure.getString(a.getContentResolver(), "android_id");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                w.a("Problem getting unique ID", ((Exception) (obj)));
                return hashmap;
            }
            s = "anAndroidID";
        }
        if (obj1 == null) goto _L8; else goto _L7
_L7:
        hashmap.put("id", obj1);
        hashmap.put("type", s);
        g = hashmap;
_L9:
        if (com.j.a.d.e.e().o() != null)
        {
            obj = com.j.a.d.e.e().o().getSharedPreferences("TAPLYTICS_PREFS", 0);
            ((SharedPreferences) (obj)).edit().putString("ID", ((String) (obj1))).apply();
            ((SharedPreferences) (obj)).edit().putString("TYPE", s).apply();
        }
        break; /* Loop/switch isn't completed */
_L8:
        hashmap.put("id", UUID.randomUUID().toString());
        hashmap.put("type", "UUID");
        g = hashmap;
        if (true) goto _L9; else goto _L4
_L4:
        s = ((String) (obj1));
        obj1 = obj;
        obj = s;
        if (true) goto _L11; else goto _L10
_L10:
        break; /* Loop/switch isn't completed */
_L2:
        s = null;
        s1 = null;
        if (true) goto _L13; else goto _L12
_L12:
        return hashmap;
    }

    public Map d()
    {
        if (g != null)
        {
            return g;
        } else
        {
            return c();
        }
    }

    public String e()
    {
        return Build.SERIAL;
    }

    public String f()
    {
        TelephonyManager telephonymanager = (TelephonyManager)a.getSystemService("phone");
        if (telephonymanager != null)
        {
            switch (telephonymanager.getPhoneType())
            {
            default:
                return null;

            case 0: // '\0'
                return "none";

            case 1: // '\001'
                return "gsm";

            case 2: // '\002'
                return "cdma";

            case 3: // '\003'
                return "sip";
            }
        } else
        {
            return null;
        }
    }

    public String g()
    {
        TelephonyManager telephonymanager = (TelephonyManager)a.getSystemService("phone");
        if (telephonymanager != null)
        {
            return telephonymanager.getNetworkOperatorName();
        } else
        {
            return null;
        }
    }

    public String h()
    {
        if (m.a(a, "android.permission.ACCESS_NETWORK_STATE"))
        {
            NetworkInfo networkinfo = ((ConnectivityManager)a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkinfo != null && networkinfo.isConnectedOrConnecting())
            {
                if (networkinfo.getType() == 1)
                {
                    return "WIFI";
                }
                if (networkinfo.getType() == 0)
                {
                    return "WWAN";
                }
            }
        } else
        {
            w.c("Error No ACCESS_NETWORK_STATE permissions to get Network type");
        }
        return "UNKNOWN";
    }
}
