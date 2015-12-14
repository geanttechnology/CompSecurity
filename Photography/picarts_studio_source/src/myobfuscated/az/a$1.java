// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.az;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package myobfuscated.az:
//            a, e

public final class it>
    implements android.widget.Bar.OnSeekBarChangeListener
{

    private TextView a;
    private a b;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag)
        {
            int j = ((Integer)b.e).intValue();
            b.g = Integer.valueOf(j + i);
            a.setText(b.a());
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        if (b.l != null)
        {
            int i = ((Integer)b.e).intValue();
            int j = seekbar.getProgress();
            b.g = Integer.valueOf(i + j);
            a.setText(b.a());
            b.l.a();
        }
    }

    public iew(a a1, TextView textview)
    {
        b = a1;
        a = textview;
        super();
    }
}
