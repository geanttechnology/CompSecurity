// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mraid.MraidNativeCommandHandler;
import com.mopub.network.AdRequest;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

// Referenced classes of package com.mopub.mobileads:
//            WebViewAdUrlGenerator, MoPubErrorCode, MoPubView, AdLoader

public class AdViewController
{

    static final double BACKOFF_FACTOR = 1.5D;
    static final int DEFAULT_REFRESH_TIME_MILLISECONDS = 60000;
    static final int MAX_REFRESH_TIME_MILLISECONDS = 0x927c0;
    private static final android.widget.FrameLayout.LayoutParams WRAP_AND_CENTER_LAYOUT_PARAMS = new android.widget.FrameLayout.LayoutParams(-2, -2, 17);
    private static final WeakHashMap sViewShouldHonorServerDimensions = new WeakHashMap();
    private AdRequest mActiveRequest;
    private final com.mopub.network.AdRequest.Listener mAdListener = new com.mopub.network.AdRequest.Listener() {

        final AdViewController this$0;

        public void onErrorResponse(VolleyError volleyerror)
        {
            onAdLoadError(volleyerror);
        }

        public void onSuccess(AdResponse adresponse)
        {
            onAdLoadSuccess(adresponse);
        }

            
            {
                this$0 = AdViewController.this;
                super();
            }
    };
    private AdResponse mAdResponse;
    private String mAdUnitId;
    private boolean mAdWasLoaded;
    private boolean mAutoRefreshEnabled;
    int mBackoffPower;
    private final long mBroadcastIdentifier = Utils.generateUniqueId();
    private Context mContext;
    private Handler mHandler;
    private boolean mIsDestroyed;
    private boolean mIsLoading;
    private boolean mIsTesting;
    private String mKeywords;
    private Map mLocalExtras;
    private Location mLocation;
    private MoPubView mMoPubView;
    private boolean mPreviousAutoRefreshSetting;
    private final Runnable mRefreshRunnable = new Runnable() {

        final AdViewController this$0;

        public void run()
        {
            internalLoadAd();
        }

            
            {
                this$0 = AdViewController.this;
                super();
            }
    };
    private Integer mRefreshTimeMillis;
    private int mTimeoutMilliseconds;
    private String mUrl;
    private WebViewAdUrlGenerator mUrlGenerator;

    public AdViewController(Context context, MoPubView mopubview)
    {
        mBackoffPower = 1;
        mLocalExtras = new HashMap();
        mAutoRefreshEnabled = true;
        mPreviousAutoRefreshSetting = true;
        mContext = context;
        mMoPubView = mopubview;
        mTimeoutMilliseconds = -1;
        mUrlGenerator = new WebViewAdUrlGenerator(mContext.getApplicationContext(), MraidNativeCommandHandler.isStorePictureSupported(mContext));
        mRefreshTimeMillis = Integer.valueOf(60000);
        mHandler = new Handler();
    }

    private void cancelRefreshTimer()
    {
        mHandler.removeCallbacks(mRefreshRunnable);
    }

    private android.widget.FrameLayout.LayoutParams getAdLayoutParams(View view)
    {
        Integer integer1 = null;
        Integer integer = null;
        if (mAdResponse != null)
        {
            integer1 = mAdResponse.getWidth();
            integer = mAdResponse.getHeight();
        }
        if (integer1 != null && integer != null && getShouldHonorServerDimensions(view) && integer1.intValue() > 0 && integer.intValue() > 0)
        {
            return new android.widget.FrameLayout.LayoutParams(Dips.asIntPixels(integer1.intValue(), mContext), Dips.asIntPixels(integer.intValue(), mContext), 17);
        } else
        {
            return WRAP_AND_CENTER_LAYOUT_PARAMS;
        }
    }

