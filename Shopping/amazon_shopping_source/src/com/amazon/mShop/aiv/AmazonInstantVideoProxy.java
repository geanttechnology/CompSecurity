// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import amazon.android.dexload.SupplementalDexLoader;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.amazon.avod.MShopAmazonInstantVideo;
import com.amazon.avod.playbackclient.settings.page.MobileStreamingQualitySettingsFragmentFactory;
import com.amazon.avod.sdk.AmazonInstantVideo;
import com.amazon.avod.sdk.CacheLevel;
import com.amazon.avod.sdk.PlaybackSupportResponse;
import com.amazon.avod.sdk.VideoPlaybackStarter;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.mShop.aiv:
//            AIVAvailabilityUtils

public class AmazonInstantVideoProxy
{
    final class _cls1PlaybackRunnable
        implements Runnable
    {

        final AmazonInstantVideoProxy this$0;
        final Activity val$activity;
        final String val$asin;
        final long val$timecode;
        final com.amazon.avod.sdk.Constants.UrlType val$urlType;

        public void run()
        {
            mMShopAmazonInstantVideo.refreshUserData();
            AmazonInstantVideo amazoninstantvideo = new AmazonInstantVideo(activity);
            amazoninstantvideo.play(asin, urlType).withRefMarker("sdk_3p").withResumeTimecode(timecode).start();
            amazoninstantvideo.cleanup();
        }

        _cls1PlaybackRunnable()
        {
            this$0 = AmazonInstantVideoProxy.this;
            activity = activity1;
            asin = s;
            urlType = urltype;
            timecode = l;
            super();
        }
    }

