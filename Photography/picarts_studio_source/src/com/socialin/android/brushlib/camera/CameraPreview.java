// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.camera;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.socialin.android.d;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CameraPreview extends SurfaceView
    implements android.view.SurfaceHolder.Callback
{

    private static final String a = com/socialin/android/brushlib/camera/CameraPreview.getSimpleName();
    private Camera b;
    private int c;
    private int d;
    private final Comparator e = new Comparator() {

        private CameraPreview a;

        public final int compare(Object obj, Object obj1)
        {
            obj = (android.hardware.Camera.Size)obj;
            obj1 = (android.hardware.Camera.Size)obj1;
            int k = Math.abs(((android.hardware.Camera.Size) (obj1)).width - CameraPreview.a(a));
            int l = Math.abs(((android.hardware.Camera.Size) (obj1)).height - CameraPreview.b(a));
            int i = Math.abs(((android.hardware.Camera.Size) (obj)).width - CameraPreview.a(a));
            int j = Math.abs(((android.hardware.Camera.Size) (obj)).height - CameraPreview.b(a));
            k += l;
            i += j;
            if (k < i)
            {
                return -1;
            }
            return k != i ? 1 : 0;
        }

            
            {
                a = CameraPreview.this;
                super();
            }
    };

    public CameraPreview(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = getHolder();
        context.addCallback(this);
        context.setType(3);
    }

    static int a(CameraPreview camerapreview)
    {
        return camerapreview.c;
    }

    private final void a()
    {
        if (b != null)
        {
            b.release();
            b = null;
        }
    }

    static int b(CameraPreview camerapreview)
    {
        return camerapreview.d;
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        c = j;
        d = k;
        if (b == null) goto _L2; else goto _L1
_L1:
        android.hardware.Camera.Parameters parameters;
        Object obj;
        Camera camera;
        android.hardware.Camera.CameraInfo camerainfo;
        b.stopPreview();
        parameters = b.getParameters();
        obj = parameters.getSupportedPreviewSizes();
        Collections.sort(((List) (obj)), e);
        obj = (android.hardware.Camera.Size)((List) (obj)).get(0);
        parameters.setPreviewSize(((android.hardware.Camera.Size) (obj)).width, ((android.hardware.Camera.Size) (obj)).height);
        obj = (Activity)getContext();
        camera = b;
        camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(0, camerainfo);
        ((Activity) (obj)).getWindowManager().getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 152
    //                   0 214
    //                   1 219
    //                   2 225
    //                   3 232;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_232;
_L3:
        i = 0;
_L8:
        if (camerainfo.facing == 1)
        {
            i = (360 - (i + camerainfo.orientation) % 360) % 360;
        } else
        {
            i = ((camerainfo.orientation - i) + 360) % 360;
        }
        camera.setDisplayOrientation(i);
        b.setParameters(parameters);
        b.setPreviewDisplay(surfaceholder);
        b.startPreview();
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
        surfaceholder;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(surfaceholder.getMessage()).toString()
        });
        return;
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        if (b != null)
        {
            a();
        }
        b = Camera.open();
        try
        {
            b.setPreviewDisplay(getHolder());
            b.startPreview();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(surfaceholder.getMessage()).toString()
            });
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        a();
    }

}
