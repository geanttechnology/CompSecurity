// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Fragment;
import com.cyberlink.youcammakeup.clflurry.ad;
import com.cyberlink.youcammakeup.clflurry.am;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.o;
import com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfMouthFeatureEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipstickToolPanel;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            h, MakeupMenuBottomToolbar

class a extends h
{

    final MakeupMenuBottomToolbar a;

    public Fragment a()
    {
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfMouthFeatureEvent(BeautyMode.v));
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.tureName.v));
        b.a(new o(com.cyberlink.youcammakeup.clflurry.reName.v));
        b.a(new ad(com.cyberlink.youcammakeup.clflurry.reName.v));
        b.a(new am(com.cyberlink.youcammakeup.clflurry.reName.v));
        StatusManager.j().a(BeautyMode.v);
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
        LipstickToolPanel lipsticktoolpanel = new LipstickToolPanel();
        ((BeautyToolPanel)lipsticktoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.c);
        return lipsticktoolpanel;
    }

    el.PreferColorMode(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        a = makeupmenubottomtoolbar;
        super(makeupmenubottomtoolbar, null);
    }
}
