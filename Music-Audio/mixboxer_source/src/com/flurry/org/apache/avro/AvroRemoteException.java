// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import java.io.IOException;

public class AvroRemoteException extends IOException
{

    private Object value;

    protected AvroRemoteException()
    {
    }

    public AvroRemoteException(Object obj)
    {
        String s;
        if (obj != null)
        {
            s = obj.toString();
        } else
        {
            s = null;
        }
        super(s);
        value = obj;
    }

    public AvroRemoteException(Object obj, Throwable throwable)
    {
        String s;
        if (obj != null)
        {
            s = obj.toString();
        } else
        {
            s = null;
        }
        super(s, throwable);
        value = obj;
    }

    public AvroRemoteException(Throwable throwable)
    {
        this(throwable.toString());
        initCause(throwable);
    }

    public Object getValue()
    {
        return value;
    }
}
