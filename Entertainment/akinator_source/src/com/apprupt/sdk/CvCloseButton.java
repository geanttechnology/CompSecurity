// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.apprupt.sdk.adview.CloseButtonPosition;

// Referenced classes of package com.apprupt.sdk:
//            CvViewHelper, Logger

class CvCloseButton extends View
{
    public static interface Listener
    {

        public abstract void onClick();
    }


    public static float size = 50F;
    private float lineWidth;
    private Listener listener;
    private Paint mBg;
    private RectF mBgBounds;
    private Paint mBlack;
    private RectF mCircleBounds;
    private Handler mHandler;
    private RectF mInnerCircleBounds;
    private Paint mWhite;
    private Paint mWhiteShadowed;

    public CvCloseButton(Context context)
    {
        super(context.getApplicationContext());
        mBg = null;
        mBgBounds = null;
        mWhiteShadowed = null;
        mWhite = null;
        mBlack = null;
        mCircleBounds = null;
        mInnerCircleBounds = null;
        lineWidth = 3F;
        listener = null;
        mHandler = new Handler();
        init();
    }

    public CvCloseButton(Context context, AttributeSet attributeset)
    {
        super(context.getApplicationContext(), attributeset);
        mBg = null;
        mBgBounds = null;
        mWhiteShadowed = null;
        mWhite = null;
        mBlack = null;
        mCircleBounds = null;
        mInnerCircleBounds = null;
        lineWidth = 3F;
        listener = null;
        mHandler = new Handler();
        init();
    }

    public CvCloseButton(Context context, CloseButtonPosition closebuttonposition)
    {
        this(context);
        setupPosition(closebuttonposition);
    }

    private void init()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setLayerType(1, null);
        }
        setClickable(true);
        setOnClickListener(new android.view.View.OnClickListener() {

            final CvCloseButton this$0;

            public void onClick(View view)
            {
            /* block-local class not found */
            class _cls1 {}

                mHandler.post(new _cls1());
            }

            
            {
                this$0 = CvCloseButton.this;
                super();
            }
        });
        mBg = new Paint(1);
        mBg.setColor(Color.argb(255, 255, 255, 255));
        mWhiteShadowed = new Paint(1);
        mWhiteShadowed.setColor(Color.argb(255, 255, 255, 255));
        mWhiteShadowed.setShadowLayer(CvViewHelper.dp2px(3F), 0.0F, 0.0F, 0xff000000);
        mWhite = new Paint(1);
        mWhite.setColor(Color.argb(255, 255, 255, 255));
        mBlack = new Paint(1);
        mBlack.setColor(Color.argb(255, 0, 0, 0));
    }

    protected int getSuggestedMinimumHeight()
    {
        return CvViewHelper.dp2px(size);
    }

    protected int getSuggestedMinimumWidth()
    {
        return CvViewHelper.dp2px(size);
    }

    protected void onDraw(Canvas canvas)
    {
        try
        {
            super.onDraw(canvas);
            canvas.drawOval(mCircleBounds, mWhiteShadowed);
            canvas.drawOval(mInnerCircleBounds, mBlack);
            float f3 = mInnerCircleBounds.width() / 4F;
            float f2 = mInnerCircleBounds.height() / 4F;
            float f = f3 + mInnerCircleBounds.left;
            float f1 = f2 + mInnerCircleBounds.top;
            f3 = (mInnerCircleBounds.left + mInnerCircleBounds.width()) - f3;
            f2 = (mInnerCircleBounds.top + mInnerCircleBounds.height()) - f2;
            mWhite.setStrokeWidth(lineWidth);
            canvas.drawLine(f, f1, f3, f2, mWhite);
            canvas.drawLine(f3, f1, f, f2, mWhite);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Canvas canvas)
        {
            Logger.get("CLOSE_BUTTON").e(new Object[] {
                "Close button cannot render"
            });
        }
    }

    protected void onMeasure(int i, int j)
    {
        i = Math.max(getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth(), android.view.View.MeasureSpec.getSize(i));
        int k = getPaddingBottom();
        int l = getPaddingTop();
        int i1 = getSuggestedMinimumHeight();
        setMeasuredDimension(i, Math.min(android.view.View.MeasureSpec.getSize(j), k + l + i1));
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        float f = getPaddingLeft() + getPaddingRight();
        float f1 = getPaddingTop() + getPaddingBottom();
        f = (float)i - f;
        f1 = (float)j - f1;
        float f2 = f * 0.48F;
        float f3 = f1 * 0.48F;
        lineWidth = Math.max(1.0F, Math.min(f, f1) * 0.06F);
        float f4 = Math.max(1.0F, Math.min(f, f1) * 0.04F);
        mBgBounds = new RectF(0.0F, 0.0F, f, f1);
        mBgBounds.offsetTo(getPaddingLeft(), getPaddingTop());
        mCircleBounds = new RectF(0.0F, 0.0F, f2, f3);
        mCircleBounds.offsetTo((float)getPaddingLeft() + 0.36F * f, (float)getPaddingTop() + 0.16F * f1);
        mInnerCircleBounds = new RectF(0.0F, 0.0F, f2 - 2.0F * f4, f3 - 2.0F * f4);
        mInnerCircleBounds.offsetTo((float)getPaddingLeft() + f4 + 0.36F * f, (float)getPaddingTop() + f4 + 0.16F * f1);
    }

    public void setListener(Listener listener1)
    {
        listener = listener1;
    }

    public void setupPosition(CloseButtonPosition closebuttonposition)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams;
        int i = CvViewHelper.dp2px(size);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(i, i);
        if (closebuttonposition != CloseButtonPosition.CENTER) goto _L2; else goto _L1
_L1:
        layoutparams.addRule(13);
_L5:
        setLayoutParams(layoutparams);
        return;
_L2:
        if (closebuttonposition != CloseButtonPosition.TOP_LEFT && closebuttonposition != CloseButtonPosition.BOTTOM_LEFT) goto _L4; else goto _L3
_L3:
        layoutparams.addRule(9);
_L6:
        if (closebuttonposition == CloseButtonPosition.BOTTOM_RIGHT || closebuttonposition == CloseButtonPosition.BOTTOM_CENTER || closebuttonposition == CloseButtonPosition.BOTTOM_LEFT)
        {
            layoutparams.addRule(12);
        } else
        {
            layoutparams.addRule(10);
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (closebuttonposition == CloseButtonPosition.TOP_RIGHT || closebuttonposition == CloseButtonPosition.BOTTOM_RIGHT)
        {
            layoutparams.addRule(11);
        } else
        {
            layoutparams.addRule(14);
        }
          goto _L6
    }



}
