// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage;

import aei;
import aek;
import ael;
import aem;
import aen;
import aeo;
import aep;
import aeq;
import aer;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.util.concurrent.Semaphore;

// Referenced classes of package jp.co.cyberagent.android.gpuimage:
//            Rotation

public class GPUImage
    implements aeq
{

    private static boolean h = false;
    aem a;
    private final Context b;
    private final aep c;
    private GLSurfaceView d;
    private aeo e;
    private Bitmap f;
    private ScaleType g;
    private String i;

    public GPUImage(Context context)
    {
        g = ScaleType.CENTER_INSIDE;
        i = "GPUImage";
        try
        {
            a = (aem)context;
        }
        catch (Exception exception) { }
        if (!a(context))
        {
            throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
        } else
        {
            Log.e("TEST JAR", "TEST JAR Error");
            b = context;
            e = new aeo();
            c = new aep(e, this);
            return;
        }
    }

    static aeo a(GPUImage gpuimage)
    {
        return gpuimage.e;
    }

    private void a(Bitmap bitmap, boolean flag)
    {
        c.a(bitmap, flag);
        a();
    }

    private boolean a(Context context)
    {
        return ((ActivityManager)context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 0x20000;
    }

    public static Context b(GPUImage gpuimage)
    {
        return gpuimage.b;
    }

    private int c()
    {
        if (c != null && c.b() != 0)
        {
            return c.b();
        }
        if (f != null)
        {
            return f.getWidth();
        } else
        {
            return ((WindowManager)b.getSystemService("window")).getDefaultDisplay().getWidth();
        }
    }

    public static aep c(GPUImage gpuimage)
    {
        return gpuimage.c;
    }

    private int d()
    {
        if (c != null && c.c() != 0)
        {
            return c.c();
        }
        if (f != null)
        {
            return f.getHeight();
        } else
        {
            return ((WindowManager)b.getSystemService("window")).getDefaultDisplay().getHeight();
        }
    }

    public static int d(GPUImage gpuimage)
    {
        return gpuimage.c();
    }

    public static int e(GPUImage gpuimage)
    {
        return gpuimage.d();
    }

    public static ScaleType f(GPUImage gpuimage)
    {
        return gpuimage.g;
    }

    public void a()
    {
        if (d != null)
        {
            d.requestRender();
        }
    }

    public void a(aeo aeo1)
    {
        e = aeo1;
        c.a(e);
        a();
    }

    public void a(Bitmap bitmap)
    {
        a(bitmap, false);
        f = bitmap;
    }

    public void a(Bitmap bitmap, String s, String s1, ael ael)
    {
        (new aen(this, bitmap, s, s1, ael)).execute(new Void[0]);
    }

    public void a(Uri uri)
    {
        (new aek(this, this, uri)).execute(new Void[0]);
    }

    public void a(GLSurfaceView glsurfaceview)
    {
        d = glsurfaceview;
        d.setEGLContextClientVersion(2);
        d.setRenderer(c);
        d.setRenderMode(0);
        d.requestRender();
    }

    public void a(File file)
    {
        (new aei(this, this, file)).execute(new Void[0]);
    }

    public void a(String s, String s1, ael ael)
    {
        a(f, s, s1, ael);
    }

    public void a(boolean flag)
    {
        h = flag;
        if (a != null)
        {
            a.a(h);
        }
    }

    public Bitmap b(Bitmap bitmap)
    {
        if (d != null)
        {
            c.a();
            Object obj = new Semaphore(0);
            c.a(new Runnable(((Semaphore) (obj))) {

                final Semaphore a;
                final GPUImage b;

                public void run()
                {
                    GPUImage.a(b).e();
                    a.release();
                }

            
            {
                b = GPUImage.this;
                a = semaphore;
                super();
            }
            });
            a();
            aer aer1;
            try
            {
                ((Semaphore) (obj)).acquire();
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
        obj = new aep(e);
        ((aep) (obj)).a(Rotation.NORMAL, c.d(), c.e());
        ((aep) (obj)).a(g);
        aer1 = new aer(bitmap.getWidth(), bitmap.getHeight());
        aer1.a(((android.opengl.GLSurfaceView.Renderer) (obj)));
        ((aep) (obj)).a(bitmap, false);
        bitmap = aer1.a();
        e.e();
        ((aep) (obj)).a();
        aer1.b();
        c.a(e);
        if (f != null)
        {
            c.a(f, false);
        }
        a();
        return bitmap;
        Exception exception;
        exception;
        bitmap = null;
_L2:
        Log.e(i, exception.toString());
        Crashlytics.logException(exception);
        return bitmap;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void b()
    {
        c.a();
        f = null;
        a();
    }


    private class ScaleType extends Enum
    {

        private static final ScaleType $VALUES[];
        public static final ScaleType CENTER_CROP;
        public static final ScaleType CENTER_INSIDE;

        public static ScaleType valueOf(String s)
        {
            return (ScaleType)Enum.valueOf(jp/co/cyberagent/android/gpuimage/GPUImage$ScaleType, s);
        }

        public static ScaleType[] values()
        {
            return (ScaleType[])$VALUES.clone();
        }

        static 
        {
            CENTER_INSIDE = new ScaleType("CENTER_INSIDE", 0);
            CENTER_CROP = new ScaleType("CENTER_CROP", 1);
            $VALUES = (new ScaleType[] {
                CENTER_INSIDE, CENTER_CROP
            });
        }

        private ScaleType(String s, int j)
        {
            super(s, j);
        }
    }

}
