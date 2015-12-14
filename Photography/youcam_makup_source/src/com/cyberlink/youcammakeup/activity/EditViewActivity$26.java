// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements android.view.
{

    final EditViewActivity a;

    public void onClick(View view)
    {
        view = MotionControlHelper.e().f();
        if (view == null)
        {
            return;
        }
        MotionControlHelper motioncontrolhelper = MotionControlHelper.e();
        boolean flag;
        if (!view.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        motioncontrolhelper.a(Boolean.valueOf(flag), true);
        a.O();
    }

    olHelper(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
