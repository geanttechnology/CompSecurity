// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.nativeads:
//            ServerPositioningSource

class this._cls0
    implements com.mopub.volley.._cls3
{

    final ServerPositioningSource this$0;

    public void onErrorResponse(VolleyError volleyerror)
    {
        if (!(volleyerror instanceof MoPubNetworkError) || ((MoPubNetworkError)volleyerror).getReason().quals(com.mopub.network.ARMING_UP))
        {
            MoPubLog.e("Failed to load positioning data", volleyerror);
            if (volleyerror.networkResponse == null && !DeviceUtils.isNetworkAvailable(ServerPositioningSource.access$200(ServerPositioningSource.this)))
            {
                MoPubLog.c(String.valueOf(MoPubErrorCode.NO_CONNECTION.toString()));
            }
        }
        ServerPositioningSource.access$300(ServerPositioningSource.this);
    }

    ()
    {
        this$0 = ServerPositioningSource.this;
        super();
    }
}
