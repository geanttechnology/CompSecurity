// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.squareup.okhttp:
//            Call, Callback, OkHttpClient, Dispatcher, 
//            Request

final class ttpEngine extends NamedRunnable
{

    private final boolean forWebSocket;
    private final Callback responseCallback;
    final Call this$0;

    void cancel()
    {
        Call.this.cancel();
    }

    protected void execute()
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        Response response = Call.access$100(Call.this, forWebSocket);
        flag = flag1;
        if (!canceled) goto _L2; else goto _L1
_L1:
        flag = true;
        responseCallback.onFailure(originalRequest, new IOException("Canceled"));
_L4:
        Call.access$300(Call.this).getDispatcher().finished(this);
        return;
_L2:
        flag = true;
        responseCallback.onResponse(response);
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        if (!flag) goto _L6; else goto _L5
_L5:
        Internal.logger.log(Level.INFO, (new StringBuilder()).append("Callback failure for ").append(Call.access$200(Call.this)).toString(), ((Throwable) (obj)));
_L8:
        Call.access$300(Call.this).getDispatcher().finished(this);
        return;
_L6:
        responseCallback.onFailure(engine.getRequest(), ((IOException) (obj)));
        if (true) goto _L8; else goto _L7
_L7:
        obj;
        Call.access$300(Call.this).getDispatcher().finished(this);
        throw obj;
    }

    Call get()
    {
        return Call.this;
    }

    String host()
    {
        return originalRequest.url().getHost();
    }

    Object tag()
    {
        return originalRequest.tag();
    }
}
