// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import aaq;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import aqe;
import aqk;
import com.crashlytics.android.Crashlytics;
import com.fotoable.fotovariant.nativeAds.FotoNativeBaseWall;
import com.fotoable.homewall.THomewallView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
import yp;

// Referenced classes of package com.fotoable.ad:
//            NativeAdWrapper

public class HomeWallFactory
{

    public static String InstaBeauty_BundleName = "com.fotoable.fotobeauty";
    public static String InstaMag_BundleName = "com.instamag.activity";
    public static boolean IsHomawallLoaded = false;
    public static boolean IsSavewallLoaded = false;
    private static aqe NativeSize = new aqe(300, 207);
    public static String PIP_BundleName = "com.pipcamera.activity";
    static final String TAG = "HomeWallFactory";
    public static String Wantu_BundleName = "com.wantu.activity";
    private static WeakReference defaultAdWallViewRef = null;
    private static aqk gifListener = new _cls1();
    public static boolean hasADmobNativeAd = false;
    public static boolean hasNativeAd = false;
    private static WeakReference mActivityWeakRef = null;
    private static WeakReference mClickListenerRef = null;
    private static WeakReference mListenerWeakRef = null;
    private static int mPosition = 1;
    public static View nativeAdView = null;
    public static aqe nativeAdViewSize = null;
    private static WeakReference staticGifWallViewRef = null;
    private static WeakReference staticadContainerRef = null;

    public HomeWallFactory()
    {
    }

    public static void applyNativeAd()
    {
        if (nativeAdView != null)
        {
            ViewGroup viewgroup = (ViewGroup)nativeAdView.getParent();
            if (viewgroup != null)
            {
                viewgroup.removeView(nativeAdView);
            }
            if (staticGifWallViewRef != null && staticGifWallViewRef.get() != null)
            {
                if ((nativeAdView instanceof FotoNativeBaseWall) && mActivityWeakRef != null && mActivityWeakRef.get() != null)
                {
                    ((FotoNativeBaseWall)nativeAdView).reloadView((Activity)mActivityWeakRef.get());
                }
                ((THomewallView)staticGifWallViewRef.get()).clearNativeAD();
                ((THomewallView)staticGifWallViewRef.get()).addNativeAdView(nativeAdView);
                if (mListenerWeakRef != null && mListenerWeakRef.get() != null)
                {
                    ((fotoHomeWalladListener)mListenerWeakRef.get()).onHomeWallReceived(nativeAdViewSize);
                    IsHomawallLoaded = true;
                    return;
                }
            }
        }
    }

    public static void clearNativeView()
    {
        if (nativeAdView != null)
        {
            ViewGroup viewgroup = (ViewGroup)nativeAdView.getParent();
            if (viewgroup != null)
            {
                viewgroup.removeView(nativeAdView);
            }
            nativeAdView = null;
        }
        nativeAdViewSize = null;
    }

    public static void clearView()
    {
        if (staticGifWallViewRef != null)
        {
            staticGifWallViewRef.clear();
            staticGifWallViewRef = null;
        }
        IsHomawallLoaded = false;
        if (defaultAdWallViewRef != null)
        {
            defaultAdWallViewRef.clear();
            defaultAdWallViewRef = null;
        }
    }

