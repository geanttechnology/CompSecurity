// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.math;


// Referenced classes of package com.google.common.math:
//            LongMath

static final class nit> extends nit>
{

    long mulMod(long l, long l1, long l2)
    {
        return (l * l1) % l2;
    }

    long squareMod(long l, long l1)
    {
        return (l * l) % l1;
    }

    _cls9(String s, int i)
    {
        super(s, i, null);
    }
}
