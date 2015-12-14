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

public final class c
    implements android.hardware.aPreviewContainer._cls2
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
                camera.takePicture(null, null, new android.hardware.Camera.PictureCallback() {

                    final CameraPreviewContainer._cls2 a;

                    public final void onPictureTaken(byte abyte0[], Camera camera1)
                    {
                        a.a.set(true);
                        if (a.b != null)
                        {
                            ((Activity)a.d.getContext()).runOnUiThread(a.b);
                        }
                        CameraPreviewContainer.c(a.d).execute(new Runnable(this, abyte0) {

                            private byte a[];
                            private _cls1 b;

                            public final void run()
                            {
                                android.graphics.Bitmap bitmap;
                                boolean flag;
                                int j;
                                bitmap = BitmapFactory.decodeByteArray(a, 0, a.length);
                                j = m.a((Activity)b.a.d.getContext(), CameraPreviewContainer.a(b.a.d));
                                int i = CameraPreviewContainer.a(b.a.d);
                                if (android.os.Build.VERSION.SDK_INT < 9)
                                {
                                    break MISSING_BLOCK_LABEL_150;
                                }
                                android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
                                Camera.getCameraInfo(i, camerainfo);
                                if (camerainfo.facing != 1)
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
                                if (b.a.c != null)
                                {
                                    b.a.c.a(bitmap);
                                }
                                com.socialin.android.brushlib.camera.CameraPreviewContainer.b(b.a.d);
                                return;
                                flag = false;
                                  goto _L1
                            }

            
            {
                b = _pcls1;
                a = abyte0;
                super();
            }
                        });
                    }

            
            {
                a = CameraPreviewContainer._cls2.this;
                super();
            }
                });
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

    public _cls1.a(CameraPreviewContainer camerapreviewcontainer, AtomicBoolean atomicboolean, Runnable runnable, a a1)
    {
        d = camerapreviewcontainer;
        a = atomicboolean;
        b = runnable;
        c = a1;
        super();
    }
}
