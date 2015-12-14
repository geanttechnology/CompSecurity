// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.MotionEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a extends android.view.pleOnGestureListener
{

    public BeautyMode a;
    final BeautyToolPanel b;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (Math.abs(f) <= Math.abs(f1)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (f1 >= 0.0F)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a != BeautyMode.x || b.m() == 0)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        if (!StatusManager.j().e().equalsIgnoreCase("default_original_wig"))
        {
            b.d(true);
            b.a(true, false, null, null);
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (a == BeautyMode.x && b.m() == 0)
        {
            b.d(false);
            b.a(false, true, null, null);
            return true;
        }
        return true;
    }

    (BeautyToolPanel beautytoolpanel)
    {
        b = beautytoolpanel;
        super();
        a = StatusManager.j().s();
    }
}
