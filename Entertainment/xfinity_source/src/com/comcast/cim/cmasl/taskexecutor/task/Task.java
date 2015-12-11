// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.task;


public interface Task
{

    public abstract void clearCachedResult();

    public abstract Object execute();

    public abstract Object getCachedResultIfAvailable();

    public abstract Object getSecondLevelStaleResultIfAvailable();

    public abstract Object getStaleResultIfAvailable();
}
