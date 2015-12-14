// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.network:
//            ScribeRequestManager, BackoffPolicy

class val.volleyError
    implements Runnable
{

    final ScribeRequestManager this$0;
    final VolleyError val$volleyError;

    public void run()
    {
        try
        {
            mBackoffPolicy.backoff(val$volleyError);
            makeRequestInternal();
            return;
        }
        catch (VolleyError volleyerror)
        {
            MoPubLog.d((new StringBuilder()).append("Failed to Scribe events: ").append(val$volleyError).toString());
        }
        clearRequest();
    }

    ()
    {
        this$0 = final_scriberequestmanager;
        val$volleyError = VolleyError.this;
        super();
    }
}
