// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.customad;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;

public class NativeBaseView extends FrameLayout
{

    public FrameLayout actionFrame;
    public FrameLayout clickFrame;
    public FrameLayout iconFrame;
    public FrameLayout imageFrame;
    public Context mContext;
    public TextView nativeAdBody;
    public Button nativeAdCallToAction;
    public FrameLayout nativeAdContainer;
    public ImageView nativeAdIcon;
    public ImageView nativeAdImage;
    public TextView nativeAdSocialContext;
    public TextView nativeAdTitle;
    public FrameLayout nativeFrame;
    public FrameLayout textFrame;

    public NativeBaseView(Context context)
    {
        super(context);
        mContext = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(com.fotoable.fotoadpackage.R.layout.native_ad_view, this, true);
        nativeFrame = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.nativeFrameLayout);
        imageFrame = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.imageFrame);
        actionFrame = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.action_frame);
        iconFrame = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.icon_frame);
        clickFrame = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.click_frame);
        textFrame = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.text_frame);
        nativeAdContainer = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.nativeAdContainer);
        nativeAdIcon = (ImageView)findViewById(com.fotoable.fotoadpackage.R.id.nativeAdIcon);
        nativeAdTitle = (TextView)findViewById(com.fotoable.fotoadpackage.R.id.nativeAdTitle);
        nativeAdBody = (TextView)findViewById(com.fotoable.fotoadpackage.R.id.nativeAdBody);
        nativeAdImage = (ImageView)findViewById(com.fotoable.fotoadpackage.R.id.nativeAdImage);
        nativeAdSocialContext = (TextView)findViewById(com.fotoable.fotoadpackage.R.id.nativeAdSocialContext);
        nativeAdCallToAction = (Button)findViewById(com.fotoable.fotoadpackage.R.id.nativeAdCallToAction);
        resetView();
    }

    public void resetView()
    {
        try
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
            ((android.widget.FrameLayout.LayoutParams)nativeAdTitle.getLayoutParams()).gravity = 19;
            nativeAdTitle.requestLayout();
            layoutparams = (android.widget.FrameLayout.LayoutParams)clickFrame.getLayoutParams();
            layoutparams.height = (int)((f * 40F) / 300F);
            layoutparams.width = (int)((f * 40F) / 300F) * 2;
            clickFrame.setLayoutParams(layoutparams);
            layoutparams = (android.widget.FrameLayout.LayoutParams)textFrame.getLayoutParams();
            layoutparams.height = (int)((f * 40F) / 300F);
            layoutparams.width = (int)((150F * f) / 300F);
            layoutparams.gravity = 17;
            textFrame.setLayoutParams(layoutparams);
            setLayoutParams(new android.widget.FrameLayout.LayoutParams((int)f, (int)f1, 17));
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }
}
