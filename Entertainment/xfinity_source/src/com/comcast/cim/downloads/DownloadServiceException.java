// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;


public class DownloadServiceException extends Exception
{

    public DownloadServiceException()
    {
    }

    public DownloadServiceException(String s)
    {
        super(s);
    }

    public DownloadServiceException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public DownloadServiceException(Throwable throwable)
    {
        super(throwable);
    }
}
