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

class k
    implements android.view.View.OnTouchListener
{

    final MakeupMenuBottomToolbar a;

    private k(MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        a = makeupmenubottomtoolbar;
        super();
    }

    k(MakeupMenuBottomToolbar makeupmenubottomtoolbar, MakeupMenuBottomToolbar._cls1 _pcls1)
    {
        this(makeupmenubottomtoolbar);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag1 = false;
        boolean flag;
        if (!StatusManager.j().E().booleanValue() || MakeupMenuBottomToolbar.d(a))
        {
            flag = true;
        } else
        {
            int i = motionevent.getActionMasked();
            switch (i)
            {
            }
            if (i == 0)
            {
                MakeupMenuBottomToolbar.c(a, true);
                MakeupMenuBottomToolbar.a(a, false, view);
                return false;
            }
            flag = flag1;
            if (i == 1)
            {
                flag = flag1;
                if (StatusManager.j().s() == BeautyMode.D)
                {
                    MakeupMenuBottomToolbar.c(a, false);
                    MakeupMenuBottomToolbar.a(a, true);
                    return false;
                }
            }
        }
        return flag;
    }
}
