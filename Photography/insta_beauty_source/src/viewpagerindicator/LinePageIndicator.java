// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package viewpagerindicator;

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
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package viewpagerindicator:
//            PageIndicator

public class LinePageIndicator extends View
    implements PageIndicator
{

    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private boolean mCentered;
    private int mCurrentPage;
    private float mGapWidth;
    private boolean mIsDragging;
    private float mLastMotionX;
    private float mLineWidth;
    private android.support.v4.view.ViewPager.OnPageChangeListener mListener;
    private final Paint mPaintSelected;
    private final Paint mPaintUnselected;
    private int mTouchSlop;
    private ViewPager mViewPager;

    public LinePageIndicator(Context context)
    {
        this(context, null);
    }

    public LinePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f0100e5);
    }

    public LinePageIndicator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mPaintUnselected = new Paint(1);
        mPaintSelected = new Paint(1);
        mLastMotionX = -1F;
        mActivePointerId = -1;
        if (isInEditMode())
        {
            return;
        }
        Object obj = getResources();
        int j = ((Resources) (obj)).getColor(0x7f0c003c);
        int k = ((Resources) (obj)).getColor(0x7f0c003d);
        float f = ((Resources) (obj)).getDimension(0x7f080036);
        float f1 = ((Resources) (obj)).getDimension(0x7f080035);
        float f2 = ((Resources) (obj)).getDimension(0x7f080037);
        boolean flag = ((Resources) (obj)).getBoolean(0x7f070008);
        attributeset = context.obtainStyledAttributes(attributeset, com.fotoable.fotobeauty.R.styleable.LinePageIndicator, i, 0);
        mCentered = attributeset.getBoolean(1, flag);
        mLineWidth = attributeset.getDimension(5, f);
        mGapWidth = attributeset.getDimension(6, f1);
        setStrokeWidth(attributeset.getDimension(3, f2));
        mPaintUnselected.setColor(attributeset.getColor(4, k));
        mPaintSelected.setColor(attributeset.getColor(2, j));
        obj = attributeset.getDrawable(0);
        if (obj != null)
        {
            setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        }
        attributeset.recycle();
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    private int measureHeight(int i)
    {
        int j;
        j = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        if (j != 0x40000000) goto _L2; else goto _L1
_L1:
        float f = i;
_L4:
        return (int)FloatMath.ceil(f);
_L2:
        float f1 = mPaintSelected.getStrokeWidth() + (float)getPaddingTop() + (float)getPaddingBottom();
        f = f1;
        if (j == 0x80000000)
        {
            f = Math.min(f1, i);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int measureWidth(int i)
    {
        int j;
        j = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        if (j != 0x40000000 && mViewPager != null) goto _L2; else goto _L1
_L1:
        float f = i;
_L4:
        return (int)FloatMath.ceil(f);
_L2:
        int k = mViewPager.getAdapter().getCount();
        f = getPaddingLeft() + getPaddingRight();
        float f1 = k;
        float f2 = mLineWidth;
        f1 = (float)(k - 1) * mGapWidth + (f + f1 * f2);
        f = f1;
        if (j == 0x80000000)
        {
            f = Math.min(f1, i);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public float getGapWidth()
    {
        return mGapWidth;
    }

    public float getLineWidth()
    {
        return mLineWidth;
    }

    public int getSelectedColor()
    {
        return mPaintSelected.getColor();
    }

    public float getStrokeWidth()
    {
        return mPaintSelected.getStrokeWidth();
    }

    public int getUnselectedColor()
    {
        return mPaintUnselected.getColor();
    }

    public boolean isCentered()
    {
        return mCentered;
    }

    public void notifyDataSetChanged()
    {
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mViewPager != null) goto _L2; else goto _L1
_L1:
        int j;
        return;
_L2:
        if ((j = mViewPager.getAdapter().getCount()) != 0)
        {
            if (mCurrentPage >= j)
            {
                setCurrentItem(j - 1);
                return;
            }
            float f1 = mLineWidth + mGapWidth;
            float f3 = j;
            float f5 = mGapWidth;
            float f2 = getPaddingTop();
            float f = getPaddingLeft();
            float f7 = getPaddingRight();
            f2 += ((float)getHeight() - f2 - (float)getPaddingBottom()) / 2.0F;
            if (mCentered)
            {
                f += ((float)getWidth() - f - f7) / 2.0F - (f3 * f1 - f5) / 2.0F;
            }
            int i = 0;
            while (i < j) 
            {
                float f4 = f + (float)i * f1;
                float f6 = mLineWidth;
                Paint paint;
                if (i == mCurrentPage)
                {
                    paint = mPaintSelected;
                } else
                {
                    paint = mPaintUnselected;
                }
                canvas.drawLine(f4, f2, f4 + f6, f2, paint);
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(measureWidth(i), measureHeight(j));
    }

    public void onPageScrollStateChanged(int i)
    {
        if (mListener != null)
        {
            mListener.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (mListener != null)
        {
            mListener.onPageScrolled(i, f, j);
        }
    }

    public void onPageSelected(int i)
    {
        mCurrentPage = i;
        invalidate();
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

    public void setGapWidth(float f)
    {
        mGapWidth = f;
        invalidate();
    }

    public void setLineWidth(float f)
    {
        mLineWidth = f;
        invalidate();
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        mListener = onpagechangelistener;
    }

    public void setSelectedColor(int i)
    {
        mPaintSelected.setColor(i);
        invalidate();
    }

    public void setStrokeWidth(float f)
    {
        mPaintSelected.setStrokeWidth(f);
        mPaintUnselected.setStrokeWidth(f);
        invalidate();
    }

    public void setUnselectedColor(int i)
    {
        mPaintUnselected.setColor(i);
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

        public static final android.os.Parcelable.Creator CREATOR = new cfq();
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

        public SavedState(Parcel parcel, cfp cfp)
        {
            this(parcel);
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
