// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;


// Referenced classes of package org.apache.commons.httpclient:
//            RedirectException

public class InvalidRedirectLocationException extends RedirectException
{

    private final String location;

    public InvalidRedirectLocationException(String s, String s1)
    {
        super(s);
        location = s1;
    }

    public InvalidRedirectLocationException(String s, String s1, Throwable throwable)
    {
        super(s, throwable);
        location = s1;
    }

    public String getLocation()
    {
        return location;
    }
}
