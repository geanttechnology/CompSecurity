// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.vungle.publisher.net.http;


// Referenced classes of package com.vungle.publisher.net.http:
//            MaxRetryAgeHttpResponseHandler

public class FireAndForgetHttpResponseHandler extends MaxRetryAgeHttpResponseHandler
{

    public FireAndForgetHttpResponseHandler()
    {
        super.i = 1;
        super.h = 10;
    }
}
