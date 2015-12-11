// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ads;

import com.google.android.gms.ads.AdListener;

// Referenced classes of package com.ebay.mobile.ads:
//            NativeAdLoader

static final class innerListener extends AdListener
{

    private final AdListener innerListener;

    public void onAdFailedToLoad(int i)
    {
        if (innerListener != null)
        {
            innerListener.onAdFailedToLoad(i);
        }
    }

    public void onAdOpened()
    {
        if (innerListener != null)
        {
            innerListener.onAdOpened();
        }
    }

    (AdListener adlistener)
    {
        innerListener = adlistener;
    }
}
