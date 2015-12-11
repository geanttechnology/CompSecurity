// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.io.Serializable;
import org.roboguice.shaded.goole.common.base.Function;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Ordering

final class ByFunctionOrdering extends Ordering
    implements Serializable
{

    final Function function;
    final Ordering ordering;

    ByFunctionOrdering(Function function1, Ordering ordering1)
    {
        function = (Function)Preconditions.checkNotNull(function1);
        ordering = (Ordering)Preconditions.checkNotNull(ordering1);
    }

    public int compare(Object obj, Object obj1)
    {
        return ordering.compare(function.apply(obj), function.apply(obj1));
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof ByFunctionOrdering)
            {
                if (!function.equals(((ByFunctionOrdering) (obj = (ByFunctionOrdering)obj)).function) || !ordering.equals(((ByFunctionOrdering) (obj)).ordering))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            function, ordering
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append(ordering).append(".onResultOf(").append(function).append(")").toString();
    }
}
