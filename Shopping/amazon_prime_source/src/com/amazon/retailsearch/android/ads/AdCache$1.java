// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ads;

import java.util.Queue;

// Referenced classes of package com.amazon.retailsearch.android.ads:
//            AdCache, AdView

class this._cls0
    implements iewListener
{

    final AdCache this$0;

    public void onAdFailedToLoad(AdView adview)
    {
        AdCache.access$100(AdCache.this).offer(adview);
    }

    public void onAdLoaded(AdView adview)
    {
        AdCache.access$000(AdCache.this).offer(adview);
    }

    iewListener()
    {
        this$0 = AdCache.this;
        super();
    }
}
