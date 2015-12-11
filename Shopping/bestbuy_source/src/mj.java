// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.widget.Toast;
import java.io.IOException;
import java.util.List;

public final class mj
{

    static final int a;
    private static final String b = mj.getSimpleName();
    private static mj c;
    private final Context d;
    private final mi e;
    private Camera f;
    private Rect g;
    private Rect h;
    private boolean i;
    private boolean j;
    private final boolean k;
    private final ml l;
    private final mh m = new mh();

    private mj(Context context)
    {
        d = context;
        e = new mi(context);
        boolean flag;
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = flag;
        l = new ml(e, k);
    }

    public static mj a()
    {
        return c;
    }

    public static void a(Context context)
    {
        if (c == null)
        {
            c = new mj(context);
        }
    }

    public me a(byte abyte0[], int i1, int j1)
    {
        Rect rect = h();
        int k1 = e.c();
        String s = e.d();
        switch (k1)
        {
        default:
            if ("yuv420p".equals(s))
            {
                return new me(abyte0, i1, j1, rect.left, rect.top, rect.width(), rect.height());
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unsupported picture format: ").append(k1).append('/').append(s).toString());
            }

        case 16: // '\020'
        case 17: // '\021'
            return new me(abyte0, i1, j1, rect.left, rect.top, rect.width(), rect.height());
        }
    }

    public void a(Handler handler, int i1)
    {
label0:
        {
            if (f != null && j)
            {
                l.a(handler, i1);
                if (!k)
                {
                    break label0;
                }
                f.setOneShotPreviewCallback(l);
            }
            return;
        }
        f.setPreviewCallback(l);
    }

    public void a(SurfaceHolder surfaceholder)
    {
        if (f == null)
        {
            f = Camera.open();
            if (f == null)
            {
                throw new IOException();
            }
            f.setPreviewDisplay(surfaceholder);
            if (!i)
            {
                i = true;
                e.a(f);
            }
            e.b(f);
        }
    }

    public me b(byte abyte0[], int i1, int j1)
    {
        Rect rect = h();
        int k1 = e.c();
        String s = e.d();
        switch (k1)
        {
        default:
            if ("yuv420p".equals(s))
            {
                return new me(abyte0, i1, j1, rect.left, rect.top, rect.width(), rect.height());
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unsupported picture format: ").append(k1).append('/').append(s).toString());
            }

        case 16: // '\020'
        case 17: // '\021'
            return new me(abyte0, i1, j1, rect.left, rect.top, rect.width(), rect.height());
        }
    }

    public void b()
    {
        if (f != null)
        {
            mk.a();
            f.release();
            f = null;
        }
    }

    public void b(Handler handler, int i1)
    {
        if (f != null && j)
        {
            m.a(handler, i1);
            f.autoFocus(m);
        }
    }

    public boolean c()
    {
        android.hardware.Camera.Parameters parameters = f.getParameters();
        List list = parameters.getSupportedFlashModes();
        if (list != null && list.contains("torch"))
        {
            parameters.setFlashMode("torch");
            f.setParameters(parameters);
            f.startPreview();
            return true;
        } else
        {
            Toast.makeText(d, "Flash not supported in this device.", 0).show();
            return false;
        }
    }

    public void d()
    {
        android.hardware.Camera.Parameters parameters = f.getParameters();
        parameters.setFlashMode("off");
        f.setParameters(parameters);
        f.startPreview();
    }

    public void e()
    {
        if (f != null && !j)
        {
            f.startPreview();
            j = true;
        }
    }

    public void f()
    {
        if (f != null && j)
        {
            if (!k)
            {
                f.setPreviewCallback(null);
            }
            f.stopPreview();
            l.a(null, 0);
            m.a(null, 0);
            j = false;
        }
    }

    public Rect g()
    {
        int i1 = 800;
        int j1 = 240;
        Point point = e.b();
        if (g == null)
        {
            if (f == null)
            {
                return null;
            }
            int k1 = (point.x * 3) / 4;
            int l1;
            if (k1 < 240)
            {
                i1 = 240;
            } else
            if (k1 <= 800)
            {
                i1 = k1;
            }
            k1 = (point.y * 3) / 4;
            if (k1 >= 240)
            {
                if (k1 > 700)
                {
                    j1 = 700;
                } else
                {
                    j1 = k1;
                }
            }
            k1 = (point.x - i1) / 2;
            l1 = (point.y - j1) / 2;
            g = new Rect(k1, l1, i1 + k1, j1 + l1);
        }
        return g;
    }

    public Rect h()
    {
        if (h == null)
        {
            Rect rect = new Rect(g());
            Point point = e.a();
            Point point1 = e.b();
            rect.left = (rect.left * point.x) / point1.x;
            rect.right = (rect.right * point.x) / point1.x;
            rect.top = (rect.top * point.y) / point1.y;
            int i1 = rect.bottom;
            rect.bottom = (point.y * i1) / point1.y;
            h = rect;
        }
        return h;
    }

    static 
    {
        int i1;
        try
        {
            i1 = Integer.parseInt(android.os.Build.VERSION.SDK);
        }
        catch (NumberFormatException numberformatexception)
        {
            i1 = 10000;
        }
        a = i1;
    }
}
