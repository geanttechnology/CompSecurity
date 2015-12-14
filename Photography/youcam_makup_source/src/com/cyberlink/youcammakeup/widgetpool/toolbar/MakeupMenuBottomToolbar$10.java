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
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.f;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            h, MakeupMenuBottomToolbar

class a extends h
{

    final MakeupMenuBottomToolbar a;

    public Fragment a()
    {
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfEyeFeatureEvent(com.cyberlink.youcammakeup.flurry.ureName.e));
        com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.tureName.p));
        b.a(new o(com.cyberlink.youcammakeup.clflurry.reName.p));
        b.a(new aa(com.cyberlink.youcammakeup.clflurry.reName.p));
        b.a(new am(com.cyberlink.youcammakeup.clflurry.reName.p));
        StatusManager.j().a(BeautyMode.s);
        com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar.b(a);
        f f1 = new f();
        ((BeautyToolPanel)f1).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.d);
        return f1;
    }

    el.PreferColorMode(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        a = makeupmenubottomtoolbar;
        super(makeupmenubottomtoolbar, null);
    }
}
