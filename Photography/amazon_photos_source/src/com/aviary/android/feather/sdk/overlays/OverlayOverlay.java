// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.overlays;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;

// Referenced classes of package com.aviary.android.feather.sdk.overlays:
//            AviaryOverlay

public class OverlayOverlay extends AviaryOverlay
{

    private Drawable mBottomArrow;
    private final android.text.Layout.Alignment mTextAlign;
    private Drawable mTitleDrawable1;
    private CharSequence mTitleText;
    private final float mTitleWidthFraction;
    private Drawable mTopArrow;

    public OverlayOverlay(Context context, int i)
    {
        super(context, (new StringBuilder()).append(ToolLoaderFactory.getToolName(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.OVERLAYS)).append("_pinch").toString(), i, 8);
        context = context.getResources();
        mTopArrow = context.getDrawable(com.aviary.android.feather.sdk.R.drawable.aviary_overlay_arrow_top);
        mBottomArrow = context.getDrawable(com.aviary.android.feather.sdk.R.drawable.aviary_overlay_arrow_top);
        mTitleText = getTitleText(context);
        mTitleWidthFraction = getTitleWidthFraction(context);
        mTextAlign = android.text.Layout.Alignment.ALIGN_CENTER;
        addCloseButton(new int[] {
            9, 12
        });
    }

    private void calculateTextLayouts()
    {
        if (!isAttachedToParent())
        {
            return;
        }
        char c = '\0';
        if (mOrientationChanged)
        {
            c = '\377';
        }
        int i = (int)((float)getDisplayMetrics().widthPixels * (mTitleWidthFraction / 100F));
        mTitleDrawable1 = generateTitleDrawable(getContext(), mTitleText, i, mTextAlign);
        i = mTitleDrawable1.getIntrinsicWidth();
        int j = mTitleDrawable1.getIntrinsicHeight();
        Rect rect = new Rect(getWidth() / 2 - i / 2, getHeight() / 2 - j / 2, getWidth() / 2 + i / 2, getHeight() / 2 + j / 2);
        Rect rect1 = generateBounds(mTopArrow, rect, getTextMargins(), "top");
        Rect rect2 = generateBounds(mTopArrow, rect, getTextMargins(), "bottom");
        mTopArrow.setBounds(rect1);
        mBottomArrow.setBounds(rect2);
        mTitleDrawable1.setBounds(rect);
        mTitleDrawable1.setAlpha(c);
    }

    private Rect generateBounds(Drawable drawable, Rect rect, int i, CharSequence charsequence)
    {
        DisplayMetrics displaymetrics = getDisplayMetrics();
        int j = drawable.getIntrinsicWidth();
        int k = drawable.getIntrinsicHeight();
        drawable = new Rect(0, 0, j, k);
        if ("top".equals(charsequence))
        {
            drawable.offsetTo((displaymetrics.widthPixels - j) / 2, rect.top - k - i);
            return drawable;
        } else
        {
            drawable.offsetTo((displaymetrics.widthPixels - j) / 2, rect.bottom + i);
            return drawable;
        }
    }

    protected void calculatePositions()
    {
        logger.info("calculatePositions");
        calculateTextLayouts();
    }

    protected void dispatchDraw(Canvas canvas)
    {
        if (getVisibility() != 0 || !isAttachedToParent())
        {
            return;
        } else
        {
            canvas.drawColor(getBackgroundColor());
            int i = canvas.save();
            Matrix matrix = new Matrix();
            Rect rect = mTitleDrawable1.getBounds();
            matrix.setRotate(45F, rect.centerX(), rect.centerY());
            canvas.concat(matrix);
            mTopArrow.draw(canvas);
            canvas.restoreToCount(i);
            i = canvas.save();
            matrix.reset();
            matrix.setScale(1.0F, -1F, 0.0F, mBottomArrow.getBounds().centerY());
            matrix.postRotate(45F, rect.centerX(), rect.centerY());
            canvas.concat(matrix);
            mBottomArrow.draw(canvas);
            canvas.restoreToCount(i);
            mTitleDrawable1.draw(canvas);
            super.dispatchDraw(canvas);
            return;
        }
    }

    protected void doShow()
    {
        logger.info("doShow");
        if (!isAttachedToParent())
        {
            return;
        } else
        {
            fadeIn();
            return;
        }
    }

    protected CharSequence getTitleText(Resources resources)
    {
        return resources.getString(com.aviary.android.feather.sdk.R.string.feather_pinch_to_zoom);
    }

    protected float getTitleWidthFraction(Resources resources)
    {
        return resources.getFraction(com.aviary.android.feather.sdk.R.fraction.aviary_overlay_overlay_text_width, 100, 100);
    }

    protected void inAnimationCompleted()
    {
        if (getCloseButton() != null)
        {
            getCloseButton().setVisibility(0);
        }
    }

    public void onClick(View view)
    {
        logger.info((new StringBuilder()).append("onClick: ").append(view).toString());
        if (view == getCloseButton() && mCloseListener != null)
        {
            trackTutorialClosed("button");
            mCloseListener.onClose(this);
            return;
        } else
        {
            super.onClick(view);
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (isVisible() && isActive())
        {
            if (mCloseListener != null)
            {
                trackTutorialClosed("background");
                mCloseListener.onClose(this);
                return true;
            }
            if (motionevent.getAction() == 0)
            {
                hide("background");
                return true;
            }
        }
        return true;
    }

    public void setAlpha(float f)
    {
        mTopArrow.setAlpha((int)(f * 255F));
        mBottomArrow.setAlpha((int)(f * 255F));
        mTitleDrawable1.setAlpha((int)(f * 255F));
        super.setAlpha(f);
    }
}
