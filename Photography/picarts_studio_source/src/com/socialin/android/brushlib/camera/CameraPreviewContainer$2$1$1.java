// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.camera;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.brushlib.camera:
//            CameraPreviewContainer, a

final class a
    implements Runnable
{

    private byte a[];
    private b b;

    public final void run()
    {
        android.graphics.Bitmap bitmap;
        boolean flag;
        int j;
        bitmap = BitmapFactory.decodeByteArray(a, 0, a.length);
        j = m.a((Activity)b.b.b.getContext(), CameraPreviewContainer.a(b.b.b));
        int i = CameraPreviewContainer.a(b.b.b);
        if (android.os.eraPreviewContainer._cls2.d < 9)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        android.hardware.viewContainer viewcontainer = new android.hardware.viewContainer._cls2.d();
        Camera.getCameraInfo(i, viewcontainer);
        if (viewcontainer.d != 1)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        flag = true;
_L1:
        if (!flag)
        {
            bitmap = com.socialin.android.brushlib.util.b.a(bitmap, j, false, false);
        } else
        if ((j / 90) % 2 == 1)
        {
            bitmap = com.socialin.android.brushlib.util.b.a(bitmap, j, false, true);
        } else
        {
            bitmap = com.socialin.android.brushlib.util.b.a(bitmap, j, true, false);
        }
        if (b.b.b != null)
        {
            b.b.b.a(bitmap);
        }
        com.socialin.android.brushlib.camera.CameraPreviewContainer.b(b.b.b);
        return;
        flag = false;
          goto _L1
    }

    ( , byte abyte0[])
    {
        b = ;
        a = abyte0;
        super();
    }

    // Unreferenced inner class com/socialin/android/brushlib/camera/CameraPreviewContainer$2

/* anonymous class */
    public final class CameraPreviewContainer._cls2
        implements android.hardware.Camera.AutoFocusCallback
    {

        final AtomicBoolean a;
        final Runnable b;
        final a c;
        final CameraPreviewContainer d;

        public final void onAutoFocus(boolean flag, Camera camera)
        {
            if (!a.get())
            {
                try
                {
                    camera.takePicture(null, null, new CameraPreviewContainer._cls2._cls1(this));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Camera camera)
                {
                    com.socialin.android.d.b(com.socialin.android.brushlib.camera.CameraPreviewContainer.d(), new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(camera.getMessage()).toString()
                    });
                }
                if (b != null)
                {
                    ((Activity)d.getContext()).runOnUiThread(b);
                }
                if (c != null)
                {
                    c.a(null);
                    return;
                }
            }
        }

            public 
            {
                d = camerapreviewcontainer;
                a = atomicboolean;
                b = runnable;
                c = a1;
                super();
            }
    }


    // Unreferenced inner class com/socialin/android/brushlib/camera/CameraPreviewContainer$2$1

/* anonymous class */
    final class CameraPreviewContainer._cls2._cls1
        implements android.hardware.Camera.PictureCallback
    {

        final CameraPreviewContainer._cls2 a;

        public final void onPictureTaken(byte abyte0[], Camera camera)
        {
            a.a.set(true);
            if (a.b != null)
            {
                ((Activity)a.d.getContext()).runOnUiThread(a.b);
            }
            CameraPreviewContainer.c(a.d).execute(new CameraPreviewContainer._cls2._cls1._cls1(this, abyte0));
        }

            
            {
                a = _pcls2;
                super();
            }
    }

}
