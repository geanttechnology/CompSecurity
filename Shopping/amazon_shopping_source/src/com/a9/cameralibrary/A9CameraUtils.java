// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;

import android.hardware.Camera;

public class A9CameraUtils
{

    public A9CameraUtils()
    {
    }

    public static boolean hasBackFacingCamera()
    {
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        int j = Camera.getNumberOfCameras();
        for (int i = 0; i < j; i++)
        {
            Camera.getCameraInfo(i, camerainfo);
            if (camerainfo.facing == 0)
            {
                return true;
            }
        }

        return false;
    }

    public static boolean hasFrontFacingCamera()
    {
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        int j = Camera.getNumberOfCameras();
        for (int i = 0; i < j; i++)
        {
            Camera.getCameraInfo(i, camerainfo);
            if (camerainfo.facing == 1)
            {
                return true;
            }
        }

        return false;
    }
}
