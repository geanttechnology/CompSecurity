// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            Iterables

public final class Collections2
{

    static final Joiner STANDARD_JOINER = Joiner.on(", ");

    static Collection cast(Iterable iterable)
    {
        return (Collection)iterable;
    }

    static boolean containsAllImpl(Collection collection, Collection collection1)
    {
        Preconditions.checkNotNull(collection);
        for (collection1 = collection1.iterator(); collection1.hasNext();)
        {
            if (!collection.contains(collection1.next()))
            {
                return false;
            }
        }

        return true;
    }

    static StringBuilder newStringBuilderForCollection(int i)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "size must be non-negative");
        return new StringBuilder((int)Math.min((long)i * 8L, 0x40000000L));
    }

    static String toStringImpl(Collection collection)
    {
        StringBuilder stringbuilder = newStringBuilderForCollection(collection.size()).append('[');
        STANDARD_JOINER.appendTo(stringbuilder, Iterables.transform(collection, new Function(collection) {

            final Collection val$collection;

            public Object apply(Object obj)
            {
                Object obj1 = obj;
                if (obj == collection)
                {
                    obj1 = "(this Collection)";
                }
                return obj1;
            }

            
            {
                collection = collection1;
                super();
            }
        }));
        return stringbuilder.append(']').toString();
    }

}
