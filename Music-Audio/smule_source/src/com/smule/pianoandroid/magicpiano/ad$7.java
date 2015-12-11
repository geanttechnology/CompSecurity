// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.SeekBar;
import com.smule.magicpiano.PianoCoreBridge;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ad, av

class a
    implements android.widget.ar.OnSeekBarChangeListener
{

    final ad a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        float f = (float)a.f.getProgress() / 100F;
        PianoCoreBridge.setVoxVolume(f);
        av.a(a, f);
    }

    istener(ad ad1)
    {
        a = ad1;
        super();
    }
}
