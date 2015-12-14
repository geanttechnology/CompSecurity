// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseNativeAd
{
    public static interface NativeEventListener
    {

        public abstract void onAdClicked();

        public abstract void onAdImpressed();
    }


    private final Set mClickTrackers = new HashSet();
    private final Set mImpressionTrackers = new HashSet();
    private NativeEventListener mNativeEventListener;

    protected BaseNativeAd()
    {
    }

    public final void addClickTracker(String s)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(s, "clickTracker url is not allowed to be null"))
        {
            return;
        } else
        {
            mClickTrackers.add(s);
            return;
        }
    }

    public final void addImpressionTracker(String s)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(s, "impressionTracker url is not allowed to be null"))
        {
            return;
        } else
        {
            mImpressionTrackers.add(s);
            return;
        }
    }

    public abstract void clear(View view);

    public abstract void destroy();

    Set getClickTrackers()
    {
        return new HashSet(mClickTrackers);
    }

    Set getImpressionTrackers()
    {
        return new HashSet(mImpressionTrackers);
    }

    protected final void notifyAdClicked()
    {
        if (mNativeEventListener != null)
        {
            mNativeEventListener.onAdClicked();
        }
    }

    protected final void notifyAdImpressed()
    {
        if (mNativeEventListener != null)
        {
            mNativeEventListener.onAdImpressed();
        }
    }

    public abstract void prepare(View view);

    public void setNativeEventListener(NativeEventListener nativeeventlistener)
    {
        mNativeEventListener = nativeeventlistener;
    }
}
