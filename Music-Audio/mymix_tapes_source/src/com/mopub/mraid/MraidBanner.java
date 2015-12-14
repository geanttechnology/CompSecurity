// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.content.Context;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.factories.MraidControllerFactory;
import java.util.Map;

// Referenced classes of package com.mopub.mraid:
//            PlacementType, MraidController, MraidWebViewDebugListener

class MraidBanner extends CustomEventBanner
{

    private com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener mBannerListener;
    private MraidWebViewDebugListener mDebugListener;
    private MraidController mMraidController;

    MraidBanner()
    {
    }

    private boolean extrasAreValid(Map map)
    {
        return map.containsKey("Html-Response-Body");
    }

    protected void loadBanner(Context context, com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener customeventbannerlistener, Map map, Map map1)
    {
        mBannerListener = customeventbannerlistener;
        if (extrasAreValid(map1))
        {
            customeventbannerlistener = (String)map1.get("Html-Response-Body");
            try
            {
                mMraidController = MraidControllerFactory.create(context, (AdReport)map.get("mopub-intent-ad-report"), PlacementType.INLINE);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MoPubLog.w("MRAID banner creating failed:", context);
                mBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
                return;
            }
            mMraidController.setDebugListener(mDebugListener);
            mMraidController.setMraidListener(new MraidController.MraidListener() {

                final MraidBanner this$0;

                public void onClose()
                {
                    mBannerListener.onBannerCollapsed();
                }

                public void onExpand()
                {
                    mBannerListener.onBannerExpanded();
                    mBannerListener.onBannerClicked();
                }

                public void onFailedToLoad()
                {
                    mBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
                }

                public void onLoaded(View view)
                {
                    AdViewController.setShouldHonorServerDimensions(view);
                    mBannerListener.onBannerLoaded(view);
                }

                public void onOpen()
                {
                    mBannerListener.onBannerClicked();
                }

            
            {
                this$0 = MraidBanner.this;
                super();
            }
            });
            mMraidController.loadContent(customeventbannerlistener);
            return;
        } else
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
            return;
        }
    }

    protected void onInvalidate()
    {
        if (mMraidController != null)
        {
            mMraidController.setMraidListener(null);
            mMraidController.destroy();
        }
    }

    public void setDebugListener(MraidWebViewDebugListener mraidwebviewdebuglistener)
    {
        mDebugListener = mraidwebviewdebuglistener;
        if (mMraidController != null)
        {
            mMraidController.setDebugListener(mraidwebviewdebuglistener);
        }
    }

}
