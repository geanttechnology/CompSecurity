// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

public class ks
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final ActivityCamera a;

    public ks(ActivityCamera activitycamera)
    {
        a = activitycamera;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (ActivityCamera.c(a) != null)
        {
            ActivityCamera.c(a).b((float)i / 100.1F);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        pt.a(pt.o, a, seekbar.getProgress() / seekbar.getMax());
    }
}
