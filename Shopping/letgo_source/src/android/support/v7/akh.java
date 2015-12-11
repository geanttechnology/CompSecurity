// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.os.Handler;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.support.v7:
//            akf, ald, alb, aks, 
//            alj, alh, aky, aku, 
//            aki, alf, akv, akn, 
//            alg

class akh
    implements Runnable
{

    private static final Object t = new Object();
    private static final ThreadLocal u = new ThreadLocal() {

        protected StringBuilder a()
        {
            return new StringBuilder("Picasso-");
        }

        protected Object initialValue()
        {
            return a();
        }

    };
    private static final AtomicInteger v = new AtomicInteger();
    private static final ald w = new ald() {

        public ald.a a(alb alb1, int i1)
            throws IOException
        {
            throw new IllegalStateException((new StringBuilder()).append("Unrecognized type of request: ").append(alb1).toString());
        }

        public boolean a(alb alb1)
        {
            return true;
        }

    };
    final int a;
    final aky b;
    final akn c;
    final aki d;
    final alf e;
    final String f;
    final alb g;
    final int h;
    int i;
    final ald j;
    akf k;
    List l;
    Bitmap m;
    Future n;
    aky.d o;
    Exception p;
    int q;
    int r;
    aky.e s;

    akh(aky aky1, akn akn1, aki aki1, alf alf1, akf akf1, ald ald1)
    {
        a = v.incrementAndGet();
        b = aky1;
        c = akn1;
        d = aki1;
        e = alf1;
        k = akf1;
        f = akf1.e();
        g = akf1.c();
        s = akf1.k();
        h = akf1.h();
        i = akf1.i();
        j = ald1;
        r = ald1.a();
    }

    static Bitmap a(alb alb1, Bitmap bitmap, int i1)
    {
        Object obj;
        int j1;
        int k1;
        boolean flag4;
        j1 = bitmap.getWidth();
        k1 = bitmap.getHeight();
        flag4 = alb1.l;
        obj = new Matrix();
        if (!alb1.f()) goto _L2; else goto _L1
_L1:
        float f1;
        int l1;
        int i2;
        int l2;
        int i3;
        l2 = alb1.h;
        i3 = alb1.i;
        f1 = alb1.m;
        float f7;
        if (f1 != 0.0F)
        {
            if (alb1.p)
            {
                ((Matrix) (obj)).setRotate(f1, alb1.n, alb1.o);
            } else
            {
                ((Matrix) (obj)).setRotate(f1);
            }
        }
        if (!alb1.j) goto _L4; else goto _L3
_L3:
        float f4 = (float)l2 / (float)j1;
        f1 = (float)i3 / (float)k1;
        int j2;
        int k2;
        if (f4 > f1)
        {
            f7 = k1;
            i2 = (int)Math.ceil((f1 / f4) * f7);
            l1 = (k1 - i2) / 2;
            f1 = (float)i3 / (float)i2;
            j2 = 0;
            k2 = j1;
        } else
        {
            float f8 = j1;
            k2 = (int)Math.ceil((f4 / f1) * f8);
            j2 = (j1 - k2) / 2;
            f4 = (float)l2 / (float)k2;
            l1 = 0;
            i2 = k1;
        }
        if (a(flag4, j1, k1, l2, i3))
        {
            ((Matrix) (obj)).preScale(f4, f1);
        }
        j1 = j2;
        k1 = l1;
        l1 = k2;
_L6:
        if (i1 != 0)
        {
            ((Matrix) (obj)).preRotate(i1);
        }
        obj = Bitmap.createBitmap(bitmap, j1, k1, l1, i2, ((Matrix) (obj)), true);
        alb1 = bitmap;
        if (obj != bitmap)
        {
            bitmap.recycle();
            alb1 = ((alb) (obj));
        }
        return alb1;
_L4:
        if (alb1.k)
        {
            float f2 = (float)l2 / (float)j1;
            float f5 = (float)i3 / (float)k1;
            boolean flag;
            boolean flag2;
            if (f2 >= f5)
            {
                f2 = f5;
            }
            if (a(flag4, j1, k1, l2, i3))
            {
                ((Matrix) (obj)).preScale(f2, f2);
            }
            flag = false;
            flag2 = false;
            i2 = k1;
            l1 = j1;
            j1 = ((flag2) ? 1 : 0);
            k1 = ((flag) ? 1 : 0);
            continue; /* Loop/switch isn't completed */
        }
        if ((l2 != 0 || i3 != 0) && (l2 != j1 || i3 != k1))
        {
            float f3;
            float f6;
            boolean flag1;
            boolean flag3;
            if (l2 != 0)
            {
                f3 = (float)l2 / (float)j1;
            } else
            {
                f3 = (float)i3 / (float)k1;
            }
            if (i3 != 0)
            {
                f6 = (float)i3 / (float)k1;
            } else
            {
                f6 = (float)l2 / (float)j1;
            }
            if (a(flag4, j1, k1, l2, i3))
            {
                ((Matrix) (obj)).preScale(f3, f6);
            }
        }
_L2:
        flag1 = false;
        flag3 = false;
        i2 = k1;
        l1 = j1;
        j1 = ((flag3) ? 1 : 0);
        k1 = ((flag1) ? 1 : 0);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static Bitmap a(InputStream inputstream, alb alb1)
        throws IOException
    {
        InputStream inputstream1 = new aks(inputstream);
        long l1 = inputstream1.a(0x10000);
        inputstream = ald.c(alb1);
        boolean flag = ald.a(inputstream);
        boolean flag1 = alj.c(inputstream1);
        inputstream1.a(l1);
        if (flag1)
        {
            inputstream1 = alj.b(inputstream1);
            if (flag)
            {
                BitmapFactory.decodeByteArray(inputstream1, 0, inputstream1.length, inputstream);
                ald.a(alb1.h, alb1.i, inputstream, alb1);
            }
            inputstream = BitmapFactory.decodeByteArray(inputstream1, 0, inputstream1.length, inputstream);
        } else
        {
            if (flag)
            {
                BitmapFactory.decodeStream(inputstream1, null, inputstream);
                ald.a(alb1.h, alb1.i, inputstream, alb1);
                inputstream1.a(l1);
            }
            alb1 = BitmapFactory.decodeStream(inputstream1, null, inputstream);
            inputstream = alb1;
            if (alb1 == null)
            {
                throw new IOException("Failed to decode stream.");
            }
        }
        return inputstream;
    }

    static Bitmap a(List list, Bitmap bitmap)
    {
        int j1 = list.size();
        for (int i1 = 0; i1 < j1;)
        {
            alh alh1 = (alh)list.get(i1);
            Bitmap bitmap1;
            try
            {
                bitmap1 = alh1.a(bitmap);
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                aky.a.post(new Runnable(alh1, list) {

                    final alh a;
                    final RuntimeException b;

                    public void run()
                    {
                        throw new RuntimeException((new StringBuilder()).append("Transformation ").append(a.a()).append(" crashed with exception.").toString(), b);
                    }

            
            {
                a = alh1;
                b = runtimeexception;
                super();
            }
                });
                return null;
            }
            if (bitmap1 == null)
            {
                bitmap = (new StringBuilder()).append("Transformation ").append(alh1.a()).append(" returned null after ").append(i1).append(" previous transformation(s).\n\nTransformation list:\n");
                for (list = list.iterator(); list.hasNext(); bitmap.append(((alh)list.next()).a()).append('\n')) { }
                aky.a.post(new Runnable(bitmap) {

                    final StringBuilder a;

                    public void run()
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
                aky.a.post(new Runnable(alh1) {

                    final alh a;

                    public void run()
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Transformation ").append(a.a()).append(" returned input Bitmap but recycled it.").toString());
                    }

            
            {
                a = alh1;
                super();
            }
                });
                return null;
            }
            if (bitmap1 != bitmap && !bitmap.isRecycled())
            {
                aky.a.post(new Runnable(alh1) {

                    final alh a;

                    public void run()
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Transformation ").append(a.a()).append(" mutated input Bitmap but failed to recycle the original.").toString());
                    }

            
            {
                a = alh1;
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

    static akh a(aky aky1, akn akn1, aki aki1, alf alf1, akf akf1)
    {
        alb alb1 = akf1.c();
        List list = aky1.a();
        int i1 = 0;
        for (int j1 = list.size(); i1 < j1; i1++)
        {
            ald ald1 = (ald)list.get(i1);
            if (ald1.a(alb1))
            {
                return new akh(aky1, akn1, aki1, alf1, akf1, ald1);
            }
        }

        return new akh(aky1, akn1, aki1, alf1, akf1, w);
    }

    static void a(alb alb1)
    {
        alb1 = alb1.c();
        StringBuilder stringbuilder = (StringBuilder)u.get();
        stringbuilder.ensureCapacity("Picasso-".length() + alb1.length());
        stringbuilder.replace("Picasso-".length(), stringbuilder.length(), alb1);
        Thread.currentThread().setName(stringbuilder.toString());
    }

    private static boolean a(boolean flag, int i1, int j1, int k1, int l1)
    {
        return !flag || i1 > k1 || j1 > l1;
    }

    private aky.e o()
    {
        aky.e e1;
        aky.e e2;
        boolean flag;
        boolean flag2;
        boolean flag3 = true;
        flag2 = false;
        e1 = aky.e.a;
        boolean flag1;
        if (l != null && !l.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag3;
        if (k == null)
        {
            if (flag)
            {
                flag1 = flag3;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1) goto _L2; else goto _L1
_L1:
        e2 = e1;
_L4:
        return e2;
_L2:
        if (k != null)
        {
            e1 = k.k();
        }
        e2 = e1;
        if (!flag)
        {
            continue;
        }
        int j1 = l.size();
        int i1 = ((flag2) ? 1 : 0);
        do
        {
            e2 = e1;
            if (i1 >= j1)
            {
                continue;
            }
            e2 = ((akf)l.get(i1)).k();
            if (e2.ordinal() > e1.ordinal())
            {
                e1 = e2;
            }
            i1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    Bitmap a()
        throws IOException
    {
        Object obj = null;
        if (!aku.a(h)) goto _L2; else goto _L1
_L1:
        Object obj2;
        obj2 = d.a(f);
        obj = obj2;
        if (obj2 == null) goto _L2; else goto _L3
_L3:
        Object obj1;
        e.a();
        o = aky.d.a;
        obj1 = obj2;
        if (b.l)
        {
            alj.a("Hunter", "decoded", g.a(), "from cache");
            obj1 = obj2;
        }
_L5:
        return ((Bitmap) (obj1));
_L2:
        obj1 = g;
        int i1;
        if (r == 0)
        {
            i1 = akv.c.d;
        } else
        {
            i1 = i;
        }
        obj1.c = i1;
        obj2 = j.a(g, i);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        o = ((ald.a) (obj2)).c();
        q = ((ald.a) (obj2)).d();
        obj1 = ((ald.a) (obj2)).a();
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        obj1 = ((ald.a) (obj2)).b();
        obj = a(((InputStream) (obj1)), g);
        alj.a(((InputStream) (obj1)));
        obj1 = obj;
        if (obj == null) goto _L5; else goto _L4
_L4:
        if (b.l)
        {
            alj.a("Hunter", "decoded", g.a());
        }
        e.a(((Bitmap) (obj)));
        if (g.e())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        if (q == 0) goto _L5; else goto _L6
_L6:
        obj2 = t;
        obj2;
        JVM INSTR monitorenter ;
        if (g.f())
        {
            break MISSING_BLOCK_LABEL_256;
        }
        obj1 = obj;
        if (q == 0)
        {
            break MISSING_BLOCK_LABEL_299;
        }
        obj = a(g, ((Bitmap) (obj)), q);
        obj1 = obj;
        if (!b.l)
        {
            break MISSING_BLOCK_LABEL_299;
        }
        alj.a("Hunter", "transformed", g.a());
        obj1 = obj;
        obj = obj1;
        if (!g.g())
        {
            break MISSING_BLOCK_LABEL_356;
        }
        obj1 = a(g.g, ((Bitmap) (obj1)));
        obj = obj1;
        if (!b.l)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        alj.a("Hunter", "transformed", g.a(), "from custom transformations");
        obj = obj1;
        obj2;
        JVM INSTR monitorexit ;
        obj1 = obj;
        if (obj == null) goto _L5; else goto _L7
_L7:
        e.b(((Bitmap) (obj)));
        return ((Bitmap) (obj));
        Exception exception;
        exception;
        alj.a(((InputStream) (obj1)));
        throw exception;
        exception;
        obj2;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void a(akf akf1)
    {
        alb alb1;
        boolean flag;
        flag = b.l;
        alb1 = akf1.b;
        if (k != null) goto _L2; else goto _L1
_L1:
        k = akf1;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (l != null && !l.isEmpty()) goto _L6; else goto _L5
_L5:
        alj.a("Hunter", "joined", alb1.a(), "to empty hunter");
_L4:
        return;
_L6:
        alj.a("Hunter", "joined", alb1.a(), alj.a(this, "to "));
        return;
_L2:
        if (l == null)
        {
            l = new ArrayList(3);
        }
        l.add(akf1);
        if (flag)
        {
            alj.a("Hunter", "joined", alb1.a(), alj.a(this, "to "));
        }
        akf1 = akf1.k();
        if (akf1.ordinal() > s.ordinal())
        {
            s = akf1;
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    boolean a(boolean flag, NetworkInfo networkinfo)
    {
        boolean flag1;
        if (r > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            return false;
        } else
        {
            r = r - 1;
            return j.a(flag, networkinfo);
        }
    }

    void b(akf akf1)
    {
        boolean flag = false;
        if (k != akf1) goto _L2; else goto _L1
_L1:
        k = null;
        flag = true;
_L4:
        if (flag && akf1.k() == s)
        {
            s = o();
        }
        if (b.l)
        {
            alj.a("Hunter", "removed", akf1.b.a(), alj.a(this, "from "));
        }
        return;
_L2:
        if (l != null)
        {
            flag = l.remove(akf1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean b()
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

    boolean c()
    {
        return n != null && n.isCancelled();
    }

    boolean d()
    {
        return j.b();
    }

    Bitmap e()
    {
        return m;
    }

    String f()
    {
        return f;
    }

    int g()
    {
        return h;
    }

    alb h()
    {
        return g;
    }

    akf i()
    {
        return k;
    }

    aky j()
    {
        return b;
    }

    List k()
    {
        return l;
    }

    Exception l()
    {
        return p;
    }

    aky.d m()
    {
        return o;
    }

    aky.e n()
    {
        return s;
    }

    public void run()
    {
        a(g);
        if (b.l)
        {
            alj.a("Hunter", "executing", alj.a(this));
        }
        m = a();
        if (m != null) goto _L2; else goto _L1
_L1:
        c.c(this);
_L4:
        Thread.currentThread().setName("Picasso-Idle");
        return;
_L2:
        c.a(this);
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        if (!((ako.b) (obj)).a || ((ako.b) (obj)).b != 504)
        {
            p = ((Exception) (obj));
        }
        c.c(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj;
        p = ((Exception) (obj));
        c.b(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj;
        p = ((Exception) (obj));
        c.b(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj;
        StringWriter stringwriter = new StringWriter();
        e.e().a(new PrintWriter(stringwriter));
        p = new RuntimeException(stringwriter.toString(), ((Throwable) (obj)));
        c.c(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj;
        p = ((Exception) (obj));
        c.c(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj;
        Thread.currentThread().setName("Picasso-Idle");
        throw obj;
    }

}
