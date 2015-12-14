// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.mopub.common.AdFormat;
import com.mopub.common.GpsHelper;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.ManifestUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.AdRequest;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.mopub.nativeads:
//            NativeUrlGenerator, CustomEventNativeAdapter, NativeErrorCode, RequestParameters, 
//            NativeResponse, NativeAdInterface

public class MoPubNative
{

    static final MoPubNativeEventListener EMPTY_EVENT_LISTENER = new MoPubNativeEventListener() {

        public final void onNativeClick(View view)
        {
        }

        public final void onNativeImpression(View view)
        {
        }

    };
    static final MoPubNativeNetworkListener EMPTY_NETWORK_LISTENER = new MoPubNativeNetworkListener() {

        public final void onNativeFail(NativeErrorCode nativeerrorcode)
        {
        }

        public final void onNativeLoad(NativeResponse nativeresponse)
        {
            nativeresponse.destroy();
        }

    };
    private final String mAdUnitId;
    private final WeakReference mContext;
    private Map mLocalExtras;
    private MoPubNativeEventListener mMoPubNativeEventListener;
    private MoPubNativeNetworkListener mMoPubNativeNetworkListener;
    private AdRequest mNativeRequest;
    private final com.mopub.network.AdRequest.Listener mVolleyListener;

    public MoPubNative(Context context, String s, MoPubNativeListener mopubnativelistener)
    {
        this(context, s, ((MoPubNativeNetworkListener) (mopubnativelistener)));
        setNativeEventListener(mopubnativelistener);
    }

