// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import org.roboguice.shaded.goole.common.base.Function;
import org.roboguice.shaded.goole.common.base.Throwables;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ComputingConcurrentHashMap, MapMaker, ComputationException

static final class nit> extends ComputingConcurrentHashMap
    implements Serializable
{

    public Object get(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = getOrCompute(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = ((ExecutionException) (obj)).getCause();
            Throwables.propagateIfInstanceOf(((Throwable) (obj)), org/roboguice/shaded/goole/common/collect/ComputationException);
            throw new ComputationException(((Throwable) (obj)));
        }
        if (obj1 == null)
        {
            throw new NullPointerException((new StringBuilder()).append(computingFunction).append(" returned null for key ").append(obj).append(".").toString());
        } else
        {
            return obj1;
        }
    }

    (MapMaker mapmaker, Function function)
    {
        super(mapmaker, function);
    }
}
