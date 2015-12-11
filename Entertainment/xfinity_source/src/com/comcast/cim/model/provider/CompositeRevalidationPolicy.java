// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.provider;

import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.utils.container.Tuple;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CompositeRevalidationPolicy
    implements RevalidationPolicy
{

    private final RevalidationPolicy xPolicy;
    private final RevalidationPolicy yPolicy;

    public CompositeRevalidationPolicy(RevalidationPolicy revalidationpolicy, RevalidationPolicy revalidationpolicy1)
    {
        xPolicy = revalidationpolicy;
        yPolicy = revalidationpolicy1;
    }

    private Tuple getNullSafeVersion(Tuple tuple)
    {
        Tuple tuple1 = tuple;
        if (tuple == null)
        {
            tuple1 = new Tuple(null, null);
        }
        return tuple1;
    }

    public Tuple getCurrentVersion()
    {
        return new Tuple(xPolicy.getCurrentVersion(), yPolicy.getCurrentVersion());
    }

    public volatile Object getCurrentVersion()
    {
        return getCurrentVersion();
    }

    public boolean shouldFallBackToLastCached(Tuple tuple)
    {
        tuple = getNullSafeVersion(tuple);
        return xPolicy.shouldFallBackToLastCached(tuple.e1) && yPolicy.shouldFallBackToLastCached(tuple.e2);
    }

    public volatile boolean shouldFallBackToLastCached(Object obj)
    {
        return shouldFallBackToLastCached((Tuple)obj);
    }

    public boolean shouldRevalidate(Tuple tuple)
    {
        tuple = getNullSafeVersion(tuple);
        return xPolicy.shouldRevalidate(tuple.e1) || yPolicy.shouldRevalidate(tuple.e2);
    }

    public volatile boolean shouldRevalidate(Object obj)
    {
        return shouldRevalidate((Tuple)obj);
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append(xPolicy).append(yPolicy).toString();
    }
}
