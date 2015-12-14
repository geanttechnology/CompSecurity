// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.ai;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager

class d
    implements Runnable
{

    final EditViewActivity a;
    final boolean b;
    final boolean c;
    final boolean d;
    final StatusManager e;

    public void run()
    {
        boolean flag1 = false;
        if (e.s() == BeautyMode.x)
        {
            Object obj = MotionControlHelper.e().T();
            boolean flag;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            if (obj != null)
            {
                flag = ((ai) (obj)).a();
            } else
            {
                flag = false;
            }
            if (a.A())
            {
                a.c(b, c);
                return;
            }
            obj = a;
            flag2 = b;
            flag3 = b;
            flag4 = c;
            if (d || flag)
            {
                flag1 = true;
            }
            ((EditViewActivity) (obj)).a(Boolean.valueOf(flag2), Boolean.valueOf(flag3), Boolean.valueOf(flag4), Boolean.valueOf(flag1), null);
            return;
        }
        if (a.A())
        {
            a.c(b, c);
            return;
        } else
        {
            a.a(Boolean.valueOf(b), Boolean.valueOf(b), Boolean.valueOf(c), Boolean.valueOf(d), null);
            return;
        }
    }

    er(StatusManager statusmanager, EditViewActivity editviewactivity, boolean flag, boolean flag1, boolean flag2)
    {
        e = statusmanager;
        a = editviewactivity;
        b = flag;
        c = flag1;
        d = flag2;
        super();
    }
}
