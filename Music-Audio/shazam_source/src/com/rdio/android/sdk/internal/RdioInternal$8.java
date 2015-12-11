// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.sdk.RdioApiCallback;
import com.rdio.android.sdk.RdioResponseListener;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.sdk.internal:
//            RdioInternal

class val.method
    implements RdioResponseListener
{

    final RdioInternal this$0;
    final RdioApiCallback val$callback;
    final String val$method;

    public void onResponse(RdioApiResponse rdioapiresponse)
    {
        if (rdioapiresponse.isSuccess())
        {
            rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
            val$callback.onApiSuccess(rdioapiresponse);
            return;
        } else
        {
            val$callback.onApiFailure(val$method, null);
            return;
        }
    }

    ()
    {
        this$0 = final_rdiointernal;
        val$callback = rdioapicallback;
        val$method = String.this;
        super();
    }
}
