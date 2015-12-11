// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.mediation.zzb;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            kr

public abstract class ki
    implements MediationBannerAdapter, MediationInterstitialAdapter, zza
{
    static class a extends NativeAppInstallAdMapper
    {

        private final NativeAppInstallAd a;

        public void trackView(View view)
        {
            if (view instanceof NativeAdView)
            {
                ((NativeAdView)view).setNativeAd(a);
            }
        }

        public a(NativeAppInstallAd nativeappinstallad)
        {
            a = nativeappinstallad;
            setHeadline(nativeappinstallad.getHeadline().toString());
            setImages(nativeappinstallad.getImages());
            setBody(nativeappinstallad.getBody().toString());
            setIcon(nativeappinstallad.getIcon());
            setCallToAction(nativeappinstallad.getCallToAction().toString());
            setStarRating(nativeappinstallad.getStarRating().doubleValue());
            setStore(nativeappinstallad.getStore().toString());
            setPrice(nativeappinstallad.getPrice().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }
    }

    static class b extends NativeContentAdMapper
    {

        private final NativeContentAd a;

        public void trackView(View view)
        {
            if (view instanceof NativeAdView)
            {
                ((NativeAdView)view).setNativeAd(a);
            }
        }

        public b(NativeContentAd nativecontentad)
        {
            a = nativecontentad;
            setHeadline(nativecontentad.getHeadline().toString());
            setImages(nativecontentad.getImages());
            setBody(nativecontentad.getBody().toString());
            setLogo(nativecontentad.getLogo());
            setCallToAction(nativecontentad.getCallToAction().toString());
            setAdvertiser(nativecontentad.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }
    }

    static final class c extends AdListener
        implements com.google.android.gms.ads.internal.client.zza
    {

        final ki a;
        final MediationBannerListener b;

        public void onAdClicked()
        {
            b.onAdClicked(a);
        }

        public void onAdClosed()
        {
            b.onAdClosed(a);
        }

        public void onAdFailedToLoad(int i)
        {
            b.onAdFailedToLoad(a, i);
        }

        public void onAdLeftApplication()
        {
            b.onAdLeftApplication(a);
        }

        public void onAdLoaded()
        {
            b.onAdLoaded(a);
        }

        public void onAdOpened()
        {
            b.onAdOpened(a);
        }

        public c(ki ki1, MediationBannerListener mediationbannerlistener)
        {
            a = ki1;
            b = mediationbannerlistener;
        }
    }

    static final class d extends AdListener
        implements com.google.android.gms.ads.internal.client.zza
    {

        final ki a;
        final MediationInterstitialListener b;

        public void onAdClicked()
        {
            b.onAdClicked(a);
        }

        public void onAdClosed()
        {
            b.onAdClosed(a);
        }

        public void onAdFailedToLoad(int i)
        {
            b.onAdFailedToLoad(a, i);
        }

        public void onAdLeftApplication()
        {
            b.onAdLeftApplication(a);
        }

        public void onAdLoaded()
        {
            b.onAdLoaded(a);
        }

        public void onAdOpened()
        {
            b.onAdOpened(a);
        }

        public d(ki ki1, MediationInterstitialListener mediationinterstitiallistener)
        {
            a = ki1;
            b = mediationinterstitiallistener;
        }
    }

    static final class e extends AdListener
        implements com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener, com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener, com.google.android.gms.ads.internal.client.zza
    {

        final ki a;
        final zzb b;

        public void onAdClicked()
        {
            b.zzd(a);
        }

        public void onAdClosed()
        {
            b.zzb(a);
        }

        public void onAdFailedToLoad(int i)
        {
            b.zza(a, i);
        }

        public void onAdLeftApplication()
        {
            b.zzc(a);
        }

        public void onAdLoaded()
        {
        }

        public void onAdOpened()
        {
            b.zza(a);
        }

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeappinstallad)
        {
            b.zza(a, new a(nativeappinstallad));
        }

        public void onContentAdLoaded(NativeContentAd nativecontentad)
        {
            b.zza(a, new b(nativecontentad));
        }

        public e(ki ki1, zzb zzb1)
        {
            a = ki1;
            b = zzb1;
        }
    }


    protected AdView a;
    protected InterstitialAd b;
    private AdLoader c;

    public ki()
    {
    }

    protected abstract Bundle a(Bundle bundle, Bundle bundle1);

    com.google.android.gms.ads.AdLoader.Builder a(Context context, String s)
    {
        return new com.google.android.gms.ads.AdLoader.Builder(context, s);
    }

    AdRequest a(Context context, MediationAdRequest mediationadrequest, Bundle bundle, Bundle bundle1)
    {
        com.google.android.gms.ads.AdRequest.Builder builder = new com.google.android.gms.ads.AdRequest.Builder();
        Object obj = mediationadrequest.getBirthday();
        if (obj != null)
        {
            builder.setBirthday(((java.util.Date) (obj)));
        }
        int i = mediationadrequest.getGender();
        if (i != 0)
        {
            builder.setGender(i);
        }
        obj = mediationadrequest.getKeywords();
        if (obj != null)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); builder.addKeyword((String)((Iterator) (obj)).next())) { }
        }
        obj = mediationadrequest.getLocation();
        if (obj != null)
        {
            builder.setLocation(((android.location.Location) (obj)));
        }
        if (mediationadrequest.isTesting())
        {
            builder.addTestDevice(zzk.zzcE().zzQ(context));
        }
        if (mediationadrequest.taggedForChildDirectedTreatment() != -1)
        {
            boolean flag;
            if (mediationadrequest.taggedForChildDirectedTreatment() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            builder.tagForChildDirectedTreatment(flag);
        }
        builder.addNetworkExtrasBundle(android/support/v7/kr, a(bundle, bundle1));
        return builder.build();
    }

    public String a(Bundle bundle)
    {
        return bundle.getString("pubid");
    }

    public View getBannerView()
    {
        return a;
    }

    public void onDestroy()
    {
        if (a != null)
        {
            a.destroy();
            a = null;
        }
        if (b != null)
        {
            b = null;
        }
        if (c != null)
        {
            c = null;
        }
    }

    public void onPause()
    {
        if (a != null)
        {
            a.pause();
        }
    }

    public void onResume()
    {
        if (a != null)
        {
            a.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationbannerlistener, Bundle bundle, AdSize adsize, MediationAdRequest mediationadrequest, Bundle bundle1)
    {
        a = new AdView(context);
        a.setAdSize(new AdSize(adsize.getWidth(), adsize.getHeight()));
        a.setAdUnitId(a(bundle));
        a.setAdListener(new c(this, mediationbannerlistener));
        a.loadAd(a(context, mediationadrequest, bundle1, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationinterstitiallistener, Bundle bundle, MediationAdRequest mediationadrequest, Bundle bundle1)
    {
        b = new InterstitialAd(context);
        b.setAdUnitId(a(bundle));
        b.setAdListener(new d(this, mediationinterstitiallistener));
        b.loadAd(a(context, mediationadrequest, bundle1, bundle));
    }

    public void requestNativeAd(Context context, zzb zzb, Bundle bundle, NativeMediationAdRequest nativemediationadrequest, Bundle bundle1)
    {
        zzb = new e(this, zzb);
        com.google.android.gms.ads.AdLoader.Builder builder = a(context, bundle.getString("pubid")).withAdListener(zzb);
        com.google.android.gms.ads.formats.NativeAdOptions nativeadoptions = nativemediationadrequest.getNativeAdOptions();
        if (nativeadoptions != null)
        {
            builder.withNativeAdOptions(nativeadoptions);
        }
        if (nativemediationadrequest.isAppInstallAdRequested())
        {
            builder.forAppInstallAd(zzb);
        }
        if (nativemediationadrequest.isContentAdRequested())
        {
            builder.forContentAd(zzb);
        }
        c = builder.build();
        c.loadAd(a(context, nativemediationadrequest, bundle1, bundle));
    }

    public void showInterstitial()
    {
        b.show();
    }
}
