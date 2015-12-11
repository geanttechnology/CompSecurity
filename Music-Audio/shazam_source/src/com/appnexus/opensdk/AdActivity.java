// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.j;
import com.appnexus.opensdk.b.k;
import com.appnexus.opensdk.b.o;
import java.util.Locale;

// Referenced classes of package com.appnexus.opensdk:
//            t, q, w

public class AdActivity extends Activity
{
    static interface a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d();

        public abstract WebView e();
    }

    static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        private static final b d[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/appnexus/opensdk/AdActivity$b, s);
        }

        public static b[] values()
        {
            return (b[])d.clone();
        }

        static 
        {
            a = new b("portrait", 0);
            b = new b("landscape", 1);
            c = new b("none", 2);
            d = (new b[] {
                a, b, c
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    static Class a = com/appnexus/opensdk/AdActivity;
    private a b;

    public AdActivity()
    {
    }

    static Class a()
    {
        return a;
    }

    protected static void a(Activity activity)
    {
        b(activity, activity.getResources().getConfiguration().orientation);
    }

    protected static void a(Activity activity, int i)
    {
        b(activity, i);
    }

    protected static void a(Activity activity, b b1)
    {
        int i = activity.getResources().getConfiguration().orientation;
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[b.values().length];
                try
                {
                    a[b.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.appnexus.opensdk.b.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[b.a.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[b1.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 50
    //                   2 56
    //                   3 61;
           goto _L1 _L2 _L3 _L4
_L1:
        b(activity, i);
        return;
_L2:
        activity.setRequestedOrientation(-1);
        return;
_L3:
        i = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 1;
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected static void b(Activity activity)
    {
        activity.setRequestedOrientation(-1);
    }

    private static void b(Activity activity, int i)
    {
        Object obj = j.a().g.toUpperCase(Locale.US);
        boolean flag;
        if (j.a().f.toUpperCase(Locale.US).equals("AMAZON") && (((String) (obj)).equals("KFTT") || ((String) (obj)).equals("KFJWI") || ((String) (obj)).equals("KFJWA")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = ((WindowManager)activity.getSystemService("window")).getDefaultDisplay();
        if (i != 1) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 9) goto _L4; else goto _L3
_L3:
        activity.setRequestedOrientation(1);
_L6:
        return;
_L4:
        i = ((Display) (obj)).getRotation();
        if (i == 1 || i == 2)
        {
            activity.setRequestedOrientation(9);
            return;
        } else
        {
            activity.setRequestedOrientation(1);
            return;
        }
_L2:
        if (i == 2)
        {
            if (android.os.Build.VERSION.SDK_INT >= 9)
            {
                i = ((Display) (obj)).getRotation();
                if (!flag)
                {
                    if (i == 0 || i == 1)
                    {
                        activity.setRequestedOrientation(0);
                        return;
                    } else
                    {
                        activity.setRequestedOrientation(8);
                        return;
                    }
                }
                if (i == 0 || i == 1)
                {
                    activity.setRequestedOrientation(8);
                    return;
                }
            }
            activity.setRequestedOrientation(0);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onBackPressed()
    {
        if (b != null)
        {
            b.b();
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getStringExtra("ACTIVITY_TYPE");
        if (!k.a(bundle)) goto _L2; else goto _L1
_L1:
        com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.adactivity_no_type));
        finish();
_L4:
        CookieSyncManager.createInstance(this);
        bundle = CookieSyncManager.getInstance();
        if (bundle != null)
        {
            bundle.startSync();
        }
        return;
_L2:
        if ("INTERSTITIAL".equals(bundle))
        {
            b = new t(this);
            b.a();
        } else
        if ("BROWSER".equals(bundle))
        {
            b = new q(this);
            b.a();
        } else
        if ("MRAID".equals(bundle))
        {
            b = new w(this);
            b.a();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    protected void onDestroy()
    {
        if (b != null)
        {
            b.c();
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        if (b != null)
        {
            o.c(b.e());
        }
        CookieSyncManager cookiesyncmanager = CookieSyncManager.getInstance();
        if (cookiesyncmanager != null)
        {
            cookiesyncmanager.stopSync();
        }
        super.onPause();
    }

    protected void onResume()
    {
        if (b != null)
        {
            o.b(b.e());
        }
        CookieSyncManager cookiesyncmanager = CookieSyncManager.getInstance();
        if (cookiesyncmanager != null)
        {
            cookiesyncmanager.startSync();
        }
        super.onResume();
    }

}
