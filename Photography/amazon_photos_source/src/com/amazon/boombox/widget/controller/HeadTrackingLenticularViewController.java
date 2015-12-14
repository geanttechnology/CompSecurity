// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.widget.controller;

import android.content.Context;
import com.amazon.boombox.internal.util.ArgumentValidationUtil;
import com.amazon.boombox.internal.util.MathUtil;
import com.amazon.boombox.widget.LenticularView;
import com.amazon.headtracking.HeadTrackingEvent;
import com.amazon.headtracking.HeadTrackingListener;
import com.amazon.headtracking.HeadTrackingManager;

// Referenced classes of package com.amazon.boombox.widget.controller:
//            MotionTrackingLenticularViewController

public class HeadTrackingLenticularViewController
    implements MotionTrackingLenticularViewController, HeadTrackingListener
{

    private static final float FIELD_OF_VIEW_DEGREES = 60F;
    private Context mContext;
    private Float mCurrentProgressPercentage;
    private HeadTrackingManager mHeadTrackingManager;
    private boolean mIsLowSensitivity;
    private LenticularView mLenticularView;
    private float mSensitivityThreshold;

    public HeadTrackingLenticularViewController(Context context)
    {
        mIsLowSensitivity = false;
        mSensitivityThreshold = 0.4F;
        mCurrentProgressPercentage = null;
        ArgumentValidationUtil.validateNotNull(context, "context", com/amazon/boombox/widget/controller/HeadTrackingLenticularViewController);
        mContext = context;
    }

    private boolean withinSensitivityThreshold(double d)
    {
        while (mCurrentProgressPercentage == null || !mIsLowSensitivity || Math.abs((double)mCurrentProgressPercentage.floatValue() - d) >= (double)mSensitivityThreshold) 
        {
            return false;
        }
        return true;
    }

    public boolean isLowSensitivity()
    {
        return mIsLowSensitivity;
    }

    public void onHeadTrackingEvent(HeadTrackingEvent headtrackingevent)
    {
        if (mLenticularView != null && mLenticularView.getCount() != 0)
        {
            int i = mLenticularView.getOrientationOverride();
            double d;
            float f;
            if (i != 0)
            {
                if (i == 1)
                {
                    d = Math.atan2(headtrackingevent.x_mm, headtrackingevent.z_mm);
                } else
                {
                    d = Math.atan2(headtrackingevent.y_mm, headtrackingevent.z_mm);
                }
            } else
            {
                d = Math.atan2(headtrackingevent.x_mm, headtrackingevent.z_mm);
            }
            f = MathUtil.clamp((float)((30D + (double)(float)Math.toDegrees(d)) / 60D), 0.0F, 1.0F);
            if (!withinSensitivityThreshold(f))
            {
                mCurrentProgressPercentage = Float.valueOf(f);
                int j = (int)((float)mLenticularView.getCount() * f);
                mLenticularView.setPosition(j);
                return;
            }
        }
    }

    public void setIsLowSensitivity(boolean flag)
    {
        mIsLowSensitivity = flag;
    }

    public void setView(LenticularView lenticularview)
    {
        mLenticularView = lenticularview;
    }

    public void start()
    {
        mHeadTrackingManager = HeadTrackingManager.createInstance(mContext);
        mHeadTrackingManager.registerListener(this);
    }

    public void stop()
    {
        if (mHeadTrackingManager == null)
        {
            return;
        } else
        {
            mHeadTrackingManager.unregisterListener(this);
            return;
        }
    }
}
