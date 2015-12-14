// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.network.AdResponse;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.mobileads:
//            AdViewController

class this._cls0
    implements com.mopub.network._cls1
{

    final AdViewController this$0;

    public void onErrorResponse(VolleyError volleyerror)
    {
        onAdLoadError(volleyerror);
    }

    public void onSuccess(AdResponse adresponse)
    {
        onAdLoadSuccess(adresponse);
    }

    ()
    {
        this$0 = AdViewController.this;
        super();
    }
}
