// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;

class hf
    implements AdListener
{

    final NativeAd a;
    final he b;

    hf(he he1, NativeAd nativead)
    {
        b = he1;
        a = nativead;
        super();
    }

    public void onAdClicked(Ad ad)
    {
        if (b.a != null)
        {
            (new Handler(b.a.getMainLooper())).post(new hg(this));
        }
    }

    public void onAdLoaded(Ad ad)
    {
        if (b.a != null)
        {
            (new Handler(b.a.getMainLooper())).post(new hh(this, ad));
        }
    }

    public void onError(Ad ad, AdError aderror)
    {
        if (b.a != null)
        {
            (new Handler(b.a.getMainLooper())).post(new hi(this));
        }
    }
}
