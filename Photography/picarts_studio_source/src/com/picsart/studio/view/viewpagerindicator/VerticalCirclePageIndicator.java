// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import myobfuscated.bf.a;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            VerticalViewPager, f

public class VerticalCirclePageIndicator extends View
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    private float a;
    private final Paint b;
    private final Paint c;
    private final Paint d;
    private VerticalViewPager e;
    private android.support.v4.view.ViewPager.OnPageChangeListener f;
    private int g;
    private int h;
    private float i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private float o;
    private int p;
    private boolean q;

    public VerticalCirclePageIndicator(Context context)
    {
        this(context, null);
    }

    public VerticalCirclePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f01015b);
    }

    public VerticalCirclePageIndicator(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        b = new Paint(1);
        c = new Paint(1);
        d = new Paint(1);
        o = -1F;
        p = -1;
        if (isInEditMode())
        {
            return;
        } else
        {
            Resources resources = getResources();
            int j1 = resources.getColor(0x7f0f0079);
            int k1 = resources.getColor(0x7f0f0078);
            int l1 = resources.getInteger(0x7f0e0022);
            int i2 = resources.getColor(0x7f0f007a);
            float f1 = resources.getDimension(0x7f0b00c7);
            float f2 = resources.getDimension(0x7f0b00c6);
            boolean flag = resources.getBoolean(0x7f0d0008);
            boolean flag1 = resources.getBoolean(0x7f0d0009);
            attributeset = context.obtainStyledAttributes(attributeset, a.CirclePageIndicator, i1, 0);
            l = attributeset.getBoolean(a.CirclePageIndicator_centered, flag);
            k = attributeset.getInt(a.CirclePageIndicator_android_orientation, l1);
            b.setStyle(android.graphics.Paint.Style.FILL);
            b.setColor(attributeset.getColor(a.CirclePageIndicator_pageColor, j1));
            c.setStyle(android.graphics.Paint.Style.STROKE);
            c.setColor(attributeset.getColor(a.CirclePageIndicator_strokeColor, i2));
            c.setStrokeWidth(attributeset.getDimension(a.CirclePageIndicator_strokeWidth, f1));
            d.setStyle(android.graphics.Paint.Style.FILL);
            d.setColor(attributeset.getColor(a.CirclePageIndicator_fillColor, k1));
            a = attributeset.getDimension(a.CirclePageIndicator_radius, f2);
            m = attributeset.getBoolean(a.CirclePageIndicator_snap, flag1);
            attributeset.recycle();
            n = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
            return;
        }
    }

    private int a(int i1)
    {
        int l1 = android.view.View.MeasureSpec.getMode(i1);
        int j1 = android.view.View.MeasureSpec.getSize(i1);
        if (l1 == 0x40000000 || e == null)
        {
            i1 = j1;
        } else
        {
            i1 = e.b.getCount();
            float f1 = getPaddingLeft() + getPaddingRight();
            float f2 = i1 * 2;
            float f3 = a;
            int k1 = (int)((float)(i1 - 1) * a + (f1 + f2 * f3) + 1.0F);
            i1 = k1;
            if (l1 == 0x80000000)
            {
                return Math.min(k1, j1);
            }
        }
        return i1;
    }

    private int b(int i1)
    {
        int j1 = android.view.View.MeasureSpec.getMode(i1);
        i1 = android.view.View.MeasureSpec.getSize(i1);
        if (j1 == 0x40000000)
        {
            return i1;
        }
        int k1 = (int)(2.0F * a + (float)getPaddingTop() + (float)getPaddingBottom() + 1.0F);
        if (j1 == 0x80000000)
        {
            return Math.min(k1, i1);
        } else
        {
            return k1;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i2;
        if (e != null)
        {
            if ((i2 = e.b.getCount()) != 0)
            {
                if (g >= i2)
                {
                    setCurrentItem(i2 - 1);
                    return;
                }
                float f1;
                float f2;
                float f3;
                float f4;
                float f6;
                int i1;
                int j1;
                int k1;
                int l1;
                if (k == 0)
                {
                    l1 = getWidth();
                    k1 = getPaddingLeft();
                    j1 = getPaddingRight();
                    i1 = getPaddingTop();
                } else
                {
                    l1 = getHeight();
                    k1 = getPaddingTop();
                    j1 = getPaddingBottom();
                    i1 = getPaddingLeft();
                }
                f6 = a * 3F;
                f1 = i1;
                f1 = a + f1;
                f3 = (float)k1 + a;
                f2 = f3;
                if (l)
                {
                    f2 = f3 + ((float)(l1 - k1 - j1) / 2.0F - ((float)i2 * f6) / 2.0F);
                }
                f4 = a;
                f3 = f4;
                if (c.getStrokeWidth() > 0.0F)
                {
                    f3 = f4 - c.getStrokeWidth() / 2.0F;
                }
                i1 = 0;
                while (i1 < i2) 
                {
                    f4 = (float)i1 * f6 + f2;
                    float f5;
                    if (k == 0)
                    {
                        f5 = f4;
                        f4 = f1;
                    } else
                    {
                        f5 = f1;
                    }
                    if (b.getAlpha() > 0)
                    {
                        canvas.drawCircle(f5, f4, f3, b);
                    }
                    if (f3 != a)
                    {
                        canvas.drawCircle(f5, f4, a, c);
                    }
                    i1++;
                }
                if (m)
                {
                    i1 = h;
                } else
                {
                    i1 = g;
                }
                f4 = (float)i1 * f6;
                f3 = f4;
                if (!m)
                {
                    f3 = f4 + i * f6;
                }
                if (k == 0)
                {
                    f3 = f2 + f3;
                    f2 = f1;
                    f1 = f3;
                } else
                {
                    f2 += f3;
                }
                canvas.drawCircle(f1, f2, a, d);
                return;
            }
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        if (k == 0)
        {
            setMeasuredDimension(a(i1), b(j1));
            return;
        } else
        {
            setMeasuredDimension(b(i1), a(j1));
            return;
        }
    }

    public void onPageScrollStateChanged(int i1)
    {
        j = i1;
        if (f != null)
        {
            f.onPageScrollStateChanged(i1);
        }
    }

    public void onPageScrolled(int i1, float f1, int j1)
    {
        g = i1;
        i = f1;
        invalidate();
        if (f != null)
        {
            f.onPageScrolled(i1, f1, j1);
        }
    }

    public void onPageSelected(int i1)
    {
        if (m || j == 0)
        {
            g = i1;
            h = i1;
            invalidate();
        }
        if (f != null)
        {
            f.onPageSelected(i1);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        g = ((SavedState) (parcelable)).a;
        h = ((SavedState) (parcelable)).a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = g;
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (super.onTouchEvent(motionevent))
        {
            return true;
        }
        if (e == null || e.b.getCount() == 0)
        {
            return false;
        }
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 6: default 84
    //                   0 86
    //                   1 518
    //                   2 106
    //                   3 518
    //                   4 84
    //                   5 784
    //                   6 813;
           goto _L1 _L2 _L3 _L4 _L3 _L1 _L5 _L6
_L1:
        return true;
_L2:
        p = MotionEventCompat.getPointerId(motionevent, 0);
        o = motionevent.getX();
        continue; /* Loop/switch isn't completed */
_L4:
        float f1 = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, p));
        float f2 = f1 - o;
        if (!q && Math.abs(f2) > (float)n)
        {
            q = true;
        }
        if (!q)
        {
            continue; /* Loop/switch isn't completed */
        }
        o = f1;
        if (!e.l)
        {
            motionevent = e;
            boolean flag;
            if (((VerticalViewPager) (motionevent)).f)
            {
                flag = false;
            } else
            {
                motionevent.l = true;
                motionevent.a(1);
                motionevent.g = 0.0F;
                motionevent.h = 0.0F;
                MotionEvent motionevent1;
                long l1;
                if (((VerticalViewPager) (motionevent)).j == null)
                {
                    motionevent.j = VelocityTracker.obtain();
                } else
                {
                    ((VerticalViewPager) (motionevent)).j.clear();
                }
                l1 = SystemClock.uptimeMillis();
                motionevent1 = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
                ((VerticalViewPager) (motionevent)).j.addMovement(motionevent1);
                motionevent1.recycle();
                motionevent.m = l1;
                flag = true;
            }
            if (!flag)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        motionevent = e;
        if (!((VerticalViewPager) (motionevent)).l)
        {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        motionevent.g = ((VerticalViewPager) (motionevent)).g + f2;
        float f3 = (float)motionevent.getScrollY() - f2;
        int i1 = motionevent.a();
        f1 = i1;
        float f5 = ((VerticalViewPager) (motionevent)).c;
        f2 = i1;
        float f4 = ((VerticalViewPager) (motionevent)).d;
        Object obj = (f)((VerticalViewPager) (motionevent)).a.get(0);
        f f6 = (f)((VerticalViewPager) (motionevent)).a.get(((VerticalViewPager) (motionevent)).a.size() - 1);
        int j1;
        int k1;
        long l2;
        if (((f) (obj)).b != 0)
        {
            f1 = ((f) (obj)).e * (float)i1;
        } else
        {
            f1 *= f5;
        }
        if (f6.b != ((VerticalViewPager) (motionevent)).b.getCount() - 1)
        {
            f2 = f6.e * (float)i1;
        } else
        {
            f2 *= f4;
        }
        if (f3 >= f1)
        {
            if (f3 > f2)
            {
                f1 = f2;
            } else
            {
                f1 = f3;
            }
        }
        motionevent.g = ((VerticalViewPager) (motionevent)).g + (f1 - (float)(int)f1);
        motionevent.scrollTo(motionevent.getScrollX(), (int)f1);
        motionevent.b((int)f1);
        l2 = SystemClock.uptimeMillis();
        obj = MotionEvent.obtain(((VerticalViewPager) (motionevent)).m, l2, 2, 0.0F, ((VerticalViewPager) (motionevent)).g, 0);
        ((VerticalViewPager) (motionevent)).j.addMovement(((MotionEvent) (obj)));
        ((MotionEvent) (obj)).recycle();
        continue; /* Loop/switch isn't completed */
_L3:
        if (!q)
        {
            i1 = e.b.getCount();
            j1 = getWidth();
            f1 = (float)j1 / 2.0F;
            f2 = (float)j1 / 6F;
            if (g > 0 && motionevent.getX() < f1 - f2)
            {
                e.setCurrentItem(g - 1);
                return true;
            }
            if (g < i1 - 1 && motionevent.getX() > f2 + f1)
            {
                e.setCurrentItem(g + 1);
                return true;
            }
        }
        q = false;
        p = -1;
        if (e.l)
        {
            motionevent = e;
            if (!((VerticalViewPager) (motionevent)).l)
            {
                throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
            }
            obj = ((VerticalViewPager) (motionevent)).j;
            ((VelocityTracker) (obj)).computeCurrentVelocity(1000, ((VerticalViewPager) (motionevent)).k);
            i1 = (int)VelocityTrackerCompat.getYVelocity(((VelocityTracker) (obj)), ((VerticalViewPager) (motionevent)).i);
            motionevent.e = true;
            j1 = motionevent.a();
            k1 = motionevent.getScrollY();
            obj = motionevent.d();
            motionevent.a(motionevent.a(((f) (obj)).b, ((float)k1 / (float)j1 - ((f) (obj)).e) / ((f) (obj)).d, i1, (int)(((VerticalViewPager) (motionevent)).g - ((VerticalViewPager) (motionevent)).h)), true, true, i1);
            motionevent.e();
            motionevent.l = false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i1 = MotionEventCompat.getActionIndex(motionevent);
        o = MotionEventCompat.getX(motionevent, i1);
        p = MotionEventCompat.getPointerId(motionevent, i1);
        continue; /* Loop/switch isn't completed */
_L6:
        i1 = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, i1) == p)
        {
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            p = MotionEventCompat.getPointerId(motionevent, i1);
        }
        o = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, p));
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void setCentered(boolean flag)
    {
        l = flag;
        invalidate();
    }

    public void setCurrentItem(int i1)
    {
        if (e == null)
        {
            throw new IllegalStateException("VerticalViewPager has not been bound.");
        } else
        {
            e.setCurrentItem(i1);
            g = i1;
            invalidate();
            return;
        }
    }

    public void setFillColor(int i1)
    {
        d.setColor(i1);
        invalidate();
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        f = onpagechangelistener;
    }

    public void setOrientation(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");

        case 0: // '\0'
        case 1: // '\001'
            k = i1;
            break;
        }
        requestLayout();
    }

    public void setPageColor(int i1)
    {
        b.setColor(i1);
        invalidate();
    }

    public void setRadius(float f1)
    {
        a = f1;
        invalidate();
    }

    public void setSnap(boolean flag)
    {
        m = flag;
        invalidate();
    }

    public void setStrokeColor(int i1)
    {
        c.setColor(i1);
        invalidate();
    }

    public void setStrokeWidth(float f1)
    {
        c.setStrokeWidth(f1);
        invalidate();
    }

    public void setViewPager(VerticalViewPager verticalviewpager)
    {
        if (e == verticalviewpager)
        {
            return;
        }
        if (e != null)
        {
            e.setOnPageChangeListener(null);
        }
        if (verticalviewpager.b == null)
        {
            throw new IllegalStateException("VerticalViewPager does not have adapter instance.");
        } else
        {
            e = verticalviewpager;
            e.setOnPageChangeListener(this);
            invalidate();
            return;
        }
    }

    public void setViewPager(VerticalViewPager verticalviewpager, int i1)
    {
        setViewPager(verticalviewpager);
        setCurrentItem(i1);
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel, (byte)0);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        int a;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readInt();
        }

        SavedState(Parcel parcel, byte byte0)
        {
            this(parcel);
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
