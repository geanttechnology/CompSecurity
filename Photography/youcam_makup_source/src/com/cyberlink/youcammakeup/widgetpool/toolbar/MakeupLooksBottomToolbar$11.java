// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar

class a
    implements Runnable
{

    final MakeupLooksBottomToolbar a;

    public void run()
    {
        if (!MakeupLooksBottomToolbar.d(a) || MotionControlHelper.e().aC())
        {
            Globals.a(MakeupLooksBottomToolbar.f(a), 300L);
        } else
        if (!a.a(MakeupLooksBottomToolbar.g(a), true) && (a.getActivity() instanceof BaseActivity))
        {
            ((BaseActivity)a.getActivity()).i();
            return;
        }
    }

    (MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        a = makeuplooksbottomtoolbar;
        super();
    }
}
