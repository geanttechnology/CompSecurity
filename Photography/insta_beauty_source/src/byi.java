// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.Rotation;

public class byi
    implements android.hardware.Camera.PreviewCallback, android.opengl.GLSurfaceView.Renderer
{

    public static final float a[] = {
        -1F, -1F, 1.0F, -1F, -1F, 1.0F, 1.0F, 1.0F
    };
    public static HashMap d = new HashMap();
    public static String e = null;
    public final Object b;
    byo c;
    public boolean f;
    public boolean g;
    private byh h;
    private int i;
    private SurfaceTexture j;
    private final FloatBuffer k;
    private final FloatBuffer l;
    private IntBuffer m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private final Queue s;
    private Rotation t;
    private boolean u;
    private boolean v;
    private jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType w;
    private int x;
    private long y;
    private long z;

    public byi(byh byh1)
    {
        b = new Object();
        i = -1;
        j = null;
        w = jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_INSIDE;
        f = false;
        x = 0;
        y = 0L;
        z = 0L;
        g = false;
        h = byh1;
        s = new LinkedList();
        k = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        k.put(a).position(0);
        l = ByteBuffer.allocateDirect(byq.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        b(Rotation.NORMAL, false, false);
    }

    public byi(byh byh1, byo byo1)
    {
        b = new Object();
        i = -1;
        j = null;
        w = jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_INSIDE;
        f = false;
        x = 0;
        y = 0L;
        z = 0L;
        g = false;
        c = byo1;
        h = byh1;
        s = new LinkedList();
        k = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        k.put(a).position(0);
        l = ByteBuffer.allocateDirect(byq.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        b(Rotation.NORMAL, false, false);
    }

    static int a(byi byi1, int i1)
    {
        byi1.i = i1;
        return i1;
    }

    static SurfaceTexture a(byi byi1, SurfaceTexture surfacetexture)
    {
        byi1.j = surfacetexture;
        return surfacetexture;
    }

    static byh a(byi byi1, byh byh1)
    {
        byi1.h = byh1;
        return byh1;
    }

    static IntBuffer a(byi byi1)
    {
        return byi1.m;
    }

    static int b(byi byi1)
    {
        return byi1.i;
    }

    static int b(byi byi1, int i1)
    {
        byi1.p = i1;
        return i1;
    }

    static int c(byi byi1)
    {
        return byi1.p;
    }

    static int c(byi byi1, int i1)
    {
        byi1.q = i1;
        return i1;
    }

    static int d(byi byi1, int i1)
    {
        byi1.r = i1;
        return i1;
    }

    static byh d(byi byi1)
    {
        return byi1.h;
    }

    static void e(byi byi1)
    {
        byi1.f();
    }

    static SurfaceTexture f(byi byi1)
    {
        return byi1.j;
    }

    private void f()
    {
        float f1 = n;
        float f3 = o;
        if (f1 == 0.0F || f3 == 0.0F)
        {
            return;
        } else
        {
            float af[] = a;
            af = byq.a(t, u, v);
            float f2 = a[0];
            float f4 = a[1];
            float f5 = a[2];
            float f6 = a[3];
            float f7 = a[4];
            float f8 = a[5];
            float f9 = a[6];
            float f10 = a[7];
            k.clear();
            k.put(new float[] {
                f2 * 1.0F, f4, f5 * 1.0F, f6, f7 * 1.0F, f8, 1.0F * f9, f10
            }).position(0);
            l.clear();
            l.put(af).position(0);
            return;
        }
    }

    static int g(byi byi1)
    {
        return byi1.n;
    }

    static int h(byi byi1)
    {
        return byi1.o;
    }

    public void a()
    {
        a(((Runnable) (new bym(this))));
    }

    public void a(Bitmap bitmap, boolean flag)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            return;
        } else
        {
            a(((Runnable) (new byn(this, bitmap, flag))));
            return;
        }
    }

    public void a(Camera camera)
    {
        a(((Runnable) (new byk(this, camera))));
    }

    public void a(byh byh1)
    {
        a(((Runnable) (new byl(this, byh1))));
    }

    public void a(Runnable runnable)
    {
        synchronized (s)
        {
            s.add(runnable);
        }
        return;
        runnable;
        queue;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void a(jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType scaletype)
    {
        w = scaletype;
    }

    public void a(Rotation rotation, boolean flag, boolean flag1)
    {
        b(rotation, flag1, flag);
    }

    public int b()
    {
        return n;
    }

    public void b(Rotation rotation, boolean flag, boolean flag1)
    {
        t = rotation;
        u = flag;
        v = flag1;
        f();
    }

    public int c()
    {
        return o;
    }

    public boolean d()
    {
        return u;
    }

    public boolean e()
    {
        return v;
    }

    public void onDrawFrame(GL10 gl10)
    {
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        gl10 = s;
        gl10;
        JVM INSTR monitorenter ;
        for (; !s.isEmpty(); ((Runnable)s.poll()).run()) { }
          goto _L1
        Exception exception;
        exception;
        gl10;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (GL10 gl10)
        {
            gl10.printStackTrace();
        }
_L3:
        return;
_L1:
        gl10;
        JVM INSTR monitorexit ;
        if (i == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        h.b(i, k, l);
        gl10 = j;
        if (gl10 != null)
        {
            return;
        }
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        if (y == 0L)
        {
            y = System.currentTimeMillis();
        }
        if (x >= 15) goto _L2; else goto _L1
_L1:
        x = x + 1;
_L7:
        android.hardware.Camera.Size size = camera.getParameters().getPreviewSize();
        if (size != null) goto _L4; else goto _L3
_L3:
        return;
_L2:
        if (x == 15)
        {
            x = x + 1;
            z = System.currentTimeMillis();
            if (Math.abs(y - z) < 2000L)
            {
                g = true;
            } else
            {
                g = false;
            }
            if (c != null)
            {
                c.a(g);
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (m == null || m.capacity() != size.width * size.height)
        {
            m = IntBuffer.allocate(size.width * size.height);
            if (i != -1)
            {
                GLES20.glDeleteTextures(1, new int[] {
                    i
                }, 0);
                i = -1;
            }
        }
        if (!s.isEmpty()) goto _L3; else goto _L5
_L5:
        a(new byj(this, abyte0, size, camera));
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        n = i1;
        o = j1;
        GLES20.glViewport(0, 0, i1, j1);
        GLES20.glUseProgram(h.i());
        h.b(i1, j1);
        h.a(i1, j1);
        synchronized (b)
        {
            b.notifyAll();
        }
        return;
        exception;
        gl10;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        d.clear();
        Log.i("GL", (new StringBuilder()).append("GL_RENDERER = ").append(GLES20.glGetString(7937)).toString());
        Log.i("GL", (new StringBuilder()).append("GL_VENDOR = ").append(GLES20.glGetString(7936)).toString());
        Log.i("GL", (new StringBuilder()).append("GL_VERSION = ").append(GLES20.glGetString(7938)).toString());
        Log.i("GL", (new StringBuilder()).append("GL_EXTENSIONS = ").append(GLES20.glGetString(7939)).toString());
        h.e();
    }

}
