// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

public class wv
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final MSlimBodyFragment a;

    public wv(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
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
        MSlimBodyFragment.a(a, (float)seekbar.getProgress() / 100F);
        MSlimBodyFragment.g(a);
    }
}
