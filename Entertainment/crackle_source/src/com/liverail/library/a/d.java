// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.a.a.a.j;
import com.liverail.library.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.CookieStore;

// Referenced classes of package com.liverail.library.a:
//            e, a

public class d
{

    private static CookieStore y;
    public final String a = "2.1.0";
    public final String b = "Mozilla/5.0 (Linux; Android; Device) LiveRailSDK/2.1.0";
    public Context c;
    public HashMap d;
    public int e;
    public int f;
    public int g;
    public int h;
    public e i;
    public int j;
    public boolean k;
    public String l;
    public int m;
    private HashMap n;
    private int o;
    private int p;
    private boolean q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;

    public d()
    {
        d = new HashMap();
        e = 3;
        f = 10000;
        g = 10000;
        h = 15000;
        j = 800;
        k = false;
        l = "";
        m = 50;
        o = -1;
        p = -1;
        i = new e();
    }

    private void a(String s1, String s2)
    {
        if (!s1.equalsIgnoreCase("LR_INTEGRATION")) goto _L2; else goto _L1
_L1:
        l = s2;
_L4:
        return;
_L2:
        if (s1.equalsIgnoreCase("LR_TIMEOUT_DELIVERY"))
        {
            n.put(s1, s2);
            f = Math.round(com.liverail.library.e.a.b(s2) * 1000F);
            return;
        }
        if (s1.equalsIgnoreCase("LR_TIMEOUT_ADSOURCE"))
        {
            n.put(s1, s2);
            g = Math.round(com.liverail.library.e.a.b(s2) * 1000F);
            return;
        }
        if (s1.equalsIgnoreCase("LR_TIMEOUT_STREAM"))
        {
            n.put(s1, s2);
            h = Math.round(com.liverail.library.e.a.b(s2) * 1000F);
            return;
        }
        if (s1.equalsIgnoreCase("LR_WRAPPER_LIMIT"))
        {
            n.put(s1, s2);
            e = com.liverail.library.e.a.d(s2);
            return;
        }
        if (s1.equalsIgnoreCase("LR_LAYOUT_SKIN_MESSAGE"))
        {
            n.put(s1, s2);
            i.e = s2;
            return;
        }
        if (s1.equalsIgnoreCase("LR_LAYOUT_SKIN_ADINDEX"))
        {
            n.put(s1, s2);
            i.f = s2;
            return;
        }
        if (s1.equalsIgnoreCase("LR_LAYOUT_LINEAR_PLAYBTN"))
        {
            n.put(s1, s2);
            i.h = com.liverail.library.e.a.a(s2);
            return;
        }
        if (s1.equalsIgnoreCase("LR_LAYOUT_LINEAR_PAUSEONCLICKTHRU"))
        {
            n.put(s1, s2);
            i.g = com.liverail.library.e.a.a(s2);
            return;
        }
        if (s1.equalsIgnoreCase("LR_PLAYER_HANDLES_CLICK"))
        {
            n.put(s1, s2);
            k = com.liverail.library.e.a.a(s2);
            return;
        }
        if (s1.equalsIgnoreCase("LR_SKIP_BTN"))
        {
            n.put(s1, s2);
            i.i = com.liverail.library.e.a.a(s2);
            return;
        }
        if (s1.equalsIgnoreCase("LR_SKIP_COUNTDOWN"))
        {
            n.put(s1, s2);
            i.k = s2;
            return;
        }
        if (s1.equalsIgnoreCase("LR_SKIP_MESSAGE"))
        {
            n.put(s1, s2);
            i.j = s2;
            return;
        }
        if (!s1.equalsIgnoreCase("LR_SKIP_POSITION"))
        {
            continue; /* Loop/switch isn't completed */
        }
        n.put(s1, s2);
        s1 = s2.split(",");
        if (s1.length < 4) goto _L4; else goto _L3
_L3:
        i.l.a = com.liverail.library.e.a.c(s1[0]);
        i.l.b = com.liverail.library.e.a.e(s1[1]);
        i.l.c = com.liverail.library.e.a.c(s1[2]);
        i.l.d = com.liverail.library.e.a.e(s1[3]);
        return;
        if (!s1.startsWith("LR_")) goto _L4; else goto _L5
_L5:
        d.put(s1, s2);
        return;
    }

