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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import cfy;
import cfz;

// Referenced classes of package viewpagerindicator:
//            PageIndicator

public class UnderlinePageIndicator extends View
    implements PageIndicator
{

    private static final int FADE_FRAME_MS = 30;
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private int mCurrentPage;
    private int mFadeBy;
    private int mFadeDelay;
    private int mFadeLength;
    private final Runnable mFadeRunnable;
    private boolean mFades;
    private boolean mIsDragging;
    private float mLastMotionX;
    private android.support.v4.view.ViewPager.OnPageChangeListener mListener;
    private final Paint mPaint;
    private float mPositionOffset;
    private int mScrollState;
    private int mTouchSlop;
    private ViewPager mViewPager;

    public UnderlinePageIndicator(Context context)
    {
        this(context, null);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f0100e8);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mPaint = new Paint(1);
        mLastMotionX = -1F;
        mActivePointerId = -1;
        mFadeRunnable = new cfy(this);
        if (isInEditMode())
        {
            return;
        }
        Object obj = getResources();
        boolean flag = ((Resources) (obj)).getBoolean(0x7f07000a);
        int j = ((Resources) (obj)).getInteger(0x7f090006);
        int k = ((Resources) (obj)).getInteger(0x7f090007);
        int l = ((Resources) (obj)).getColor(0x7f0c0041);
        attributeset = context.obtainStyledAttributes(attributeset, com.fotoable.fotobeauty.R.styleable.UnderlinePageIndicator, i, 0);
        setFades(attributeset.getBoolean(2, flag));
        setSelectedColor(attributeset.getColor(1, l));
        setFadeDelay(attributeset.getInteger(3, j));
        setFadeLength(attributeset.getInteger(4, k));
        obj = attributeset.getDrawable(0);
        if (obj != null)
        {
            setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        }
        attributeset.recycle();
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    public int getFadeDelay()
    {
        return mFadeDelay;
    }

    public int getFadeLength()
    {
        return mFadeLength;
    }

    public boolean getFades()
    {
        return mFades;
    }

    public int getSelectedColor()
    {
        return mPaint.getColor();
    }

    public void notifyDataSetChanged()
    {
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i;
        if (mViewPager != null)
        {
            if ((i = mViewPager.getAdapter().getCount()) != 0)
            {
                if (mCurrentPage >= i)
                {
                    setCurrentItem(i - 1);
                    return;
                } else
                {
                    int j = getPaddingLeft();
                    float f = (float)(getWidth() - j - getPaddingRight()) / ((float)i * 1.0F);
                    float f1 = (float)j + ((float)mCurrentPage + mPositionOffset) * f;
                    canvas.drawRect(f1, getPaddingTop(), f1 + f, getHeight() - getPaddingBottom(), mPaint);
                    return;
                }
            }
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
        mPositionOffset = f;
        if (!mFades) goto _L2; else goto _L1
_L1:
        if (j <= 0) goto _L4; else goto _L3
_L3:
        removeCallbacks(mFadeRunnable);
        mPaint.setAlpha(255);
_L2:
        invalidate();
        if (mListener != null)
        {
            mListener.onPageScrolled(i, f, j);
        }
        return;
_L4:
        if (mScrollState != 1)
        {
            postDelayed(mFadeRunnable, mFadeDelay);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onPageSelected(int i)
    {
        if (mScrollState == 0)
        {
            mCurrentPage = i;
            mPositionOffset = 0.0F;
            invalidate();
            mFadeRunnable.run();
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

    public void setFadeDelay(int i)
    {
        mFadeDelay = i;
    }

    public void setFadeLength(int i)
    {
        mFadeLength = i;
        mFadeBy = 255 / (mFadeLength / 30);
    }

    public void setFades(boolean flag)
    {
label0:
        {
            if (flag != mFades)
            {
                mFades = flag;
                if (!flag)
                {
                    break label0;
                }
                post(mFadeRunnable);
            }
            return;
        }
        removeCallbacks(mFadeRunnable);
        mPaint.setAlpha(255);
        invalidate();
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        mListener = onpagechangelistener;
    }

    public void setSelectedColor(int i)
    {
        mPaint.setColor(i);
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
            post(new cfz(this));
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

        public static final android.os.Parcelable.Creator CREATOR = new cga();
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

        public SavedState(Parcel parcel, cfy cfy1)
        {
            this(parcel);
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
