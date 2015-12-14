// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.app.Activity;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import com.socialin.android.photo.imgop.ImageOp;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity, b, d, e, 
//            c, f

public final class a
    implements android.opengl.GLSurfaceView.Renderer
{

    private Handler A;
    private int B;
    int a;
    int b;
    int c;
    float d;
    float e;
    float f;
    RectF g;
    RectF h;
    int i;
    int j;
    int k;
    boolean l;
    int m;
    float n[];
    ByteBuffer o;
    ByteBuffer p;
    float q[];
    b r;
    int s;
    Runnable t;
    boolean u;
    private boolean v;
    private FloatBuffer w;
    private float x[];
    private int y;
    private Activity z;

    public a(Activity activity, Handler handler, b b1)
    {
        a = 0;
        b = 0;
        c = 0;
        k = 0;
        l = false;
        v = false;
        m = -1;
        n = new float[2];
        o = null;
        x = new float[2];
        q = new float[2];
        y = -1;
        r = null;
        s = 0;
        u = false;
        B = 0;
        z = activity;
        A = handler;
        r = b1;
    }

    final void a(float f1, float f2, float f3, float f4)
    {
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(48);
        bytebuffer.order(ByteOrder.nativeOrder());
        w = bytebuffer.asFloatBuffer();
        w.put(new float[] {
            f1, f2, 0.0F, f1 + f3, f2, 0.0F, f1 + f3, f2 + f4, 0.0F, f1, 
            f2 + f4, 0.0F
        });
        w.position(0);
    }

    public final void onDrawFrame(GL10 gl10)
    {
        if (!v) goto _L2; else goto _L1
_L1:
        return;
_L2:
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        gl10 = r;
        s;
        JVM INSTR tableswitch 0 1: default 52
    //                   0 503
    //                   1 518;
           goto _L3 _L4 _L5
_L3:
        int i1 = -1;
_L8:
        Object obj;
        GLES20.glUseProgram(i1);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(i1, "rltb"), 1, x, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(i1, "initialXY"), 1, q, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(i1, "textureInitialXY"), 1, n, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i1, "bitmapWidth"), f);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i1, "bitmapHeight"), f);
        obj = r;
        s;
        JVM INSTR tableswitch 1 1: default 164
    //                   1 533;
           goto _L6 _L7
_L6:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, y);
        i1 = GLES20.glGetAttribLocation(i1, "vPosition");
        if (w != null)
        {
            GLES20.glVertexAttribPointer(i1, 3, 5126, false, 0, w);
            GLES20.glEnableVertexAttribArray(i1);
            GLES20.glDrawArrays(6, 0, 4);
            if (p != null)
            {
                if (l)
                {
                    k = k + 1;
                    if (k <= 1)
                    {
                        ((ColorSplashActivity)z).a();
                    }
                }
                if (!v && (!l || k <= 2))
                {
                    B = B + 1;
                    float f1;
                    String s1;
                    float af[];
                    Integer integer;
                    int j1;
                    if (B > 1)
                    {
                        p.position(0);
                        GLES20.glReadPixels(0, 0, i, j, 6408, 5121, p);
                        if (B == 2 && s == 0 && !l && t != null)
                        {
                            t.run();
                        }
                    } else
                    if (s == 0 && !l)
                    {
                        ((ColorSplashActivity)z).a();
                    }
                }
                if (!v && l && k == 2)
                {
                    v = true;
                    gl10 = A.obtainMessage();
                    gl10.arg1 = m;
                    A.sendMessage(gl10);
                }
            }
        }
        if (!u && !l && t != null)
        {
            t.run();
        }
        u = true;
        if (z != null && s != 0)
        {
            gl10 = (ColorSplashActivity)z;
            if (((ColorSplashActivity) (gl10)).f != null)
            {
                gl10.runOnUiThread(new ColorSplashActivity._cls8(gl10));
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = ((b) (gl10)).c.a.a;
          goto _L8
_L5:
        i1 = ((b) (gl10)).b.b.a;
          goto _L8
_L7:
        gl10 = ((b) (obj)).b.a;
        j1 = ((b) (obj)).b.b.a;
        for (obj = ((f) (gl10)).a.keySet().iterator(); ((Iterator) (obj)).hasNext(); GLES20.glUniform1f(GLES20.glGetUniformLocation(j1, s1), f1))
        {
            s1 = (String)((Iterator) (obj)).next();
            f1 = ((Float)((f) (gl10)).a.get(s1)).floatValue();
        }

        for (obj = ((f) (gl10)).b.keySet().iterator(); ((Iterator) (obj)).hasNext(); GLES20.glUniform2fv(GLES20.glGetUniformLocation(j1, s1), 1, af, 0))
        {
            s1 = (String)((Iterator) (obj)).next();
            af = (float[])((f) (gl10)).b.get(s1);
        }

        obj = ((f) (gl10)).c.keySet().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            s1 = (String)((Iterator) (obj)).next();
            integer = (Integer)((f) (gl10)).c.get(s1);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(j1, s1), integer.intValue());
        }
          goto _L6
        if (true) goto _L1; else goto _L9
_L9:
    }

    public final void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        k = 0;
        GLES20.glViewport(0, 0, i1, j1);
        if (v || o == null) goto _L2; else goto _L1
_L1:
        if ((float)i1 / (float)j1 < 1.0F) goto _L4; else goto _L3
_L3:
        d = i1;
        e = (d * (float)b) / (float)a;
        if (e > (float)j1)
        {
            d = (int)(d * ((float)j1 / e));
            e = (int)(e * ((float)j1 / e));
        }
_L6:
        f = ((float)c * d) / (float)a;
        if (p != null)
        {
            ImageOp.a(p);
        }
        p = ImageOp.a(i1 * j1 * 4);
        i = i1;
        j = j1;
        p.order(ByteOrder.nativeOrder());
        float f1 = (int)(((float)i1 - d) / 2.0F);
        float f2 = (int)(((float)j1 - e) / 2.0F);
        q[0] = f1;
        q[1] = f2;
        n[0] = 0.0F;
        n[1] = 0.0F;
        g = new RectF(f1, f2, (float)i - f1, (float)j - f2);
        h = new RectF(f1, f2, (float)i - f1, (float)j - f2);
        a(f1, f2, d, e);
        x[0] = 2.0F / (float)i1;
        x[1] = 2.0F / (float)(-j1);
        if (y == -1)
        {
            gl10 = new int[1];
            GLES20.glGenTextures(1, gl10, 0);
            y = gl10[0];
            GLES20.glBindTexture(3553, y);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
            GLES20.glTexImage2D(3553, 0, 6408, c, c, 0, 6408, 5121, o);
        }
_L2:
        B = 0;
        u = false;
        return;
_L4:
        e = j1;
        d = (int)(e * ((float)a / (float)b));
        if (d > (float)i1)
        {
            e = (int)(e * ((float)i1 / d));
            d = (int)(d * ((float)i1 / d));
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        gl10 = r;
        ((b) (gl10)).c.a = new e(((b) (gl10)).c.b, ((b) (gl10)).c.c, ((b) (gl10)).a.getApplicationContext());
        if (((b) (gl10)).d == 1)
        {
            ((b) (gl10)).b.d = 0x7f070058;
        } else
        {
            ((b) (gl10)).b.d = 0x7f070059;
        }
        ((b) (gl10)).b.b = new e(((b) (gl10)).b.c, ((b) (gl10)).b.d, ((b) (gl10)).a.getApplicationContext());
        GLES20.glClearColor(0.5F, 0.5F, 0.5F, 1.0F);
    }
}
