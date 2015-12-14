// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

// Referenced classes of package com.mopub.nativeads:
//            MoPubAdRenderer, ViewBinder, NativeViewHolder, NativeResponse

public class MoPubNativeAdRenderer
    implements MoPubAdRenderer
{

    private final ViewBinder mViewBinder;
    final WeakHashMap mViewHolderMap = new WeakHashMap();

    public MoPubNativeAdRenderer(ViewBinder viewbinder)
    {
        mViewBinder = viewbinder;
    }

    public View createAdView(Context context, ViewGroup viewgroup)
    {
        return LayoutInflater.from(context).inflate(mViewBinder.layoutId, viewgroup, false);
    }

    public void renderAdView(View view, NativeResponse nativeresponse)
    {
        NativeViewHolder nativeviewholder1 = (NativeViewHolder)mViewHolderMap.get(view);
        NativeViewHolder nativeviewholder = nativeviewholder1;
        if (nativeviewholder1 == null)
        {
            nativeviewholder = NativeViewHolder.fromViewBinder(view, mViewBinder);
            mViewHolderMap.put(view, nativeviewholder);
        }
        nativeviewholder.update(nativeresponse);
        nativeviewholder.updateExtras(nativeresponse, mViewBinder);
        nativeviewholder.setViewVisibility(0);
    }

    public volatile void renderAdView(View view, Object obj)
    {
        renderAdView(view, (NativeResponse)obj);
    }
}
