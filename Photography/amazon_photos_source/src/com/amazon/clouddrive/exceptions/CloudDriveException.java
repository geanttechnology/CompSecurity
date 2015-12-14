// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.exceptions;


public class CloudDriveException extends Exception
{

    private String mCode;
    private String mLogref;

    public CloudDriveException()
    {
    }

    public CloudDriveException(String s)
    {
        super(s);
    }

    public CloudDriveException(String s, String s1, String s2)
    {
        super(s);
        mCode = s1;
        mLogref = s2;
    }

    public CloudDriveException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public String getCode()
    {
        return mCode;
    }

    public String getMessage()
    {
        return super.getMessage();
    }
}
