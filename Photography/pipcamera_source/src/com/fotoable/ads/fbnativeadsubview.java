// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.fotoable.customad.NativeBaseView;

public class fbnativeadsubview extends NativeBaseView
{

    public fbnativeadsubview(Context context)
    {
        super(context);
    }

    public void loadViewWithAd(NativeAd nativead)
    {
        nativeAdSocialContext.setText("SPONSORED");
        nativeAdCallToAction.setText(nativead.getAdCallToAction());
        nativeAdTitle.setText(nativead.getAdTitle());
        nativeAdBody.setText(nativead.getAdSocialContext());
        NativeAd.downloadAndDisplayImage(nativead.getAdIcon(), nativeAdIcon);
        com.facebook.ads.NativeAd.Image image = nativead.getAdCoverImage();
        Log.v("TAG", image.getUrl());
        NativeAd.downloadAndDisplayImage(image, nativeAdImage);
        setClickedAble(nativead);
    }

    protected void resetView()
    {
        float f = mContext.getResources().getDisplayMetrics().widthPixels;
        f -= f / 8F;
        float f1 = (207F * f) / 300F;
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)nativeFrame.getLayoutParams();
        layoutparams.width = (int)f;
        layoutparams.height = (int)f1;
        nativeFrame.setLayoutParams(layoutparams);
        layoutparams = (android.widget.FrameLayout.LayoutParams)imageFrame.getLayoutParams();
        layoutparams.width = (int)f;
        layoutparams.height = (int)((157F * f) / 300F);
        imageFrame.setLayoutParams(layoutparams);
        layoutparams = (android.widget.FrameLayout.LayoutParams)actionFrame.getLayoutParams();
        layoutparams.width = (int)f;
        layoutparams.height = (int)((50F * f) / 300F);
        actionFrame.setLayoutParams(layoutparams);
        layoutparams = (android.widget.FrameLayout.LayoutParams)iconFrame.getLayoutParams();
        layoutparams.height = (int)((f * 40F) / 300F);
        layoutparams.width = (int)((f * 40F) / 300F);
        iconFrame.setLayoutParams(layoutparams);
        layoutparams = (android.widget.FrameLayout.LayoutParams)clickFrame.getLayoutParams();
        layoutparams.height = (int)((f * 40F) / 300F);
        layoutparams.width = (int)((f * 40F) / 300F) * 2;
        clickFrame.setLayoutParams(layoutparams);
        layoutparams = (android.widget.FrameLayout.LayoutParams)textFrame.getLayoutParams();
        layoutparams.height = (int)((f * 40F) / 300F);
        layoutparams.width = (int)((150F * f) / 300F);
        textFrame.setLayoutParams(layoutparams);
        setLayoutParams(new android.widget.FrameLayout.LayoutParams((int)f, (int)f1));
    }

    public void setClickedAble(NativeAd nativead)
    {
        nativead.registerViewForInteraction(nativeAdContainer);
        nativeAdContainer.setVisibility(0);
    }
}
