// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.Context;
import android.content.res.Resources;

public class ParserException extends RuntimeException
{

    private static final long serialVersionUID = 0xea2c53d8d237f504L;

    public ParserException()
    {
    }

    public ParserException(Context context, int i)
    {
        super(context.getResources().getString(i));
    }

    public ParserException(Context context, int i, Exception exception)
    {
        super(context.getResources().getString(i), exception);
    }

    public ParserException(String s)
    {
        super(s);
    }

    public ParserException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public ParserException(Throwable throwable)
    {
        super(throwable);
    }
}
