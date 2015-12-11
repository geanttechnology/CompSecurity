// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import com.jumio.commons.camera.ImageData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package jumiomobile:
//            j, s, l, n, 
//            i, ab, h, u, 
//            ao, d, o, m, 
//            k, p, by

public class g
    implements android.view.TextureView.SurfaceTextureListener, android.view.View.OnClickListener, android.view.View.OnTouchListener
{

    private static final String a[] = {
        "GT-I9100", "SPH-D710", "SGH-T989", "SCH-I605", "SAMSUNG-SGH-I727", "GT-I9100G", "SAMSUNG-SGH-I777", "SPH-D710BST", "GT-I9100P", "GT-I9100T", 
        "SGH-S959G", "SGH-T989D", "SGH-I727R", "GT-I9100M", "SPH-D710VMUB", "SAMSUNG-SGH-T989", "SGH-I757M", "SGH-I777", "GT-I9210", "GT-I9105P", 
        "GT-I9105", "GT-I9105I", "GT-I9105G", "SAMSUNG-SGH-I717", "SGH-T879", "SGH-I717M", "SGH-I717R", "GT-N7000", "GT-N7005", "DROIDX"
    };
    private android.hardware.Camera.Size b;
    private boolean c;
    private boolean d;
    private Camera e;
    private TextureView f;
    private s g;
    private ao h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private byte p[];
    private l q;
    private ExecutorService r;
    private d s;
    private final Object t = new Object();
    private final Object u = new Object();
    private android.hardware.Camera.AutoFocusCallback v;

    public g(TextureView textureview, s s1, ao ao1, boolean flag)
    {
        c = false;
        d = false;
        k = false;
        l = false;
        m = false;
        n = false;
        o = false;
        v = new j(this);
        f = textureview;
        f.setSurfaceTextureListener(this);
        f.setOpaque(false);
        f.setOnClickListener(this);
        f.setOnTouchListener(this);
        a(flag);
        g = s1;
        h = ao1;
        r = Executors.newSingleThreadExecutor();
    }

    public static int a()
    {
        return Camera.getNumberOfCameras();
    }

    private android.hardware.Camera.Size a(android.hardware.Camera.Parameters parameters)
    {
        android.hardware.Camera.Size size = (android.hardware.Camera.Size)parameters.getSupportedPreviewSizes().get(0);
        Iterator iterator = parameters.getSupportedPreviewSizes().iterator();
        parameters = size;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            android.hardware.Camera.Size size1 = (android.hardware.Camera.Size)iterator.next();
            if (size1.width >= ((android.hardware.Camera.Size) (parameters)).width && size1.height >= ((android.hardware.Camera.Size) (parameters)).height)
            {
                parameters = size1;
            }
        } while (true);
        return parameters;
    }

    private Camera a(int i1)
    {
        boolean flag = false;
        int k1 = Camera.getNumberOfCameras();
        if (k1 <= 0)
        {
            i1 = 0;
        }
        int j1 = i1;
        if (i1 >= k1)
        {
            j1 = 0;
        }
        i = j1;
        Object obj = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(j1, ((android.hardware.Camera.CameraInfo) (obj)));
        if (((android.hardware.Camera.CameraInfo) (obj)).facing == 1)
        {
            flag = true;
        }
        k = flag;
        j = ((android.hardware.Camera.CameraInfo) (obj)).orientation;
        long l1 = System.currentTimeMillis();
        Throwable throwable = null;
        for (obj = null; obj == null && System.currentTimeMillis() - l1 <= 2000L;)
        {
            try
            {
                obj = Camera.open(j1);
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable)
            {
                obj = null;
            }
        }

        if (obj == null && throwable != null)
        {
            g.a(throwable);
        }
        return ((Camera) (obj));
    }

    static Camera a(g g1, Camera camera)
    {
        g1.e = camera;
        return camera;
    }

    static Object a(g g1)
    {
        return g1.u;
    }

    private void a(SurfaceTexture surfacetexture, int i1, int j1, boolean flag, int k1)
    {
label0:
        {
            synchronized (u)
            {
                if (e != null)
                {
                    break label0;
                }
            }
            return;
        }
        e.setPreviewTexture(surfacetexture);
_L10:
        obj;
        JVM INSTR monitorexit ;
        float f1;
        float f2;
        int l1;
        int i2;
        surfacetexture = e.getParameters();
        boolean flag2 = Arrays.asList(a).contains(Build.MODEL);
        obj = surfacetexture.getSupportedFocusModes();
        boolean flag1;
        if (obj != null)
        {
            if (!flag2 && ((List) (obj)).contains("continuous-picture"))
            {
                surfacetexture.setFocusMode("continuous-picture");
                m = false;
            } else
            if (!flag2 && ((List) (obj)).contains("continuous-video"))
            {
                surfacetexture.setFocusMode("continuous-video");
                m = false;
            } else
            if (((List) (obj)).contains("auto"))
            {
                surfacetexture.setFocusMode("auto");
                m = true;
            } else
            if (((List) (obj)).contains("macro"))
            {
                surfacetexture.setFocusMode("macro");
                m = true;
            }
        }
        b = a(((android.hardware.Camera.Parameters) (surfacetexture)));
        q = new l();
        if (i1 > j1)
        {
            f1 = (float)i1 / (float)j1;
        } else
        {
            f1 = (float)j1 / (float)i1;
        }
        try
        {
            surfacetexture.set("metering", "center");
        }
        catch (Exception exception) { }
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_870;
        }
        f2 = (float)b.width / (float)b.height;
        if (!flag) goto _L2; else goto _L1
