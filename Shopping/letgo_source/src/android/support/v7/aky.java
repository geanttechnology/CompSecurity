// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

// Referenced classes of package android.support.v7:
//            ale, akk, akt, akl, 
//            akg, akp, akw, akn, 
//            akf, alb, alj, akm, 
//            alc, akh, aki, alf, 
//            aku, akr, ala, ako

public class aky
{
    public static class a
    {

        private final Context a;
        private ako b;
        private ExecutorService c;
        private aki d;
        private c e;
        private f f;
        private List g;
        private android.graphics.Bitmap.Config h;
        private boolean i;
        private boolean j;

        public aky a()
        {
            Context context = a;
            if (b == null)
            {
                b = alj.a(context);
            }
            if (d == null)
            {
                d = new akr(context);
            }
            if (c == null)
            {
                c = new ala();
            }
            if (f == null)
            {
                f = f.a;
            }
            alf alf1 = new alf(d);
            return new aky(context, new akn(context, c, aky.a, b, d, alf1), d, e, f, g, alf1, h, i, j);
        }

        public a(Context context)
        {
            if (context == null)
            {
                throw new IllegalArgumentException("Context must not be null.");
            } else
            {
                a = context.getApplicationContext();
                return;
            }
        }
    }

    private static class b extends Thread
    {

        private final ReferenceQueue a;
        private final Handler b;

        public void run()
        {
            Process.setThreadPriority(10);
            try
            {
                do
                {
                    akf.a a1 = (akf.a)a.remove();
                    b.sendMessage(b.obtainMessage(3, a1.a));
                } while (true);
            }
            catch (InterruptedException interruptedexception)
            {
                return;
            }
            catch (Exception exception)
            {
                b.post(new Runnable(this, exception) {

                    final Exception a;
                    final b b;

                    public void run()
                    {
                        throw new RuntimeException(a);
                    }

            
            {
                b = b1;
                a = exception;
                super();
            }
                });
            }
        }

        b(ReferenceQueue referencequeue, Handler handler)
        {
            a = referencequeue;
            b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }
    }

    public static interface c
    {

        public abstract void a(aky aky1, Uri uri, Exception exception);
    }

    public static final class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        private static final d e[];
        final int d;

        public static d valueOf(String s)
        {
            return (d)Enum.valueOf(android/support/v7/aky$d, s);
        }

        public static d[] values()
        {
            return (d[])e.clone();
        }

        static 
        {
            a = new d("MEMORY", 0, 0xff00ff00);
            b = new d("DISK", 1, 0xff0000ff);
            c = new d("NETWORK", 2, 0xffff0000);
            e = (new d[] {
                a, b, c
            });
        }

        private d(String s, int i1, int j1)
        {
            super(s, i1);
            d = j1;
        }
    }

    public static final class e extends Enum
    {

        public static final e a;
        public static final e b;
        public static final e c;
        private static final e d[];

        public static e valueOf(String s)
        {
            return (e)Enum.valueOf(android/support/v7/aky$e, s);
        }

        public static e[] values()
        {
            return (e[])d.clone();
        }

        static 
        {
            a = new e("LOW", 0);
            b = new e("NORMAL", 1);
            c = new e("HIGH", 2);
            d = (new e[] {
                a, b, c
            });
        }

        private e(String s, int i1)
        {
            super(s, i1);
        }
    }

    public static interface f
    {

        public static final f a = new f() {

            public alb a(alb alb1)
            {
                return alb1;
            }

        };

        public abstract alb a(alb alb1);

    }


    static final Handler a = new Handler(Looper.getMainLooper()) {

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR lookupswitch 3: default 40
        //                       3: 120
        //                       8: 70
        //                       13: 166;
               goto _L1 _L2 _L3 _L4
_L1:
            throw new AssertionError((new StringBuilder()).append("Unknown handler message received: ").append(message.what).toString());
_L3:
            message = (List)message.obj;
            int k1 = message.size();
            for (int i1 = 0; i1 < k1; i1++)
            {
                akh akh1 = (akh)message.get(i1);
                akh1.b.a(akh1);
            }

            break; /* Loop/switch isn't completed */
_L2:
            message = (akf)message.obj;
            if (message.j().l)
            {
                alj.a("Main", "canceled", ((akf) (message)).b.a(), "target got garbage collected");
            }
            aky.a(((akf) (message)).a, message.d());
_L6:
            return;
_L4:
            message = (List)message.obj;
            int l1 = message.size();
            int j1 = 0;
            while (j1 < l1) 
            {
                akf akf1 = (akf)message.get(j1);
                akf1.a.c(akf1);
                j1++;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

    };
    static aky b = null;
    final Context c;
    final akn d;
    final aki e;
    final alf f;
    final Map g = new WeakHashMap();
    final Map h = new WeakHashMap();
    final ReferenceQueue i = new ReferenceQueue();
    final android.graphics.Bitmap.Config j;
    boolean k;
    volatile boolean l;
    boolean m;
    private final c n;
    private final f o;
    private final b p;
    private final List q;

    aky(Context context, akn akn1, aki aki1, c c1, f f1, List list, alf alf1, 
            android.graphics.Bitmap.Config config, boolean flag, boolean flag1)
    {
        c = context;
        d = akn1;
        e = aki1;
        n = c1;
        o = f1;
        j = config;
        int i1;
        if (list != null)
        {
            i1 = list.size();
        } else
        {
            i1 = 0;
        }
        aki1 = new ArrayList(i1 + 7);
        aki1.add(new ale(context));
        if (list != null)
        {
            aki1.addAll(list);
        }
        aki1.add(new akk(context));
        aki1.add(new akt(context));
        aki1.add(new akl(context));
        aki1.add(new akg(context));
        aki1.add(new akp(context));
        aki1.add(new akw(akn1.d, alf1));
        q = Collections.unmodifiableList(aki1);
        f = alf1;
        k = flag;
        l = flag1;
        p = new b(i, a);
        p.start();
    }

    public static aky a(Context context)
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        android/support/v7/aky;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = (new a(context)).a();
        }
        android/support/v7/aky;
        JVM INSTR monitorexit ;
