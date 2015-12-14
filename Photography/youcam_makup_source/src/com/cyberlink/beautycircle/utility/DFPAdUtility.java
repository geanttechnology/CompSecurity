// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.cyberlink.beautycircle.Globals;
import com.google.android.gms.ads.AdSize;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            g, f, AccountManager, h

public class DFPAdUtility
{

    private static final List a = new ArrayList(Arrays.asList(new AdSize[] {
        new AdSize(600, 232), new AdSize(480, 186), new AdSize(360, 138), new AdSize(320, 124)
    }));
    private DFPAdUnitId b;
    private g c;
    private ViewGroup d;
    private int e;
    private int f;
    private BroadcastReceiver g;

    public DFPAdUtility(DFPAdUnitId dfpadunitid, int k, int l)
    {
        b = dfpadunitid;
        f = k;
        e = l;
        d();
    }

    public static DFPAdUtility a(DFPAdUnitId dfpadunitid, ViewGroup viewgroup, Activity activity)
    {
        if (viewgroup == null || activity == null)
        {
            return null;
        } else
        {
            Point point = new Point();
            activity.getWindowManager().getDefaultDisplay().getSize(point);
            int k = (point.x * 422) / 1080;
            dfpadunitid = new DFPAdUtility(dfpadunitid, point.x, k);
            dfpadunitid.a(true);
            dfpadunitid.a(viewgroup);
            return dfpadunitid;
        }
    }

