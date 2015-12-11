// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            bh

public final class af
{

    public static Object a(bh bh1)
    {
        int i = 1;
_L2:
        Object obj = bh1.call();
        return obj;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        if (i >= 10)
        {
            throw outofmemoryerror;
        }
        System.gc();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
