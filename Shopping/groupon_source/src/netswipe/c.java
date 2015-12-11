// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.TextureView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package netswipe:
//            f, h, cz, i, 
//            e, dh, d, at, 
//            g

public class c
    implements android.view.TextureView.SurfaceTextureListener
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
    private at g;
    private i h;
    private cz i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private byte p[];
    private h q;
    private android.hardware.Camera.AutoFocusCallback r;

    public c(Context context, TextureView textureview, at at1, i i1, cz cz1)
    {
        c = false;
        d = false;
        r = new f(this);
        f = textureview;
        f.setSurfaceTextureListener(this);
        f.setOpaque(false);
        g = at1;
        j = 0;
        h = i1;
        i = cz1;
    }

    private android.hardware.Camera.Size a(int i1, int j1, android.hardware.Camera.Parameters parameters)
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
        j = j1;
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(j1, camerainfo);
        if (camerainfo.facing == 1)
        {
            flag = true;
        }
        l = flag;
        k = camerainfo.orientation;
        return Camera.open(j1);
    }

    private void a(SurfaceTexture surfacetexture, int i1, int j1)
    {
        float f1;
        float f2;
        float f3;
        int k1;
        int l1;
        boolean flag;
        flag = false;
        l1 = 0;
        f2 = 1.0F;
        Object obj;
        Camera camera;
        boolean flag1;
        try
        {
            e.setPreviewTexture(surfacetexture);
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceTexture surfacetexture)
        {
            dh.a("Exception in setPreviewTexture()", surfacetexture);
        }
        surfacetexture = e.getParameters();
        flag1 = Arrays.asList(a).contains(Build.MODEL);
        obj = surfacetexture.getSupportedFocusModes();
        if (obj != null)
        {
            if (!flag1 && ((List) (obj)).contains("continuous-picture"))
            {
                surfacetexture.setFocusMode("continuous-picture");
                n = false;
            } else
            if (!flag1 && ((List) (obj)).contains("continuous-video"))
            {
                surfacetexture.setFocusMode("continuous-video");
                n = false;
            } else
            if (((List) (obj)).contains("auto"))
            {
                surfacetexture.setFocusMode("auto");
                n = true;
            }
        }
        b = a(i1, j1, ((android.hardware.Camera.Parameters) (surfacetexture)));
        q = new h();
        if (i1 > j1)
        {
            f1 = (float)i1 / (float)j1;
        } else
        {
            f1 = (float)j1 / (float)i1;
        }
        f3 = (float)b.width / (float)b.height;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_778;
        }
        if (!i.e()) goto _L2; else goto _L1
_L1:
        surfacetexture.setPreviewSize(b.width, b.height);
        obj = e;
        if (i.g())
        {
            k1 = 270;
        } else
        {
            k1 = 90;
        }
        ((Camera) (obj)).setDisplayOrientation(k1);
        obj = q;
        camera = e;
        camera.getClass();
        obj.c = new android.hardware.Camera.Size(camera, b.height, b.width);
        if (f3 <= f1) goto _L4; else goto _L3
_L3:
        l1 = (int)(((float)b.width / (float)b.height) * (float)i1);
        f1 = (float)l1 / (float)j1;
        k1 = i1;
_L7:
        e.setParameters(surfacetexture);
_L10:
        surfacetexture = q;
        obj = e;
        obj.getClass();
        surfacetexture.a = new android.hardware.Camera.Size(((Camera) (obj)), k1, l1);
        surfacetexture = q;
        obj = e;
        obj.getClass();
        surfacetexture.b = new android.hardware.Camera.Size(((Camera) (obj)), i1, j1);
        q.d = l;
        if (h != null)
        {
            h.a(q);
        }
        surfacetexture = new Matrix();
        surfacetexture.setScale(f2, f1, i1 / 2, j1 / 2);
        f.post(new e(this, surfacetexture));
        return;
_L4:
        if (f3 >= f1) goto _L6; else goto _L5
_L5:
        k1 = (int)((float)j1 / ((float)b.width / (float)b.height));
        f2 = (float)k1 / (float)i1;
        l1 = j1;
        f1 = 1.0F;
          goto _L7
_L2:
        if (!i.f()) goto _L6; else goto _L8
_L8:
label0:
        {
            surfacetexture.setPreviewSize(b.width, b.height);
            Object obj1 = e;
            Camera camera1;
            if (i.g())
            {
                k1 = 180;
            } else
            {
                k1 = 0;
            }
            ((Camera) (obj1)).setDisplayOrientation(k1);
            obj1 = q;
            camera1 = e;
            camera1.getClass();
            obj1.c = new android.hardware.Camera.Size(camera1, b.width, b.height);
            if (f3 >= f1)
            {
                break label0;
            }
            l1 = (int)((float)i1 / ((float)b.width / (float)b.height));
            f1 = (float)l1 / (float)j1;
            k1 = i1;
        }
          goto _L7
        if (f3 <= f1) goto _L6; else goto _L9
