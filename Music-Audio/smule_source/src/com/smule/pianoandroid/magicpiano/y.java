// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.smule.android.f.h;
import com.smule.magicpiano.PianoCoreBridge;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class y
    implements android.opengl.GLSurfaceView.Renderer
{

    private static final String c = com/smule/pianoandroid/magicpiano/y.getName();
    public int a;
    public int b;
    private Context d;
    private boolean e;

    public y(Context context)
    {
        e = false;
        d = context.getApplicationContext();
    }

    private void a(int i, int j)
    {
        a = i;
        b = j;
    }

    private void b()
    {
        Display display = ((WindowManager)d.getSystemService("window")).getDefaultDisplay();
        a(display.getWidth(), display.getHeight());
    }

    public boolean a()
    {
        return e;
    }

    public void onDrawFrame(GL10 gl10)
    {
        PianoCoreBridge.render(a, b);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int j)
    {
        a(i, j);
        gl10.glViewport(0, 0, i, j);
        PianoCoreBridge.resize(i, j);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        b();
        if (!e)
        {
            gl10.glEnable(2884);
            gl10.glCullFace(1029);
            e = true;
        }
        h.a().a("RENDERER_INITIALIZED", "RENDERER_INITIALIZED");
    }

}
