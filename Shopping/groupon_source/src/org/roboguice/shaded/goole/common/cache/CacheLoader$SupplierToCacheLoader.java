// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.io.Serializable;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.base.Supplier;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            CacheLoader

private static final class computingSupplier extends CacheLoader
    implements Serializable
{

    private final Supplier computingSupplier;

    public Object load(Object obj)
    {
        Preconditions.checkNotNull(obj);
        return computingSupplier.get();
    }

    public (Supplier supplier)
    {
        computingSupplier = (Supplier)Preconditions.checkNotNull(supplier);
    }
}
