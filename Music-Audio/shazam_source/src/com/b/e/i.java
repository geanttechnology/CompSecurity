// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;

import com.b.a.b;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class i extends ConcurrentLinkedQueue
{

    private b a;

    public i(b b1)
    {
        a = b1;
    }

    public final boolean offer(Object obj)
    {
        obj = (Runnable)obj;
        return a.f.a(((Runnable) (obj)), true);
    }
}
