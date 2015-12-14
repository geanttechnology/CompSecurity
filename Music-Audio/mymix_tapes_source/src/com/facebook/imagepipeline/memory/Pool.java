// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.ResourceReleaser;

public interface Pool
    extends ResourceReleaser, MemoryTrimmable
{

    public abstract Object get(int i);

    public abstract void release(Object obj);
}
