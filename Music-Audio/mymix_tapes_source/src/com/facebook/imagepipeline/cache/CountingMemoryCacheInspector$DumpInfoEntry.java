// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            CountingMemoryCacheInspector

public static class value
{

    public final Object key;
    public final CloseableReference value;

    public void release()
    {
        CloseableReference.closeSafely(value);
    }

    public Q(Object obj, CloseableReference closeablereference)
    {
        key = Preconditions.checkNotNull(obj);
        value = CloseableReference.cloneOrNull(closeablereference);
    }
}
