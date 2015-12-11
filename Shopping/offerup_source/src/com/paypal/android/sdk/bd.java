// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.Context;
import android.util.Log;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.paypal.android.sdk:
//            z, a, af, ce

public final class bd
{

    private static z a;

    public bd()
    {
    }

    static z a()
    {
        return a;
    }

    public static final String a(ExecutorService executorservice, Context context, a a1, String s)
    {
        com/paypal/android/sdk/bd;
        JVM INSTR monitorenter ;
        z z1 = a;
        if (z1 != null) goto _L2; else goto _L1
_L1:
        z z2 = z.a();
        a = z2;
        context = z2.a(context, a1.e(), af.b, s, Collections.emptyMap());
        executorservice.submit(new ce());
        (new StringBuilder("Init risk component: ")).append(z.c()).append(" returning new clientMetadataId:").append(context);
        executorservice = context;
_L4:
        com/paypal/android/sdk/bd;
        JVM INSTR monitorexit ;
        return executorservice;
        executorservice;
        Log.e("paypal.sdk", (new StringBuilder("An internal component failed to initialize: ")).append(executorservice.getMessage()).toString());
        executorservice = null;
        continue; /* Loop/switch isn't completed */
_L2:
        executorservice = a.f();
        if (true) goto _L4; else goto _L3
_L3:
        executorservice;
        throw executorservice;
    }

    static 
    {
        com/paypal/android/sdk/bd.getSimpleName();
    }
}
