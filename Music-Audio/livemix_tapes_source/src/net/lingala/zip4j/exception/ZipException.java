// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.exception;


public class ZipException extends Exception
{

    private static final long serialVersionUID = 1L;
    private int code;

    public ZipException()
    {
        code = -1;
    }

    public ZipException(String s)
    {
        super(s);
        code = -1;
    }

    public ZipException(String s, int i)
    {
        super(s);
        code = -1;
        code = i;
    }

    public ZipException(String s, Throwable throwable)
    {
        super(s, throwable);
        code = -1;
    }

    public ZipException(String s, Throwable throwable, int i)
    {
        super(s, throwable);
        code = -1;
        code = i;
    }

    public ZipException(Throwable throwable)
    {
        super(throwable);
        code = -1;
    }

    public ZipException(Throwable throwable, int i)
    {
        super(throwable);
        code = -1;
        code = i;
    }

    public int getCode()
    {
        return code;
    }
}
