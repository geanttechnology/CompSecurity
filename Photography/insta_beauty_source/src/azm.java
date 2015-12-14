// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public class azm
    implements InterstitialAdListener
{

    final FacebookAdapter a;

    private azm(FacebookAdapter facebookadapter)
    {
        a = facebookadapter;
        super();
    }

    public azm(FacebookAdapter facebookadapter, azm azm1)
    {
        this(facebookadapter);
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        FacebookAdapter.b(a).onAdLoaded(a);
    }

    public void onError(Ad ad, AdError aderror)
    {
        ad = aderror.getErrorMessage();
        if (!TextUtils.isEmpty(ad))
        {
            Log.w("FacebookAdapter", ad);
        }
        FacebookAdapter.b(a).onAdFailedToLoad(a, FacebookAdapter.a(a, aderror));
    }

    public void onInterstitialDismissed(Ad ad)
    {
        FacebookAdapter.b(a).onAdClosed(a);
    }

    public void onInterstitialDisplayed(Ad ad)
    {
        FacebookAdapter.b(a).onAdOpened(a);
    }
}
