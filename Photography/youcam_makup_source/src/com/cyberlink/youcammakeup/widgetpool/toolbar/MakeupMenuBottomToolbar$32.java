// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Fragment;
import com.cyberlink.youcammakeup.clflurry.am;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.o;
import com.cyberlink.youcammakeup.clflurry.z;
import com.cyberlink.youcammakeup.flurry.UsageOfAccessoryFeatureEvent;
import com.cyberlink.youcammakeup.flurry.UsageOfAllFeaturesEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            h, MakeupMenuBottomToolbar

class a extends h
{

    final MakeupMenuBottomToolbar a;

    public Fragment a()
    {
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.t.FeatureName.c));
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.tureName.B));
        b.a(new o(com.cyberlink.youcammakeup.clflurry.reName.B));
        b.a(new z(com.cyberlink.youcammakeup.clflurry.reName.B));
        b.a(new am(com.cyberlink.youcammakeup.clflurry.reName.B));
        StatusManager.j().a(BeautyMode.B);
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
        BeautyToolPanel beautytoolpanel = new BeautyToolPanel();
        ((BeautyToolPanel)beautytoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.e);
        return beautytoolpanel;
    }

    el.PreferColorMode(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        a = makeupmenubottomtoolbar;
        super(makeupmenubottomtoolbar, null);
    }
}
