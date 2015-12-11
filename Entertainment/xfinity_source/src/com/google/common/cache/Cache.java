// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import com.google.common.base.Function;
import java.util.concurrent.ConcurrentMap;

public interface Cache
    extends Function
{

    public abstract Object apply(Object obj);

    public abstract ConcurrentMap asMap();

    public abstract Object getUnchecked(Object obj);
}
