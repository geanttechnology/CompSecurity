// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.google.android.gms.d:
//            ce, ct, ab, he, 
//            ad, gv, gm

final class a
    implements ce
{

    final ab a;
    final nal.util.client.b.a b;

    public final void a(he he, Map map)
    {
label0:
        {
            synchronized (b.b.a)
            {
                if (b.b.b() != -1 && b.b.b() != 1)
                {
                    break label0;
                }
            }
            return;
        }
        b.b.g = 0;
        b.b.e.b(a);
        b.b.b(a);
        b.b.f = b.b;
        com.google.android.gms.ads.internal.util.client.b.a(2);
        he;
        JVM INSTR monitorexit ;
        return;
        map;
        he;
        JVM INSTR monitorexit ;
        throw map;
    }

    a(a a1, ab ab)
    {
        b = a1;
        a = ab;
        super();
    }

    // Unreferenced inner class com/google/android/gms/d/ct$1

/* anonymous class */
    final class ct._cls1
        implements Runnable
    {

        final ct.e a;
        final ct b;

        public final void run()
        {
            ad ad1 = new ad(b.b, b.d, null);
            ad1.a(new ct._cls1._cls1(ad1));
            ad1.a("/jsLoaded", new ct._cls1._cls2(this, ad1));
            gv gv1 = new gv();
            ce ce1 = new ct._cls1._cls3(ad1, gv1);
            gv1.a = ce1;
            ad1.a("/requestReload", ce1);
            if (b.c.endsWith(".js"))
            {
                ad1.a(b.c);
            } else
            if (b.c.startsWith("<html>"))
            {
                ad1.c(b.c);
            } else
            {
                ad1.b(b.c);
            }
            (new Timer()).schedule(new ct._cls1._cls4(ad1), ct.a.a);
        }

            
            {
                b = ct1;
                a = e;
                super();
            }

        // Unreferenced inner class com/google/android/gms/d/ct$1$1

/* anonymous class */
        final class ct._cls1._cls1
            implements ab.a
        {

            final ab a;
            final ct._cls1 b;

            public final void a()
            {
                (new Timer()).schedule(new ct._cls1._cls1._cls1(this), com.google.android.gms.d.ct.a.b);
            }

                    
                    {
                        b = ct._cls1.this;
                        a = ab1;
                        super();
                    }
        }


        // Unreferenced inner class com/google/android/gms/d/ct$1$1$1

/* anonymous class */
        final class ct._cls1._cls1._cls1 extends TimerTask
        {

            final ct._cls1._cls1 a;

            public final void run()
            {
label0:
                {
                    synchronized (a.b.b.a)
                    {
                        if (a.b.a.e() != -1 && a.b.a.e() != 1)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                a.b.a.d();
                gm.a(new ct._cls1._cls1._cls1._cls1(this));
                com.google.android.gms.ads.internal.util.client.b.a(2);
                obj;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }


        // Unreferenced inner class com/google/android/gms/d/ct$1$1$1$1

/* anonymous class */
        final class ct._cls1._cls1._cls1._cls1
            implements Runnable
        {

            final ct._cls1._cls1._cls1 a;

            public final void run()
            {
                a.a.a.a();
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }


        // Unreferenced inner class com/google/android/gms/d/ct$1$3

/* anonymous class */
        final class ct._cls1._cls3
            implements ce
        {

            final ab a;
            final gv b;
            final ct._cls1 c;

            public final void a(he he, Map map)
            {
                synchronized (c.b.a)
                {
                    com.google.android.gms.ads.internal.util.client.b.a(4);
                    if (c.b.g == 0)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(4);
                        c.b.g = 2;
                        c.b.a();
                    }
                    a.b("/requestReload", (ce)b.a);
                }
                return;
                map;
                he;
                JVM INSTR monitorexit ;
                throw map;
            }

                    
                    {
                        c = ct._cls1.this;
                        a = ab1;
                        b = gv1;
                        super();
                    }
        }


        // Unreferenced inner class com/google/android/gms/d/ct$1$4

/* anonymous class */
        final class ct._cls1._cls4 extends TimerTask
        {

            final ab a;
            final ct._cls1 b;

            public final void run()
            {
label0:
                {
                    synchronized (b.b.a)
                    {
                        if (b.a.e() != -1 && b.a.e() != 1)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                b.a.d();
                gm.a(new ct._cls1._cls4._cls1(this));
                com.google.android.gms.ads.internal.util.client.b.a(2);
                obj;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

                    
                    {
                        b = ct._cls1.this;
                        a = ab1;
                        super();
                    }
        }


        // Unreferenced inner class com/google/android/gms/d/ct$1$4$1

/* anonymous class */
        final class ct._cls1._cls4._cls1
            implements Runnable
        {

            final ct._cls1._cls4 a;

            public final void run()
            {
                a.a.a();
            }

                    
                    {
                        a = _pcls4;
                        super();
                    }
        }

    }

}