    private class AIVInitializationRunnable
        implements Runnable
    {

        final AmazonInstantVideoProxy this$0;

        private Object initializeReflectively(String s, Context context)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
        {
            Log.d("AmazonApplication", (new StringBuilder()).append("loading and initializing class ").append(s).toString());
            s = ((String) (SecondDexEntry.getInstance().getClassLoader().loadClass(s).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0])));
            s.getClass().getDeclaredMethod("initialize", new Class[] {
                android/content/Context
            }).invoke(s, new Object[] {
                context
            });
            return s;
        }

        public void run()
        {
            boolean flag = false;
            SupplementalDexLoader.getInstance().waitForLoad();
            mMShopAmazonInstantVideo = (MShopAmazonInstantVideo)initializeReflectively("com.amazon.avod.MShopAmazonInstantVideoDelegate", mApplicationContext);
            mMobileStreamingQualitySettingsFragmentFactory = (MobileStreamingQualitySettingsFragmentFactory)initializeReflectively("com.amazon.avod.playbackclient.settings.page.MobileStreamingQualitySettingsFragmentFactoryDelegate", mApplicationContext);
            AmazonInstantVideo amazoninstantvideo = new AmazonInstantVideo(mApplicationContext);
            amazoninstantvideo.queryPlaybackSupport(new PlaybackSupportResponse() {

                final AIVInitializationRunnable this$1;

                public void onPlaybackSupport(com.amazon.avod.sdk.PlaybackSupportResponse.PlaybackSupport playbacksupport)
                {
                    mIsSupported = playbacksupport.isPlaybackSupported();
                    mIsSustainable = playbacksupport.isPlaybackSustainable();
                }

            
            {
                this$1 = AIVInitializationRunnable.this;
                super();
            }
            });
            amazoninstantvideo.cleanup();
            flag = true;
_L2:
            mAivInitializedLatch.countDown();
            AIVAvailabilityUtils.setIsAIVInitialized(flag);
            return;
            Exception exception;
            exception;
            Log.e("AmazonApplication", "AIV initialization failed, falling back to silently disabling AIV integration", exception);
            mMShopAmazonInstantVideo = new MShopNoopAmazonInstantVideo();
            mMobileStreamingQualitySettingsFragmentFactory = new NoopMobileStreamingQualitySettingsFragmentFactory();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public AIVInitializationRunnable(Context context)
        {
            this$0 = AmazonInstantVideoProxy.this;
            super();
            mApplicationContext = context;
        }
    }

    private static class MShopNoopAmazonInstantVideo
        implements MShopAmazonInstantVideo
    {

        public void forceRefreshAccount()
        {
        }

        public List getGroverRecommendations()
        {
            return Collections.emptyList();
        }

        public long getGroverRecommendationsTTLMillis()
        {
            return 0L;
        }

        public boolean isAIVBeta()
        {
            return false;
        }

        public boolean isPlaybackSustainable()
        {
            return false;
        }

        public boolean isSupported()
        {
            return false;
        }

        public void refreshUserData()
        {
        }

        public void startPlayback(Activity activity, String s, long l)
        {
        }

        public void startTrailer(Activity activity, String s)
        {
        }

        public void verifyAndroidRuntime(Activity activity, Runnable runnable)
        {
        }

        public void whisperCache(List list)
        {
        }

        private MShopNoopAmazonInstantVideo()
        {
        }

    }

    private static class NoopMobileStreamingQualitySettingsFragmentFactory
        implements MobileStreamingQualitySettingsFragmentFactory
    {

        public Fragment createInstance()
        {
            return new Fragment();
        }

        private NoopMobileStreamingQualitySettingsFragmentFactory()
        {
        }

    }

    private static class SingletonHolder
    {

        private static final AmazonInstantVideoProxy INSTANCE = new AmazonInstantVideoProxy();



        private SingletonHolder()
        {
        }
    }


    private static final String SDK_REF_MARKER = "sdk_3p";
    private static final String TAG = "AmazonApplication";
    private static final long USE_AIV_TIMECODE = -1L;
    private final CountDownLatch mAivInitializedLatch = new CountDownLatch(1);
    private Context mApplicationContext;
    private final AtomicBoolean mInitializationStarted = new AtomicBoolean(false);
    private volatile boolean mIsSupported;
    private volatile boolean mIsSustainable;
    private MShopAmazonInstantVideo mMShopAmazonInstantVideo;
    private MobileStreamingQualitySettingsFragmentFactory mMobileStreamingQualitySettingsFragmentFactory;

    public AmazonInstantVideoProxy()
    {
    }

    public static AmazonInstantVideoProxy getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private void playContent(final Activity activity, final String asin, final com.amazon.avod.sdk.Constants.UrlType urlType, final long timecode)
    {
        mMShopAmazonInstantVideo.verifyAndroidRuntime(activity, new _cls1PlaybackRunnable());
    }

    public Fragment createMainSettingsFragment()
    {
        Uninterruptibles.awaitUninterruptibly(mAivInitializedLatch);
        return mMobileStreamingQualitySettingsFragmentFactory.createInstance();
    }

    public void forceRefreshAccount()
    {
        Uninterruptibles.awaitUninterruptibly(mAivInitializedLatch);
        mMShopAmazonInstantVideo.forceRefreshAccount();
    }

    public List getGroverRecommendations()
    {
        Uninterruptibles.awaitUninterruptibly(mAivInitializedLatch);
        return mMShopAmazonInstantVideo.getGroverRecommendations();
    }

    public long getGroverRecommendationsTTLMillis()
    {
        Uninterruptibles.awaitUninterruptibly(mAivInitializedLatch);
        return mMShopAmazonInstantVideo.getGroverRecommendationsTTLMillis();
    }

    public void initializeAIV(Context context)
    {
        if (mInitializationStarted.getAndSet(true))
        {
            throw new IllegalStateException("AIV initialization can only be called once");
        } else
        {
            (new Thread(new AIVInitializationRunnable(context))).start();
            return;
        }
    }

    public boolean isAIVBeta()
    {
        Uninterruptibles.awaitUninterruptibly(mAivInitializedLatch);
        return mMShopAmazonInstantVideo.isAIVBeta();
    }

    public boolean isPlaybackSustainable()
    {
        Uninterruptibles.awaitUninterruptibly(mAivInitializedLatch);
        return mIsSustainable;
    }

    public boolean isSupported()
    {
        Uninterruptibles.awaitUninterruptibly(mAivInitializedLatch);
        return mIsSupported;
    }

    public void startPlayback(Activity activity, String s, long l)
    {
        Uninterruptibles.awaitUninterruptibly(mAivInitializedLatch);
        if (l != 0L)
        {
            l = -1L;
        }
        playContent(activity, s, com.amazon.avod.sdk.Constants.UrlType.CONTENT, l);
    }

    public void startTrailer(Activity activity, String s)
    {
        Uninterruptibles.awaitUninterruptibly(mAivInitializedLatch);
        playContent(activity, s, com.amazon.avod.sdk.Constants.UrlType.TRAILER, 0L);
    }

    public void whisperCache(List list)
    {
        Uninterruptibles.awaitUninterruptibly(mAivInitializedLatch);
        mMShopAmazonInstantVideo.refreshUserData();
        AmazonInstantVideo amazoninstantvideo = new AmazonInstantVideo(mApplicationContext);
        amazoninstantvideo.whisperCacheContent(list, CacheLevel.L1);
        amazoninstantvideo.cleanup();
    }



/*
    static Context access$102(AmazonInstantVideoProxy amazoninstantvideoproxy, Context context)
    {
        amazoninstantvideoproxy.mApplicationContext = context;
        return context;
    }

*/



/*
    static MShopAmazonInstantVideo access$202(AmazonInstantVideoProxy amazoninstantvideoproxy, MShopAmazonInstantVideo mshopamazoninstantvideo)
    {
        amazoninstantvideoproxy.mMShopAmazonInstantVideo = mshopamazoninstantvideo;
        return mshopamazoninstantvideo;
    }

*/


/*
    static MobileStreamingQualitySettingsFragmentFactory access$302(AmazonInstantVideoProxy amazoninstantvideoproxy, MobileStreamingQualitySettingsFragmentFactory mobilestreamingqualitysettingsfragmentfactory)
    {
        amazoninstantvideoproxy.mMobileStreamingQualitySettingsFragmentFactory = mobilestreamingqualitysettingsfragmentfactory;
        return mobilestreamingqualitysettingsfragmentfactory;
    }

*/


/*
    static boolean access$402(AmazonInstantVideoProxy amazoninstantvideoproxy, boolean flag)
    {
        amazoninstantvideoproxy.mIsSupported = flag;
        return flag;
    }

*/


/*
    static boolean access$502(AmazonInstantVideoProxy amazoninstantvideoproxy, boolean flag)
    {
        amazoninstantvideoproxy.mIsSustainable = flag;
        return flag;
    }

*/

}
