// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.widget.SeekBar;
import android.widget.TextView;
import myobfuscated.bc.c;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixActivity, BlemishFixImageView

final class a
    implements android.widget.geListener
{

    private TextView a;
    private BlemishFixActivity b;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        a.setText((new StringBuilder()).append(b.getString(0x7f0801e2)).append(" : ").append(i + 2).toString());
        c c1 = BlemishFixActivity.a(b).d;
        if (c1 != null)
        {
            c1.a(seekbar.getProgress() + 2);
            BlemishFixActivity.a(b).invalidate();
        }
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
        a.setText((new StringBuilder()).append(b.getString(0x7f0801e2)).append(" : ").append(seekbar.getProgress() + 2).toString());
        c c1 = BlemishFixActivity.a(b).d;
        if (c1 != null)
        {
            c1.a(seekbar.getProgress() + 2);
            BlemishFixActivity.a(b).invalidate();
        }
    }

    _cls9(BlemishFixActivity blemishfixactivity, TextView textview)
    {
        b = blemishfixactivity;
        a = textview;
        super();
    }
}
