// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKMainFeaturesClicksEvent;
import com.cyberlink.youcammakeup.clflurry.am;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.o;
import com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfCategoryEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupMenuBottomToolbar, NewIconCtrl

class a extends ch
{

    final a a;

    public void onAnimationEnd(Animator animator)
    {
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.reName.a));
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfCategoryEvent(MakeupMode.a));
        b.a(new o(com.cyberlink.youcammakeup.clflurry.Name.a));
        b.a(new YMKMainFeaturesClicksEvent(com.cyberlink.youcammakeup.clflurry.atureName.a));
        b.a(new am(com.cyberlink.youcammakeup.clflurry.atureName.a));
        a.a.d();
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a.a);
        StatusManager.j().a(Boolean.valueOf(true));
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupMenuBottomToolbar$40

/* anonymous class */
    class MakeupMenuBottomToolbar._cls40
        implements android.view.View.OnClickListener
    {

        final MakeupMenuBottomToolbar a;

        public void onClick(View view)
        {
            if (!StatusManager.j().E().booleanValue())
            {
                return;
            } else
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.a(a).a(view);
                com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.a(a, false);
                StatusManager.j().a(Boolean.valueOf(false));
                StatusManager.j().a(-1, -1, -1, -1, -1, -1, 4, -1);
                a.c(new MakeupMenuBottomToolbar._cls40._cls1(this));
                return;
            }
        }

            
            {
                a = makeupmenubottomtoolbar;
                super();
            }
    }

}
