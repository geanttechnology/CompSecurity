// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;


class Exceptions
{
    static class UnhandledCheckedUserException extends RuntimeException
    {

        public UnhandledCheckedUserException(Throwable throwable)
        {
            super(throwable);
        }
    }


    Exceptions()
    {
    }

    public static RuntimeException rethrow(Throwable throwable)
    {
        if (throwable instanceof RuntimeException)
        {
            throw (RuntimeException)throwable;
        }
        if (throwable instanceof Error)
        {
            throw (Error)throwable;
        } else
        {
            throw new UnhandledCheckedUserException(throwable);
        }
    }

    public static RuntimeException rethrowCause(Throwable throwable)
    {
        Throwable throwable1 = throwable;
        if (throwable.getCause() != null)
        {
            throwable1 = throwable.getCause();
        }
        return rethrow(throwable1);
    }
}
