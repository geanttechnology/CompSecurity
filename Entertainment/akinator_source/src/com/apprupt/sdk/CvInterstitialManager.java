// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.apprupt.sdk:
//            CvAdViewCallback, CvSDK, CvMediation, CvAdView, 
//            Logger, CvAd, CvAdType, CvContext, 
//            CvAdColony, CvInterstitialActivity

class CvInterstitialManager
    implements CvAdViewCallback
{

    private int adSpaceId;
    private String categories;
    private String keywords;
    private CvSDK.CvInterstitialListener listener;
    private CvAdView loadingAd;
    private Context mContext;

    private CvInterstitialManager()
    {
        mContext = null;
        loadingAd = null;
        adSpaceId = -1;
        keywords = "";
        categories = "";
    }

    CvInterstitialManager(_cls1 _pcls1)
    {
        this();
    }

    static CvInterstitialManager getInstance()
    {
    /* block-local class not found */
    class CvInterstitialInstanceHolder {}

        return CvInterstitialInstanceHolder.instance;
    }

    void fetchInterstitial(Context context, int i, CvContentManager.PreloaderListener preloaderlistener, String s, String s1)
    {
        CvSDK.mediation.checkConfig(new _cls1(i, s, s1, context, preloaderlistener));
    }

    int getAdSpaceId()
    {
        int i = adSpaceId;
        adSpaceId = -1;
        return i;
    }

    public String getCategories(CvAdView cvadview)
    {
        return categories;
    }

    public String getKeywords(CvAdView cvadview)
    {
        return keywords;
    }

    public int getLimit(CvAdView cvadview)
    {
        return 1;
    }

    CvSDK.CvInterstitialListener getListener()
    {
        CvSDK.CvInterstitialListener cvinterstitiallistener = listener;
        listener = null;
        return cvinterstitiallistener;
    }

    void killInterstitial()
    {
        this;
        JVM INSTR monitorenter ;
        if (loadingAd != null)
        {
            loadingAd.kill();
            loadingAd = null;
            if (listener == null);
            adSpaceId = -1;
            listener = null;
            mContext = null;
            categories = "";
            keywords = "";
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onError(CvAdView cvadview, String s, int i)
    {
        Logger.get("INTERSTITIAL").e(new Object[] {
            (new StringBuilder()).append("Cannot display interstitial ").append(s).append(" code ").append(i).toString()
        });
        Logger.get().e(new Object[] {
            "Cannot display interstitial: no ads found"
        });
        if (listener != null)
        {
            listener.cvInterstitialDidFail(adSpaceId, "Failed to load ads (probably server returned empty response)", i);
            listener = null;
        }
        killInterstitial();
        try
        {
            cvadview.kill();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CvAdView cvadview)
        {
            return;
        }
    }

    public void onFirstTap()
    {
    }

    public void onLoad(CvAdView cvadview)
    {
        cvadview.setCallback(null);
        if (cvadview != loadingAd || mContext == null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        Logger.log log = Logger.get("AdColony");
        Object obj = cvadview.getCurrentData();
        Object obj1 = ((CvAd) (obj)).getType();
        Object obj2 = CvAdType.AD_COLONY_INTERSTITIAL;
        String s;
        int i;
        boolean flag;
        if (((CvAd) (obj)).getType() == CvAdType.AD_COLONY_INTERSTITIAL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        log.e(new Object[] {
            "AD TYPE", obj1, obj2, Boolean.valueOf(flag)
        });
        if (((CvAd) (obj)).getType() != CvAdType.AD_COLONY_INTERSTITIAL)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        log.e(new Object[] {
            "DISPLAY AD COLONY!"
        });
        obj = ((CvContext)cvadview.getContext()).getBaseContext();
        i = adSpaceId;
        obj1 = listener;
        obj2 = categories;
        s = keywords;
        cvadview.setCallback(null);
        listener = null;
        killInterstitial();
        CvAdColony.wrapper().showInterstitial(i, new _cls3(((CvSDK.CvInterstitialListener) (obj1)), i, log, ((Context) (obj)), ((String) (obj2)), s));
        cvadview.kill();
        return;
        Logger.get().i(new Object[] {
            "Interstitial will appear"
        });
        if (listener != null)
        {
            listener.cvInterstitialWillAppear(adSpaceId);
        }
        cvadview = new Intent(mContext, com/apprupt/sdk/CvInterstitialActivity);
        cvadview.addFlags(0x10000000);
        mContext.startActivity(cvadview);
        return;
        cvadview;
    }

    CvAdView popAdView()
    {
        CvAdView cvadview = loadingAd;
        this;
        JVM INSTR monitorenter ;
        loadingAd = null;
        mContext = null;
        categories = null;
        keywords = null;
        this;
        JVM INSTR monitorexit ;
        return cvadview;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void startInterstitial(Context context, int i, CvSDK.CvInterstitialListener cvinterstitiallistener, String s, String s1)
    {
        CvSDK.mediation.checkConfig(new _cls2(i, s, s1, cvinterstitiallistener, context));
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}

}
