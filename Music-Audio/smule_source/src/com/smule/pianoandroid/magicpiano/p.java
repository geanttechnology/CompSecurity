// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.smule.pianoandroid.globe.PianoGlobeBridge;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class p
    implements android.opengl.GLSurfaceView.Renderer
{

    private static final String a = com/smule/pianoandroid/magicpiano/p.getName();
    private Context b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private float g;
    private float h;
    private Rect i;

    public p(Context context)
    {
        e = false;
        f = false;
        i = null;
        e = false;
        b = context.getApplicationContext();
    }

    private void a()
    {
        Display display = ((WindowManager)b.getSystemService("window")).getDefaultDisplay();
        a(display.getWidth(), display.getHeight());
    }

    private void a(int j, int k)
    {
        c = j;
        d = k;
    }

    public void a(float f1, float f2)
    {
        if (e)
        {
            PianoGlobeBridge.visitLatLong(f1, f2, 0.5F);
            return;
        } else
        {
            g = f1;
            h = f2;
            f = true;
            return;
        }
    }

    public void a(Rect rect)
    {
        if (e)
        {
            PianoGlobeBridge.setViewSize(rect.top, rect.left, rect.bottom, rect.right);
            return;
        } else
        {
            i = rect;
            return;
        }
    }

    public void onDrawFrame(GL10 gl10)
    {
        PianoGlobeBridge.render();
    }

    public void onSurfaceChanged(GL10 gl10, int j, int k)
    {
        GLES20.glViewport(0, 0, j, k);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        a();
        Log.i(a, (new StringBuilder()).append("Width ").append(c).append(", Height ").append(d).toString());
        PianoGlobeBridge.init(b, c, d);
        e = true;
        if (i != null)
        {
            PianoGlobeBridge.setViewSize(i.top, i.left, i.bottom, i.right);
            i = null;
        }
        if (f)
        {
            PianoGlobeBridge.visitLatLong(g, h, 0.5F);
            f = false;
        }
    }

}
