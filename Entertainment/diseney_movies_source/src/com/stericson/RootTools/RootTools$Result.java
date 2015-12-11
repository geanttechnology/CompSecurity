// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import java.io.Serializable;

// Referenced classes of package com.stericson.RootTools:
//            IResult, RootTools

public static abstract class error
    implements IResult
{

    private Serializable data;
    private int error;
    private Process process;

    public Serializable getData()
    {
        return data;
    }

    public int getError()
    {
        return error;
    }

    public Process getProcess()
    {
        return process;
    }

    public abstract void onComplete(int i);

    public abstract void onFailure(Exception exception);

    public abstract void process(String s)
        throws Exception;

    public abstract void processError(String s)
        throws Exception;

    public volatile IResult setData(Serializable serializable)
    {
        return setData(serializable);
    }

    public setData setData(Serializable serializable)
    {
        data = serializable;
        return this;
    }

    public volatile IResult setError(int i)
    {
        return setError(i);
    }

    public setError setError(int i)
    {
        error = i;
        return this;
    }

    public volatile IResult setProcess(Process process1)
    {
        return setProcess(process1);
    }

    public setProcess setProcess(Process process1)
    {
        process = process1;
        return this;
    }

    public ()
    {
        process = null;
        data = null;
        error = 0;
    }
}
