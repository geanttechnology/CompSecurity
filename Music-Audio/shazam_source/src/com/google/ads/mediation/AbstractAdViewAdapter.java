// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.c.a;
import com.google.android.gms.ads.c.c;
import com.google.android.gms.ads.c.e;
import com.google.android.gms.ads.c.h;
import com.google.android.gms.ads.c.i;
import com.google.android.gms.ads.c.j;
import com.google.android.gms.ads.c.l;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.internal.client.aa;
import com.google.android.gms.ads.internal.client.ab;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.client.q;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractAdViewAdapter
    implements c, e, l
{
    static class zza extends h
    {

        private final com.google.android.gms.ads.b.d zzaN;

        public void trackView(View view)
        {
            if (view instanceof com.google.android.gms.ads.b.c)
            {
                ((com.google.android.gms.ads.b.c)view).setNativeAd(zzaN);
            }
        }

        public zza(com.google.android.gms.ads.b.d d1)
        {
            zzaN = d1;
            setHeadline(d1.b().toString());
            setImages(d1.c());
            setBody(d1.d().toString());
            setIcon(d1.e());
            setCallToAction(d1.f().toString());
            setStarRating(d1.g().doubleValue());
            setStore(d1.h().toString());
            setPrice(d1.i().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }
    }

    static class zzb extends i
    {

        private final com.google.android.gms.ads.b.e zzaO;

        public void trackView(View view)
        {
            if (view instanceof com.google.android.gms.ads.b.c)
            {
                ((com.google.android.gms.ads.b.c)view).setNativeAd(zzaO);
            }
        }

        public zzb(com.google.android.gms.ads.b.e e1)
        {
            zzaO = e1;
            setHeadline(e1.b().toString());
            setImages(e1.c());
            setBody(e1.d().toString());
            setLogo(e1.e());
            setCallToAction(e1.f().toString());
            setAdvertiser(e1.g().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }
    }

    static final class zzc extends com.google.android.gms.ads.a
        implements com.google.android.gms.ads.internal.client.a
    {

        final AbstractAdViewAdapter zzaP;
        final com.google.android.gms.ads.c.d zzaQ;

        public final void onAdClicked()
        {
            zzaQ.e();
        }

        public final void onAdClosed()
        {
            zzaQ.c();
        }

        public final void onAdFailedToLoad(int i)
        {
            zzaQ.a(i);
        }

        public final void onAdLeftApplication()
        {
            zzaQ.d();
        }

        public final void onAdLoaded()
        {
            zzaQ.a();
        }

        public final void onAdOpened()
        {
            zzaQ.b();
        }

        public zzc(AbstractAdViewAdapter abstractadviewadapter, com.google.android.gms.ads.c.d d1)
        {
            zzaP = abstractadviewadapter;
            zzaQ = d1;
        }
    }

    static final class zzd extends com.google.android.gms.ads.a
        implements com.google.android.gms.ads.internal.client.a
    {

        final AbstractAdViewAdapter zzaP;
        final com.google.android.gms.ads.c.f zzaR;

        public final void onAdClicked()
        {
            zzaR.j();
        }

        public final void onAdClosed()
        {
            zzaR.h();
        }

        public final void onAdFailedToLoad(int i)
        {
            zzaR.b(i);
        }

        public final void onAdLeftApplication()
        {
            zzaR.i();
        }

        public final void onAdLoaded()
        {
            zzaR.f();
        }

        public final void onAdOpened()
        {
            zzaR.g();
        }

        public zzd(AbstractAdViewAdapter abstractadviewadapter, com.google.android.gms.ads.c.f f1)
        {
            zzaP = abstractadviewadapter;
            zzaR = f1;
        }
    }

    static final class zze extends com.google.android.gms.ads.a
        implements com.google.android.gms.ads.b.d.a, com.google.android.gms.ads.b.e.a, com.google.android.gms.ads.internal.client.a
    {

        final AbstractAdViewAdapter zzaP;
        final com.google.android.gms.ads.c.m zzaS;

        public final void onAdClicked()
        {
            zzaS.n();
        }

        public final void onAdClosed()
        {
            zzaS.l();
        }

        public final void onAdFailedToLoad(int i)
        {
            zzaS.c(i);
        }

        public final void onAdLeftApplication()
        {
            zzaS.m();
        }

        public final void onAdLoaded()
        {
        }

        public final void onAdOpened()
        {
            zzaS.k();
        }

        public final void onAppInstallAdLoaded(com.google.android.gms.ads.b.d d1)
        {
            zzaS.a(new zza(d1));
        }

        public final void onContentAdLoaded(com.google.android.gms.ads.b.e e1)
        {
            zzaS.a(new zzb(e1));
        }

        public zze(AbstractAdViewAdapter abstractadviewadapter, com.google.android.gms.ads.c.m m1)
        {
            zzaP = abstractadviewadapter;
            zzaS = m1;
        }
    }


    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    protected com.google.android.gms.ads.e zzaK;
    protected f zzaL;
    private b zzaM;

    public AbstractAdViewAdapter()
    {
    }

    public String getAdUnitId(Bundle bundle)
    {
        return bundle.getString("pubid");
    }

    public View getBannerView()
    {
        return zzaK;
    }

    public void onDestroy()
    {
        if (zzaK != null)
        {
            zzaK.a.a();
            zzaK = null;
        }
        if (zzaL != null)
        {
            zzaL = null;
        }
        if (zzaM != null)
        {
            zzaM = null;
        }
    }

    public void onPause()
    {
        if (zzaK != null)
        {
            zzaK.a.c();
        }
    }

    public void onResume()
    {
        if (zzaK != null)
        {
            zzaK.a.d();
        }
    }

    public void requestBannerAd(Context context, com.google.android.gms.ads.c.d d1, Bundle bundle, d d2, a a1, Bundle bundle1)
    {
        zzaK = new com.google.android.gms.ads.e(context);
        zzaK.setAdSize(new d(d2.h, d2.i));
        zzaK.setAdUnitId(getAdUnitId(bundle));
        zzaK.setAdListener(new zzc(this, d1));
        zzaK.a(zza(context, a1, bundle1, bundle));
    }

    public void requestInterstitialAd(Context context, com.google.android.gms.ads.c.f f1, Bundle bundle, a a1, Bundle bundle1)
    {
        zzaL = new f(context);
        zzaL.a(getAdUnitId(bundle));
        zzaL.a(new zzd(this, f1));
        zzaL.a(zza(context, a1, bundle1, bundle));
    }

    public void requestNativeAd(Context context, com.google.android.gms.ads.c.m m1, Bundle bundle, j j1, Bundle bundle1)
    {
        m1 = new zze(this, m1);
        com.google.android.gms.ads.b.a a1 = zza(context, bundle.getString("pubid")).a(m1);
        com.google.android.gms.ads.b.b b1 = j1.g();
        if (b1 != null)
        {
            a1.a(b1);
        }
        if (j1.h())
        {
            a1.a(m1);
        }
        if (j1.i())
        {
            a1.a(m1);
        }
        zzaM = a1.a();
        m1 = zzaM;
        context = zza(context, j1, bundle1, bundle).b;
        try
        {
            ((b) (m1)).b.a(com.google.android.gms.ads.internal.client.j.a(((b) (m1)).a, context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Failed to load ad.", context);
        }
    }

    public void showInterstitial()
    {
        zzaL.a.b();
    }

    public abstract Bundle zza(Bundle bundle, Bundle bundle1);

    com.google.android.gms.ads.b.a zza(Context context, String s)
    {
        return new com.google.android.gms.ads.b.a(context, s);
    }

    com.google.android.gms.ads.c zza(Context context, a a1, Bundle bundle, Bundle bundle1)
    {
        boolean flag = true;
        com.google.android.gms.ads.c.a a2 = new com.google.android.gms.ads.c.a();
        Object obj = a1.a();
        if (obj != null)
        {
            a2.a.g = ((java.util.Date) (obj));
        }
        int i = a1.b();
        if (i != 0)
        {
            a2.a(i);
        }
        obj = a1.c();
        if (obj != null)
        {
            String s;
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a2.a.a.add(s))
            {
                s = (String)((Iterator) (obj)).next();
            }

        }
        obj = a1.d();
        if (obj != null)
        {
            a2.a(((android.location.Location) (obj)));
        }
        if (a1.f())
        {
            m.a();
            context = com.google.android.gms.ads.internal.util.client.a.a(context);
            a2.a.a(context);
        }
        if (a1.e() != -1)
        {
            int k;
            if (a1.e() == 1)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            context = a2.a;
            if (k != 0)
            {
                k = ((flag) ? 1 : 0);
            } else
            {
                k = 0;
            }
            context.n = k;
        }
        context = zza(bundle, bundle1);
        a2.a.a(com/google/ads/mediation/admob/AdMobAdapter, context);
        if (com/google/ads/mediation/admob/AdMobAdapter.equals(com/google/ads/mediation/admob/AdMobAdapter) && context.getBoolean("_emulatorLiveAds"))
        {
            context = a2.a;
            a1 = a;
            ((com.google.android.gms.ads.internal.client.z.a) (context)).d.remove(a1);
        }
        return a2.a();
    }
}
