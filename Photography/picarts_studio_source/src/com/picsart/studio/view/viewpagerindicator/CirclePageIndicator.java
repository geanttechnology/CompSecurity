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
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import myobfuscated.bf.a;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            c

public class CirclePageIndicator extends View
    implements c
{

    public ViewPager a;
    private float b;
    private final Paint c;
    private final Paint d;
    private final Paint e;
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

    public CirclePageIndicator(Context context)
    {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f01015b);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        c = new Paint(1);
        d = new Paint(1);
        e = new Paint(1);
        o = -1F;
        p = -1;
        if (isInEditMode())
        {
            return;
        }
        Object obj = getResources();
        int j1 = ((Resources) (obj)).getColor(0x7f0f0079);
        int k1 = ((Resources) (obj)).getColor(0x7f0f0078);
        int l1 = ((Resources) (obj)).getInteger(0x7f0e0022);
        int i2 = ((Resources) (obj)).getColor(0x7f0f007a);
        float f1 = ((Resources) (obj)).getDimension(0x7f0b00c7);
        float f2 = ((Resources) (obj)).getDimension(0x7f0b00c6);
        boolean flag = ((Resources) (obj)).getBoolean(0x7f0d0008);
        boolean flag1 = ((Resources) (obj)).getBoolean(0x7f0d0009);
        attributeset = context.obtainStyledAttributes(attributeset, a.CirclePageIndicator, i1, 0);
        l = attributeset.getBoolean(a.CirclePageIndicator_centered, flag);
        k = attributeset.getInt(a.CirclePageIndicator_android_orientation, l1);
        c.setStyle(android.graphics.Paint.Style.FILL);
        c.setColor(attributeset.getColor(a.CirclePageIndicator_pageColor, j1));
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setColor(attributeset.getColor(a.CirclePageIndicator_strokeColor, i2));
        d.setStrokeWidth(attributeset.getDimension(a.CirclePageIndicator_strokeWidth, f1));
        e.setStyle(android.graphics.Paint.Style.FILL);
        e.setColor(attributeset.getColor(a.CirclePageIndicator_fillColor, k1));
        b = attributeset.getDimension(a.CirclePageIndicator_radius, f2);
        m = attributeset.getBoolean(a.CirclePageIndicator_snap, flag1);
        obj = attributeset.getDrawable(a.CirclePageIndicator_android_background);
        if (obj != null)
        {
            setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        }
        attributeset.recycle();
        n = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    private int a(int i1)
    {
        int l1 = android.view.View.MeasureSpec.getMode(i1);
        int j1 = android.view.View.MeasureSpec.getSize(i1);
        if (l1 == 0x40000000 || a == null)
        {
            i1 = j1;
        } else
        {
            i1 = a.getAdapter().getCount();
            float f1 = getPaddingLeft() + getPaddingRight();
            float f2 = i1 * 2;
            float f3 = b;
            int k1 = (int)((float)(i1 - 1) * b + (f1 + f2 * f3) + 1.0F);
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
        int k1 = (int)(2.0F * b + (float)getPaddingTop() + (float)getPaddingBottom() + 1.0F);
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
        if (a != null)
        {
            if ((i2 = a.getAdapter().getCount()) != 0)
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
                f6 = b * 3F;
                f1 = i1;
                f1 = b + f1;
                f3 = (float)k1 + b;
                f2 = f3;
                if (l)
                {
                    f2 = f3 + ((float)(l1 - k1 - j1) / 2.0F - ((float)i2 * f6) / 2.0F);
                }
                f4 = b;
                f3 = f4;
                if (d.getStrokeWidth() > 0.0F)
                {
                    f3 = f4 - d.getStrokeWidth() / 2.0F;
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
                    if (c.getAlpha() > 0)
                    {
                        canvas.drawCircle(f5, f4, f3, c);
                    }
                    if (f3 != b)
                    {
                        canvas.drawCircle(f5, f4, b, d);
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
                canvas.drawCircle(f1, f2, b, e);
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
        int i1 = 0;
        if (!super.onTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int j1;
        if (a == null || a.getAdapter().getCount() == 0)
        {
            return false;
        }
        j1 = motionevent.getAction() & 0xff;
        j1;
        JVM INSTR tableswitch 0 6: default 88
    //                   0 90
    //                   1 199
    //                   2 109
    //                   3 199
    //                   4 88
    //                   5 349
    //                   6 377;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L7 _L8
_L3:
        return true;
_L4:
        p = MotionEventCompat.getPointerId(motionevent, 0);
        o = motionevent.getX();
        return true;
_L6:
        float f1 = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, p));
        float f3 = f1 - o;
        if (!q && Math.abs(f3) > (float)n)
        {
            q = true;
        }
        if (q)
        {
            o = f1;
            if (a.isFakeDragging() || a.beginFakeDrag())
            {
                try
                {
                    a.fakeDragBy(f3);
                }
                // Misplaced declaration of an exception variable
                catch (MotionEvent motionevent)
                {
                    return true;
                }
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (q)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = a.getAdapter().getCount();
        int l1 = getWidth();
        float f2 = (float)l1 / 2.0F;
        float f4 = (float)l1 / 6F;
        if (g > 0 && motionevent.getX() < f2 - f4)
        {
            if (j1 != 3)
            {
                a.setCurrentItem(g - 1);
                return true;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (g >= i1 - 1 || motionevent.getX() <= f4 + f2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (j1 != 3)
        {
            a.setCurrentItem(g + 1);
            return true;
        }
        if (true) goto _L1; else goto _L9
_L9:
        q = false;
        p = -1;
        if (a.isFakeDragging())
        {
            a.endFakeDrag();
            return true;
        }
          goto _L1
_L7:
        i1 = MotionEventCompat.getActionIndex(motionevent);
        o = MotionEventCompat.getX(motionevent, i1);
        p = MotionEventCompat.getPointerId(motionevent, i1);
        return true;
_L8:
        int k1 = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, k1) == p)
        {
            if (k1 == 0)
            {
                i1 = 1;
            }
            p = MotionEventCompat.getPointerId(motionevent, i1);
        }
        o = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, p));
        return true;
    }

    public void setCentered(boolean flag)
    {
        l = flag;
        invalidate();
    }

    public void setCurrentItem(int i1)
    {
        if (a == null)
        {
            return;
        } else
        {
            a.setCurrentItem(i1);
            g = i1;
            invalidate();
            return;
        }
    }

    public void setFillColor(int i1)
    {
        e.setColor(i1);
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
        c.setColor(i1);
        invalidate();
    }

    public void setRadius(float f1)
    {
        b = f1;
        invalidate();
    }

    public void setSnap(boolean flag)
    {
        m = flag;
        invalidate();
    }

    public void setStrokeColor(int i1)
    {
        d.setColor(i1);
        invalidate();
    }

    public void setStrokeWidth(float f1)
    {
        d.setStrokeWidth(f1);
        invalidate();
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (a == viewpager)
        {
            return;
        }
        if (a != null)
        {
            a.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            a = viewpager;
            a.setOnPageChangeListener(this);
            invalidate();
            return;
        }
    }

    public void setViewPager(ViewPager viewpager, int i1)
    {
        setViewPager(viewpager);
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
