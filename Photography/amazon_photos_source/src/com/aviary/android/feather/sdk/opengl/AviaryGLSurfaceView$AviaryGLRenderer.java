// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.opengl;

import android.util.Log;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.aviary.android.feather.sdk.opengl:
//            AviaryGLSurfaceView

private class <init>
    implements android.opengl.eView.AviaryGLRenderer
{

    private int mHeight;
    private int mWidth;
    final AviaryGLSurfaceView this$0;

    public void onDrawFrame(GL10 gl10)
    {
        AviaryGLSurfaceView.access$300().<init>("onDrawFrame");
    }

    public void onSurfaceChanged(GL10 gl10, int i, int j)
    {
        AviaryGLSurfaceView.access$300().<init>((new StringBuilder()).append("onSurfaceChanged. ").append(i).append("x").append(j).toString());
        boolean flag;
        if (mWidth != i || mHeight != j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mWidth = i;
        mHeight = j;
        AviaryGLSurfaceView.access$800(AviaryGLSurfaceView.this, flag, i, j);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        Log.d("GL", (new StringBuilder()).append("GL_RENDERER = ").append(gl10.glGetString(7937)).toString());
        Log.d("GL", (new StringBuilder()).append("GL_VENDOR = ").append(gl10.glGetString(7936)).toString());
        Log.d("GL", (new StringBuilder()).append("GL_VERSION = ").append(gl10.glGetString(7938)).toString());
        Log.i("GL", (new StringBuilder()).append("GL_EXTENSIONS = ").append(gl10.glGetString(7939)).toString());
        AviaryGLSurfaceView.access$300()._mth0("onSurfaceCreated");
        AviaryGLSurfaceView.access$900(AviaryGLSurfaceView.this);
    }

    private ()
    {
        this$0 = AviaryGLSurfaceView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
