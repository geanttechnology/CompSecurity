// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package android.support.v7:
//            alz, amw, amo, ana, 
//            ape, apc, amq, apf, 
//            apd, apq, amt, apn, 
//            alt, amc, apm, apl, 
//            aol

public class apk
{
    static class a
    {

        private static final apk a = new apk();

        static apk a()
        {
            return a;
        }

    }

    public static interface b
    {

        public abstract Object usingSettings(apn apn1);
    }


    private final AtomicReference a;
    private final CountDownLatch b;
    private apm c;
    private boolean d;

    private apk()
    {
        a = new AtomicReference();
        b = new CountDownLatch(1);
        d = false;
    }


    public static apk a()
    {
        return a.a();
    }

    private void a(apn apn1)
    {
        a.set(apn1);
        b.countDown();
    }

    public apk a(alz alz1, amw amw1, aol aol, String s, String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return this;
_L2:
        if (c == null)
        {
            android.content.Context context = alz1.getContext();
            String s3 = amw1.c();
            String s4 = (new amo()).a(context);
            String s5 = amw1.h();
            ana ana1 = new ana();
            ape ape1 = new ape();
            apc apc1 = new apc(alz1);
            String s6 = amq.k(context);
            aol = new apf(alz1, s2, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[] {
                s3
            }), aol);
            c = new apd(alz1, new apq(s4, amw1.a(s4, s3), amq.a(new String[] {
                amq.m(context)
            }), s1, s, amt.a(s5).a(), s6), ana1, ape1, apc1, aol);
        }
        d = true;
        if (true) goto _L1; else goto _L3
_L3:
        alz1;
        throw alz1;
    }

    public Object a(b b1, Object obj)
    {
        apn apn1 = (apn)a.get();
        if (apn1 == null)
        {
            return obj;
        } else
        {
            return b1.usingSettings(apn1);
        }
    }

    public apn b()
    {
        apn apn1;
        try
        {
            b.await();
            apn1 = (apn)a.get();
        }
        catch (InterruptedException interruptedexception)
        {
            alt.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
        return apn1;
    }

    public boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        apn apn1;
        apn1 = c.a();
        a(apn1);
        boolean flag;
        if (apn1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean d()
    {
        this;
        JVM INSTR monitorenter ;
        apn apn1;
        apn1 = c.a(apl.b);
        a(apn1);
        if (apn1 != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        alt.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        boolean flag;
        if (apn1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }
}
