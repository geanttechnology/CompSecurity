// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            cv

public final class cx
{

    public static RuntimeException a(Throwable throwable)
    {
        Throwable throwable1 = (Throwable)cv.a(throwable);
        a(throwable1, java/lang/Error);
        a(throwable1, java/lang/RuntimeException);
        throw new RuntimeException(throwable);
    }

    private static void a(Throwable throwable, Class class1)
    {
        if (throwable != null && class1.isInstance(throwable))
        {
            throw (Throwable)class1.cast(throwable);
        } else
        {
            return;
        }
    }
}
