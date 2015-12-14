// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import java.lang.ref.WeakReference;
import jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView;

public class bzj
    implements android.hardware.Camera.PictureCallback
{

    final CameraGLSurfaceView a;

    public bzj(CameraGLSurfaceView cameraglsurfaceview)
    {
        a = cameraglsurfaceview;
        super();
    }

    public void onPictureTaken(byte abyte0[], Camera camera)
    {
        try
        {
            if (a.mCallbackWeakRef != null && a.mCallbackWeakRef.get() != null)
            {
                ((bzl)a.mCallbackWeakRef.get()).a(abyte0);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
        a.restartCameraPreview();
    }
}
