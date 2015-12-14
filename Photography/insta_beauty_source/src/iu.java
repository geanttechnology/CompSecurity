// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.beautyui.NewFilterContainer;

public class iu
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final NewFilterContainer a;

    public iu(NewFilterContainer newfiltercontainer)
    {
        a = newfiltercontainer;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        float f = (float)seekbar.getProgress() / (float)seekbar.getMax();
        NewFilterContainer.access$102(a, f);
        if (a.mListener != null)
        {
            a.mListener.a(f);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }
}
