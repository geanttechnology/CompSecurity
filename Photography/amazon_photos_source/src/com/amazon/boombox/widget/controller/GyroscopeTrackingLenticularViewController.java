// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.widget.controller;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;
import com.amazon.boombox.internal.util.ArgumentValidationUtil;
import com.amazon.boombox.internal.util.MathUtil;
import com.amazon.boombox.widget.LenticularView;

// Referenced classes of package com.amazon.boombox.widget.controller:
//            MotionTrackingLenticularViewController

public class GyroscopeTrackingLenticularViewController
    implements SensorEventListener, MotionTrackingLenticularViewController
{

    private Context mContext;
    private Float mCurrentProgressPercentage;
    private Display mDisplay;
    private Sensor mGyroscopeSensor;
    private boolean mIsLowSensitivity;
    private long mLastMeasuredTimestamp;
    private LenticularView mLenticularView;
    private float mSensitivityThreshold;
    private SensorManager mSensorManager;
    private float mXAccumulationDegrees;
    private float mYAccumulationDegrees;

    public GyroscopeTrackingLenticularViewController(Context context)
    {
        mLastMeasuredTimestamp = 0L;
        mXAccumulationDegrees = 0.0F;
        mYAccumulationDegrees = 0.0F;
        mIsLowSensitivity = false;
        mSensitivityThreshold = 0.4F;
        mCurrentProgressPercentage = null;
        ArgumentValidationUtil.validateNotNull(context, "context", com/amazon/boombox/widget/controller/GyroscopeTrackingLenticularViewController);
        mContext = context;
        mDisplay = ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay();
    }

    private float calculateProgress(float f)
    {
        return MathUtil.clamp(1.0F - (30F + f) / 60F, 0.0F, 1.0F);
    }

    private void updateAccumulations(double d, double d1)
    {
        mXAccumulationDegrees = (float)((double)mXAccumulationDegrees + d);
        mXAccumulationDegrees = MathUtil.clamp(mXAccumulationDegrees, -30F, 30F);
        mYAccumulationDegrees = (float)((double)mYAccumulationDegrees + d1);
        mYAccumulationDegrees = MathUtil.clamp(mYAccumulationDegrees, -30F, 30F);
    }

    private boolean withinSensitivityThreshold(double d)
    {
        while (mCurrentProgressPercentage == null || !mIsLowSensitivity || Math.abs((double)mCurrentProgressPercentage.floatValue() - d) >= (double)mSensitivityThreshold) 
        {
            return false;
        }
        return true;
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        boolean flag = false;
        if (mLenticularView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        float f;
        if (mLastMeasuredTimestamp == 0L)
        {
            mLastMeasuredTimestamp = sensorevent.timestamp;
            return;
        }
        if (mLenticularView.getCount() == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        f = (float)(sensorevent.timestamp - mLastMeasuredTimestamp) / 1E+09F;
        float f1 = sensorevent.values[0];
        float f2 = sensorevent.values[1];
        updateAccumulations(Math.toDegrees(f1 * f), Math.toDegrees(f2 * f));
        f = 0.0F;
        if (mLenticularView.getOrientationOverride() != 0)
        {
            flag = true;
        }
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (mLenticularView.getOrientationOverride() == 1)
        {
            f = calculateProgress(mYAccumulationDegrees);
        } else
        {
            f = calculateProgress(mXAccumulationDegrees);
        }
_L4:
        if (!withinSensitivityThreshold(f))
        {
            mCurrentProgressPercentage = Float.valueOf(f);
            mLenticularView.setPosition((int)((float)mLenticularView.getCount() * f));
            mLastMeasuredTimestamp = sensorevent.timestamp;
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        int i = mDisplay.getRotation();
        if (i == 0)
        {
            f = calculateProgress(mYAccumulationDegrees);
        } else
        if (i == 1)
        {
            f = calculateProgress(mXAccumulationDegrees);
        } else
        if (i == 2)
        {
            f = 1.0F - calculateProgress(mYAccumulationDegrees);
        } else
        if (i == 3)
        {
            f = 1.0F - calculateProgress(mXAccumulationDegrees);
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setView(LenticularView lenticularview)
    {
        mLenticularView = lenticularview;
    }

    public void start()
    {
        if (mGyroscopeSensor != null)
        {
            mSensorManager.unregisterListener(this);
        }
        mSensorManager = (SensorManager)mContext.getSystemService("sensor");
        mGyroscopeSensor = mSensorManager.getDefaultSensor(4);
        mSensorManager.registerListener(this, mGyroscopeSensor, 3);
        mXAccumulationDegrees = 0.0F;
        mYAccumulationDegrees = 0.0F;
    }

    public void stop()
    {
        if (mGyroscopeSensor != null)
        {
            mSensorManager.unregisterListener(this);
        }
    }
}
