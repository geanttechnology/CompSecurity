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

public class bxk
{

    private final AtomicReference a;
    private final CountDownLatch b;
    private bxo c;
    private boolean d;

    private bxk()
    {
        a = new AtomicReference();
        b = new CountDownLatch(1);
        d = false;
    }

    bxk(bxl bxl)
    {
        this();
    }

    public static bxk a()
    {
        return bxm.a();
    }

    private void a(bxp bxp1)
    {
        a.set(bxp1);
        b.countDown();
    }

    public bxk a(bsy bsy1, IdManager idmanager, bwl bwl, String s, String s1, String s2)
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
            android.content.Context context = bsy1.getContext();
            String s3 = idmanager.c();
            String s4 = (new btr()).a(context);
            String s5 = idmanager.h();
            bul bul1 = new bul();
            bxe bxe1 = new bxe();
            bxc bxc1 = new bxc(bsy1);
            String s6 = CommonUtils.k(context);
            bwl = new bxf(bsy1, s2, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[] {
                s3
            }), bwl);
            c = new bxd(bsy1, new bxs(s4, idmanager.a(s4, s3), CommonUtils.a(new String[] {
                CommonUtils.m(context)
            }), s1, s, DeliveryMechanism.determineFrom(s5).getId(), s6), bul1, bxe1, bxc1, bwl);
        }
        d = true;
        if (true) goto _L1; else goto _L3
_L3:
        bsy1;
        throw bsy1;
    }

    public Object a(bxn bxn1, Object obj)
    {
        bxp bxp1 = (bxp)a.get();
        if (bxp1 == null)
        {
            return obj;
        } else
        {
            return bxn1.usingSettings(bxp1);
        }
    }

    public bxp b()
    {
        bxp bxp1;
        try
        {
            b.await();
            bxp1 = (bxp)a.get();
        }
        catch (InterruptedException interruptedexception)
        {
            bso.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
        return bxp1;
    }

    public boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        bxp bxp1;
        bxp1 = c.a();
        a(bxp1);
        boolean flag;
        if (bxp1 != null)
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
        bxp bxp1;
        bxp1 = c.a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        a(bxp1);
        if (bxp1 != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        bso.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        boolean flag;
        if (bxp1 != null)
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
