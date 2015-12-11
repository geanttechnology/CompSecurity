// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import com.target.a.a.b;

// Referenced classes of package com.target.ui.fragment.cardstream.c:
//            d

static final class r
    implements ad.UncaughtExceptionHandler
{

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        b.a("ExecutorProvider", (new StringBuilder()).append("Uncaught exception in thread '").append(thread.getName()).toString(), throwable);
    }

    r()
    {
    }
}
