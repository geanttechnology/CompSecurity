// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

public class SensorController extends BroadcastReceiver
    implements SensorEventListener
{

    private static float aR = 4.294967E+09F;
    private static float aU = 0.5F;
    private SensorManager aS;
    private float aT;
    private SensorEventCallBack aV;
    private Sensor aW;
    private final boolean aX;
    private boolean aY;
    private boolean aZ;

    public SensorController(Context context)
    {
        aY = false;
        aZ = false;
        aS = (SensorManager)context.getSystemService("sensor");
        aW = aS.getDefaultSensor(8);
        boolean flag;
        if (aW != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aX = flag;
        aT = aU + 1.0F;
    }

    public boolean isSensorEnable()
    {
        return aX;
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG"))
        {
            int i = intent.getIntExtra("state", 0);
            if (i == 1)
            {
                aY = true;
            }
            if (i == 0)
            {
                aY = false;
            }
        }
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        float f;
        if (aY)
        {
            return;
        }
        f = sensorevent.values[0];
        switch (sensorevent.sensor.getType())
        {
        default:
            return;

        case 8: // '\b'
            break;
        }
        if (f < aR)
        {
            aR = f;
            aU = 0.5F + f;
        }
        if (aT < aU || f >= aU) goto _L2; else goto _L1
_L1:
        if (aV != null)
        {
            Log.v("MicroMsg.SensorController", "sensor event false");
            aV.onSensorEvent(false);
        }
_L4:
        aT = f;
        return;
_L2:
        if (aT <= aU && f > aU && aV != null)
        {
            Log.v("MicroMsg.SensorController", "sensor event true");
            aV.onSensorEvent(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void removeSensorCallBack()
    {
        Log.v("MicroMsg.SensorController", "sensor callback removed");
        aS.unregisterListener(this, aW);
        aS.unregisterListener(this);
        aZ = false;
        aV = null;
    }

    public void setSensorCallBack(SensorEventCallBack sensoreventcallback)
    {
        Log.v("MicroMsg.SensorController", "sensor callback set");
        if (!aZ)
        {
            aS.registerListener(this, aW, 2);
            aZ = true;
        }
        aV = sensoreventcallback;
    }


    private class SensorEventCallBack
    {

        public abstract void onSensorEvent(boolean flag);
    }

}
