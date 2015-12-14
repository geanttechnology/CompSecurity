// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.overlays;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.DynamicLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;

// Referenced classes of package com.aviary.android.feather.sdk.overlays:
//            AviaryOverlay

public class StickersOverlay extends AviaryOverlay
{

    private static final float CIRCLE_SIZE = 1.5F;
    private Drawable arrow;
    private Paint eraser;
    private final float mDensity;
    private CharSequence mDetailText;
    private DynamicLayout mDetailsLayout;
    private Rect mDetailsPosition;
    private android.text.Layout.Alignment mTextAlign;
    private CharSequence mTextRelativePosition;
    private float mTextWidthFraction;
    private DynamicLayout mTitleLayout;
    private Rect mTitlePosition;
    private CharSequence mTitleText;
    private View packView;
    private final Rect viewRect;

    public StickersOverlay(Context context, int i, View view)
    {
        this(context, i, view, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.STICKERS, 1);
    }

    public StickersOverlay(Context context, int i, View view, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools, int j)
    {
        super(context, ToolLoaderFactory.getToolName(tools), i, j);
        context = context.getResources();
        mDensity = context.getDisplayMetrics().density;
        viewRect = new Rect();
        arrow = generateArrow();
        packView = view;
        mTitleText = getTitleText(context);
        mDetailText = getDetailText(context);
        mTextWidthFraction = getTextWidthFraction(context);
        mTextRelativePosition = getTextRelativePosition(context);
        context = context.getString(com.aviary.android.feather.sdk.R.string.aviary_overlay_default_text_align);
        if (android.text.Layout.Alignment.ALIGN_CENTER.name().equals(context))
        {
            mTextAlign = android.text.Layout.Alignment.ALIGN_CENTER;
        } else
        if (android.text.Layout.Alignment.ALIGN_OPPOSITE.equals(context))
        {
            mTextAlign = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        } else
        {
            mTextAlign = android.text.Layout.Alignment.ALIGN_NORMAL;
        }
        addCloseButton(new int[] {
            12, 9
        });
    }

    private void calculateTextLayouts()
    {
        if (isAttachedToParent())
        {
            packView.getGlobalVisibleRect(viewRect);
            if (mDetailsLayout == null || mTitleLayout == null || mOrientationChanged)
            {
                int i = viewRect.centerX();
                viewRect.centerY();
                int j = viewRect.top;
                int k = viewRect.left;
                DisplayMetrics displaymetrics = getDisplayMetrics();
                int l = (int)((float)displaymetrics.widthPixels * (mTextWidthFraction / 100F));
                mDetailsLayout = generateTextLayout(mDetailText, l, mTextAlign);
                mDetailsPosition = new Rect();
                android.widget.RelativeLayout.LayoutParams layoutparams;
                if (POSITION_LEFT.equals(mTextRelativePosition))
                {
                    mDetailsPosition.left = k - l / 2;
                } else
                if (POSITION_CENTER.equals(mTextRelativePosition))
                {
                    mDetailsPosition.left = i - l / 2;
                } else
                {
                    mDetailsPosition.left = viewRect.right;
                }
                mDetailsPosition.right = mDetailsPosition.left + mDetailsLayout.getWidth();
                mDetailsPosition.top = (int)((float)(j - arrow.getIntrinsicHeight() - mDetailsLayout.getHeight() - getTextMargins()) - 10F * mDensity);
                mDetailsPosition.bottom = mDetailsPosition.top + mDetailsLayout.getHeight();
                if (mDetailsPosition.right > displaymetrics.widthPixels)
                {
                    mDetailsPosition.offset(displaymetrics.widthPixels - mDetailsPosition.right - getTextMargins(), 0);
                } else
                if (mDetailsPosition.left < 0)
                {
                    mDetailsPosition.left = getTextMargins();
                }
                mTitleLayout = generateTitleLayout(mTitleText, l, mTextAlign);
                mTitlePosition = new Rect();
                mTitlePosition.left = mDetailsPosition.left;
                mTitlePosition.right = mDetailsPosition.right;
                mTitlePosition.top = mDetailsPosition.top - mTitleLayout.getHeight() - getTitleMargins();
                mTitlePosition.bottom = mTitlePosition.top + mTitleLayout.getHeight();
                layoutparams = (android.widget.RelativeLayout.LayoutParams)generateDefaultLayoutParams();
                layoutparams.addRule(12);
                if (viewRect.centerX() < displaymetrics.widthPixels / 2)
                {
                    layoutparams.addRule(11);
                } else
                {
                    layoutparams.addRule(9);
                }
                layoutparams.setMargins(mClosebuttonMargins, mClosebuttonMargins, mClosebuttonMargins, mClosebuttonMargins);
                getCloseButton().setLayoutParams(layoutparams);
                return;
            }
        }
    }

