// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.b;


// Referenced classes of package com.gimbal.internal.proximity.core.b:
//            a

public final class b extends RuntimeException
{

    public a a;

    public b(a a1)
    {
        super(a1.e);
        a = a1;
    }

    public b(a a1, Throwable throwable)
    {
        super(a1.e, throwable);
        a = a1;
    }
}
