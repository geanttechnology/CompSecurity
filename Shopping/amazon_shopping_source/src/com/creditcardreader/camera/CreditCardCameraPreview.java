// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Pair;
import com.a9.cameralibrary.A9CameraPreview;
import com.a9.cameralibrary.CameraFrameListener;
import com.creditcardreader.activities.CreditCardScanActivity;
import com.creditcardreader.helpers.CreditCardAnimationHelper;
import com.creditcardreader.helpers.CreditCardOverlayHelper;
import com.creditcardreader.utils.CreditCardUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreditCardCameraPreview extends A9CameraPreview
{

    private CreditCardScanActivity mActivity;
    private CreditCardAnimationHelper mAnimationHelper;
    private float mBottomBound;
    private ArrayList mBounds;
    private float mLeftBound;
    private float mRadius;
    private Resources mResources;
    private float mRightBound;
    private RectF mScanBox;
    private boolean mScanning;
    private boolean mSuccess;
    private float mTopBound;

    public CreditCardCameraPreview(Context context, CameraFrameListener cameraframelistener)
    {
        super(context, cameraframelistener);
        setWillNotDraw(false);
        mBounds = new ArrayList();
        mActivity = (CreditCardScanActivity)context;
        mResources = mActivity.getResources();
        mLeftBound = (1.0F / 0.0F);
        mRightBound = (-1.0F / 0.0F);
        mTopBound = (1.0F / 0.0F);
        mBottomBound = (-1.0F / 0.0F);
    }

    private void createAnimations()
    {
        mAnimationHelper = new CreditCardAnimationHelper(mActivity, this);
        mAnimationHelper.setViews();
        mAnimationHelper.createAnimations();
        mAnimationHelper.lighten();
    }

    private void createOverlay()
    {
        CreditCardOverlayHelper creditcardoverlayhelper = new CreditCardOverlayHelper(mActivity, this);
        creditcardoverlayhelper.setBounds(mLeftBound, mRightBound, mTopBound, mBottomBound);
        creditcardoverlayhelper.drawOverlay();
    }

    private void drawOverlay(Canvas canvas)
    {
        canvas.drawColor(mResources.getColor(com.creditcardreader.R.color.cc_scan_background));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        int i = Math.round(mLeftBound);
        int k = Math.round(mTopBound);
        int i1 = Math.round(mRightBound);
        int k1 = Math.round(mBottomBound);
        mScanBox = new RectF(i, k, i1, k1);
        canvas.drawRect(mScanBox, paint);
        if (mSuccess)
        {
            float f = mResources.getDimension(com.creditcardreader.R.dimen.cc_scan_thickness);
            paint.setXfermode(null);
            paint.setColor(mResources.getColor(com.creditcardreader.R.color.cc_scan_green));
            canvas.drawRoundRect(mScanBox, mRadius, mRadius, paint);
            int j = Math.round(mScanBox.left + f);
            int l = Math.round(mScanBox.top + f);
            int j1 = Math.round(mScanBox.right - f);
            int l1 = Math.round(mScanBox.bottom - f);
            RectF rectf = new RectF(j, l, j1, l1);
            f = CreditCardUtils.convertDpToPx((int)mResources.getDimension(com.creditcardreader.R.dimen.cc_scan_inner_radius));
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
            canvas.drawRoundRect(rectf, f, f, paint);
        }
    }

    public void blacken()
    {
        if (mAnimationHelper != null)
        {
            mAnimationHelper.blacken();
        }
    }

    public boolean isScanning()
    {
        return mScanning;
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drawOverlay(canvas);
    }

    public void resetOverlay()
    {
        if (mAnimationHelper != null)
        {
            mAnimationHelper.resetOverlay();
        }
        mScanning = false;
        invalidate();
    }

    public void setBounds(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = (Point)list.next();
            obj = new PointF(((Point) (obj)).x, ((Point) (obj)).y);
            translatePointInPlace(((PointF) (obj)));
            mBounds.add(obj);
            mLeftBound = Math.min(mLeftBound, ((PointF) (obj)).x);
            mRightBound = Math.max(mRightBound, ((PointF) (obj)).x);
            mTopBound = Math.min(mTopBound, ((PointF) (obj)).y);
            mBottomBound = Math.max(mBottomBound, ((PointF) (obj)).y);
        }

        createOverlay();
        createAnimations();
        invalidate();
    }

    public void setEdges(List list)
    {
        boolean flag = false;
        boolean flag2 = false;
        boolean flag1 = false;
        boolean flag3 = false;
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = (Pair)list.next();
            PointF pointf = new PointF((Point)((Pair) (obj)).first);
            obj = new PointF((Point)((Pair) (obj)).second);
            translatePointInPlace(pointf);
            translatePointInPlace(((PointF) (obj)));
            if (pointf.x == ((PointF) (obj)).x)
            {
                if (pointf.y > ((PointF) (obj)).y)
                {
                    flag2 = true;
                } else
                {
                    flag1 = true;
                }
            } else
            if (pointf.x < ((PointF) (obj)).x)
            {
                flag = true;
            } else
            {
                flag3 = true;
            }
        }

        if (flag2 && flag1 && flag && flag3)
        {
            mScanning = true;
            mAnimationHelper.centerToScanning();
            invalidate();
        } else
        if (mScanning)
        {
            mScanning = false;
            mAnimationHelper.scanningToCenter();
            invalidate();
            return;
        }
    }

    public void showSuccess()
    {
        mScanning = false;
        mSuccess = true;
        mAnimationHelper.scanningToScanned();
        invalidate();
    }

    public void startPreview()
    {
        super.startPreview();
    }

    public void stopPreview()
    {
        super.stopPreview();
    }
}
