// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.GLES10;
import android.opengl.GLSurfaceView;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u, z, s, Rotation, 
//            ag, t, aa

public class GPUImage
{

    private final Context a;
    private z b;
    private GLSurfaceView c;
    private u d;
    private Bitmap e;
    private ScaleType f;
    private int g;

    public GPUImage(Context context)
    {
        f = ScaleType.b;
        g = 0;
        if (!a(context))
        {
            throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
        } else
        {
            a = context;
            d = new u();
            b = new z(d);
            context = new int[1];
            GLES10.glGetIntegerv(3379, context, 0);
            g = context[0];
            return;
        }
    }

    static Context a(GPUImage gpuimage)
    {
        return gpuimage.a;
    }

    private boolean a(Context context)
    {
        return ((ActivityManager)context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 0x20000;
    }

    static z b(GPUImage gpuimage)
    {
        return gpuimage.b;
    }

    static int c(GPUImage gpuimage)
    {
        return gpuimage.f();
    }

    static int d(GPUImage gpuimage)
    {
        return gpuimage.g();
    }

    static ScaleType e(GPUImage gpuimage)
    {
        return gpuimage.f;
    }

    private int f()
    {
        if (b != null && b.c() != 0)
        {
            return b.c();
        }
        if (e != null)
        {
            return e.getWidth();
        } else
        {
            Display display = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            return point.x;
        }
    }

    private int g()
    {
        if (b != null && b.d() != 0)
        {
            return b.d();
        }
        if (e != null)
        {
            return e.getHeight();
        } else
        {
            Display display = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            return point.y;
        }
    }

    public z a()
    {
        return b;
    }

    public void a(Bitmap bitmap)
    {
        e = bitmap;
        b.a(bitmap, false);
        b();
    }

    public void a(Uri uri)
    {
        (new s(this, this, uri)).execute(new Void[0]);
    }

    public void a(GLSurfaceView glsurfaceview)
    {
        c = glsurfaceview;
        c.setEGLContextClientVersion(2);
        c.setRenderer(b);
        c.setRenderMode(0);
        c.requestRender();
        b.a(c);
    }

    public void a(ScaleType scaletype)
    {
        f = scaletype;
        b.a(scaletype);
        b.b();
        e = null;
        b();
    }

    public void a(Rotation rotation, boolean flag, boolean flag1)
    {
        b.a(rotation, flag1, flag);
    }

    public void a(aa aa)
    {
        b.a(aa);
    }

    public void a(u u1)
    {
        d = u1;
        b.a(d);
        b();
    }

    public void a(Object obj)
    {
        b.a(obj);
    }

    public void a(byte abyte0[], int i, int j)
    {
        b.a(abyte0, i, j);
    }

    public Bitmap b(Bitmap bitmap)
    {
        if (g == 0 || bitmap.getWidth() <= g && bitmap.getHeight() <= g)
        {
            z z1 = new z(d);
            z1.a(Rotation.a, b.e(), b.f());
            z1.a(f);
            ag ag1 = new ag(bitmap.getWidth(), bitmap.getHeight(), b.a());
            ag1.a(z1);
            z1.a(bitmap, false);
            bitmap = ag1.b();
            d.h();
            z1.b();
            ag1.c();
        } else
        {
            int k2 = bitmap.getWidth();
            int l2 = bitmap.getHeight();
            Object obj = new ArrayList();
            int i1;
            for (i1 = g / 2; i1 + 512 > g; i1 /= 2) { }
            int j1;
            for (j1 = g / 2; j1 + 512 > g; j1 /= 2) { }
            for (int k1 = 0; k1 < l2; k1 += j1)
            {
                int l1 = 0;
                while (l1 < k2) 
                {
                    int j = l1 - 256;
                    int i2 = k1 - 256;
                    int l = j + i1 + 512;
                    int j2 = i2 + j1 + 512;
                    int k = l;
                    int i = j;
                    if (j < 0)
                    {
                        k = l - j;
                        i = 0;
                    }
                    l = j2;
                    j = i2;
                    if (i2 < 0)
                    {
                        l = j2 - i2;
                        j = 0;
                    }
                    j2 = k;
                    i2 = i;
                    if (k > k2)
                    {
                        i2 = i - (k - k2);
                        j2 = k2;
                    }
                    k = l;
                    i = j;
                    if (l > l2)
                    {
                        i = j - (l - l2);
                        k = l2;
                    }
                    Object obj1 = Bitmap.createBitmap(bitmap, i2, i, j2 - i2, k - i);
                    Object obj2 = new z(d);
                    ((z) (obj2)).a(Rotation.a, b.e(), b.f());
                    ((z) (obj2)).a(f);
                    ag ag2 = new ag(((Bitmap) (obj1)).getWidth(), ((Bitmap) (obj1)).getHeight(), b.a());
                    ag2.a(((android.opengl.GLSurfaceView.Renderer) (obj2)));
                    ((z) (obj2)).a(((Bitmap) (obj1)), false);
                    ag2.a();
                    ((z) (obj2)).b();
                    if (obj1 != bitmap)
                    {
                        ((Bitmap) (obj1)).recycle();
                    }
                    obj1 = new Rect(l1 - i2, k1 - i, ag2.b, ag2.c);
                    obj1.right = ((Rect) (obj1)).left + Math.min(i1, ag2.b);
                    obj1.bottom = ((Rect) (obj1)).top + Math.min(j1, ag2.c);
                    obj2 = new Rect(l1, k1, 0, 0);
                    if (l1 + i1 < k2)
                    {
                        obj2.right = l1 + i1;
                    } else
                    {
                        obj2.right = k2;
                    }
                    if (k1 + j1 < l2)
                    {
                        obj2.bottom = k1 + j1;
                    } else
                    {
                        obj2.bottom = l2;
                    }
                    ((ArrayList) (obj)).add(new t(this, ag2, ((Rect) (obj1)), ((Rect) (obj2))));
                    l1 += i1;
                }
            }

            bitmap.recycle();
            bitmap = Bitmap.createBitmap(k2, l2, android.graphics.Bitmap.Config.ARGB_8888);
            t t1;
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); t1.a.c())
            {
                t1 = (t)((Iterator) (obj)).next();
                t1.a.a(t1.b, t1.c, bitmap);
            }

            d.h();
        }
        b.a(d);
        if (e != null)
        {
            b.a(e, false);
        }
        b();
        return bitmap;
    }

    public void b()
    {
        if (c != null)
        {
            c.requestRender();
        }
    }

    public Bitmap c()
    {
        return e;
    }

    public void d()
    {
        b.b();
        e = null;
        b();
    }

    public Bitmap e()
    {
        Bitmap bitmap = b(e);
        if (e.isRecycled())
        {
            e = null;
        }
        return bitmap;
    }

    private class ScaleType extends Enum
    {

        public static final ScaleType a;
        public static final ScaleType b;
        public static final ScaleType c;
        public static final ScaleType d;
        public static final ScaleType e;
        public static final ScaleType f;
        public static final ScaleType g;
        private static final ScaleType h[];

        public static ScaleType valueOf(String s1)
        {
            return (ScaleType)Enum.valueOf(com/cyberlink/clgpuimage/GPUImage$ScaleType, s1);
        }

        public static ScaleType[] values()
        {
            return (ScaleType[])h.clone();
        }

        static 
        {
            a = new ScaleType("CENTER_INSIDE", 0);
            b = new ScaleType("CENTER_CROP", 1);
            c = new ScaleType("CENTER_INSIDE_CAMERA", 2);
            d = new ScaleType("SQUARE_CROP_INSIDE_CAMERA", 3);
            e = new ScaleType("CENTER_INSIDE_CAMERA_YUV_BUFFER", 4);
            f = new ScaleType("AS_DISAPLY", 5);
            g = new ScaleType("MANUALLY", 6);
            h = (new ScaleType[] {
                a, b, c, d, e, f, g
            });
        }

        private ScaleType(String s1, int i)
        {
            super(s1, i);
        }
    }

}
