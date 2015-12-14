// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.indicate;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package com.fotoable.photocollage.view.compose2.indicate:
//            PageIndicator

public class CirclePageIndicator extends View
    implements PageIndicator
{

    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private boolean mCentered;
    private int mCurrentPage;
    private boolean mIsDragging;
    private float mLastMotionX;
    private android.support.v4.view.ViewPager.OnPageChangeListener mListener;
    private int mOrientation;
    private float mPageOffset;
    private final Paint mPaintFill;
    private final Paint mPaintPageFill;
    private final Paint mPaintStroke;
    private float mRadius;
    private int mScrollState;
    private boolean mSnap;
    private int mSnapPage;
    private int mTouchSlop;
    private ViewPager mViewPager;

    public CirclePageIndicator(Context context)
    {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f0100ca);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mPaintPageFill = new Paint(1);
        mPaintStroke = new Paint(1);
        mPaintFill = new Paint(1);
        mLastMotionX = -1F;
        mActivePointerId = -1;
        if (isInEditMode())
        {
            return;
        }
        Object obj = getResources();
        int j = ((Resources) (obj)).getColor(0x7f0b002f);
        int k = ((Resources) (obj)).getColor(0x7f0b002e);
        int l = ((Resources) (obj)).getInteger(0x7f090003);
        int i1 = ((Resources) (obj)).getColor(0x7f0b0030);
        float f = ((Resources) (obj)).getDimension(0x7f080032);
        float f1 = ((Resources) (obj)).getDimension(0x7f080031);
        boolean flag = ((Resources) (obj)).getBoolean(0x7f070006);
        boolean flag1 = ((Resources) (obj)).getBoolean(0x7f070007);
        attributeset = context.obtainStyledAttributes(attributeset, com.pipcamera.activity.R.styleable.CirclePageIndicator, i, 0);
        mCentered = attributeset.getBoolean(2, flag);
        mOrientation = attributeset.getInt(0, l);
        mPaintPageFill.setStyle(android.graphics.Paint.Style.FILL);
        mPaintPageFill.setColor(attributeset.getColor(5, j));
        mPaintStroke.setStyle(android.graphics.Paint.Style.STROKE);
        mPaintStroke.setColor(attributeset.getColor(8, i1));
        mPaintStroke.setStrokeWidth(attributeset.getDimension(3, f));
        mPaintFill.setStyle(android.graphics.Paint.Style.FILL);
        mPaintFill.setColor(attributeset.getColor(4, k));
        mRadius = attributeset.getDimension(6, f1);
        mSnap = attributeset.getBoolean(7, flag1);
        obj = attributeset.getDrawable(1);
        if (obj != null)
        {
            setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        }
        attributeset.recycle();
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    private int measureLong(int i)
    {
        int l = android.view.View.MeasureSpec.getMode(i);
        int j = android.view.View.MeasureSpec.getSize(i);
        if (l == 0x40000000 || mViewPager == null)
        {
            i = j;
        } else
        {
            i = mViewPager.getAdapter().getCount();
            float f = getPaddingLeft() + getPaddingRight();
            float f1 = i * 2;
            float f2 = mRadius;
            int k = (int)((float)(i - 1) * mRadius + (f + f1 * f2) + 1.0F);
            i = k;
            if (l == 0x80000000)
            {
                return Math.min(k, j);
            }
        }
        return i;
    }

    private int measureShort(int i)
    {
        int j = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        if (j == 0x40000000)
        {
            return i;
        }
        int k = (int)(2.0F * mRadius + (float)getPaddingTop() + (float)getPaddingBottom() + 1.0F);
        if (j == 0x80000000)
        {
            return Math.min(k, i);
        } else
        {
            return k;
        }
    }

    public int getFillColor()
    {
        return mPaintFill.getColor();
    }

    public int getOrientation()
    {
        return mOrientation;
    }

    public int getPageColor()
    {
        return mPaintPageFill.getColor();
    }

    public float getRadius()
    {
        return mRadius;
    }

    public int getStrokeColor()
    {
        return mPaintStroke.getColor();
    }

    public float getStrokeWidth()
    {
        return mPaintStroke.getStrokeWidth();
    }

    public ViewPager getViewPager()
    {
        return mViewPager;
    }

    public boolean isCentered()
    {
        return mCentered;
    }

    public boolean isSnap()
    {
        return mSnap;
    }

    public void notifyDataSetChanged()
    {
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i1;
        if (mViewPager != null)
        {
            if ((i1 = mViewPager.getAdapter().getCount()) != 0)
            {
                if (mCurrentPage >= i1)
                {
                    setCurrentItem(i1 - 1);
                    return;
                }
                float f;
                float f1;
                float f2;
                float f3;
                float f5;
                int i;
                int j;
                int k;
                int l;
                if (mOrientation == 0)
                {
                    l = getWidth();
                    k = getPaddingLeft();
                    j = getPaddingRight();
                    i = getPaddingTop();
                } else
                {
                    l = getHeight();
                    k = getPaddingTop();
                    j = getPaddingBottom();
                    i = getPaddingLeft();
                }
                f5 = mRadius * 3F;
                f = i;
                f = mRadius + f;
                f2 = (float)k + mRadius;
                f1 = f2;
                if (mCentered)
                {
                    f1 = f2 + ((float)(l - k - j) / 2.0F - ((float)i1 * f5) / 2.0F);
                }
                f3 = mRadius;
                f2 = f3;
                if (mPaintStroke.getStrokeWidth() > 0.0F)
                {
                    f2 = f3 - mPaintStroke.getStrokeWidth() / 2.0F;
                }
                i = 0;
                while (i < i1) 
                {
                    f3 = (float)i * f5 + f1;
                    float f4;
                    if (mOrientation == 0)
                    {
                        f4 = f3;
                        f3 = f;
                    } else
                    {
                        f4 = f;
                    }
                    if (mPaintPageFill.getAlpha() > 0)
                    {
                        canvas.drawCircle(f4, f3, f2, mPaintPageFill);
                    }
                    if (f2 != mRadius)
                    {
                        canvas.drawCircle(f4, f3, mRadius, mPaintStroke);
                    }
                    i++;
                }
                if (mSnap)
                {
                    i = mSnapPage;
                } else
                {
                    i = mCurrentPage;
                }
                f3 = (float)i * f5;
                f2 = f3;
                if (!mSnap)
                {
                    f2 = f3 + mPageOffset * f5;
                }
                if (mOrientation == 0)
                {
                    f2 = f1 + f2;
                    f1 = f;
                    f = f2;
                } else
                {
                    f1 += f2;
                }
                canvas.drawCircle(f, f1, mRadius, mPaintFill);
                return;
            }
        }
    }

    protected void onMeasure(int i, int j)
    {
        if (mOrientation == 0)
        {
            setMeasuredDimension(measureLong(i), measureShort(j));
            return;
        } else
        {
            setMeasuredDimension(measureShort(i), measureLong(j));
            return;
        }
    }

    public void onPageScrollStateChanged(int i)
    {
        mScrollState = i;
        if (mListener != null)
        {
            mListener.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        mCurrentPage = i;
        mPageOffset = f;
        invalidate();
        if (mListener != null)
        {
            mListener.onPageScrolled(i, f, j);
        }
    }

    public void onPageSelected(int i)
    {
        if (mSnap || mScrollState == 0)
        {
            mCurrentPage = i;
            mSnapPage = i;
            invalidate();
        }
        if (mListener != null)
        {
            mListener.onPageSelected(i);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        mCurrentPage = ((SavedState) (parcelable)).a;
        mSnapPage = ((SavedState) (parcelable)).a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = mCurrentPage;
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i = 0;
        if (!super.onTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int j;
        if (mViewPager == null || mViewPager.getAdapter().getCount() == 0)
        {
            return false;
        }
        j = motionevent.getAction() & 0xff;
        j;
        JVM INSTR tableswitch 0 6: default 88
    //                   0 90
    //                   1 196
    //                   2 109
    //                   3 196
    //                   4 88
    //                   5 346
    //                   6 374;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L7 _L8
_L3:
        return true;
_L4:
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, 0);
        mLastMotionX = motionevent.getX();
        return true;
_L6:
        float f = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, mActivePointerId));
        float f2 = f - mLastMotionX;
        if (!mIsDragging && Math.abs(f2) > (float)mTouchSlop)
        {
            mIsDragging = true;
        }
        if (mIsDragging)
        {
            mLastMotionX = f;
            if (mViewPager.isFakeDragging() || mViewPager.beginFakeDrag())
            {
                mViewPager.fakeDragBy(f2);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (mIsDragging)
        {
            break; /* Loop/switch isn't completed */
        }
        i = mViewPager.getAdapter().getCount();
        int l = getWidth();
        float f1 = (float)l / 2.0F;
        float f3 = (float)l / 6F;
        if (mCurrentPage > 0 && motionevent.getX() < f1 - f3)
        {
            if (j != 3)
            {
                mViewPager.setCurrentItem(mCurrentPage - 1);
                return true;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (mCurrentPage >= i - 1 || motionevent.getX() <= f3 + f1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (j != 3)
        {
            mViewPager.setCurrentItem(mCurrentPage + 1);
            return true;
        }
        if (true) goto _L1; else goto _L9
_L9:
        mIsDragging = false;
        mActivePointerId = -1;
        if (mViewPager.isFakeDragging())
        {
            mViewPager.endFakeDrag();
            return true;
        }
          goto _L1
_L7:
        i = MotionEventCompat.getActionIndex(motionevent);
        mLastMotionX = MotionEventCompat.getX(motionevent, i);
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, i);
        return true;
_L8:
        int k = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, k) == mActivePointerId)
        {
            if (k == 0)
            {
                i = 1;
            }
            mActivePointerId = MotionEventCompat.getPointerId(motionevent, i);
        }
        mLastMotionX = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, mActivePointerId));
        return true;
    }

    public void setCentered(boolean flag)
    {
        mCentered = flag;
        invalidate();
    }

    public void setCurrentItem(int i)
    {
        if (mViewPager == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        } else
        {
            mViewPager.setCurrentItem(i);
            mCurrentPage = i;
            invalidate();
            return;
        }
    }

    public void setFillColor(int i)
    {
        mPaintFill.setColor(i);
        invalidate();
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        mListener = onpagechangelistener;
    }

    public void setOrientation(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");

        case 0: // '\0'
        case 1: // '\001'
            mOrientation = i;
            break;
        }
        requestLayout();
    }

    public void setPageColor(int i)
    {
        mPaintPageFill.setColor(i);
        invalidate();
    }

    public void setRadius(float f)
    {
        mRadius = f;
        invalidate();
    }

    public void setSnap(boolean flag)
    {
        mSnap = flag;
        invalidate();
    }

    public void setStrokeColor(int i)
    {
        mPaintStroke.setColor(i);
        invalidate();
    }

    public void setStrokeWidth(float f)
    {
        mPaintStroke.setStrokeWidth(f);
        invalidate();
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (mViewPager == viewpager)
        {
            return;
        }
        if (mViewPager != null)
        {
            mViewPager.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            mViewPager = viewpager;
            mViewPager.setOnPageChangeListener(this);
            invalidate();
            return;
        }
    }

    public void setViewPager(ViewPager viewpager, int i)
    {
        setViewPager(viewpager);
        setCurrentItem(i);
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i)
            {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        int a;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(a);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readInt();
        }


        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
