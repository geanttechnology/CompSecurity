// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import java.io.Serializable;

public interface IResult
{

    public abstract Serializable getData();

    public abstract int getError();

    public abstract Process getProcess();

    public abstract void onComplete(int i);

    public abstract void onFailure(Exception exception);

    public abstract void process(String s)
        throws Exception;

    public abstract void processError(String s)
        throws Exception;

    public abstract IResult setData(Serializable serializable);

    public abstract IResult setError(int i);

    public abstract IResult setProcess(Process process1);
}
