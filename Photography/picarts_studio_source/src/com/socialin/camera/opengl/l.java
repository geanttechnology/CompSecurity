// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.widget.SeekBar;
import com.photo.gpu.g;
import com.socialin.picsin.camera.view.VerticalLabelView;

public final class l
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    private VerticalLabelView a;
    private g b;

    public l(g g1, VerticalLabelView verticallabelview)
    {
        b = g1;
        a = verticallabelview;
        super();
    }

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        a.setText((new StringBuilder("Blur : ")).append(seekbar.getProgress()).toString());
        b.p = (float)seekbar.getProgress() + 3F;
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        a.setText((new StringBuilder("Blur : ")).append(seekbar.getProgress()).toString());
        b.p = (float)seekbar.getProgress() + 3F;
    }
}
