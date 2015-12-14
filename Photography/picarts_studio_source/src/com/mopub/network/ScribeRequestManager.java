// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.os.Handler;
import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.network:
//            RequestManager, BackoffPolicy

public class ScribeRequestManager extends RequestManager
    implements ScribeRequest.Listener
{

    public ScribeRequestManager(Looper looper)
    {
        super(looper);
    }

    Request createRequest()
    {
        return ((ScribeRequest.ScribeRequestFactory)mRequestFactory).createRequest(this);
    }

    public void onErrorResponse(final VolleyError volleyError)
    {
        mHandler.post(new Runnable() {

            final ScribeRequestManager this$0;
            final VolleyError val$volleyError;

            public void run()
            {
                try
                {
                    mBackoffPolicy.backoff(volleyError);
                    makeRequestInternal();
                    return;
                }
                catch (VolleyError volleyerror)
                {
                    MoPubLog.d((new StringBuilder("Failed to Scribe events: ")).append(volleyError).toString());
                }
                clearRequest();
            }

            
            {
                this$0 = ScribeRequestManager.this;
                volleyError = volleyerror;
                super();
            }
        });
    }

    public void onResponse()
    {
        MoPubLog.d("Successfully scribed events");
        mHandler.post(new Runnable() {

            final ScribeRequestManager this$0;

            public void run()
            {
                clearRequest();
            }

            
            {
                this$0 = ScribeRequestManager.this;
                super();
            }
        });
    }
}
