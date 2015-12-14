// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.beautyui.NewOneBeautyToolBar;

public class jj
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final NewOneBeautyToolBar a;

    public jj(NewOneBeautyToolBar newonebeautytoolbar)
    {
        a = newonebeautytoolbar;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        a.mListener.a((float)seekbar.getProgress() / (float)seekbar.getMax());
    }
}
