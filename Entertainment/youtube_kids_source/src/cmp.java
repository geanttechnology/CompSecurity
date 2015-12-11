// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class cmp
    implements android.graphics.SurfaceTexture.OnFrameAvailableListener, android.opengl.GLSurfaceView.Renderer
{

    private static final float b[] = {
        -1F, -1F, 0.0F, 0.0F, 0.0F, 1.0F, -1F, 0.0F, 1.0F, 0.0F, 
        -1F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F
    };
    public cmr a;
    private final Context c;
    private final FloatBuffer d = ByteBuffer.allocateDirect(80).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final Handler e;
    private int f;
    private int g;
    private int h;
    private cms i;
    private SurfaceTexture j;
    private boolean k;

    public cmp(Context context, Handler handler)
    {
        k = false;
        b.a(context);
        b.a(handler);
        e = handler;
        c = context;
        context = b;
        d.put(b).position(0);
        a(cms.d);
    }

    private static int a(int l, String s)
    {
        int i1 = GLES20.glCreateShader(l);
        if (i1 != 0)
        {
            GLES20.glShaderSource(i1, s);
            GLES20.glCompileShader(i1);
            s = new int[1];
            GLES20.glGetShaderiv(i1, 35713, s, 0);
            if (s[0] == 0)
            {
                bmo.b((new StringBuilder(37)).append("Could not compile shader ").append(l).append(":").toString());
                bmo.b(GLES20.glGetShaderInfoLog(i1));
                GLES20.glDeleteShader(i1);
                return 0;
            }
        }
        return i1;
    }

    private static void a(String s, int l)
    {
        int i1 = GLES20.glGetError();
        if (i1 != 0 || l == -1)
        {
            bmo.b((new StringBuilder(String.valueOf(s).length() + 21)).append(s).append(": glError ").append(i1).toString());
            throw new RuntimeException((new StringBuilder(String.valueOf(s).length() + 21)).append(s).append(": glError ").append(i1).toString());
        } else
        {
            return;
        }
    }

    public final void a(cms cms1)
    {
        this;
        JVM INSTR monitorenter ;
        i = (cms)b.a(cms1);
        cms1 = i;
        cmq.a[cms1.ordinal()];
        JVM INSTR tableswitch 1 4: default 130
    //                   1 71
    //                   2 104
    //                   3 119
    //                   4 119;
           goto _L1 _L2 _L3 _L4 _L4
_L4:
        break MISSING_BLOCK_LABEL_119;
_L1:
        throw new UnsupportedOperationException("Shader not supported");
        cms1;
        this;
        JVM INSTR monitorexit ;
        throw cms1;
_L2:
        cms1 = new cmu(c);
_L5:
        a = cms1;
        if (f != 0)
        {
            onSurfaceCreated(null, null);
        }
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        cms1 = new cmv(c);
          goto _L5
        cms1 = new cmt();
          goto _L5
    }

    public final void onDrawFrame(GL10 gl10)
    {
        this;
        JVM INSTR monitorenter ;
        if (k)
        {
            j.updateTexImage();
            k = false;
        }
        this;
        JVM INSTR monitorexit ;
        a.c();
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays", 0);
        GLES20.glFinish();
        return;
        gl10;
        this;
        JVM INSTR monitorexit ;
        throw gl10;
    }

    public final void onFrameAvailable(SurfaceTexture surfacetexture)
    {
        this;
        JVM INSTR monitorenter ;
        k = true;
        this;
        JVM INSTR monitorexit ;
        return;
        surfacetexture;
        throw surfacetexture;
    }

    public final void onSurfaceChanged(GL10 gl10, int l, int i1)
    {
        GLES20.glViewport(0, 0, l, i1);
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        int i1;
        gl10 = a.a();
        eglconfig = a.b();
        i1 = a(35633, gl10);
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        int l = ((flag) ? 1 : 0);
_L4:
        f = l;
        l = f;
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_156;
        }
_L7:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int j1 = a(35632, eglconfig);
        l = ((flag) ? 1 : 0);
        if (j1 == 0) goto _L4; else goto _L3
_L3:
        l = GLES20.glCreateProgram();
        if (l == 0) goto _L4; else goto _L5
_L5:
        GLES20.glAttachShader(l, i1);
        a("glAttachShader", 0);
        GLES20.glAttachShader(l, j1);
        a("glAttachShader", 0);
        GLES20.glLinkProgram(l);
        gl10 = new int[1];
        GLES20.glGetProgramiv(l, 35714, gl10, 0);
        if (gl10[0] == 1) goto _L4; else goto _L6
_L6:
        bmo.b("Could not link program: ");
        bmo.b(GLES20.glGetProgramInfoLog(l));
        GLES20.glDeleteProgram(l);
        l = ((flag) ? 1 : 0);
          goto _L4
        gl10;
        throw gl10;
        h = GLES20.glGetAttribLocation(f, "aVertPos");
        a("glGetAttribLocation aVertPos", h);
        gl10 = new int[1];
        GLES20.glGenTextures(1, gl10, 0);
        g = gl10[0];
        GLES20.glBindTexture(36197, g);
        a("glBindTexture mTextureID", 0);
        GLES20.glTexParameterf(36197, 10241, 9728F);
        GLES20.glTexParameterf(36197, 10240, 9729F);
        j = new SurfaceTexture(g);
        j.setOnFrameAvailableListener(this);
        gl10 = new Surface(j);
        e.obtainMessage(0, gl10).sendToTarget();
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        GLES20.glUseProgram(f);
        a("glUseProgram", 0);
        a.a(f);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, g);
        d.position(0);
        GLES20.glVertexAttribPointer(h, 3, 5126, false, 20, d);
        a("glVertexAttribPointer maPosition", 0);
        GLES20.glEnableVertexAttribArray(h);
        a("glEnableVertexAttribArray maPositionHandle", 0);
          goto _L7
    }

}