    private static void b(boolean flag)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "SetServerAdResult enter"
        });
        android.content.SharedPreferences.Editor editor = Globals.n().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).edit();
        editor.putBoolean("ServerAdReturnResult", flag);
        editor.commit();
    }

    public static boolean c()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "GetServerAdResult enter"
        });
        Boolean boolean1 = Boolean.valueOf(Globals.n().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).getBoolean("ServerAdReturnResult", false));
        com.perfectcorp.utility.e.c(new Object[] {
            (new StringBuilder()).append("GetServerAdResult result:").append(boolean1).toString()
        });
        return boolean1.booleanValue();
    }

    private void d()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "init enter"
        });
        c = new g(b.a(), a, f, e);
        c.a(new h() {

            final DFPAdUtility a;

            public void a()
            {
                a.a();
            }

            public void b()
            {
            }

            
            {
                a = DFPAdUtility.this;
                super();
            }
        });
        if (g == null)
        {
            g = new f(this);
            IntentFilter intentfilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            Globals.n().registerReceiver(g, intentfilter);
        }
    }

    private void e()
    {
        h();
        b(true);
        j();
        if (c != null)
        {
            c.a(true);
        }
    }

    private static boolean f()
    {
        Object obj = Globals.n().getSystemService("connectivity");
        if (obj instanceof ConnectivityManager)
        {
            obj = ((ConnectivityManager)obj).getActiveNetworkInfo();
            if (obj != null && ((NetworkInfo) (obj)).isConnected())
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    "Network is connected"
                });
                return true;
            } else
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    "Network isn't connected"
                });
                return false;
            }
        } else
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "Unknown status of network."
            });
            return true;
        }
    }

    private static boolean g()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "HasCheckServerStatus enter"
        });
        long l = (new Date()).getTime() / 1000L;
        if (Math.abs(Globals.n().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).getLong("AskServerAdDateSecond", 0L) - l) < 0x15180L)
        {
            com.perfectcorp.utility.e.c(new Object[] {
                "HasCheckServerStatus , in 24 hours , return true."
            });
            return true;
        } else
        {
            com.perfectcorp.utility.e.c(new Object[] {
                "HasCheckServerStatus , more than 24 hours , return false."
            });
            return false;
        }
    }

    private static void h()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "SetServerStatus enter"
        });
        long l = (new Date()).getTime() / 1000L;
        com.perfectcorp.utility.e.c(new Object[] {
            (new StringBuilder()).append("SetServerStatus currentAccumulateSeconds:").append(l).toString()
        });
        android.content.SharedPreferences.Editor editor = Globals.n().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).edit();
        editor.putLong("AskServerAdDateSecond", l);
        editor.commit();
    }

    private static boolean i()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "HasChangeLangSetting enter"
        });
        String s = AccountManager.a();
        String s1 = Globals.n().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).getString("DeviceLangInfo", "null");
        com.perfectcorp.utility.e.c(new Object[] {
            (new StringBuilder()).append("HasChangeLangSetting deviceLangSetting:").append(s1).append(" current langCode:").append(s).toString()
        });
        return !s1.equals(s);
    }

    private static void j()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "SetLangSetting enter"
        });
        String s = AccountManager.a();
        com.perfectcorp.utility.e.c(new Object[] {
            (new StringBuilder()).append("SetLangSetting langCode:").append(s).toString()
        });
        android.content.SharedPreferences.Editor editor = Globals.n().getApplicationContext().getSharedPreferences("ServerAdInfo", 0).edit();
        editor.putString("DeviceLangInfo", s);
        editor.commit();
    }

    public void a()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "resumeAdView enter"
        });
        if (d != null)
        {
            d.setVisibility(0);
        }
        if (c != null)
        {
            c.b();
        }
    }

    public void a(View view)
    {
        if (c != null)
        {
            c.a(view);
            c.d();
        }
        if (g != null)
        {
            Globals.n().unregisterReceiver(g);
            g = null;
        }
    }

    public void a(ViewGroup viewgroup)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "setAdContainer enter"
        });
        d = viewgroup;
        c.a(viewgroup, new android.widget.LinearLayout.LayoutParams(-1, -1));
    }

    public void a(boolean flag)
    {
label0:
        {
label1:
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    "startAdFlow enter"
                });
                boolean flag1 = f();
                com.perfectcorp.utility.e.c(new Object[] {
                    (new StringBuilder()).append("startAdFlow bIsNetworkConnected:").append(flag1).toString()
                });
                if (flag1)
                {
                    if (!g() || i())
                    {
                        break label0;
                    }
                    if (c() && c != null)
                    {
                        if (flag || !c.e())
                        {
                            break label1;
                        }
                        a();
                    }
                }
                return;
            }
            c.a(flag);
            return;
        }
        com.perfectcorp.utility.e.c(new Object[] {
            "has not check server status or device language setting changed"
        });
        e();
    }

    public void b()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "pauseAdView enter"
        });
        if (c != null)
        {
            c.c();
        }
    }


    private class DFPAdUnitId extends Enum
    {

        public static final DFPAdUnitId a;
        public static final DFPAdUnitId b;
        public static final DFPAdUnitId c;
        private static final DFPAdUnitId d[];
        private final int id;
        private final int testId;

        public static DFPAdUnitId valueOf(String s)
        {
            return (DFPAdUnitId)Enum.valueOf(com/cyberlink/beautycircle/utility/DFPAdUtility$DFPAdUnitId, s);
        }

        public static DFPAdUnitId[] values()
        {
            return (DFPAdUnitId[])d.clone();
        }

        public String a()
        {
            Globals globals;
label0:
            {
                String s = null;
                globals = Globals.n();
                if (globals != null)
                {
                    if (Globals.c() != "PRODUCTION")
                    {
                        break label0;
                    }
                    s = globals.getString(id);
                }
                return s;
            }
            return globals.getString(testId);
        }

        static 
        {
            a = new DFPAdUnitId("MAIN", 0, m.bc_main_page_topbanner, m.bc_main_page_topbanner_test);
            b = new DFPAdUnitId("DISCOVER", 1, m.bc_discover_page_topbanner, m.bc_discover_page_topbanner_test);
            c = new DFPAdUnitId("PRODUCT", 2, m.bc_product_page_topbanner, m.bc_product_page_topbanner_test);
            d = (new DFPAdUnitId[] {
                a, b, c
            });
        }

        private DFPAdUnitId(String s, int k, int l, int i1)
        {
            super(s, k);
            id = l;
            testId = i1;
        }
    }

}
