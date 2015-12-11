// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;

final class gf
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final ge a;
    private final Runnable b = new gg(this);

    gf(ge ge1)
    {
        a = ge1;
        super();
    }

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag)
        {
            ge.d(a).a(i);
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
        if (ge.a(a))
        {
            ge.c(a).removeCallbacks(b);
            return;
        } else
        {
            ge.a(a, true);
            return;
        }
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        ge.c(a).postDelayed(b, 250L);
    }
}
