// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Fragment;
import com.cyberlink.youcammakeup.clflurry.ac;
import com.cyberlink.youcammakeup.clflurry.am;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.o;
import com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfHairFeatureEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.q;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            h, MakeupMenuBottomToolbar

class a extends h
{

    final MakeupMenuBottomToolbar a;

    public Fragment a()
    {
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfHairFeatureEvent(com.cyberlink.youcammakeup.flurry.tureName.a));
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.tureName.x));
        b.a(new o(com.cyberlink.youcammakeup.clflurry.reName.x));
        b.a(new ac(com.cyberlink.youcammakeup.clflurry.reName.x));
        b.a(new am(com.cyberlink.youcammakeup.clflurry.reName.x));
        StatusManager.j().a(BeautyMode.x);
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
        return new q();
    }

    (MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        a = makeupmenubottomtoolbar;
        super(makeupmenubottomtoolbar, null);
    }
}
