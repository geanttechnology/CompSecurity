// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.widget.SeekBar;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.c;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.a.g;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class a
    implements android.widget.ar.OnSeekBarChangeListener
{

    final d a;
    private final c b = new c() {

        final d._cls11 a;

        public void a()
        {
            if (d.i(a.a) != null)
            {
                d.i(a.a).b(this);
                a.a.a(false);
                if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a.a) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a.a).b(false);
                }
                if (d.f(a.a) != null)
                {
                    d.f(a.a).a(true);
                    return;
                }
            }
        }

            
            {
                a = d._cls11.this;
                super();
            }
    };

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (d.i(a) == null)
        {
            return;
        }
        if (d.i(a).aa())
        {
            d.i(a).a(b);
            seekbar = Globals.d().j();
            if (flag)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            seekbar.b(Boolean.valueOf(flag));
            d.i(a).t(false);
        }
        d.i(a).b(Integer.toString(i));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        if (d.i(a) == null)
        {
            return;
        }
        d.i(a).s(false);
        d.p(a).a(Boolean.valueOf(true));
        d.i(a).v(true);
        Globals.d().j().y();
        a.a(true);
        if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a) != null)
        {
            com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(a).b(true);
        }
        if (d.f(a) != null)
        {
            d.f(a).a(false);
        }
        d.i(a).a(b);
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (d.i(a) != null)
        {
            d.i(a).s(true);
            d.p(a).a(Boolean.valueOf(false));
            d.i(a).v(false);
            if (Globals.d().j().b(Boolean.valueOf(true)))
            {
                Globals.d().i().b(d.i(a));
                return;
            }
        }
    }

    _cls1.a(d d1)
    {
        a = d1;
        super();
    }
}
