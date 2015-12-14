// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import cfv;
import cfw;
import java.util.ArrayList;

// Referenced classes of package viewpagerindicator:
//            PageIndicator

public class TitlePageIndicator extends View
    implements PageIndicator
{

    private static final float BOLD_FADE_PERCENTAGE = 0.05F;
    private static final String EMPTY_TITLE = "";
    private static final int INVALID_POINTER = -1;
    private static final float SELECTION_FADE_PERCENTAGE = 0.25F;
    private int mActivePointerId;
    private boolean mBoldText;
    private final Rect mBounds;
    private cfw mCenterItemClickListener;
    private float mClipPadding;
    private int mColorSelected;
    private int mColorText;
    private int mCurrentPage;
    private float mFooterIndicatorHeight;
    private IndicatorStyle mFooterIndicatorStyle;
    private float mFooterIndicatorUnderlinePadding;
    private float mFooterLineHeight;
    private float mFooterPadding;
    private boolean mIsDragging;
    private float mLastMotionX;
    private LinePosition mLinePosition;
    private android.support.v4.view.ViewPager.OnPageChangeListener mListener;
    private float mPageOffset;
    private final Paint mPaintFooterIndicator;
    private final Paint mPaintFooterLine;
    private final Paint mPaintText;
    private Path mPath;
    private int mScrollState;
    private float mTitlePadding;
    private float mTopPadding;
    private int mTouchSlop;
    private ViewPager mViewPager;

    public TitlePageIndicator(Context context)
    {
        this(context, null);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f0100e6);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mCurrentPage = -1;
        mPaintText = new Paint();
        mPath = new Path();
        mBounds = new Rect();
        mPaintFooterLine = new Paint();
        mPaintFooterIndicator = new Paint();
        mLastMotionX = -1F;
        mActivePointerId = -1;
        if (isInEditMode())
        {
            return;
        }
        Object obj = getResources();
        int j = ((Resources) (obj)).getColor(0x7f0c003e);
        float f = ((Resources) (obj)).getDimension(0x7f08003b);
        int k = ((Resources) (obj)).getInteger(0x7f090004);
        float f1 = ((Resources) (obj)).getDimension(0x7f080039);
        float f2 = ((Resources) (obj)).getDimension(0x7f08003a);
        float f3 = ((Resources) (obj)).getDimension(0x7f08003c);
        int l = ((Resources) (obj)).getInteger(0x7f090005);
        int i1 = ((Resources) (obj)).getColor(0x7f0c003f);
        boolean flag = ((Resources) (obj)).getBoolean(0x7f070009);
        int j1 = ((Resources) (obj)).getColor(0x7f0c0040);
        float f4 = ((Resources) (obj)).getDimension(0x7f08003d);
        float f5 = ((Resources) (obj)).getDimension(0x7f08003e);
        float f6 = ((Resources) (obj)).getDimension(0x7f080038);
        float f7 = ((Resources) (obj)).getDimension(0x7f08003f);
        attributeset = context.obtainStyledAttributes(attributeset, com.fotoable.fotobeauty.R.styleable.TitlePageIndicator, i, 0);
        mFooterLineHeight = attributeset.getDimension(6, f);
        mFooterIndicatorStyle = IndicatorStyle.fromValue(attributeset.getInteger(7, k));
        mFooterIndicatorHeight = attributeset.getDimension(8, f1);
        mFooterIndicatorUnderlinePadding = attributeset.getDimension(9, f2);
        mFooterPadding = attributeset.getDimension(10, f3);
        mLinePosition = LinePosition.fromValue(attributeset.getInteger(11, l));
        mTopPadding = attributeset.getDimension(14, f7);
        mTitlePadding = attributeset.getDimension(13, f5);
        mClipPadding = attributeset.getDimension(4, f6);
        mColorSelected = attributeset.getColor(3, i1);
        mColorText = attributeset.getColor(1, j1);
        mBoldText = attributeset.getBoolean(12, flag);
        f = attributeset.getDimension(0, f4);
        i = attributeset.getColor(5, j);
        mPaintText.setTextSize(f);
        mPaintText.setAntiAlias(true);
        mPaintFooterLine.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        mPaintFooterLine.setStrokeWidth(mFooterLineHeight);
        mPaintFooterLine.setColor(i);
        mPaintFooterIndicator.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        mPaintFooterIndicator.setColor(i);
        obj = attributeset.getDrawable(2);
        if (obj != null)
        {
            setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        }
        attributeset.recycle();
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    private Rect calcBounds(int i, Paint paint)
    {
        Rect rect = new Rect();
        CharSequence charsequence = getTitle(i);
        rect.right = (int)paint.measureText(charsequence, 0, charsequence.length());
        rect.bottom = (int)(paint.descent() - paint.ascent());
        return rect;
    }

    private ArrayList calculateAllBounds(Paint paint)
    {
        ArrayList arraylist = new ArrayList();
        int j = mViewPager.getAdapter().getCount();
        int k = getWidth();
        int l = k / 2;
        for (int i = 0; i < j; i++)
        {
            Rect rect = calcBounds(i, paint);
            int i1 = rect.right - rect.left;
            int j1 = rect.bottom;
            int k1 = rect.top;
            rect.left = (int)(((float)l - (float)i1 / 2.0F) + ((float)(i - mCurrentPage) - mPageOffset) * (float)k);
            rect.right = i1 + rect.left;
            rect.top = 0;
            rect.bottom = j1 - k1;
            arraylist.add(rect);
        }

        return arraylist;
    }

    private void clipViewOnTheLeft(Rect rect, float f, int i)
    {
        rect.left = (int)((float)i + mClipPadding);
        rect.right = (int)(mClipPadding + f);
    }

    private void clipViewOnTheRight(Rect rect, float f, int i)
    {
        rect.right = (int)((float)i - mClipPadding);
        rect.left = (int)((float)rect.right - f);
    }

    private CharSequence getTitle(int i)
    {
        CharSequence charsequence = mViewPager.getAdapter().getPageTitle(i);
        Object obj = charsequence;
        if (charsequence == null)
        {
            obj = "";
        }
        return ((CharSequence) (obj));
    }

    public float getClipPadding()
    {
        return mClipPadding;
    }

    public int getFooterColor()
    {
        return mPaintFooterLine.getColor();
    }

    public float getFooterIndicatorHeight()
    {
        return mFooterIndicatorHeight;
    }

    public float getFooterIndicatorPadding()
    {
        return mFooterPadding;
    }

    public IndicatorStyle getFooterIndicatorStyle()
    {
        return mFooterIndicatorStyle;
    }

    public float getFooterLineHeight()
    {
        return mFooterLineHeight;
    }

    public LinePosition getLinePosition()
    {
        return mLinePosition;
    }

    public int getSelectedColor()
    {
        return mColorSelected;
    }

    public int getTextColor()
    {
        return mColorText;
    }

    public float getTextSize()
    {
        return mPaintText.getTextSize();
    }

    public float getTitlePadding()
    {
        return mTitlePadding;
    }

    public float getTopPadding()
    {
        return mTopPadding;
    }

    public Typeface getTypeface()
    {
        return mPaintText.getTypeface();
    }

    public boolean isSelectedBold()
    {
        return mBoldText;
    }

    public void notifyDataSetChanged()
    {
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int l2;
        if (mViewPager != null)
        {
            if ((l2 = mViewPager.getAdapter().getCount()) != 0)
            {
                if (mCurrentPage == -1 && mViewPager != null)
                {
                    mCurrentPage = mViewPager.getCurrentItem();
                }
                Object obj = calculateAllBounds(mPaintText);
                int j2 = ((ArrayList) (obj)).size();
                if (mCurrentPage >= j2)
                {
                    setCurrentItem(j2 - 1);
                    return;
                }
                float f2 = (float)getWidth() / 2.0F;
                int i3 = getLeft();
                float f1 = (float)i3 + mClipPadding;
                int k2 = getWidth();
                int i2 = getHeight();
                int j3 = i3 + k2;
                float f5 = (float)j3 - mClipPadding;
                int i = mCurrentPage;
                float f;
                float f4;
                Rect rect;
                boolean flag;
                int j;
                if ((double)mPageOffset <= 0.5D)
                {
                    f = mPageOffset;
                } else
                {
                    f = mPageOffset;
                    i++;
                    f = 1.0F - f;
                }
                if (f <= 0.25F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (f <= 0.05F)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                f4 = (0.25F - f) / 0.25F;
                rect = (Rect)((ArrayList) (obj)).get(mCurrentPage);
                f = rect.right - rect.left;
                if ((float)rect.left < f1)
                {
                    clipViewOnTheLeft(rect, f, i3);
                }
                if ((float)rect.right > f5)
                {
                    clipViewOnTheRight(rect, f, j3);
                }
                if (mCurrentPage > 0)
                {
                    for (int k = mCurrentPage - 1; k >= 0; k--)
                    {
                        Rect rect1 = (Rect)((ArrayList) (obj)).get(k);
                        if ((float)rect1.left >= f1)
                        {
                            continue;
                        }
                        int j1 = rect1.right - rect1.left;
                        clipViewOnTheLeft(rect1, j1, i3);
                        Rect rect4 = (Rect)((ArrayList) (obj)).get(k + 1);
                        if ((float)rect1.right + mTitlePadding > (float)rect4.left)
                        {
                            rect1.left = (int)((float)(rect4.left - j1) - mTitlePadding);
                            rect1.right = rect1.left + j1;
                        }
                    }

                }
                if (mCurrentPage < l2 - 1)
                {
                    for (int l = mCurrentPage + 1; l < l2; l++)
                    {
                        Rect rect2 = (Rect)((ArrayList) (obj)).get(l);
                        if ((float)rect2.right <= f5)
                        {
                            continue;
                        }
                        int k1 = rect2.right - rect2.left;
                        clipViewOnTheRight(rect2, k1, j3);
                        Rect rect5 = (Rect)((ArrayList) (obj)).get(l - 1);
                        if ((float)rect2.left - mTitlePadding < (float)rect5.right)
                        {
                            rect2.left = (int)((float)rect5.right + mTitlePadding);
                            rect2.right = rect2.left + k1;
                        }
                    }

                }
                int k3 = mColorText >>> 24;
                int i1 = 0;
                while (i1 < l2) 
                {
                    Rect rect3 = (Rect)((ArrayList) (obj)).get(i1);
                    if ((rect3.left <= i3 || rect3.left >= j3) && (rect3.right <= i3 || rect3.right >= j3))
                    {
                        continue;
                    }
                    CharSequence charsequence;
                    Paint paint;
                    int l1;
                    int i4;
                    boolean flag1;
                    if (i1 == i)
                    {
                        l1 = 1;
                    } else
                    {
                        l1 = 0;
                    }
                    charsequence = getTitle(i1);
                    paint = mPaintText;
                    if (l1 != 0 && j && mBoldText)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    paint.setFakeBoldText(flag1);
                    mPaintText.setColor(mColorText);
                    if (l1 != 0 && flag)
                    {
                        mPaintText.setAlpha(k3 - (int)((float)k3 * f4));
                    }
                    if (i1 < j2 - 1)
                    {
                        Rect rect6 = (Rect)((ArrayList) (obj)).get(i1 + 1);
                        if ((float)rect3.right + mTitlePadding > (float)rect6.left)
                        {
                            int l3 = rect3.right - rect3.left;
                            rect3.left = (int)((float)(rect6.left - l3) - mTitlePadding);
                            rect3.right = rect3.left + l3;
                        }
                    }
                    i4 = charsequence.length();
                    f = rect3.left;
                    f1 = rect3.bottom;
                    canvas.drawText(charsequence, 0, i4, f, mTopPadding + f1, mPaintText);
                    if (l1 != 0 && flag)
                    {
                        mPaintText.setColor(mColorSelected);
                        mPaintText.setAlpha((int)((float)(mColorSelected >>> 24) * f4));
                        l1 = charsequence.length();
                        f = rect3.left;
                        f1 = rect3.bottom;
                        canvas.drawText(charsequence, 0, l1, f, mTopPadding + f1, mPaintText);
                    }
                    i1++;
                }
                f1 = mFooterLineHeight;
                f = mFooterIndicatorHeight;
                if (mLinePosition == LinePosition.Top)
                {
                    j = 0;
                    f1 = -f1;
                    f = -f;
                } else
                {
                    j = i2;
                }
                mPath.reset();
                mPath.moveTo(0.0F, (float)j - f1 / 2.0F);
                mPath.lineTo(k2, (float)j - f1 / 2.0F);
                mPath.close();
                canvas.drawPath(mPath, mPaintFooterLine);
                f1 = (float)j - f1;
                switch (cfv.a[mFooterIndicatorStyle.ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    mPath.reset();
                    mPath.moveTo(f2, f1 - f);
                    mPath.lineTo(f2 + f, f1);
                    mPath.lineTo(f2 - f, f1);
                    mPath.close();
                    canvas.drawPath(mPath, mPaintFooterIndicator);
                    return;

                case 2: // '\002'
                    break;
                }
                if (flag && i < j2)
                {
                    obj = (Rect)((ArrayList) (obj)).get(i);
                    float f3 = (float)((Rect) (obj)).right + mFooterIndicatorUnderlinePadding;
                    float f6 = (float)((Rect) (obj)).left - mFooterIndicatorUnderlinePadding;
                    f = f1 - f;
                    mPath.reset();
                    mPath.moveTo(f6, f1);
                    mPath.lineTo(f3, f1);
                    mPath.lineTo(f3, f);
                    mPath.lineTo(f6, f);
                    mPath.close();
                    mPaintFooterIndicator.setAlpha((int)(255F * f4));
                    canvas.drawPath(mPath, mPaintFooterIndicator);
                    mPaintFooterIndicator.setAlpha(255);
                    return;
                }
            }
        }
    }

    protected void onMeasure(int i, int j)
    {
        i = android.view.View.MeasureSpec.getSize(i);
        if (android.view.View.MeasureSpec.getMode(j) != 0x40000000) goto _L2; else goto _L1
_L1:
        float f = android.view.View.MeasureSpec.getSize(j);
_L4:
        setMeasuredDimension(i, (int)f);
        return;
_L2:
        mBounds.setEmpty();
        mBounds.bottom = (int)(mPaintText.descent() - mPaintText.ascent());
        float f1 = (float)(mBounds.bottom - mBounds.top) + mFooterLineHeight + mFooterPadding + mTopPadding;
        f = f1;
        if (mFooterIndicatorStyle != IndicatorStyle.None)
        {
            f = f1 + mFooterIndicatorHeight;
        }
        if (true) goto _L4; else goto _L3
_L3:
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
        if (mScrollState == 0)
        {
            mCurrentPage = i;
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
    //                   5 374
    //                   6 402;
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
          goto _L1
_L5:
        float f1;
        float f3;
        float f4;
        if (mIsDragging)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        i = mViewPager.getAdapter().getCount();
        int l = getWidth();
        f1 = (float)l / 2.0F;
        f3 = (float)l / 6F;
        f4 = motionevent.getX();
        if (f4 >= f1 - f3) goto _L10; else goto _L9
_L9:
        if (mCurrentPage <= 0)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        if (j != 3)
        {
            mViewPager.setCurrentItem(mCurrentPage - 1);
            return true;
        }
          goto _L1
_L10:
        if (f4 <= f3 + f1) goto _L12; else goto _L11
_L11:
        if (mCurrentPage >= i - 1)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        if (j != 3)
        {
            mViewPager.setCurrentItem(mCurrentPage + 1);
            return true;
        }
          goto _L1
_L12:
        if (mCenterItemClickListener != null && j != 3)
        {
            mCenterItemClickListener.a(mCurrentPage);
        }
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

    public void setClipPadding(float f)
    {
        mClipPadding = f;
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

    public void setFooterColor(int i)
    {
        mPaintFooterLine.setColor(i);
        mPaintFooterIndicator.setColor(i);
        invalidate();
    }

    public void setFooterIndicatorHeight(float f)
    {
        mFooterIndicatorHeight = f;
        invalidate();
    }

    public void setFooterIndicatorPadding(float f)
    {
        mFooterPadding = f;
        invalidate();
    }

    public void setFooterIndicatorStyle(IndicatorStyle indicatorstyle)
    {
        mFooterIndicatorStyle = indicatorstyle;
        invalidate();
    }

    public void setFooterLineHeight(float f)
    {
        mFooterLineHeight = f;
        mPaintFooterLine.setStrokeWidth(mFooterLineHeight);
        invalidate();
    }

    public void setLinePosition(LinePosition lineposition)
    {
        mLinePosition = lineposition;
        invalidate();
    }

    public void setOnCenterItemClickListener(cfw cfw1)
    {
        mCenterItemClickListener = cfw1;
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        mListener = onpagechangelistener;
    }

    public void setSelectedBold(boolean flag)
    {
        mBoldText = flag;
        invalidate();
    }

    public void setSelectedColor(int i)
    {
        mColorSelected = i;
        invalidate();
    }

    public void setTextColor(int i)
    {
        mPaintText.setColor(i);
        mColorText = i;
        invalidate();
    }

    public void setTextSize(float f)
    {
        mPaintText.setTextSize(f);
        invalidate();
    }

    public void setTitlePadding(float f)
    {
        mTitlePadding = f;
        invalidate();
    }

    public void setTopPadding(float f)
    {
        mTopPadding = f;
        invalidate();
    }

    public void setTypeface(Typeface typeface)
    {
        mPaintText.setTypeface(typeface);
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

    private class IndicatorStyle extends Enum
    {

        private static final IndicatorStyle $VALUES[];
        public static final IndicatorStyle None;
        public static final IndicatorStyle Triangle;
        public static final IndicatorStyle Underline;
        public final int value;

        public static IndicatorStyle fromValue(int i)
        {
            IndicatorStyle aindicatorstyle[] = values();
            int k = aindicatorstyle.length;
            for (int j = 0; j < k; j++)
            {
                IndicatorStyle indicatorstyle = aindicatorstyle[j];
                if (indicatorstyle.value == i)
                {
                    return indicatorstyle;
                }
            }

            return null;
        }

        public static IndicatorStyle valueOf(String s)
        {
            return (IndicatorStyle)Enum.valueOf(viewpagerindicator/TitlePageIndicator$IndicatorStyle, s);
        }

        public static IndicatorStyle[] values()
        {
            return (IndicatorStyle[])$VALUES.clone();
        }

        static 
        {
            None = new IndicatorStyle("None", 0, 0);
            Triangle = new IndicatorStyle("Triangle", 1, 1);
            Underline = new IndicatorStyle("Underline", 2, 2);
            $VALUES = (new IndicatorStyle[] {
                None, Triangle, Underline
            });
        }

        private IndicatorStyle(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    private class LinePosition extends Enum
    {

        private static final LinePosition $VALUES[];
        public static final LinePosition Bottom;
        public static final LinePosition Top;
        public final int value;

        public static LinePosition fromValue(int i)
        {
            LinePosition alineposition[] = values();
            int k = alineposition.length;
            for (int j = 0; j < k; j++)
            {
                LinePosition lineposition = alineposition[j];
                if (lineposition.value == i)
                {
                    return lineposition;
                }
            }

            return null;
        }

        public static LinePosition valueOf(String s)
        {
            return (LinePosition)Enum.valueOf(viewpagerindicator/TitlePageIndicator$LinePosition, s);
        }

        public static LinePosition[] values()
        {
            return (LinePosition[])$VALUES.clone();
        }

        static 
        {
            Bottom = new LinePosition("Bottom", 0, 0);
            Top = new LinePosition("Top", 1, 1);
            $VALUES = (new LinePosition[] {
                Bottom, Top
            });
        }

        private LinePosition(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new cfx();
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

        public SavedState(Parcel parcel, cfv cfv1)
        {
            this(parcel);
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
