// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.io.Serializable;
import org.roboguice.shaded.goole.common.base.Function;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            CacheLoader

private static final class computingFunction extends CacheLoader
    implements Serializable
{

    private final Function computingFunction;

    public Object load(Object obj)
    {
        return computingFunction.apply(Preconditions.checkNotNull(obj));
    }

    public (Function function)
    {
        computingFunction = (Function)Preconditions.checkNotNull(function);
    }
}
