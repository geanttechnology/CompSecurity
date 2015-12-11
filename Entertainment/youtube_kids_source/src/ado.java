// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.hardware.Camera;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.WindowManager;

public abstract class ado
{

    private Camera camera;
    private int cameraId;
    private int cameraOrientation;
    private final Context context;
    private final OrientationEventListener orientationListener;
    private View previewView;

    public ado(Context context1, Camera camera1, int i)
    {
        context = (Context)b.a(context1);
        previewView = createPreviewView(context1);
        setCamera(camera1, i);
        orientationListener = new adp(this, context1);
    }

    private void updateCameraDisplayOrientation()
    {
        int j = 0;
        if (camera == null) goto _L2; else goto _L1
_L1:
        android.hardware.Camera.CameraInfo camerainfo;
        camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(cameraId, camerainfo);
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 76
    //                   0 119
    //                   1 124
    //                   2 130
    //                   3 137;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_137;
_L3:
        int i = 0;
_L8:
        if (camerainfo.facing == 1)
        {
            j = (360 - (i + camerainfo.orientation) % 360) % 360;
        } else
        if (camerainfo.facing == 0)
        {
            j = ((camerainfo.orientation - i) + 360) % 360;
        }
        cameraOrientation = j;
        camera.setDisplayOrientation(j);
_L2:
        return;
_L4:
        i = 0;
          goto _L8
_L5:
        i = 90;
          goto _L8
_L6:
        i = 180;
          goto _L8
        i = 270;
          goto _L8
    }

    protected abstract View createPreviewView(Context context1);

    protected Camera getCamera()
    {
        return camera;
    }

    public int getCameraOrientation()
    {
        return cameraOrientation;
    }

    public View getPreviewView()
    {
        return previewView;
    }

    protected void onPreviewCreated()
    {
        updateCameraDisplayOrientation();
        orientationListener.enable();
    }

    protected void onPreviewDestroyed()
    {
        orientationListener.disable();
    }

    public void setCamera(Camera camera1, int i)
    {
        camera = camera1;
        cameraId = i;
        startPreview();
    }

    protected abstract void startPreview();

}
