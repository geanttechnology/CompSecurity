// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.rendering.RenderView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            l, k, b, InMobiAdRequestStatus, 
//            j

public final class InMobiBanner extends RelativeLayout
{
    public static final class AnimationType extends Enum
    {

        private static final AnimationType $VALUES[];
        public static final AnimationType ANIMATION_ALPHA;
        public static final AnimationType ANIMATION_OFF;
        public static final AnimationType ROTATE_HORIZONTAL_AXIS;
        public static final AnimationType ROTATE_VERTICAL_AXIS;

        public static AnimationType valueOf(String s)
        {
            return (AnimationType)Enum.valueOf(com/inmobi/ads/InMobiBanner$AnimationType, s);
        }

        public static AnimationType[] values()
        {
            return (AnimationType[])$VALUES.clone();
        }

        static 
        {
            ANIMATION_OFF = new AnimationType("ANIMATION_OFF", 0);
            ROTATE_HORIZONTAL_AXIS = new AnimationType("ROTATE_HORIZONTAL_AXIS", 1);
            ANIMATION_ALPHA = new AnimationType("ANIMATION_ALPHA", 2);
            ROTATE_VERTICAL_AXIS = new AnimationType("ROTATE_VERTICAL_AXIS", 3);
            $VALUES = (new AnimationType[] {
                ANIMATION_OFF, ROTATE_HORIZONTAL_AXIS, ANIMATION_ALPHA, ROTATE_VERTICAL_AXIS
            });
        }

        private AnimationType(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface BannerAdListener
    {

        public abstract void onAdDismissed(InMobiBanner inmobibanner);

        public abstract void onAdDisplayed(InMobiBanner inmobibanner);

        public abstract void onAdInteraction(InMobiBanner inmobibanner, Map map);

        public abstract void onAdLoadFailed(InMobiBanner inmobibanner, InMobiAdRequestStatus inmobiadrequeststatus);

        public abstract void onAdLoadSucceeded(InMobiBanner inmobibanner);

        public abstract void onAdRewardActionCompleted(InMobiBanner inmobibanner, Map map);

        public abstract void onUserLeftApplication(InMobiBanner inmobibanner);
    }

    private static interface a
    {

        public abstract void a();
    }

    private static final class b extends Handler
    {

        private WeakReference a;
        private WeakReference b;

        public void a(BannerAdListener banneradlistener)
        {
            a = new WeakReference(banneradlistener);
        }

        public void handleMessage(Message message)
        {
            Object obj;
            InMobiBanner inmobibanner;
            BannerAdListener banneradlistener;
label0:
            {
label1:
                {
                    Map map;
label2:
                    {
label3:
                        {
label4:
                            {
label5:
                                {
label6:
                                    {
                                        obj = null;
                                        map = null;
                                        inmobibanner = (InMobiBanner)b.get();
                                        banneradlistener = (BannerAdListener)a.get();
                                        if (inmobibanner != null && banneradlistener != null)
                                        {
                                            switch (message.what)
                                            {
                                            default:
                                                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, InMobiBanner.TAG, "Unhandled ad lifecycle event! Ignoring ...");
                                                break;

                                            case 1: // '\001'
                                                break label6;

                                            case 2: // '\002'
                                                break label5;

                                            case 3: // '\003'
                                                break label4;

                                            case 4: // '\004'
                                                break label3;

                                            case 5: // '\005'
                                                break label2;

                                            case 6: // '\006'
                                                break label1;

                                            case 7: // '\007'
                                                break label0;
                                            }
                                        }
                                        return;
                                    }
                                    banneradlistener.onAdLoadSucceeded(inmobibanner);
                                    return;
                                }
                                banneradlistener.onAdLoadFailed(inmobibanner, (InMobiAdRequestStatus)message.obj);
                                return;
                            }
                            banneradlistener.onAdDisplayed(inmobibanner);
                            return;
                        }
                        banneradlistener.onAdDismissed(inmobibanner);
                        return;
                    }
                    if (message.obj != null)
                    {
                        map = (Map)message.obj;
                    }
                    banneradlistener.onAdInteraction(inmobibanner, map);
                    return;
                }
                banneradlistener.onUserLeftApplication(inmobibanner);
                return;
            }
            Map map1 = obj;
            if (message.obj != null)
            {
                map1 = (Map)message.obj;
            }
            banneradlistener.onAdRewardActionCompleted(inmobibanner, map1);
        }

        public b(InMobiBanner inmobibanner, BannerAdListener banneradlistener)
        {
            super(Looper.getMainLooper());
            b = new WeakReference(inmobibanner);
            a = new WeakReference(banneradlistener);
        }
    }


