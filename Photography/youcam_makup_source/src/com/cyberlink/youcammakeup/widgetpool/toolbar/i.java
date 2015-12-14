// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.UsageOfCategoryEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupMenuBottomToolbar, NewIconCtrl

abstract class i
    implements android.view.View.OnClickListener
{

    final MakeupMenuBottomToolbar b;

    private i(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        b = makeupmenubottomtoolbar;
        super();
    }

    i(MakeupMenuBottomToolbar makeupmenubottomtoolbar, MakeupMenuBottomToolbar._cls1 _pcls1)
    {
        this(makeupmenubottomtoolbar);
    }

    static void a(i j)
    {
        j.b();
    }

    private void b()
    {
        if (StatusManager.j().r() != a()) goto _L2; else goto _L1
_L1:
        StatusManager.j().a(MakeupMode.g);
_L4:
        return;
_L2:
        com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent.FeatureName featurename;
        MakeupMode makeupmode;
        b.c();
        StatusManager.j().a(a());
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfCategoryEvent(a()));
        makeupmode = a();
        featurename = null;
        if (makeupmode != MakeupMode.a)
        {
            break; /* Loop/switch isn't completed */
        }
        featurename = com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent.FeatureName.a;
_L5:
        if (featurename != null)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKMainFeaturesClicksEvent(featurename));
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (makeupmode == MakeupMode.c)
        {
            featurename = com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent.FeatureName.b;
        } else
        if (makeupmode == MakeupMode.d)
        {
            featurename = com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent.FeatureName.c;
        } else
        if (makeupmode == MakeupMode.e)
        {
            featurename = com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent.FeatureName.d;
        } else
        if (makeupmode == MakeupMode.f)
        {
            featurename = com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent.FeatureName.e;
        } else
        if (makeupmode == MakeupMode.b)
        {
            featurename = com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent.FeatureName.f;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public abstract MakeupMode a();

    public void onClick(View view)
    {
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.a(b).a(view);
        view = b.getActivity().findViewById(0x7f0c00c5);
        view.animate().translationY(view.getHeight()).setDuration(300L).setListener(new AnimatorListenerAdapter(view) {

            final View a;
            final i b;

            public void onAnimationEnd(Animator animator)
            {
                a.animate().setListener(null);
                com.cyberlink.youcammakeup.widgetpool.toolbar.i.a(b);
                Globals.d(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        a.a.animate().translationY(0.0F).setDuration(300L).setListener(new AnimatorListenerAdapter(this) {

                            final _cls1 a;

                            public void onAnimationEnd(Animator animator)
                            {
                                a.a.a.animate().setListener(null);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        }).start();
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                b = i.this;
                a = view;
                super();
            }
        }).start();
    }
}
