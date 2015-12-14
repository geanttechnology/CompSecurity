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
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            h, MakeupMenuBottomToolbar

class c extends h
{

    final BeautyMode a;
    final BeautyMode b;
    final MakeupMode c;
    final MakeupMenuBottomToolbar d;

    public Fragment a()
    {
        BeautyToolPanel beautytoolpanel = new BeautyToolPanel();
        ((BeautyToolPanel)beautytoolpanel).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.e);
        if (a == BeautyMode.z && b != BeautyMode.z)
        {
            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.t.FeatureName.d));
            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.tureName.z));
            com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.reName.z));
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.reName.z));
            com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.reName.z));
            StatusManager.j().a(BeautyMode.z);
        } else
        if (a == BeautyMode.A && b != BeautyMode.A)
        {
            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.t.FeatureName.b));
            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.tureName.A));
            com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.reName.A));
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.reName.A));
            com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.reName.A));
            StatusManager.j().a(BeautyMode.A);
        } else
        if (a == BeautyMode.B && b != BeautyMode.B)
        {
            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.t.FeatureName.c));
            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.tureName.B));
            com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.reName.B));
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.reName.B));
            com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.reName.B));
            StatusManager.j().a(BeautyMode.B);
        } else
        if (a == BeautyMode.C && b != BeautyMode.C)
        {
            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAccessoryFeatureEvent(com.cyberlink.youcammakeup.flurry.t.FeatureName.a));
            com.cyberlink.youcammakeup.flurry.a.a(new UsageOfAllFeaturesEvent(com.cyberlink.youcammakeup.flurry.tureName.C));
            com.cyberlink.youcammakeup.clflurry.b.a(new o(com.cyberlink.youcammakeup.clflurry.reName.C));
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.reName.C));
            com.cyberlink.youcammakeup.clflurry.b.a(new z(com.cyberlink.youcammakeup.clflurry.reName.C));
            StatusManager.j().a(BeautyMode.C);
        } else
        {
            beautytoolpanel = null;
        }
        if (beautytoolpanel != null)
        {
            StatusManager.j().a(c, false);
        }
        return beautytoolpanel;
    }

    e(MakeupMenuBottomToolbar makeupmenubottomtoolbar, BeautyMode beautymode, BeautyMode beautymode1, MakeupMode makeupmode)
    {
        d = makeupmenubottomtoolbar;
        a = beautymode;
        b = beautymode1;
        c = makeupmode;
        super(makeupmenubottomtoolbar, null);
    }
}
