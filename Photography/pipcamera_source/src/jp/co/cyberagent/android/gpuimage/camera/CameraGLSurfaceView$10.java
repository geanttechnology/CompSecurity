// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import aeu;
import android.hardware.Camera;
import java.lang.ref.WeakReference;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            CameraGLSurfaceView

class a
    implements android.hardware..CameraGLSurfaceView._cls10
{

    final CameraGLSurfaceView a;

    public void onPictureTaken(byte abyte0[], Camera camera)
    {
        try
        {
            if (a.mCallbackWeakRef != null && a.mCallbackWeakRef.get() != null)
            {
                ((aeu)a.mCallbackWeakRef.get()).a(abyte0);
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

    (CameraGLSurfaceView cameraglsurfaceview)
    {
        a = cameraglsurfaceview;
        super();
    }
}
