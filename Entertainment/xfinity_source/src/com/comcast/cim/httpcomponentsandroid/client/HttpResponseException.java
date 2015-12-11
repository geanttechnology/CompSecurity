// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client;


// Referenced classes of package com.comcast.cim.httpcomponentsandroid.client:
//            ClientProtocolException

public class HttpResponseException extends ClientProtocolException
{

    private final int statusCode;

    public int getStatusCode()
    {
        return statusCode;
    }
}