    private static final String TAG = com/inmobi/ads/InMobiBanner.getSimpleName();
    private long mAdLoadCalledTimestamp;
    private AnimationType mAnimationType;
    private k mBackgroundBannerAdUnit;
    private final AdUnit.a mBannerAdListener;
    private k mBannerAdUnit1;
    private k mBannerAdUnit2;
    private int mBannerHeightInDp;
    private int mBannerWidthInDp;
    private b mClientCallbackHandler;
    private BannerAdListener mClientListener;
    private k mForegroundBannerAdUnit;
    private boolean mIsAutoRefreshEnabled;
    private boolean mIsInitialized;
    private l mRefreshHandler;
    private int mRefreshInterval;

    public InMobiBanner(Context context, long l1)
    {
        super(context);
        mIsInitialized = false;
        mIsAutoRefreshEnabled = true;
        mBannerWidthInDp = 0;
        mBannerHeightInDp = 0;
        mAnimationType = AnimationType.ROTATE_HORIZONTAL_AXIS;
        mAdLoadCalledTimestamp = 0L;
        mBannerAdListener = new AdUnit.a() {

            final InMobiBanner a;

            public void a()
            {
                if (a.mForegroundBannerAdUnit == null || !a.mForegroundBannerAdUnit.z())
                {
                    a.swapAdUnitsAndDisplayAd(new a(this) {

                        final _cls4 a;

                        public void a()
                        {
                            a.a.mClientCallbackHandler.sendEmptyMessage(1);
                            a.a.scheduleRefresh();
                        }

            
            {
                a = _pcls4;
                super();
            }
                    });
                }
            }

            public void a(InMobiAdRequestStatus inmobiadrequeststatus)
            {
                Message message = Message.obtain();
                message.what = 2;
                message.obj = inmobiadrequeststatus;
                a.mClientCallbackHandler.sendMessage(message);
                a.scheduleRefresh();
            }

            public void a(Map map)
            {
                Message message = Message.obtain();
                message.what = 5;
                message.obj = map;
                a.mClientCallbackHandler.sendMessage(message);
            }

            public void b()
            {
                a.mClientCallbackHandler.sendEmptyMessage(3);
            }

            public void b(Map map)
            {
                Message message = Message.obtain();
                message.what = 7;
                message.obj = map;
                a.mClientCallbackHandler.sendMessage(message);
            }

            public void c()
            {
                a.scheduleRefresh();
                a.mClientCallbackHandler.sendEmptyMessage(4);
            }

            public void d()
            {
                a.mClientCallbackHandler.sendEmptyMessage(6);
            }

            
            {
                a = InMobiBanner.this;
                super();
            }
        };
        if (context == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Context supplied as null, the ad unit can't be created.");
            return;
        }
        if (!com.inmobi.commons.a.a.a())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Please initialize the SDK before trying to create an ad.");
            return;
        } else
        {
            mClientCallbackHandler = new b(this, mClientListener);
            initializeAdUnit(context, l1);
            return;
        }
    }

