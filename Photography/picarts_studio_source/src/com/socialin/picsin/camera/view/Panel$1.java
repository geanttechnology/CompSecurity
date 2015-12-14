// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.socialin.picsin.camera.view:
//            Panel, d

final class d
    implements android.view.ouchListener
{

    private int a;
    private int b;
    private boolean c;
    private Panel d;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        int i = -1;
        if (Panel.a(d) != ate.ANIMATING)
        {
            int k = motionevent.getAction();
            if (k == 0)
            {
                if (Panel.b(d))
                {
                    d.bringToFront();
                }
                a = 0;
                b = 0;
                if (Panel.c(d).getVisibility() == 8)
                {
                    if (Panel.d(d) == 1)
                    {
                        if (Panel.e(d) != 0)
                        {
                            i = 1;
                        }
                        b = i;
                    } else
                    {
                        if (Panel.e(d) != 2)
                        {
                            i = 1;
                        }
                        a = i;
                    }
                }
                c = true;
            } else
            {
                if (c)
                {
                    a = a * Panel.f(d);
                    b = b * Panel.g(d);
                    view = Panel.h(d);
                    int j = a;
                    int l = b;
                    view.b = j;
                    view.a = l;
                    c = false;
                    a = -a;
                    b = -b;
                }
                motionevent.offsetLocation(a, b);
            }
            if (!Panel.i(d).onTouchEvent(motionevent) && k == 1)
            {
                d.post(d.a);
                return false;
            }
        }
        return false;
    }

    ate(Panel panel)
    {
        d = panel;
        super();
    }
}
