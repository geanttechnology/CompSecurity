// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.widget.SeekBar;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.c;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.a.d;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, k

class a
    implements android.widget.angeListener
{

    final BeautyToolPanel a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (a.b == null)
        {
            return;
        }
        if (a.b.aa())
        {
            seekbar = Globals.d().j();
            if (flag)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            seekbar.a(Boolean.valueOf(flag));
            a.b.t(false);
        }
        a.b.b(Integer.toString((int)BeautyToolPanel.s(a) + i));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        if (a.b == null)
        {
            return;
        }
        seekbar = (ImageViewer)a.b.findViewById(0x7f0c0720);
        a.b.s(false);
        BeautyToolPanel.f(a).a(Boolean.valueOf(true));
        a.b.v(true);
        Globals.d().j().x();
        a.a(true);
        if (a.c != null)
        {
            a.c.b(true);
        }
        if (a.e != null)
        {
            a.e.a(false);
        }
        a.b.a(new c() {

            final BeautyToolPanel._cls29 a;

            public void a()
            {
                if (a.a.b != null)
                {
                    a.a.b.b(this);
                }
                a.a.a(false);
                if (a.a.c != null)
                {
                    a.a.c.b(false);
                }
                if (a.a.e != null)
                {
                    a.a.e.a(true);
                }
            }

            
            {
                a = BeautyToolPanel._cls29.this;
                super();
            }
        });
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (a.b != null)
        {
            a.b.s(true);
            BeautyToolPanel.f(a).a(Boolean.valueOf(false));
            a.b.v(false);
            if (Globals.d().j().a(Boolean.valueOf(true)))
            {
                Globals.d().i().b(a.b);
                return;
            }
        }
    }

    _cls1.a(BeautyToolPanel beautytoolpanel)
    {
        a = beautytoolpanel;
        super();
    }
}
