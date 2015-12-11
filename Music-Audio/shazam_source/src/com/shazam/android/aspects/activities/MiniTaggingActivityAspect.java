// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.shazam.android.analytics.TaggingOutcome;
import com.shazam.android.annotation.WithMiniTaggingFragment;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.aspects.c.a.a;
import com.shazam.android.ay.a.q;
import com.shazam.android.util.h.h;
import com.shazam.i.b.ar.a.e;
import com.shazam.i.b.c;

// Referenced classes of package com.shazam.android.aspects.activities:
//            MiniTaggingController, MiniTaggingListener, MiniTaggingControllerReceiver

public class MiniTaggingActivityAspect extends b
    implements MiniTaggingController
{
    private class NotifyingOfHidingBottomBarLayout extends com.shazam.android.widget.b
    {

        final MiniTaggingActivityAspect this$0;

        public void hideBottomBar(Runnable runnable)
        {
            super.hideBottomBar(runnable. new Runnable() {

                final NotifyingOfHidingBottomBarLayout this$1;
                final Runnable val$actionToPerformOnAnimationEnd;

                public void run()
                {
                    if (actionToPerformOnAnimationEnd != null)
                    {
                        actionToPerformOnAnimationEnd.run();
                    }
                    notifyMiniTaggingStopped(getContext());
                }

            
            {
                this$1 = final_notifyingofhidingbottombarlayout;
                actionToPerformOnAnimationEnd = Runnable.this;
                super();
            }
            });
        }

        public void hideBottomBarNoAnimation()
        {
            super.hideBottomBarNoAnimation();
            notifyMiniTaggingStopped(getContext());
        }

        public NotifyingOfHidingBottomBarLayout(a a1)
        {
            this$0 = MiniTaggingActivityAspect.this;
            super(a1);
        }
    }


    private static final String MINI_TAGGING_FRAGMENT_KEY = "mini_tagging_fragment";
    private static final String PARAM_MINI_TAGGING_STATE = "miniTaggingState";
    private static final String PARAM_SHOULD_DISPLAY_MINI_TAGGING = "shouldDisplayMiniTagging";
    private final Resources resources = c.a().getResources();
    private boolean shouldAnimateOut;
    private k supportFragmentManager;
    private final q taggingCoordinator = e.a();

    public MiniTaggingActivityAspect()
    {
    }

    private android.widget.FrameLayout.LayoutParams bottomContentLayoutParameters()
    {
        return new android.widget.FrameLayout.LayoutParams(-1, resources.getDimensionPixelSize(0x7f0a00ab));
    }

    public static void copyStateFrom(i j, Intent intent)
    {
        setMiniTaggingFlag(intent, shouldDisplayMiniFragmentFlag(j));
        saveStateOn(intent, getStateFrom(j));
    }

    private FrameLayout createBottomContent(a a1)
    {
        a1 = new FrameLayout(a1);
        a1.setId(0x7f110007);
        return a1;
    }

    private FrameLayout createTopContent(a a1)
    {
        return h.a(a1, h.a(a1), 0x7f110036);
    }

    public static void enableMiniTagging(Intent intent)
    {
        setMiniTaggingFlag(intent, true);
    }

    private com.shazam.android.fragment.h.c findMiniTaggingFragment()
    {
        return (com.shazam.android.fragment.h.c)supportFragmentManager.a("mini_tagging_fragment");
    }

    private Bundle getSavedFragmentState(Bundle bundle, Activity activity)
    {
        if (bundle != null)
        {
            return bundle.getBundle("mini_tagging_fragment");
        } else
        {
            return getStateFrom(activity);
        }
    }

    private static Bundle getStateFrom(Activity activity)
    {
        return activity.getIntent().getBundleExtra("miniTaggingState");
    }

    private void notifyMiniTaggingStarted(Object obj)
    {
        if (obj instanceof MiniTaggingListener)
        {
            ((MiniTaggingListener)obj).onMiniTaggingDisplayed();
        }
    }

    private void notifyMiniTaggingStopped(Object obj)
    {
        if (obj instanceof MiniTaggingListener)
        {
            ((MiniTaggingListener)obj).onMiniTaggingHidden();
        }
    }

    private void passControllerTo(Object obj)
    {
        if (obj instanceof MiniTaggingControllerReceiver)
        {
            ((MiniTaggingControllerReceiver)obj).receiveMiniTaggingController(this);
        }
    }

    private void pullAttributes(Object obj)
    {
        obj = (WithMiniTaggingFragment)obj.getClass().getAnnotation(com/shazam/android/annotation/WithMiniTaggingFragment);
        if (obj != null)
        {
            shouldAnimateOut = ((WithMiniTaggingFragment) (obj)).shouldAnimateOut();
        }
    }

    public static void saveStateOn(Intent intent, Bundle bundle)
    {
        intent.putExtra("miniTaggingState", bundle);
    }

    private static void setMiniTaggingFlag(Intent intent, boolean flag)
    {
        intent.putExtra("shouldDisplayMiniTagging", flag);
    }

    private static boolean shouldDisplayMiniFragmentFlag(i j)
    {
        return j.getIntent().getBooleanExtra("shouldDisplayMiniTagging", false);
    }

    private boolean shouldDisplayMiniTaggingFragment(a a1, Bundle bundle)
    {
        if (shouldDisplayMiniFragmentFlag(a1))
        {
            a1 = getSavedFragmentState(bundle, a1);
            boolean flag;
            if (a1 != null && com.shazam.android.fragment.h.b.a(a1) == com.shazam.android.ag.h.b.g)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                return true;
            }
        }
        return false;
    }

    public void disableCancelingOfTaggingWhenStopped()
    {
        com.shazam.android.fragment.h.c c1 = findMiniTaggingFragment();
        if (c1 != null)
        {
            c1.a = false;
        }
    }

    public void onBackPressed(a a1)
    {
        taggingCoordinator.a(TaggingOutcome.CANCELED);
    }

    public void onCreate(a a1, Bundle bundle)
    {
        supportFragmentManager = a1.getSupportFragmentManager();
        pullAttributes(a1);
    }

    public boolean onOptionsItemSelected(a a1, MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            taggingCoordinator.a(TaggingOutcome.CANCELED);
        }
        return false;
    }

    public void onPostCreate(a a1, Bundle bundle)
    {
        if (shouldDisplayMiniTaggingFragment(a1, bundle))
        {
            NotifyingOfHidingBottomBarLayout notifyingofhidingbottombarlayout = new NotifyingOfHidingBottomBarLayout(a1);
            notifyingofhidingbottombarlayout.setId(0x7f110014);
            notifyingofhidingbottombarlayout.addView(createTopContent(a1));
            notifyingofhidingbottombarlayout.addView(createBottomContent(a1), bottomContentLayoutParameters());
            h.a(a1).addView(notifyingofhidingbottombarlayout);
            bundle = com.shazam.android.fragment.h.c.a(getSavedFragmentState(bundle, a1), shouldAnimateOut);
            a1.getSupportFragmentManager().a().a(0x7f110007, bundle, "mini_tagging_fragment").a();
            passControllerTo(a1);
            notifyMiniTaggingStarted(a1);
        }
    }

    public void onSaveInstanceState(a a1, Bundle bundle)
    {
        a1 = findMiniTaggingFragment();
        if (a1 != null)
        {
            bundle.putBundle("mini_tagging_fragment", a1.getArguments());
        }
    }

}
