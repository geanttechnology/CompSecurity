// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.graphics.Paint;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.photo.select:
//            a, b, c

final class a
    implements android.widget.Bar.OnSeekBarChangeListener
{

    private a a;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        a.d.setText((new StringBuilder(": ")).append(i).toString());
        if (a.a != null)
        {
            seekbar = a.a.f();
            if (seekbar != null)
            {
                seekbar.H = i;
                ((c) (seekbar)).p.setAlpha(i);
                seekbar = a.a.g();
                if (seekbar != null)
                {
                    seekbar.invalidate();
                }
            }
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    Listener(a a1)
    {
        a = a1;
        super();
    }
}
