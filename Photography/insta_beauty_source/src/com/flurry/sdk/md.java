// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            je, ki, hl, mb, 
//            i, kg

public class md
{

    private static final String a = com/flurry/sdk/md.getSimpleName();
    private static boolean b;

    public md()
    {
    }

    public static void a()
    {
        com/flurry/sdk/md;
        JVM INSTR monitorenter ;
        boolean flag = b;
        if (!flag) goto _L2; else goto _L1
_L1:
        com/flurry/sdk/md;
        JVM INSTR monitorexit ;
        return;
_L2:
        ki.a(com/flurry/sdk/je, 10);
        ki.a(com/flurry/sdk/hl, 10);
_L3:
        ki.a(com/flurry/sdk/mb, 10);
_L4:
        ki.a(com/flurry/sdk/i, 10);
_L5:
        b = true;
          goto _L1
        Object obj;
        obj;
        throw obj;
        obj;
        kg.a(3, a, "Analytics module not available");
          goto _L3
        obj;
        kg.a(3, a, "Crash module not available");
          goto _L4
        obj;
        kg.a(3, a, "Ads module not available");
          goto _L5
    }

}
