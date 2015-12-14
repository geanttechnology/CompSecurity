// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;


public interface CrashDescriptorStorageUtil
{

    public abstract boolean contains(String s);

    public abstract Integer getCount(String s);

    public abstract void persistCrashDescriptors();

    public abstract Integer prune(String s);

    public abstract void push(String s);

    public abstract Boolean shouldDedupe(String s);
}