_L1:
        surfacetexture.setPreviewSize(b.width, b.height);
        q.c = new n(b.height, b.width);
        if (f2 < f1) goto _L4; else goto _L3
_L3:
        l1 = (int)(((float)b.width / (float)b.height) * (float)i1);
        f2 = 1.0F;
        f1 = (float)l1 / (float)j1;
        i2 = i1;
_L13:
        obj = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(i, ((android.hardware.Camera.CameraInfo) (obj)));
        flag1 = false;
        k1;
        JVM INSTR tableswitch 0 3: default 312
    //                   0 800
    //                   1 806
    //                   2 813
    //                   3 821;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        k1 = ((flag1) ? 1 : 0);
_L16:
        if (((android.hardware.Camera.CameraInfo) (obj)).facing == 1)
        {
            k1 = (360 - (k1 + ((android.hardware.Camera.CameraInfo) (obj)).orientation) % 360) % 360;
        } else
        {
            k1 = ((((android.hardware.Camera.CameraInfo) (obj)).orientation - k1) + 360) % 360;
        }
        e.setDisplayOrientation(k1);
        e.setParameters(surfacetexture);
        q.e = k1;
_L17:
        q.a = new n(i2, l1);
        q.b = new n(i1, j1);
        q.d = k;
        q.f = surfacetexture.getPreviewFormat();
        if (g != null)
        {
            g.a(q);
        }
        surfacetexture = new Matrix();
        surfacetexture.setScale(f2, f1, (float)i1 / 2.0F, (float)j1 / 2.0F);
        f.post(new i(this, surfacetexture));
        return;
        surfacetexture;
        ab.a("CameraManager", "Exception in setPreviewTexture()", surfacetexture);
          goto _L10
        surfacetexture;
        obj;
        JVM INSTR monitorexit ;
        throw surfacetexture;
_L4:
        if (f2 >= f1) goto _L12; else goto _L11
_L11:
        i2 = (int)((float)j1 / ((float)b.width / (float)b.height));
        f2 = (float)i2 / (float)i1;
        f1 = 1.0F;
        l1 = j1;
          goto _L13
_L2:
label1:
        {
            surfacetexture.setPreviewSize(b.width, b.height);
            q.c = new n(b.width, b.height);
            if (f2 > f1)
            {
                break label1;
            }
            l1 = (int)((float)i1 / ((float)b.width / (float)b.height));
            f2 = 1.0F;
            f1 = (float)l1 / (float)j1;
            i2 = i1;
        }
        if (true) goto _L13; else goto _L14
_L14:
        if (f2 <= f1) goto _L12; else goto _L15
_L15:
        i2 = (int)(((float)b.width / (float)b.height) * (float)j1);
        f2 = (float)i2 / (float)i1;
        f1 = 1.0F;
        l1 = j1;
          goto _L13
