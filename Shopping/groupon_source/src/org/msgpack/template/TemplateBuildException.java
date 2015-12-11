// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;


public class TemplateBuildException extends RuntimeException
{

    public TemplateBuildException(String s)
    {
        super(s);
    }

    public TemplateBuildException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public TemplateBuildException(Throwable throwable)
    {
        super(throwable);
    }
}
