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
//            MoPubAdRenderer, MediaViewHolder, VideoNativeAd, NativeRendererHelper, 
//            MediaLayout, NativeImageHelper, MediaViewBinder, BaseNativeAd

public class MoPubVideoNativeAdRenderer
    implements MoPubAdRenderer
{

    private final MediaViewBinder mMediaViewBinder;
    final WeakHashMap mMediaViewHolderMap = new WeakHashMap();

    public MoPubVideoNativeAdRenderer(MediaViewBinder mediaviewbinder)
    {
        mMediaViewBinder = mediaviewbinder;
    }

    private void setViewVisibility(MediaViewHolder mediaviewholder, int i)
    {
        if (mediaviewholder.mainView != null)
        {
            mediaviewholder.mainView.setVisibility(i);
        }
    }

    private void update(MediaViewHolder mediaviewholder, VideoNativeAd videonativead)
    {
        NativeRendererHelper.addTextView(mediaviewholder.titleView, videonativead.getTitle());
        NativeRendererHelper.addTextView(mediaviewholder.textView, videonativead.getText());
        NativeRendererHelper.addCtaButton(mediaviewholder.callToActionView, mediaviewholder.mainView, videonativead.getCallToAction());
        NativeImageHelper.loadImageView(videonativead.getMainImageUrl(), mediaviewholder.mediaLayout.getMainImageView());
        NativeImageHelper.loadImageView(videonativead.getIconImageUrl(), mediaviewholder.iconImageView);
        NativeRendererHelper.addPrivacyInformationIcon(mediaviewholder.privacyInformationIconImageView, videonativead.getPrivacyInformationIconClickThroughUrl());
    }

    public View createAdView(Context context, ViewGroup viewgroup)
    {
        return LayoutInflater.from(context).inflate(mMediaViewBinder.layoutId, viewgroup, false);
    }

    public volatile void renderAdView(View view, BaseNativeAd basenativead)
    {
        renderAdView(view, (VideoNativeAd)basenativead);
    }

    public void renderAdView(View view, VideoNativeAd videonativead)
    {
        MediaViewHolder mediaviewholder1 = (MediaViewHolder)mMediaViewHolderMap.get(view);
        MediaViewHolder mediaviewholder = mediaviewholder1;
        if (mediaviewholder1 == null)
        {
            mediaviewholder = MediaViewHolder.fromViewBinder(view, mMediaViewBinder);
            mMediaViewHolderMap.put(view, mediaviewholder);
        }
        update(mediaviewholder, videonativead);
        NativeRendererHelper.updateExtras(mediaviewholder.mainView, mMediaViewBinder.extras, videonativead.getExtras());
        setViewVisibility(mediaviewholder, 0);
        videonativead.render((MediaLayout)view.findViewById(mMediaViewBinder.mediaLayoutId));
    }

    public boolean supports(BaseNativeAd basenativead)
    {
        Preconditions.checkNotNull(basenativead);
        return basenativead instanceof VideoNativeAd;
    }
}
