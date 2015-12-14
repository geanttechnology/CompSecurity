// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class ag
{

    android.opengl.GLSurfaceView.Renderer a;
    int b;
    int c;
    Bitmap d;
    EGL10 e;
    EGLDisplay f;
    EGLConfig g[];
    EGLConfig h;
    EGLContext i;
    EGLSurface j;
    GL10 k;
    String l;

    public ag(int i1, int j1, EGLContext eglcontext)
    {
        b = i1;
        c = j1;
        int ai[] = new int[2];
        i1 = b;
        j1 = c;
        e = (EGL10)EGLContext.getEGL();
        f = e.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        e.eglInitialize(f, ai);
        h = d();
        i = e.eglCreateContext(f, h, eglcontext, new int[] {
            12440, 2, 12344
        });
        j = e.eglCreatePbufferSurface(f, h, new int[] {
            12375, i1, 12374, j1, 12344
        });
        e.eglMakeCurrent(f, j, j, i);
        k = (GL10)i.getGL();
        l = Thread.currentThread().getName();
    }

    private EGLConfig d()
    {
        int ai[] = new int[15];
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
        int i1 = ai1[0];
        g = new EGLConfig[i1];
        e.eglChooseConfig(f, ai, g, i1, ai1);
        return g[0];
    }

    private void e()
    {
        Object obj = IntBuffer.allocate(b * c);
        k.glReadPixels(0, 0, b, c, 6408, 5121, ((java.nio.Buffer) (obj)));
        int ai[] = ((IntBuffer) (obj)).array();
        obj = Bitmap.createBitmap(b, c, android.graphics.Bitmap.Config.ARGB_8888);
        ((Bitmap) (obj)).copyPixelsFromBuffer(IntBuffer.wrap(ai));
        Matrix matrix = new Matrix();
        matrix.setScale(1.0F, -1F);
        d = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight(), matrix, false);
    }

    public void a(Rect rect, Rect rect1, Bitmap bitmap)
    {
        e.eglMakeCurrent(f, j, j, i);
        Object obj = IntBuffer.allocate(rect.width() * rect.height());
        k.glReadPixels(rect.left, c - (rect.top + rect.height()), rect.width(), rect.height(), 6408, 5121, ((java.nio.Buffer) (obj)));
        int ai[] = ((IntBuffer) (obj)).array();
        rect = Bitmap.createBitmap(rect.width(), rect.height(), android.graphics.Bitmap.Config.ARGB_8888);
        rect.copyPixelsFromBuffer(IntBuffer.wrap(ai));
        ai = new Matrix();
        ai.setScale(1.0F, -1F);
        rect = Bitmap.createBitmap(rect, 0, 0, rect.getWidth(), rect.getHeight(), ai, false);
        (new Canvas(bitmap)).drawBitmap(rect, rect1.left, rect1.top, null);
    }

    public void a(android.opengl.GLSurfaceView.Renderer renderer)
    {
        a = renderer;
        if (!Thread.currentThread().getName().equals(l))
        {
            Log.e("PixelBuffer", "setRenderer: This thread does not own the OpenGL context.");
            return;
        } else
        {
            a.onSurfaceCreated(k, h);
            a.onSurfaceChanged(k, b, c);
            return;
        }
    }

    public boolean a()
    {
        if (a == null)
        {
            Log.e("PixelBuffer", "getBitmap: Renderer was not set.");
            return false;
        }
        if (!Thread.currentThread().getName().equals(l))
        {
            Log.e("PixelBuffer", "getBitmap: This thread does not own the OpenGL context.");
            return false;
        } else
        {
            e.eglMakeCurrent(f, j, j, i);
            a.onDrawFrame(k);
            return true;
        }
    }

    public Bitmap b()
    {
        if (a())
        {
            e();
            return d;
        } else
        {
            return null;
        }
    }

    public void c()
    {
        e.eglMakeCurrent(f, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        e.eglDestroySurface(f, j);
        e.eglDestroyContext(f, i);
        e.eglTerminate(f);
    }
}
