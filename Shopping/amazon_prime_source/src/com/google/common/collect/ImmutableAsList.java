// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            ImmutableList, ImmutableCollection

abstract class ImmutableAsList extends ImmutableList
{

    ImmutableAsList()
    {
    }

    public boolean contains(Object obj)
    {
        return delegateCollection().contains(obj);
    }

    abstract ImmutableCollection delegateCollection();

    public boolean isEmpty()
    {
        return delegateCollection().isEmpty();
    }

    boolean isPartialView()
    {
        return delegateCollection().isPartialView();
    }

    public int size()
    {
        return delegateCollection().size();
    }
}
