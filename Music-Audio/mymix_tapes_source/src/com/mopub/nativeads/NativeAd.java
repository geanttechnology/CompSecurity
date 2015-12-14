// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.network.TrackingRequest;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.mopub.nativeads:
//            BaseNativeAd, MoPubAdRenderer

public class NativeAd
{
    public static interface MoPubNativeEventListener
    {

        public abstract void onClick(View view);

        public abstract void onImpression(View view);
    }


    private final String mAdUnitId;
    private final BaseNativeAd mBaseNativeAd;
    private final Set mClickTrackers = new HashSet();
    private final Context mContext;
    private final Set mImpressionTrackers = new HashSet();
    private boolean mIsClicked;
    private boolean mIsDestroyed;
    private final MoPubAdRenderer mMoPubAdRenderer;
    private MoPubNativeEventListener mMoPubNativeEventListener;
    private boolean mRecordedImpression;

    public NativeAd(Context context, String s, String s1, String s2, BaseNativeAd basenativead, MoPubAdRenderer mopubadrenderer)
    {
        mContext = context.getApplicationContext();
        mAdUnitId = s2;
        mImpressionTrackers.add(s);
        mImpressionTrackers.addAll(basenativead.getImpressionTrackers());
        mClickTrackers.add(s1);
        mClickTrackers.addAll(basenativead.getClickTrackers());
        mBaseNativeAd = basenativead;
        mBaseNativeAd.setNativeEventListener(new BaseNativeAd.NativeEventListener() {

            final NativeAd this$0;

            public void onAdClicked()
            {
                handleClick(null);
            }

            public void onAdImpressed()
            {
                recordImpression(null);
            }

            
            {
                this$0 = NativeAd.this;
                super();
            }
        });
        mMoPubAdRenderer = mopubadrenderer;
    }

    public void clear(View view)
    {
        if (mIsDestroyed)
        {
            return;
        } else
        {
            mBaseNativeAd.clear(view);
            return;
        }
    }

    public View createAdView(ViewGroup viewgroup)
    {
        return mMoPubAdRenderer.createAdView(mContext, viewgroup);
    }

    public void destroy()
    {
        if (mIsDestroyed)
        {
            return;
        } else
        {
            mBaseNativeAd.destroy();
            mIsDestroyed = true;
            return;
        }
    }

    public String getAdUnitId()
    {
        return mAdUnitId;
    }

    public MoPubAdRenderer getMoPubAdRenderer()
    {
        return mMoPubAdRenderer;
    }

    void handleClick(View view)
    {
        if (mIsClicked || mIsDestroyed)
        {
            return;
        }
        TrackingRequest.makeTrackingHttpRequest(mClickTrackers, mContext);
        if (mMoPubNativeEventListener != null)
        {
            mMoPubNativeEventListener.onClick(view);
        }
        mIsClicked = true;
    }

    public boolean isDestroyed()
    {
        return mIsDestroyed;
    }

    public void prepare(View view)
    {
        if (mIsDestroyed)
        {
            return;
        } else
        {
            mBaseNativeAd.prepare(view);
            return;
        }
    }

    void recordImpression(View view)
    {
        if (mRecordedImpression || mIsDestroyed)
        {
            return;
        }
        TrackingRequest.makeTrackingHttpRequest(mImpressionTrackers, mContext);
        if (mMoPubNativeEventListener != null)
        {
            mMoPubNativeEventListener.onImpression(view);
        }
        mRecordedImpression = true;
    }

    public void renderAdView(View view)
    {
        mMoPubAdRenderer.renderAdView(view, mBaseNativeAd);
    }

    public void setMoPubNativeEventListener(MoPubNativeEventListener mopubnativeeventlistener)
    {
        mMoPubNativeEventListener = mopubnativeeventlistener;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("\n");
        stringbuilder.append("impressionTrackers").append(":").append(mImpressionTrackers).append("\n");
        stringbuilder.append("clickTrackers").append(":").append(mClickTrackers).append("\n");
        stringbuilder.append("recordedImpression").append(":").append(mRecordedImpression).append("\n");
        stringbuilder.append("isClicked").append(":").append(mIsClicked).append("\n");
        stringbuilder.append("isDestroyed").append(":").append(mIsDestroyed).append("\n");
        return stringbuilder.toString();
    }
}
