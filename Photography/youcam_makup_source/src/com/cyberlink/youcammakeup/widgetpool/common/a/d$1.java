// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.view.MotionEvent;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            d

class r extends android.view.ureDetector.SimpleOnGestureListener
{

    final d a;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (Math.abs(f) <= Math.abs(f1)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (f1 >= 0.0F) goto _L4; else goto _L3
_L3:
        if (StatusManager.j().e().equalsIgnoreCase("default_original_wig")) goto _L1; else goto _L5
_L5:
        a.d.p(true);
        a.d.a(Boolean.valueOf(false), Boolean.valueOf(true));
        a.d.b(0);
_L7:
        return true;
_L4:
        a.d.p(false);
        a.d.a(Boolean.valueOf(false), Boolean.valueOf(false));
        a.d.b(8);
        if (true) goto _L7; else goto _L6
_L6:
    }

    y(d d1)
    {
        a = d1;
        super();
    }
}
