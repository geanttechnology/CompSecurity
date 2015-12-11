// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.amazon.mShop.util.LocaleUtils;

// Referenced classes of package com.amazon.mShop:
//            AmazonApplication

class this._cls0
    implements ComponentCallbacks
{

    final AmazonApplication this$0;

    public void onConfigurationChanged(Configuration configuration)
    {
        LocaleUtils.ensureConfigLocale(configuration);
        LocaleUtils.ensureAppLocale(AmazonApplication.this);
    }

    public void onLowMemory()
    {
    }

    ()
    {
        this$0 = AmazonApplication.this;
        super();
    }
}
