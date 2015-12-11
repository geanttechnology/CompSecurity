// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.helpers;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.creditcardreader.activities.CreditCardScanActivity;
import com.creditcardreader.camera.CreditCardCameraPreview;
import com.creditcardreader.utils.CreditCardUtils;

public class CreditCardOverlayHelper
{

    private CreditCardScanActivity mActivity;
    private int mBottomBound;
    private int mLeftBound;
    private float mPadding;
    private Resources mResources;
    private int mRightBound;
    private RectF mScanBox;
    private int mTopBound;

    public CreditCardOverlayHelper(CreditCardScanActivity creditcardscanactivity, CreditCardCameraPreview creditcardcamerapreview)
    {
        mActivity = creditcardscanactivity;
        mResources = creditcardscanactivity.getResources();
        switch (mActivity.getScreenOrientation())
        {
        default:
            mPadding = creditcardcamerapreview.getScreenHeight() / 20F;
            return;

        case 1: // '\001'
            mPadding = creditcardcamerapreview.getScreenWidth() / 20F;
            break;
        }
    }

    private void positionBorderLayout(RelativeLayout relativelayout)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)relativelayout.getLayoutParams();
        layoutparams.height = Math.round(mScanBox.height());
        layoutparams.topMargin = mTopBound;
        layoutparams.leftMargin = 0;
        relativelayout.setLayoutParams(layoutparams);
    }

    private void positionScanLayout(RelativeLayout relativelayout)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)relativelayout.getLayoutParams();
        layoutparams.width = Math.round(mScanBox.width() + 2.0F * mPadding);
        layoutparams.height = Math.round(mScanBox.height());
        layoutparams.topMargin = mTopBound;
        layoutparams.leftMargin = Math.round((float)mLeftBound - mPadding);
        relativelayout.setLayoutParams(layoutparams);
    }

    private void setBorderView(ImageView imageview)
    {
        float f = CreditCardUtils.convertDpToPx((int)mResources.getDimension(com.creditcardreader.R.dimen.cc_scan_outer_radius));
        Bitmap bitmap = Bitmap.createBitmap(imageview.getWidth(), Math.round(mScanBox.height()), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        canvas.drawColor(mResources.getColor(com.creditcardreader.R.color.cc_scan_background));
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        canvas.drawRoundRect(new RectF(mLeftBound, 0.0F, mRightBound, Math.round(mScanBox.height())), f, f, paint);
        imageview.setImageBitmap(bitmap);
        imageview.setVisibility(0);
    }

    private void setGhostView(ImageView imageview)
    {
        Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(mResources, com.creditcardreader.R.drawable.cc_scan_ghost), Math.round(mScanBox.width()), Math.round(mScanBox.height()), true);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)imageview.getLayoutParams();
        layoutparams.topMargin = mTopBound;
        imageview.setLayoutParams(layoutparams);
        imageview.setImageBitmap(bitmap);
        imageview.setVisibility(0);
    }

    private void setLayouts()
    {
        positionScanLayout((RelativeLayout)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_progress_layout));
        positionBorderLayout((RelativeLayout)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_border_layout));
    }

    private void setProgressView(ImageView imageview)
    {
        Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(mResources, com.creditcardreader.R.drawable.cc_scanning), Math.round(mScanBox.width() + mPadding), Math.round(mScanBox.height()), true);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)imageview.getLayoutParams();
        layoutparams.topMargin = 0;
        layoutparams.leftMargin = 0;
        imageview.setLayoutParams(layoutparams);
        imageview.setImageBitmap(bitmap);
        imageview.setVisibility(4);
    }

    private void setSecureLockViews(ImageView imageview, TextView textview, TextView textview1)
    {
        float f3 = CreditCardUtils.convertDpToPx((int)mResources.getDimension(com.creditcardreader.R.dimen.cc_lock_padding));
        float f = imageview.getWidth();
        float f1 = textview1.getWidth();
        float f2 = (float)mBottomBound + (float)mTopBound / 2.0F;
        f = mScanBox.centerX() - (f + f3 + f1) / 2.0F;
        f1 = mResources.getDimension(com.creditcardreader.R.dimen.cc_lock_padding_left_min);
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (f <= f1)
        {
            f = f1;
        }
        f1 = (float)imageview.getHeight() / 2.0F;
        layoutparams = (android.widget.RelativeLayout.LayoutParams)imageview.getLayoutParams();
        layoutparams.leftMargin = Math.round(f);
        layoutparams.topMargin = Math.round(f2 - f1);
        f = (float)imageview.getWidth() + f + f3;
        f1 = textview.getHeight();
        layoutparams = (android.widget.RelativeLayout.LayoutParams)textview.getLayoutParams();
        layoutparams.leftMargin = Math.round(f);
        layoutparams.topMargin = Math.round(f2 - f1);
        layoutparams = (android.widget.RelativeLayout.LayoutParams)textview1.getLayoutParams();
        layoutparams.leftMargin = Math.round(f);
        layoutparams.topMargin = Math.round(f2);
        imageview.setVisibility(0);
        textview.setVisibility(0);
        textview1.setVisibility(0);
    }

    private void setStatusView(TextView textview)
    {
        float f = CreditCardUtils.convertDpToPx((int)mResources.getDimension(com.creditcardreader.R.dimen.cc_status_padding));
        f = Math.max((float)mTopBound - f, mTopBound / 2 - textview.getHeight() / 2);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)textview.getLayoutParams();
        layoutparams.topMargin = (int)f;
        textview.setLayoutParams(layoutparams);
        textview.setVisibility(0);
    }

    private void setViews()
    {
        setStatusView((TextView)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_status_text));
        setGhostView((ImageView)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_ghost));
        setProgressView((ImageView)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_progress));
        setBorderView((ImageView)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_border));
        setSecureLockViews((ImageView)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_lock), (TextView)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_secure_text), (TextView)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_save_text));
    }

    public void drawOverlay()
    {
        setLayouts();
        setViews();
    }

    public void setBounds(float f, float f1, float f2, float f3)
    {
        mLeftBound = Math.round(f);
        mTopBound = Math.round(f2);
        mRightBound = Math.round(f1);
        mBottomBound = Math.round(f3);
        mScanBox = new RectF(mLeftBound, mTopBound, mRightBound, mBottomBound);
    }
}
