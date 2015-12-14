// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


// Referenced classes of package com.loopj.android.http:
//            BaseJsonHttpResponseHandler

class val.t
    implements Runnable
{

    final l.responseString this$1;
    final Throwable val$t;

    public void run()
    {
        onFailure(statusCode, headers, val$t, responseString, null);
    }

    ()
    {
        this$1 = final_;
        val$t = Throwable.this;
        super();
    }
}
