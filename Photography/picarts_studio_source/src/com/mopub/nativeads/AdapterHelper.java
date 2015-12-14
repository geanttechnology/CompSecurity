// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;

// Referenced classes of package com.mopub.nativeads:
//            NativeAdViewHelper, NativeResponse, ViewBinder

public final class AdapterHelper
{

    private final WeakReference mActivity;
    private final Context mApplicationContext;
    private final int mInterval;
    private final int mStart;

    public AdapterHelper(Context context, int i, int j)
    {
        boolean flag1 = true;
        super();
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkArgument(context instanceof Activity, "Context must be an Activity.");
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "start position must be non-negative");
        if (j >= 2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "interval must be at least 2");
        mActivity = new WeakReference((Activity)context);
        mApplicationContext = context.getApplicationContext();
        mStart = i;
        mInterval = j;
    }

    private int numberOfAdsSeenUpToPosition(int i)
    {
        if (i <= mStart)
        {
            return 0;
        } else
        {
            return (int)Math.floor((double)(i - mStart) / (double)mInterval) + 1;
        }
    }

    private int numberOfAdsThatCouldFitWithContent(int i)
    {
        if (i <= mStart)
        {
            return 0;
        }
        int j = mInterval - 1;
        if ((i - mStart) % j == 0)
        {
            return (i - mStart) / j;
        } else
        {
            return (int)Math.floor((double)(i - mStart) / (double)j) + 1;
        }
    }

    final void clearActivityContext()
    {
        mActivity.clear();
    }

    public final View getAdView(View view, ViewGroup viewgroup, NativeResponse nativeresponse, ViewBinder viewbinder, MoPubNative.MoPubNativeListener mopubnativelistener)
    {
        mopubnativelistener = (Activity)mActivity.get();
        if (mopubnativelistener == null)
        {
            MoPubLog.w("Weak reference to Activity Context in AdapterHelper became null. Returning empty view.");
            return new View(mApplicationContext);
        } else
        {
            return NativeAdViewHelper.getAdView(view, viewgroup, mopubnativelistener, nativeresponse, viewbinder);
        }
    }

    public final boolean isAdPosition(int i)
    {
        while (i < mStart || (i - mStart) % mInterval != 0) 
        {
            return false;
        }
        return true;
    }

    public final int shiftedCount(int i)
    {
        return numberOfAdsThatCouldFitWithContent(i) + i;
    }

    public final int shiftedPosition(int i)
    {
        return i - numberOfAdsSeenUpToPosition(i);
    }
}
