// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fotoable.fotoproedit.activity.stretch.StretchNewImageView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditNewStretchActivity

class a
    implements android.widget.ner
{

    final ProEditNewStretchActivity a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (a.g != null && a.h)
        {
            a.d.setEnabled(true);
            a.f.setTextColor(-1);
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

    (ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }
}
