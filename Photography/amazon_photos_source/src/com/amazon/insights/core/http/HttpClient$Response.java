// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;


// Referenced classes of package com.amazon.insights.core.http:
//            HttpClient

public static interface 
{

    public abstract  addHeader(String s, String s1);

    public abstract int getCode();

    public abstract String getHeader(String s);

    public abstract String getMessage();

    public abstract  getOriginatingRequest();

    public abstract long getRequestSize();

    public abstract String getResponse();

    public abstract long getResponseSize();

    public abstract  setCode(int i);

    public abstract  setMessage(String s);

    public abstract  setOriginatingRequest( );

    public abstract  setRequestSize(long l);

    public abstract  setResponse(String s);

    public abstract  setResponseSize(long l);
}
