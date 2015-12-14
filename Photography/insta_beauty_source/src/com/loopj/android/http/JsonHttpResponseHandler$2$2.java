// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.loopj.android.http:
//            JsonHttpResponseHandler

class val.ex
    implements Runnable
{

    final val.ex this$1;
    final JSONException val$ex;

    public void run()
    {
        onFailure(statusCode, headers, val$ex, (JSONObject)null);
    }

    ()
    {
        this$1 = final_;
        val$ex = JSONException.this;
        super();
    }
}
