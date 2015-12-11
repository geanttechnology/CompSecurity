// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            dg, dk

class lT
    implements Runnable
{

    final int lT;
    final lT lU;

    public void run()
    {
        if (dg.c(lU.) != null)
        {
            dg.c(lU.).onApplicationDisconnected(lT);
        }
    }

    nit>(nit> nit>, int i)
    {
        lU = nit>;
        lT = i;
        super();
    }

    // Unreferenced inner class com/google/android/gms/internal/dg$1

/* anonymous class */
    class dg._cls1 extends dj.a
    {

        final dg lS;

        private void b(long l, int i)
        {
            com.google.android.gms.common.api.a.c c;
            synchronized (dg.g(lS))
            {
                c = (com.google.android.gms.common.api.a.c)dg.g(lS).remove(Long.valueOf(l));
            }
            if (c != null)
            {
                c.a(new Status(i));
            }
            return;
            exception;
            map;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private boolean x(int i)
        {
            Object obj = dg.ba();
            obj;
            JVM INSTR monitorenter ;
            if (dg.h(lS) == null)
            {
                break MISSING_BLOCK_LABEL_49;
            }
            dg.h(lS).a(new Status(i));
            dg.b(lS, null);
            return true;
            obj;
            JVM INSTR monitorexit ;
            return false;
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
        {
            dg.a(lS, applicationmetadata.getApplicationId());
            dg.b(lS, s1);
            synchronized (dg.aZ())
            {
                if (dg.b(lS) != null)
                {
                    dg.b(lS).a(new dg.a(new Status(0), applicationmetadata, s, s1, flag));
                    dg.a(lS, null);
                }
            }
            return;
            applicationmetadata;
            obj;
            JVM INSTR monitorexit ;
            throw applicationmetadata;
        }

        public void a(String s, long l)
        {
            b(l, 0);
        }

        public void a(String s, long l, int i)
        {
            b(l, i);
        }

        public void a(String s, String s1)
        {
            dg.aY().b("Receive (type=text, ns=%s) %s", new Object[] {
                s, s1
            });
            dg.d(lS).post(new dg._cls1._cls3(s, s1));
        }

        public void b(String s, double d, boolean flag)
        {
            dg.d(lS).post(new dg._cls1._cls2(s, d, flag));
        }

        public void b(String s, byte abyte0[])
        {
            dg.aY().b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] {
                s, Integer.valueOf(abyte0.length)
            });
        }

        public void onApplicationDisconnected(int i)
        {
            dg.a(lS, null);
            dg.b(lS, null);
            while (x(i) || dg.c(lS) == null) 
            {
                return;
            }
            dg.d(lS).post(new dg._cls1._cls1(this, i));
        }

        public void t(int i)
        {
            dg.aY().b("ICastDeviceControllerListener.onDisconnected", new Object[0]);
            dg.a(lS, false);
            dg.a(lS, null);
            if (i != 0)
            {
                lS.I(2);
            }
        }

        public void u(int i)
        {
            synchronized (dg.aZ())
            {
                if (dg.b(lS) != null)
                {
                    dg.b(lS).a(new dg.a(new Status(i)));
                    dg.a(lS, null);
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void v(int i)
        {
            x(i);
        }

        public void w(int i)
        {
            x(i);
        }

            
            {
                lS = dg1;
                super();
            }

        // Unreferenced inner class com/google/android/gms/internal/dg$1$2

/* anonymous class */
        class dg._cls1._cls2
            implements Runnable
        {

            final dg._cls1 lU;
            final String lV;
            final double lp;
            final boolean lq;

            public void run()
            {
                dg.a(lU.lS, lV, lp, lq);
            }

                    
                    {
                        lU = dg._cls1.this;
                        lV = s;
                        lp = d;
                        lq = flag;
                        super();
                    }
        }


        // Unreferenced inner class com/google/android/gms/internal/dg$1$3

/* anonymous class */
        class dg._cls1._cls3
            implements Runnable
        {

            final String km;
            final dg._cls1 lU;
            final String lW;

            public void run()
            {
                com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback;
                synchronized (dg.e(lU.lS))
                {
                    messagereceivedcallback = (com.google.android.gms.cast.Cast.MessageReceivedCallback)dg.e(lU.lS).get(km);
                }
                if (messagereceivedcallback != null)
                {
                    messagereceivedcallback.onMessageReceived(dg.f(lU.lS), km, lW);
                    return;
                } else
                {
                    dg.aY().b("Discarded message for unknown namespace '%s'", new Object[] {
                        km
                    });
                    return;
                }
                exception;
                map;
                JVM INSTR monitorexit ;
                throw exception;
            }

                    
                    {
                        lU = dg._cls1.this;
                        km = s;
                        lW = s1;
                        super();
                    }
        }

    }

}
