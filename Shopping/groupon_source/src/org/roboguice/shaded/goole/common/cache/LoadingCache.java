// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.util.concurrent.ConcurrentMap;
import org.roboguice.shaded.goole.common.base.Function;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            Cache

public interface LoadingCache
    extends Function, Cache
{

    public abstract ConcurrentMap asMap();

    public abstract Object getUnchecked(Object obj);
}
