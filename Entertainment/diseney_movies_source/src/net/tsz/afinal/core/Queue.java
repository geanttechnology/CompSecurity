// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;

import java.util.Collection;

public interface Queue
    extends Collection
{

    public abstract boolean add(Object obj);

    public abstract Object element();

    public abstract boolean offer(Object obj);

    public abstract Object peek();

    public abstract Object poll();

    public abstract Object remove();
}
