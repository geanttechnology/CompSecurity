// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            CountingMemoryCache

static class isOrphan
{

    public int clientCount;
    public boolean isOrphan;
    public final Object key;
    public final CloseableReference valueRef;

    static isOrphan of(Object obj, CloseableReference closeablereference)
    {
        return new <init>(obj, closeablereference);
    }

    private (Object obj, CloseableReference closeablereference)
    {
        key = Preconditions.checkNotNull(obj);
        valueRef = (CloseableReference)Preconditions.checkNotNull(CloseableReference.cloneOrNull(closeablereference));
        clientCount = 0;
        isOrphan = false;
    }
}
