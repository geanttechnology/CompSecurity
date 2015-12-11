// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import java.util.Set;

public interface InstanceTracker
{

    public abstract Set getTrackedInstances();

    public abstract boolean isTimedOut(Object obj);

    public abstract boolean stopTrackingInstance(Object obj);
}
