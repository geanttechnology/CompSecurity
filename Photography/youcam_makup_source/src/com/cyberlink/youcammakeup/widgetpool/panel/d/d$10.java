// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.VerticalSeekBar;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class b
    implements Runnable
{

    final float a;
    final boolean b;
    final d c;

    public void run()
    {
        LayoutInflater.from(d.h(c).getContext()).inflate(0x7f0301d7, d.i(c).Z());
        d.a(c, (ViewGroup)d.i(c).Z().findViewById(0x7f0c0854));
        d.a(c, (VerticalSeekBar)d.i(c).Z().findViewById(0x7f0c0855));
        if (d.u(c) != null)
        {
            d.u(c).setProgress((int)a);
            d.u(c).setOnSeekBarChangeListener(c.a);
            Globals.d().j().a(d.u(c));
            if (d.i(c) != null)
            {
                d.i(c).v();
            }
        }
        c.c(b);
    }

    ControlHelper(d d1, float f, boolean flag)
    {
        c = d1;
        a = f;
        b = flag;
        super();
    }
}
