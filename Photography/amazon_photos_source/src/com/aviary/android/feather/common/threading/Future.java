// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.threading;


public interface Future
    extends java.util.concurrent.Future
{

    public abstract boolean cancel(boolean flag);

    public abstract Object get();

    public abstract Exception getException();

    public abstract boolean hasException();

    public abstract void setCancelListener(ThreadPool.CancelListener cancellistener);

    public abstract void waitDone();
}
