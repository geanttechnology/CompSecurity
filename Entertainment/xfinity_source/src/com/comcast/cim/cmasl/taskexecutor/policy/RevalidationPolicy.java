// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.policy;


public interface RevalidationPolicy
{

    public abstract Object getCurrentVersion();

    public abstract boolean shouldFallBackToLastCached(Object obj);

    public abstract boolean shouldRevalidate(Object obj);
}
