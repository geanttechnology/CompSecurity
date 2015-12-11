// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.medialets.advertising:
//            r, AdManager, AdManagerService, a

final class t
{
    static interface a
    {

        public abstract void onOrientationChange(int i);
    }


    private static t d;
    int a;
    private SensorManager b;
    private Vector c;
    private SensorEventListener e;

    private t()
    {
        e = new r(this);
        b = (SensorManager)AdManager.getInstance().mService.getSystemService("sensor");
        c = new Vector();
    }

    public static t a()
    {
        if (d == null)
        {
            d = new t();
        }
        return d;
    }

    static Vector a(t t1)
    {
        return t1.c;
    }

    public final void a(a a1)
    {
        if (!c.contains(a1))
        {
            c.add(a1);
        }
        if (c.size() > 0)
        {
            a1 = b.getSensorList(1);
            b.registerListener(e, (Sensor)a1.get(0), 3);
        }
    }

    public final void b(a a1)
    {
        if (c.contains(a1))
        {
            c.remove(a1);
        }
        if (c.size() == 0)
        {
            com.medialets.advertising.a.d("Unregistering the orientation sensor.");
            b.unregisterListener(e);
        }
    }

    protected final int getOrientation()
    {
        return a;
    }

    // Unreferenced inner class com/medialets/advertising/r
    final class r
        implements SensorEventListener
    {

        private t a;

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
                for (sensorevent = t.a(a).iterator(); sensorevent.hasNext(); ((a)sensorevent.next()).onOrientationChange(a.a)) { }
            }
        }

            r()
            {
                a = t.this;
                super();
            }
    }

}
