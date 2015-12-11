// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jeremyfeinstein.slidingmenu.lib;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.jeremyfeinstein.slidingmenu.lib:
//            CustomViewAbove

public class CustomViewBehind extends ViewGroup
{

    private static final int MARGIN_THRESHOLD = 48;
    private static final String TAG = "CustomViewBehind";
    private boolean mChildrenEnabled;
    private View mContent;
    private float mFadeDegree;
    private boolean mFadeEnabled;
    private final Paint mFadePaint;
    private int mMarginThreshold;
    private int mMode;
    private float mScrollScale;
    private View mSecondaryContent;
    private Drawable mSecondaryShadowDrawable;
    private View mSelectedView;
    private Bitmap mSelectorDrawable;
    private boolean mSelectorEnabled;
    private Drawable mShadowDrawable;
    private int mShadowWidth;
    private int mTouchMode;
    private SlidingMenu.CanvasTransformer mTransformer;
    private CustomViewAbove mViewAbove;
    private int mWidthOffset;

    public CustomViewBehind(Context context)
    {
        this(context, null);
    }

    public CustomViewBehind(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mTouchMode = 0;
        mFadePaint = new Paint();
        mSelectorEnabled = true;
        mMarginThreshold = (int)TypedValue.applyDimension(1, 48F, getResources().getDisplayMetrics());
    }

    private int getSelectorTop()
    {
        return mSelectedView.getTop() + (mSelectedView.getHeight() - mSelectorDrawable.getHeight()) / 2;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        if (mTransformer != null)
        {
            canvas.save();
            mTransformer.transformCanvas(canvas, mViewAbove.getPercentOpen());
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        } else
        {
            super.dispatchDraw(canvas);
            return;
        }
    }

