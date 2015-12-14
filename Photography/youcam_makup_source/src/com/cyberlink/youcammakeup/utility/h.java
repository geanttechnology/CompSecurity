// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.LauncherActivity;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.c;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.d;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            j, i, k

public class h
{

    public static PublisherInterstitialAd a = null;
    private static String b = "DFPAdUtility";
    private static String c = "/14662192/youcammakeup-android-main-tile-1";
    private static String d = "/14662192/youcamperfect-android-main-interstitial-1";
    private static String e = "/14662192/youcammakeup-android-main-tile-1-test";
    private static String f = "/14662192/youcamperfect-android-main-interstitial-1-test";
    private static String g = null;
    private static String h = null;
    private static final List i = new ArrayList(Arrays.asList(new AdSize[] {
        new AdSize(138, 138), new AdSize(108, 108), new AdSize(78, 78), new AdSize(68, 68)
    }));
    private static h j = null;
    private static Object k = new Object();
    private static j l;
    private static NetworkManager m;
    private static int n = 0;
    private static boolean o = false;
    private static ViewGroup p;
    private static int q;
    private static int r;

    protected h()
    {
    }

    public static h a()
    {
        com.pf.common.utility.m.c(b, "getInstance enter");
        h h1;
        synchronized (k)
        {
            if (j == null)
            {
                j = new h();
                j.l();
            }
            h1 = j;
        }
        return h1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static String a(int i1)
    {
        return b(i1);
    }

    public static void a(int i1, int j1)
    {
        q = i1;
        r = j1;
        b();
    }

    public static void a(View view)
    {
        if (l != null)
        {
            l.a(view);
        }
        l = null;
        j = null;
        o = false;
    }

    public static void a(ViewGroup viewgroup)
    {
        p = viewgroup;
        if (l != null)
        {
            l.a(viewgroup, new android.widget.LinearLayout.LayoutParams(-1, -1));
        }
    }

    static void a(h h1)
    {
        h1.m();
    }

    static boolean a(boolean flag)
    {
        o = flag;
        return flag;
    }

    private static String b(int i1)
    {
        switch (i1)
        {
        default:
            return "";

        case 0: // '\0'
            return "Internal error";

        case 1: // '\001'
            return "Invalid request";

        case 2: // '\002'
            return "Network Error";

        case 3: // '\003'
            return "No fill";
        }
    }

    public static void b()
    {
label0:
        {
label1:
            {
                a();
                if (o())
                {
                    if (!p() || r())
                    {
                        break label0;
                    }
                    if (f())
                    {
                        if (!o)
                        {
                            break label1;
                        }
                        c();
                    }
                }
                return;
            }
            a().m();
            return;
        }
        n();
    }

    static void b(boolean flag)
    {
        c(flag);
    }

    public static void c()
    {
        if (p.getParent() != null)
        {
            ((View)p.getParent()).setVisibility(0);
        }
        if (l != null)
        {
            l.b();
        }
    }

    private static void c(boolean flag)
    {
        com.pf.common.utility.m.c(b, "SetServerAdResult enter");
        android.content.SharedPreferences.Editor editor = Globals.d().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).edit();
        editor.putBoolean("ServerAdReturnResult", flag);
        editor.commit();
    }

    public static void d()
    {
        if (l != null)
        {
            l.c();
        }
    }

    public static boolean e()
    {
        return o;
    }

