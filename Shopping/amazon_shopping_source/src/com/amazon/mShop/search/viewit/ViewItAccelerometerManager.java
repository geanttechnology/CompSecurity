// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            FSECameraActivity, CameraBgHelper

public class ViewItAccelerometerManager
    implements SensorEventListener
{

    private float mAccelerometerThreshold;
    private FSECameraActivity mActivity;
    private boolean mIsRunning;
    private boolean mIsSteady;
    private float mLastAccelX;
    private float mLastAccelY;
    private float mLastAccelZ;
    private boolean mLastSteadyStatus;
    private SensorManager mSensorManager;
    private int mSteadinessThreshold;
    private int mSteadyFrames;

    public ViewItAccelerometerManager(FSECameraActivity fsecameraactivity)
    {
        mLastSteadyStatus = true;
        mActivity = fsecameraactivity;
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        boolean flag = true;
        float f3 = sensorevent.values[0];
        float f4 = sensorevent.values[1];
        float f5 = sensorevent.values[2];
        float f = Math.abs(mLastAccelX - f3);
        float f1 = Math.abs(mLastAccelY - f4);
        float f2 = Math.abs(mLastAccelZ - f5);
        mLastAccelX = f3;
        mLastAccelY = f4;
        mLastAccelZ = f5;
        f3 = mAccelerometerThreshold;
        boolean flag1;
        if (f >= f3 || f1 >= f3 || f2 >= f3)
        {
            flag = false;
        }
        flag1 = false;
        this;
        JVM INSTR monitorenter ;
        if (!mIsRunning) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        if (mSteadyFrames < mSteadinessThreshold) goto _L4; else goto _L3
_L3:
        flag1 = true;
_L5:
        mIsSteady = flag1;
        if (mIsSteady != mLastSteadyStatus)
        {
            mLastSteadyStatus = mIsSteady;
            mActivity.getCameraBgHelper().updateSteadyStatus(mIsSteady);
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        mSteadyFrames = mSteadyFrames + 1;
          goto _L5
        sensorevent;
        this;
        JVM INSTR monitorexit ;
        throw sensorevent;
        mSteadyFrames = 0;
          goto _L5
    }

    public void start()
    {
        boolean flag1 = false;
        mAccelerometerThreshold = 2.0F;
        mSteadinessThreshold = 5;
        mLastAccelX = 0.0F;
        mLastAccelY = 0.0F;
        mLastAccelZ = 0.0F;
        mSteadyFrames = 0;
        mIsRunning = true;
        mIsSteady = false;
        mSensorManager = (SensorManager)mActivity.getSystemService("sensor");
        Sensor sensor = mSensorManager.getDefaultSensor(1);
        boolean flag = flag1;
        if (sensor != null)
        {
            flag = flag1;
            if (mSensorManager.registerListener(this, sensor, 3))
            {
                flag = true;
            }
        }
        if (!flag)
        {
            mIsSteady = true;
        }
    }

    public void stop()
    {
        this;
        JVM INSTR monitorenter ;
        mIsRunning = false;
        this;
        JVM INSTR monitorexit ;
        if (mSensorManager != null)
        {
            mSensorManager.unregisterListener(this);
        }
        mSensorManager = null;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
