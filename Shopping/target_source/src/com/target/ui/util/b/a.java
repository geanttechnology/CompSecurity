// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.b;

import android.hardware.Camera;

public class a
{

    public static boolean a()
    {
        return a(0);
    }

    private static boolean a(int i)
    {
        boolean flag1 = false;
        int k = Camera.getNumberOfCameras();
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        int j = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (j < k)
                {
                    Camera.getCameraInfo(j, camerainfo);
                    if (i != camerainfo.facing)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j++;
        } while (true);
    }
}