    public static void createHomeWallAdView(Activity activity, View view, int i, String s, fotoHomeWalladListener fotohomewalladlistener, HomeWallClickListener homewallclicklistener)
    {
        mActivityWeakRef = new WeakReference(activity);
        mPosition = i;
        mListenerWeakRef = new WeakReference(fotohomewalladlistener);
        mClickListenerRef = new WeakReference(homewallclicklistener);
        if (view != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (isWebViewProbablyCorrupt(activity)) goto _L1; else goto _L3
_L3:
        int j;
        fotohomewalladlistener = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(fotohomewalladlistener);
        j = ((DisplayMetrics) (fotohomewalladlistener)).heightPixels;
        if (((DisplayMetrics) (fotohomewalladlistener)).widthPixels + j < 1280) goto _L1; else goto _L4
_L4:
        staticadContainerRef = new WeakReference((FrameLayout)view);
        fotohomewalladlistener = (FrameLayout)view.findViewWithTag("adViewContainer");
        if (fotohomewalladlistener == null) goto _L1; else goto _L5
_L5:
        view.setVisibility(0);
        fotohomewalladlistener.setVisibility(0);
        ((FrameLayout)staticadContainerRef.get()).setVisibility(0);
        if (staticGifWallViewRef != null) goto _L7; else goto _L6
_L6:
        view = new THomewallView(activity);
        view.addSize(new aqe(160, 120));
        view.addSize(new aqe(300, 207));
        staticGifWallViewRef = new WeakReference(view);
        view.setAdPosition(i);
        view.setGifViewListener(gifListener);
        view.onlineRequest(s);
        fotohomewalladlistener.addView(view);
_L9:
        applyNativeAd();
        if (defaultAdWallViewRef == null)
        {
            view = new ImageView(activity);
            defaultAdWallViewRef = new WeakReference(view);
            s = new android.widget.FrameLayout.LayoutParams(-2, -2);
            float f = activity.getResources().getDisplayMetrics().widthPixels;
            f -= (40F * f) / 320F;
            float f1 = (207F * f) / 300F;
            s.width = (int)f;
            s.height = (int)f1;
            s.gravity = 17;
            view.setLayoutParams(s);
            view.setBackgroundColor(0);
            loadDefaultWall();
            fotohomewalladlistener.addView(view);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        try
        {
            view = (THomewallView)staticGifWallViewRef.get();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            activity.printStackTrace();
            Crashlytics.logException(activity);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Crashlytics.logException(activity);
            return;
        }
        if (view == null) goto _L9; else goto _L8
_L8:
        if (view.getParent() != null)
        {
            ((ViewGroup)view.getParent()).removeView(view);
        }
        view.setAdPosition(mPosition);
        view.start();
        fotohomewalladlistener.addView(view);
          goto _L9
        if (defaultAdWallViewRef.get() == null) goto _L1; else goto _L10
_L10:
        if (((ImageView)defaultAdWallViewRef.get()).getParent() != null)
        {
            ((ViewGroup)((ImageView)defaultAdWallViewRef.get()).getParent()).removeView((View)defaultAdWallViewRef.get());
        }
        if (i != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!IsHomawallLoaded)
        {
            loadDefaultWall();
            fotohomewalladlistener.addView((View)defaultAdWallViewRef.get());
        }
        if (i != 2) goto _L1; else goto _L11
_L11:
        if (hasNativeAd || IsSavewallLoaded) goto _L1; else goto _L12
_L12:
        loadDefaultWall();
        fotohomewalladlistener.addView((View)defaultAdWallViewRef.get());
        return;
    }

    private static int dip2px(Context context, float f)
    {
        return (int)(context.getResources().getDisplayMetrics().density * f + 0.5F);
    }

    private static int getAppBannerImage(String s, int i)
    {
        if (mActivityWeakRef == null)
        {
            return aaq.home_fotorus_cn;
        }
        if (mActivityWeakRef.get() == null)
        {
            return aaq.home_fotorus_cn;
        }
        if (((Activity)mActivityWeakRef.get()).getPackageName().compareToIgnoreCase(PIP_BundleName) == 0 && s.compareToIgnoreCase(InstaBeauty_BundleName) == 0)
        {
            if (yp.a() && i == 1)
            {
                return aaq.beauty_in_pip_cn;
            }
            if (!yp.a() && i == 1)
            {
                return aaq.beauty_in_pip_en;
            }
        }
        if (s.compareToIgnoreCase(Wantu_BundleName) == 0)
        {
            if (yp.a() && i == 1)
            {
                return aaq.home_fotorus_cn;
            }
            if (yp.a() && i == 2)
            {
                return aaq.savewall_fotorus_cn;
            }
            if (!yp.a() && i == 1)
            {
                return aaq.home_fotorus_en;
            }
            if (!yp.a() && i == 2)
            {
                return aaq.savewall_fotorus_en;
            }
        } else
        if (s.compareToIgnoreCase(InstaMag_BundleName) == 0)
        {
            if (yp.a() && i == 1)
            {
                return aaq.home_instamag_cn;
            }
            if (yp.a() && i == 2)
            {
                return aaq.savewall_instamag_cn;
            }
            if (!yp.a() && i == 1)
            {
                return aaq.home_instamag_en;
            }
            if (!yp.a() && i == 2)
            {
                return aaq.savewall_instamag_en;
            }
        } else
        if (s.compareToIgnoreCase(InstaBeauty_BundleName) == 0)
        {
            if (yp.a() && i == 1)
            {
                return aaq.home_instabeauty_cn;
            }
            if (yp.a() && i == 2)
            {
                return aaq.savewall_instabeauty_cn;
            }
            if (!yp.a() && i == 1)
            {
                return aaq.home_instabeauty_en;
            }
            if (!yp.a() && i == 2)
            {
                return aaq.savewall_instabeauty_en;
            }
        }
        return aaq.home_fotorus_cn;
    }

    private static String getAppDownloadUrl(String s, String s1)
    {
        if (s.compareToIgnoreCase(Wantu_BundleName) == 0)
        {
            if (yp.a())
            {
                return "http://ad.apps.fm/qa_w_909ROKpPKglxNwMfa5px440Px0vtrw1ww5B54zQdRNgT6_EiPEaH8YoLpD4DJLKOLMY_juhsh5Hw3KCu08fOF8ZSDYgZhjpuyN3juo";
            } else
            {
                return "http://ad.apps.fm/b7AQW_n1kj6ftyguY3oS565px440Px0vtrw1ww5B54zQdRNgT6_EiPEaH8YoLpD4DJLKOLMY_juhsh5Hw3KCu8n28EatPhK8df5odF1AlDE";
            }
        }
        if (s.compareToIgnoreCase(InstaMag_BundleName) == 0)
        {
            if (yp.a())
            {
                return "http://ad.apps.fm/5N83LCGv25XS9IK2Wouwqa5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9EJfa5ANJkG7Cuc3SYZkhYu7J0qUk3OjfDYjebtGmHnyI";
            } else
            {
                return "http://ad.apps.fm/AhHYS1f7_zbD_DgA1Yn3p65px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9EJfa5ANJkG7Cuc3SYZkhYu4uJ6vq4aG2yCjv0vnvT728";
            }
        }
        if (s.compareToIgnoreCase(InstaBeauty_BundleName) == 0)
        {
            if (s1.compareToIgnoreCase(Wantu_BundleName) == 0)
            {
                if (yp.a())
                {
                    return "http://ad.apps.fm/dXSp7NANrtfS0hFrHubbkK5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvuAX-2hUuqEVFiZzbInDrWmkPHH8J58MuwMDZHyvO7ZnwmGoCp43dyUyi8sCzsPeK";
                } else
                {
                    return "http://ad.apps.fm/gB_NmQ0A74eSSuKIX217Fa5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvuAX-2hUuqEVFiZzbInDrWqm62fWbk4iDmSG-FDPPV5DwmGoCp43dyUyi8sCzsPeK";
                }
            }
            if (s1.compareToIgnoreCase(InstaMag_BundleName) == 0)
            {
                if (yp.a())
                {
                    return "http://ad.apps.fm/r9OUB_GFAyL1mZjhcMz96K5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvy5GzMhuSOAExcSrsI57pI69vGUNffnedufoS5R344xjO0WbEg59B4_REjBA_DY5h";
                } else
                {
                    return "http://ad.apps.fm/KIQ4B16ZhaQ3569om7JO865px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvy5GzMhuSOAExcSrsI57pI2P5537t9_rtzH0grtF4KBTO0WbEg59B4_REjBA_DY5h";
                }
            }
            if (s1.compareToIgnoreCase(PIP_BundleName) == 0)
            {
                if (yp.a())
                {
                    return "http://ad.apps.fm/0GvzmtCTzYUpZlpvLRIkKq5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvIRsnpJ59y84Aw9JG8Lc404ykfv24fiwF26iFmUgL1oU";
                } else
                {
                    return "http://ad.apps.fm/SR7Rq73l0lt-F3paRzLTCK5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvIRsnpJ59y84Aw9JG8Lc407FE0VUsRnE9meu6-jDD8aw";
                }
            } else
            {
                return "http://ad.apps.fm/r9OUB_GFAyL1mZjhcMz96K5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvy5GzMhuSOAExcSrsI57pI69vGUNffnedufoS5R344xjO0WbEg59B4_REjBA_DY5h";
            }
        } else
        {
            return "";
        }
    }

    private static String getRandomAppToShow()
    {
        if (mActivityWeakRef == null)
        {
            return "";
        }
        if (mActivityWeakRef.get() == null)
        {
            return "";
        }
        Activity activity = (Activity)mActivityWeakRef.get();
        if (activity.getPackageName().equalsIgnoreCase(PIP_BundleName) && !isInstall(InstaBeauty_BundleName))
        {
            return InstaBeauty_BundleName;
        }
        ArrayList arraylist = new ArrayList();
        if (!activity.getPackageName().equalsIgnoreCase(InstaBeauty_BundleName) && !isInstall(InstaBeauty_BundleName))
        {
            arraylist.add(InstaBeauty_BundleName);
        }
        if (!activity.getPackageName().equalsIgnoreCase(Wantu_BundleName) && !isInstall(Wantu_BundleName))
        {
            arraylist.add(Wantu_BundleName);
        }
        if (!activity.getPackageName().equalsIgnoreCase(InstaMag_BundleName) && !isInstall(InstaMag_BundleName))
        {
            arraylist.add(InstaMag_BundleName);
        }
        if (arraylist.size() > 0)
        {
            int i = (new Random()).nextInt(arraylist.size());
            if (i >= 0 && i < arraylist.size())
            {
                return (String)arraylist.get(i);
            }
        }
        return "";
    }

    private static boolean isInstall(String s)
    {
        while (mActivityWeakRef == null || mActivityWeakRef.get() == null) 
        {
            return false;
        }
        Activity activity = (Activity)mActivityWeakRef.get();
        boolean flag;
        try
        {
            s = activity.getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = null;
        }
        if (s == null)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        return flag;
    }

    public static final boolean isWebViewProbablyCorrupt(Context context)
    {
        SharedPreferences sharedpreferences;
        sharedpreferences = context.getSharedPreferences("sysconfig", 0);
        boolean flag = sharedpreferences.getBoolean("isWebViewProbablyCorrupt", true);
        if (!flag)
        {
            return flag;
        }
        context = context.openOrCreateDatabase("webviewCache.db", 0, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        context.close();
        sharedpreferences.edit().putBoolean("isWebViewProbablyCorrupt", false).apply();
        return false;
        context;
        Crashlytics.logException(context);
        return true;
    }

    private static void loadDefaultWall()
    {
        final String appToShow;
        for (appToShow = getRandomAppToShow(); appToShow == null || appToShow.length() <= 0 || defaultAdWallViewRef == null || defaultAdWallViewRef.get() == null;)
        {
            return;
        }

        try
        {
            ((ImageView)defaultAdWallViewRef.get()).setImageResource(getAppBannerImage(appToShow, mPosition));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            outofmemoryerror.printStackTrace();
            Crashlytics.logException(outofmemoryerror);
        }
        ((ImageView)defaultAdWallViewRef.get()).setOnClickListener(new _cls3());
    }

    public static void requestFBAdView(Context context)
    {
        Log.e("HomeWallFactory", "native wall requestFBAdView");
        try
        {
            hasNativeAd = false;
            NativeAdWrapper.resetAdStateWhenRefresh();
            NativeAdWrapper.createThirdPartNativeView(context, new _cls2());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        Crashlytics.logException(context);
    }

    public static void setHasLeft(boolean flag)
    {
        if (staticGifWallViewRef != null && staticGifWallViewRef.get() != null)
        {
            ((THomewallView)staticGifWallViewRef.get()).setHasLeft(flag);
        }
    }

    public static void startCirclePlay()
    {
        if (staticGifWallViewRef != null && staticGifWallViewRef.get() != null)
        {
            ((THomewallView)staticGifWallViewRef.get()).activeTimer();
        }
    }

    public static void stopCirclePlay()
    {
        if (staticGifWallViewRef != null && staticGifWallViewRef.get() != null)
        {
            ((THomewallView)staticGifWallViewRef.get()).cancelTimer();
        }
    }

    static 
    {
        IsHomawallLoaded = false;
        IsSavewallLoaded = false;
    }










    private class fotoHomeWalladListener
    {

        public abstract void onHomeWallLoadfailed();

        public abstract void onHomeWallReceived(aqe aqe1);
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final String val$appToShow;

        public void onClick(View view)
        {
_L2:
            return;
            if (HomeWallFactory.mActivityWeakRef == null || HomeWallFactory.mClickListenerRef == null || HomeWallFactory.mActivityWeakRef.get() == null || HomeWallFactory.mClickListenerRef.get() == null) goto _L2; else goto _L1
_L1:
            Activity activity = (Activity)HomeWallFactory.mActivityWeakRef.get();
            if (yp.a())
            {
                view = "CN";
            } else
            {
                view = "EN";
            }
            try
            {
                StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_click, (new StringBuilder()).append(view).append("_default").toString());
                if (HomeWallFactory.mClickListenerRef != null)
                {
                    ((HomeWallClickListener)HomeWallFactory.mClickListenerRef.get()).onHomeWallClicked(HomeWallFactory.getAppDownloadUrl(appToShow, activity.getPackageName()));
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                try
                {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(appToShow).toString())));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    Crashlytics.logException(view);
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                Crashlytics.logException(view);
                return;
            }
            if (true) goto _L2; else goto _L3
_L3:
        }

        _cls3()
        {
            appToShow = s;
            super();
        }

        private class HomeWallClickListener
        {

            public abstract void onHomeWallClicked(String s);
        }

    }


    private class _cls2
        implements NativeAdWrapper.NativeAdWrapperListener
    {

        public void onAdDelayReload()
        {
            HomeWallFactory.hasNativeAd = false;
        }

        public void onAdFailedToLoad(int i)
        {
            HomeWallFactory.hasNativeAd = false;
        }

        public void onAdLoaded(View view, aqe aqe1)
        {
            HomeWallFactory.hasNativeAd = true;
            HomeWallFactory.nativeAdView = view;
            HomeWallFactory.nativeAdViewSize = aqe1;
            HomeWallFactory.applyNativeAd();
        }

        _cls2()
        {
        }
    }


    private class _cls1
        implements aqk
    {

        public void GifViewClicked(String s)
        {
            if (HomeWallFactory.mClickListenerRef != null && HomeWallFactory.mClickListenerRef.get() != null)
            {
                ((HomeWallClickListener)HomeWallFactory.mClickListenerRef.get()).onHomeWallClicked(s);
            }
        }

        public void GifViewDisplayed(aqe aqe1)
        {
            if (HomeWallFactory.defaultAdWallViewRef != null && HomeWallFactory.defaultAdWallViewRef.get() != null)
            {
                ImageView imageview = (ImageView)HomeWallFactory.defaultAdWallViewRef.get();
                if ((ViewGroup)imageview.getParent() != null)
                {
                    ((ViewGroup)imageview.getParent()).removeView(imageview);
                }
            }
            if (HomeWallFactory.mListenerWeakRef != null && HomeWallFactory.mListenerWeakRef.get() != null)
            {
                ((fotoHomeWalladListener)HomeWallFactory.mListenerWeakRef.get()).onHomeWallReceived(aqe1);
                if (HomeWallFactory.mPosition == 1)
                {
                    HomeWallFactory.IsHomawallLoaded = true;
                }
                if (HomeWallFactory.mPosition == 2)
                {
                    HomeWallFactory.IsSavewallLoaded = true;
                }
            }
        }

        public void GifViewSizeChanged(aqe aqe1)
        {
            Object obj;
            while (HomeWallFactory.staticGifWallViewRef == null || HomeWallFactory.mActivityWeakRef == null || HomeWallFactory.staticGifWallViewRef.get() == null || HomeWallFactory.mActivityWeakRef.get() == null) 
            {
                return;
            }
            obj = (Activity)HomeWallFactory.mActivityWeakRef.get();
            float f = ((Activity) (obj)).getResources().getDisplayMetrics().widthPixels;
            float f1 = f - (2.0F * f * (320F - (float)aqe1.a())) / 320F;
            f = f1;
            if (f1 <= (float)aqe1.a())
            {
                f = HomeWallFactory.dip2px(((Context) (obj)), aqe1.a());
            }
            f1 = ((float)aqe1.b() * f) / (float)aqe1.a();
            obj = (android.widget.FrameLayout.LayoutParams)((THomewallView)HomeWallFactory.staticGifWallViewRef.get()).getLayoutParams();
            obj.width = (int)f;
            obj.height = (int)f1;
            if (aqe1.a() != aqe1.b() && (aqe1.a() != 160 || aqe1.b() != 120)) goto _L2; else goto _L1
_L1:
            if (HomeWallFactory.mPosition != 1) goto _L4; else goto _L3
_L3:
            obj.gravity = 85;
_L6:
            ((THomewallView)HomeWallFactory.staticGifWallViewRef.get()).resetlayout(((android.widget.FrameLayout.LayoutParams) (obj)));
            return;
_L4:
            if (HomeWallFactory.mPosition == 2)
            {
                obj.gravity = 53;
            }
            continue; /* Loop/switch isn't completed */
_L2:
            obj.gravity = 17;
            if (true) goto _L6; else goto _L5
_L5:
        }

        public void GifViewfailed()
        {
            if (HomeWallFactory.mListenerWeakRef != null && HomeWallFactory.mListenerWeakRef.get() != null && (HomeWallFactory.mPosition == 1 && !HomeWallFactory.IsHomawallLoaded || HomeWallFactory.mPosition == 2 && !HomeWallFactory.IsSavewallLoaded))
            {
                ((fotoHomeWalladListener)HomeWallFactory.mListenerWeakRef.get()).onHomeWallLoadfailed();
            }
            if (HomeWallFactory.defaultAdWallViewRef != null && HomeWallFactory.defaultAdWallViewRef.get() != null)
            {
                ImageView imageview = (ImageView)HomeWallFactory.defaultAdWallViewRef.get();
                if (imageview.getParent() != null)
                {
                    ((ViewGroup)imageview.getParent()).removeView(imageview);
                }
                if (HomeWallFactory.staticadContainerRef != null && HomeWallFactory.staticGifWallViewRef.get() != null)
                {
                    ((FrameLayout)HomeWallFactory.staticadContainerRef.get()).addView(imageview);
                }
            }
        }

        _cls1()
        {
        }
    }

}
