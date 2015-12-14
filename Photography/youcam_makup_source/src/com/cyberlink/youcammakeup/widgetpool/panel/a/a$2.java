// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.a;

import android.widget.SeekBar;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.SliderValueText;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.a:
//            a

class a
    implements android.widget.Bar.OnSeekBarChangeListener
{

    final a a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (com.cyberlink.youcammakeup.widgetpool.panel.a.a.d(a))
        {
            Globals.d().j().b(Boolean.valueOf(false));
            com.cyberlink.youcammakeup.widgetpool.panel.a.a.c(a, false);
        }
        com.cyberlink.youcammakeup.widgetpool.panel.a.a.e(a).setText(Integer.toString(i));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        com.cyberlink.youcammakeup.widgetpool.panel.a.a.b(a, false);
        com.cyberlink.youcammakeup.widgetpool.panel.a.a.c(a).t().b(Boolean.valueOf(false));
        Globals.d().j().y();
        if (a.a != null)
        {
            a.a.a(Boolean.valueOf(true));
        }
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        com.cyberlink.youcammakeup.widgetpool.panel.a.a.b(a, true);
        if (a.a != null)
        {
            a.a.a(Boolean.valueOf(false));
        }
        if (Globals.d().j().b(Boolean.valueOf(true)))
        {
            com.cyberlink.youcammakeup.widgetpool.panel.a.a.b(a);
        }
    }

    oolBar(a a1)
    {
        a = a1;
        super();
    }
}