    static MoPubErrorCode getErrorCodeFromVolleyError(VolleyError volleyerror, Context context)
    {
        NetworkResponse networkresponse = volleyerror.networkResponse;
        static class _cls4
        {

            static final int $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[];

            static 
            {
                $SwitchMap$com$mopub$network$MoPubNetworkError$Reason = new int[com.mopub.network.MoPubNetworkError.Reason.values().length];
                try
                {
                    $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.WARMING_UP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.NO_FILL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (volleyerror instanceof MoPubNetworkError)
        {
            switch (_cls4..SwitchMap.com.mopub.network.MoPubNetworkError.Reason[((MoPubNetworkError)volleyerror).getReason().ordinal()])
            {
            default:
                return MoPubErrorCode.UNSPECIFIED;

            case 1: // '\001'
                return MoPubErrorCode.WARMUP;

            case 2: // '\002'
                return MoPubErrorCode.NO_FILL;
            }
        }
        if (networkresponse == null)
        {
            if (!DeviceUtils.isNetworkAvailable(context))
            {
                return MoPubErrorCode.NO_CONNECTION;
            } else
            {
                return MoPubErrorCode.UNSPECIFIED;
            }
        }
        if (volleyerror.networkResponse.statusCode >= 400)
        {
            return MoPubErrorCode.SERVER_ERROR;
        } else
        {
            return MoPubErrorCode.UNSPECIFIED;
        }
    }

    private static boolean getShouldHonorServerDimensions(View view)
    {
        return sViewShouldHonorServerDimensions.get(view) != null;
    }

    private void internalLoadAd()
    {
        mAdWasLoaded = true;
        if (TextUtils.isEmpty(mAdUnitId))
        {
            MoPubLog.d("Can't load an ad in this ad view because the ad unit ID is not set. Did you forget to call setAdUnitId()?");
            return;
        }
        if (!isNetworkAvailable())
        {
            MoPubLog.d("Can't load an ad because there is no network connectivity.");
            scheduleRefreshTimerIfEnabled();
            return;
        } else
        {
            loadNonJavascript(generateAdUrl());
            return;
        }
    }

    private boolean isNetworkAvailable()
    {
        boolean flag1 = true;
        if (mContext != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (mContext.checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") == -1) goto _L4; else goto _L3
_L3:
        NetworkInfo networkinfo;
        networkinfo = ((ConnectivityManager)mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (networkinfo.isConnected()) goto _L4; else goto _L5
_L5:
        return false;
    }

    private void setAutorefreshEnabled(boolean flag)
    {
        boolean flag1;
        if (mAdWasLoaded && mAutoRefreshEnabled != flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            String s;
            if (flag)
            {
                s = "enabled";
            } else
            {
                s = "disabled";
            }
            MoPubLog.d((new StringBuilder()).append("Refresh ").append(s).append(" for ad unit (").append(mAdUnitId).append(").").toString());
        }
        mAutoRefreshEnabled = flag;
        if (mAdWasLoaded && mAutoRefreshEnabled)
        {
            scheduleRefreshTimerIfEnabled();
        } else
        if (!mAutoRefreshEnabled)
        {
            cancelRefreshTimer();
            return;
        }
    }

    public static void setShouldHonorServerDimensions(View view)
    {
        sViewShouldHonorServerDimensions.put(view, Boolean.valueOf(true));
    }

    void adDidFail(MoPubErrorCode mopuberrorcode)
    {
        MoPubLog.i("Ad failed to load.");
        setNotLoading();
        MoPubView mopubview = getMoPubView();
        if (mopubview == null)
        {
            return;
        } else
        {
            scheduleRefreshTimerIfEnabled();
            mopubview.adFailed(mopuberrorcode);
            return;
        }
    }

    void cleanup()
    {
        if (mIsDestroyed)
        {
            return;
        }
        if (mActiveRequest != null)
        {
            mActiveRequest.cancel();
            mActiveRequest = null;
        }
        setAutorefreshEnabled(false);
        cancelRefreshTimer();
        mMoPubView = null;
        mContext = null;
        mUrlGenerator = null;
        mIsDestroyed = true;
    }

    public void customEventActionWillBegin()
    {
        registerClick();
    }

    public void customEventDidFailToLoadAd()
    {
        loadFailUrl(MoPubErrorCode.UNSPECIFIED);
    }

    public void customEventDidLoadAd()
    {
        setNotLoading();
        trackImpression();
        scheduleRefreshTimerIfEnabled();
    }

    void fetchAd(String s)
    {
        MoPubView mopubview = getMoPubView();
        if (mopubview == null || mContext == null)
        {
            MoPubLog.d("Can't load an ad in this ad view because it was destroyed.");
            setNotLoading();
            return;
        } else
        {
            s = new AdRequest(s, mopubview.getAdFormat(), mAdUnitId, mContext, mAdListener);
            Networking.getRequestQueue(mContext).add(s);
            mActiveRequest = s;
            return;
        }
    }

    void forceRefresh()
    {
        setNotLoading();
        loadAd();
    }

    void forceSetAutorefreshEnabled(boolean flag)
    {
        mPreviousAutoRefreshSetting = flag;
        setAutorefreshEnabled(flag);
    }

    String generateAdUrl()
    {
        if (mUrlGenerator == null)
        {
            return null;
        } else
        {
            return mUrlGenerator.withAdUnitId(mAdUnitId).withKeywords(mKeywords).withLocation(mLocation).generateUrlString("ads.mopub.com");
        }
    }

    Object getAdConfiguration()
    {
        return null;
    }

    public int getAdHeight()
    {
        if (mAdResponse != null && mAdResponse.getHeight() != null)
        {
            return mAdResponse.getHeight().intValue();
        } else
        {
            return 0;
        }
    }

    public AdReport getAdReport()
    {
        if (mAdUnitId != null && mAdResponse != null)
        {
            return new AdReport(mAdUnitId, ClientMetadata.getInstance(mContext), mAdResponse);
        } else
        {
            return null;
        }
    }

    Integer getAdTimeoutDelay()
    {
        if (mAdResponse == null)
        {
            return null;
        } else
        {
            return mAdResponse.getAdTimeoutMillis();
        }
    }

    public String getAdUnitId()
    {
        return mAdUnitId;
    }

    public int getAdWidth()
    {
        if (mAdResponse != null && mAdResponse.getWidth() != null)
        {
            return mAdResponse.getWidth().intValue();
        } else
        {
            return 0;
        }
    }

    public boolean getAutorefreshEnabled()
    {
        return mAutoRefreshEnabled;
    }

    public long getBroadcastIdentifier()
    {
        return mBroadcastIdentifier;
    }

    public String getClickTrackingUrl()
    {
        if (mAdResponse == null)
        {
            return null;
        } else
        {
            return mAdResponse.getClickTrackingUrl();
        }
    }

    public String getKeywords()
    {
        return mKeywords;
    }

    Map getLocalExtras()
    {
        if (mLocalExtras != null)
        {
            return new TreeMap(mLocalExtras);
        } else
        {
            return new TreeMap();
        }
    }

    public Location getLocation()
    {
        return mLocation;
    }

    public MoPubView getMoPubView()
    {
        return mMoPubView;
    }

    public String getRedirectUrl()
    {
        if (mAdResponse == null)
        {
            return null;
        } else
        {
            return mAdResponse.getRedirectUrl();
        }
    }

    Integer getRefreshTimeMillis()
    {
        return mRefreshTimeMillis;
    }

    public String getResponseString()
    {
        if (mAdResponse == null)
        {
            return null;
        } else
        {
            return mAdResponse.getStringBody();
        }
    }

    public boolean getTesting()
    {
        return mIsTesting;
    }

    boolean isDestroyed()
    {
        return mIsDestroyed;
    }

    public boolean isFacebookSupported()
    {
        return false;
    }

    public void loadAd()
    {
        mBackoffPower = 1;
        internalLoadAd();
    }

    void loadFailUrl(MoPubErrorCode mopuberrorcode)
    {
        mIsLoading = false;
        StringBuilder stringbuilder = (new StringBuilder()).append("MoPubErrorCode: ");
        if (mopuberrorcode == null)
        {
            mopuberrorcode = "";
        } else
        {
            mopuberrorcode = mopuberrorcode.toString();
        }
        Log.v("MoPub", stringbuilder.append(mopuberrorcode).toString());
        if (mAdResponse == null)
        {
            mopuberrorcode = "";
        } else
        {
            mopuberrorcode = mAdResponse.getFailoverUrl();
        }
        if (!TextUtils.isEmpty(mopuberrorcode))
        {
            MoPubLog.d((new StringBuilder()).append("Loading failover url: ").append(mopuberrorcode).toString());
            loadNonJavascript(mopuberrorcode);
            return;
        } else
        {
            adDidFail(MoPubErrorCode.NO_FILL);
            return;
        }
    }

    void loadNonJavascript(String s)
    {
        if (s != null)
        {
            MoPubLog.d((new StringBuilder()).append("Loading url: ").append(s).toString());
            if (mIsLoading)
            {
                if (!TextUtils.isEmpty(mAdUnitId))
                {
                    MoPubLog.i((new StringBuilder()).append("Already loading an ad for ").append(mAdUnitId).append(", wait to finish.").toString());
                    return;
                }
            } else
            {
                mUrl = s;
                mIsLoading = true;
                fetchAd(mUrl);
                return;
            }
        }
    }

    void onAdLoadError(VolleyError volleyerror)
    {
        if (volleyerror instanceof MoPubNetworkError)
        {
            MoPubNetworkError mopubnetworkerror = (MoPubNetworkError)volleyerror;
            if (mopubnetworkerror.getRefreshTimeMillis() != null)
            {
                mRefreshTimeMillis = mopubnetworkerror.getRefreshTimeMillis();
            }
        }
        volleyerror = getErrorCodeFromVolleyError(volleyerror, mContext);
        if (volleyerror == MoPubErrorCode.SERVER_ERROR)
        {
            mBackoffPower = mBackoffPower + 1;
        }
        setNotLoading();
        adDidFail(volleyerror);
    }

    void onAdLoadSuccess(AdResponse adresponse)
    {
        mBackoffPower = 1;
        mAdResponse = adresponse;
        int i;
        if (mAdResponse.getAdTimeoutMillis() == null)
        {
            i = mTimeoutMilliseconds;
        } else
        {
            i = mAdResponse.getAdTimeoutMillis().intValue();
        }
        mTimeoutMilliseconds = i;
        mRefreshTimeMillis = mAdResponse.getRefreshTimeMillis();
        setNotLoading();
        adresponse = AdLoader.fromAdResponse(mAdResponse, this);
        if (adresponse != null)
        {
            adresponse.load();
        }
        scheduleRefreshTimerIfEnabled();
    }

    void pauseRefresh()
    {
        mPreviousAutoRefreshSetting = mAutoRefreshEnabled;
        setAutorefreshEnabled(false);
    }

    void registerClick()
    {
        if (mAdResponse != null)
        {
            TrackingRequest.makeTrackingHttpRequest(mAdResponse.getClickTrackingUrl(), mContext, com.mopub.common.event.BaseEvent.Name.CLICK_REQUEST);
        }
    }

    public void reload()
    {
        MoPubLog.d((new StringBuilder()).append("Reload ad: ").append(mUrl).toString());
        loadNonJavascript(mUrl);
    }

    void scheduleRefreshTimerIfEnabled()
    {
        cancelRefreshTimer();
        if (mAutoRefreshEnabled && mRefreshTimeMillis != null && mRefreshTimeMillis.intValue() > 0)
        {
            mHandler.postDelayed(mRefreshRunnable, Math.min(0x927c0L, (long)mRefreshTimeMillis.intValue() * (long)Math.pow(1.5D, mBackoffPower)));
        }
    }

    void setAdContentView(final View view)
    {
        mHandler.post(new Runnable() {

            final AdViewController this$0;
            final View val$view;

            public void run()
            {
                MoPubView mopubview = getMoPubView();
                if (mopubview == null)
                {
                    return;
                } else
                {
                    mopubview.removeAllViews();
                    mopubview.addView(view, getAdLayoutParams(view));
                    return;
                }
            }

            
            {
                this$0 = AdViewController.this;
                view = view1;
                super();
            }
        });
    }

    public void setAdUnitId(String s)
    {
        mAdUnitId = s;
    }

    public void setClickthroughUrl(String s)
    {
    }

    public void setFacebookSupported(boolean flag)
    {
    }

    void setFailUrl(String s)
    {
    }

    public void setKeywords(String s)
    {
        mKeywords = s;
    }

    void setLocalExtras(Map map)
    {
        if (map != null)
        {
            map = new TreeMap(map);
        } else
        {
            map = new TreeMap();
        }
        mLocalExtras = map;
    }

    public void setLocation(Location location)
    {
        mLocation = location;
    }

    void setNotLoading()
    {
        mIsLoading = false;
        if (mActiveRequest != null)
        {
            if (!mActiveRequest.isCanceled())
            {
                mActiveRequest.cancel();
            }
            mActiveRequest = null;
        }
    }

    void setRefreshTimeMillis(Integer integer)
    {
        mRefreshTimeMillis = integer;
    }

    public void setTesting(boolean flag)
    {
        mIsTesting = flag;
    }

    public void setTimeout(int i)
    {
        mTimeoutMilliseconds = i;
    }

    void trackImpression()
    {
        if (mAdResponse != null)
        {
            TrackingRequest.makeTrackingHttpRequest(mAdResponse.getImpressionTrackingUrl(), mContext, com.mopub.common.event.BaseEvent.Name.IMPRESSION_REQUEST);
        }
    }

    void unpauseRefresh()
    {
        setAutorefreshEnabled(mPreviousAutoRefreshSetting);
    }



}
