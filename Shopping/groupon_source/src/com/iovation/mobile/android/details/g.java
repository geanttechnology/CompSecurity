// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class g
    implements i
{

    public g()
    {
    }

    public void a(Context context, j j1)
    {
        if (android.os.Build.VERSION.SDK_INT < 21) goto _L2; else goto _L1
_L1:
        int k;
        CameraManager cameramanager;
        Object obj;
        Integer integer;
        try
        {
            cameramanager = (CameraManager)context.getSystemService("camera");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        context = "{";
        k = 0;
_L3:
        if (k >= cameramanager.getCameraIdList().length)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        obj = cameramanager.getCameraCharacteristics(cameramanager.getCameraIdList()[k]);
        integer = (Integer)((CameraCharacteristics) (obj)).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        if (integer.intValue() != 1)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        obj = String.valueOf(((CameraCharacteristics) (obj)).get(CameraCharacteristics.SENSOR_CALIBRATION_TRANSFORM1));
        if (((String) (obj)).equals("null"))
        {
            break MISSING_BLOCK_LABEL_181;
        }
        context = (new StringBuilder()).append(context).append("'").append(k).append("':'").append(((String) (obj))).append("';").toString();
        break MISSING_BLOCK_LABEL_181;
        if (context.equals("{"))
        {
            return;
        }
        j1.a("ACAT", (new StringBuilder()).append(context).append("}").toString());
        return;
        k++;
        if (true) goto _L3; else goto _L2
_L2:
    }
}
