// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class na
    implements SensorEventListener
{

    final ActivityCameraNew a;

    public na(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
        Log.e(ActivityCameraNew.i(a), (new StringBuilder()).append("accuracy = ").append(i).toString());
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        ActivityCameraNew.b(a, sensorevent.values[0]);
    }
}
