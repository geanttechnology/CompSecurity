// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.FrequencyCapResponseInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            b, ap, bb, aw

public class bc
{

    private static final String a = com/flurry/sdk/bc.getSimpleName();
    private final HashMap b = new HashMap();

    public bc()
    {
    }

    public List a()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(b.values());
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(b b1)
    {
        this;
        JVM INSTR monitorenter ;
        if (b1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        FrequencyCapResponseInfo frequencycapresponseinfo = b1.c().f();
        if (frequencycapresponseinfo == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        bb bb2;
        String s;
        s = frequencycapresponseinfo.id;
        if (TextUtils.isEmpty(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        bb2 = (bb)b.get(s);
        bb bb1;
        bb1 = bb2;
        if (bb2 != null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        bb1 = new bb(s, frequencycapresponseinfo.streamCapDurationMillis);
        b.put(s, bb1);
        bb1.a(b1.a.a());
        bb1.b(System.currentTimeMillis());
        if (aw.f.equals(b1.a))
        {
            bb1.a(System.currentTimeMillis());
        }
        bb1.b(b1.a.a());
        if (true) goto _L1; else goto _L3
_L3:
        b1;
        throw b1;
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
            bb bb1 = (bb)iterator.next();
            if (System.currentTimeMillis() > bb1.d() + bb1.b())
            {
                b.remove(bb1.a());
            }
        } while (true);
        break MISSING_BLOCK_LABEL_67;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

}
