// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;

public class azl
    implements AdListener
{

    final FacebookAdapter a;

    private azl(FacebookAdapter facebookadapter)
    {
        a = facebookadapter;
        super();
    }

    public azl(FacebookAdapter facebookadapter, azl azl1)
    {
        this(facebookadapter);
    }

    public void onAdClicked(Ad ad)
    {
        FacebookAdapter.a(a).onAdClicked(a);
        FacebookAdapter.a(a).onAdOpened(a);
    }

    public void onAdLoaded(Ad ad)
    {
        FacebookAdapter.a(a).onAdLoaded(a);
    }

    public void onError(Ad ad, AdError aderror)
    {
        ad = aderror.getErrorMessage();
        if (!TextUtils.isEmpty(ad))
        {
            Log.w("FacebookAdapter", ad);
        }
        FacebookAdapter.a(a).onAdFailedToLoad(a, FacebookAdapter.a(a, aderror));
    }
}
