// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.base.BBYApplication;

public class nq
    implements SensorEventListener
{

    private float a;
    private float b[];
    private double c;
    private double d;
    private float e;

    public nq()
    {
        a = 9.80665F;
        c = 64D;
        d = 25D;
        e = 13F;
    }

    void a(SensorEvent sensorevent)
    {
        if (nb.a().b().getString("shake_your_device", toString()).equals("On"))
        {
            if (sensorevent.sensor.getType() == 1)
            {
                b = a((float[])sensorevent.values.clone(), b);
            }
            if (b != null)
            {
                float f = b[0];
                float f1 = b[1];
                float f2 = b[2];
                double d1 = f * f;
                double d2 = f1 * f1;
                double d3 = f2 * f2;
                a = (float)Math.sqrt(d1 + d2 + d3);
                if (a > e && (d1 > c && d2 > c && d3 > d || d1 > c && d2 > d && d3 > c || d1 > d && d2 > c && d3 > c))
                {
                    sensorevent = new Intent(BBYApplication.getInstance().getBaseContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
                    sensorevent.putExtra(nb.k, nb.n);
                    sensorevent.addFlags(0x14000000);
                    BBYApplication.getInstance().getBaseContext().startActivity(sensorevent);
                }
            }
        }
    }

    protected float[] a(float af[], float af1[])
    {
        if (af1 == null)
        {
            return af;
        }
        for (int i = 0; i < af.length; i++)
        {
            af1[i] = af1[i] + 0.25F * (af[i] - af1[i]);
        }

        return af1;
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        a(sensorevent);
    }
}
