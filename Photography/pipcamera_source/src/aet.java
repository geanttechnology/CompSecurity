// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;
import jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView;

public class aet extends Handler
{

    public final Object a = new Object();
    private WeakReference b;

    public aet(CameraGLSurfaceView cameraglsurfaceview)
    {
        b = new WeakReference(cameraglsurfaceview);
    }

    public void handleMessage(Message message)
    {
        CameraGLSurfaceView cameraglsurfaceview;
        int i;
        i = message.what;
        cameraglsurfaceview = (CameraGLSurfaceView)b.get();
        if (cameraglsurfaceview != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (i)
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("unknown msg ").append(i).toString());

        case 0: // '\0'
            cameraglsurfaceview.setCameraParamSafe(message.arg1, message.arg2);
            return;

        case 1: // '\001'
            i = message.arg1;
            break;
        }
        Log.e("CameraGLSurfaceView", (new StringBuilder()).append("current fps = ").append(i).toString());
        message = cameraglsurfaceview.getCameraCallback();
        if (message != null)
        {
            message.b(i);
        }
        if (i >= 10)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!cameraglsurfaceview.adjustPreviewForFps(false)) goto _L1; else goto _L3
_L3:
        cameraglsurfaceview.restartCamera();
        return;
        if (i < 25 || !cameraglsurfaceview.adjustPreviewForFps(true)) goto _L1; else goto _L4
_L4:
        cameraglsurfaceview.restartCamera();
        return;
    }
}
