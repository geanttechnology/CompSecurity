// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.util.AdUtil;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import java.lang.ref.WeakReference;
import java.util.List;

public class NativeAdLoader
{
    static final class InnerAdListener extends AdListener
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

        InnerAdListener(AdListener adlistener)
        {
            innerListener = adlistener;
        }
    }

    static final class OnAppInstallAdLoadedListener
        implements com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
    {

        private final AdListener listener;
        private final WeakReference loaderReference;

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeappinstallad)
        {
            NativeAdLoader nativeadloader = (NativeAdLoader)loaderReference.get();
            if (nativeadloader != null)
            {
                nativeadloader.nativeAd = nativeappinstallad;
                if (listener != null)
                {
                    listener.onAdLoaded();
                    return;
                }
            }
        }

        OnAppInstallAdLoadedListener(NativeAdLoader nativeadloader, AdListener adlistener)
        {
            loaderReference = new WeakReference(nativeadloader);
            listener = adlistener;
        }
    }

    static final class OnContentAdLoadedListener
        implements com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
    {

        private final AdListener listener;
        private final WeakReference loaderReference;

        public void onContentAdLoaded(NativeContentAd nativecontentad)
        {
            NativeAdLoader nativeadloader = (NativeAdLoader)loaderReference.get();
            if (nativeadloader != null)
            {
                nativeadloader.nativeAd = nativecontentad;
                if (listener != null)
                {
                    listener.onAdLoaded();
                    return;
                }
            }
        }

        OnContentAdLoadedListener(NativeAdLoader nativeadloader, AdListener adlistener)
        {
            loaderReference = new WeakReference(nativeadloader);
            listener = adlistener;
        }
    }


    public static final String AD_SITE_DE = "Anzeige";
    public static final String AD_SITE_DEFAULT = "Ad";
    public static final String AD_SITE_ES = "Anuncio";
    public static final String AD_SITE_FR = "Annonce";
    public static final String AD_SITE_IT = "Ann.";
    private static final double IMAGE_HEIGHT_SCALE = 0.59999999999999998D;
    private static final int NATIVE_AD_WIDTH_WIDE = 738;
    private static final double NOMINAL_RATIO = 1.6699999999999999D;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("NativeAdLoader", 3, "Log Native Ad Loader events");
    private com.ebay.common.rtm.RtmContent.Ad ad;
    private NativeAd nativeAd;

    public NativeAdLoader(com.ebay.common.rtm.RtmContent.Ad ad1)
    {
        if (ad1 == null)
        {
            throw new IllegalArgumentException("invalid argument");
        } else
        {
            ad = ad1;
            return;
        }
    }

    public static View getAdView(Context context, int i, ViewGroup viewgroup, NativeAd nativead)
    {
        boolean flag = true;
        if (context != null && viewgroup != null && nativead != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        int j;
        int k = viewgroup.getWidth();
        j = k;
        if (k == 0)
        {
            j = i;
        }
        obj = context.getResources().getDisplayMetrics();
        i = (int)((float)j / ((float)((DisplayMetrics) (obj)).densityDpi / 160F));
        if (debugLogger.isLoggable)
        {
            debugLogger.log(String.format("pix = %d, dp = %d", new Object[] {
                Integer.valueOf(j), Integer.valueOf(i)
            }));
        }
        if (i < 738)
        {
            flag = false;
        }
        EbaySite.getInstanceFromId(MyApp.getCurrentSite()).idInt;
        JVM INSTR lookupswitch 5: default 164
    //                   71: 204
    //                   77: 197
    //                   101: 211
    //                   186: 218
    //                   210: 204;
           goto _L3 _L4 _L5 _L6 _L7 _L4
_L3:
        obj = "Ad";
_L9:
        if (nativead instanceof NativeContentAd)
        {
            return getContentAdView(context, viewgroup, j, ((String) (obj)), flag, (NativeContentAd)nativead);
        }
        break; /* Loop/switch isn't completed */
_L5:
        obj = "Anzeige";
        continue; /* Loop/switch isn't completed */
_L4:
        obj = "Annonce";
        continue; /* Loop/switch isn't completed */
_L6:
        obj = "Ann.";
        continue; /* Loop/switch isn't completed */
_L7:
        obj = "Anuncio";
        if (true) goto _L9; else goto _L8
_L8:
        if (!(nativead instanceof NativeAppInstallAd)) goto _L1; else goto _L10
_L10:
        return getAppInstallAdView(context, viewgroup, j, ((String) (obj)), flag, (NativeAppInstallAd)nativead);
    }

    private static View getAppInstallAdView(Context context, ViewGroup viewgroup, int i, String s, boolean flag, NativeAppInstallAd nativeappinstallad)
    {
        Object obj;
        int j;
        if (flag)
        {
            j = 0x7f03017a;
        } else
        {
            j = 0x7f030179;
        }
        viewgroup = (NativeAppInstallAdView)((LayoutInflater)context.getSystemService("layout_inflater")).inflate(j, viewgroup, false);
        obj = (TextView)viewgroup.findViewById(0x7f1003e5);
        ((TextView) (obj)).setText(textFromHtml(nativeappinstallad.getBody()));
        viewgroup.setBodyView(((View) (obj)));
        obj = (TextView)viewgroup.findViewById(0x7f1003e2);
        ((TextView) (obj)).setText(textFromHtml(nativeappinstallad.getHeadline()));
        viewgroup.setHeadlineView(((View) (obj)));
        ((TextView)viewgroup.findViewById(0x7f1003e0)).setText(s);
        s = (ImageView)viewgroup.findViewById(0x7f1003e1);
        if (nativeappinstallad.getIcon() != null)
        {
            s.setImageDrawable(nativeappinstallad.getIcon().getDrawable());
            viewgroup.setIconView(s);
        } else
        {
            s.setVisibility(8);
        }
        s = (ImageView)viewgroup.findViewById(0x7f1003e3);
        obj = nativeappinstallad.getImages();
        if (obj != null && ((List) (obj)).size() > 0)
        {
            obj = ((com.google.android.gms.ads.formats.NativeAd.Image)((List) (obj)).get(0)).getDrawable();
            j = ((Drawable) (obj)).getIntrinsicWidth();
            int k = ((Drawable) (obj)).getIntrinsicHeight();
            if (j > 0 && k > 0)
            {
                double d = (double)j / (double)k;
                if (flag)
                {
                    LinearLayout linearlayout = (LinearLayout)viewgroup.findViewById(0x7f1003e7);
                    j = (int)((double)(i / 2) * 0.59999999999999998D);
                    linearlayout.setMinimumHeight(j);
                    i = j;
                    if (d < 1.6699999999999999D)
                    {
                        s.setBackgroundColor(context.getResources().getColor(0x7f0d00b9));
                        i = j;
                    }
                } else
                if (d > 1.6699999999999999D)
                {
                    i = (int)((double)i / d);
                } else
                {
                    i = (int)((double)i * 0.59999999999999998D);
                    s.setBackgroundColor(context.getResources().getColor(0x7f0d00b9));
                }
                s.setMaxHeight(i);
                s.setImageDrawable(((Drawable) (obj)));
            }
        } else
        {
            s.setVisibility(8);
        }
        viewgroup.setImageView(s);
        context = (Button)viewgroup.findViewById(0x7f1003e6);
        s = textFromHtml(nativeappinstallad.getCallToAction());
        if (s != null)
        {
            context.setText(s);
            viewgroup.setCallToActionView(context);
        } else
        {
            context.setVisibility(8);
        }
        try
        {
            viewgroup.setNativeAd(nativeappinstallad);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LogTrackManager.addLogErrorData(new LogTrackError("GoogleNativeAds", "setNativeAd", null, null, "Application", "CrashError", context));
            return null;
        }
        return viewgroup;
    }

    private static View getContentAdView(Context context, ViewGroup viewgroup, int i, String s, boolean flag, NativeContentAd nativecontentad)
    {
        Object obj;
        int j;
        if (flag)
        {
            j = 0x7f03017c;
        } else
        {
            j = 0x7f03017b;
        }
        viewgroup = (NativeContentAdView)((LayoutInflater)context.getSystemService("layout_inflater")).inflate(j, viewgroup, false);
        obj = (TextView)viewgroup.findViewById(0x7f1003e4);
        ((TextView) (obj)).setText(textFromHtml(nativecontentad.getHeadline()));
        viewgroup.setHeadlineView(((View) (obj)));
        obj = (TextView)viewgroup.findViewById(0x7f1003e5);
        ((TextView) (obj)).setText(textFromHtml(nativecontentad.getBody()));
        viewgroup.setBodyView(((View) (obj)));
        obj = (TextView)viewgroup.findViewById(0x7f1003e2);
        ((TextView) (obj)).setText(textFromHtml(nativecontentad.getAdvertiser()));
        viewgroup.setAdvertiserView(((View) (obj)));
        ((TextView)viewgroup.findViewById(0x7f1003e0)).setText(s);
        s = (ImageView)viewgroup.findViewById(0x7f1003e1);
        if (nativecontentad.getLogo() != null)
        {
            s.setImageDrawable(nativecontentad.getLogo().getDrawable());
            viewgroup.setLogoView(s);
        } else
        {
            s.setVisibility(8);
        }
        s = (ImageView)viewgroup.findViewById(0x7f1003e3);
        obj = nativecontentad.getImages();
        if (obj != null && ((List) (obj)).size() > 0)
        {
            obj = ((com.google.android.gms.ads.formats.NativeAd.Image)((List) (obj)).get(0)).getDrawable();
            j = ((Drawable) (obj)).getIntrinsicWidth();
            int k = ((Drawable) (obj)).getIntrinsicHeight();
            if (j > 0 && k > 0)
            {
                double d = (double)j / (double)k;
                if (flag)
                {
                    LinearLayout linearlayout = (LinearLayout)viewgroup.findViewById(0x7f1003e7);
                    j = (int)((double)(i / 2) * 0.59999999999999998D);
                    linearlayout.setMinimumHeight(j);
                    i = j;
                    if (d < 1.6699999999999999D)
                    {
                        s.setBackgroundColor(context.getResources().getColor(0x7f0d00b9));
                        i = j;
                    }
                } else
                if (d > 1.6699999999999999D)
                {
                    i = (int)((double)i / d);
                } else
                {
                    i = (int)((double)i * 0.59999999999999998D);
                    s.setBackgroundColor(context.getResources().getColor(0x7f0d00b9));
                }
                s.setMaxHeight(i);
                s.setImageDrawable(((Drawable) (obj)));
            }
        } else
        {
            s.setVisibility(8);
        }
        viewgroup.setImageView(s);
        context = (Button)viewgroup.findViewById(0x7f1003e6);
        s = textFromHtml(nativecontentad.getCallToAction());
        if (s != null)
        {
            context.setText(s);
            viewgroup.setCallToActionView(context);
        } else
        {
            context.setVisibility(8);
        }
        try
        {
            viewgroup.setNativeAd(nativecontentad);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LogTrackManager.addLogErrorData(new LogTrackError("GoogleNativeAds", "setNativeAd", null, null, "Application", "CrashError", context));
            return null;
        }
        return viewgroup;
    }

    private static CharSequence textFromHtml(CharSequence charsequence)
    {
        if (TextUtils.isEmpty(charsequence))
        {
            return null;
        } else
        {
            return Html.fromHtml(charsequence.toString());
        }
    }

    public View getAdView(Context context, ViewGroup viewgroup)
    {
        return getAdView(context, 0, viewgroup, nativeAd);
    }

    public NativeAd getNativeAd()
    {
        return nativeAd;
    }

    public void loadAd(Context context, PublisherAdRequest publisheradrequest, AdListener adlistener)
    {
        context = (new com.google.android.gms.ads.AdLoader.Builder(context, AdUtil.getAdUnitId(ad))).forAppInstallAd(new OnAppInstallAdLoadedListener(this, adlistener)).forContentAd(new OnContentAdLoadedListener(this, adlistener)).withAdListener(new InnerAdListener(adlistener)).build();
        try
        {
            context.loadAd(publisheradrequest);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (adlistener != null)
        {
            adlistener.onAdFailedToLoad(0);
        }
        LogTrackManager.addLogErrorData(new LogTrackError("GoogleNativeAds", "loadNativeAd", null, null, "Application", "CrashError", context));
    }



/*
    static NativeAd access$002(NativeAdLoader nativeadloader, NativeAd nativead)
    {
        nativeadloader.nativeAd = nativead;
        return nativead;
    }

*/
}
