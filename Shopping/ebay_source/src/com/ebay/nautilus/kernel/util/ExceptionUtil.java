// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import java.io.InterruptedIOException;

public class ExceptionUtil
{

    public ExceptionUtil()
    {
    }

    public static InterruptedException convertToInterruptedException(Exception exception)
    {
        if (exception instanceof InterruptedException)
        {
            return (InterruptedException)exception;
        }
        if (isInterruptedException(exception))
        {
            Object obj = exception.getLocalizedMessage();
            if (obj == null)
            {
                obj = new InterruptedException();
            } else
            {
                obj = new InterruptedException(((String) (obj)));
            }
            ((InterruptedException) (obj)).initCause(exception);
            return ((InterruptedException) (obj));
        } else
        {
            return null;
        }
    }

    public static boolean isInterruptedException(Exception exception)
    {
        return exception != null && exception.getClass() == java/io/InterruptedIOException || (exception instanceof InterruptedException);
    }
}
