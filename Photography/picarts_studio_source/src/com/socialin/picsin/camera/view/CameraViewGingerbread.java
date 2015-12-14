// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import java.io.IOException;
import myobfuscated.de.b;

// Referenced classes of package com.socialin.picsin.camera.view:
//            CameraViewCupcake

public class CameraViewGingerbread extends CameraViewCupcake
{

    private int r;

    public CameraViewGingerbread(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        j = true;
    }

    public CameraViewGingerbread(android.view.ViewGroup.LayoutParams layoutparams, Activity activity, b b)
    {
        super(layoutparams, activity, b);
        j = true;
    }

    private Camera Y()
    {
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        int j = Camera.getNumberOfCameras();
        setOrientation(camerainfo.orientation);
        Camera camera = null;
        int i = 0;
        do
        {
            if (i >= j)
            {
                break;
            }
            Camera.getCameraInfo(i, camerainfo);
            Camera camera1 = camera;
            if (camerainfo.facing == 1)
            {
                try
                {
                    camera1 = Camera.open(i);
                }
                catch (RuntimeException runtimeexception)
                {
                    Log.e("CameraView", (new StringBuilder("Camera failed to open: ")).append(runtimeexception.getLocalizedMessage()).toString());
                    runtimeexception = camera;
                }
            }
            i++;
            camera = camera1;
        } while (true);
        return camera;
    }

    public void setCameraIndex(int i)
    {
        r = i;
    }

    public void setOrientation(int i)
    {
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        super.surfaceChanged(surfaceholder, i, j, k);
        M();
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        boolean flag;
        flag = false;
        l = false;
        if (a != null) goto _L2; else goto _L1
_L1:
        if (r != 0) goto _L4; else goto _L3
_L3:
        a = Camera.open();
        if (a == null)
        {
            a = Camera.open(0);
        }
_L14:
        if (h) goto _L6; else goto _L5
_L5:
        Activity activity;
        android.hardware.Camera.CameraInfo camerainfo;
        activity = p;
        int i = r;
        camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(i, camerainfo);
        int j = ((flag) ? 1 : 0);
        activity.getWindowManager().getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 298
    //                   0 124
    //                   1 229
    //                   2 236
    //                   3 244;
           goto _L7 _L8 _L9 _L10 _L11
_L8:
        if (camerainfo.facing != 1) goto _L13; else goto _L12
_L12:
        j = (360 - (j + camerainfo.orientation) % 360) % 360;
_L15:
        g = j;
        h = true;
_L6:
        a.setDisplayOrientation(g);
        a.setPreviewDisplay(b);
        this.i = false;
_L16:
        d.surfaceCreated(surfaceholder);
        return;
_L4:
        try
        {
            a = Y();
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            surfaceholder.printStackTrace();
            d.surfaceCreated(null);
            return;
        }
          goto _L14
_L9:
        j = 90;
          goto _L8
_L10:
        j = 180;
          goto _L8
_L11:
        j = 270;
          goto _L8
_L13:
        j = ((camerainfo.orientation - j) + 360) % 360;
          goto _L15
_L2:
        a();
        try
        {
            a.setPreviewDisplay(b);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
          goto _L16
_L7:
        j = ((flag) ? 1 : 0);
          goto _L8
    }

    public final int u()
    {
        return Camera.getNumberOfCameras();
    }

    public final int v()
    {
        if (Camera.getNumberOfCameras() == 1 && z())
        {
            return 1;
        } else
        {
            return r;
        }
    }

    public final boolean z()
    {
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(r, camerainfo);
        return camerainfo.facing == 1;
    }
}
