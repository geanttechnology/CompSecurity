// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import java.util.WeakHashMap;

// Referenced classes of package com.mopub.nativeads:
//            MoPubAdRenderer, StaticNativeViewHolder, StaticNativeAd, NativeRendererHelper, 
//            NativeImageHelper, ViewBinder, BaseNativeAd

public class MoPubStaticNativeAdRenderer
    implements MoPubAdRenderer
{

    private final ViewBinder mViewBinder;
    final WeakHashMap mViewHolderMap = new WeakHashMap();

    public MoPubStaticNativeAdRenderer(ViewBinder viewbinder)
    {
        mViewBinder = viewbinder;
    }

    private void setViewVisibility(StaticNativeViewHolder staticnativeviewholder, int i)
    {
        if (staticnativeviewholder.mainView != null)
        {
            staticnativeviewholder.mainView.setVisibility(i);
        }
    }

    private void update(StaticNativeViewHolder staticnativeviewholder, StaticNativeAd staticnativead)
    {
        NativeRendererHelper.addTextView(staticnativeviewholder.titleView, staticnativead.getTitle());
        NativeRendererHelper.addTextView(staticnativeviewholder.textView, staticnativead.getText());
        NativeRendererHelper.addTextView(staticnativeviewholder.callToActionView, staticnativead.getCallToAction());
        NativeImageHelper.loadImageView(staticnativead.getMainImageUrl(), staticnativeviewholder.mainImageView);
        NativeImageHelper.loadImageView(staticnativead.getIconImageUrl(), staticnativeviewholder.iconImageView);
        NativeRendererHelper.addPrivacyInformationIcon(staticnativeviewholder.privacyInformationIconImageView, staticnativead.getPrivacyInformationIconClickThroughUrl());
    }

    public View createAdView(Context context, ViewGroup viewgroup)
    {
        return LayoutInflater.from(context).inflate(mViewBinder.layoutId, viewgroup, false);
    }

    public volatile void renderAdView(View view, BaseNativeAd basenativead)
    {
        renderAdView(view, (StaticNativeAd)basenativead);
    }

    public void renderAdView(View view, StaticNativeAd staticnativead)
    {
        StaticNativeViewHolder staticnativeviewholder1 = (StaticNativeViewHolder)mViewHolderMap.get(view);
        StaticNativeViewHolder staticnativeviewholder = staticnativeviewholder1;
        if (staticnativeviewholder1 == null)
        {
            staticnativeviewholder = StaticNativeViewHolder.fromViewBinder(view, mViewBinder);
            mViewHolderMap.put(view, staticnativeviewholder);
        }
        update(staticnativeviewholder, staticnativead);
        NativeRendererHelper.updateExtras(staticnativeviewholder.mainView, mViewBinder.extras, staticnativead.getExtras());
        setViewVisibility(staticnativeviewholder, 0);
    }

    public boolean supports(BaseNativeAd basenativead)
    {
        Preconditions.checkNotNull(basenativead);
        return basenativead instanceof StaticNativeAd;
    }
}
