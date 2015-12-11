// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

// Referenced classes of package com.a.b:
//            a, ay, ad, e, 
//            f, g, ao, ar, 
//            k, z, l, c, 
//            v, ab, h, as, 
//            aj, u, n, av, 
//            s

abstract class d
    implements Runnable
{

    protected static final int a = 22;
    private static final Object o = new Object();
    final ad b;
    final n c;
    final h d;
    final as e;
    final String f;
    final ao g;
    final List h = new ArrayList(4);
    final boolean i;
    Bitmap j;
    Future k;
    aj l;
    Exception m;
    int n;

    d(ad ad1, n n1, h h1, as as1, a a1)
    {
        b = ad1;
        c = n1;
        d = h1;
        e = as1;
        f = a1.h;
        g = a1.b;
        i = a1.d;
        a(a1);
    }

    private static Bitmap a(List list, Bitmap bitmap)
    {
        int j1 = list.size();
        for (int i1 = 0; i1 < j1;)
        {
            ay ay1 = (ay)list.get(i1);
            Bitmap bitmap1 = ay1.a();
            if (bitmap1 == null)
            {
                bitmap = (new StringBuilder("Transformation ")).append(ay1.b()).append(" returned null after ").append(i1).append(" previous transformation(s).\n\nTransformation list:\n");
                for (list = list.iterator(); list.hasNext(); bitmap.append(((ay)list.next()).b()).append('\n')) { }
                ad.a.post(new e(bitmap));
                return null;
            }
            if (bitmap1 == bitmap && bitmap.isRecycled())
            {
                ad.a.post(new f(ay1));
                return null;
            }
            if (bitmap1 != bitmap && !bitmap.isRecycled())
            {
                ad.a.post(new g(ay1));
                return null;
            }
            i1++;
            bitmap = bitmap1;
        }

        return bitmap;
    }

    static d a(Context context, ad ad1, n n1, h h1, as as1, a a1, s s)
    {
        if (a1.b.b != 0)
        {
            return new ar(context, ad1, n1, h1, as1, a1);
        }
        Uri uri = a1.b.a;
        String s1 = uri.getScheme();
        if ("content".equals(s1))
        {
            if (android.provider.ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && !uri.getPathSegments().contains("photo"))
            {
                return new k(context, ad1, n1, h1, as1, a1);
            }
            if ("media".equals(uri.getAuthority()))
            {
                return new z(context, ad1, n1, h1, as1, a1);
            } else
            {
                return new l(context, ad1, n1, h1, as1, a1);
            }
        }
        if ("file".equals(s1))
        {
            if (!uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0)))
            {
                return new c(context, ad1, n1, h1, as1, a1);
            } else
            {
                return new v(context, ad1, n1, h1, as1, a1);
            }
        }
        if ("android.resource".equals(s1))
        {
            return new ar(context, ad1, n1, h1, as1, a1);
        } else
        {
            return new ab(ad1, n1, h1, as1, a1, s);
        }
    }

    static void a(int i1, int j1, int k1, int l1, android.graphics.BitmapFactory.Options options)
    {
        int i2 = 1;
        if (l1 > j1 || k1 > i1)
        {
            i2 = Math.round((float)l1 / (float)j1);
            i1 = Math.round((float)k1 / (float)i1);
            if (i2 >= i1)
            {
                i2 = i1;
            }
        }
        options.inSampleSize = i2;
        options.inJustDecodeBounds = false;
    }

    static void a(int i1, int j1, android.graphics.BitmapFactory.Options options)
    {
        a(i1, j1, options.outWidth, options.outHeight, options);
    }

    private Bitmap c()
    {
        int j1;
        int k1;
        int i2;
        k1 = 1;
        i2 = 0;
        j1 = 0;
        if (i) goto _L2; else goto _L1
_L1:
        Object obj = d.a(f);
        if (obj == null) goto _L2; else goto _L3
_L3:
        e.a();
        l = aj.a;
_L5:
        return ((Bitmap) (obj));
_L2:
        Object obj1;
        obj1 = a(g);
        obj = obj1;
        if (obj1 == null) goto _L5; else goto _L4
_L4:
        float f1;
        float f2;
        Object obj2;
        Object obj3;
        int i1;
        int l1;
        int k2;
        e.a(((Bitmap) (obj1)), 2);
        obj = g;
        i1 = k1;
        float f3;
        int j2;
        if (!((ao) (obj)).b())
        {
            if (((ao) (obj)).c())
            {
                i1 = k1;
            } else
            {
                i1 = 0;
            }
        }
        if (i1 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (n == 0) goto _L5; else goto _L6
_L6:
        obj3 = o;
        obj3;
        JVM INSTR monitorenter ;
        if (g.b()) goto _L8; else goto _L7
_L7:
        obj = obj1;
        if (n == 0) goto _L9; else goto _L8
_L8:
        obj = g;
        j2 = n;
        k1 = ((Bitmap) (obj1)).getWidth();
        l1 = ((Bitmap) (obj1)).getHeight();
        obj2 = new Matrix();
        if (!((ao) (obj)).b()) goto _L11; else goto _L10
_L10:
        i1 = ((ao) (obj)).d;
        k2 = ((ao) (obj)).e;
        f1 = ((ao) (obj)).h;
        if (f1 == 0.0F) goto _L13; else goto _L12
_L12:
        if (!((ao) (obj)).k) goto _L15; else goto _L14
_L14:
        ((Matrix) (obj2)).setRotate(f1, ((ao) (obj)).i, ((ao) (obj)).j);
_L13:
        if (!((ao) (obj)).f) goto _L17; else goto _L16
_L16:
        f1 = (float)i1 / (float)k1;
        f2 = (float)k2 / (float)l1;
        if (f1 <= f2) goto _L19; else goto _L18
_L18:
        f3 = l1;
        i2 = (int)Math.ceil((f2 / f1) * f3);
        j1 = (l1 - i2) / 2;
        i1 = 0;
        l1 = i2;
_L21:
        ((Matrix) (obj2)).preScale(f1, f1);
_L24:
        if (j2 == 0)
        {
            break MISSING_BLOCK_LABEL_339;
        }
        ((Matrix) (obj2)).preRotate(j2);
        obj2 = Bitmap.createBitmap(((Bitmap) (obj1)), i1, j1, k1, l1, ((Matrix) (obj2)), true);
        obj = obj1;
        if (obj2 == obj1) goto _L9; else goto _L20
_L20:
        ((Bitmap) (obj1)).recycle();
        obj = obj2;
_L9:
        obj1 = obj;
        if (g.c())
        {
            obj1 = a(g.c, ((Bitmap) (obj)));
        }
        obj3;
        JVM INSTR monitorexit ;
        e.a(((Bitmap) (obj1)), 3);
        return ((Bitmap) (obj1));
_L15:
        ((Matrix) (obj2)).setRotate(f1);
          goto _L13
        obj;
        obj3;
        JVM INSTR monitorexit ;
        throw obj;
_L19:
        double d1;
        float f4 = k1;
        d1 = (f1 / f2) * f4;
        i1 = (int)Math.ceil(d1);
        i2 = (k1 - i1) / 2;
        k1 = i1;
        i1 = i2;
        f1 = f2;
          goto _L21
_L17:
        if (!((ao) (obj)).g) goto _L23; else goto _L22
_L22:
        f1 = (float)i1 / (float)k1;
        f2 = (float)k2 / (float)l1;
        if (f1 >= f2)
        {
            f1 = f2;
        }
        ((Matrix) (obj2)).preScale(f1, f1);
        i1 = 0;
        j1 = i2;
          goto _L24
_L25:
        ((Matrix) (obj2)).preScale((float)i1 / (float)k1, (float)k2 / (float)l1);
_L11:
        i1 = 0;
        j1 = i2;
          goto _L24
_L23:
        if (i1 == 0 || k2 == 0 || i1 == k1 && k2 == l1) goto _L11; else goto _L25
    }

    abstract Bitmap a(ao ao1);

    aj a()
    {
        return l;
    }

    final void a(a a1)
    {
        h.add(a1);
    }

    boolean a(NetworkInfo networkinfo)
    {
        return false;
    }

    final boolean b()
    {
        return k != null && k.isCancelled();
    }

    public void run()
    {
        Object obj;
        Thread thread;
        StringBuilder stringbuilder;
        thread = Thread.currentThread();
        stringbuilder = new StringBuilder("Picasso-");
        obj = g;
        if (((ao) (obj)).a == null) goto _L2; else goto _L1
_L1:
        obj = ((ao) (obj)).a.getPath();
_L5:
        thread.setName(stringbuilder.append(((String) (obj))).toString());
        j = c();
        if (j != null) goto _L4; else goto _L3
_L3:
        c.a(this);
_L6:
        Thread.currentThread().setName("Picasso-Idle");
        return;
_L2:
        obj = Integer.toHexString(((ao) (obj)).b);
          goto _L5
_L4:
        n n1 = c;
        n1.f.sendMessage(n1.f.obtainMessage(4, this));
          goto _L6
        Object obj1;
        obj1;
        m = ((Exception) (obj1));
        c.a(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj1;
        m = ((Exception) (obj1));
        n n2 = c;
        n2.f.sendMessageDelayed(n2.f.obtainMessage(5, this), 500L);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        n2;
        StringWriter stringwriter = new StringWriter();
        av av1 = e.b();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        printwriter.println("===============BEGIN PICASSO STATS ===============");
        printwriter.println("Memory Cache Stats");
        printwriter.print("  Max Cache Size: ");
        printwriter.println(av1.a);
        printwriter.print("  Cache Size: ");
        printwriter.println(av1.b);
        printwriter.print("  Cache % Full: ");
        printwriter.println((int)Math.ceil(((float)av1.b / (float)av1.a) * 100F));
        printwriter.print("  Cache Hits: ");
        printwriter.println(av1.c);
        printwriter.print("  Cache Misses: ");
        printwriter.println(av1.d);
        printwriter.println("Bitmap Stats");
        printwriter.print("  Total Bitmaps Decoded: ");
        printwriter.println(av1.i);
        printwriter.print("  Total Bitmap Size: ");
        printwriter.println(av1.e);
        printwriter.print("  Total Transformed Bitmaps: ");
        printwriter.println(av1.j);
        printwriter.print("  Total Transformed Bitmap Size: ");
        printwriter.println(av1.f);
        printwriter.print("  Average Bitmap Size: ");
        printwriter.println(av1.g);
        printwriter.print("  Average Transformed Bitmap Size: ");
        printwriter.println(av1.h);
        printwriter.println("===============END PICASSO STATS ===============");
        printwriter.flush();
        m = new RuntimeException(stringwriter.toString(), n2);
        c.a(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        n2;
        m = n2;
        c.a(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        n2;
        Thread.currentThread().setName("Picasso-Idle");
        throw n2;
          goto _L5
    }

}
