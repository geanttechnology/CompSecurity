// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import org.roboguice.shaded.goole.common.base.Function;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            MapMaker, ComputationException

static final class computingFunction extends computingFunction
{

    final Function computingFunction;

    private Object compute(Object obj)
    {
        Preconditions.checkNotNull(obj);
        try
        {
            obj = computingFunction.apply(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ComputationException(((Throwable) (obj)));
        }
        return obj;
    }

    public Object get(Object obj)
    {
        Object obj1 = compute(obj);
        Preconditions.checkNotNull(obj1, (new StringBuilder()).append(computingFunction).append(" returned null for key ").append(obj).append(".").toString());
        notifyRemoval(obj, obj1);
        return obj1;
    }

    (MapMaker mapmaker, Function function)
    {
        super(mapmaker);
        computingFunction = (Function)Preconditions.checkNotNull(function);
    }
}
