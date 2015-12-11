// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.widget.SeekBar;
import android.widget.TextView;

final class zn
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    private zl a;

    zn(zl zl1)
    {
        a = zl1;
        super();
    }

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        long l = zl.a(a, i);
        a.f.setText(Long.toString(l));
        if (l > 1L)
        {
            i = 0x7f0b01f1;
        } else
        {
            i = 0x7f0b01f0;
        }
        a.g.setContentDescription(a.getResources().getString(i, new Object[] {
            Long.valueOf(l)
        }));
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
    }
}