    private void trackPackClicked()
    {
        if (getContext() != null)
        {
            AviaryTracker.getInstance(getContext()).tagEvent((new StringBuilder()).append(getToolName()).append(": tutorial_pack_selected").toString());
        }
    }

    protected void calculatePositions()
    {
        logger.info("calculatePositions");
        calculateTextLayouts();
    }

    protected void dispatchDraw(Canvas canvas)
    {
        if (getVisibility() != 0 || !isAttachedToParent() || packView == null)
        {
            return;
        }
        canvas.drawColor(getBackgroundColor());
        arrow.setBounds(viewRect.centerX(), (int)((float)(viewRect.top - arrow.getIntrinsicHeight()) - mDensity * 10F), viewRect.centerX() + arrow.getIntrinsicWidth(), (int)((float)viewRect.top - mDensity * 10F));
        arrow.draw(canvas);
        calculateTextLayouts();
        if (mDetailsLayout != null)
        {
            canvas.save();
            canvas.translate(mDetailsPosition.left, mDetailsPosition.top);
            mDetailsLayout.draw(canvas);
            canvas.restore();
        }
        if (mTitleLayout != null)
        {
            canvas.save();
            canvas.translate(mTitlePosition.left, mTitlePosition.top);
            mTitleLayout.draw(canvas);
            canvas.restore();
        }
        canvas.save();
        canvas.translate(viewRect.left, viewRect.top);
        packView.draw(canvas);
        canvas.restore();
        super.dispatchDraw(canvas);
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

    protected CharSequence getDetailText(Resources resources)
    {
        return resources.getString(com.aviary.android.feather.sdk.R.string.feather_overlay_stickers_text);
    }

    public int getTextMargins()
    {
        return (int)(5F * mDensity);
    }

    protected CharSequence getTextRelativePosition(Resources resources)
    {
        return resources.getString(com.aviary.android.feather.sdk.R.string.aviary_overlay_stickers_text_position);
    }

    protected float getTextWidthFraction(Resources resources)
    {
        return resources.getFraction(com.aviary.android.feather.sdk.R.fraction.aviary_overlay_stickers_text_width, 100, 100);
    }

    protected CharSequence getTitleText(Resources resources)
    {
        return resources.getString(com.aviary.android.feather.sdk.R.string.feather_stickers);
    }

    protected void inAnimationCompleted()
    {
        logger.info("inAnimationCompleted");
        if (getCloseButton() != null)
        {
            getCloseButton().setVisibility(0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        float f = Math.abs(motionevent.getRawX() - (float)viewRect.centerX());
        float f1 = Math.abs(motionevent.getRawY() - (float)viewRect.centerY());
        Math.sqrt(Math.pow(f, 2D) + Math.pow(f1, 2D));
        int i = (int)((float)viewRect.width() / 1.5F);
        if (viewRect.contains((int)motionevent.getRawX(), (int)motionevent.getRawY()))
        {
            trackPackClicked();
            flag = false;
        } else
        if (motionevent.getAction() == 0)
        {
            hide("background");
            return true;
        }
        return flag;
    }

    public void setAlpha(float f)
    {
        if (mTitleLayout != null)
        {
            mTitleLayout.getPaint().setAlpha((int)(f * 255F));
        }
        if (mDetailsLayout != null)
        {
            mDetailsLayout.getPaint().setAlpha((int)(f * 255F));
        }
        arrow.setAlpha((int)(f * 255F));
        super.setAlpha(f);
    }

    public void setText(int i)
    {
        setText(((CharSequence) (getContext().getString(i))));
    }

    public void setText(CharSequence charsequence)
    {
        mDetailText = charsequence;
        mDetailsLayout = null;
        postInvalidate();
    }

    public void setTitle(int i)
    {
        setTitle(((CharSequence) (getContext().getString(i))));
    }

    public void setTitle(CharSequence charsequence)
    {
        mTitleText = charsequence;
        mTitleLayout = null;
        postInvalidate();
    }

    public void update(View view)
    {
        logger.info("update");
        packView = view;
        mDetailsLayout = null;
        calculatePositions();
        postInvalidate();
    }
}
