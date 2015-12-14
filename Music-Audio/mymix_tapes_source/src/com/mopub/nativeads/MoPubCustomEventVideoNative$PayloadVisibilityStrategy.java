// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import com.mopub.network.TrackingRequest;

// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative

static class mUrl
    implements dStrategy
{

    private final Context mContext;
    private final String mUrl;

    public void execute()
    {
        TrackingRequest.makeTrackingHttpRequest(mUrl, mContext);
    }

    dStrategy(Context context, String s)
    {
        mContext = context.getApplicationContext();
        mUrl = s;
    }
}
