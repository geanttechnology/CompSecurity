// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import java.util.concurrent.Executor;

// Referenced classes of package com.google.a.g.a:
//            e

private static final class c
{

    final Runnable a;
    final Executor b;
    Executor c;

    Executor(Runnable runnable, Executor executor, Executor executor1)
    {
        a = runnable;
        b = executor;
        c = executor1;
    }
}
