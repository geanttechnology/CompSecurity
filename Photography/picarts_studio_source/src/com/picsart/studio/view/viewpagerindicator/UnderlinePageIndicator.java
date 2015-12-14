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

public class UnderlinePageIndicator extends View
    implements c
{

    private final Paint a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private ViewPager f;
    private android.support.v4.view.ViewPager.OnPageChangeListener g;
    private int h;
    private int i;
    private float j;
    private int k;
    private float l;
    private int m;
    private boolean n;
    private final Runnable o;

    public UnderlinePageIndicator(Context context)
    {
        this(context, null);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f010160);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = new Paint(1);
        l = -1F;
        m = -1;
        o = new Runnable() {

            private UnderlinePageIndicator a;

            public final void run()
            {
                if (com.picsart.studio.view.viewpagerindicator.UnderlinePageIndicator.a(a))
                {
                    int i2 = Math.max(UnderlinePageIndicator.b(a).getAlpha() - UnderlinePageIndicator.c(a), 0);
                    UnderlinePageIndicator.b(a).setAlpha(i2);
                    a.invalidate();
                    if (i2 > 0)
                    {
                        a.postDelayed(this, 30L);
                        return;
                    }
                }
            }

            
            {
                a = UnderlinePageIndicator.this;
                super();
            }
        };
        if (isInEditMode())
        {
            return;
        }
        Object obj = getResources();
        boolean flag = ((Resources) (obj)).getBoolean(0x7f0d000c);
        int j1 = ((Resources) (obj)).getInteger(0x7f0e0024);
        int k1 = ((Resources) (obj)).getInteger(0x7f0e0025);
        int l1 = ((Resources) (obj)).getColor(0x7f0f0080);
        attributeset = context.obtainStyledAttributes(attributeset, a.UnderlinePageIndicator, i1, 0);
        setFades(attributeset.getBoolean(a.UnderlinePageIndicator_fades, flag));
        setSelectedColor(attributeset.getColor(a.UnderlinePageIndicator_selectedColor, l1));
        setFadeDelay(attributeset.getInteger(a.UnderlinePageIndicator_fadeDelay, j1));
        setFadeLength(attributeset.getInteger(a.UnderlinePageIndicator_fadeLength, k1));
        obj = attributeset.getDrawable(a.UnderlinePageIndicator_android_background);
        if (obj != null)
        {
            setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        }
        attributeset.recycle();
        k = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    static boolean a(UnderlinePageIndicator underlinepageindicator)
    {
        return underlinepageindicator.b;
    }

    static Paint b(UnderlinePageIndicator underlinepageindicator)
    {
        return underlinepageindicator.a;
    }

    static int c(UnderlinePageIndicator underlinepageindicator)
    {
        return underlinepageindicator.e;
    }

    static Runnable d(UnderlinePageIndicator underlinepageindicator)
    {
        return underlinepageindicator.o;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i1;
        if (f != null)
        {
            if ((i1 = f.getAdapter().getCount()) != 0)
            {
                if (i >= i1)
                {
                    setCurrentItem(i1 - 1);
                    return;
                } else
                {
                    int j1 = getPaddingLeft();
                    float f1 = (float)(getWidth() - j1 - getPaddingRight()) / ((float)i1 * 1.0F);
                    float f2 = (float)j1 + ((float)i + j) * f1;
                    canvas.drawRect(f2, getPaddingTop(), f2 + f1, getHeight() - getPaddingBottom(), a);
                    return;
                }
            }
        }
    }

    public void onPageScrollStateChanged(int i1)
    {
        h = i1;
        if (g != null)
        {
            g.onPageScrollStateChanged(i1);
        }
    }

    public void onPageScrolled(int i1, float f1, int j1)
    {
        i = i1;
        j = f1;
        if (!b) goto _L2; else goto _L1
_L1:
        if (j1 <= 0) goto _L4; else goto _L3
_L3:
        removeCallbacks(o);
        a.setAlpha(255);
_L2:
        invalidate();
        if (g != null)
        {
            g.onPageScrolled(i1, f1, j1);
        }
        return;
_L4:
        if (h != 1)
        {
            postDelayed(o, c);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onPageSelected(int i1)
    {
        if (h == 0)
        {
            i = i1;
            j = 0.0F;
            invalidate();
            o.run();
        }
        if (g != null)
        {
            g.onPageSelected(i1);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        i = ((SavedState) (parcelable)).a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = i;
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
        if (f == null || f.getAdapter().getCount() == 0)
        {
            return false;
        }
        j1 = motionevent.getAction() & 0xff;
        j1;
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
        m = MotionEventCompat.getPointerId(motionevent, 0);
        l = motionevent.getX();
        return true;
_L6:
        float f1 = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, m));
        float f3 = f1 - l;
        if (!n && Math.abs(f3) > (float)k)
        {
            n = true;
        }
        if (n)
        {
            l = f1;
            if (f.isFakeDragging() || f.beginFakeDrag())
            {
                f.fakeDragBy(f3);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (n)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = f.getAdapter().getCount();
        int l1 = getWidth();
        float f2 = (float)l1 / 2.0F;
        float f4 = (float)l1 / 6F;
        if (i > 0 && motionevent.getX() < f2 - f4)
        {
            if (j1 != 3)
            {
                f.setCurrentItem(i - 1);
                return true;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i >= i1 - 1 || motionevent.getX() <= f4 + f2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (j1 != 3)
        {
            f.setCurrentItem(i + 1);
            return true;
        }
        if (true) goto _L1; else goto _L9
_L9:
        n = false;
        m = -1;
        if (f.isFakeDragging())
        {
            f.endFakeDrag();
            return true;
        }
          goto _L1
_L7:
        i1 = MotionEventCompat.getActionIndex(motionevent);
        l = MotionEventCompat.getX(motionevent, i1);
        m = MotionEventCompat.getPointerId(motionevent, i1);
        return true;
_L8:
        int k1 = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, k1) == m)
        {
            if (k1 == 0)
            {
                i1 = 1;
            }
            m = MotionEventCompat.getPointerId(motionevent, i1);
        }
        l = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, m));
        return true;
    }

    public void setCurrentItem(int i1)
    {
        if (f == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        } else
        {
            f.setCurrentItem(i1);
            i = i1;
            invalidate();
            return;
        }
    }

    public void setFadeDelay(int i1)
    {
        c = i1;
    }

    public void setFadeLength(int i1)
    {
        d = i1;
        e = 255 / (d / 30);
    }

    public void setFades(boolean flag)
    {
label0:
        {
            if (flag != b)
            {
                b = flag;
                if (!flag)
                {
                    break label0;
                }
                post(o);
            }
            return;
        }
        removeCallbacks(o);
        a.setAlpha(255);
        invalidate();
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        g = onpagechangelistener;
    }

    public void setSelectedColor(int i1)
    {
        a.setColor(i1);
        invalidate();
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (f == viewpager)
        {
            return;
        }
        if (f != null)
        {
            f.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            f = viewpager;
            f.setOnPageChangeListener(this);
            invalidate();
            post(new Runnable() {

                private UnderlinePageIndicator a;

                public final void run()
                {
                    if (com.picsart.studio.view.viewpagerindicator.UnderlinePageIndicator.a(a))
                    {
                        a.post(UnderlinePageIndicator.d(a));
                    }
                }

            
            {
                a = UnderlinePageIndicator.this;
                super();
            }
            });
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
