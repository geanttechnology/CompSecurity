// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Multisets, Multiset, TransformedIterator

static abstract class init> extends Set
{

    public void clear()
    {
        multiset().clear();
    }

    public boolean contains(Object obj)
    {
        return multiset().contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        return multiset().containsAll(collection);
    }

    public boolean isEmpty()
    {
        return multiset().isEmpty();
    }

    public Iterator iterator()
    {
        return new TransformedIterator(multiset().entrySet().iterator()) {

            final Multisets.ElementSet this$0;

            volatile Object transform(Object obj)
            {
                return transform((Multiset.Entry)obj);
            }

            Object transform(Multiset.Entry entry)
            {
                return entry.getElement();
            }

            
            {
                this$0 = Multisets.ElementSet.this;
                super(iterator1);
            }
        };
    }

    abstract Multiset multiset();

    public boolean remove(Object obj)
    {
        int i = multiset().count(obj);
        if (i > 0)
        {
            multiset().remove(obj, i);
            return true;
        } else
        {
            return false;
        }
    }

    public int size()
    {
        return multiset().entrySet().size();
    }

    init>()
    {
    }
}
