// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractFuture

private static final class executor
{

    static final executor TOMBSTONE = new <init>(null, null);
    final Executor executor;
    <init> next;
    final Runnable task;


    (Runnable runnable, Executor executor1)
    {
        task = runnable;
        executor = executor1;
    }
}
