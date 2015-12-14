// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.graphics.Bitmap;
import android.util.Log;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public final class i
{

    android.opengl.GLSurfaceView.Renderer a;
    int b;
    int c;
    Bitmap d;
    EGL10 e;
    EGLDisplay f;
    EGLConfig g;
    EGLContext h;
    EGLSurface i;
    GL10 j;
    String k;
    private EGLConfig l[];

    public i(int i1, int j1)
    {
        b = i1;
        c = j1;
        int ai[] = new int[2];
        i1 = b;
        j1 = c;
        e = (EGL10)EGLContext.getEGL();
        f = e.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        e.eglInitialize(f, ai);
        ai = new int[15];
        int[] _tmp = ai;
        ai[0] = 12325;
        ai[1] = 0;
        ai[2] = 12326;
        ai[3] = 0;
        ai[4] = 12324;
        ai[5] = 8;
        ai[6] = 12323;
        ai[7] = 8;
        ai[8] = 12322;
        ai[9] = 8;
        ai[10] = 12321;
        ai[11] = 8;
        ai[12] = 12352;
        ai[13] = 4;
        ai[14] = 12344;
        int ai1[] = new int[1];
        e.eglChooseConfig(f, ai, null, 0, ai1);
        int k1 = ai1[0];
        l = new EGLConfig[k1];
        e.eglChooseConfig(f, ai, l, k1, ai1);
        g = l[0];
        h = e.eglCreateContext(f, g, EGL10.EGL_NO_CONTEXT, new int[] {
            12440, 2, 12344
        });
        i = e.eglCreatePbufferSurface(f, g, new int[] {
            12375, i1, 12374, j1, 12344
        });
        e.eglMakeCurrent(f, i, i, h);
        j = (GL10)h.getGL();
        k = Thread.currentThread().getName();
    }

    final ByteBuffer a()
    {
        Log.e("ex1", "convertToBuffer() START");
        ByteBuffer bytebuffer = ImageOpCommon.allocNativeBuffer(b * c * 4);
        bytebuffer.position(0);
        j.glReadPixels(0, 0, b, c, 6408, 5121, bytebuffer);
        ImageOpCommon.reverseBitmap(bytebuffer, b, c);
        Log.e("ex1", "convertToBuffer() END");
        return bytebuffer;
    }
}
