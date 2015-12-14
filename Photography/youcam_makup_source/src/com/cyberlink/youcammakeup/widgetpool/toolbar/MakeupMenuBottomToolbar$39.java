// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Fragment;
import com.cyberlink.youcammakeup.clflurry.am;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.LipstickToolPanel;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.f;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.h;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.n;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            h, MakeupMenuBottomToolbar

class c extends com.cyberlink.youcammakeup.widgetpool.toolbar.h
{

    final BeautyMode a;
    final BeautyMode b;
    final MakeupMode c;
    final MakeupMenuBottomToolbar d;

    public Fragment a()
    {
        Object obj1 = null;
        if (a != BeautyMode.n || b == BeautyMode.n) goto _L2; else goto _L1
_L1:
        Object obj;
        StatusManager.j().a(BeautyMode.n);
        obj = new BeautyToolPanel();
        ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.a);
        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.e.a));
_L4:
        if (obj != null)
        {
            StatusManager.j().a(c, false);
        }
        return ((Fragment) (obj));
_L2:
        if (a == BeautyMode.m && b != BeautyMode.m)
        {
            StatusManager.j().a(BeautyMode.m);
            obj = new n();
            ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.c);
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.e.c));
        } else
        if (a == BeautyMode.l && b != BeautyMode.l)
        {
            StatusManager.j().a(BeautyMode.l);
            obj = new n();
            ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.c);
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.e.c));
        } else
        if (a == BeautyMode.r && b != BeautyMode.r)
        {
            StatusManager.j().a(BeautyMode.r);
            obj = new h();
            ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.c);
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.e.c));
        } else
        if (a == BeautyMode.s && b != BeautyMode.s)
        {
            StatusManager.j().a(BeautyMode.s);
            obj = new f();
            ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.d);
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.e.d));
        } else
        if (a == BeautyMode.a && b != BeautyMode.a)
        {
            StatusManager.j().a(BeautyMode.a);
            obj = new n();
            ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.c);
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.e.c));
        } else
        if (a == BeautyMode.t && b != BeautyMode.t)
        {
            StatusManager.j().a(BeautyMode.t);
            obj = new BeautyToolPanel();
            ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.d);
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.e.d));
        } else
        if (a == BeautyMode.v && b != BeautyMode.v)
        {
            StatusManager.j().a(BeautyMode.v);
            obj = new LipstickToolPanel();
            ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.c);
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.e.c));
        } else
        {
            obj = obj1;
            if (a == BeautyMode.b)
            {
                obj = obj1;
                if (b != BeautyMode.b)
                {
                    StatusManager.j().a(BeautyMode.b);
                    obj = new BeautyToolPanel();
                    ((BeautyToolPanel) (obj)).a(com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.Mode.c);
                    com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.e.c));
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    anel(MakeupMenuBottomToolbar makeupmenubottomtoolbar, BeautyMode beautymode, BeautyMode beautymode1, MakeupMode makeupmode)
    {
        d = makeupmenubottomtoolbar;
        a = beautymode;
        b = beautymode1;
        c = makeupmode;
        super(makeupmenubottomtoolbar, null);
    }
}
