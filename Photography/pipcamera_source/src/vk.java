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

public class vk
    implements android.opengl.GLSurfaceView.Renderer
{

    wh a;
    wd b;
    Context c;
    int d;
    int e;
    private float f;
    private Bitmap g;
    private Bitmap h;
    private String i;
    private boolean j;
    private boolean k;
    private Bitmap l;
    private String m;
    private Handler n;
    private boolean o;

    public vk(Context context)
    {
        d = -1;
        e = -1;
        j = false;
        k = false;
        o = false;
        c = context;
        a = new wh(context);
        i = context.getResources().getString(0x7f060181);
    }

    private boolean a(int i1, Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return false;
        } else
        {
            bitmap = ev.b(bitmap);
            vu.b(bitmap, i1);
            bitmap.recycle();
            j = true;
            return true;
        }
    }

    private void b(String s)
    {
        s = va.a(c, s);
        if (s != null)
        {
            a.a(s);
        }
        k = false;
    }

    public void a(float f1)
    {
        a.a(f1);
    }

    public void a(Bitmap bitmap)
    {
        h = bitmap;
        a.a(bitmap);
    }

    public void a(Bitmap bitmap, String s, Handler handler)
    {
        l = bitmap;
        m = s;
        n = handler;
        o = true;
    }

    public void a(Handler handler)
    {
        a.a(handler);
    }

    public void a(String s)
    {
        i = s;
        k = true;
    }

    public void b(float f1)
    {
        f = f1;
    }

    public void b(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            Log.e("ImageGLRender", "source bitmap is null");
            return;
        } else
        {
            g = bitmap;
            j = false;
            return;
        }
    }

    public void b(Bitmap bitmap, String s, Handler handler)
    {
        if (bitmap == null || s == null)
        {
            Log.e("ImageGLRender", "source image or filter name is null");
            return;
        }
        if (b == null)
        {
            b = new wd(c);
        }
        s = va.a(c, s);
        if (s == null)
        {
            Log.e("ImageGLRender", "No filter is created!");
            return;
        } else
        {
            b.a(s);
            b.a(bitmap.getWidth(), bitmap.getHeight());
            b.a(handler);
            bitmap = ev.b(bitmap);
            int i1 = vu.a(bitmap);
            bitmap.recycle();
            b.b(i1);
            GLES20.glDeleteTextures(1, IntBuffer.wrap(new int[] {
                i1
            }));
            b.a();
            return;
        }
    }

    public void onDrawFrame(GL10 gl10)
    {
        Log.v("ImageGLRender", "onDrawFrame ....");
        if (o)
        {
            Log.v("ImageGLRender", "processBitmap ....");
            b(l, m, n);
            o = false;
            l = null;
            m = null;
            n = null;
        }
        if (k)
        {
            Log.v("ImageGLRender", "changeFilterName ....");
            b(i);
        }
        if (!j)
        {
            Log.v("ImageGLRender", "initTexture ....");
            if (!a(d, g) && !a(e, h))
            {
                return;
            }
        }
        a.b(d);
    }

    public void onSurfaceChanged(GL10 gl10, int i1, int j1)
    {
        Log.v("ImageGLRender", (new StringBuilder()).append("onSurfaceChanged").append(i1).append(":").append(j1).toString());
        a.a(i1, j1);
        a(i);
        b(i);
        if (h != null)
        {
            a.a(h);
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        Log.v("ImageGLRender", "onSurfaceCreated");
        j = false;
        gl10 = new int[1];
        GLES20.glGenTextures(1, gl10, 0);
        d = gl10[0];
        if (g != null)
        {
            a(d, g);
        }
        gl10 = new int[1];
        GLES20.glGenTextures(1, gl10, 0);
        e = gl10[0];
        if (h != null)
        {
            a(e, h);
        }
    }
}
