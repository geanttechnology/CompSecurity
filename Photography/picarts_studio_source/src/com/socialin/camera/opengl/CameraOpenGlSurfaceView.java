// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.picsin.camera.CameraMainActivity;
import com.socialin.picsin.camera.view.c;
import java.util.HashMap;

// Referenced classes of package com.socialin.camera.opengl:
//            h, a, n

public class CameraOpenGlSurfaceView extends GLSurfaceView
{

    public boolean a;
    private h b;
    private Activity c;

    public CameraOpenGlSurfaceView(Activity activity)
    {
        super(activity);
        a = false;
        setEGLContextClientVersion(2);
        c = activity;
        setTag("CAMERA_OPENGL_SURFACEVIEW_TAG");
    }

    public CameraOpenGlSurfaceView(Context context)
    {
        super(context);
        a = false;
        setEGLContextClientVersion(2);
        setTag("CAMERA_OPENGL_SURFACEVIEW_TAG");
    }

    public CameraOpenGlSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = false;
        setEGLContextClientVersion(2);
        setTag("CAMERA_OPENGL_SURFACEVIEW_TAG");
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (c != null)
        {
            Object obj = (CameraMainActivity)c;
            if (((CameraMainActivity) (obj)).a != null && ((CameraMainActivity) (obj)).a.N())
            {
                obj = ((CameraMainActivity) (obj)).a.X();
                if (obj != null)
                {
                    ((ScaleGestureDetector) (obj)).onTouchEvent(motionevent);
                }
            }
        }
        return super.onTouchEvent(motionevent);
    }

    public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer)
    {
        super.setRenderer(renderer);
        b = (h)renderer;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        super.surfaceDestroyed(surfaceholder);
        if (b != null && (c.isFinishing() || a))
        {
            surfaceholder = b;
            surfaceholder.e = true;
            if (!((h) (surfaceholder)).z)
            {
                if (((h) (surfaceholder)).d != null)
                {
                    ImageOpCommon.freeNativeBuffer(((h) (surfaceholder)).d);
                    surfaceholder.d = null;
                }
                if (((h) (surfaceholder)).t != null)
                {
                    ImageOpCommon.freeNativeBuffer(((h) (surfaceholder)).t);
                    surfaceholder.t = null;
                }
                if (((h) (surfaceholder)).o != null)
                {
                    ImageOpCommon.freeNativeBuffer(((h) (surfaceholder)).o);
                    surfaceholder.o = null;
                }
                if (((h) (surfaceholder)).i && ((h) (surfaceholder)).a != null)
                {
                    surfaceholder = ((h) (surfaceholder)).a;
                    if (((a) (surfaceholder)).p != null)
                    {
                        n n1 = ((a) (surfaceholder)).p;
                        ((a) (surfaceholder)).b.get(Integer.valueOf(((a) (surfaceholder)).c));
                        n1.b();
                        ((a) (surfaceholder)).p.c();
                    }
                }
            }
        }
    }
}
