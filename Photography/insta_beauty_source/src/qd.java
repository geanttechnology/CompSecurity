// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.FrameLayout;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class qd
{

    public int a;
    public Camera b;
    public boolean c;
    public android.hardware.Camera.Size d;
    public android.hardware.Camera.Size e;
    public android.hardware.Camera.Size f;
    public ArrayList g;
    byf h;
    private int i;
    private String j[] = {
        "off", "on", "auto"
    };
    private String k;
    private ss l;
    private Context m;
    private GPUImage n;
    private GLSurfaceView o;
    private qi p;
    private FrameLayout q;
    private boolean r;
    private boolean s;

    public qd(ss ss1, Context context, FrameLayout framelayout, qi qi1)
    {
        i = 0;
        k = "CameraLoader";
        a = 0;
        c = true;
        r = true;
        d = null;
        e = null;
        f = null;
        g = new ArrayList();
        s = true;
        h = null;
        l = ss1;
        m = context;
        p = qi1;
        q = framelayout;
        if (l.d())
        {
            a = l.a();
            c = true;
            return;
        } else
        {
            a = l.b();
            c = false;
            return;
        }
    }

    private List a(List list)
    {
        LinkedList linkedlist = new LinkedList();
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            if (((android.hardware.Camera.Size)list.get(i1)).width <= 1280 && ((android.hardware.Camera.Size)list.get(i1)).height <= 1280)
            {
                linkedlist.add(list.get(i1));
            }
        }

        return linkedlist;
    }

    static qi a(qd qd1)
    {
        return qd1.p;
    }

    private boolean a(android.hardware.Camera.Parameters parameters)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (parameters.getSupportedFlashModes() != null)
        {
            flag = flag1;
            if (parameters.getSupportedFlashModes().contains("off"))
            {
                flag = flag1;
                if (parameters.getSupportedFlashModes().contains("on"))
                {
                    flag = flag1;
                    if (parameters.getSupportedFlashModes().contains("auto"))
                    {
                        flag = true;
                    }
                }
            }
        }
        p.a(flag);
        return flag;
    }

    public static boolean c(int i1)
    {
        try
        {
            android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
            Camera.getCameraInfo(i1, camerainfo);
            i1 = camerainfo.facing;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return i1 == 1;
    }

    private Camera d(int i1)
    {
        return l.a(i1);
    }

    private void f()
    {
        if (b != null)
        {
            b.stopPreview();
            b.setPreviewCallback(null);
            b.release();
            b = null;
        }
    }

    public android.hardware.Camera.Size a(List list, int i1, int j1)
    {
        double d5;
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        d5 = (double)i1 / (double)j1;
        if (list != null) goto _L2; else goto _L1
_L1:
        obj = obj1;
_L4:
        return ((android.hardware.Camera.Size) (obj));
_L2:
        Object obj2 = a(list);
        double d1 = 1.7976931348623157E+308D;
        Iterator iterator = ((List) (obj2)).iterator();
        list = ((List) (obj));
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (android.hardware.Camera.Size)iterator.next();
            if (Math.abs((double)((android.hardware.Camera.Size) (obj)).width / (double)((android.hardware.Camera.Size) (obj)).height - d5) <= 0.050000000000000003D && (double)Math.abs(((android.hardware.Camera.Size) (obj)).height - j1) < d1)
            {
                d1 = Math.abs(((android.hardware.Camera.Size) (obj)).height - j1);
                list = ((List) (obj));
            }
        } while (true);
        obj = list;
        if (list != null)
        {
            continue;
        }
        obj2 = ((List) (obj2)).iterator();
        double d3 = 1.7976931348623157E+308D;
        double d2 = d1;
        d1 = d3;
        do
        {
            obj = list;
            if (!((Iterator) (obj2)).hasNext())
            {
                continue;
            }
            obj = (android.hardware.Camera.Size)((Iterator) (obj2)).next();
            double d4 = (double)((android.hardware.Camera.Size) (obj)).width / (double)((android.hardware.Camera.Size) (obj)).height;
            if (Math.abs(d4 - d5) <= d1 && d4 > 1.0D && (double)Math.abs(((android.hardware.Camera.Size) (obj)).height - j1) < d2)
            {
                d1 = Math.abs(d4 - d5);
                d2 = Math.abs(((android.hardware.Camera.Size) (obj)).height - j1);
                list = ((List) (obj));
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a()
    {
        try
        {
            b(a);
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            Log.e("\u76F8\u673A\u9519\u8BEF\uFF1A", exception.toString());
            b = null;
            oj.a(m, new qe(this));
        }
        FlurryAgent.onPageView();
    }

    protected void a(float f1)
    {
        System.out.println("realBeauty To Camera!");
        Bitmap bitmap = Bitmap.createBitmap(256, 256, android.graphics.Bitmap.Config.ARGB_8888);
        ih.a(bitmap, 1.0F);
        h = new byf(bitmap);
        h.d = 0.66F;
        n.a(h);
    }

    public void a(int i1)
    {
        i = i1;
    }

    public void a(boolean flag)
    {
        s = flag;
    }

    public void b()
    {
        g.clear();
        try
        {
            f();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    protected void b(float f1)
    {
        if (h != null)
        {
            h.d = f1;
        }
    }

    public void b(int i1)
    {
        b = d(i1);
        if (b == null)
        {
            FlurryAgent.onError((new StringBuilder()).append(k).append("013").toString(), "unexpected", "013");
            throw new Exception("mCameraInstance get is null");
        }
        Object obj = b.getParameters();
        if (a(((android.hardware.Camera.Parameters) (obj))))
        {
            ((android.hardware.Camera.Parameters) (obj)).setFlashMode(j[e()]);
        }
        ((android.hardware.Camera.Parameters) (obj)).setExposureCompensation(0);
        i1 = m.getResources().getDisplayMetrics().heightPixels;
        d = a(((android.hardware.Camera.Parameters) (obj)).getSupportedPreviewSizes(), 800, 600);
        if (d != null)
        {
            ((android.hardware.Camera.Parameters) (obj)).setPreviewSize(d.width, d.height);
            p.a(d);
        }
        List list = ((android.hardware.Camera.Parameters) (obj)).getSupportedPictureSizes();
        float f1 = pu.d();
        char c1 = '\u0258';
        i1 = 800;
        char c2;
        int j1;
        boolean flag;
        if (f1 >= 0.7F)
        {
            if (f1 > 0.7F && f1 < 1.7F)
            {
                i1 = 1600;
                c1 = '\u04B0';
            } else
            if (f1 > 1.7F)
            {
                i1 = 3200;
                c1 = '\u0960';
            }
        }
        j1 = i1;
        c2 = c1;
        if (c1 * i1 > 0x2dc6c0)
        {
            c2 = '\u0465';
            j1 = 2000;
        }
        e = a(list, j1, c2);
        if (e != null)
        {
            ((android.hardware.Camera.Parameters) (obj)).setPictureSize(e.width, e.height);
            pt.a(e, m);
            if (f == null)
            {
                f = e;
                g.add(f);
            } else
            if (f.height != e.height && f.width != e.width)
            {
                g.add(e);
            }
        }
        b.setParameters(((android.hardware.Camera.Parameters) (obj)));
        if (n == null)
        {
            n = new GPUImage(m);
            if (o == null)
            {
                o = new GLSurfaceView(((Activity)m).getBaseContext());
                q.addView(o, new android.widget.FrameLayout.LayoutParams(-1, -1));
            }
            n.a(o);
            if (ActivityCamera.a() && pt.b(pt.n, m, true))
            {
                a(0.8F);
            }
        }
        p.a(n);
        if (c)
        {
            i1 = (d() + pt.b(pt.k, m, 0)) % 360;
        } else
        {
            i1 = (d() + pt.b(pt.l, m, 0)) % 360;
        }
        Log.e(k, (new StringBuilder()).append("hascorrectpresize angle:").append(i1).toString());
        obj = new su();
        l.a(a, ((su) (obj)));
        if (((su) (obj)).a == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        n.a(b, i1, flag, false);
        obj = new pu(a, m, new qg(this));
        if (((pu) (obj)).a(1))
        {
            ((pu) (obj)).c();
            ((pu) (obj)).b(1);
        }
        (new Handler()).postDelayed(new qh(this), 1000L);
    }

    public void c()
    {
        f();
        a = (a + 1) % l.c();
        boolean flag;
        if (!c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            c = flag;
            b(a);
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            oj.a(m, new qf(this));
        }
        FlurryAgent.onPageView();
        return;
    }

    public int d()
    {
        int i1 = 0;
        if (l != null)
        {
            i1 = l.a((Activity)m, a);
        }
        return i1;
    }

    public int e()
    {
        return i;
    }
}