    public void drawFade(View view, Canvas canvas, float f)
    {
        int i;
        int j;
        if (!mFadeEnabled)
        {
            return;
        }
        i = (int)(mFadeDegree * 255F * Math.abs(1.0F - f));
        mFadePaint.setColor(Color.argb(i, 0, 0, 0));
        i = 0;
        j = 0;
        if (mMode != 0) goto _L2; else goto _L1
_L1:
        i = view.getLeft() - getBehindWidth();
        j = view.getLeft();
_L4:
        canvas.drawRect(i, 0.0F, j, getHeight(), mFadePaint);
        return;
_L2:
        if (mMode == 1)
        {
            i = view.getRight();
            j = view.getRight() + getBehindWidth();
        } else
        if (mMode == 2)
        {
            i = view.getLeft();
            j = getBehindWidth();
            int k = view.getLeft();
            canvas.drawRect(i - j, 0.0F, k, getHeight(), mFadePaint);
            i = view.getRight();
            j = view.getRight() + getBehindWidth();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void drawSelector(View view, Canvas canvas, float f)
    {
        int i;
        while (!mSelectorEnabled || mSelectorDrawable == null || mSelectedView == null || !((String)mSelectedView.getTag(R.id.selected_view)).equals("CustomViewBehindSelectedView")) 
        {
            return;
        }
        canvas.save();
        i = (int)((float)mSelectorDrawable.getWidth() * f);
        if (mMode != 0) goto _L2; else goto _L1
_L1:
        int j = view.getLeft();
        i = j - i;
        canvas.clipRect(i, 0, j, getHeight());
        canvas.drawBitmap(mSelectorDrawable, i, getSelectorTop(), null);
_L4:
        canvas.restore();
        return;
_L2:
        if (mMode == 1)
        {
            int k = view.getRight();
            i = k + i;
            canvas.clipRect(k, 0, i, getHeight());
            canvas.drawBitmap(mSelectorDrawable, i - mSelectorDrawable.getWidth(), getSelectorTop(), null);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void drawShadow(View view, Canvas canvas)
    {
        int i;
        if (mShadowDrawable == null || mShadowWidth <= 0)
        {
            return;
        }
        i = 0;
        if (mMode != 0) goto _L2; else goto _L1
_L1:
        i = view.getLeft() - mShadowWidth;
_L4:
        mShadowDrawable.setBounds(i, 0, mShadowWidth + i, getHeight());
        mShadowDrawable.draw(canvas);
        return;
_L2:
        if (mMode == 1)
        {
            i = view.getRight();
        } else
        if (mMode == 2)
        {
            if (mSecondaryShadowDrawable != null)
            {
                i = view.getRight();
                mSecondaryShadowDrawable.setBounds(i, 0, mShadowWidth + i, getHeight());
                mSecondaryShadowDrawable.draw(canvas);
            }
            i = view.getLeft() - mShadowWidth;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int getAbsLeftBound(View view)
    {
        if (mMode == 0 || mMode == 2)
        {
            return view.getLeft() - getBehindWidth();
        }
        if (mMode == 1)
        {
            return view.getLeft();
        } else
        {
            return 0;
        }
    }

    public int getAbsRightBound(View view)
    {
        if (mMode == 0)
        {
            return view.getLeft();
        }
        if (mMode == 1 || mMode == 2)
        {
            return view.getLeft() + getBehindWidth();
        } else
        {
            return 0;
        }
    }

    public int getBehindWidth()
    {
        return mContent.getWidth();
    }

    public View getContent()
    {
        return mContent;
    }

    public int getMarginThreshold()
    {
        return mMarginThreshold;
    }

    public int getMenuLeft(View view, int i)
    {
        if (mMode != 0) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 41
    //                   1 36
    //                   2 51;
           goto _L3 _L4 _L3 _L5
_L3:
        return view.getLeft();
_L4:
        return view.getLeft() - getBehindWidth();
_L5:
        return view.getLeft();
_L2:
        if (mMode != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        switch (i)
        {
        case 0: // '\0'
            return view.getLeft();

        case 2: // '\002'
            return view.getLeft() + getBehindWidth();
        }
        if (true) goto _L3; else goto _L6
_L6:
        if (mMode != 2) goto _L3; else goto _L7
_L7:
        switch (i)
        {
        case 0: // '\0'
            return view.getLeft() - getBehindWidth();

        case 2: // '\002'
            return view.getLeft() + getBehindWidth();
        }
        if (true) goto _L3; else goto _L8
_L8:
    }

    public int getMenuPage(int i)
    {
        if (i <= 1) goto _L2; else goto _L1
_L1:
        int j = 2;
_L4:
        if (mMode == 0 && j > 1)
        {
            return 0;
        }
        break; /* Loop/switch isn't completed */
_L2:
        j = i;
        if (i < 1)
        {
            j = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (mMode == 1 && j < 1)
        {
            return 2;
        } else
        {
            return j;
        }
    }

    public int getMode()
    {
        return mMode;
    }

    public float getScrollScale()
    {
        return mScrollScale;
    }

    public View getSecondaryContent()
    {
        return mSecondaryContent;
    }

    public boolean marginTouchAllowed(View view, int i)
    {
        int j;
        int k;
        j = view.getLeft();
        k = view.getRight();
        if (mMode != 0) goto _L2; else goto _L1
_L1:
        if (i < j || i > mMarginThreshold + j) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (mMode != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i > k || i < k - mMarginThreshold)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
        if (mMode == 2)
        {
            if ((i < j || i > mMarginThreshold + j) && (i > k || i < k - mMarginThreshold))
            {
                return false;
            }
        } else
        {
            return false;
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    public boolean menuClosedSlideAllowed(float f)
    {
        if (mMode != 0) goto _L2; else goto _L1
_L1:
        if (f <= 0.0F) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (mMode != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (f < 0.0F) goto _L3; else goto _L5
_L5:
        return false;
        if (mMode == 2) goto _L3; else goto _L6
_L6:
        return false;
    }

    public boolean menuOpenSlideAllowed(float f)
    {
        if (mMode != 0) goto _L2; else goto _L1
_L1:
        if (f >= 0.0F) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (mMode != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (f > 0.0F) goto _L3; else goto _L5
_L5:
        return false;
        if (mMode == 2) goto _L3; else goto _L6
_L6:
        return false;
    }

    public boolean menuOpenTouchAllowed(View view, int i, float f)
    {
        switch (mTouchMode)
        {
        default:
            return false;

        case 1: // '\001'
            return true;

        case 0: // '\0'
            return menuTouchInQuickReturn(view, i, f);
        }
    }

    public boolean menuTouchInQuickReturn(View view, int i, float f)
    {
        if (mMode != 0 && (mMode != 2 || i != 0)) goto _L2; else goto _L1
_L1:
        if (f < (float)view.getLeft()) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (mMode == 1 || mMode == 2 && i == 2)
        {
            if (f > (float)view.getRight())
            {
                return false;
            }
        } else
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return !mChildrenEnabled;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        i = k - i;
        j = l - j;
        mContent.layout(0, 0, i - mWidthOffset, j);
        if (mSecondaryContent != null)
        {
            mSecondaryContent.layout(0, 0, i - mWidthOffset, j);
        }
    }

    protected void onMeasure(int i, int j)
    {
        int l = getDefaultSize(0, i);
        int k = getDefaultSize(0, j);
        setMeasuredDimension(l, k);
        i = getChildMeasureSpec(i, 0, l - mWidthOffset);
        j = getChildMeasureSpec(j, 0, k);
        mContent.measure(i, j);
        if (mSecondaryContent != null)
        {
            mSecondaryContent.measure(i, j);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return !mChildrenEnabled;
    }

    public void scrollBehindTo(View view, int i, int j)
    {
        byte byte0;
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        byte0 = 0;
        if (mMode != 0) goto _L2; else goto _L1
_L1:
        if (i >= view.getLeft())
        {
            byte0 = 4;
        }
        scrollTo((int)((float)(getBehindWidth() + i) * mScrollScale), j);
_L4:
        if (byte0 == 4)
        {
            Log.v("CustomViewBehind", "behind INVISIBLE");
        }
        setVisibility(byte0);
        return;
_L2:
        if (mMode == 1)
        {
            byte0 = flag1;
            if (i <= view.getLeft())
            {
                byte0 = 4;
            }
            scrollTo((int)((float)(getBehindWidth() - getWidth()) + (float)(i - getBehindWidth()) * mScrollScale), j);
        } else
        {
            byte0 = flag;
            if (mMode == 2)
            {
                View view1 = mContent;
                if (i >= view.getLeft())
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 0;
                }
                view1.setVisibility(byte0);
                view1 = mSecondaryContent;
                if (i <= view.getLeft())
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 0;
                }
                view1.setVisibility(byte0);
                if (i == 0)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 0;
                }
                if (i <= view.getLeft())
                {
                    scrollTo((int)((float)(getBehindWidth() + i) * mScrollScale), j);
                } else
                {
                    scrollTo((int)((float)(getBehindWidth() - getWidth()) + (float)(i - getBehindWidth()) * mScrollScale), j);
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void scrollTo(int i, int j)
    {
        super.scrollTo(i, j);
        if (mTransformer != null)
        {
            invalidate();
        }
    }

    public void setCanvasTransformer(SlidingMenu.CanvasTransformer canvastransformer)
    {
        mTransformer = canvastransformer;
    }

    public void setChildrenEnabled(boolean flag)
    {
        mChildrenEnabled = flag;
    }

    public void setContent(View view)
    {
        if (mContent != null)
        {
            removeView(mContent);
        }
        mContent = view;
        addView(mContent);
    }

    public void setCustomViewAbove(CustomViewAbove customviewabove)
    {
        mViewAbove = customviewabove;
    }

    public void setFadeDegree(float f)
    {
        if (f > 1.0F || f < 0.0F)
        {
            throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
        } else
        {
            mFadeDegree = f;
            return;
        }
    }

    public void setFadeEnabled(boolean flag)
    {
        mFadeEnabled = flag;
    }

    public void setMarginThreshold(int i)
    {
        mMarginThreshold = i;
    }

    public void setMode(int i)
    {
        if (i == 0 || i == 1)
        {
            if (mContent != null)
            {
                mContent.setVisibility(0);
            }
            if (mSecondaryContent != null)
            {
                mSecondaryContent.setVisibility(4);
            }
        }
        mMode = i;
    }

    public void setScrollScale(float f)
    {
        mScrollScale = f;
    }

    public void setSecondaryContent(View view)
    {
        if (mSecondaryContent != null)
        {
            removeView(mSecondaryContent);
        }
        mSecondaryContent = view;
        addView(mSecondaryContent);
    }

    public void setSecondaryShadowDrawable(Drawable drawable)
    {
        mSecondaryShadowDrawable = drawable;
        invalidate();
    }

    public void setSelectedView(View view)
    {
        if (mSelectedView != null)
        {
            mSelectedView.setTag(R.id.selected_view, null);
            mSelectedView = null;
        }
        if (view != null && view.getParent() != null)
        {
            mSelectedView = view;
            mSelectedView.setTag(R.id.selected_view, "CustomViewBehindSelectedView");
            invalidate();
        }
    }

    public void setSelectorBitmap(Bitmap bitmap)
    {
        mSelectorDrawable = bitmap;
        refreshDrawableState();
    }

    public void setSelectorEnabled(boolean flag)
    {
        mSelectorEnabled = flag;
    }

    public void setShadowDrawable(Drawable drawable)
    {
        mShadowDrawable = drawable;
        invalidate();
    }

    public void setShadowWidth(int i)
    {
        mShadowWidth = i;
        invalidate();
    }

    public void setTouchMode(int i)
    {
        mTouchMode = i;
    }

    public void setWidthOffset(int i)
    {
        mWidthOffset = i;
        requestLayout();
    }
}
