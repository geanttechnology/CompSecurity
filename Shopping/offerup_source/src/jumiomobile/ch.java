// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package jumiomobile:
//            aw, cv, ck

public abstract class ch
{

    protected static int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;
    private static final Object k = new Object();
    private static ch l = null;
    private static ck m;
    protected aw g;
    protected SparseArray h;
    protected SparseArray i;
    protected String j;

    protected ch()
    {
        g = new aw();
        h = null;
        i = null;
        j = "";
        h = new SparseArray();
        h.append(b, "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");
        h.append(c, "iVBORw0KGgoAAAANSUhEUgAAAD4AAAA+CAMAAABEH1h2AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAA/FBMVEUAAABOTk5OTk5OTk5OTk5OTk50dHTZ2dn4+Pj///9OTk6IiIhOTk5VVVXy8vJOTk6kpKROTk7Hx8dOTk7T09POzs5mZmbX19fKyspOTk5OTk5OTk5OTk5OTk5OTk6xsbHt7e39/f3t7e3U1NTV1dVOTk6wsLBOTk7s7Oz9/f1OTk7r6+uurq7U1NROTk5QUFBOTk5OTk5OTk5OTk5OTk5TU1OVlZXFxcXg4ODw8PD7+/tOTk5OTk6Ghob5+flOTk52dnbf39////+Tk5P6+vr5+fnc3Nz8/PxbW1t5eXlOTk5OTk5OTk6oqKhOTk5OTk5bW1tOTk5OTk4AAABaLhDcAAAAU3RSTlMADy9GTSdYiquzIV8BT6IWayV+K4eDU4mABR09Sw0tcZ2xnoiJHHA8nLA7nHCHDE4RJDRASU5kfJKhrRMzXaooWZGyY6urjq9QWgMJB2wYDlECLg3U97EAAAABYktHRACIBR1IAAAACXBIWXMAAAsTAAALEwEAmpwYAAABoUlEQVRIx+3XWVeCQBgG4FFBRXEtxRTH3NoT911zLbXF6v//mECgg8bAMNPpdOF76fgozrwHPgHYj8vtYZDxuF3AMqzX5+eQ8fu8rJUOBC3w7gOCAbTmQ2HOJuEQj+SRqJ3muGgEyWNxex6PIfnJqfKGRBIRQVlNsTY8xZ6ZRl+15SSrv8/TGVHMpAl5FubO8/lCDmaJOCyqR1WCJLx8oR91Lk3AL690XsgQcPFa53nx7/nNLdXFl++otg7Ae5qDAxW62iillSTi0jpb/Vecr9bqjSbDNBv1WpV3yLOw1e50e32O6/e6nXZL2X1sPhiOSmPj7XVcGg0HuPxhMp0d3p9n0wkuny/MbvCLOR4vLs0fEMtHLI58Sj5hcesc+ZEfhHK2oZysKOc6yqmSdqbdTdQrdYpbC4dz3cp2olayUce4JJeAz3uD3cbefkfmincgfnCHvgINfx0Urnrjqwx8QXKT0iq/P0nR+QSk4tzrGw0XJJpvF6QtNq+sDB1baxoAyVi9d/TO64XTWqdpuQOGfODXRtMkkTmFljmNBmD7iaG/AFVCatGQEyt2AAAAAElFTkSuQmCC");
        h.append(d, "iVBORw0KGgoAAAANSUhEUgAAAD4AAAA+CAMAAABEH1h2AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAn1BMVEUAAABOTk5OTk5OTk5OTk5OTk50dHTZ2dn4+Pj///9OTk6IiIhOTk5VVVXy8vJOTk6kpKROTk7Hx8dOTk7T09Po6OilpaVtbW1vb2/p6enKysrOzs5QUFBOTk5OTk5OTk7S0tJOTk5OTk7q6uqoqKhOTk5zc3NbW1tmZmZ5eXnX19dOTk5OTk5OTk5OTk5OTk5OTk5bW1tOTk5OTk4AAABd2ItmAAAANHRSTlMADy9GTSdYiquzIV8BT6IWayV+K4eZa1VWmoCDThoHG4UJC5psCFdQU1qJAwUtDBgOUQIuGWGxlgAAAAFiS0dEAIgFHUgAAAAJcEhZcwAACxMAAAsTAQCanBgAAAEaSURBVEjH7dfHFoIwEAXQKCDGChYsRBQbiGL9/3+TAHqCGoLMwoV5yzlc6lsMCGVTqSoqN0q1gnKj1fQ65qau17Q83Wjm4PgEzQZft9odLEin3eLyriHSGBtdLjd7Yt4zubw/yB46tEZja5KdTbWi3CYzx5mTRTk+JC4dLsmqFLdmyXS+LsXHTjLdbH/BgTcPfHXADwetzcdILrnkkkv+txy42wA3K+BeB9wqoTttvFF7fpxd4L/EE27UNPtDHB/boXtgsxfbZyJO/RfijX/pjyHz60B54tmpGjpc/qG09Pl9QOftEMTx+gThAYFcPSDnwvzoMR3bpRohwlbvwn/zj8KlrUt11AEm1+K1SXWZRBygIw7RCJ1vBfQdPu9nWal0Oh0AAAAASUVORK5CYII=");
        h.append(e, "iVBORw0KGgoAAAANSUhEUgAAAD4AAAA+CAMAAABEH1h2AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAolBMVEUAAABOTk5OTk5OTk5OTk7T09P///+oqKhOTk7w8PBQUFCpqalOTk6dnZ1OTk7g4OBOTk79/f17e3tOTk7MzMz39/ddXV1OTk6wsLBOTk7q6uqqqqrX19f+/v6MjIxOTk5mZmZOTk5OTk76+vppaWlOTk6+vr5OTk7w8PBVVVVOTk5OTk56enrLy8v19fVOTk6urq7p6elOTk6Li4tOTk4AAAD1YJyZAAAANXRSTlMADC1NK4ezbBifTm0fZxSSNK9aFYGnUQhwJZpuibNhG1MuBaxUDngooU8BIFmBqAdwmjpgGhUBErwAAAABYktHRACIBR1IAAAACXBIWXMAAAsTAAALEwEAmpwYAAABDUlEQVRIx+3UV2/CYAyF4QChhABljzLK3hv6/38bEvOLYkvHNr3D949eKTmJ58UukUwxl/SA89NfzGUCC8+Gpnoub+FYnOVYnONgnONgnOFonOFonOZwnOZwnOR4nOR4nOKCOMUFcYJL4gSXxONcFI9zUTzGs+Gb/nWFbwsvliz1cqVq4TVf9+RvV280Lbz1o3txt2uj2wk66et1Xd377YPcC/zrDVzeHaL6fiOXjydTC5/NhTrCF8uVhRfWUu1ybOwcL2+QL43lW2zsDN819hZ+AMdO8+NJox+8d4bHTnHx2CNcPvYIl4/d5Yqxu1wxdodrxv7iqrG/uGrsT64b+5Prxv648M+iP/e5/7oLx2chR6Xj360AAAAASUVORK5CYII=");
        h.append(f, "iVBORw0KGgoAAAANSUhEUgAAAD4AAAA+CAMAAABEH1h2AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAA3lBMVEUAAABOTk5OTk5OTk5OTk7T09P///+jo6NOTk5OTk5OTk7s7OxOTk5OTk5mZmaVlZXt7e38/PydnZ1OTk5QUFDq6upOTk6+vr6oqKj9/f1OTk7Ozs5OTk5OTk7V1dVOTk5OTk7g4OBOTk79/f16enrLy8v19fVdXV1OTk6urq5OTk6zs7NOTk6qqqrX19dOTk7MzMz39/ewsLDq6ur+/v6MjIzX19dOTk76+vpra2tOTk6Xl5dOTk6+vr5OTk7w8PBtbW1OTk7x8fFVVVVOTk6enp57e3tOTk5OTk4AAAC73ZWaAAAASXRSTlMADC1NK4ezahYFEZ08HVNknbBnG06bIXhssQGDLAmJKRSSNK9ZgahRB3AlchhuiRyBp3Cas2GKLq1VDmQSeSihVgaiTyBoWhUIRCCmxwAAAAFiS0dEAIgFHUgAAAAJcEhZcwAACxMAAAsTAQCanBgAAAFsSURBVEjH7dXZUoMwFAbgiCm1VpACbnWpiorWra372mrr8v5PJAIlBElyThjv+t+FyTc/kOFAyJ/MGfOCGAQQWjMFqS+IVWNRxZtLYm3Zy1TB65ZEOy2XSrmk3LMd00y9iEvK/ZXfDYlfXUM/ube+kfm2sYksJ2Qr57fLvKwc4KXlSq8oV3lVudyry6UeUC7xoHKxh5WLPLRc4MHlpR5RHsXYMXmPKWcf7NQ3NWdd4jvs/NxdDC+e394+qr3ggwNIOTes8v6Qol5dwR+Fx3jO/EkXd3C8PwWdWpSz81qci7wnl0AdeRrH5vqxadhmFZ/jOj7PNTzH8Z7naM940NLwjPdcDZ/xfkg1fMYHXaLhp/zKjxZ4n/LrG4/o+JTf3iVLrE/4/cMj4f3TM4K/vGYXEj8cvcH5+7hNOD8cTRA3/8Ftpq4D1TEvTnbLB/+vIh58fkF3l/GexpBivB9+V+ED4GQvj+9X0bPM8l/5ASW6MBBkLBfRAAAAAElFTkSuQmCC");
        i = new SparseArray();
    }

