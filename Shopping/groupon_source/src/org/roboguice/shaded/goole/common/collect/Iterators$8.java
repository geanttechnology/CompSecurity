// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Iterator;
import org.roboguice.shaded.goole.common.base.Function;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            TransformedIterator, Iterators

static final class terator extends TransformedIterator
{

    final Function val$function;

    Object transform(Object obj)
    {
        return val$function.apply(obj);
    }

    terator(Iterator iterator, Function function1)
    {
        val$function = function1;
        super(iterator);
    }
}
