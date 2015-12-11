// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android;

import java.io.IOException;

public class PlayHavenException extends IOException
{

    private static final long serialVersionUID = 0x32c47c9df6375f36L;

    public PlayHavenException()
    {
    }

    public PlayHavenException(String s)
    {
        super(s);
    }

    public PlayHavenException(String s, Throwable throwable)
    {
        super(s);
        initCause(throwable);
    }

    public transient PlayHavenException(String s, Object aobj[])
    {
        this(String.format(s, aobj));
    }

    public PlayHavenException(Throwable throwable)
    {
        super(throwable.getMessage());
        initCause(throwable);
    }

    public transient PlayHavenException(Throwable throwable, String s, Object aobj[])
    {
        this(String.format(s, aobj), throwable);
    }
}
