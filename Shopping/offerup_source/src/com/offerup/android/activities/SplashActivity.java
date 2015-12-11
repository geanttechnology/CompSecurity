// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.e.a;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.widget.ImageView;
import com.b.a.a.g;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.analytics.Tracker;
import com.offerup.android.utils.OfferUpLocation;
import com.offerup.android.utils.an;
import com.offerup.android.utils.ap;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.offerup.android.activities:
//            h, hr, hs, a, 
//            SearchActivity

public class SplashActivity extends h
{

    private hr a;
    private hs b;
    private Handler c;
    private OfferUpLocation d;
    private String j;
    private boolean k;

    public SplashActivity()
    {
        a = new hr(this, (byte)0);
        b = new hs(this, (byte)0);
        c = new Handler();
        j = "SplashActivity";
        k = false;
    }

    static OfferUpLocation a(SplashActivity splashactivity)
    {
        return splashactivity.d;
    }

    static boolean b(SplashActivity splashactivity)
    {
        return splashactivity.k;
    }

    static hs c(SplashActivity splashactivity)
    {
        return splashactivity.b;
    }

    static Handler d(SplashActivity splashactivity)
    {
        return splashactivity.c;
    }

    static void e(SplashActivity splashactivity)
    {
        com.offerup.android.activities.a a1 = splashactivity.f;
        OfferUpLocation offeruplocation = splashactivity.d;
        Intent intent = new Intent(a1.a, com/offerup/android/activities/SearchActivity);
        if (offeruplocation != null)
        {
            offeruplocation.a(null);
            intent.putExtra("location", offeruplocation);
        }
        intent.addFlags(0x4000000);
        a1.a.startActivity(intent);
        splashactivity.finish();
    }

    public final void a(OfferUpLocation offeruplocation)
    {
        if (offeruplocation != null)
        {
            d = offeruplocation;
            if (offeruplocation.i() != null)
            {
                an.a(ap.a, offeruplocation.i());
            }
        }
    }

    public final void a(boolean flag)
    {
        super.a(flag);
        k = true;
    }

    final String b()
    {
        return "splash";
    }

    protected final boolean j()
    {
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        setContentView(0x7f0400ce);
        bundle = (ImageView)findViewById(0x7f1002c0);
        Picasso.with(getApplicationContext()).load(0x7f0201e6).into(bundle);
        bundle = j;
        try
        {
            Tracker tracker = android.support.v4.e.a.a(this);
            tracker.setScreenName(bundle);
            tracker.send((new com.google.android.gms.analytics.HitBuilders.EventBuilder()).setCategory("UX").setAction("click").setLabel("submit").build());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            g.a(getClass().getSimpleName(), bundle);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onPause()
    {
        c.removeCallbacks(a);
        c.removeCallbacks(b);
        AppEventsLogger.deactivateApp(this);
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        AppEventsLogger.activateApp(this);
        if (an.b(ap.a))
        {
            d = an.a(ap.a);
        } else
        {
            f();
        }
        c.postDelayed(a, 2000L);
        c.postDelayed(b, 5000L);
    }
}
