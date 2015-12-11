// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;

final class cmw
{

    final float a[] = new float[16];
    Looper b;
    boolean c;
    Handler d;
    float e;
    float f;
    float g;
    float h;
    int i;
    float j;
    boolean k;
    long l;
    final float m[] = {
        -1F, 1.0F
    };
    private final SensorManager n;
    private SensorEventListener o;
    private boolean p;

    public cmw(Context context)
    {
        n = (SensorManager)context.getSystemService("sensor");
    }

    static float a(float f1, float f2, float f3)
    {
        if (f1 > f3)
        {
            return f3;
        }
        if (f1 < f2)
        {
            return f2;
        } else
        {
            return f1;
        }
    }

    final void a()
    {
        if (c)
        {
            return;
        }
        l = -1L;
        f = 0.0F;
        g = 0.0F;
        h = 0.0F;
        i = 0;
        j = -1F;
        k = true;
        if (o == null)
        {
            o = new cmx(this);
        }
        Thread thread = new Thread(new cmy(this));
        b(true);
        thread.start();
        c = true;
    }

    public final void a(boolean flag)
    {
        if (c)
        {
            b(flag);
        }
    }

    final void a(float af[])
    {
        synchronized (a)
        {
            if (k)
            {
                float f1 = a(e + f, -1.570796F, 1.570796F);
                e = f1 - f;
                Matrix.setIdentityM(a, 0);
                Matrix.rotateM(a, 0, (float)Math.toDegrees(-g), 0.0F, 1.0F, 0.0F);
                Matrix.rotateM(a, 0, (float)(-Math.toDegrees(f1)), 1.0F, 0.0F, 0.0F);
                k = false;
            }
            float af2[] = a;
            float af3[] = a;
            System.arraycopy(af2, 0, af, 0, 16);
        }
        return;
        af;
        af1;
        JVM INSTR monitorexit ;
        throw af;
    }

    void b(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (p) goto _L2; else goto _L3
_L3:
        android.hardware.Sensor sensor;
        android.hardware.Sensor sensor1;
        sensor = n.getDefaultSensor(9);
        sensor1 = n.getDefaultSensor(4);
        if (sensor == null || sensor1 == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        n.registerListener(o, sensor, 0, d);
        n.registerListener(o, sensor1, 0, d);
        p = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (p)
        {
            n.unregisterListener(o);
            p = false;
        }
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }
}
