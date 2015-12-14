// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.references.CloseableReference;

public interface MemoryCache
{

    public abstract CloseableReference cache(Object obj, CloseableReference closeablereference);

    public abstract CloseableReference get(Object obj);

    public abstract int removeAll(Predicate predicate);
}
