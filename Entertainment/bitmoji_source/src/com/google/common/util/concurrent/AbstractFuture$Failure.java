// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractFuture

private static final class exception
{

    static final exception FALLBACK_INSTANCE = new <init>(new Throwable("Failure occurred while trying to finish a future.") {

        public Throwable fillInStackTrace()
        {
            this;
            JVM INSTR monitorenter ;
            return this;
        }

    });
    final Throwable exception;


    _cls1(Throwable throwable)
    {
        exception = (Throwable)Preconditions.checkNotNull(throwable);
    }
}
