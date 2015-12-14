// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.VerticalSeekBar;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class d
    implements Runnable
{

    final float a;
    final float b;
    final float c;
    final boolean d;
    final BeautyToolPanel e;

    public void run()
    {
        BeautyMode beautymode = StatusManager.j().s();
        Object obj = LayoutInflater.from(e.a.getContext());
        if (beautymode == BeautyMode.n || beautymode == BeautyMode.v || beautymode == BeautyMode.x || beautymode == BeautyMode.l || beautymode == BeautyMode.b || beautymode == BeautyMode.a || beautymode == BeautyMode.m || beautymode == BeautyMode.t)
        {
            obj = ((LayoutInflater) (obj)).inflate(0x7f0301d7, null);
            e.b.Z().addView(((View) (obj)));
            BeautyToolPanel.a(e, (ViewGroup)e.b.Z().findViewById(0x7f0c0854));
            BeautyToolPanel.a(e, (VerticalSeekBar)e.b.Z().findViewById(0x7f0c0855));
        } else
        if (beautymode == BeautyMode.r || beautymode == BeautyMode.s || beautymode == BeautyMode.y)
        {
            obj = ((LayoutInflater) (obj)).inflate(0x7f0301d8, null);
            e.b.Z().addView(((View) (obj)));
            BeautyToolPanel.b(e, (ViewGroup)e.b.Z().findViewById(0x7f0c0856));
            BeautyToolPanel.a(e, (VerticalSeekBar)e.b.Z().findViewById(0x7f0c0858));
            BeautyToolPanel.b(e, (VerticalSeekBar)e.b.Z().findViewById(0x7f0c085a));
            BeautyToolPanel.a(e, (TextView)e.b.Z().findViewById(0x7f0c0857));
            BeautyToolPanel.b(e, (TextView)e.b.Z().findViewById(0x7f0c0859));
        }
        if (BeautyToolPanel.j(e) != null)
        {
            BeautyToolPanel.j(e).setProgress((int)a);
            BeautyToolPanel.j(e).setOnSeekBarChangeListener(e.A);
            Globals.d().j().a(BeautyToolPanel.j(e));
            if (BeautyToolPanel.k(e) != null && beautymode == BeautyMode.y)
            {
                BeautyToolPanel.k(e).setText(0x7f070342);
            }
            if (e.b != null)
            {
                e.b.v();
            }
        }
        if (BeautyToolPanel.l(e) != null)
        {
            BeautyToolPanel.l(e).setProgress((int)b);
            BeautyToolPanel.l(e).setOnSeekBarChangeListener(e.B);
            BeautyToolPanel.a(e, c);
            Globals.d().j().b(BeautyToolPanel.l(e));
            if (BeautyToolPanel.m(e) != null)
            {
                if (beautymode == BeautyMode.r)
                {
                    BeautyToolPanel.m(e).setText(0x7f07034c);
                } else
                if (beautymode == BeautyMode.y)
                {
                    BeautyToolPanel.m(e).setText(0x7f070331);
                }
            }
        }
        if (BeautyToolPanel.n(e) != null)
        {
            e.i(d);
        } else
        {
            e.h(d);
        }
        e.g(null);
    }

    (BeautyToolPanel beautytoolpanel, float f, float f1, float f2, boolean flag)
    {
        e = beautytoolpanel;
        a = f;
        b = f1;
        c = f2;
        d = flag;
        super();
    }
}
