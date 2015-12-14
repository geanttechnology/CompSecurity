// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupMenuBottomToolbar

class j
    implements android.view.View.OnTouchListener
{

    final MakeupMenuBottomToolbar a;

    private j(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        a = makeupmenubottomtoolbar;
        super();
    }

    j(MakeupMenuBottomToolbar makeupmenubottomtoolbar, MakeupMenuBottomToolbar._cls1 _pcls1)
    {
        this(makeupmenubottomtoolbar);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i;
        if (MakeupMenuBottomToolbar.c(a))
        {
            return true;
        }
        i = motionevent.getActionMasked();
        if (i != 0) goto _L2; else goto _L1
_L1:
        MakeupMenuBottomToolbar.b(a, true);
        MakeupMenuBottomToolbar.a(a, false, view);
_L4:
        return false;
_L2:
        if (i == 1 && StatusManager.j().s() == BeautyMode.D)
        {
            MakeupMenuBottomToolbar.b(a, false);
            MakeupMenuBottomToolbar.a(a, true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