    public static Bitmap a(Context context, String s)
    {
        try
        {
            int i1 = cv.a(context, (new StringBuilder()).append(a().j).append(s).toString(), "drawable");
            context = BitmapFactory.decodeResource(context.getResources(), i1);
            s = a();
            i1 = a;
            a = i1 + 1;
            s.a(i1, ((Bitmap) (context)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static Bitmap a(Resources resources, int i1)
    {
        if (!a().b(i1))
        {
            if (!g(i1))
            {
                return null;
            } else
            {
                byte abyte0[] = Base64.decode(h(i1), 0);
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                options.inDensity = 320;
                options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
                resources = BitmapFactory.decodeStream(new ByteArrayInputStream(abyte0), null, options);
                a().a(i1, ((Bitmap) (resources)));
                return resources;
            }
        } else
        {
            return a().c(i1);
        }
    }

    private static NinePatchDrawable a(Resources resources, InputStream inputstream, int i1)
    {
        if (inputstream != null)
        {
            Rect rect = new Rect();
            if (!a().b(i1))
            {
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                options.inDensity = 320;
                options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
                inputstream = BitmapFactory.decodeStream(inputstream, rect, options);
                a().a(i1, ((Bitmap) (inputstream)), rect);
            } else
            {
                inputstream = a().a(i1, rect);
            }
            if (inputstream != null)
            {
                byte abyte0[];
label0:
                {
                    byte abyte1[] = inputstream.getNinePatchChunk();
                    if (abyte1 != null)
                    {
                        abyte0 = abyte1;
                        if (NinePatch.isNinePatchChunk(abyte1))
                        {
                            break label0;
                        }
                    }
                    abyte0 = null;
                }
                return new NinePatchDrawable(resources, inputstream, abyte0, rect, null);
            }
        }
        return null;
    }

    public static ch a()
    {
        Object obj = k;
        obj;
        JVM INSTR monitorenter ;
        if (m == null)
        {
            throw new IllegalStateException("need to call Images.setFactory()!");
        }
        break MISSING_BLOCK_LABEL_27;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        ch ch1;
        if (l == null)
        {
            l = m.a();
        }
        ch1 = l;
        obj;
        JVM INSTR monitorexit ;
        return ch1;
    }

    public static void a(int i1)
    {
        a().d(i1);
    }

    public static void a(ck ck1)
    {
        synchronized (k)
        {
            if (l != null)
            {
                l.b();
            }
            l = null;
            m = ck1;
        }
        return;
        ck1;
        obj;
        JVM INSTR monitorexit ;
        throw ck1;
    }

    public static Drawable b(Context context, String s)
    {
        return new BitmapDrawable(context.getResources(), a(context, s));
    }

    public static Drawable b(Resources resources, int i1)
    {
        return new BitmapDrawable(resources, a(resources, i1));
    }

    public static NinePatchDrawable c(Resources resources, int i1)
    {
        if (!g(i1))
        {
            return null;
        } else
        {
            return a(resources, new ByteArrayInputStream(Base64.decode(h(i1), 0)), i1);
        }
    }

    private static boolean g(int i1)
    {
        return a().f(i1);
    }

    private static byte[] h(int i1)
    {
        return a().e(i1).getBytes();
    }

    protected Bitmap a(int i1, Rect rect)
    {
        if (rect != null)
        {
            rect.set((Rect)i.get(i1));
        }
        return g.a(i1);
    }

    protected void a(int i1, Bitmap bitmap)
    {
        a(i1, bitmap, ((Rect) (null)));
    }

    protected void a(int i1, Bitmap bitmap, Rect rect)
    {
        g.a(i1, bitmap);
        if (rect != null)
        {
            i.put(i1, rect);
        }
    }

    protected void b()
    {
        g.a();
        i.clear();
    }

    protected boolean b(int i1)
    {
        return g.b(i1);
    }

    protected Bitmap c(int i1)
    {
        return a(i1, ((Rect) (null)));
    }

    protected void d(int i1)
    {
        g.c(i1);
        i.delete(i1);
    }

    protected String e(int i1)
    {
        return (String)h.get(i1);
    }

    protected boolean f(int i1)
    {
        return h.get(i1) != null;
    }

    static 
    {
        a = 100;
        int i1 = a;
        a = i1 + 1;
        b = i1;
        i1 = a;
        a = i1 + 1;
        c = i1;
        i1 = a;
        a = i1 + 1;
        d = i1;
        i1 = a;
        a = i1 + 1;
        e = i1;
        i1 = a;
        a = i1 + 1;
        f = i1;
    }
}
