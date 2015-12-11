// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.g.c:
//            a, x, z, af, 
//            u, q, d, ab, 
//            ah, r, o, i, 
//            ac

final class c
    implements Runnable
{

    private static final Object t = new Object();
    private static final ThreadLocal u = new ThreadLocal() {

        protected final Object initialValue()
        {
            return new StringBuilder("Picasso-");
        }

    };
    private static final AtomicInteger v = new AtomicInteger();
    private static final z w = new z() {

        public final boolean a(x x1)
        {
            return true;
        }

        public final z.a b(x x1)
        {
            throw new IllegalStateException((new StringBuilder("Unrecognized type of request: ")).append(x1).toString());
        }

    };
    final int a;
    final u b;
    final i c;
    final d d;
    final ab e;
    final String f;
    final x g;
    final int h;
    int i;
    final z j;
    a k;
    List l;
    Bitmap m;
    Future n;
    u.d o;
    Exception p;
    int q;
    int r;
    u.e s;

    private c(u u1, i i1, d d1, ab ab1, a a1, z z1)
    {
        a = v.incrementAndGet();
        b = u1;
        c = i1;
        d = d1;
        e = ab1;
        k = a1;
        f = a1.i;
        g = a1.b;
        s = a1.b.r;
        h = a1.e;
        i = a1.f;
        j = z1;
        r = z1.a();
    }

    private static Bitmap a(List list, Bitmap bitmap)
    {
        int j1 = list.size();
        for (int i1 = 0; i1 < j1;)
        {
            af af1 = (af)list.get(i1);
            Bitmap bitmap1;
            try
            {
                bitmap1 = af1.a(bitmap);
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                u.a.post(new Runnable(af1, list) {

                    final af a;
                    final RuntimeException b;

                    public final void run()
                    {
                        throw new RuntimeException((new StringBuilder("Transformation ")).append(a.a()).append(" crashed with exception.").toString(), b);
                    }

            
            {
                a = af1;
                b = runtimeexception;
                super();
            }
                });
                return null;
            }
            if (bitmap1 == null)
            {
                bitmap = (new StringBuilder("Transformation ")).append(af1.a()).append(" returned null after ").append(i1).append(" previous transformation(s).\n\nTransformation list:\n");
                for (list = list.iterator(); list.hasNext(); bitmap.append(((af)list.next()).a()).append('\n')) { }
                u.a.post(new Runnable(bitmap) {

                    final StringBuilder a;

                    public final void run()
                    {
                        throw new NullPointerException(a.toString());
                    }

            
            {
                a = stringbuilder;
                super();
            }
                });
                return null;
            }
            if (bitmap1 == bitmap && bitmap.isRecycled())
            {
                u.a.post(new Runnable(af1) {

                    final af a;

                    public final void run()
                    {
                        throw new IllegalStateException((new StringBuilder("Transformation ")).append(a.a()).append(" returned input Bitmap but recycled it.").toString());
                    }

            
            {
                a = af1;
                super();
            }
                });
                return null;
            }
            if (bitmap1 != bitmap && !bitmap.isRecycled())
            {
                u.a.post(new Runnable(af1) {

                    final af a;

                    public final void run()
                    {
                        throw new IllegalStateException((new StringBuilder("Transformation ")).append(a.a()).append(" mutated input Bitmap but failed to recycle the original.").toString());
                    }

            
            {
                a = af1;
                super();
            }
                });
                return null;
            }
            i1++;
            bitmap = bitmap1;
        }

        return bitmap;
    }

    static c a(u u1, i i1, d d1, ab ab1, a a1)
    {
        x x1 = a1.b;
        List list = u1.d;
        int j1 = 0;
        for (int k1 = list.size(); j1 < k1; j1++)
        {
            z z1 = (z)list.get(j1);
            if (z1.a(x1))
            {
                return new c(u1, i1, d1, ab1, a1, z1);
            }
        }

        return new c(u1, i1, d1, ab1, a1, w);
    }

    private static boolean a(boolean flag, int i1, int j1, int k1, int l1)
    {
        return !flag || i1 > k1 || j1 > l1;
    }

    private Bitmap c()
    {
        Object obj = null;
        if (!com.g.c.q.a(h)) goto _L2; else goto _L1
_L1:
        Object obj2;
        obj2 = d.a(f);
        obj = obj2;
        if (obj2 == null) goto _L2; else goto _L3
_L3:
        Object obj1;
        e.a();
        o = u.d.a;
        obj1 = obj2;
        if (b.n)
        {
            ah.a("Hunter", "decoded", g.a(), "from cache");
            obj1 = obj2;
        }
_L10:
        return ((Bitmap) (obj1));
_L2:
        float f1;
        float f2;
        java.io.InputStream inputstream;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int l2;
        int i3;
        long l3;
        boolean flag1;
        obj1 = g;
        int k2;
        boolean flag2;
        if (r == 0)
        {
            i1 = r.c.d;
        } else
        {
            i1 = i;
        }
        obj1.c = i1;
        obj2 = j.b(g);
        if (obj2 == null) goto _L5; else goto _L4
_L4:
        o = ((z.a) (obj2)).a;
        q = ((z.a) (obj2)).d;
        obj1 = ((z.a) (obj2)).b;
        obj = obj1;
        if (obj1 != null) goto _L5; else goto _L6
_L6:
        obj2 = ((z.a) (obj2)).c;
        obj = g;
        inputstream = new o(((java.io.InputStream) (obj2)));
        l3 = inputstream.a(0x10000);
        obj1 = z.d(((x) (obj)));
        flag1 = z.a(((android.graphics.BitmapFactory.Options) (obj1)));
        flag2 = ah.c(inputstream);
        inputstream.a(l3);
        if (!flag2) goto _L8; else goto _L7
_L7:
        inputstream = ah.b(inputstream);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        BitmapFactory.decodeByteArray(inputstream, 0, inputstream.length, ((android.graphics.BitmapFactory.Options) (obj1)));
        z.a(((x) (obj)).h, ((x) (obj)).i, ((android.graphics.BitmapFactory.Options) (obj1)), ((x) (obj)));
        obj = BitmapFactory.decodeByteArray(inputstream, 0, inputstream.length, ((android.graphics.BitmapFactory.Options) (obj1)));
_L28:
        ah.a(((java.io.InputStream) (obj2)));
_L5:
        obj1 = obj;
        if (obj == null) goto _L10; else goto _L9
_L9:
        if (b.n)
        {
            ah.a("Hunter", "decoded", g.a());
        }
        e.a(((Bitmap) (obj)), 2);
        obj1 = g;
        Exception exception;
        if (((x) (obj1)).d() || ((x) (obj1)).e())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        if (q == 0) goto _L10; else goto _L11
_L11:
        inputstream = ((java.io.InputStream) (t));
        inputstream;
        JVM INSTR monitorenter ;
        if (g.d()) goto _L13; else goto _L12
_L12:
        obj2 = obj;
        if (q == 0) goto _L14; else goto _L13
_L13:
        obj1 = g;
        k2 = q;
        i1 = ((Bitmap) (obj)).getWidth();
        j1 = ((Bitmap) (obj)).getHeight();
        flag1 = ((x) (obj1)).l;
        obj2 = new Matrix();
        if (!((x) (obj1)).d()) goto _L16; else goto _L15
_L15:
        l2 = ((x) (obj1)).h;
        i3 = ((x) (obj1)).i;
        f1 = ((x) (obj1)).m;
        if (f1 == 0.0F) goto _L18; else goto _L17
_L17:
        if (!((x) (obj1)).p) goto _L20; else goto _L19
_L19:
        ((Matrix) (obj2)).setRotate(f1, ((x) (obj1)).n, ((x) (obj1)).o);
_L18:
        if (!((x) (obj1)).j) goto _L22; else goto _L21
_L21:
        f1 = (float)l2 / (float)i1;
        f2 = (float)i3 / (float)j1;
        if (f1 <= f2) goto _L24; else goto _L23
_L23:
        k1 = (int)Math.ceil((float)j1 * (f2 / f1));
        j2 = (j1 - k1) / 2;
        f2 = (float)i3 / (float)k1;
        l1 = i1;
        i2 = 0;
_L29:
        if (a(flag1, i1, j1, l2, i3))
        {
            ((Matrix) (obj2)).preScale(f1, f2);
        }
          goto _L25
_L37:
        if (k2 == 0)
        {
            break MISSING_BLOCK_LABEL_621;
        }
        ((Matrix) (obj2)).preRotate(k2);
        obj2 = Bitmap.createBitmap(((Bitmap) (obj)), i1, j1, l1, k1, ((Matrix) (obj2)), true);
        obj1 = obj;
        if (obj2 == obj)
        {
            break MISSING_BLOCK_LABEL_659;
        }
        ((Bitmap) (obj)).recycle();
        obj1 = obj2;
        obj2 = obj1;
        if (!b.n) goto _L14; else goto _L26
_L26:
        ah.a("Hunter", "transformed", g.a());
        obj2 = obj1;
_L14:
        obj = obj2;
        if (!g.e())
        {
            break MISSING_BLOCK_LABEL_756;
        }
        obj1 = a(g.g, ((Bitmap) (obj2)));
        obj = obj1;
        if (!b.n)
        {
            break MISSING_BLOCK_LABEL_756;
        }
        ah.a("Hunter", "transformed", g.a(), "from custom transformations");
        obj = obj1;
        inputstream;
        JVM INSTR monitorexit ;
        obj1 = obj;
        if (obj != null)
        {
            e.a(((Bitmap) (obj)), 3);
            return ((Bitmap) (obj));
        }
          goto _L10
_L8:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_828;
        }
        BitmapFactory.decodeStream(inputstream, null, ((android.graphics.BitmapFactory.Options) (obj1)));
        z.a(((x) (obj)).h, ((x) (obj)).i, ((android.graphics.BitmapFactory.Options) (obj1)), ((x) (obj)));
        inputstream.a(l3);
        obj1 = BitmapFactory.decodeStream(inputstream, null, ((android.graphics.BitmapFactory.Options) (obj1)));
        obj = obj1;
        if (obj1 != null) goto _L28; else goto _L27
_L27:
        throw new IOException("Failed to decode stream.");
        exception;
        ah.a(((java.io.InputStream) (obj2)));
        throw exception;
_L20:
        ((Matrix) (obj2)).setRotate(f1);
          goto _L18
        Exception exception1;
        exception1;
        inputstream;
        JVM INSTR monitorexit ;
        throw exception1;
_L24:
        double d1 = (float)i1 * (f1 / f2);
        l1 = (int)Math.ceil(d1);
        i2 = (i1 - l1) / 2;
        f1 = (float)l2 / (float)l1;
        j2 = 0;
        k1 = j1;
          goto _L29
_L22:
        if (!((x) (obj1)).k) goto _L31; else goto _L30
_L30:
        f1 = (float)l2 / (float)i1;
        f2 = (float)i3 / (float)j1;
        if (f1 >= f2)
        {
            f1 = f2;
        }
        if (a(flag1, i1, j1, l2, i3))
        {
            ((Matrix) (obj2)).preScale(f1, f1);
        }
          goto _L32
_L40:
        if (l2 == 0) goto _L34; else goto _L33
_L33:
        f1 = (float)l2 / (float)i1;
_L38:
        if (i3 == 0) goto _L36; else goto _L35
_L35:
        f2 = (float)i3 / (float)j1;
_L39:
        if (a(flag1, i1, j1, l2, i3))
        {
            ((Matrix) (obj2)).preScale(f1, f2);
        }
_L16:
        i2 = 0;
        k1 = j1;
        l1 = i1;
        j1 = 0;
        i1 = i2;
          goto _L37
_L34:
        f1 = (float)i3 / (float)j1;
          goto _L38
_L36:
        f2 = (float)l2 / (float)i1;
          goto _L39
_L25:
        j1 = j2;
        i1 = i2;
          goto _L37
_L32:
        boolean flag = false;
        k1 = j1;
        l1 = i1;
        j1 = 0;
        i1 = ((flag) ? 1 : 0);
          goto _L37
_L31:
        if (l2 == 0 && i3 == 0 || l2 == i1 && i3 == j1) goto _L16; else goto _L40
    }

    final void a(a a1)
    {
        boolean flag1 = true;
        boolean flag = false;
        boolean flag2;
        if (k == a1)
        {
            k = null;
            flag2 = true;
        } else
        if (l != null)
        {
            flag2 = l.remove(a1);
        } else
        {
            flag2 = false;
        }
        if (flag2 && a1.b.r == s)
        {
            u.e e1 = u.e.a;
            u.e e2;
            int i1;
            int j1;
            if (l != null && !l.isEmpty())
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            j1 = ((flag1) ? 1 : 0);
            if (k == null)
            {
                if (i1 != 0)
                {
                    j1 = ((flag1) ? 1 : 0);
                } else
                {
                    j1 = 0;
                }
            }
            if (j1 != 0)
            {
                if (k != null)
                {
                    e1 = k.b.r;
                }
                e2 = e1;
                if (i1 != 0)
                {
                    j1 = l.size();
                    i1 = ((flag) ? 1 : 0);
                    do
                    {
                        e2 = e1;
                        if (i1 >= j1)
                        {
                            break;
                        }
                        e2 = ((a)l.get(i1)).b.r;
                        if (e2.ordinal() > e1.ordinal())
                        {
                            e1 = e2;
                        }
                        i1++;
                    } while (true);
                }
            } else
            {
                e2 = e1;
            }
            s = e2;
        }
        if (b.n)
        {
            ah.a("Hunter", "removed", a1.b.a(), ah.a(this, "from "));
        }
    }

    final boolean a()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (k != null)
            {
                break label0;
            }
            if (l != null)
            {
                flag = flag1;
                if (!l.isEmpty())
                {
                    break label0;
                }
            }
            flag = flag1;
            if (n != null)
            {
                flag = flag1;
                if (n.cancel(false))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    final boolean b()
    {
        return n != null && n.isCancelled();
    }

    public final void run()
    {
        Object obj = g;
        if (((x) (obj)).d == null) goto _L2; else goto _L1
_L1:
        obj = String.valueOf(((x) (obj)).d.getPath());
_L5:
        StringBuilder stringbuilder = (StringBuilder)u.get();
        stringbuilder.ensureCapacity(((String) (obj)).length() + 8);
        stringbuilder.replace(8, stringbuilder.length(), ((String) (obj)));
        Thread.currentThread().setName(stringbuilder.toString());
        if (b.n)
        {
            ah.a("Hunter", "executing", ah.a(this));
        }
        m = c();
        if (m != null) goto _L4; else goto _L3
_L3:
        c.b(this);
_L6:
        Thread.currentThread().setName("Picasso-Idle");
        return;
_L2:
        obj = Integer.toHexString(((x) (obj)).e);
          goto _L5
_L4:
        i i1 = c;
        i1.i.sendMessage(i1.i.obtainMessage(4, this));
          goto _L6
        Object obj1;
        obj1;
        if (!((j.b) (obj1)).a || ((j.b) (obj1)).b != 504)
        {
            p = ((Exception) (obj1));
        }
        c.b(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj1;
        p = ((Exception) (obj1));
        c.a(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj1;
        p = ((Exception) (obj1));
        c.a(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj1;
        StringWriter stringwriter = new StringWriter();
        Object obj2 = e;
        obj2 = new ac(((ab) (obj2)).b.b(), ((ab) (obj2)).b.a(), ((ab) (obj2)).d, ((ab) (obj2)).e, ((ab) (obj2)).f, ((ab) (obj2)).g, ((ab) (obj2)).h, ((ab) (obj2)).i, ((ab) (obj2)).j, ((ab) (obj2)).k, ((ab) (obj2)).l, ((ab) (obj2)).m, ((ab) (obj2)).n, System.currentTimeMillis());
        PrintWriter printwriter = new PrintWriter(stringwriter);
        printwriter.println("===============BEGIN PICASSO STATS ===============");
        printwriter.println("Memory Cache Stats");
        printwriter.print("  Max Cache Size: ");
        printwriter.println(((ac) (obj2)).a);
        printwriter.print("  Cache Size: ");
        printwriter.println(((ac) (obj2)).b);
        printwriter.print("  Cache % Full: ");
        printwriter.println((int)Math.ceil(((float)((ac) (obj2)).b / (float)((ac) (obj2)).a) * 100F));
        printwriter.print("  Cache Hits: ");
        printwriter.println(((ac) (obj2)).c);
        printwriter.print("  Cache Misses: ");
        printwriter.println(((ac) (obj2)).d);
        printwriter.println("Network Stats");
        printwriter.print("  Download Count: ");
        printwriter.println(((ac) (obj2)).k);
        printwriter.print("  Total Download Size: ");
        printwriter.println(((ac) (obj2)).e);
        printwriter.print("  Average Download Size: ");
        printwriter.println(((ac) (obj2)).h);
        printwriter.println("Bitmap Stats");
        printwriter.print("  Total Bitmaps Decoded: ");
        printwriter.println(((ac) (obj2)).l);
        printwriter.print("  Total Bitmap Size: ");
        printwriter.println(((ac) (obj2)).f);
        printwriter.print("  Total Transformed Bitmaps: ");
        printwriter.println(((ac) (obj2)).m);
        printwriter.print("  Total Transformed Bitmap Size: ");
        printwriter.println(((ac) (obj2)).g);
        printwriter.print("  Average Bitmap Size: ");
        printwriter.println(((ac) (obj2)).i);
        printwriter.print("  Average Transformed Bitmap Size: ");
        printwriter.println(((ac) (obj2)).j);
        printwriter.println("===============END PICASSO STATS ===============");
        printwriter.flush();
        p = new RuntimeException(stringwriter.toString(), ((Throwable) (obj1)));
        c.b(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj1;
        p = ((Exception) (obj1));
        c.b(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj1;
        Thread.currentThread().setName("Picasso-Idle");
        throw obj1;
          goto _L5
    }

}
