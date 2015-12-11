// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.databerries.DataBerries;
import com.elokence.analytics.MetricsSetAdapter;
import com.intentsoftware.addapptr.AATKit;
import com.intentsoftware.addapptr.PlacementSize;
import com.tapjoy.Tapjoy;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkApplication, AkLog, AkGameFactory, AkPlayerBelongingsFactory

public class AkApplicationProcessing
    implements com.intentsoftware.addapptr.AATKit.Delegate
{

    public static final String AATKIT_ACTION_PLACEMENT_ID = "placementId";
    public static final String AATKIT_HAVE_AD_ACTION = (new StringBuilder()).append(com/digidust/elokence/akinator/factories/AkApplication.getPackage().getName()).append(".AATKIT_HAVE_AD").toString();
    public static final int BANNER = 0;
    public static final int INTERSTITIAL = 1;
    public static final int Launch_Interstitial = 2;
    public static final int Questions_Banner = 8;
    public static final int Questions_Banner_Tablet = 9;
    public static final int REWARD_VIDEO_AD_AVAILABLE = 1;
    public static final int REWARD_VIDEO_NO_AD = 0;
    public static final int Rewarded_Interstitial = 10;
    private static final String TAG = "AATKitDelegate";
    private static AkApplicationProcessing _instance = null;
    private ArrayList aAtkitlisteners;
    private AkApplication application;
    private int launchInterstitialId;
    private int mRewardedVideoState;
    private int questionBannerId;
    private int questionBannerTabletId;
    private int rewardedInterstitialId;

    private AkApplicationProcessing()
    {
        application = null;
        launchInterstitialId = -1;
        questionBannerId = -1;
        questionBannerTabletId = -1;
        rewardedInterstitialId = -1;
        mRewardedVideoState = 0;
        aAtkitlisteners = new ArrayList();
    }

    public static AkApplicationProcessing getInstance()
    {
        if (_instance == null)
        {
            _instance = new AkApplicationProcessing();
        }
        return _instance;
    }

    public void aatkitHaveAd(int i)
    {
        AkLog.d("AATKitDelegate", (new StringBuilder()).append("ATKit have Ad placementid=").append(i).toString());
        Intent intent = new Intent(AATKIT_HAVE_AD_ACTION);
        intent.putExtra("placementId", i);
        LocalBroadcastManager.getInstance(application.getApplicationContext()).sendBroadcast(intent);
        if (i == rewardedInterstitialId)
        {
            mRewardedVideoState = 1;
        }
        for (Iterator iterator = aAtkitlisteners.iterator(); iterator.hasNext(); ((com.intentsoftware.addapptr.AATKit.Delegate)iterator.next()).aatkitHaveAd(i)) { }
    }

    public void aatkitNoAd(int i)
    {
        AkLog.d("AATKitDelegate", (new StringBuilder()).append("ATKitNoAd ").append(i).toString());
        if (i == rewardedInterstitialId)
        {
            mRewardedVideoState = 0;
        }
        for (Iterator iterator = aAtkitlisteners.iterator(); iterator.hasNext(); ((com.intentsoftware.addapptr.AATKit.Delegate)iterator.next()).aatkitNoAd(i)) { }
    }

    public void aatkitObtainedAdRules(boolean flag)
    {
        AkLog.d("AATKitDelegate", (new StringBuilder()).append("ATKitObtainedAdRules ").append(flag).toString());
        for (Iterator iterator = aAtkitlisteners.iterator(); iterator.hasNext(); ((com.intentsoftware.addapptr.AATKit.Delegate)iterator.next()).aatkitObtainedAdRules(flag)) { }
    }

    public void aatkitPauseForAd(int i)
    {
        AkLog.d("AATKitDelegate", (new StringBuilder()).append("ATKitPauseForAd ").append(i).toString());
        if (i == questionBannerId || i == questionBannerTabletId)
        {
            AkLog.d("AkiBanner", "aatkitpause for ad");
            AkGameFactory.sharedInstance().setClickedBanner(true);
        }
        for (Iterator iterator = aAtkitlisteners.iterator(); iterator.hasNext(); ((com.intentsoftware.addapptr.AATKit.Delegate)iterator.next()).aatkitPauseForAd(i)) { }
    }

    public void aatkitResumeAfterAd(int i)
    {
        AkLog.d("AATKitDelegate", (new StringBuilder()).append("ATKitResumeAfterAd ").append(i).toString());
        for (Iterator iterator = aAtkitlisteners.iterator(); iterator.hasNext(); ((com.intentsoftware.addapptr.AATKit.Delegate)iterator.next()).aatkitResumeAfterAd(i)) { }
    }

    public void aatkitShowingEmpty(int i)
    {
        AkLog.d("AATKitDelegate", (new StringBuilder()).append("ATKitShowingAmpty ").append(i).toString());
        for (Iterator iterator = aAtkitlisteners.iterator(); iterator.hasNext(); ((com.intentsoftware.addapptr.AATKit.Delegate)iterator.next()).aatkitShowingEmpty(i)) { }
    }

    public void aatkitUnknownBundleId()
    {
        AkLog.d("AATKitDelegate", "ATKitUnknownBundleId");
        for (Iterator iterator = aAtkitlisteners.iterator(); iterator.hasNext(); ((com.intentsoftware.addapptr.AATKit.Delegate)iterator.next()).aatkitUnknownBundleId()) { }
    }

    public void aatkitUserEarnedIncentive(int i)
    {
        AkLog.d("AATKitDelegate", (new StringBuilder()).append("ATKitEarnedIncentive ").append(i).toString());
        AkPlayerBelongingsFactory.sharedInstance().depositGeniz(700);
        MetricsSetAdapter.sharedInstance().incMetricCompteur("video_views");
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricCompteur("gz_gain_video", 700);
        for (Iterator iterator = aAtkitlisteners.iterator(); iterator.hasNext(); ((com.intentsoftware.addapptr.AATKit.Delegate)iterator.next()).aatkitUserEarnedIncentive(i)) { }
    }

    public void addListener(com.intentsoftware.addapptr.AATKit.Delegate delegate1)
    {
        aAtkitlisteners.add(delegate1);
    }

    public int getAAtkitPlacementId(int i)
    {
        switch (i)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return -1;

        case 2: // '\002'
            return launchInterstitialId;

        case 8: // '\b'
            return questionBannerId;

        case 9: // '\t'
            return questionBannerTabletId;

        case 10: // '\n'
            return rewardedInterstitialId;
        }
    }

    public int getVideoRewardedState()
    {
        return mRewardedVideoState;
    }

    protected void processOnApplicationCreate()
    {
        Hashtable hashtable;
        if ("release".equals("debug"))
        {
            AATKit.init(application, this);
        } else
        {
            AATKit.initWithoutDebugScreen(application, this);
        }
        launchInterstitialId = AATKit.createPlacement("Launch_Interstitial", PlacementSize.Fullscreen);
        questionBannerId = AATKit.createPlacement("Questions_Banner", PlacementSize.Banner320x53);
        questionBannerTabletId = AATKit.createPlacement("Questions_Banner_Tablet", PlacementSize.Banner768x90);
        rewardedInterstitialId = AATKit.createPlacement("Rewarded_Video_Interstitial", PlacementSize.Fullscreen);
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            DataBerries.initialize("bc3cb5dc3b83acede51ec532592c78f51d34408c", application);
        }
        hashtable = new Hashtable();
        hashtable.put("TJC_OPTION_ENABLE_LOGGING", "true");
        AkLog.d("AkinatorTapjoy", "Tapjoy connect");
        try
        {
            Tapjoy.connect(application, "g0FHdVPoQ-CPFMXDPicgewEC26fblO9kphBo5axL5Ynmp8cS-R2GaZQ6YShW", hashtable, AkPlayerBelongingsFactory.sharedInstance());
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void removeListener(com.intentsoftware.addapptr.AATKit.Delegate delegate1)
    {
        aAtkitlisteners.remove(delegate1);
    }

    protected void setApplication(AkApplication akapplication)
    {
        application = akapplication;
    }

}
