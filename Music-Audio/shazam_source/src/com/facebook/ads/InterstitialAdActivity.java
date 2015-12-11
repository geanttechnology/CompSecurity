// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.a.e;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.facebook.ads.a.g.d;
import com.facebook.ads.a.g.f;
import com.facebook.ads.a.g.g;
import com.facebook.ads.a.h;

public class InterstitialAdActivity extends Activity
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/facebook/ads/InterstitialAdActivity$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("DISPLAY", 0);
            b = new a("VIDEO", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int j)
        {
            super(s, j);
        }
    }


    private RelativeLayout a;
    private h b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private String g;
    private f h;
    private int i;

    public InterstitialAdActivity()
    {
        f = false;
        i = -1;
    }

    static RelativeLayout a(InterstitialAdActivity interstitialadactivity)
    {
        return interstitialadactivity.a;
    }

    static void a(InterstitialAdActivity interstitialadactivity, String s)
    {
        interstitialadactivity.a(s);
    }

    private void a(String s)
    {
        s = new Intent((new StringBuilder()).append(s).append(":").append(g).toString());
        android.support.v4.a.e.a(this).a(s);
    }

    static h b(InterstitialAdActivity interstitialadactivity)
    {
        return interstitialadactivity.b;
    }

    public void finish()
    {
        a.removeAllViews();
        h.c();
        a("com.facebook.ads.interstitial.dismissed");
        super.finish();
    }

    public void onCreate(Bundle bundle)
    {
        Intent intent;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        a = new RelativeLayout(this);
        a.setBackgroundColor(0xff000000);
        setContentView(a, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        intent = getIntent();
        if (intent.getBooleanExtra("useNativeCloseButton", false))
        {
            b = new h(this);
            b.setId(0x186a2);
            b.setOnClickListener(new android.view.View.OnClickListener() {

                final InterstitialAdActivity a;

                public final void onClick(View view)
                {
                    a.finish();
                }

            
            {
                a = InterstitialAdActivity.this;
                super();
            }
            });
        }
        a a1 = (a)intent.getSerializableExtra("viewType");
        static final class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[a.values().length];
                try
                {
                    a[a.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[a.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls4.a[a1.ordinal()])
        {
        default:
            h = new d(this, new com.facebook.ads.a.g.f.a() {

                final InterstitialAdActivity a;

                public final void a(View view)
                {
                    InterstitialAdActivity.a(a).addView(view);
                    if (InterstitialAdActivity.b(a) != null)
                    {
                        InterstitialAdActivity.a(a).addView(InterstitialAdActivity.b(a));
                    }
                }

                public final void a(String s)
                {
                    InterstitialAdActivity.a(a, s);
                }

            
            {
                a = InterstitialAdActivity.this;
                super();
            }
            });
            break;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_227;
        }
_L1:
        i = intent.getIntExtra("predefinedOrientationKey", -1);
        if (bundle != null)
        {
            c = bundle.getInt("lastRequestedOrientation", -1);
            g = bundle.getString("adInterstitialUniqueId");
            h.a(intent, bundle);
            f = true;
        } else
        {
            d = intent.getIntExtra("displayWidth", 0);
            e = intent.getIntExtra("displayHeight", 0);
            g = intent.getStringExtra("adInterstitialUniqueId");
            h.a(intent, bundle);
        }
        a("com.facebook.ads.interstitial.displayed");
        return;
        h = new g(this, new com.facebook.ads.a.g.f.a() {

            final InterstitialAdActivity a;

            public final void a(View view)
            {
                InterstitialAdActivity.a(a).addView(view);
                if (InterstitialAdActivity.b(a) != null)
                {
                    InterstitialAdActivity.a(a).addView(InterstitialAdActivity.b(a));
                }
            }

            public final void a(String s)
            {
                InterstitialAdActivity.a(a, s);
            }

            
            {
                a = InterstitialAdActivity.this;
                super();
            }
        });
          goto _L1
    }

    public void onPause()
    {
        super.onPause();
        h.a();
    }

    public void onRestart()
    {
        super.onRestart();
        f = true;
    }

    public void onResume()
    {
        super.onResume();
        h.b();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        h.a(bundle);
        bundle.putInt("lastRequestedOrientation", c);
        bundle.putString("adInterstitialUniqueId", g);
    }

    public void onStart()
    {
        super.onStart();
        if (i == -1) goto _L2; else goto _L1
_L1:
        setRequestedOrientation(i);
_L4:
        f = false;
        return;
_L2:
        if (d == 0 || e == 0) goto _L4; else goto _L3
_L3:
        if (!f)
        {
            int j = d;
            boolean flag;
            int k;
            if (e >= j)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
            if (flag)
            {
                switch (k)
                {
                default:
                    setRequestedOrientation(1);
                    break;

                case 1: // '\001'
                case 2: // '\002'
                    setRequestedOrientation(9);
                    break;
                }
            } else
            {
                switch (k)
                {
                default:
                    setRequestedOrientation(0);
                    break;

                case 2: // '\002'
                case 3: // '\003'
                    setRequestedOrientation(8);
                    break;
                }
            }
        } else
        if (c >= 0)
        {
            setRequestedOrientation(c);
            c = -1;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void setRequestedOrientation(int j)
    {
        c = j;
        super.setRequestedOrientation(j);
    }
}
