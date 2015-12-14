// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;

public class VastVideoCloseButtonWidget extends RelativeLayout
{

    private CloseButtonDrawable mCloseButtonDrawable;
    private final int mEdgePadding;
    private final ImageLoader mImageLoader;
    private final int mImagePadding;
    private ImageView mImageView;
    private final int mTextRightMargin;
    private TextView mTextView;
    private final int mWidgetHeight;

    public VastVideoCloseButtonWidget(Context context)
    {
        super(context);
        setId((int)Utils.generateUniqueId());
        mEdgePadding = Dips.dipsToIntPixels(16F, context);
        mImagePadding = Dips.dipsToIntPixels(5F, context);
        mWidgetHeight = Dips.dipsToIntPixels(46F, context);
        mTextRightMargin = Dips.dipsToIntPixels(7F, context);
        mCloseButtonDrawable = new CloseButtonDrawable();
        mImageLoader = Networking.getImageLoader(context);
        createImageView();
        createTextView();
        context = new android.widget.RelativeLayout.LayoutParams(-2, mWidgetHeight);
        context.addRule(11);
        setLayoutParams(context);
    }

    private void createImageView()
    {
        mImageView = new ImageView(getContext());
        mImageView.setId((int)Utils.generateUniqueId());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(mWidgetHeight, mWidgetHeight);
        layoutparams.addRule(11);
        mImageView.setImageDrawable(mCloseButtonDrawable);
        mImageView.setPadding(mImagePadding, mImagePadding + mEdgePadding, mImagePadding + mEdgePadding, mImagePadding);
        addView(mImageView, layoutparams);
    }

    private void createTextView()
    {
        mTextView = new TextView(getContext());
        mTextView.setSingleLine();
        mTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        mTextView.setTextColor(-1);
        mTextView.setTextSize(20F);
        mTextView.setTypeface(com.mopub.mobileads.resource.DrawableConstants.CloseButton.TEXT_TYPEFACE);
        mTextView.setText("");
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(15);
        layoutparams.addRule(0, mImageView.getId());
        mTextView.setPadding(0, mEdgePadding, 0, 0);
        layoutparams.setMargins(0, 0, mTextRightMargin, 0);
        addView(mTextView, layoutparams);
    }

    ImageView getImageView()
    {
        return mImageView;
    }

    TextView getTextView()
    {
        return mTextView;
    }

    void setImageView(ImageView imageview)
    {
        mImageView = imageview;
    }

    void setOnTouchListenerToContent(android.view.View.OnTouchListener ontouchlistener)
    {
        mImageView.setOnTouchListener(ontouchlistener);
        mTextView.setOnTouchListener(ontouchlistener);
    }

    void updateCloseButtonIcon(final String imageUrl)
    {
        mImageLoader.get(imageUrl, new com.mopub.volley.toolbox.ImageLoader.ImageListener() {

            final VastVideoCloseButtonWidget this$0;
            final String val$imageUrl;

            public void onErrorResponse(VolleyError volleyerror)
            {
                MoPubLog.d("Failed to load image.", volleyerror);
            }

            public void onResponse(com.mopub.volley.toolbox.ImageLoader.ImageContainer imagecontainer, boolean flag)
            {
                imagecontainer = imagecontainer.getBitmap();
                if (imagecontainer != null)
                {
                    mImageView.setImageBitmap(imagecontainer);
                    return;
                } else
                {
                    MoPubLog.d(String.format("%s returned null bitmap", new Object[] {
                        imageUrl
                    }));
                    return;
                }
            }

            
            {
                this$0 = VastVideoCloseButtonWidget.this;
                imageUrl = s;
                super();
            }
        });
    }

    void updateCloseButtonText(String s)
    {
        if (mTextView != null)
        {
            mTextView.setText(s);
        }
    }

}
