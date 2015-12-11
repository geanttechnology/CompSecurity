// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;

import android.util.Log;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.analytics:
//            BitstripsAnalyticsService

class this._cls0
    implements Callback
{

    final BitstripsAnalyticsService this$0;

    public void failure(RetrofitError retrofiterror)
    {
        Log.d(BitstripsAnalyticsService.access$000(), (new StringBuilder()).append("problem!").append(retrofiterror).toString());
    }

    public volatile void success(Object obj, Response response)
    {
        success((Void)obj, response);
    }

    public void success(Void void1, Response response)
    {
        Log.d(BitstripsAnalyticsService.access$000(), (new StringBuilder()).append("success!").append(String.valueOf(response.getStatus())).toString());
    }

    ()
    {
        this$0 = BitstripsAnalyticsService.this;
        super();
    }
}
