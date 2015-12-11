// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import com.facebook.AppEventsLogger;
import com.facebook.RequestBatch;

// Referenced classes of package com.facebook.internal:
//            LikeActionController, Utility

class ishLikeRequestWrapper
    implements com.facebook.ller._cls6._cls1
{

    final l.analyticsParameters this$1;
    final ishLikeRequestWrapper val$likeRequest;

    public void onBatchCompleted(RequestBatch requestbatch)
    {
        LikeActionController.access$1502(_fld0, false);
        if (val$likeRequest.error != null)
        {
            LikeActionController.access$900(_fld0, false, LikeActionController.access$1600(_fld0), LikeActionController.access$1700(_fld0), LikeActionController.access$1800(_fld0), LikeActionController.access$1900(_fld0), LikeActionController.access$2000(_fld0));
            LikeActionController.access$2100(_fld0, activity, analyticsParameters);
            return;
        } else
        {
            LikeActionController.access$2002(_fld0, Utility.coerceValueIfNullOrEmpty(val$likeRequest.unlikeToken, null));
            LikeActionController.access$2202(_fld0, true);
            LikeActionController.access$800(_fld0).logSdkEvent("fb_like_control_did_like", null, analyticsParameters);
            LikeActionController.access$2300(_fld0, activity, analyticsParameters);
            return;
        }
    }

    ishLikeRequestWrapper()
    {
        this$1 = final_ishlikerequestwrapper;
        val$likeRequest = ishLikeRequestWrapper.this;
        super();
    }
}
