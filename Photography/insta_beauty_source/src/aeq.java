// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.fotoproedit.activity.ProEditAdjustActivity;

public class aeq
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final ProEditAdjustActivity a;

    public aeq(ProEditAdjustActivity proeditadjustactivity)
    {
        a = proeditadjustactivity;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        ProEditAdjustActivity.a(a, i);
        if (ProEditAdjustActivity.n(a))
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
}
