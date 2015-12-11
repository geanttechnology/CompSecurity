// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.g.c:
//            aa, f, p, g, 
//            b, l, s, i, 
//            y, a, x, ah, 
//            h, d, ab, j, 
//            c, q

public final class u
{
    public static final class a
    {

        public final Context a;
        public j b;
        public ExecutorService c;
        public com.g.c.d d;
        public c e;
        public f f;
        public List g;
        public android.graphics.Bitmap.Config h;
        public boolean i;
        public boolean j;

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

    private static final class b extends Thread
    {

        private final ReferenceQueue a;
        private final Handler b;

        public final void run()
        {
            Process.setThreadPriority(10);
_L1:
            a.a a1;
            Message message;
            try
            {
                a1 = (a.a)a.remove(1000L);
                message = b.obtainMessage();
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

                    public final void run()
                    {
                        throw new RuntimeException(a);
                    }

            
            {
                b = b1;
                a = exception;
                super();
            }
                });
                return;
            }
            if (a1 == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            message.what = 3;
            message.obj = a1.a;
            b.sendMessage(message);
              goto _L1
            message.recycle();
              goto _L1
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
    }

    public static final class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        private static final d e[];
        final int d;

        public static d valueOf(String s1)
        {
            return (d)Enum.valueOf(com/g/c/u$d, s1);
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

        private d(String s1, int i1, int j1)
        {
            super(s1, i1);
            d = j1;
        }
    }

    public static final class e extends Enum
    {

        public static final e a;
        public static final e b;
        public static final e c;
        private static final e d[];

