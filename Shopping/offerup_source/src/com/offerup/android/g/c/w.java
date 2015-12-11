// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.widget.SeekBar;
import android.widget.TextView;
import com.b.a.a.j;

// Referenced classes of package com.offerup.android.g.c:
//            t

final class w
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    private t a;

    w(t t1)
    {
        a = t1;
        super();
    }

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag && j.a().R())
        {
            j.a().s(false);
        }
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            t.c(a).setText(0x7f090123);
            return;

        case 1: // '\001'
            t.c(a).setText(0x7f090124);
            return;

        case 2: // '\002'
            t.c(a).setText(0x7f090125);
            return;

        case 3: // '\003'
            t.c(a).setText(0x7f090126);
            return;

        case 4: // '\004'
            t.c(a).setText(0x7f090127);
            return;

        case 5: // '\005'
            t.c(a).setText(0x7f090128);
            break;
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
    }
}
