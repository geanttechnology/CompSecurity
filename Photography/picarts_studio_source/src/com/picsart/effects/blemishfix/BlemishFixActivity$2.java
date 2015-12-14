// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixActivity, BlemishFixImageView

final class a
    implements android.widget.geListener
{

    private TextView a;
    private BlemishFixActivity b;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        a.setText((new StringBuilder()).append(b.getString(0x7f0801a2)).append(" : ").append(i).toString());
        BlemishFixActivity.a(b).setBlemishFixAmount(seekbar.getProgress());
        if (flag)
        {
            b.b = true;
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        a.setText((new StringBuilder()).append(b.getString(0x7f0801a2)).append(" : ").append(seekbar.getProgress()).toString());
        BlemishFixActivity.a(b).setBlemishFixAmount(seekbar.getProgress());
    }

    _cls9(BlemishFixActivity blemishfixactivity, TextView textview)
    {
        b = blemishfixactivity;
        a = textview;
        super();
    }
}
