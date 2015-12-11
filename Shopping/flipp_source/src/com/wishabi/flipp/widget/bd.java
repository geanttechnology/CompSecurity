// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.widget.ProgressBar;
import android.widget.SeekBar;

// Referenced classes of package com.wishabi.flipp.widget:
//            FlyerToolbar, bh

final class bd
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final FlyerToolbar a;

    bd(FlyerToolbar flyertoolbar)
    {
        a = flyertoolbar;
        super();
    }

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (FlyerToolbar.a(a).getVisibility() != 0)
        {
            FlyerToolbar.b(a);
        }
        if (FlyerToolbar.c(a) != null)
        {
            FlyerToolbar.c(a).a(a, i);
        }
        FlyerToolbar.d(a);
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
    }
}
