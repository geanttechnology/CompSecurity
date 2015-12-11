// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayDeque;
import java.util.Iterator;

public final class ba
    implements Iterable
{

    private final ArrayDeque a = new ArrayDeque();
    private final int b = 99;

    public ba(int i)
    {
    }

    public final Iterator iterator()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator1 = a.clone().iterator();
        this;
        JVM INSTR monitorexit ;
        return iterator1;
        Exception exception;
        exception;
        throw exception;
    }
}
