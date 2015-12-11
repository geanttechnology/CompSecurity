// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import a;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import bgv;
import vq;
import xo;
import xp;
import xq;
import xr;
import xs;
import xx;
import xy;
import za;

public class ParentalControlActivity extends vq
{

    private xx h;
    private xs i;
    private View j;
    private View k;
    private View l;
    private boolean m;
    private boolean n;
    private xy o;
    private android.animation.Animator.AnimatorListener p;

    public ParentalControlActivity()
    {
        o = new xo(this);
        p = new xp(this);
    }

    public static Intent a(Activity activity)
    {
        Intent intent = new Intent(activity, com/google/android/apps/youtube/kids/activities/ParentalControlActivity);
        boolean flag;
        if ((activity.getWindow().getAttributes().flags & 0x400) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        intent.putExtra("com.google.android.apps.youtube.kids.activities.Fullscreen", flag);
        return intent;
    }

    public static Intent a(Context context)
    {
        context = new Intent(context, com/google/android/apps/youtube/kids/activities/ParentalControlActivity);
        context.putExtra("com.google.android.apps.youtube.kids.activities.Onboarding", true);
        return context;
    }

    public static View a(ParentalControlActivity parentalcontrolactivity)
    {
        return parentalcontrolactivity.k;
    }

    public static xx a(ParentalControlActivity parentalcontrolactivity, xx xx1)
    {
        parentalcontrolactivity.h = xx1;
        return xx1;
    }

    public static boolean a(ParentalControlActivity parentalcontrolactivity, boolean flag)
    {
        parentalcontrolactivity.m = false;
        return false;
    }

    public static xx b(ParentalControlActivity parentalcontrolactivity)
    {
        return parentalcontrolactivity.h;
    }

    public static void c(ParentalControlActivity parentalcontrolactivity)
    {
        parentalcontrolactivity.h();
    }

    public static boolean d(ParentalControlActivity parentalcontrolactivity)
    {
        return parentalcontrolactivity.n;
    }

    public static xx e(ParentalControlActivity parentalcontrolactivity)
    {
        return parentalcontrolactivity.i();
    }

    public static View f(ParentalControlActivity parentalcontrolactivity)
    {
        return parentalcontrolactivity.l;
    }

    public static View g(ParentalControlActivity parentalcontrolactivity)
    {
        return parentalcontrolactivity.j;
    }

    private void h()
    {
        if (h != null && h.isVisible() || i != null && i.isVisible())
        {
            Object obj;
            if (h != null && h.isVisible())
            {
                obj = h;
                j.setAnimation(AnimationUtils.loadAnimation(this, 0x7f050012));
            } else
            {
                obj = i;
            }
            getFragmentManager().beginTransaction().setCustomAnimations(0, 0x7f060002).remove(((android.app.Fragment) (obj))).commit();
            n = true;
            return;
        } else
        {
            finish();
            return;
        }
    }

    private xx i()
    {
        xx xx1 = new xx();
        xx1.a = o;
        xx1.b = p;
        return xx1;
    }

    public void onBackPressed()
    {
        h();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04004c);
        j = findViewById(0x7f100162);
        k = findViewById(0x7f100163);
        l = findViewById(0x7f100165);
        findViewById(0x7f100161).setOnClickListener(new xq(this));
        l.setOnClickListener(new xr(this));
        m = getIntent().getBooleanExtra("com.google.android.apps.youtube.kids.activities.Onboarding", false);
        if (getIntent().getBooleanExtra("com.google.android.apps.youtube.kids.activities.Fullscreen", false))
        {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
    }

    protected void onPause()
    {
        overridePendingTransition(0x7f05000b, 0x7f05000d);
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        overridePendingTransition(0x7f05000b, 0x7f05000d);
        if (m)
        {
            if (i == null)
            {
                j.setVisibility(4);
                k.setVisibility(8);
                l.setVisibility(0);
                i = new xs();
                i.b = p;
                getFragmentManager().beginTransaction().setCustomAnimations(0x7f060000, 0).replace(0x7f100164, i).commit();
            }
        } else
        if (h == null)
        {
            SharedPreferences sharedpreferences = e().i();
            boolean flag;
            if (!a.e(getApplication()) || sharedpreferences.getBoolean("pref_enable_parental_gate", false))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                k.setVisibility(8);
                h = i();
                getFragmentManager().beginTransaction().setCustomAnimations(0x7f060000, 0).replace(0x7f100164, h).commit();
                j.setAnimation(AnimationUtils.loadAnimation(this, 0x7f050011));
                return;
            }
        }
    }
}
