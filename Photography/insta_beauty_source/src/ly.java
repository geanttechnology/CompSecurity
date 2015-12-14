// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class ly
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final ActivityCameraNew a;

    public ly(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        a.k.setSoftenLevel((float)i / 100F);
        ActivityCameraNew.a(a, (float)i / 100F);
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }
}
