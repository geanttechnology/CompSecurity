// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http;


// Referenced classes of package org.apache.http:
//            Header

public interface HttpMessage
{

    public abstract void addHeader(String s, String s1);

    public abstract boolean containsHeader(String s);

    public abstract Header[] getAllHeaders();

    public abstract Header getFirstHeader(String s);

    public abstract Header[] getHeaders(String s);

    public abstract void removeHeaders(String s);

    public abstract void setHeader(String s, String s1);
}