    public MoPubNative(Context context, String s, MoPubNativeNetworkListener mopubnativenetworklistener)
    {
        mLocalExtras = new TreeMap();
        Preconditions.checkNotNull(context, "Context may not be null.");
        Preconditions.checkNotNull(s, "AdUnitId may not be null.");
        Preconditions.checkNotNull(mopubnativenetworklistener, "MoPubNativeNetworkListener may not be null.");
        ManifestUtils.checkNativeActivitiesDeclared(context);
        mContext = new WeakReference(context);
        mAdUnitId = s;
        mMoPubNativeNetworkListener = mopubnativenetworklistener;
        mMoPubNativeEventListener = EMPTY_EVENT_LISTENER;
        mVolleyListener = new com.mopub.network.AdRequest.Listener() {

            final MoPubNative this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                onAdError(volleyerror);
            }

            public void onSuccess(AdResponse adresponse)
            {
                onAdLoad(adresponse);
            }

            
            {
                this$0 = MoPubNative.this;
                super();
            }
        };
        GpsHelper.fetchAdvertisingInfoAsync(context, null);
    }

    private void loadNativeAd(RequestParameters requestparameters, Integer integer)
    {
        Context context = getContextOrDestroy();
        if (context == null)
        {
            return;
        }
        requestparameters = (new NativeUrlGenerator(context)).withAdUnitId(mAdUnitId).withRequest(requestparameters);
        if (integer != null)
        {
            requestparameters.withSequenceNumber(integer.intValue());
        }
        requestparameters = requestparameters.generateUrlString("ads.mopub.com");
        if (requestparameters != null)
        {
            MoPubLog.d((new StringBuilder("Loading ad from: ")).append(requestparameters).toString());
        }
        requestNativeAd(requestparameters);
    }

    private void onAdLoad(final AdResponse response)
    {
        Context context = getContextOrDestroy();
        if (context == null)
        {
            return;
        } else
        {
            CustomEventNative.CustomEventNativeListener customeventnativelistener = new CustomEventNative.CustomEventNativeListener() {

                final MoPubNative this$0;
                final AdResponse val$response;

                public void onNativeAdFailed(NativeErrorCode nativeerrorcode)
                {
                    requestNativeAd(response.getFailoverUrl());
                }

                public void onNativeAdLoaded(NativeAdInterface nativeadinterface)
                {
                    Context context1 = getContextOrDestroy();
                    if (context1 == null)
                    {
                        return;
                    } else
                    {
                        mMoPubNativeNetworkListener.onNativeLoad(new NativeResponse(context1, response.getImpressionTrackingUrl(), response.getClickTrackingUrl(), mAdUnitId, nativeadinterface, mMoPubNativeEventListener));
                        return;
                    }
                }

            
            {
                this$0 = MoPubNative.this;
                response = adresponse;
                super();
            }

                private class MoPubNativeNetworkListener
                {

                    public abstract void onNativeFail(NativeErrorCode nativeerrorcode);

                    public abstract void onNativeLoad(NativeResponse nativeresponse);
                }

            };
            CustomEventNativeAdapter.loadNativeAd(context, mLocalExtras, response, customeventnativelistener);
            return;
        }
    }

    public void destroy()
    {
        mContext.clear();
        if (mNativeRequest != null)
        {
            mNativeRequest.cancel();
            mNativeRequest = null;
        }
        mMoPubNativeNetworkListener = EMPTY_NETWORK_LISTENER;
        mMoPubNativeEventListener = EMPTY_EVENT_LISTENER;
    }

    Context getContextOrDestroy()
    {
        Context context = (Context)mContext.get();
        if (context == null)
        {
            destroy();
            MoPubLog.d("Weak reference to Activity Context in MoPubNative became null. This instance of MoPubNative is destroyed and No more requests will be processed.");
        }
        return context;
    }

    MoPubNativeEventListener getMoPubNativeEventListener()
    {
        return mMoPubNativeEventListener;
    }

    MoPubNativeNetworkListener getMoPubNativeNetworkListener()
    {
        return mMoPubNativeNetworkListener;
    }

    public void makeRequest()
    {
        makeRequest(null);
    }

    public void makeRequest(RequestParameters requestparameters)
    {
        makeRequest(requestparameters, null);
    }

    public void makeRequest(RequestParameters requestparameters, Integer integer)
    {
        Context context = getContextOrDestroy();
        if (context == null)
        {
            return;
        }
        if (!DeviceUtils.isNetworkAvailable(context))
        {
            mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
            return;
        } else
        {
            loadNativeAd(requestparameters, integer);
            return;
        }
    }

    void onAdError(VolleyError volleyerror)
    {
        MoPubLog.d("Native ad request failed.", volleyerror);
        if (volleyerror instanceof MoPubNetworkError)
        {
            volleyerror = (MoPubNetworkError)volleyerror;
            class _cls5
            {

                static final int $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[];

                static 
                {
                    $SwitchMap$com$mopub$network$MoPubNetworkError$Reason = new int[com.mopub.network.MoPubNetworkError.Reason.values().length];
                    try
                    {
                        $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.BAD_BODY.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.BAD_HEADER_DATA.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.WARMING_UP.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.NO_FILL.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.UNSPECIFIED.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls5..SwitchMap.com.mopub.network.MoPubNetworkError.Reason[volleyerror.getReason().ordinal()])
            {
            default:
                mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.UNSPECIFIED);
                return;

            case 1: // '\001'
                mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.INVALID_JSON);
                return;

            case 2: // '\002'
                mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.INVALID_JSON);
                return;

            case 3: // '\003'
                MoPubLog.c(MoPubErrorCode.WARMUP.toString());
                mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
                return;

            case 4: // '\004'
                mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
                break;
            }
            return;
        }
        volleyerror = volleyerror.networkResponse;
        if (volleyerror != null && ((NetworkResponse) (volleyerror)).statusCode >= 500 && ((NetworkResponse) (volleyerror)).statusCode < 600)
        {
            mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
            return;
        }
        if (volleyerror == null && !DeviceUtils.isNetworkAvailable((Context)mContext.get()))
        {
            MoPubLog.c(String.valueOf(MoPubErrorCode.NO_CONNECTION.toString()));
            mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
            return;
        } else
        {
            mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.UNSPECIFIED);
            return;
        }
    }

    void requestNativeAd(String s)
    {
        Context context = getContextOrDestroy();
        if (context == null)
        {
            return;
        }
        if (s == null)
        {
            mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.INVALID_REQUEST_URL);
            return;
        }
        mNativeRequest = new AdRequest(s, AdFormat.NATIVE, mAdUnitId, context, mVolleyListener);
        try
        {
            Networking.getRequestQueue(context).add(mNativeRequest);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void setLocalExtras(Map map)
    {
        if (map == null)
        {
            mLocalExtras = new TreeMap();
            return;
        } else
        {
            mLocalExtras = new TreeMap(map);
            return;
        }
    }

    public void setNativeEventListener(MoPubNativeEventListener mopubnativeeventlistener)
    {
        MoPubNativeEventListener mopubnativeeventlistener1 = mopubnativeeventlistener;
        if (mopubnativeeventlistener == null)
        {
            mopubnativeeventlistener1 = EMPTY_EVENT_LISTENER;
        }
        mMoPubNativeEventListener = mopubnativeeventlistener1;
    }





}
