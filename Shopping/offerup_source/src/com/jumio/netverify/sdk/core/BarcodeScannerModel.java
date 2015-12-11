// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.core;

import jumiomobile.ga;
import jumiomobile.ge;
import jumiomobile.gi;
import jumiomobile.hg;
import jumiomobile.hh;

// Referenced classes of package com.jumio.netverify.sdk.core:
//            ModelTemplate

public final class BarcodeScannerModel extends ModelTemplate
{

    public static final android.os.Parcelable.Creator CREATOR = new hg();
    private static BarcodeScannerModel Q;

    private BarcodeScannerModel()
    {
    }

    public BarcodeScannerModel(hg hg1)
    {
        this();
    }

    public static BarcodeScannerModel a(BarcodeScannerModel barcodescannermodel)
    {
        Q = barcodescannermodel;
        return barcodescannermodel;
    }

    public static BarcodeScannerModel a(Object obj)
    {
        com/jumio/netverify/sdk/core/BarcodeScannerModel;
        JVM INSTR monitorenter ;
        if (!(obj instanceof gi) && !(obj instanceof ge) && !(obj instanceof ga)) goto _L2; else goto _L1
_L1:
        if (Q == null)
        {
            Q = new BarcodeScannerModel();
        }
        obj = Q;
_L4:
        com/jumio/netverify/sdk/core/BarcodeScannerModel;
        JVM INSTR monitorexit ;
        return ((BarcodeScannerModel) (obj));
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public static void a()
    {
        com/jumio/netverify/sdk/core/BarcodeScannerModel;
        JVM INSTR monitorenter ;
        BarcodeScannerModel barcodescannermodel = Q;
        if (barcodescannermodel != null) goto _L2; else goto _L1
_L1:
        com/jumio/netverify/sdk/core/BarcodeScannerModel;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (Q.b != null)
        {
            Q.b.e();
        }
        Q.c();
        Q = null;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static BarcodeScannerModel b()
    {
        return Q;
    }

}
