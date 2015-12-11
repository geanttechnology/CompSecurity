// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.a.b:
//            bb

final class bc
    implements ThreadFactory
{

    bc()
    {
    }

    public final Thread newThread(Runnable runnable)
    {
        return new bb(runnable);
    }
}
