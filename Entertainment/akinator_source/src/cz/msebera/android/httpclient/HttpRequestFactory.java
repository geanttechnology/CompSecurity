// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient;


// Referenced classes of package cz.msebera.android.httpclient:
//            MethodNotSupportedException, RequestLine, HttpRequest

public interface HttpRequestFactory
{

    public abstract HttpRequest newHttpRequest(RequestLine requestline)
        throws MethodNotSupportedException;

    public abstract HttpRequest newHttpRequest(String s, String s1)
        throws MethodNotSupportedException;
}
