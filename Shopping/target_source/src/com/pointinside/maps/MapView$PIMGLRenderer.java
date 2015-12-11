// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.pointinside.internal.utils.LogUtils;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.pointinside.maps:
//            MapView, PIMGLContext, PIMGL

private static class mPimglContext
    implements android.opengl.
{

    private final WeakReference mPimglContext;

    public void onDrawFrame(GL10 gl10)
    {
        gl10 = (PIMGLContext)mPimglContext.get();
        if (gl10 != null)
        {
            PIMGL.render(gl10);
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int j)
    {
        gl10 = (PIMGLContext)mPimglContext.get();
        if (gl10 != null)
        {
            PIMGL.display_setViewSize(gl10, i, j);
            LogUtils.logD(PIMGL.TAG, "PIMGLRenderer", "onSurfaceChanged");
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        gl10 = (PIMGLContext)mPimglContext.get();
        if (gl10 != null)
        {
            PIMGL.detectGfxContext(gl10);
            LogUtils.logD(PIMGL.TAG, "PIMGLRenderer", "onSurfaceCreated");
        }
    }

    (PIMGLContext pimglcontext)
    {
        mPimglContext = new WeakReference(pimglcontext);
    }
}
