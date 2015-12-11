// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

final class cmx
    implements SensorEventListener
{

    private cmw a;

    cmx(cmw cmw1)
    {
        a = cmw1;
        super();
    }

    public final void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public final void onSensorChanged(SensorEvent sensorevent)
    {
        cmw cmw1 = a;
        if (sensorevent.sensor.getType() != 9) goto _L2; else goto _L1
_L1:
        float f3 = sensorevent.values[0];
        float f4 = sensorevent.values[1];
        float f2 = sensorevent.values[2];
        int i;
        if (Math.abs(f3) > 4.903325F)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        cmw1.i = i;
        if (cmw1.i == 0)
        {
            double d;
            float f;
            if (f3 < 0.0F)
            {
                f = cmw1.m[1];
            } else
            {
                f = cmw1.m[0];
            }
            cmw1.j = f;
            cmw1.h = (float)Math.atan2(f4, 9.8066501617431641D);
        } else
        {
            float f1;
            if (f4 > 0.0F)
            {
                f1 = cmw1.m[0];
            } else
            {
                f1 = cmw1.m[1];
            }
            cmw1.j = f1;
            cmw1.h = (float)Math.atan2(f3, 9.8066501617431641D);
        }
        af = cmw1.a;
        af;
        JVM INSTR monitorenter ;
        f = (1.570796F * f2) / 9.80665F;
        cmw1.f = f;
        cmw1.k = true;
        af;
        JVM INSTR monitorexit ;
_L2:
        if (sensorevent.sensor.getType() == 4)
        {
            if (cmw1.l != -1L)
            {
                f = sensorevent.values[cmw1.i];
                d = (float)(sensorevent.timestamp - cmw1.l) * 1E-09F;
                synchronized (cmw1.a)
                {
                    f2 = cmw1.g;
                    f3 = cmw1.j;
                    cmw1.g = cmw.a((float)(d * (double)f), -0.1F, 0.1F) * f3 + f2;
                    cmw1.k = true;
                }
            }
            cmw1.l = sensorevent.timestamp;
        }
        return;
        sensorevent;
        af;
        JVM INSTR monitorexit ;
        throw sensorevent;
        sensorevent;
        af;
        JVM INSTR monitorexit ;
        throw sensorevent;
    }
}
