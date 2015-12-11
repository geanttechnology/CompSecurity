// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.j.a.g.w;

// Referenced classes of package com.j.a.d:
//            e, a

public class q
    implements SensorEventListener
{

    private SensorManager a;
    private Sensor b;
    private float c[];
    private int d;
    private long e;
    private a f;

    public q()
    {
        c = new float[3];
    }

    private float a(float f1, int i)
    {
        return 0.8F * c[i] + 0.2F * f1;
    }

    private float a(SensorEvent sensorevent)
    {
        c[0] = a(sensorevent.values[0], 0);
        c[1] = a(sensorevent.values[1], 1);
        c[2] = a(sensorevent.values[2], 2);
        float f1 = sensorevent.values[0];
        float f2 = c[0];
        float f3 = sensorevent.values[1];
        float f4 = c[1];
        float f5 = sensorevent.values[2];
        float f6 = c[2];
        return Math.max(Math.max(f1 - f2, f3 - f4), f5 - f6);
    }

    private void c()
    {
        d = 0;
        e = System.currentTimeMillis();
    }

    public void a()
    {
        a.registerListener(this, b, 3);
    }

    public void a(Context context)
    {
        a = (SensorManager)context.getSystemService("sensor");
        b = a.getDefaultSensor(1);
        a();
    }

    public void a(a a1)
    {
        f = a1;
    }

    public void b()
    {
        a.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        if (com.j.a.d.e.e().i() && a(sensorevent) >= 5F)
        {
            if (d == 0)
            {
                d = d + 1;
                e = System.currentTimeMillis();
            } else
            {
                long l = System.currentTimeMillis();
                if (l - e < 500L && l - e > 10L)
                {
                    d = d + 1;
                    w.a((new StringBuilder()).append("Move Count: ").append(d).toString());
                    if (d >= 3 && f != null)
                    {
                        f.a();
                        return;
                    }
                } else
                {
                    c();
                    d = d + 1;
                    return;
                }
            }
        }
    }
}
