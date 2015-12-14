// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Handler;
import android.util.Log;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class bkv
    implements android.opengl.GLSurfaceView.Renderer
{

    blt a;
    bls b;
    Context c;
    int d;
    private Bitmap e;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private Bitmap j;
    private String k;
    private float l;
    private Handler m;
    private boolean n;
    private boolean o;

    public bkv(Context context)
    {
        d = -1;
        h = false;
        i = false;
        l = 1.0F;
        n = false;
        o = false;
        c = context;
        a = new blt(context);
        f = context.getResources().getString(0x7f0601a0);
        g = "0";
    }

    private boolean a(int i1)
    {
        if (e == null)
        {
            return false;
        } else
        {
            Bitmap bitmap = yo.b(e);
            blj.a(bitmap, d);
            bitmap.recycle();
            h = true;
            return true;
        }
    }

    private void c(String s)
    {
        s = bku.a(c, s);
        if (s != null)
        {
            a.b(s);
        }
        i = false;
    }

    public void a()
    {
        a.a();
    }

    public void a(float f1)
    {
        a.b(f1);
    }

    public void a(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            Log.e("ImageGLRender", "source bitmap is null");
            return;
        } else
        {
            e = bitmap;
            h = false;
            return;
        }
    }

    public void a(Bitmap bitmap, String s, float f1, Handler handler, boolean flag)
    {
        j = bitmap;
        k = s;
        l = f1;
        m = handler;
        o = true;
        n = flag;
    }

    public void a(Handler handler)
    {
        a.a(handler, e.getWidth(), e.getHeight());
    }

    public void a(String s)
    {
        f = s;
        i = true;
    }

    public void b(Bitmap bitmap, String s, float f1, Handler handler, boolean flag)
    {
        if (bitmap == null || s == null)
        {
            Log.e("ImageGLRender", "source image or filter name is null");
            return;
        }
        if (b == null)
        {
            b = new bls(c);
        }
        if (flag)
        {
            s = blc.a(c, s);
        } else
        {
            s = bku.a(c, s);
        }
        if (s == null)
        {
            Log.e("ImageGLRender", "No filter is created!");
            return;
        } else
        {
            b.a(s);
            b.a(bitmap.getWidth(), bitmap.getHeight());
            b.a(f1);
            b.a(handler);
            bitmap = yo.b(bitmap);
            int i1 = blj.a(bitmap);
            bitmap.recycle();
            b.b(i1);
            GLES20.glDeleteTextures(1, IntBuffer.wrap(new int[] {
                i1
            }));
            b.a();
            return;
        }
    }

    public void b(String s)
    {
        g = s;
        s = blc.a(c, s);
        if (s != null)
        {
            a.c(s);
        }
    }

    public void onDrawFrame(GL10 gl10)
    {
        Log.v("ImageGLRender", "onDrawFrame ....");
        if (o)
        {
            Log.v("ImageGLRender", "processBitmap ....");
            b(j, k, l, m, n);
            o = false;
            j = null;
            k = null;
            m = null;
            n = false;
        }
        if (e != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (i)
        {
            Log.v("ImageGLRender", "changeFilterName ....");
            c(f);
        }
        if (h)
        {
            break; /* Loop/switch isn't completed */
        }
        Log.v("ImageGLRender", "initTexture ....");
        gl10 = new int[1];
        GLES20.glGenTextures(1, gl10, 0);
        d = gl10[0];
        if (!a(d)) goto _L1; else goto _L3
_L3:
        a.c(d);
        return;
    }

    public void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        Log.v("ImageGLRender", (new StringBuilder()).append("onSurfaceChanged").append(i1).append(":").append(j1).toString());
        a.b(i1, j1);
        a(f);
        c(f);
        if (g != null)
        {
            b(g);
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        Log.v("ImageGLRender", "onSurfaceCreated");
        h = false;
    }
}
