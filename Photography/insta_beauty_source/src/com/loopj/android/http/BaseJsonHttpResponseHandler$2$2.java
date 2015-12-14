// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


// Referenced classes of package com.loopj.android.http:
//            BaseJsonHttpResponseHandler

class this._cls1
    implements Runnable
{

    final l.responseString this$1;

    public void run()
    {
        onFailure(statusCode, headers, throwable, responseString, null);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
