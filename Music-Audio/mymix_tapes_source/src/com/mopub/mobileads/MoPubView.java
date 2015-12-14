// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import com.mopub.common.AdFormat;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Visibility;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import com.mopub.mobileads.factories.CustomEventBannerAdapterFactory;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.mopub.mobileads:
//            AdViewController, CustomEventBannerAdapter, MoPubErrorCode

public class MoPubView extends FrameLayout
{
    public static interface BannerAdListener
    {

        public abstract void onBannerClicked(MoPubView mopubview);

        public abstract void onBannerCollapsed(MoPubView mopubview);

        public abstract void onBannerExpanded(MoPubView mopubview);

        public abstract void onBannerFailed(MoPubView mopubview, MoPubErrorCode mopuberrorcode);

        public abstract void onBannerLoaded(MoPubView mopubview);
    }


    protected AdViewController mAdViewController;
    private BannerAdListener mBannerAdListener;
    private Context mContext;
    protected CustomEventBannerAdapter mCustomEventBannerAdapter;
    private BroadcastReceiver mScreenStateReceiver;
    private int mScreenVisibility;

    public MoPubView(Context context)
    {
        this(context, null);
    }

    public MoPubView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ManifestUtils.checkWebViewActivitiesDeclared(context);
        mContext = context;
        mScreenVisibility = getVisibility();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (WebViewDatabase.getInstance(context) == null)
        {
            MoPubLog.e("Disabling MoPub. Local cache file is inaccessible so MoPub will fail if we try to create a WebView. Details of this Android bug found at:http://code.google.com/p/android/issues/detail?id=10789");
            return;
        } else
        {
            mAdViewController = AdViewControllerFactory.create(context, this);
            registerScreenStateBroadcastReceiver();
            return;
        }
    }

    private void registerScreenStateBroadcastReceiver()
    {
        mScreenStateReceiver = new BroadcastReceiver() {

            final MoPubView this$0;

            public void onReceive(Context context, Intent intent)
            {
                if (Visibility.isScreenVisible(mScreenVisibility) && intent != null)
                {
                    context = intent.getAction();
                    if ("android.intent.action.USER_PRESENT".equals(context))
                    {
                        setAdVisibility(0);
                        return;
                    }
                    if ("android.intent.action.SCREEN_OFF".equals(context))
                    {
                        setAdVisibility(8);
                        return;
                    }
                }
            }

            
            {
                this$0 = MoPubView.this;
                super();
            }
        };
        IntentFilter intentfilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentfilter.addAction("android.intent.action.USER_PRESENT");
        mContext.registerReceiver(mScreenStateReceiver, intentfilter);
    }

    private void setAdVisibility(int i)
    {
        if (mAdViewController == null)
        {
            return;
        }
        if (Visibility.isScreenVisible(i))
        {
            mAdViewController.unpauseRefresh();
            return;
        } else
        {
            mAdViewController.pauseRefresh();
            return;
        }
    }

    private void unregisterScreenStateBroadcastReceiver()
    {
        try
        {
            mContext.unregisterReceiver(mScreenStateReceiver);
            return;
        }
        catch (Exception exception)
        {
            MoPubLog.d("Failed to unregister screen state broadcast receiver (never registered).");
        }
    }

    protected void adClicked()
    {
        if (mBannerAdListener != null)
        {
            mBannerAdListener.onBannerClicked(this);
        }
    }

    protected void adClosed()
    {
        if (mBannerAdListener != null)
        {
            mBannerAdListener.onBannerCollapsed(this);
        }
    }

    protected void adFailed(MoPubErrorCode mopuberrorcode)
    {
        if (mBannerAdListener != null)
        {
            mBannerAdListener.onBannerFailed(this, mopuberrorcode);
        }
    }

    protected void adLoaded()
    {
        MoPubLog.d("adLoaded");
        if (mBannerAdListener != null)
        {
            mBannerAdListener.onBannerLoaded(this);
        }
    }

    protected void adPresentedOverlay()
    {
        if (mBannerAdListener != null)
        {
            mBannerAdListener.onBannerExpanded(this);
        }
    }

    public void destroy()
    {
        unregisterScreenStateBroadcastReceiver();
        removeAllViews();
        if (mAdViewController != null)
        {
            mAdViewController.cleanup();
            mAdViewController = null;
        }
        if (mCustomEventBannerAdapter != null)
        {
            mCustomEventBannerAdapter.invalidate();
            mCustomEventBannerAdapter = null;
        }
    }

    public void forceRefresh()
    {
        if (mCustomEventBannerAdapter != null)
        {
            mCustomEventBannerAdapter.invalidate();
            mCustomEventBannerAdapter = null;
        }
        if (mAdViewController != null)
        {
            mAdViewController.forceRefresh();
        }
    }

    public Activity getActivity()
    {
        return (Activity)mContext;
    }

    public AdFormat getAdFormat()
    {
        return AdFormat.BANNER;
    }

    public int getAdHeight()
    {
        if (mAdViewController != null)
        {
            return mAdViewController.getAdHeight();
        } else
        {
            return 0;
        }
    }

    Integer getAdTimeoutDelay()
    {
        if (mAdViewController != null)
        {
            return mAdViewController.getAdTimeoutDelay();
        } else
        {
            return null;
        }
    }

    public String getAdUnitId()
    {
        if (mAdViewController != null)
        {
            return mAdViewController.getAdUnitId();
        } else
        {
            return null;
        }
    }

    AdViewController getAdViewController()
    {
        return mAdViewController;
    }

    public int getAdWidth()
    {
        if (mAdViewController != null)
        {
            return mAdViewController.getAdWidth();
        } else
        {
            return 0;
        }
    }

    public boolean getAutorefreshEnabled()
    {
        if (mAdViewController != null)
        {
            return mAdViewController.getAutorefreshEnabled();
        } else
        {
            MoPubLog.d("Can't get autorefresh status for destroyed MoPubView. Returning false.");
            return false;
        }
    }

    public BannerAdListener getBannerAdListener()
    {
        return mBannerAdListener;
    }

    public String getClickTrackingUrl()
    {
        return null;
    }

    public String getKeywords()
    {
        if (mAdViewController != null)
        {
            return mAdViewController.getKeywords();
        } else
        {
            return null;
        }
    }

    public Map getLocalExtras()
    {
        if (mAdViewController != null)
        {
            return mAdViewController.getLocalExtras();
        } else
        {
            return new TreeMap();
        }
    }

    public Location getLocation()
    {
        if (mAdViewController != null)
        {
            return mAdViewController.getLocation();
        } else
        {
            return null;
        }
    }

    public String getResponseString()
    {
        return null;
    }

    public boolean getTesting()
    {
        if (mAdViewController != null)
        {
            return mAdViewController.getTesting();
        } else
        {
            MoPubLog.d("Can't get testing status for destroyed MoPubView. Returning false.");
            return false;
        }
    }

    public void loadAd()
    {
        if (mAdViewController != null)
        {
            mAdViewController.loadAd();
        }
    }

    protected void loadCustomEvent(String s, Map map)
    {
        if (mAdViewController == null)
        {
            return;
        }
        if (TextUtils.isEmpty(s))
        {
            MoPubLog.d("Couldn't invoke custom event because the server did not specify one.");
            loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        if (mCustomEventBannerAdapter != null)
        {
            mCustomEventBannerAdapter.invalidate();
        }
        MoPubLog.d("Loading custom event adapter.");
        mCustomEventBannerAdapter = CustomEventBannerAdapterFactory.create(this, s, map, mAdViewController.getBroadcastIdentifier(), mAdViewController.getAdReport());
        mCustomEventBannerAdapter.loadAd();
    }

    protected void loadFailUrl(MoPubErrorCode mopuberrorcode)
    {
        if (mAdViewController != null)
        {
            mAdViewController.loadFailUrl(mopuberrorcode);
        }
    }

    protected void nativeAdLoaded()
    {
        if (mAdViewController != null)
        {
            mAdViewController.scheduleRefreshTimerIfEnabled();
        }
        adLoaded();
    }

    protected void onWindowVisibilityChanged(int i)
    {
        if (Visibility.hasScreenVisibilityChanged(mScreenVisibility, i))
        {
            mScreenVisibility = i;
            setAdVisibility(mScreenVisibility);
        }
    }

    protected void registerClick()
    {
        if (mAdViewController != null)
        {
            mAdViewController.registerClick();
            adClicked();
        }
    }

    public void setAdContentView(View view)
    {
        if (mAdViewController != null)
        {
            mAdViewController.setAdContentView(view);
        }
    }

    public void setAdUnitId(String s)
    {
        if (mAdViewController != null)
        {
            mAdViewController.setAdUnitId(s);
        }
    }

    public void setAutorefreshEnabled(boolean flag)
    {
        if (mAdViewController != null)
        {
            mAdViewController.forceSetAutorefreshEnabled(flag);
        }
    }

    public void setBannerAdListener(BannerAdListener banneradlistener)
    {
        mBannerAdListener = banneradlistener;
    }

    public void setKeywords(String s)
    {
        if (mAdViewController != null)
        {
            mAdViewController.setKeywords(s);
        }
    }

    public void setLocalExtras(Map map)
    {
        if (mAdViewController != null)
        {
            mAdViewController.setLocalExtras(map);
        }
    }

    public void setLocation(Location location)
    {
        if (mAdViewController != null)
        {
            mAdViewController.setLocation(location);
        }
    }

    public void setTesting(boolean flag)
    {
        if (mAdViewController != null)
        {
            mAdViewController.setTesting(flag);
        }
    }

    public void setTimeout(int i)
    {
        if (mAdViewController != null)
        {
            mAdViewController.setTimeout(i);
        }
    }

    protected void trackNativeImpression()
    {
        MoPubLog.d("Tracking impression for native adapter.");
        if (mAdViewController != null)
        {
            mAdViewController.trackImpression();
        }
    }


}
