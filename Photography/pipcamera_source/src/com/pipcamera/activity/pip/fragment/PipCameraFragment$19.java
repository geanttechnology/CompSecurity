// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements SensorEventListener
{

    final PipCameraFragment a;

    public void onAccuracyChanged(Sensor sensor, int i)
    {
        Log.e("PipCameraFragment", (new StringBuilder()).append("accuracy = ").append(i).toString());
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        PipCameraFragment.a(a, sensorevent.values[0]);
    }

    (PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
