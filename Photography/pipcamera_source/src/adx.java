// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class adx
{

    private final AtomicReference a;
    private final CountDownLatch b;
    private aea c;
    private boolean d;

    private adx()
    {
        a = new AtomicReference();
        b = new CountDownLatch(1);
        d = false;
    }


    public static adx a()
    {
        return ady.a();
    }

    private void a(aeb aeb1)
    {
        a.set(aeb1);
        b.countDown();
    }

    public adx a(aad aad1, IdManager idmanager, acy acy, String s, String s1, String s2)
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
            android.content.Context context = aad1.getContext();
            String s3 = idmanager.c();
            String s4 = (new aau()).a(context);
            String s5 = idmanager.h();
            abi abi1 = new abi();
            adr adr1 = new adr();
            adp adp1 = new adp(aad1);
            String s6 = CommonUtils.k(context);
            acy = new ads(aad1, s2, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[] {
                s3
            }), acy);
            c = new adq(aad1, new aee(s4, idmanager.a(s4, s3), CommonUtils.a(new String[] {
                CommonUtils.m(context)
            }), s1, s, DeliveryMechanism.determineFrom(s5).getId(), s6), abi1, adr1, adp1, acy);
        }
        d = true;
        if (true) goto _L1; else goto _L3
_L3:
        aad1;
        throw aad1;
    }

    public Object a(adz adz1, Object obj)
    {
        aeb aeb1 = (aeb)a.get();
        if (aeb1 == null)
        {
            return obj;
        } else
        {
            return adz1.usingSettings(aeb1);
        }
    }

    public aeb b()
    {
        aeb aeb1;
        try
        {
            b.await();
            aeb1 = (aeb)a.get();
        }
        catch (InterruptedException interruptedexception)
        {
            zw.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
        return aeb1;
    }

    public boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        aeb aeb1;
        aeb1 = c.a();
        a(aeb1);
        boolean flag;
        if (aeb1 != null)
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
        aeb aeb1;
        aeb1 = c.a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        a(aeb1);
        if (aeb1 != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        zw.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        boolean flag;
        if (aeb1 != null)
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
