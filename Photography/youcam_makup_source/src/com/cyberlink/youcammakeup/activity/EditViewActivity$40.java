// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.widget.SeekBar;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.FixedAspectRatioFrameLayout;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.SliderValueText;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements android.widget.ngeListener
{

    final EditViewActivity a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (com.cyberlink.youcammakeup.activity.EditViewActivity.k(a))
        {
            seekbar = Globals.d().j();
            if (flag)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            seekbar.b(Boolean.valueOf(flag));
            EditViewActivity.b(a, false);
        }
        EditViewActivity.l(a).setText(Integer.toString(i));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        EditViewActivity.a(a, false);
        EditViewActivity.ae().a(Boolean.valueOf(true));
        Globals.d().j().y();
        if (EditViewActivity.i(a) != null)
        {
            ((FixedAspectRatioFrameLayout)EditViewActivity.i(a)).setInterceptTouchEvent(true);
        }
        if (EditViewActivity.j(a) != null)
        {
            EditViewActivity.j(a).b(true);
        }
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        EditViewActivity.a(a, true);
        EditViewActivity.ae().a(Boolean.valueOf(false));
        if (Globals.d().j().b(Boolean.valueOf(true)))
        {
            Globals.d().i().b(a);
        }
    }

    nel.k(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
