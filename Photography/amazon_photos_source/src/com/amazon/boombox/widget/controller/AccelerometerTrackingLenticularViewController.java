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

public class AccelerometerTrackingLenticularViewController
    implements SensorEventListener, MotionTrackingLenticularViewController
{

    private Sensor mAccelerometorSensor;
    private Context mContext;
    private Float mCurrentProgressPercentage;
    private Display mDisplay;
    private boolean mIsLowSensitivity;
    private LenticularView mLenticularView;
    private float mSensitivityThreshold;
    private SensorManager mSensorManager;

    public AccelerometerTrackingLenticularViewController(Context context)
    {
        mIsLowSensitivity = false;
        mSensitivityThreshold = 0.4F;
        mCurrentProgressPercentage = null;
        ArgumentValidationUtil.validateNotNull(context, "context", com/amazon/boombox/widget/controller/AccelerometerTrackingLenticularViewController);
        mContext = context;
        mDisplay = ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay();
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
_L2:
        return;
        if (mLenticularView == null || mLenticularView.getCount() == 0) goto _L2; else goto _L1
_L1:
        float f;
        float f1;
        float f2;
        f = (2.2F * sensorevent.values[0] + 9.80665F) / 19.6133F;
        f1 = (2.2F * sensorevent.values[1] + 9.80665F) / 19.6133F;
        f2 = 0.0F;
        boolean flag;
        if (mLenticularView.getOrientationOverride() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (mLenticularView.getOrientationOverride() != 1)
        {
            f = f1;
        }
_L4:
        f = MathUtil.clamp(f, 0.0F, 1.0F);
        if (!withinSensitivityThreshold(f))
        {
            mCurrentProgressPercentage = Float.valueOf(f);
            mLenticularView.setPosition((int)((float)mLenticularView.getCount() * f));
            return;
        }
        if (true) goto _L2; else goto _L3
_L3:
        int i = mDisplay.getRotation();
        if (i != 0)
        {
            if (i == 1)
            {
                f = 1.0F - f1;
            } else
            if (i == 2)
            {
                f = 1.0F - f;
            } else
            {
                f = f2;
                if (i == 3)
                {
                    f = f1;
                }
            }
        }
          goto _L4
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void setView(LenticularView lenticularview)
    {
        mLenticularView = lenticularview;
    }

    public void start()
    {
        if (mAccelerometorSensor != null)
        {
            mSensorManager.unregisterListener(this);
        }
        mSensorManager = (SensorManager)mContext.getSystemService("sensor");
        mAccelerometorSensor = mSensorManager.getDefaultSensor(1);
        mSensorManager.registerListener(this, mAccelerometorSensor, 3);
    }

    public void stop()
    {
        if (mAccelerometorSensor != null)
        {
            mSensorManager.unregisterListener(this);
        }
    }
}
