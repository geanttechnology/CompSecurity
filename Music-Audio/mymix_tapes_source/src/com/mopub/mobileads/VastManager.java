// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CacheService;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoConfig, VastXmlManagerAggregator, VideoDownloader

public class VastManager
    implements VastXmlManagerAggregator.VastXmlManagerAggregatorListener
{
    public static interface VastManagerListener
    {

        public abstract void onVastVideoConfigurationPrepared(VastVideoConfig vastvideoconfig);
    }


    private int mScreenAreaDp;
    private double mScreenAspectRatio;
    private final boolean mShouldPreCacheVideo;
    private VastManagerListener mVastManagerListener;
    private VastXmlManagerAggregator mVastXmlManagerAggregator;

    public VastManager(Context context, boolean flag)
    {
        initializeScreenDimensions(context);
        mShouldPreCacheVideo = flag;
    }

    private void initializeScreenDimensions(Context context)
    {
        Preconditions.checkNotNull(context, "context cannot be null");
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        int j = display.getWidth();
        int k = display.getHeight();
        float f1 = context.getResources().getDisplayMetrics().density;
        float f = f1;
        if (f1 <= 0.0F)
        {
            f = 1.0F;
        }
        int i = Math.max(j, k);
        j = Math.min(j, k);
        mScreenAspectRatio = (double)i / (double)j;
        mScreenAreaDp = (int)(((float)i / f) * ((float)j / f));
    }

    private boolean updateDiskMediaFileUrl(VastVideoConfig vastvideoconfig)
    {
        Preconditions.checkNotNull(vastvideoconfig, "vastVideoConfig cannot be null");
        String s = vastvideoconfig.getNetworkMediaFileUrl();
        if (CacheService.containsKeyDiskCache(s))
        {
            vastvideoconfig.setDiskMediaFileUrl(CacheService.getFilePathDiskCache(s));
            return true;
        } else
        {
            return false;
        }
    }

    public void cancel()
    {
        if (mVastXmlManagerAggregator != null)
        {
            mVastXmlManagerAggregator.cancel(true);
            mVastXmlManagerAggregator = null;
        }
    }

    int getScreenAreaDp()
    {
        return mScreenAreaDp;
    }

    double getScreenAspectRatio()
    {
        return mScreenAspectRatio;
    }

    public void onAggregationComplete(final VastVideoConfig vastVideoConfig)
    {
        if (mVastManagerListener == null)
        {
            throw new IllegalStateException("mVastManagerListener cannot be null here. Did you call prepareVastVideoConfiguration()?");
        }
        if (vastVideoConfig == null)
        {
            mVastManagerListener.onVastVideoConfigurationPrepared(null);
            return;
        }
        if (!mShouldPreCacheVideo || updateDiskMediaFileUrl(vastVideoConfig))
        {
            mVastManagerListener.onVastVideoConfigurationPrepared(vastVideoConfig);
            return;
        } else
        {
            VideoDownloader.VideoDownloaderListener videodownloaderlistener = new VideoDownloader.VideoDownloaderListener() {

                final VastManager this$0;
                final VastVideoConfig val$vastVideoConfig;

                public void onComplete(boolean flag)
                {
                    if (flag && updateDiskMediaFileUrl(vastVideoConfig))
                    {
                        mVastManagerListener.onVastVideoConfigurationPrepared(vastVideoConfig);
                        return;
                    } else
                    {
                        MoPubLog.d("Failed to download VAST video.");
                        mVastManagerListener.onVastVideoConfigurationPrepared(null);
                        return;
                    }
                }

            
            {
                this$0 = VastManager.this;
                vastVideoConfig = vastvideoconfig;
                super();
            }
            };
            VideoDownloader.cache(vastVideoConfig.getNetworkMediaFileUrl(), videodownloaderlistener);
            return;
        }
    }

    public void prepareVastVideoConfiguration(String s, VastManagerListener vastmanagerlistener, Context context)
    {
        Preconditions.checkNotNull(vastmanagerlistener, "vastManagerListener cannot be null");
        Preconditions.checkNotNull(context, "context cannot be null");
        if (mVastXmlManagerAggregator != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        mVastManagerListener = vastmanagerlistener;
        mVastXmlManagerAggregator = new VastXmlManagerAggregator(this, mScreenAspectRatio, mScreenAreaDp, context.getApplicationContext());
        AsyncTasks.safeExecuteOnExecutor(mVastXmlManagerAggregator, new String[] {
            s
        });
        return;
        s;
        MoPubLog.d("Failed to aggregate vast xml", s);
        mVastManagerListener.onVastVideoConfigurationPrepared(null);
        return;
    }


}