_L9:
        k1 = (int)(((float)b.width / (float)b.height) * (float)j1);
        f2 = (float)k1 / (float)i1;
        l1 = j1;
        f1 = 1.0F;
          goto _L7
_L6:
        f1 = 1.0F;
        k1 = 0;
          goto _L7
        f1 = 1.0F;
        k1 = 0;
        l1 = ((flag) ? 1 : 0);
          goto _L10
    }

    static void a(c c1)
    {
        c1.n();
    }

    static void a(c c1, SurfaceTexture surfacetexture, int i1, int j1)
    {
        c1.a(surfacetexture, i1, j1);
    }

    static boolean a(c c1, boolean flag)
    {
        c1.o = flag;
        return flag;
    }

    static boolean b(c c1)
    {
        return c1.d;
    }

    static i c(c c1)
    {
        return c1.h;
    }

    static TextureView d(c c1)
    {
        return c1.f;
    }

    private void n()
    {
        e = a(j);
        if (h != null && e != null)
        {
            f.post(new d(this));
        }
    }

    public void a(boolean flag)
    {
        if (e == null || !a()) goto _L2; else goto _L1
_L1:
        Object obj;
        android.hardware.Camera.Parameters parameters;
        m = flag;
        parameters = e.getParameters();
        obj = parameters.getSupportedFlashModes();
        if (obj == null || !((List) (obj)).contains("torch")) goto _L4; else goto _L3
_L3:
        if (flag)
        {
            obj = "torch";
        } else
        {
            obj = "off";
        }
        parameters.setFlashMode(((String) (obj)));
_L6:
        e.setParameters(parameters);
_L2:
        return;
_L4:
        if (obj != null && ((List) (obj)).contains("on"))
        {
            String s;
            if (flag)
            {
                s = "on";
            } else
            {
                s = "off";
            }
            parameters.setFlashMode(s);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean a()
    {
        if (e != null)
        {
            List list = e.getParameters().getSupportedFlashModes();
            if (list != null && (list.contains("torch") || list.contains("on")))
            {
                return true;
            }
        }
        return false;
    }

    public void b(boolean flag)
    {
        a(false);
        if (c && e != null)
        {
            e.stopPreview();
        }
        c = false;
        d = flag;
    }

    public boolean b()
    {
        return l;
    }

    public void c(boolean flag)
    {
        g.a(f.getBitmap(), flag);
    }

    public boolean c()
    {
        return m;
    }

    public String d()
    {
        return String.format(Locale.GERMAN, "%dx%d", new Object[] {
            Integer.valueOf(b.width), Integer.valueOf(b.height)
        });
    }

    public void d(boolean flag)
    {
        g.a(flag);
    }

    public boolean e()
    {
        return Camera.getNumberOfCameras() > 1;
    }

    public void f()
    {
        boolean flag;
        if (!m)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
    }

    public void g()
    {
        if (n && !o && e != null)
        {
            o = true;
            dh.b("focus requested");
            e.autoFocus(r);
        }
    }

    public void h()
    {
        if (e != null)
        {
            e.startPreview();
            if (p == null)
            {
                p = new byte[(b.width * b.height * ImageFormat.getBitsPerPixel(17)) / 8];
            }
            e.addCallbackBuffer(p);
            e.setPreviewCallbackWithBuffer(h);
            c = true;
            d = false;
        }
    }

    public void i()
    {
        if (e != null && p != null)
        {
            e.addCallbackBuffer(p);
        }
    }

    public void j()
    {
        if (e != null)
        {
            e.release();
            e = null;
        }
    }

    public void k()
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
        j = j + 1;
        if (j >= i1)
        {
            j = 0;
        }
        b(false);
        j();
        (new Thread(new g(this, f.getSurfaceTexture(), f.getWidth(), f.getHeight()))).start();
        return;
    }

    public void l()
    {
        onSurfaceTextureSizeChanged(f.getSurfaceTexture(), f.getWidth(), f.getHeight());
    }

    public void m()
    {
        g.a();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i1, int j1)
    {
        (new Thread(new g(this, surfacetexture, i1, j1))).start();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i1, int j1)
    {
        if (e != null)
        {
            if (h != null)
            {
                h.b();
            }
            e.stopPreview();
            a(surfacetexture, i1, j1);
            if (!d)
            {
                h();
            }
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }

}
