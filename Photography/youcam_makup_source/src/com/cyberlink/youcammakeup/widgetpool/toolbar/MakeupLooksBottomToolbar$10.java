// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.widget.SeekBar;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar, TopToolBar

class a
    implements android.widget.ner
{

    final MakeupLooksBottomToolbar a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        YMKFeatureRoomLookEvent.d();
        YMKSavingPageEvent.c(true);
        YMKSavingPageEvent.a(i);
        EditViewActivity editviewactivity = Globals.d().t();
        if (editviewactivity == null)
        {
            return;
        }
        if (MakeupLooksBottomToolbar.d(a) && !MotionControlHelper.e().aC())
        {
            a.a(seekbar.getProgress(), false);
            MakeupLooksBottomToolbar.a(a, false);
        }
        editviewactivity.b(Integer.toString(i));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        seekbar = Globals.d().t();
        if (seekbar == null)
        {
            return;
        }
        MakeupLooksBottomToolbar.b(a, false);
        seekbar.v(true);
        TopToolBar toptoolbar = a.e();
        if (toptoolbar != null)
        {
            toptoolbar.a(Boolean.valueOf(true));
            toptoolbar.a(true);
        }
        seekbar.a(Boolean.valueOf(false));
        seekbar.f(true);
        MakeupLooksBottomToolbar.c(a).setEnabled(false);
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        EditViewActivity editviewactivity = Globals.d().t();
        if (editviewactivity == null)
        {
            return;
        }
        MakeupLooksBottomToolbar.b(a, true);
        MakeupLooksBottomToolbar.a(a, seekbar.getProgress());
        MakeupLooksBottomToolbar.e(a);
        editviewactivity.v(false);
        editviewactivity.f(false);
        editviewactivity.a(Boolean.valueOf(true));
        seekbar = a.e();
        if (seekbar != null)
        {
            seekbar.a(false);
            seekbar.a(Boolean.valueOf(false));
        }
        MakeupLooksBottomToolbar.c(a).setEnabled(true);
    }

    iew(MakeupLooksBottomToolbar makeuplooksbottomtoolbar)
    {
        a = makeuplooksbottomtoolbar;
        super();
    }
}
