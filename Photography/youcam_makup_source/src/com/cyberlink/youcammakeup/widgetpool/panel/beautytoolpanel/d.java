// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.utility.at;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            c

class d extends android.view.GestureDetector.SimpleOnGestureListener
{

    final String a = com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/d.getSimpleName();
    final c b;

    d(c c1)
    {
        b = c1;
        super();
    }

    void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            c.u(b);
            return;
        } else
        {
            c.v(b);
            return;
        }
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (motionevent.getX() - motionevent1.getX() <= 60F || Math.abs(f) <= 200F)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        a(Boolean.valueOf(true));
        return false;
        if (motionevent1.getX() - motionevent.getX() <= 60F || Math.abs(f) <= 200F)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        a(Boolean.valueOf(false));
        return false;
        motionevent;
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        if (c.s(b) == null) goto _L2; else goto _L1
_L1:
        int i;
        i = c.s(b).getId();
        motionevent = (ColorDrawable)c.s(b).getBackground();
        if (motionevent == null)
        {
            return false;
        }
        if (c.t(b))
        {
            if (c.j(b) != null && c.j(b).size() > 0)
            {
                String s = (String)c.j(b).get(0);
                if (s != null)
                {
                    b.a(s, new Float[0]);
                }
            }
            c.a(b, false);
        }
        motionevent = new at(motionevent.getColor());
        if (i != 0x7f0c0880 && i != 0x7f0c0881 && i != 0x7f0c0883 && i != 0x7f0c0886) goto _L4; else goto _L3
_L3:
        c.a(b, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a, motionevent);
_L5:
        c.k(b, null);
        return true;
_L4:
        if (i == 0x7f0c0882 || i == 0x7f0c0884 || i == 0x7f0c0887)
        {
            c.a(b, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.b, motionevent);
        } else
        if (i == 0x7f0c0885 || i == 0x7f0c0888)
        {
            c.a(b, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.c, motionevent);
        } else
        if (i == 0x7f0c0889)
        {
            c.a(b, com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.d, motionevent);
        }
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }
}
