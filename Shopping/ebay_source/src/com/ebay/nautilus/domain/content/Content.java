// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.kernel.content.ResultStatus;

public class Content
{

    private final Object _data;
    private final ResultStatus _resultStatus;

    public Content(ResultStatus resultstatus)
    {
        this(null, resultstatus);
    }

    public Content(Object obj)
    {
        this(obj, ResultStatus.SUCCESS);
    }

    public Content(Object obj, ResultStatus resultstatus)
    {
        if (resultstatus == null)
        {
            throw new IllegalArgumentException("Status must not be null!");
        } else
        {
            _data = obj;
            _resultStatus = resultstatus;
            return;
        }
    }

    public final Object getData()
    {
        return _data;
    }

    public final ResultStatus getStatus()
    {
        return _resultStatus;
    }

    public String toString()
    {
        return (new StringBuilder()).append("result status:").append(_resultStatus).toString();
    }
}
