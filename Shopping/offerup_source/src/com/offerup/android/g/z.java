// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.widget.SeekBar;
import android.widget.TextView;
import com.offerup.android.dto.FilterOption;
import java.util.List;

// Referenced classes of package com.offerup.android.g:
//            x

final class z
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    private int a;
    private x b;

    private z(x x1)
    {
        b = x1;
        super();
        int i;
        if (x.c(b).size() > 2)
        {
            i = x.c(b).size() - 1;
        } else
        {
            i = 1;
        }
        a = 1000 / i;
    }

    z(x x1, byte byte0)
    {
        this(x1);
    }

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        double d = i;
        i = (int)Math.round(d / (double)a);
        x.d(b).setText(((FilterOption)x.c(b).get(i)).getLongLabel());
        this;
        JVM INSTR monitorexit ;
        return;
        seekbar;
        throw seekbar;
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        x.a(b).setProgress(Math.round((seekbar.getProgress() + a / 2) / a) * a);
        int i = Math.round(seekbar.getProgress() / a);
        if (x.c(b).get(i) != null)
        {
            x.e(b).setSelected(false);
            x.a(b, (FilterOption)x.c(b).get(i));
            x.e(b).setSelected(true);
        }
    }
}
