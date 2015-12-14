// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.graphics.Bitmap;
import android.graphics.PointF;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.photo.morph:
//            b

public class MorphRenderer
    implements android.opengl.GLSurfaceView.Renderer
{

    b a;
    private Bitmap b;
    private Runnable c;
    private Bitmap d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private PointF k;
    private float l;
    private float m;
    private float n;
    private int o;

    public MorphRenderer()
    {
        b = null;
        c = null;
        d = null;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = 0;
        k = new PointF(0.0F, 0.0F);
        l = 1.0F;
        m = 0.1F;
        n = 3F;
        a = null;
    }

    private void b(float f1, float f2)
    {
        this;
        JVM INSTR monitorenter ;
        k.x = f1;
        k.y = f2;
        setFrameCenter(k.x, k.y);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private native int create(int i1);

    private native void display();

    private native void freeBuffers();

    private native void freeGLResources();

    private native void getImage(Bitmap bitmap);

    private native void getScaledImage(Bitmap bitmap);

    private void k()
    {
        if (b != null)
        {
            i = b.getWidth();
            j = b.getHeight();
            if (i > 1024 || j > 1024)
            {
                getClass().getSimpleName();
                float f1 = 1024F / (float)Math.max(i, j);
                i = (int)((float)i * f1);
                j = (int)(f1 * (float)j);
            }
            g = b.getWidth();
            h = b.getHeight();
            boolean flag = false;
            if (g > o || h > o)
            {
                getClass().getSimpleName();
                float f2 = (float)o / (float)Math.max(g, h);
                b = Bitmap.createScaledBitmap(b, (int)((float)g * f2), (int)(f2 * (float)h), true);
                g = b.getWidth();
                h = b.getHeight();
                flag = true;
            }
            setTextureBitmap(b, i, j);
            if (flag)
            {
                b.recycle();
            }
            c(Math.min((float)e / (float)i, (float)f / (float)j));
            b = null;
            if (c != null)
            {
                c.run();
                c = null;
            }
        }
    }

    private native void morph();

    private native void nullGLResources();

    private native void render();

    private native void setCanvasSize(int i1, int j1);

    private native void setFrameCenter(float f1, float f2);

    private native void setFrameScale(float f1);

    private native void setTextureBitmap(Bitmap bitmap, int i1, int j1);

    private native void updateCoordsTexture();

    private native void updateSelectionTexture();

    private native void updateTextures();

    public final int a()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = e;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final PointF a(float f1, float f2)
    {
        this;
        JVM INSTR monitorenter ;
        PointF pointf;
        pointf = new PointF();
        pointf.x = ((f1 - k.x) + ((float)i * l) / 2.0F) / l;
        pointf.y = ((f2 - k.y) + ((float)j * l) / 2.0F) / l;
        this;
        JVM INSTR monitorexit ;
        return pointf;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(float f1)
    {
        this;
        JVM INSTR monitorenter ;
        m = f1;
        c(l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(Bitmap bitmap, Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        b = bitmap;
        c = runnable;
        this;
        JVM INSTR monitorexit ;
        return;
        bitmap;
        throw bitmap;
    }

    public final void a(PointF pointf)
    {
        this;
        JVM INSTR monitorenter ;
        b(pointf.x, pointf.y);
        this;
        JVM INSTR monitorexit ;
        return;
        pointf;
        throw pointf;
    }

    public final int b()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = f;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b(float f1)
    {
        this;
        JVM INSTR monitorenter ;
        n = f1;
        c(l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final int c()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = i;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void c(float f1)
    {
        this;
        JVM INSTR monitorenter ;
        l = Math.max(m, Math.min(n, f1));
        setFrameScale(l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final int d()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = j;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final float e()
    {
        this;
        JVM INSTR monitorenter ;
        float f1 = m;
        this;
        JVM INSTR monitorexit ;
        return f1;
        Exception exception;
        exception;
        throw exception;
    }

    public final float f()
    {
        this;
        JVM INSTR monitorenter ;
        float f1 = n;
        this;
        JVM INSTR monitorexit ;
        return f1;
        Exception exception;
        exception;
        throw exception;
    }

    public final float g()
    {
        this;
        JVM INSTR monitorenter ;
        float f1 = l;
        this;
        JVM INSTR monitorexit ;
        return f1;
        Exception exception;
        exception;
        throw exception;
    }

    public final PointF h()
    {
        this;
        JVM INSTR monitorenter ;
        PointF pointf = new PointF(k.x, k.y);
        this;
        JVM INSTR monitorexit ;
        return pointf;
        Exception exception;
        exception;
        throw exception;
    }

    public final Bitmap i()
    {
        this;
        JVM INSTR monitorenter ;
        d = Bitmap.createBitmap(g, h, android.graphics.Bitmap.Config.ARGB_8888);
        Bitmap bitmap;
        wait();
        bitmap = d;
        d = null;
_L2:
        this;
        JVM INSTR monitorexit ;
        return bitmap;
        InterruptedException interruptedexception;
        interruptedexception;
        bitmap = null;
_L3:
        interruptedexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
        interruptedexception;
          goto _L3
    }

    public final void j()
    {
        this;
        JVM INSTR monitorenter ;
        setSelectionBitmap(null);
        setBrushAreaBitmap(null);
        freeBuffers();
        nullGLResources();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onDrawFrame(GL10 gl10)
    {
        this;
        JVM INSTR monitorenter ;
        k();
        render();
        if (d != null)
        {
            getScaledImage(d);
        }
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        gl10;
        this;
        JVM INSTR monitorexit ;
        throw gl10;
    }

    public void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        this;
        JVM INSTR monitorenter ;
        e = i1;
        f = j1;
        setCanvasSize(e, f);
        b((float)e / 2.0F, (float)f / 2.0F);
        k();
        if (i > 0 && j > 0)
        {
            c(Math.min((float)e / (float)i, (float)f / (float)j));
        }
        if (a != null)
        {
            a.c();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        gl10;
        this;
        JVM INSTR monitorexit ;
        throw gl10;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        this;
        JVM INSTR monitorenter ;
        o = create(0);
        this;
        JVM INSTR monitorexit ;
        return;
        gl10;
        this;
        JVM INSTR monitorexit ;
        throw gl10;
    }

    public synchronized native void setBrushAreaBitmap(Bitmap bitmap);

    public synchronized native void setDefaultCoords();

    public synchronized native void setDefaultSelection();

    public synchronized native void setSelectionBitmap(Bitmap bitmap);
}
