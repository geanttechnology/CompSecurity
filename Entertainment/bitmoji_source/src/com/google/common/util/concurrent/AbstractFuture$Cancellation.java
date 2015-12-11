// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractFuture

private static final class cause
{

    final Throwable cause;
    final boolean wasInterrupted;

    (boolean flag, Throwable throwable)
    {
        wasInterrupted = flag;
        cause = (Throwable)Preconditions.checkNotNull(throwable);
    }
}
