// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.content.res.Resources;
import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.effects.clone.BrushStyleView;

// Referenced classes of package com.photo.morph:
//            StretchActivity, MorphGLSurfaceView

final class c
    implements android.widget.hangeListener
{

    private TextView a;
    private int b;
    private BrushStyleView c;
    private StretchActivity d;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        a.setText((new StringBuilder()).append(d.getResources().getString(0x7f08006a)).append(" : ").append(seekbar.getProgress()).toString());
        c.setBrushPercentSize(i);
        c.invalidate();
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
        a.setText((new StringBuilder()).append(d.getResources().getString(0x7f08006a)).append(" : ").append(seekbar.getProgress()).toString());
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        a.setText((new StringBuilder()).append(d.getResources().getString(0x7f08006a)).append(" : ").append(seekbar.getProgress()).toString());
        float f = (float)seekbar.getProgress() / 100F;
        float f1 = b;
        float f2 = 1.0F / StretchActivity.e(d).a();
        StretchActivity.a(d, f * f1 * f2);
    }

    leView(StretchActivity stretchactivity, TextView textview, int i, BrushStyleView brushstyleview)
    {
        d = stretchactivity;
        a = textview;
        b = i;
        c = brushstyleview;
        super();
    }
}
