// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;

public interface ExecutorSupplier
{

    public abstract Executor forBackgroundTasks();

    public abstract Executor forDecode();

    public abstract Executor forLightweightBackgroundTasks();

    public abstract Executor forLocalStorageRead();

    public abstract Executor forLocalStorageWrite();
}
