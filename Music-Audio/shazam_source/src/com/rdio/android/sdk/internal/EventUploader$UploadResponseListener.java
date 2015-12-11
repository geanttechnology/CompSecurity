// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import android.util.Log;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.util.Logging;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.sdk.internal:
//            EventUploader

private class <init>
    implements com.rdio.android.core.istener
{

    public boolean isSuccess;
    final EventUploader this$0;

    public void onResponse(RdioApiResponse rdioapiresponse)
    {
        if (!rdioapiresponse.isSuccess())
        {
            break MISSING_BLOCK_LABEL_34;
        }
        rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
        if (!rdioapiresponse.has("success"))
        {
            break MISSING_BLOCK_LABEL_64;
        }
        isSuccess = rdioapiresponse.getBoolean("success");
        return;
        rdioapiresponse;
        EventUploader.access$000(EventUploader.this).logException(rdioapiresponse, true);
        isSuccess = false;
        Log.e("rdio", "Event upload failed to parse response");
        return;
        isSuccess = false;
        Log.e("rdio", "Event upload not successful");
        return;
    }

    private ()
    {
        this$0 = EventUploader.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
