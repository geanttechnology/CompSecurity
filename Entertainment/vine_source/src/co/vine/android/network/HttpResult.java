// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;


public class HttpResult
{

    public long durationMs;
    public int errorCode;
    public Exception exception;
    public final String reasonPhrase;
    public final int statusCode;
    public String uploadKey;

    public HttpResult(int i, String s)
    {
        statusCode = i;
        reasonPhrase = s;
    }
}
