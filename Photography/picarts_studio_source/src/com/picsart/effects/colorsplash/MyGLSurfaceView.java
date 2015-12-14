// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.app.Activity;
import android.graphics.RectF;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;

// Referenced classes of package com.picsart.effects.colorsplash:
//            a

public class MyGLSurfaceView extends GLSurfaceView
{

    a a;

    public MyGLSurfaceView(Activity activity, a a1)
    {
        super(activity.getApplicationContext());
        a = null;
        setEGLContextClientVersion(2);
        a = a1;
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setRenderer(a);
        setRenderMode(0);
        getHolder().setFormat(1);
    }

    final void a()
    {
        int i = a.i;
        int j = a.j;
        float af[] = a.q;
        RectF rectf = a.h;
        float f5 = rectf.left;
        float f7 = rectf.right;
        float f4 = rectf.top;
        float f6 = rectf.bottom;
        float af1[] = new float[2];
        float[] _tmp = af1;
        af1[0] = 0.0F;
        af1[1] = 0.0F;
        float f;
        float f1;
        float f2;
        float f3;
        a a1;
        if (f5 < 0.0F)
        {
            af1[0] = Math.abs(f5);
            f = 0.0F;
        } else
        {
            f = f5;
        }
        if (f4 < 0.0F)
        {
            af1[1] = Math.abs(f4);
            f1 = 0.0F;
        } else
        {
            f1 = f4;
        }
        if (f7 < (float)i)
        {
            f2 = f7 - f;
        } else
        {
            f2 = (float)i - f;
        }
        if (f6 < (float)j)
        {
            f3 = f6 - f1;
        } else
        {
            f3 = (float)j - f1;
        }
        f5 = Math.abs(f7 - f5);
        f4 = Math.abs(f6 - f4);
        af[0] = f;
        af[1] = f1;
        a1 = a;
        a1.f = (f5 / a1.d) * a1.f;
        a1.d = f5;
        a1.e = f4;
        a1.q = af;
        a1.n = af1;
        a1.a(af[0], af[1], f2, f3);
        requestRender();
    }
}