        public static e valueOf(String s1)
        {
            return (e)Enum.valueOf(com/g/c/u$e, s1);
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

        private e(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    public static interface f
    {

        public static final f a = new f() {

            public final x a(x x1)
            {
                return x1;
            }

        };

        public abstract x a(x x1);

    }


    public static final Handler a = new Handler(Looper.getMainLooper()) {

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR lookupswitch 3: default 40
        //                       3: 278
        //                       8: 67
        //                       13: 324;
               goto _L1 _L2 _L3 _L4
_L1:
            throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(message.what).toString());
_L3:
            message = (List)message.obj;
            int j2 = message.size();
            int k1;
            int i2;
            for (int i1 = 0; i1 < j2; i1++)
            {
                Object obj = (com.g.c.c)message.get(i1);
                u u1 = ((com.g.c.c) (obj)).b;
                com.g.c.a a1 = ((com.g.c.c) (obj)).k;
                List list1 = ((com.g.c.c) (obj)).l;
                if (list1 != null && !list1.isEmpty())
                {
                    k1 = 1;
                } else
                {
                    k1 = 0;
                }
                if (a1 != null || k1 != 0)
                {
                    i2 = 1;
                } else
                {
                    i2 = 0;
                }
                if (i2 != 0)
                {
                    Object obj1 = ((com.g.c.c) (obj)).g.d;
                    obj1 = ((com.g.c.c) (obj)).p;
                    obj1 = ((com.g.c.c) (obj)).m;
                    obj = ((com.g.c.c) (obj)).o;
                    if (a1 != null)
                    {
                        u1.a(((Bitmap) (obj1)), ((d) (obj)), a1);
                    }
                    if (k1 != 0)
                    {
                        i2 = list1.size();
                        for (k1 = 0; k1 < i2; k1++)
                        {
                            u1.a(((Bitmap) (obj1)), ((d) (obj)), (com.g.c.a)list1.get(k1));
                        }

                    }
                }
            }

            break; /* Loop/switch isn't completed */
_L2:
            message = (com.g.c.a)message.obj;
            if (((com.g.c.a) (message)).a.n)
            {
                ah.a("Main", "canceled", ((com.g.c.a) (message)).b.a(), "target got garbage collected");
            }
            u.a(((com.g.c.a) (message)).a, message.c());
_L6:
            return;
_L4:
            List list = (List)message.obj;
            int l1 = list.size();
            int j1 = 0;
            while (j1 < l1) 
            {
                com.g.c.a a2 = (com.g.c.a)list.get(j1);
                u u2 = a2.a;
                message = null;
                if (com.g.c.q.a(a2.e))
                {
                    message = u2.b(a2.i);
                }
                if (message != null)
                {
                    u2.a(message, d.a, a2);
                    if (u2.n)
                    {
                        ah.a("Main", "completed", a2.b.a(), (new StringBuilder("from ")).append(d.a).toString());
                    }
                } else
                {
                    u2.a(a2);
                    if (u2.n)
                    {
                        ah.a("Main", "resumed", a2.b.a());
                    }
                }
                j1++;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

    };
    static volatile u b = null;
    final f c;
    final List d;
    final Context e;
    final i f;
    final com.g.c.d g;
    final ab h;
    final Map i = new WeakHashMap();
    final Map j = new WeakHashMap();
    final ReferenceQueue k = new ReferenceQueue();
    final android.graphics.Bitmap.Config l;
    boolean m;
    volatile boolean n;
    boolean o;
    private final c p;
    private final b q;

    public u(Context context, i i1, com.g.c.d d1, c c1, f f1, List list, ab ab1, 
            android.graphics.Bitmap.Config config, boolean flag, boolean flag1)
    {
        e = context;
        f = i1;
        g = d1;
        p = c1;
        c = f1;
        l = config;
        int j1;
        if (list != null)
        {
            j1 = list.size();
        } else
        {
            j1 = 0;
        }
        d1 = new ArrayList(j1 + 7);
        d1.add(new aa(context));
        if (list != null)
        {
            d1.addAll(list);
        }
        d1.add(new com.g.c.f(context));
        d1.add(new p(context));
        d1.add(new g(context));
        d1.add(new com.g.c.b(context));
        d1.add(new l(context));
        d1.add(new s(i1.d, ab1));
        d = Collections.unmodifiableList(d1);
        h = ab1;
        m = flag;
        n = flag1;
        q = new b(k, a);
        q.start();
    }

    static void a(u u1, Object obj)
    {
        u1.a(obj);
    }

    public final y a(String s1)
    {
        if (s1 == null)
        {
            return new y(this, null);
        }
        if (s1.trim().length() == 0)
        {
            throw new IllegalArgumentException("Path must not be empty.");
        } else
        {
            return new y(this, Uri.parse(s1));
        }
    }

    final void a(Bitmap bitmap, d d1, com.g.c.a a1)
    {
        if (!a1.l) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!a1.k)
        {
            i.remove(a1.c());
        }
        if (bitmap == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (d1 == null)
        {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        a1.a(bitmap, d1);
        if (n)
        {
            ah.a("Main", "completed", a1.b.a(), (new StringBuilder("from ")).append(d1).toString());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        a1.a();
        if (n)
        {
            ah.a("Main", "errored", a1.b.a());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    final void a(com.g.c.a a1)
    {
        Object obj = a1.c();
        if (obj != null && i.get(obj) != a1)
        {
            a(obj);
            i.put(obj, a1);
        }
        b(a1);
    }

    public final void a(Object obj)
    {
        ah.a();
        com.g.c.a a1 = (com.g.c.a)i.remove(obj);
        if (a1 != null)
        {
            a1.b();
            i i1 = f;
            i1.i.sendMessage(i1.i.obtainMessage(2, a1));
        }
        if (obj instanceof ImageView)
        {
            obj = (ImageView)obj;
            obj = (h)j.remove(obj);
            if (obj != null)
            {
                obj.c = null;
                Object obj1 = (ImageView)((h) (obj)).b.get();
                if (obj1 != null)
                {
                    obj1 = ((ImageView) (obj1)).getViewTreeObserver();
                    if (((ViewTreeObserver) (obj1)).isAlive())
                    {
                        ((ViewTreeObserver) (obj1)).removeOnPreDrawListener(((android.view.ViewTreeObserver.OnPreDrawListener) (obj)));
                    }
                }
            }
        }
    }

    final Bitmap b(String s1)
    {
        s1 = g.a(s1);
        if (s1 != null)
        {
            h.a();
            return s1;
        } else
        {
            h.c.sendEmptyMessage(1);
            return s1;
        }
    }

    final void b(com.g.c.a a1)
    {
        i i1 = f;
        i1.i.sendMessage(i1.i.obtainMessage(1, a1));
    }

}
