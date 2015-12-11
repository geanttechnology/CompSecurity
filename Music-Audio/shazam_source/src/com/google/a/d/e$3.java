// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.d;


// Referenced classes of package com.google.a.d:
//            e

final class al extends ThreadLocal
{

    final e a;

    protected final Object initialValue()
    {
        return Boolean.valueOf(false);
    }

    al(e e1)
    {
        a = e1;
        super();
    }
}
