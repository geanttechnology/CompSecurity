// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;

public class sw
    implements st
{

    public sw()
    {
    }

    private int e(int i)
    {
        int k = Camera.getNumberOfCameras();
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        for (int j = 0; j < k; j++)
        {
            Camera.getCameraInfo(j, camerainfo);
            if (camerainfo.facing == i)
            {
                return j;
            }
        }

        return -1;
    }

    public int a()
    {
        return Camera.getNumberOfCameras();
    }

    public Camera a(int i)
    {
        return Camera.open(i);
    }

    public void a(int i, su su1)
    {
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(i, camerainfo);
        su1.a = camerainfo.facing;
        su1.b = camerainfo.orientation;
    }

    public boolean b(int i)
    {
        return e(i) != -1;
    }

    public int c(int i)
    {
        return e(1);
    }

    public int d(int i)
    {
        return e(0);
    }
}