    private void c()
    {
        q = true;
        com.liverail.library.b.a.a("Retrieve device information...");
        Object obj = android.provider.Settings.Secure.getString(c.getContentResolver(), "android_id");
        if (obj != null && ((String) (obj)).length() > 0)
        {
            r = com.liverail.library.e.a.f(((String) (obj)));
            com.liverail.library.b.a.a((new StringBuilder("Encrypt LR_DEVICE_ID from ")).append(((String) (obj))).append(" to ").append(r).toString());
        } else
        {
            com.liverail.library.b.a.a("Failed to retrieve LR_DEVICEID");
        }
        obj = c.getPackageManager();
        try
        {
            PackageInfo packageinfo = ((PackageManager) (obj)).getPackageInfo(c.getPackageName(), 0);
            s = packageinfo.packageName;
            t = packageinfo.versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
        {
            com.liverail.library.b.a.a((new StringBuilder("Failed to retrieve LR_BUNDLE, LR_APPVERS ")).append(namenotfoundexception1.getMessage()).toString());
        }
        obj = ((PackageManager) (obj)).getApplicationLabel(((PackageManager) (obj)).getApplicationInfo(c.getPackageName(), 0));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        if (((CharSequence) (obj)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        u = ((CharSequence) (obj)).toString();
_L1:
        obj = ((TelephonyManager)c.getSystemService("phone")).getNetworkOperatorName();
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        if (obj != null && ((String) (obj)).length() > 0)
        {
            v = ((String) (obj));
        } else
        {
            com.liverail.library.b.a.a("Failed to retrieve LR_CARRIER");
        }
        obj = Build.MANUFACTURER;
        if (obj != null && ((String) (obj)).length() > 0)
        {
            w = ((String) (obj));
        } else
        {
            com.liverail.library.b.a.a("Failed to retrieve LR_MAKE");
        }
        obj = Build.MODEL;
        if (obj != null && ((String) (obj)).length() > 0)
        {
            x = Build.MODEL;
            return;
        } else
        {
            com.liverail.library.b.a.a("Failed to retrieve LR_MODEL");
            return;
        }
        try
        {
            com.liverail.library.b.a.a("Failed to retrieve LR_APPNAME");
        }
        // Misplaced declaration of an exception variable
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            com.liverail.library.b.a.a((new StringBuilder("Failed to retrieve LR_APPNAME ")).append(namenotfoundexception.getMessage()).toString());
        }
          goto _L1
    }

    public String a()
    {
        return (String)d.get("LR_PUBLISHER_ID");
    }

    public void a(Map map)
    {
        d = new HashMap();
        n = new HashMap();
        d.put("LR_ADMAP", "in::0");
        map = map.entrySet().iterator();
_L9:
        if (map.hasNext()) goto _L2; else goto _L1
_L1:
        d.put("LR_SCHEMA", "liverail");
        d.put("LR_FORMAT", "video/mp4;video/3gpp;video/webm");
        d.put("LR_OS", "Android");
        d.put("LR_OSVERS", android.os.Build.VERSION.RELEASE);
        if (!q)
        {
            c();
        }
        if (r != null)
        {
            d.put("LR_DEVICEID", r);
        }
        if (s != null)
        {
            d.put("LR_BUNDLE", s);
        }
        if (t != null)
        {
            d.put("LR_APPVERS", t);
        }
        if (u != null)
        {
            d.put("LR_APPNAME", u);
        }
        if (v != null)
        {
            d.put("LR_CARRIER", v);
        }
        if (w != null)
        {
            d.put("LR_MAKE", w);
        }
        if (x != null)
        {
            d.put("LR_MODEL", x);
        }
        if (i.a > 0 && i.b > 0)
        {
            d.put("LR_WIDTH", String.valueOf(i.a));
            d.put("LR_HEIGHT", String.valueOf(i.b));
            Object obj = d;
            if (i.a <= 300 || i.b < 250)
            {
                map = "2";
            } else
            {
                map = "3";
            }
            ((HashMap) (obj)).put("LR_ADTYPE", map);
        } else
        {
            com.liverail.library.b.a.a("Failed to retrieve LR_WIDTH and LR_HEIGHT parameters");
            d.remove("LR_WIDTH");
            d.remove("LR_HEIGHT");
            d.remove("LR_ADTYPE");
        }
        map = (AudioManager)c.getSystemService("audio");
        if (map == null) goto _L4; else goto _L3
_L3:
        o = map.getStreamVolume(3);
        p = map.getStreamMaxVolume(3);
        if (o != 0) goto _L6; else goto _L5
_L5:
        d.put("LR_MUTED", "1");
_L4:
        return;
_L2:
        obj = (java.util.Map.Entry)map.next();
        a((String)((java.util.Map.Entry) (obj)).getKey(), (String)((java.util.Map.Entry) (obj)).getValue());
        continue; /* Loop/switch isn't completed */
_L6:
        if (o <= 0) goto _L4; else goto _L7
_L7:
        d.put("LR_MUTED", "0");
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public CookieStore b()
    {
        if (y == null)
        {
            com.liverail.library.b.a.a("Initializing persistent cookie store.");
            y = new j(c);
        }
        return y;
    }

    public String toString()
    {
        StringBuilder stringbuilder;
        Iterator iterator;
        stringbuilder = new StringBuilder();
        stringbuilder.append("Delivery Run-time Parameters:");
        iterator = d.entrySet().iterator();
_L3:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        stringbuilder.append("\nAdManager specific parameters:");
        if (l != null && l.length() > 0)
        {
            stringbuilder.append("integration=").append(l);
        }
        stringbuilder.append("\nwidth=").append(i.a).append(" height=").append(i.b);
        stringbuilder.append(" currentVolume=").append(o).append(" maxVolume=").append(p);
        iterator = n.entrySet().iterator();
_L4:
        if (!iterator.hasNext())
        {
            return stringbuilder.toString();
        }
        break MISSING_BLOCK_LABEL_224;
_L2:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        stringbuilder.append("\n   ");
        stringbuilder.append((String)entry.getKey());
        stringbuilder.append("=");
        stringbuilder.append((String)entry.getValue());
          goto _L3
        java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator.next();
        stringbuilder.append("\n   ");
        stringbuilder.append((String)entry1.getKey());
        stringbuilder.append("=");
        stringbuilder.append((String)entry1.getValue());
          goto _L4
    }
}
