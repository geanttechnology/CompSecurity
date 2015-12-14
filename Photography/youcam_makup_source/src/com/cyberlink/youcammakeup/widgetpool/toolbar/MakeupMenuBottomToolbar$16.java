// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Fragment;
import com.cyberlink.youcammakeup.clflurry.aa;
import com.cyberlink.youcammakeup.clflurry.am;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.o;
import com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfEyeFeatureEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            h, MakeupMenuBottomToolbar

class a extends h
{

    final MakeupMenuBottomToolbar a;

    public Fragment a()
    {
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.ureName.i));
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.tureName.s));
        b.a(new o(com.cyberlink.youcammakeup.clflurry.reName.s));
        b.a(new aa(com.cyberlink.youcammakeup.clflurry.reName.s));
        b.a(new am(com.cyberlink.youcammakeup.clflurry.reName.s));
        StatusManager.j().a(BeautyMode.u);
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
        return new com.cyberlink.youcammakeup.widgetpool.panel.a.a();
    }

    (MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        a = makeupmenubottomtoolbar;
        super(makeupmenubottomtoolbar, null);
    }
}