    public InMobiBanner(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsInitialized = false;
        mIsAutoRefreshEnabled = true;
        mBannerWidthInDp = 0;
        mBannerHeightInDp = 0;
        mAnimationType = AnimationType.ROTATE_HORIZONTAL_AXIS;
        mAdLoadCalledTimestamp = 0L;
        mBannerAdListener = new _cls4();
        if (!com.inmobi.commons.a.a.a())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Please initialize the SDK before trying to create an ad.");
        } else
        {
            mClientCallbackHandler = new b(this, mClientListener);
            String s = attributeset.getAttributeValue("http://schemas.android.com/apk/lib/com.inmobi.ads", "placementId");
            attributeset = attributeset.getAttributeValue("http://schemas.android.com/apk/lib/com.inmobi.ads", "refreshInterval");
            if (s != null)
            {
                try
                {
                    initializeAdUnit(context, Long.parseLong(s.trim()));
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put("errorCode", "InvalidPlacement");
                    hashmap.put("type", "banner");
                    com.inmobi.commons.core.c.a.a().a("ads", "AdLoadFailed", hashmap);
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Placement id value supplied in XML layout is not valid. Banner creation failed.", context);
                }
            } else
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Placement id value is not supplied in XML layout. Banner creation failed.");
            }
            if (attributeset != null)
            {
                try
                {
                    setRefreshInterval(Integer.parseInt(attributeset.trim()));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Refresh interval value supplied in XML layout is not valid. Falling back to default value.", context);
                }
                return;
            }
        }
    }

    private void cancelScheduledRefresh()
    {
        mRefreshHandler.removeMessages(1);
    }

    private final boolean checkForRefreshRate()
    {
        if (mAdLoadCalledTimestamp != 0L)
        {
            int i = mBackgroundBannerAdUnit.l().f();
            if (SystemClock.elapsedRealtime() - mAdLoadCalledTimestamp < (long)(i * 1000))
            {
                mBackgroundBannerAdUnit.a((new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST)).setCustomMessage((new StringBuilder()).append("Ad cannot be refreshed before ").append(i).append(" seconds").toString()), false);
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, (new StringBuilder()).append("Ad cannot be refreshed before ").append(i).append(" seconds").toString());
                return false;
            }
        }
        mAdLoadCalledTimestamp = SystemClock.elapsedRealtime();
        return true;
    }

    private void displayAd()
    {
        if (mForegroundBannerAdUnit.y())
        {
            mForegroundBannerAdUnit.n().o();
        }
        ViewGroup viewgroup = (ViewGroup)mForegroundBannerAdUnit.n().getParent();
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        if (viewgroup == null)
        {
            addView(mForegroundBannerAdUnit.n(), layoutparams);
        } else
        {
            viewgroup.removeAllViews();
            viewgroup.addView(mForegroundBannerAdUnit.n(), layoutparams);
        }
        mBackgroundBannerAdUnit.t();
    }

    private void initializeAdUnit(Context context, long l1)
    {
        mBannerAdUnit1 = new k(this, context, l1, mBannerAdListener);
        mBannerAdUnit2 = new k(this, context, l1, mBannerAdListener);
        mBackgroundBannerAdUnit = mBannerAdUnit1;
        mRefreshInterval = mBackgroundBannerAdUnit.l().g();
        mRefreshHandler = new l(this);
        mIsInitialized = true;
    }

    private void scheduleRefresh()
    {
        if (isShown() && hasWindowFocus())
        {
            mRefreshHandler.removeMessages(1);
            if (mBackgroundBannerAdUnit.g() == AdUnit.AdState.STATE_LOADING || mBackgroundBannerAdUnit.g() == AdUnit.AdState.STATE_AVAILABLE || mForegroundBannerAdUnit != null && mForegroundBannerAdUnit.g() == AdUnit.AdState.STATE_ACTIVE)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, TAG, "Ignoring an attempt to schedule refresh when an ad is already loading or active.");
                return;
            }
            if (mIsAutoRefreshEnabled)
            {
                mRefreshHandler.sendEmptyMessageDelayed(1, mRefreshInterval * 1000);
                return;
            }
        }
    }

    private void setSizeFromLayoutParams()
    {
        if (getLayoutParams() != null)
        {
            mBannerWidthInDp = DisplayInfo.a(getLayoutParams().width);
            mBannerHeightInDp = DisplayInfo.a(getLayoutParams().height);
        }
    }

    private void swapAdUnitsAndDisplayAd(a a1)
    {
        Animation animation;
        if (mForegroundBannerAdUnit == null)
        {
            mForegroundBannerAdUnit = mBannerAdUnit1;
            mBackgroundBannerAdUnit = mBannerAdUnit2;
        } else
        if (mForegroundBannerAdUnit.equals(mBannerAdUnit1))
        {
            mForegroundBannerAdUnit = mBannerAdUnit2;
            mBackgroundBannerAdUnit = mBannerAdUnit1;
        } else
        if (mForegroundBannerAdUnit.equals(mBannerAdUnit2))
        {
            mForegroundBannerAdUnit = mBannerAdUnit1;
            mBackgroundBannerAdUnit = mBannerAdUnit2;
        }
        animation = com.inmobi.ads.j.a(mAnimationType, getWidth(), getHeight());
        if (animation == null)
        {
            displayAd();
            a1.a();
            return;
        } else
        {
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(a1) {

                final a a;
                final InMobiBanner b;

                public void onAnimationEnd(Animation animation1)
                {
                    b.displayAd();
                    a.a();
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

            
            {
                b = InMobiBanner.this;
                a = a1;
                super();
            }
            });
            startAnimation(animation);
            return;
        }
    }

    public void disableHardwareAcceleration()
    {
        if (mIsInitialized)
        {
            mBannerAdUnit1.x();
            mBannerAdUnit2.x();
        }
    }

    String getFrameSizeString()
    {
        return (new StringBuilder()).append(mBannerWidthInDp).append("x").append(mBannerHeightInDp).toString();
    }

    boolean hasValidSize()
    {
        return mBannerWidthInDp > 0 && mBannerHeightInDp > 0;
    }

    public void load()
    {
        load(false);
    }

    void load(boolean flag)
    {
        if (mIsInitialized)
        {
            if (getLayoutParams() == null)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "The layout params of the banner must be set before calling load");
                mBannerAdListener.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID));
            } else
            {
                if (getLayoutParams().width == -2 || getLayoutParams().height == -2)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "The height or width of a Banner ad can't be WRAP_CONTENT");
                    mBannerAdListener.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID));
                    return;
                }
                if (mForegroundBannerAdUnit != null && mForegroundBannerAdUnit.z())
                {
                    Message message = Message.obtain();
                    message.what = 2;
                    message.obj = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE);
                    mClientCallbackHandler.sendMessage(message);
                    mForegroundBannerAdUnit.c("AdActive");
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
                    return;
                }
                if (!hasValidSize())
                {
                    setSizeFromLayoutParams();
                }
                if (!hasValidSize())
                {
                    (new Handler()).postDelayed(new Runnable(flag) {

                        final boolean a;
                        final InMobiBanner b;

                        public void run()
                        {
                            if (b.hasValidSize())
                            {
                                b.cancelScheduledRefresh();
                                if (b.checkForRefreshRate())
                                {
                                    b.mBackgroundBannerAdUnit.b(a);
                                }
                                return;
                            } else
                            {
                                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, InMobiBanner.TAG, "The height or width of the banner can not be determined");
                                b.mBannerAdListener.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                                return;
                            }
                        }

            
            {
                b = InMobiBanner.this;
                a = flag;
                super();
            }
                    }, 200L);
                    return;
                }
                cancelScheduledRefresh();
                if (checkForRefreshRate())
                {
                    mBackgroundBannerAdUnit.b(flag);
                    return;
                }
            }
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mIsInitialized)
        {
            setSizeFromLayoutParams();
            if (!hasValidSize())
            {
                setupBannerSizeObserver();
            }
            scheduleRefresh();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mIsInitialized)
        {
            cancelScheduledRefresh();
        }
    }

    protected void onVisibilityChanged(View view, int i)
    {
label0:
        {
            super.onVisibilityChanged(view, i);
            if (mIsInitialized)
            {
                if (i != 0)
                {
                    break label0;
                }
                scheduleRefresh();
            }
            return;
        }
        cancelScheduledRefresh();
    }

    public void onWindowFocusChanged(boolean flag)
    {
label0:
        {
            super.onWindowFocusChanged(flag);
            if (mIsInitialized)
            {
                if (!flag)
                {
                    break label0;
                }
                scheduleRefresh();
            }
            return;
        }
        cancelScheduledRefresh();
    }

    public void setAnimationType(AnimationType animationtype)
    {
        if (mIsInitialized)
        {
            mAnimationType = animationtype;
        }
    }

    public void setEnableAutoRefresh(boolean flag)
    {
        if (!mIsInitialized || mIsAutoRefreshEnabled == flag)
        {
            return;
        }
        mIsAutoRefreshEnabled = flag;
        if (mIsAutoRefreshEnabled)
        {
            scheduleRefresh();
            return;
        } else
        {
            cancelScheduledRefresh();
            return;
        }
    }

    public void setExtras(Map map)
    {
        if (mIsInitialized)
        {
            mBannerAdUnit1.a(map);
            mBannerAdUnit2.a(map);
        }
    }

    public void setKeywords(String s)
    {
        if (mIsInitialized)
        {
            mBannerAdUnit1.a(s);
            mBannerAdUnit2.a(s);
        }
    }

    public void setListener(BannerAdListener banneradlistener)
    {
        if (banneradlistener == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Please pass a non-null listener to the banner.");
        } else
        {
            mClientListener = banneradlistener;
            if (mClientCallbackHandler != null)
            {
                mClientCallbackHandler.a(banneradlistener);
                return;
            }
        }
    }

    public void setRefreshInterval(int i)
    {
        if (mIsInitialized)
        {
            int i1 = i;
            if (i < mBackgroundBannerAdUnit.l().f())
            {
                i1 = mBackgroundBannerAdUnit.l().f();
            }
            mRefreshInterval = i1;
        }
    }

    void setupBannerSizeObserver()
    {
        getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final InMobiBanner a;

            public void onGlobalLayout()
            {
label0:
                {
                    a.mBannerWidthInDp = DisplayInfo.a(a.getMeasuredWidth());
                    a.mBannerHeightInDp = DisplayInfo.a(a.getMeasuredHeight());
                    if (a.hasValidSize())
                    {
                        if (android.os.Build.VERSION.SDK_INT < 16)
                        {
                            break label0;
                        }
                        a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    return;
                }
                a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }

            
            {
                a = InMobiBanner.this;
                super();
            }
        });
    }










/*
    static int access$502(InMobiBanner inmobibanner, int i)
    {
        inmobibanner.mBannerWidthInDp = i;
        return i;
    }

*/


/*
    static int access$602(InMobiBanner inmobibanner, int i)
    {
        inmobibanner.mBannerHeightInDp = i;
        return i;
    }

*/



}
