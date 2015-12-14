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
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.j;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.q;

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
        Object obj;
        if (a == BeautyMode.x && b != BeautyMode.x)
        {
            obj = new q();
            StatusManager.j().a(BeautyMode.x);
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.init>));
        } else
        if (a == BeautyMode.y && b != BeautyMode.y)
        {
            obj = new j();
            StatusManager.j().a(BeautyMode.y);
            com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.init>));
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            StatusManager.j().a(c, false);
        }
        return ((Fragment) (obj));
    }

    (MakeupMenuBottomToolbar makeupmenubottomtoolbar, BeautyMode beautymode, BeautyMode beautymode1, MakeupMode makeupmode)
    {
        d = makeupmenubottomtoolbar;
        a = beautymode;
        b = beautymode1;
        c = makeupmode;
        super(makeupmenubottomtoolbar, null);
    }
}
