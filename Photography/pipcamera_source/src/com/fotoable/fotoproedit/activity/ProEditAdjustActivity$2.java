// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.widget.SeekBar;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditAdjustActivity

class a
    implements android.widget.istener
{

    final ProEditAdjustActivity a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        ProEditAdjustActivity.a(a, i);
        if (ProEditAdjustActivity.l(a))
        {
            ProEditAdjustActivity.a(a, false);
            return;
        } else
        {
            ProEditAdjustActivity.b(a, i);
            return;
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    (ProEditAdjustActivity proeditadjustactivity)
    {
        a = proeditadjustactivity;
        super();
    }
}