_L6:
        k1 = 0;
          goto _L16
_L7:
        k1 = 90;
          goto _L16
_L8:
        k1 = 180;
          goto _L16
_L9:
        k1 = 270;
          goto _L16
_L12:
        f1 = 1.0F;
        f2 = 1.0F;
        l1 = 0;
        i2 = 0;
          goto _L13
        f1 = 1.0F;
        f2 = 1.0F;
        l1 = 0;
        i2 = 0;
          goto _L17
    }

    static void a(g g1, SurfaceTexture surfacetexture, int i1, int j1, boolean flag, int k1)
    {
        g1.a(surfacetexture, i1, j1, flag, k1);
    }

    public static boolean a(Context context)
    {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    }

    static boolean a(g g1, boolean flag)
    {
        g1.c = flag;
        return flag;
    }

    static byte[] a(g g1, byte abyte0[])
    {
        g1.p = abyte0;
        return abyte0;
    }

    static void b(g g1)
    {
        g1.p();
    }

    static boolean b(g g1, boolean flag)
    {
        g1.n = flag;
        return flag;
    }

    static boolean c(g g1)
    {
        return g1.d;
    }

    static Camera d(g g1)
    {
        return g1.e;
    }

    static s e(g g1)
    {
        return g1.g;
    }

    static boolean f(g g1)
    {
        return g1.c;
    }

    static byte[] g(g g1)
    {
        return g1.p;
    }

    static TextureView h(g g1)
    {
        return g1.f;
    }

    private void p()
    {
        synchronized (u)
        {
            e = a(i);
        }
        boolean flag = b();
        if (g != null && e != null)
        {
            f.post(new h(this, flag));
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int i1, int j1)
    {
        int k1 = f.getWidth();
        int l1 = f.getHeight();
        float f1 = (float)i1 / (float)k1;
        float f2 = (float)j1 / (float)l1;
        i1 = (int)(f1 * 2000F - 1000F);
        j1 = (int)(f2 * 2000F - 1000F);
        Object obj = u;
        obj;
        JVM INSTR monitorenter ;
        if (!m || n || e == null) goto _L2; else goto _L1
_L1:
        n = true;
        e.autoFocus(v);
_L4:
        return;
_L2:
        if (m || n || e == null) goto _L4; else goto _L3
_L3:
        ArrayList arraylist;
        Rect rect = new Rect(i1 - 50, j1 - 50, 50, 50);
        arraylist = new ArrayList();
        arraylist.add(new android.hardware.Camera.Area(rect, 1));
        if (e.getParameters().getMaxNumFocusAreas() > 0)
        {
            e.getParameters().setFocusAreas(arraylist);
        }
        if (e.getParameters().getMaxNumMeteringAreas() > 0)
        {
            e.getParameters().setMeteringAreas(arraylist);
        }
          goto _L4
        Object obj1;
        obj1;
        ((Exception) (obj1)).printStackTrace();
          goto _L4
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void a(ImageData imagedata)
    {
        u u1;
        if (c())
        {
            u1 = u.a;
        } else
        {
            u1 = u.b;
        }
        imagedata.a(u1);
        imagedata.a(h.b());
        imagedata.a(q.c);
        imagedata.a(d());
    }

    public void a(by by)
    {
        synchronized (t)
        {
            if (s == null)
            {
                s = new d(by);
                s.start();
            }
        }
        return;
        by;
        obj;
        JVM INSTR monitorexit ;
        throw by;
    }

    public void a(boolean flag)
    {
        i = 0;
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        int j1 = Camera.getNumberOfCameras();
        int i1 = 0;
        do
        {
label0:
            {
                if (i1 < j1)
                {
                    Camera.getCameraInfo(i1, camerainfo);
                    boolean flag1;
                    if (camerainfo.facing == 1)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    k = flag1;
                    if (!flag || camerainfo.facing != 1)
                    {
                        break label0;
                    }
                    i = i1;
                }
                return;
            }
            if (!flag && camerainfo.facing == 0)
            {
                i = i1;
                return;
            }
            i1++;
        } while (true);
    }

    public void b(boolean flag)
    {
        Object obj = t;
        obj;
        JVM INSTR monitorenter ;
        if (s == null) goto _L2; else goto _L1
_L1:
        d d1 = s;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (d()) goto _L4; else goto _L5
_L5:
        flag = true;
_L7:
        d1.a(flag);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean b()
    {
        Object obj = u;
        obj;
        JVM INSTR monitorenter ;
        List list;
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        list = e.getParameters().getSupportedFlashModes();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        if (list.contains("torch") || list.contains("on"))
        {
            return true;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c(boolean flag)
    {
        Object obj1 = u;
        obj1;
        JVM INSTR monitorenter ;
        if (e == null || !b()) goto _L2; else goto _L1
_L1:
        Object obj;
        android.hardware.Camera.Parameters parameters;
        l = flag;
        parameters = e.getParameters();
        obj = parameters.getSupportedFlashModes();
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (!((List) (obj)).contains("torch")) goto _L4; else goto _L5
_L5:
        if (flag)
        {
            obj = "torch";
        } else
        {
            obj = "off";
        }
        parameters.setFlashMode(((String) (obj)));
_L7:
        e.setParameters(parameters);
_L2:
        obj1;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (obj == null) goto _L7; else goto _L6
_L6:
        if (!((List) (obj)).contains("on")) goto _L7; else goto _L8
_L8:
        if (flag)
        {
            obj = "on";
        } else
        {
            obj = "off";
        }
        parameters.setFlashMode(((String) (obj)));
          goto _L7
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public boolean c()
    {
        return k;
    }

    public void d(boolean flag)
    {
        r.submit(new o(this));
        d = flag;
    }

    public boolean d()
    {
        return l;
    }

    public boolean e()
    {
        return m && n;
    }

    public String f()
    {
        return String.format(Locale.GERMAN, "%dx%d", new Object[] {
            Integer.valueOf(b.width), Integer.valueOf(b.height)
        });
    }

    public boolean g()
    {
        return Camera.getNumberOfCameras() > 1;
    }

    public void h()
    {
        boolean flag;
        if (!l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c(flag);
    }

    public void i()
    {
        synchronized (t)
        {
            if (s != null)
            {
                s.interrupt();
                s = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void j()
    {
        a(f.getWidth() / 2, f.getHeight() / 2);
    }

    public void k()
    {
        Object obj = u;
        obj;
        JVM INSTR monitorenter ;
        Camera camera = e;
        if (camera == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        Exception exception;
        try
        {
            e.startPreview();
        }
        catch (Exception exception1) { }
        if (p == null)
        {
            p = new byte[(b.width * b.height * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        e.addCallbackBuffer(p);
        e.setPreviewCallbackWithBuffer(g);
        c = true;
        d = false;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void l()
    {
        synchronized (u)
        {
            if (e != null && p != null)
            {
                e.addCallbackBuffer(p);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void m()
    {
        r.submit(new m(this));
        i();
    }

    public void n()
    {
        int i1;
        try
        {
            i1 = Camera.getNumberOfCameras();
        }
        catch (Exception exception)
        {
            return;
        }
        if (i1 <= 0)
        {
            return;
        }
        i = i + 1;
        if (i >= i1)
        {
            i = 0;
        }
        d(false);
        m();
        r.submit(new k(this, f.getSurfaceTexture(), f.getWidth(), f.getHeight(), h.h(), h.a()));
        return;
    }

    public void o()
    {
        onSurfaceTextureSizeChanged(f.getSurfaceTexture(), f.getWidth(), f.getHeight());
    }

    public void onClick(View view)
    {
        j();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i1, int j1)
    {
        r.submit(new k(this, surfacetexture, i1, j1, h.h(), h.a()));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        d(d);
        m();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i1, int j1)
    {
        r.submit(new p(this, surfacetexture, i1, j1, h.h(), h.a()));
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i1;
        int j1;
        i1 = (int)motionevent.getX();
        j1 = (int)motionevent.getY();
        motionevent.getAction();
        JVM INSTR tableswitch 0 0: default 36
    //                   0 38;
           goto _L1 _L2
_L1:
        return false;
_L2:
        a(i1, j1);
        if (true) goto _L1; else goto _L3
_L3:
    }

}
