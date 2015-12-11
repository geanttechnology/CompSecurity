// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.listener;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tapjoy.mraid.controller.MraidSensor;
import java.util.List;

public class Accel
    implements SensorEventListener
{

    MraidSensor a;
    int b;
    int c;
    int d;
    private SensorManager e;
    private int f;
    private long g;
    private int h;
    private long i;
    private long j;
    private float k[];
    private float l[] = {
        0.0F, 0.0F, 0.0F
    };
    private boolean m;
    private boolean n;
    private float o[] = {
        0.0F, 0.0F, 0.0F
    };
    private float p[] = {
        -1F, -1F, -1F
    };

    public Accel(Context context, MraidSensor mraidsensor)
    {
        b = 0;
        c = 0;
        d = 0;
        f = 3;
        a = mraidsensor;
        e = (SensorManager)context.getSystemService("sensor");
    }

    private void a()
    {
        List list = e.getSensorList(1);
        if (list.size() > 0)
        {
            e.registerListener(this, (Sensor)list.get(0), f);
        }
    }

    public float getHeading()
    {
        return p[0];
    }

    public void onAccuracyChanged(Sensor sensor, int i1)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        sensorevent.sensor.getType();
        JVM INSTR tableswitch 1 2: default 28
    //                   1 341
    //                   2 319;
           goto _L1 _L2 _L3
_L1:
        if (k != null && l != null && n && m)
        {
            n = false;
            m = false;
            float af[] = new float[9];
            SensorManager.getRotationMatrix(af, new float[9], l, k);
            p = new float[3];
            SensorManager.getOrientation(af, p);
            a.onHeadingChange(p[0]);
        }
        if (sensorevent.sensor.getType() == 1)
        {
            long l1 = System.currentTimeMillis();
            if (l1 - g > 500L)
            {
                h = 0;
            }
            if (l1 - i > 100L)
            {
                long l2 = i;
                if ((Math.abs((l[0] + l[1] + l[2]) - o[0] - o[1] - o[2]) / (float)(l1 - l2)) * 10000F > 1000F)
                {
                    int i1 = h + 1;
                    h = i1;
                    if (i1 >= 2 && l1 - j > 2000L)
                    {
                        j = l1;
                        h = 0;
                        a.onShake();
                    }
                    g = l1;
                }
                i = l1;
                a.onTilt(l[0], l[1], l[2]);
            }
        }
        return;
_L3:
        k = (float[])sensorevent.values.clone();
        m = true;
        continue; /* Loop/switch isn't completed */
_L2:
        o = l;
        l = (float[])sensorevent.values.clone();
        n = true;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setSensorDelay(int i1)
    {
        f = i1;
        if (b > 0 || c > 0)
        {
            stop();
            a();
        }
    }

    public void startTrackingHeading()
    {
        if (d == 0)
        {
            List list = e.getSensorList(2);
            if (list.size() > 0)
            {
                e.registerListener(this, (Sensor)list.get(0), f);
                a();
            }
        }
        d = d + 1;
    }

    public void startTrackingShake()
    {
        if (c == 0)
        {
            setSensorDelay(1);
            a();
        }
        c = c + 1;
    }

    public void startTrackingTilt()
    {
        if (b == 0)
        {
            a();
        }
        b = b + 1;
    }

    public void stop()
    {
        if (d == 0 && c == 0 && b == 0)
        {
            e.unregisterListener(this);
        }
    }

    public void stopAllListeners()
    {
        b = 0;
        c = 0;
        d = 0;
        try
        {
            stop();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void stopTrackingHeading()
    {
        if (d > 0)
        {
            int i1 = d - 1;
            d = i1;
            if (i1 == 0)
            {
                stop();
            }
        }
    }

    public void stopTrackingShake()
    {
        if (c > 0)
        {
            int i1 = c - 1;
            c = i1;
            if (i1 == 0)
            {
                setSensorDelay(3);
                stop();
            }
        }
    }

    public void stopTrackingTilt()
    {
        if (b > 0)
        {
            int i1 = b - 1;
            b = i1;
            if (i1 == 0)
            {
                stop();
            }
        }
    }
}
