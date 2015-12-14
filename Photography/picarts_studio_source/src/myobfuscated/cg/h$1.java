// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cg;

import android.widget.SeekBar;

// Referenced classes of package myobfuscated.cg:
//            h

final class it>
    implements android.widget.Bar.OnSeekBarChangeListener
{

    private h a;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag)
        {
            int j = ((Integer)seekbar.getTag(0x7f100044)).intValue();
            int k = ((Integer)seekbar.getTag(0x7f100045)).intValue();
            h.a(a, j, k, i, true);
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        int i = ((Integer)seekbar.getTag(0x7f100044)).intValue();
        int j = ((Integer)seekbar.getTag(0x7f100045)).intValue();
        h.a(a, i, j, seekbar.getProgress(), false);
    }

    ar(h h1)
    {
        a = h1;
        super();
    }
}
