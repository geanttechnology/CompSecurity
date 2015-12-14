// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity, ColorSplashForegroundView

final class a
    implements android.widget.eListener
{

    private View a;
    private ColorSplashActivity b;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        i = seekbar.getProgress();
        ((TextView)a.findViewById(0x7f1001e3)).setText((new StringBuilder()).append(b.getString(0x7f080068)).append(" ").append(i).toString());
        ColorSplashActivity.a(b, a, ColorSplashActivity.e(b).k, 100 - i);
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        ColorSplashActivity.e(b).setHardness(seekbar.getProgress());
    }

    iew(ColorSplashActivity colorsplashactivity, View view)
    {
        b = colorsplashactivity;
        a = view;
        super();
    }
}
