// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.FrequencyCapType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            fu, az, gd

public final class ba
{

    private static final String a = com/flurry/sdk/ba.getSimpleName();
    private final fu b = new fu();

    public ba()
    {
    }

    public List a()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(b.d());
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public List a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = new ArrayList(b.a(s));
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void a(FrequencyCapType frequencycaptype, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (frequencycaptype == null) goto _L2; else goto _L1
_L1:
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        az az1;
        Iterator iterator = b.a(s).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_91;
            }
            az1 = (az)iterator.next();
        } while (!az1.b().equals(frequencycaptype));
        frequencycaptype = az1;
_L5:
        if (frequencycaptype == null) goto _L2; else goto _L4
_L4:
        b.b(s, frequencycaptype);
          goto _L2
        frequencycaptype;
        throw frequencycaptype;
        frequencycaptype = null;
          goto _L5
    }

    public void a(az az1)
    {
        this;
        JVM INSTR monitorenter ;
        if (az1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (az1.b() != null && !TextUtils.isEmpty(az1.c()))
        {
            a(az1.b(), az1.c());
            if (az1.g() != -1)
            {
                b.a(az1.c(), az1);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        az1;
        throw az1;
    }

    public boolean a(long l)
    {
        return l <= System.currentTimeMillis();
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = a().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            az az1 = (az)iterator.next();
            if (a(az1.e()))
            {
                gd.a(3, a, (new StringBuilder()).append("expiring freq cap for id: ").append(az1.c()).append(" capType:").append(az1.b()).append(" expiration: ").append(az1.e()).append(" epoch").append(System.currentTimeMillis()).toString());
                b(az1.c());
            }
        } while (true);
        break MISSING_BLOCK_LABEL_122;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        b.b(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}
