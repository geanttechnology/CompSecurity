// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.widget.controller;

import android.content.Context;
import com.amazon.boombox.util.DeviceCapabilities;

// Referenced classes of package com.amazon.boombox.widget.controller:
//            HeadTrackingLenticularViewController, GyroscopeTrackingLenticularViewController, AccelerometerTrackingLenticularViewController, AutoPlayLenticularViewController, 
//            LenticularViewController

public class LenticularViewControllerFactory
{

    public static LenticularViewController getDefaultController(Context context)
    {
        if (DeviceCapabilities.supportsHeadTrackingSensor())
        {
            return new HeadTrackingLenticularViewController(context);
        }
        if (DeviceCapabilities.supportsGyroscopeSensor(context))
        {
            return new GyroscopeTrackingLenticularViewController(context);
        }
        if (DeviceCapabilities.supportsAccelerometorSensor(context))
        {
            return new AccelerometerTrackingLenticularViewController(context);
        } else
        {
            return new AutoPlayLenticularViewController();
        }
    }
}