    public static boolean f()
    {
        com.pf.common.utility.m.c(b, "GetServerAdResult enter");
        Boolean boolean1 = Boolean.valueOf(Globals.d().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).getBoolean("ServerAdReturnResult", false));
        com.pf.common.utility.m.c(b, (new StringBuilder()).append("GetServerAdResult result:").append(boolean1).toString());
        return boolean1.booleanValue();
    }

    static String g()
    {
        return b;
    }

    static void h()
    {
        q();
    }

    static void i()
    {
        s();
    }

    private String j()
    {
        if (g == null)
        {
            if (NetworkManager.e())
            {
                g = e;
            } else
            {
                g = c;
            }
        }
        return g;
    }

    private String k()
    {
        if (h == null)
        {
            if (NetworkManager.e())
            {
                h = f;
            } else
            {
                h = d;
            }
        }
        return h;
    }

    private void l()
    {
        l = new j(j(), i, r, q);
        l.a(new k() {

            final h a;

            public void a()
            {
                h.a(true);
                com.cyberlink.youcammakeup.utility.h.c();
            }

            public void b()
            {
                h.a(false);
            }

            
            {
                a = h.this;
                super();
            }
        });
        a = new PublisherInterstitialAd(Globals.d().getApplicationContext());
        a.setAdUnitId(k());
        a.setAdListener(new AdListener() {

            final h a;

            public void onAdClosed()
            {
            }

            public void onAdFailedToLoad(int j1)
            {
                com.pf.common.utility.m.c(h.g(), (new StringBuilder()).append("PublisherInterstitialAd onAdFailedToLoad : ").append(h.a(j1)).toString());
            }

            public void onAdLoaded()
            {
                com.pf.common.utility.m.c(h.g(), "PublisherInterstitialAd onAdLoaded");
            }

            
            {
                a = h.this;
                super();
            }
        });
        i i1 = new i();
        IntentFilter intentfilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        Globals.d().registerReceiver(i1, intentfilter);
    }

    private void m()
    {
        if (!o && l != null)
        {
            l.a();
        }
    }

    private static void n()
    {
        m = Globals.d().w();
        m.a(new c(m, new d() {

            public void a(bn bn1)
            {
            }

            public volatile void a(Object obj)
            {
                a((String)obj);
            }

            public void a(String s1)
            {
                if (s1.equals("ON"))
                {
                    h.h();
                    com.cyberlink.youcammakeup.utility.h.b(true);
                    h.i();
                    if (Globals.d().s() != null)
                    {
                        Globals.d().s().runOnUiThread(new Runnable(this) {

                            final _cls3 a;

                            public void run()
                            {
                                h.a(h.a());
                            }

            
            {
                a = _pcls3;
                super();
            }
                        });
                    }
                } else
                if (s1.equals("OFF"))
                {
                    h.h();
                    com.cyberlink.youcammakeup.utility.h.b(false);
                    h.i();
                    return;
                }
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

        }));
    }

    private static boolean o()
    {
        Object obj = Globals.d().getSystemService("connectivity");
        if (obj instanceof ConnectivityManager)
        {
            obj = ((ConnectivityManager)obj).getActiveNetworkInfo();
            if (obj != null && ((NetworkInfo) (obj)).isConnected())
            {
                com.pf.common.utility.m.c(b, "Network is connected");
                return true;
            } else
            {
                com.pf.common.utility.m.e(b, "Network isn't connected");
                return false;
            }
        } else
        {
            com.pf.common.utility.m.e(b, "Unknown status of network.");
            return true;
        }
    }

    private static boolean p()
    {
        com.pf.common.utility.m.c(b, "HasCheckServerStatus enter");
        long l1 = (new Date()).getTime() / 1000L;
        if (Math.abs(Globals.d().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).getLong("AskServerAdDateSecond", 0L) - l1) < 0x15180L)
        {
            com.pf.common.utility.m.c(b, "HasCheckServerStatus , in 24 hours , return true.");
            return true;
        } else
        {
            com.pf.common.utility.m.c(b, "HasCheckServerStatus , more than 24 hours , return false.");
            return false;
        }
    }

    private static void q()
    {
        com.pf.common.utility.m.c(b, "SetServerStatus enter");
        long l1 = (new Date()).getTime() / 1000L;
        com.pf.common.utility.m.c(b, (new StringBuilder()).append("SetServerStatus currentAccumulateSeconds:").append(l1).toString());
        android.content.SharedPreferences.Editor editor = Globals.d().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).edit();
        editor.putLong("AskServerAdDateSecond", l1);
        editor.commit();
    }

    private static boolean r()
    {
        boolean flag = false;
        com.pf.common.utility.m.c(b, "HasChangeLangSetting enter");
        String s1 = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        String s2 = Globals.d().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).getString("DeviceLangInfo", "null");
        com.pf.common.utility.m.c(b, (new StringBuilder()).append("HasChangeLangSetting deviceLangSetting:").append(s2).append(" current langCode:").append(s1).toString());
        if (!s2.equals(s1))
        {
            flag = true;
        }
        return flag;
    }

    private static void s()
    {
        com.pf.common.utility.m.c(b, "SetLangSetting enter");
        String s1 = com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b();
        com.pf.common.utility.m.c(b, (new StringBuilder()).append("SetLangSetting langCode:").append(s1).toString());
        android.content.SharedPreferences.Editor editor = Globals.d().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).edit();
        editor.putString("DeviceLangInfo", s1);
        editor.commit();
    }

}
