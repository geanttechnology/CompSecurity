// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.network.AdResponse;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.nativeads:
//            MoPubNative

class this._cls0
    implements com.mopub.network.ener
{

    final MoPubNative this$0;

    public void onErrorResponse(VolleyError volleyerror)
    {
        onAdError(volleyerror);
    }

    public void onSuccess(AdResponse adresponse)
    {
        MoPubNative.access$000(MoPubNative.this, adresponse);
    }

    er()
    {
        this$0 = MoPubNative.this;
        super();
    }
}
