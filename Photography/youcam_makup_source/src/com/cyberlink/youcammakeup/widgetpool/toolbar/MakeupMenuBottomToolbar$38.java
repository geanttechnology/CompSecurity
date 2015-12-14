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
import com.cyberlink.youcammakeup.widgetpool.panel.d.a;
import com.cyberlink.youcammakeup.widgetpool.panel.d.f;

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
        Object obj1 = null;
        if (a != BeautyMode.j || b == BeautyMode.j) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new a();
        StatusManager.j().a(BeautyMode.j);
        com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.oolbar._cls38.b));
_L4:
        if (obj != null)
        {
            StatusManager.j().a(c, false);
        }
        return ((Fragment) (obj));
_L2:
        obj = obj1;
        if (a == BeautyMode.k)
        {
            obj = obj1;
            if (b != BeautyMode.k)
            {
                obj = new f();
                StatusManager.j().a(BeautyMode.k);
                com.cyberlink.youcammakeup.clflurry.b.a(new am(com.cyberlink.youcammakeup.clflurry.oolbar._cls38.b));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
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
