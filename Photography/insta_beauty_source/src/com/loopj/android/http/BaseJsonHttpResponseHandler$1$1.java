// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


// Referenced classes of package com.loopj.android.http:
//            BaseJsonHttpResponseHandler

class val.jsonResponse
    implements Runnable
{

    final val.jsonResponse this$1;
    final Object val$jsonResponse;

    public void run()
    {
        onSuccess(statusCode, headers, responseString, val$jsonResponse);
    }

    ()
    {
        this$1 = final_;
        val$jsonResponse = Object.this;
        super();
    }
}
