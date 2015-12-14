// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.network.AdResponse;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.mobileads:
//            MoPubRewardedVideoManager

public class mVideoManager
    implements com.mopub.network.r
{

    public final String adUnitId;
    private final MoPubRewardedVideoManager mVideoManager;

    public void onErrorResponse(VolleyError volleyerror)
    {
        MoPubRewardedVideoManager.access$100(mVideoManager, volleyerror, adUnitId);
    }

    public void onSuccess(AdResponse adresponse)
    {
        MoPubRewardedVideoManager.access$000(mVideoManager, adresponse, adUnitId);
    }

    public (MoPubRewardedVideoManager mopubrewardedvideomanager, String s)
    {
        adUnitId = s;
        mVideoManager = mopubrewardedvideomanager;
    }
}
