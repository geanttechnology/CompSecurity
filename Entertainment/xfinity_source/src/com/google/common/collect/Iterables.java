// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            Iterators

public final class Iterables
{
    static abstract class IterableWithToString
        implements Iterable
    {

        public String toString()
        {
            return Iterables.toString(this);
        }

        IterableWithToString()
        {
        }
    }


    public static String toString(Iterable iterable)
    {
        return Iterators.toString(iterable.iterator());
    }

    public static Iterable transform(Iterable iterable, Function function)
    {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new IterableWithToString(iterable, function) {

            final Iterable val$fromIterable;
            final Function val$function;

            public Iterator iterator()
            {
                return Iterators.transform(fromIterable.iterator(), function);
            }

            
            {
                fromIterable = iterable;
                function = function1;
                super();
            }
        };
    }
}
