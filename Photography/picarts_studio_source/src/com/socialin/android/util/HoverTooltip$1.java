// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import java.util.Map;

// Referenced classes of package com.socialin.android.util:
//            HoverTooltip

final class a
    implements android.view.tener
{

    private HoverTooltip a;

    public final boolean onHover(View view, MotionEvent motionevent)
    {
        int i = 0;
        motionevent.getAction();
        JVM INSTR tableswitch 7 10: default 36
    //                   7 38
    //                   8 36
    //                   9 53
    //                   10 345;
           goto _L1 _L2 _L1 _L3 _L4
_L1:
        return false;
_L2:
        if (a.b.isShowing())
        {
            return true;
        }
_L3:
        if (a.b.isShowing())
        {
            a.b.dismiss();
        }
        a.b(a.c, a.a.get(view));
        a.c.measure(0, 0);
        a.b.setWidth(a.c.getMeasuredWidth());
        a.b.setHeight(a.c.getMeasuredHeight());
        a[a.d.ordinal()];
        JVM INSTR tableswitch 1 3: default 196
    //                   1 234
    //                   2 277
    //                   3 315;
           goto _L5 _L6 _L7 _L8
_L5:
        int j = Math.abs(a.b.getWidth() - view.getWidth()) / 2;
_L9:
        a.b.showAsDropDown(view, j, i);
        return true;
_L6:
        i = (a.b.getHeight() + view.getHeight()) * -1;
        j = Math.abs(a.b.getWidth() - view.getWidth()) / 2;
          goto _L9
_L7:
        i = Math.abs(a.b.getHeight() - view.getHeight()) / 2;
        j = a.b.getWidth() * -1;
          goto _L9
_L8:
        i = Math.abs(a.b.getHeight() - view.getHeight()) / 2;
        j = view.getWidth();
          goto _L9
_L4:
        a.b.dismiss();
        return true;
    }

    cation(HoverTooltip hovertooltip)
    {
        a = hovertooltip;
        super();
    }
}
