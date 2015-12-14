// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.nativeads:
//            PositioningSource, PositioningRequest, PositioningUrlGenerator

class ServerPositioningSource
    implements PositioningSource
{

    private static final double DEFAULT_RETRY_TIME_MILLISECONDS = 1000D;
    private static final double EXPONENTIAL_BACKOFF_FACTOR = 2D;
    private static final int MAXIMUM_RETRY_TIME_MILLISECONDS = 0x493e0;
    private int adsOffset;
    private final Context mContext;
    private final com.mopub.volley.Response.ErrorListener mErrorListener = new com.mopub.volley.Response.ErrorListener() {

        final ServerPositioningSource this$0;

        public void onErrorResponse(VolleyError volleyerror)
        {
            if (!(volleyerror instanceof MoPubNetworkError) || ((MoPubNetworkError)volleyerror).getReason().equals(com.mopub.network.MoPubNetworkError.Reason.WARMING_UP))
            {
                MoPubLog.e("Failed to load positioning data", volleyerror);
                if (volleyerror.networkResponse == null && !DeviceUtils.isNetworkAvailable(mContext))
                {
                    MoPubLog.c(String.valueOf(MoPubErrorCode.NO_CONNECTION.toString()));
                }
            }
            handleFailure();
        }

            
            {
                this$0 = ServerPositioningSource.this;
                super();
            }
    };
    private PositioningSource.PositioningListener mListener;
    private int mMaximumRetryTimeMillis;
    private final com.mopub.volley.Response.Listener mPositioningListener = new com.mopub.volley.Response.Listener() {

        final ServerPositioningSource this$0;

        public void onResponse(MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
        {
            handleSuccess(mopubclientpositioning);
        }

        public volatile void onResponse(Object obj)
        {
            onResponse((MoPubNativeAdPositioning.MoPubClientPositioning)obj);
        }

            
            {
                this$0 = ServerPositioningSource.this;
                super();
            }
    };
    private PositioningRequest mRequest;
    private int mRetryCount;
    private final Handler mRetryHandler = new Handler();
    private final Runnable mRetryRunnable = new Runnable() {

        final ServerPositioningSource this$0;

        public void run()
        {
            requestPositioningInternal();
        }

            
            {
                this$0 = ServerPositioningSource.this;
                super();
            }
    };
    private String mRetryUrl;

    ServerPositioningSource(Context context)
    {
        mMaximumRetryTimeMillis = 0x493e0;
        adsOffset = 0;
        mContext = context.getApplicationContext();
    }

    private void handleFailure()
    {
        int i = (int)(Math.pow(2D, mRetryCount + 1) * 1000D);
        if (i >= mMaximumRetryTimeMillis)
        {
            MoPubLog.d("Error downloading positioning information");
            if (mListener != null)
            {
                mListener.onFailed();
            }
            mListener = null;
            return;
        } else
        {
            mRetryCount = mRetryCount + 1;
            mRetryHandler.postDelayed(mRetryRunnable, i);
            return;
        }
    }

    private void handleSuccess(MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
    {
        if (mListener != null)
        {
            mListener.onLoad(mopubclientpositioning);
        }
        mListener = null;
        mRetryCount = 0;
    }

    private void requestPositioningInternal()
    {
        MoPubLog.d((new StringBuilder("Loading positioning from: ")).append(mRetryUrl).toString());
        mRequest = new PositioningRequest(mRetryUrl, mPositioningListener, mErrorListener);
        try
        {
            Networking.getRequestQueue(mContext).add(mRequest);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void loadPositions(String s, PositioningSource.PositioningListener positioninglistener)
    {
        if (mRequest != null)
        {
            mRequest.cancel();
            mRequest = null;
        }
        if (mRetryCount > 0)
        {
            mRetryHandler.removeCallbacks(mRetryRunnable);
            mRetryCount = 0;
        }
        mListener = positioninglistener;
        mRetryUrl = (new PositioningUrlGenerator(mContext)).withAdUnitId(s).generateUrlString("ads.mopub.com");
        requestPositioningInternal();
    }

    void setMaximumRetryTimeMilliseconds(int i)
    {
        mMaximumRetryTimeMillis = i;
    }




}
