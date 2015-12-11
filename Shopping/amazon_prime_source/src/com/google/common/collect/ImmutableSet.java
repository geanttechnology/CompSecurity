// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ImmutableCollection, EmptyImmutableSet, SingletonImmutableSet, Sets, 
//            UnmodifiableIterator

public abstract class ImmutableSet extends ImmutableCollection
    implements Set
{

    ImmutableSet()
    {
    }

    public static ImmutableSet of()
    {
        return EmptyImmutableSet.INSTANCE;
    }

    public static ImmutableSet of(Object obj)
    {
        return new SingletonImmutableSet(obj);
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet)obj).isHashCodeFast() && hashCode() != obj.hashCode())
        {
            return false;
        } else
        {
            return Sets.equalsImpl(this, obj);
        }
    }

    public int hashCode()
    {
        return Sets.hashCodeImpl(this);
    }

    boolean isHashCodeFast()
    {
        return false;
    }

    public abstract UnmodifiableIterator iterator();

    public volatile Iterator iterator()
    {
        return iterator();
    }
}
