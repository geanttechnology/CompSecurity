// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;
import com.fotoable.fotoproedit.activity.stretch.StretchNewImageView;

public class aia
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final ProEditNewStretchActivity a;

    public aia(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (a.f != null && a.g)
        {
            a.d.setEnabled(true);
            a.e.setTextColor(-1);
            a.a.stretchWithSliderValue(i / 2);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        Log.e("startOnTouche", "start");
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }
}
