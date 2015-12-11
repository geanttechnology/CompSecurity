// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.callbacks.QandARequestCallback;
import com.groupon.http.Http;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.service:
//            QaDiscussionsService

class val.callback extends Http
{

    final QaDiscussionsService this$0;
    final QandARequestCallback val$callback;

    protected void onException(Exception exception)
    {
        super.onException(exception);
        if (val$callback != null)
        {
            val$callback.onException(exception);
        }
    }

    protected void onFinally()
    {
        super.onFinally();
        if (val$callback != null)
        {
            val$callback.onFinally();
        }
    }

    protected void onSuccess(com.groupon.models. )
        throws Exception
    {
        super.onSuccess();
        if (val$callback != null)
        {
            (new ArrayList()).addAll(.callback);
            val$callback.onPostsSuccess(.onPostsSuccess);
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((com.groupon.models..onSuccess)obj);
    }

    public void onUserCancelRetry()
    {
        super.onUserCancelRetry();
        if (val$callback != null)
        {
            val$callback.onCancel();
        }
    }

    protected boolean shouldRetry()
    {
        return true;
    }

    (Class class1, String s, QandARequestCallback qandarequestcallback)
    {
        this$0 = final_qadiscussionsservice;
        val$callback = qandarequestcallback;
        super(Context.this, class1, s);
    }
}
