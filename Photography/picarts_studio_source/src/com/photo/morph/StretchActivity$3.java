// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.photo.morph:
//            StretchActivity

final class a
    implements android.widget.hangeListener
{

    private TextView a;
    private StretchActivity b;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        a.setText((new StringBuilder()).append(b.getString(0x7f080066)).append(i).toString());
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        StretchActivity.b(b, (float)seekbar.getProgress() / 100F);
    }

    angeListener(StretchActivity stretchactivity, TextView textview)
    {
        b = stretchactivity;
        a = textview;
        super();
    }
}
