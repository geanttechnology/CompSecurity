// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.nio.Buffer;
import java.util.UUID;

// Referenced classes of package com.socialin.android.brushlib.layer:
//            a, BlendMode

public final class b
    implements a, Cloneable
{

    private static final Paint m = new Paint(1);
    public final Matrix a = new Matrix();
    public Bitmap b;
    public String c;
    public boolean d;
    public int e;
    public boolean f;
    public BlendMode g;
    public final Paint h = new Paint();
    public boolean i;
    public Canvas j;
    public String k;
    public String l;
    private com.socialin.android.brushlib.b n;

    private b(Bitmap bitmap, boolean flag, int i1, BlendMode blendmode, com.socialin.android.brushlib.b b1)
    {
        if (!bitmap.isMutable())
        {
            Bitmap bitmap1 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
            bitmap.recycle();
            bitmap = bitmap1;
        }
        b = bitmap;
        j = new Canvas(b);
        c = UUID.randomUUID().toString();
        h.setAlpha(i1);
        h.setXfermode(blendmode.getXfermode());
        h.setFilterBitmap(true);
        f = flag;
        e = i1;
        g = blendmode;
        i = false;
        n = b1;
    }

    public static b a(int i1, int j1)
    {
        return a(i1, j1, 0);
    }

    public static b a(int i1, int j1, int k1)
    {
        Object obj;
        boolean flag;
        try
        {
            obj = Bitmap.createBitmap(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        ((Bitmap) (obj)).eraseColor(k1);
        obj = new b(((Bitmap) (obj)), true, 255, BlendMode.NORMAL, null);
        if (k1 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj.d = flag;
        return ((b) (obj));
        return null;
    }

    public static b a(Bitmap bitmap, int i1, int j1, com.socialin.android.brushlib.b b1)
    {
        Bitmap bitmap1;
        Canvas canvas;
        try
        {
            bitmap1 = Bitmap.createBitmap(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return null;
        }
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        canvas = new Canvas(bitmap1);
        canvas.scale((float)i1 / (float)bitmap.getWidth(), (float)j1 / (float)bitmap.getHeight());
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
        bitmap.recycle();
        bitmap = new b(bitmap1, true, 255, BlendMode.NORMAL, b1);
        return bitmap;
        return null;
    }

    public final int a()
    {
        if (i)
        {
            return 0;
        } else
        {
            return b.getHeight() * b.getRowBytes();
        }
    }

    public final void a(int i1)
    {
        e = i1;
        h.setAlpha(i1);
    }

    public final void a(Canvas canvas)
    {
        if (!i && f)
        {
            canvas.drawBitmap(b, a, h);
        }
    }

    public final void a(BlendMode blendmode)
    {
        g = blendmode;
        h.setXfermode(g.getXfermode());
    }

    public final void a(String s)
    {
        l = s;
    }

    public final void a(Buffer buffer)
    {
        if (!i)
        {
            b.copyPixelsToBuffer(buffer);
        }
    }

    public final void a(boolean flag)
    {
        if (flag)
        {
            h.setXfermode(g.getXfermode());
            return;
        } else
        {
            h.setXfermode(null);
            return;
        }
    }

    public final Canvas b()
    {
        return j;
    }

    public final void b(Canvas canvas)
    {
        if (!i)
        {
            canvas.drawBitmap(b, 0.0F, 0.0F, m);
        }
    }

    public final void b(String s)
    {
        k = s;
    }

    public final void b(Buffer buffer)
    {
        if (!i)
        {
            b.copyPixelsFromBuffer(buffer);
        }
    }

    public final void c()
    {
        if (!i)
        {
            b.eraseColor(0);
        }
    }

    public final Object clone()
    {
        return k();
    }

    public final String d()
    {
        return k;
    }

    public final String e()
    {
        return l;
    }

    public final String f()
    {
        return c;
    }

    public final boolean g()
    {
        return !f;
    }

    public final void h()
    {
        i = true;
        if (b != null)
        {
            b.recycle();
        }
        b = null;
    }

    public final int i()
    {
        if (i)
        {
            return 0;
        } else
        {
            return b.getWidth();
        }
    }

    public final int j()
    {
        if (i)
        {
            return 0;
        } else
        {
            return b.getHeight();
        }
    }

    public final b k()
    {
        b b1 = new b(b.copy(android.graphics.Bitmap.Config.ARGB_8888, true), f, e, g, n);
        b1.l = k;
        b1.k = k;
        return b1;
    }

}