_L2:
        return b;
        context;
        android/support/v7/aky;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void a(Bitmap bitmap, d d1, akf akf1)
    {
        if (!akf1.f()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!akf1.g())
        {
            g.remove(akf1.d());
        }
        if (bitmap == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (d1 == null)
        {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        akf1.a(bitmap, d1);
        if (l)
        {
            alj.a("Main", "completed", akf1.b.a(), (new StringBuilder()).append("from ").append(d1).toString());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        akf1.a();
        if (l)
        {
            alj.a("Main", "errored", akf1.b.a());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    static void a(aky aky1, Object obj)
    {
        aky1.a(obj);
    }

    private void a(Object obj)
    {
        alj.a();
        akf akf1 = (akf)g.remove(obj);
        if (akf1 != null)
        {
            akf1.b();
            d.b(akf1);
        }
        if (obj instanceof ImageView)
        {
            obj = (ImageView)obj;
            obj = (akm)h.remove(obj);
            if (obj != null)
            {
                ((akm) (obj)).a();
            }
        }
    }

    alb a(alb alb1)
    {
        alb alb2 = o.a(alb1);
        if (alb2 == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Request transformer ").append(o.getClass().getCanonicalName()).append(" returned null for ").append(alb1).toString());
        } else
        {
            return alb2;
        }
    }

    public alc a(int i1)
    {
        if (i1 == 0)
        {
            throw new IllegalArgumentException("Resource ID must not be zero.");
        } else
        {
            return new alc(this, null, i1);
        }
    }

    public alc a(Uri uri)
    {
        return new alc(this, uri, 0);
    }

    public alc a(String s)
    {
        if (s == null)
        {
            return new alc(this, null, 0);
        }
        if (s.trim().length() == 0)
        {
            throw new IllegalArgumentException("Path must not be empty.");
        } else
        {
            return a(Uri.parse(s));
        }
    }

    List a()
    {
        return q;
    }

    void a(akf akf1)
    {
        Object obj = akf1.d();
        if (obj != null && g.get(obj) != akf1)
        {
            a(obj);
            g.put(obj, akf1);
        }
        b(akf1);
    }

    void a(akh akh1)
    {
        boolean flag2 = true;
        akf akf1 = akh1.i();
        List list = akh1.k();
        boolean flag;
        boolean flag1;
        if (list != null && !list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag2;
        if (akf1 == null)
        {
            if (flag)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1)
        {
            Uri uri = akh1.h().d;
            Exception exception = akh1.l();
            Bitmap bitmap = akh1.e();
            akh1 = akh1.m();
            if (akf1 != null)
            {
                a(bitmap, ((d) (akh1)), akf1);
            }
            if (flag)
            {
                int j1 = list.size();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    a(bitmap, ((d) (akh1)), (akf)list.get(i1));
                }

            }
            if (n != null && exception != null)
            {
                n.a(this, uri, exception);
                return;
            }
        }
    }

    public void a(ImageView imageview)
    {
        a(imageview);
    }

    void a(ImageView imageview, akm akm1)
    {
        h.put(imageview, akm1);
    }

    Bitmap b(String s)
    {
        s = e.a(s);
        if (s != null)
        {
            f.a();
            return s;
        } else
        {
            f.b();
            return s;
        }
    }

    void b(akf akf1)
    {
        d.a(akf1);
    }

    void c(akf akf1)
    {
        Bitmap bitmap = null;
        if (aku.a(akf1.e))
        {
            bitmap = b(akf1.e());
        }
        if (bitmap != null)
        {
            a(bitmap, d.a, akf1);
            if (l)
            {
                alj.a("Main", "completed", akf1.b.a(), (new StringBuilder()).append("from ").append(d.a).toString());
            }
        } else
        {
            a(akf1);
            if (l)
            {
                alj.a("Main", "resumed", akf1.b.a());
                return;
            }
        }
    }

}
