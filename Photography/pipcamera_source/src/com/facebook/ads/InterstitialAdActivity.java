// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.g;
import com.facebook.ads.internal.view.f;
import com.facebook.ads.internal.view.h;
import com.facebook.ads.internal.view.m;

public class InterstitialAdActivity extends Activity
{

    public static final String PREDEFINED_ORIENTATION_KEY = "predefinedOrientationKey";
    public static final String VIDEO_PLAY_REPORT_URL = "videoPlayReportURL";
    public static final String VIDEO_TIME_REPORT_URL = "videoTimeReportURL";
    public static final String VIDEO_URL = "videoURL";
    public static final String VIEW_TYPE = "viewType";
    private RelativeLayout a;
    private g b;
    private int c;
    private String d;
    private h e;

    public InterstitialAdActivity()
    {
        c = -1;
    }

    static RelativeLayout a(InterstitialAdActivity interstitialadactivity)
    {
        return interstitialadactivity.a;
    }

    private void a(Intent intent, Bundle bundle)
    {
        if (bundle != null)
        {
            c = bundle.getInt("predefinedOrientationKey", -1);
            d = bundle.getString("adInterstitialUniqueId");
            e.a(intent, bundle);
            return;
        } else
        {
            c = intent.getIntExtra("predefinedOrientationKey", -1);
            d = intent.getStringExtra("adInterstitialUniqueId");
            e.a(intent, bundle);
            return;
        }
    }

    static void a(InterstitialAdActivity interstitialadactivity, String s)
    {
        interstitialadactivity.a(s);
    }

    private void a(String s)
    {
        s = new Intent((new StringBuilder()).append(s).append(":").append(d).toString());
        LocalBroadcastManager.getInstance(this).sendBroadcast(s);
    }

    static g b(InterstitialAdActivity interstitialadactivity)
    {
        return interstitialadactivity.b;
    }

    public void finish()
    {
        a.removeAllViews();
        e.c();
        a("com.facebook.ads.interstitial.dismissed");
        super.finish();
    }

    public void onCreate(Bundle bundle)
    {
        Intent intent;
        Type type;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        a = new RelativeLayout(this);
        a.setBackgroundColor(0xff000000);
        setContentView(a, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        intent = getIntent();
        if (intent.getBooleanExtra("useNativeCloseButton", false))
        {
            b = new g(this);
            b.setId(0x186a2);
            b.setOnClickListener(new android.view.View.OnClickListener() {

                final InterstitialAdActivity a;

                public void onClick(View view)
                {
                    a.finish();
                }

            
            {
                a = InterstitialAdActivity.this;
                super();
            }
            });
        }
        type = (Type)intent.getSerializableExtra("viewType");
        class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[Type.values().length];
                try
                {
                    a[Type.VIDEO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Type.DISPLAY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4.a[type.ordinal()];
        JVM INSTR tableswitch 1 1: default 148
    //                   1 181;
           goto _L1 _L2
_L1:
        e = new f(this, new com.facebook.ads.internal.view.h.a() {

            final InterstitialAdActivity a;

            public void a(View view)
            {
                InterstitialAdActivity.a(a).addView(view);
                if (InterstitialAdActivity.b(a) != null)
                {
                    InterstitialAdActivity.a(a).addView(InterstitialAdActivity.b(a));
                }
            }

            public void a(String s)
            {
                InterstitialAdActivity.a(a, s);
            }

            
            {
                a = InterstitialAdActivity.this;
                super();
            }
        });
_L4:
        a(intent, bundle);
        a("com.facebook.ads.interstitial.displayed");
        return;
_L2:
        e = new m(this, new com.facebook.ads.internal.view.h.a() {

            final InterstitialAdActivity a;

            public void a(View view)
            {
                InterstitialAdActivity.a(a).addView(view);
                if (InterstitialAdActivity.b(a) != null)
                {
                    InterstitialAdActivity.a(a).addView(InterstitialAdActivity.b(a));
                }
            }

            public void a(String s)
            {
                InterstitialAdActivity.a(a, s);
            }

            
            {
                a = InterstitialAdActivity.this;
                super();
            }
        });
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPause()
    {
        super.onPause();
        e.a();
    }

    public void onRestart()
    {
        super.onRestart();
    }

    public void onResume()
    {
        super.onResume();
        e.b();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        e.a(bundle);
        bundle.putInt("predefinedOrientationKey", c);
        bundle.putString("adInterstitialUniqueId", d);
    }

    public void onStart()
    {
        super.onStart();
        if (c != -1)
        {
            setRequestedOrientation(c);
        }
    }

    public void setRequestedOrientation(int i)
    {
        super.setRequestedOrientation(i);
    }

    private class Type extends Enum
    {

        public static final Type DISPLAY;
        public static final Type VIDEO;
        private static final Type a[];

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/facebook/ads/InterstitialAdActivity$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])a.clone();
        }

        static 
        {
            DISPLAY = new Type("DISPLAY", 0);
            VIDEO = new Type("VIDEO", 1);
            a = (new Type[] {
                DISPLAY, VIDEO
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }

}
