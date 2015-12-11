// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client;


// Referenced classes of package com.comcast.cim.httpcomponentsandroid.client:
//            RedirectException

public class CircularRedirectException extends RedirectException
{

    public CircularRedirectException()
    {
    }

    public CircularRedirectException(String s)
    {
        super(s);
    }
}
