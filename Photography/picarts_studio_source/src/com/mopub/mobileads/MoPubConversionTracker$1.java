// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.SharedPreferences;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.mobileads:
//            MoPubConversionTracker

class this._cls0
    implements com.mopub.network._cls1
{

    final MoPubConversionTracker this$0;

    public void onErrorResponse(VolleyError volleyerror)
    {
    }

    public void onResponse(String s)
    {
        MoPubConversionTracker.access$200(MoPubConversionTracker.this).edit().putBoolean(MoPubConversionTracker.access$100(MoPubConversionTracker.this), true).commit();
    }

    ()
    {
        this$0 = MoPubConversionTracker.this;
        super();
    }
}
