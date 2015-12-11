// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.medialets.advertising:
//            t

final class r
    implements SensorEventListener
{

    private t a;

    r(t t1)
    {
        a = t1;
        super();
    }

    public final void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public final void onSensorChanged(SensorEvent sensorevent)
    {
        float f = sensorevent.values[0];
        float f1 = sensorevent.values[1];
        int i = a.a;
        if (f1 < 4F && f > 8F)
        {
            a.a = -90;
        } else
        if (f1 < 4F && f < -1F)
        {
            a.a = 90;
        } else
        {
            a.a = 0;
        }
        if (a.a != i)
        {
            for (sensorevent = t.a(a).iterator(); sensorevent.hasNext(); ((t.a)sensorevent.next()).onOrientationChange(a.a)) { }
        }
    }
}
