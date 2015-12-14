// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

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
import java.util.ArrayList;
import myobfuscated.bf.a;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            c

public class TitlePageIndicator extends View
    implements c
{

    private int A;
    private int B[];
    private int C[];
    private ViewPager a;
    private android.support.v4.view.ViewPager.OnPageChangeListener b;
    private PagerAdapter c;
    private int d;
    private float e;
    private int f;
    private final Paint g;
    private boolean h;
    private int i;
    private int j;
    private Path k;
    private final Rect l;
    private final Paint m;
    private IndicatorStyle n;
    private final Paint o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private int w;
    private float x;
    private int y;
    private boolean z;

    public TitlePageIndicator(Context context)
    {
        this(context, null);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f01015e);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        d = -1;
        g = new Paint();
        k = new Path();
        l = new Rect();
        m = new Paint();
        o = new Paint();
        x = -1F;
        y = -1;
        B = null;
        C = null;
        if (isInEditMode())
        {
            return;
        }
        Object obj = getResources();
        int j1 = ((Resources) (obj)).getColor(0x7f0f007d);
        float f1 = ((Resources) (obj)).getDimension(0x7f0b00d1);
        int k1 = ((Resources) (obj)).getInteger(0x7f0e0023);
        float f2 = ((Resources) (obj)).getDimension(0x7f0b00cf);
        float f3 = ((Resources) (obj)).getDimension(0x7f0b00d0);
        float f4 = ((Resources) (obj)).getDimension(0x7f0b00d2);
        int l1 = ((Resources) (obj)).getColor(0x7f0f007e);
        boolean flag = ((Resources) (obj)).getBoolean(0x7f0d000b);
        int i2 = ((Resources) (obj)).getColor(0x7f0f007f);
        float f5 = ((Resources) (obj)).getDimension(0x7f0b00d3);
        float f6 = ((Resources) (obj)).getDimension(0x7f0b00d4);
        float f7 = ((Resources) (obj)).getDimension(0x7f0b00ce);
        float f8 = ((Resources) (obj)).getDimension(0x7f0b00d5);
        attributeset = context.obtainStyledAttributes(attributeset, a.TitlePageIndicator, i1, 0);
        v = attributeset.getDimension(a.TitlePageIndicator_footerLineHeight, f1);
        n = IndicatorStyle.fromValue(attributeset.getInteger(a.TitlePageIndicator_footerIndicatorStyle, k1));
        p = attributeset.getDimension(a.TitlePageIndicator_footerIndicatorHeight, f2);
        q = attributeset.getDimension(a.TitlePageIndicator_footerIndicatorUnderlinePadding, f3);
        r = attributeset.getDimension(a.TitlePageIndicator_footerPadding, f4);
        t = attributeset.getDimension(a.TitlePageIndicator_topPadding, f8);
        s = attributeset.getDimension(a.TitlePageIndicator_titlePadding, f6);
        u = attributeset.getDimension(a.TitlePageIndicator_clipPadding, f7);
        j = attributeset.getColor(a.TitlePageIndicator_selectedColor, l1);
        i = attributeset.getColor(a.TitlePageIndicator_android_textColor, i2);
        h = attributeset.getBoolean(a.TitlePageIndicator_selectedBold, flag);
        f1 = attributeset.getDimension(a.TitlePageIndicator_android_textSize, f5);
        A = attributeset.getColor(a.TitlePageIndicator_footerColor, j1);
        g.setTextSize(f1);
        g.setAntiAlias(true);
        m.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        m.setStrokeWidth(v);
        m.setColor(A);
        o.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        o.setColor(A);
        obj = attributeset.getDrawable(a.TitlePageIndicator_android_background);
        if (obj != null)
        {
            setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        }
        attributeset.recycle();
        w = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    private int a(int i1)
    {
        if (C == null || C.length == 0)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        i1 = C[i1];
        return i1;
        Exception exception;
        exception;
        exception.printStackTrace();
        return A;
    }

    private void a(Rect rect, float f1, int i1)
    {
        rect.right = (int)((float)i1 - u);
        rect.left = (int)((float)rect.right - f1);
    }

    private int b(int i1)
    {
        if (B == null || B.length == 0)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        i1 = B[i1];
        return i1;
        Exception exception;
        exception;
        exception.printStackTrace();
        return A;
    }

    private void b(Rect rect, float f1, int i1)
    {
        rect.left = (int)((float)i1 + u);
        rect.right = (int)(u + f1);
    }

    private CharSequence c(int i1)
    {
        CharSequence charsequence = c.getPageTitle(i1);
        Object obj = charsequence;
        if (charsequence == null)
        {
            obj = "";
        }
        return ((CharSequence) (obj)).toString();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (a != null) goto _L2; else goto _L1
_L1:
        int l3;
        return;
_L2:
        if ((l3 = a.getAdapter().getCount()) == 0) goto _L1; else goto _L3
_L3:
        float f1;
        float f2;
        Object obj;
        int i1;
        int j1;
        int j4;
        int l4;
        if (d == -1 && a != null)
        {
            d = a.getCurrentItem();
        }
        Object obj1 = g;
        obj = new ArrayList();
        int l1 = a.getAdapter().getCount();
        int k1;
        if (a.getAdapter() != null)
        {
            f1 = a.getAdapter().getPageWidth(0);
        } else
        {
            f1 = 1.0F;
        }
        if (a.getCurrentItem() == 0)
        {
            i1 = (int)(f1 * (float)getWidth());
        } else
        {
            i1 = getWidth();
        }
        if (n == IndicatorStyle.Line)
        {
            j1 = i1 - i1 / (d + 1);
        } else
        {
            j1 = i1 / 2;
        }
        k1 = 0;
        while (k1 < l1) 
        {
            Rect rect3 = new Rect();
            CharSequence charsequence1 = c(k1);
            rect3.right = (int)((Paint) (obj1)).measureText(charsequence1, 0, charsequence1.length());
            rect3.bottom = (int)(((Paint) (obj1)).descent() - ((Paint) (obj1)).ascent());
            int l2 = rect3.right - rect3.left;
            int i4 = rect3.bottom;
            int k4 = rect3.top;
            if (n == IndicatorStyle.Line)
            {
                f1 = l2 - l2 / (d + 1);
            } else
            {
                f1 = (float)l2 / 2.0F;
            }
            rect3.left = (int)(((float)j1 - f1) + ((float)(k1 - d) - e) * (float)i1);
            rect3.right = rect3.left + l2;
            rect3.top = 0;
            rect3.bottom = i4 - k4;
            ((ArrayList) (obj)).add(rect3);
            k1++;
        }
        j4 = ((ArrayList) (obj)).size();
        if (d >= j4)
        {
            setCurrentItem(j4 - 1);
            return;
        }
        f2 = (float)getWidth() / 2.0F;
        int i5 = getLeft();
        float f3 = (float)i5 + u;
        int j5 = getWidth();
        l4 = getHeight();
        int k5 = i5 + j5;
        float f6 = (float)k5 - u;
        i1 = d;
        float f9;
        if ((double)e <= 0.5D)
        {
            f1 = e;
        } else
        {
            f1 = e;
            i1++;
            f1 = 1.0F - f1;
        }
        if (f1 <= 0.25F)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (f1 <= 0.05F)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        f1 = (0.25F - f1) / 0.25F;
        obj1 = (Rect)((ArrayList) (obj)).get(d);
        f9 = ((Rect) (obj1)).right - ((Rect) (obj1)).left;
        if ((float)((Rect) (obj1)).left < f3)
        {
            b(((Rect) (obj1)), f9, i5);
        }
        if ((float)((Rect) (obj1)).right > f6)
        {
            a(((Rect) (obj1)), f9, k5);
        }
        if (d > 0)
        {
            for (int i2 = d - 1; i2 >= 0; i2--)
            {
                Rect rect = (Rect)((ArrayList) (obj)).get(i2);
                if ((float)rect.left >= f3)
                {
                    continue;
                }
                int i3 = rect.right - rect.left;
                b(rect, i3, i5);
                Rect rect4 = (Rect)((ArrayList) (obj)).get(i2 + 1);
                if ((float)rect.right + s > (float)rect4.left)
                {
                    rect.left = (int)((float)(rect4.left - i3) - s);
                    rect.right = rect.left + i3;
                }
            }

        }
        if (d < l3 - 1)
        {
            for (int j2 = d + 1; j2 < l3; j2++)
            {
                Rect rect1 = (Rect)((ArrayList) (obj)).get(j2);
                if ((float)rect1.right <= f6)
                {
                    continue;
                }
                int j3 = rect1.right - rect1.left;
                a(rect1, j3, k5);
                Rect rect5 = (Rect)((ArrayList) (obj)).get(j2 - 1);
                if ((float)rect1.left - s < (float)rect5.right)
                {
                    rect1.left = (int)((float)rect5.right + s);
                    rect1.right = rect1.left + j3;
                }
            }

        }
        if (n != IndicatorStyle.Line)
        {
            int l5 = i >>> 24;
            int k2 = 0;
            while (k2 < l3) 
            {
                Rect rect2 = (Rect)((ArrayList) (obj)).get(k2);
                if ((rect2.left <= i5 || rect2.left >= k5) && (rect2.right <= i5 || rect2.right >= k5))
                {
                    continue;
                }
                float f4;
                float f7;
                CharSequence charsequence;
                Paint paint;
                int k3;
                int i6;
                boolean flag;
                if (k2 == i1)
                {
                    k3 = 1;
                } else
                {
                    k3 = 0;
                }
                charsequence = c(k2);
                paint = g;
                if (k3 != 0 && k1 && h)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                paint.setFakeBoldText(flag);
                g.setColor(i);
                if (k3 != 0 && j1)
                {
                    g.setAlpha(l5 - (int)((float)l5 * f1));
                }
                i6 = charsequence.length();
                f4 = rect2.left;
                f7 = rect2.bottom;
                canvas.drawText(charsequence, 0, i6, f4, t + f7, g);
                if (k3 != 0 && j1)
                {
                    g.setColor(j);
                    g.setAlpha((int)((float)(j >>> 24) * f1));
                    k3 = charsequence.length();
                    float f5 = rect2.left;
                    float f8 = rect2.bottom;
                    canvas.drawText(charsequence, 0, k3, f5, t + f8, g);
                }
                k2++;
            }
        }
        k.reset();
        k.moveTo(0.0F, (float)l4 - v / 2.0F);
        k.lineTo(j5, (float)l4 - v / 2.0F);
        k.close();
        m.setColor(b(i1));
        canvas.drawPath(k, m);
        k1 = a(i1);
        o.setColor(k1);
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[IndicatorStyle.values().length];
                try
                {
                    a[IndicatorStyle.Triangle.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[IndicatorStyle.Underline.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[IndicatorStyle.Line.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.picsart.studio.view.viewpagerindicator._cls1.a[n.ordinal()];
        JVM INSTR tableswitch 1 3: default 1356
    //                   1 1357
    //                   2 1447
    //                   3 1635;
           goto _L4 _L5 _L6 _L7
_L7:
        continue; /* Loop/switch isn't completed */
_L4:
        return;
_L5:
        k.reset();
        k.moveTo(f2, (float)l4 - v - p);
        k.lineTo(p + f2, (float)l4 - v);
        k.lineTo(f2 - p, (float)l4 - v);
        k.close();
        canvas.drawPath(k, o);
        return;
_L6:
        if (!j1 || i1 >= j4) goto _L1; else goto _L8
_L8:
        obj = (Rect)((ArrayList) (obj)).get(i1);
        k.reset();
        k.moveTo((float)((Rect) (obj)).left - q, (float)l4 - v);
        k.lineTo((float)((Rect) (obj)).right + q, (float)l4 - v);
        k.lineTo((float)((Rect) (obj)).right + q, (float)l4 - v - p);
        k.lineTo((float)((Rect) (obj)).left - q, (float)l4 - v - p);
        k.close();
        o.setAlpha((int)(255F * f1));
        canvas.drawPath(k, o);
        o.setAlpha(255);
        return;
        if (!j1 || i1 >= j4) goto _L1; else goto _L9
_L9:
        obj = (Rect)((ArrayList) (obj)).get(i1);
        k.moveTo((float)((Rect) (obj)).left - q, l4);
        k.lineTo((float)((Rect) (obj)).right + q, l4);
        k.lineTo((float)((Rect) (obj)).right + q, (float)l4 - p);
        k.lineTo((float)((Rect) (obj)).left - q, (float)l4 - p);
        k.close();
        o.setAlpha((int)(255F * f1));
        canvas.drawPath(k, o);
        o.setAlpha(255);
        return;
    }

    protected void onMeasure(int i1, int j1)
    {
        i1 = android.view.View.MeasureSpec.getSize(i1);
        if (android.view.View.MeasureSpec.getMode(j1) != 0x40000000) goto _L2; else goto _L1
_L1:
        float f1 = android.view.View.MeasureSpec.getSize(j1);
_L4:
        setMeasuredDimension(i1, (int)f1);
        return;
_L2:
        l.setEmpty();
        float f2;
        if (n != IndicatorStyle.Line)
        {
            l.bottom = (int)(g.descent() - g.ascent());
            f2 = (float)(l.bottom - l.top) + v + r + t;
        } else
        {
            f2 = 0.0F;
        }
        f1 = f2;
        if (n != IndicatorStyle.None)
        {
            f1 = f2 + p;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPageScrollStateChanged(int i1)
    {
        f = i1;
        if (b != null)
        {
            b.onPageScrollStateChanged(i1);
        }
    }

    public void onPageScrolled(int i1, float f1, int j1)
    {
        d = i1;
        e = f1;
        invalidate();
        if (b != null)
        {
            b.onPageScrolled(i1, f1, j1);
        }
    }

    public void onPageSelected(int i1)
    {
        if (f == 0)
        {
            d = i1;
            invalidate();
        }
        if (b != null)
        {
            b.onPageSelected(i1);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        d = ((SavedState) (parcelable)).a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = d;
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
    //                   1 203
    //                   2 109
    //                   3 203
    //                   4 88
    //                   5 355
    //                   6 383;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L7 _L8
_L3:
        return true;
_L4:
        y = MotionEventCompat.getPointerId(motionevent, 0);
        x = motionevent.getX();
        return true;
_L6:
        float f1 = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, y));
        float f3 = f1 - x;
        if (!z && Math.abs(f3) > (float)w)
        {
            z = true;
        }
        if (z)
        {
            x = f1;
            if (a != null && (a.isFakeDragging() || a.beginFakeDrag()))
            {
                a.fakeDragBy(f3);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (z)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = a.getAdapter().getCount();
        int l1 = getWidth();
        float f2 = (float)l1 / 2.0F;
        float f4 = (float)l1 / 6F;
        float f5 = motionevent.getX();
        if (f5 < f2 - f4)
        {
            if (d <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            if (j1 != 3)
            {
                a.setCurrentItem(d - 1);
                return true;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (f5 <= f4 + f2 || d >= i1 - 1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (j1 != 3)
        {
            a.setCurrentItem(d + 1);
            return true;
        }
        if (true) goto _L1; else goto _L9
_L9:
        z = false;
        y = -1;
        if (a.isFakeDragging())
        {
            a.endFakeDrag();
            return true;
        }
          goto _L1
_L7:
        i1 = MotionEventCompat.getActionIndex(motionevent);
        x = MotionEventCompat.getX(motionevent, i1);
        y = MotionEventCompat.getPointerId(motionevent, i1);
        return true;
_L8:
        int k1 = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, k1) == y)
        {
            if (k1 == 0)
            {
                i1 = 1;
            }
            y = MotionEventCompat.getPointerId(motionevent, i1);
        }
        x = MotionEventCompat.getX(motionevent, MotionEventCompat.findPointerIndex(motionevent, y));
        return true;
    }

    public void setClipPadding(float f1)
    {
        u = f1;
        invalidate();
    }

    public void setCurrentItem(int i1)
    {
        if (a == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        } else
        {
            a.setCurrentItem(i1);
            d = i1;
            invalidate();
            return;
        }
    }

    public void setFooterColor(int i1)
    {
        A = i1;
        m.setColor(A);
        o.setColor(A);
        invalidate();
    }

    public void setFooterIndicatorColors(int ai[])
    {
        C = ai;
    }

    public void setFooterIndicatorHeight(float f1)
    {
        p = f1;
        invalidate();
    }

    public void setFooterIndicatorPadding(float f1)
    {
        r = f1;
        invalidate();
    }

    public void setFooterIndicatorStyle(IndicatorStyle indicatorstyle)
    {
        n = indicatorstyle;
        invalidate();
    }

    public void setFooterLineColors(int ai[])
    {
        B = ai;
    }

    public void setFooterLineHeight(float f1)
    {
        v = f1;
        m.setStrokeWidth(v);
        invalidate();
    }

    public void setOnCenterItemClickListener$754ab0d7(com.melnykov.fab.a a1)
    {
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        b = onpagechangelistener;
    }

    public void setSelectedBold(boolean flag)
    {
        h = flag;
        invalidate();
    }

    public void setSelectedColor(int i1)
    {
        j = i1;
        invalidate();
    }

    public void setTextColor(int i1)
    {
        g.setColor(i1);
        i = i1;
        invalidate();
    }

    public void setTextSize(float f1)
    {
        g.setTextSize(f1);
        invalidate();
    }

    public void setTitlePadding(float f1)
    {
        s = f1;
        invalidate();
    }

    public void setTopPadding(float f1)
    {
        t = f1;
        invalidate();
    }

    public void setTypeface(Typeface typeface)
    {
        g.setTypeface(typeface);
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
        c = viewpager.getAdapter();
        if (c == null)
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

    private class IndicatorStyle extends Enum
    {

        private static final IndicatorStyle $VALUES[];
        public static final IndicatorStyle Line;
        public static final IndicatorStyle None;
        public static final IndicatorStyle Triangle;
        public static final IndicatorStyle Underline;
        public final int value;

        public static IndicatorStyle fromValue(int i1)
        {
            IndicatorStyle aindicatorstyle[] = values();
            int k1 = aindicatorstyle.length;
            for (int j1 = 0; j1 < k1; j1++)
            {
                IndicatorStyle indicatorstyle = aindicatorstyle[j1];
                if (indicatorstyle.value == i1)
                {
                    return indicatorstyle;
                }
            }

            return null;
        }

        public static IndicatorStyle valueOf(String s1)
        {
            return (IndicatorStyle)Enum.valueOf(com/picsart/studio/view/viewpagerindicator/TitlePageIndicator$IndicatorStyle, s1);
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
            Line = new IndicatorStyle("Line", 3, 3);
            $VALUES = (new IndicatorStyle[] {
                None, Triangle, Underline, Line
            });
        }

        private IndicatorStyle(String s1, int i1, int j1)
        {
            super(s1, i1);
            value = j1;
        }
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
