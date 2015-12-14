// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Canvas;
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
import jp.co.cyberagent.android.gpuimage.GPUImageNativeLibrary;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;
import jp.co.cyberagent.android.gpuimage.Rotation;

public class aep
    implements android.hardware.Camera.PreviewCallback, android.opengl.GLSurfaceView.Renderer
{

    public static final float a[] = {
        -1F, -1F, 1.0F, -1F, -1F, 1.0F, 1.0F, 1.0F
    };
    public static HashMap d = new HashMap();
    public static String e = null;
    public final Object b;
    aeq c;
    public boolean f;
    public boolean g;
    private aeo h;
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

    public aep(aeo aeo1)
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
        h = aeo1;
        s = new LinkedList();
        k = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        k.put(a).position(0);
        l = ByteBuffer.allocateDirect(aes.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        a(Rotation.NORMAL, false, false);
    }

    public aep(aeo aeo1, aeq aeq1)
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
        c = aeq1;
        h = aeo1;
        s = new LinkedList();
        k = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        k.put(a).position(0);
        l = ByteBuffer.allocateDirect(aes.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        a(Rotation.NORMAL, false, false);
    }

    static int a(aep aep1, int i1)
    {
        aep1.i = i1;
        return i1;
    }

    static aeo a(aep aep1, aeo aeo1)
    {
        aep1.h = aeo1;
        return aeo1;
    }

    static IntBuffer a(aep aep1)
    {
        return aep1.m;
    }

    static int b(aep aep1)
    {
        return aep1.i;
    }

    static int b(aep aep1, int i1)
    {
        aep1.p = i1;
        return i1;
    }

    static int c(aep aep1)
    {
        return aep1.p;
    }

    static int c(aep aep1, int i1)
    {
        aep1.q = i1;
        return i1;
    }

    static int d(aep aep1, int i1)
    {
        aep1.r = i1;
        return i1;
    }

    static aeo d(aep aep1)
    {
        return aep1.h;
    }

    static void e(aep aep1)
    {
        aep1.f();
    }

    static int f(aep aep1)
    {
        return aep1.n;
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
            af = aes.a(t, u, v);
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

    static int g(aep aep1)
    {
        return aep1.o;
    }

    public void a()
    {
        a(new Runnable() {

            final aep a;

            public void run()
            {
                GLES20.glDeleteTextures(1, new int[] {
                    aep.b(a)
                }, 0);
                aep.a(a, -1);
            }

            
            {
                a = aep.this;
                super();
            }
        });
    }

    public void a(aeo aeo1)
    {
        a(new Runnable(aeo1) {

            final aeo a;
            final aep b;

            public void run()
            {
                aeo aeo2 = aep.d(b);
                aep.a(b, a);
                if (aeo2 != null)
                {
                    aeo2.e();
                }
                aep.d(b).a();
                GLES20.glUseProgram(aep.d(b).i());
                aep.d(b).b(aep.f(b), aep.g(b));
            }

            
            {
                b = aep.this;
                a = aeo1;
                super();
            }
        });
    }

    public void a(Bitmap bitmap, boolean flag)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            return;
        } else
        {
            a(new Runnable(bitmap, flag) {

                final Bitmap a;
                final boolean b;
                final aep c;

                public void run()
                {
                    Bitmap bitmap1;
                    Bitmap bitmap2;
                    aep aep1;
                    if (a.getWidth() % 2 == 1)
                    {
                        bitmap1 = Bitmap.createBitmap(a.getWidth() + 1, a.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap1);
                        canvas.drawARGB(0, 0, 0, 0);
                        canvas.drawBitmap(a, 0.0F, 0.0F, null);
                        aep.d(c, 1);
                    } else
                    {
                        aep.d(c, 0);
                        bitmap1 = null;
                    }
                    aep1 = c;
                    if (bitmap1 != null)
                    {
                        bitmap2 = bitmap1;
                    } else
                    {
                        bitmap2 = a;
                    }
                    aep.a(aep1, OpenGlUtils.a(bitmap2, aep.b(c), b));
                    if (bitmap1 != null)
                    {
                        bitmap1.recycle();
                    }
                    aep.b(c, a.getWidth());
                    aep.c(c, a.getHeight());
                    aep.e(c);
                }

            
            {
                c = aep.this;
                a = bitmap;
                b = flag;
                super();
            }
            });
            return;
        }
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
        t = rotation;
        u = flag;
        v = flag1;
        f();
    }

    public int b()
    {
        return n;
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
        a(new Runnable(abyte0, size, camera) {

            final byte a[];
            final android.hardware.Camera.Size b;
            final Camera c;
            final aep d;

            public void run()
            {
                System.currentTimeMillis();
                if (OpenGlUtils.a() == jp.co.cyberagent.android.gpuimage.OpenGlUtils.GPURenderType.GPUImageRender_RGB)
                {
                    GPUImageNativeLibrary.YUVtoRBGA(a, b.width, b.height, aep.a(d).array());
                } else
                {
                    GPUImageNativeLibrary.YUVtoARBG(a, b.width, b.height, aep.a(d).array());
                }
                aep.a(d, OpenGlUtils.a(aep.a(d), b, aep.b(d)));
                c.addCallbackBuffer(a);
                if (aep.c(d) != b.width)
                {
                    aep.d(d).a(b.width, b.height);
                    aep.b(d, b.width);
                    aep.c(d, b.height);
                    aep.e(d);
                }
            }

            
            {
                d = aep.this;
                a = abyte0;
                b = size;
                c = camera;
                super();
            }
        });
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
        h.a();
    }

}
