// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import bxw;
import bxx;
import bxz;
import bya;
import byb;
import byc;
import byh;
import byi;
import byo;
import byp;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.util.concurrent.Semaphore;

// Referenced classes of package jp.co.cyberagent.android.gpuimage:
//            Rotation

public class GPUImage
    implements byo
{

    private static boolean h = false;
    byb a;
    private final Context b;
    private final byi c;
    private GLSurfaceView d;
    private byh e;
    private Bitmap f;
    private ScaleType g;
    private String i;

    public GPUImage(Context context)
    {
        g = ScaleType.CENTER_INSIDE;
        i = "GPUImage";
        try
        {
            a = (byb)context;
        }
        catch (Exception exception) { }
        if (!a(context))
        {
            throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
        } else
        {
            Log.e("TEST JAR", "TEST JAR Error");
            b = context;
            e = new byh();
            c = new byi(e, this);
            return;
        }
    }

    public static byh a(GPUImage gpuimage)
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

    private void b(Camera camera)
    {
        c.a(camera);
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

    public static byi c(GPUImage gpuimage)
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

    public void a(int j)
    {
        Rotation rotation;
        if (c == null)
        {
            return;
        }
        rotation = Rotation.NORMAL;
        j;
        JVM INSTR lookupswitch 3: default 48
    //                   90: 75
    //                   180: 82
    //                   270: 89;
           goto _L1 _L2 _L3 _L4
_L1:
        c.a(rotation, c.d(), c.e());
        b();
        return;
_L2:
        rotation = Rotation.ROTATION_90;
        continue; /* Loop/switch isn't completed */
_L3:
        rotation = Rotation.ROTATION_180;
        continue; /* Loop/switch isn't completed */
_L4:
        rotation = Rotation.ROTATION_270;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void a(Bitmap bitmap)
    {
        a(bitmap, false);
        f = bitmap;
    }

    public void a(Bitmap bitmap, String s, String s1, bya bya)
    {
        (new byc(this, bitmap, s, s1, bya)).execute(new Void[0]);
    }

    public void a(Camera camera)
    {
        camera.setPreviewCallback(c);
    }

    public void a(Camera camera, int j, boolean flag, boolean flag1)
    {
        d.setRenderMode(1);
        if (android.os.Build.VERSION.SDK_INT > 14)
        {
            b(camera);
        } else
        {
            camera.setPreviewCallback(c);
            camera.startPreview();
        }
        camera = Rotation.NORMAL;
        j % 360;
        JVM INSTR lookupswitch 3: default 64
    //                   90: 95
    //                   180: 102
    //                   270: 109;
           goto _L1 _L2 _L3 _L4
_L1:
        c.a(camera, flag, flag1);
        b();
        return;
_L2:
        camera = Rotation.ROTATION_90;
        continue; /* Loop/switch isn't completed */
_L3:
        camera = Rotation.ROTATION_180;
        continue; /* Loop/switch isn't completed */
_L4:
        camera = Rotation.ROTATION_270;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void a(Uri uri)
    {
        (new bxz(this, this, uri)).execute(new Void[0]);
    }

    public void a(GLSurfaceView glsurfaceview)
    {
        d = glsurfaceview;
        d.setEGLContextClientVersion(2);
        d.setRenderer(c);
        d.setRenderMode(0);
        d.requestRender();
    }

    public void a(byh byh1)
    {
        e = byh1;
        c.a(e);
        a();
    }

    public void a(File file)
    {
        (new bxx(this, this, file)).execute(new Void[0]);
    }

    public void a(String s, String s1, bya bya)
    {
        a(f, s, s1, bya);
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
            c.a(new bxw(this, ((Semaphore) (obj))));
            a();
            byp byp1;
            try
            {
                ((Semaphore) (obj)).acquire();
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
        obj = new byi(e);
        ((byi) (obj)).b(Rotation.NORMAL, c.d(), c.e());
        ((byi) (obj)).a(g);
        byp1 = new byp(bitmap.getWidth(), bitmap.getHeight());
        byp1.a(((android.opengl.GLSurfaceView.Renderer) (obj)));
        ((byi) (obj)).a(bitmap, false);
        bitmap = byp1.a();
        e.g();
        ((byi) (obj)).a();
        byp1.b();
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
