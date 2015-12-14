// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            k

public class ChildPosAndSizeFrameLayout extends ViewGroup
{

    private final ArrayList a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public ChildPosAndSizeFrameLayout(Context context)
    {
        super(context);
        a = new ArrayList(1);
        b = -1;
        c = -1;
        d = -1;
        e = -1;
        f = -1;
        g = -1;
    }

    public ChildPosAndSizeFrameLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ChildPosAndSizeFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new ArrayList(1);
        b = -1;
        c = -1;
        d = -1;
        e = -1;
        f = -1;
        g = -1;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, j.FixedAspectRatioLayoutArgs);
        b = typedarray.getInteger(0, -1);
        c = typedarray.getInteger(1, -1);
        typedarray.recycle();
        context = context.obtainStyledAttributes(attributeset, j.ChildPosAndSizeLayoutArgs);
        d = context.getInteger(0, -1);
        e = context.getInteger(1, -1);
        f = context.getInteger(2, -1);
        g = context.getInteger(3, -1);
        context.recycle();
    }

    public static int a(int i, int l, int i1, int j1)
    {
        if (l != -1)
        {
            if (i1 == -1)
            {
                if (j1 != -1)
                {
                    return Math.round(((float)i * (float)(l - j1)) / (float)l);
                }
            } else
            {
                return Math.round(((float)i * (float)i1) / (float)l);
            }
        }
        return i;
    }

    private void b()
    {
        int j1 = getMeasuredWidth();
        int i = getMeasuredHeight();
        int k1 = getPaddingLeft();
        int l1 = getPaddingRight();
        int l = getPaddingTop();
        int i1 = getPaddingBottom();
        j1 = a(j1 - k1 - l1, b, d, f);
        l = a(i - l - i1, c, e, g);
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        if (layoutparams.width == -1)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000);
        } else
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0);
        }
        if (layoutparams.height == -1)
        {
            l = android.view.View.MeasureSpec.makeMeasureSpec(l, 0x40000000);
        } else
        {
            l = android.view.View.MeasureSpec.makeMeasureSpec(l, 0);
        }
        measureChildren(i, l);
    }

    protected k a()
    {
        return new k(-1, -1);
    }

    protected void a(int i, int l)
    {
        int i4 = getChildCount();
        int i1;
        int j1;
        int l1;
        int i2;
        int j2;
        int j4;
        int k4;
        int l4;
        int i5;
        if (android.view.View.MeasureSpec.getMode(i) != 0x40000000 || android.view.View.MeasureSpec.getMode(l) != 0x40000000)
        {
            i2 = 1;
        } else
        {
            i2 = 0;
        }
        a.clear();
        j1 = 0;
        l1 = 0;
        i1 = 0;
        j4 = android.view.View.MeasureSpec.getSize(i);
        k4 = android.view.View.MeasureSpec.getSize(l);
        l4 = getLayoutParams().width;
        i5 = getLayoutParams().height;
        j2 = 0;
        while (j2 < i4) 
        {
            View view = getChildAt(j2);
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams;
            if (view.getVisibility() != 8)
            {
                k k1;
                int k2;
                int j3;
                if (l4 == -1 && i5 == -2)
                {
                    measureChildWithMargins(view, android.view.View.MeasureSpec.makeMeasureSpec(a(j4, b, d, f), 0x40000000), 0, 0, 0);
                } else
                if (l4 == -2 && i5 == -1)
                {
                    measureChildWithMargins(view, 0, 0, android.view.View.MeasureSpec.makeMeasureSpec(a(k4, c, e, g), 0x40000000), 0);
                } else
                if (l4 == -1 && i5 == -1)
                {
                    int l2 = a(j4, b, d, f);
                    int k3 = a(k4, c, e, g);
                    measureChildWithMargins(view, android.view.View.MeasureSpec.makeMeasureSpec(l2, 0x40000000), 0, android.view.View.MeasureSpec.makeMeasureSpec(k3, 0x40000000), 0);
                } else
                if (l4 == -2 && i5 == -2)
                {
                    measureChildWithMargins(view, 0, 0, 0, 0);
                } else
                {
                    measureChildWithMargins(view, i, 0, l, 0);
                }
                k1 = (k)view.getLayoutParams();
                k2 = Math.max(l1, view.getMeasuredWidth() + k1.leftMargin + k1.rightMargin);
                j3 = Math.max(j1, view.getMeasuredHeight() + k1.topMargin + k1.bottomMargin);
                l1 = combineMeasuredStates(i1, view.getMeasuredState());
                if (i2 && (k1.width == -1 || k1.height == -1))
                {
                    a.add(view);
                }
                j1 = k2;
                i1 = j3;
            } else
            {
                int i3 = l1;
                int l3 = j1;
                l1 = i1;
                j1 = i3;
                i1 = l3;
            }
            k2 = j2 + 1;
            j2 = i1;
            i1 = l1;
            l1 = j1;
            j1 = j2;
            j2 = k2;
        }
        i2 = getPaddingLeft();
        j2 = getPaddingRight();
        j1 = Math.max(getPaddingTop() + getPaddingBottom() + j1, getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSizeAndState(Math.max(i2 + j2 + l1, getSuggestedMinimumWidth()), i, i1), resolveSizeAndState(j1, l, i1 << 16));
        i2 = a.size();
        if (i2 > 1)
        {
            i1 = 0;
            while (i1 < i2) 
            {
                view = (View)a.get(i1);
                marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
                if (marginlayoutparams.width == -1)
                {
                    j1 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - marginlayoutparams.leftMargin - marginlayoutparams.rightMargin, 0x40000000);
                } else
                {
                    j1 = getChildMeasureSpec(i, marginlayoutparams.leftMargin + marginlayoutparams.rightMargin, marginlayoutparams.width);
                }
                if (marginlayoutparams.height == -1)
                {
                    l1 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - marginlayoutparams.topMargin - marginlayoutparams.bottomMargin, 0x40000000);
                } else
                {
                    l1 = getChildMeasureSpec(l, marginlayoutparams.topMargin + marginlayoutparams.bottomMargin, marginlayoutparams.height);
                }
                view.measure(j1, l1);
                i1++;
            }
        }
    }

    protected void b(int i, int l, int i1, int j1)
    {
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        l1 = getChildCount();
        i2 = getPaddingLeft();
        j2 = i1 - i - getPaddingRight();
        k2 = getPaddingTop();
        j1 = j1 - l - getPaddingBottom();
        l = j2 - i2;
        i = j1 - k2;
        l2 = a(l, b, d, f);
        i3 = a(i, c, e, g);
        j3 = Math.round((l * f) / b);
        k3 = Math.round((g * i) / c);
        i1 = 0;
_L21:
        if (i1 >= l1) goto _L2; else goto _L1
_L1:
        View view = getChildAt(i1);
        if (view.getVisibility() == 8) goto _L4; else goto _L3
_L3:
        k k1;
        int l3;
        int i4;
        k1 = (k)view.getLayoutParams();
        l3 = view.getMeasuredWidth();
        i4 = view.getMeasuredHeight();
        l = k1.gravity;
        i = l;
        if (l == -1)
        {
            i = 0x800033;
        }
        l = Gravity.getAbsoluteGravity(i, 0);
        i &= 0x70;
        if (f != -1) goto _L6; else goto _L5
_L5:
        l & 7;
        JVM INSTR lookupswitch 2: default 236
    //                   1: 319
    //                   5: 348;
           goto _L7 _L8 _L9
_L7:
        l = k1.leftMargin + i2;
_L16:
        if (g != -1) goto _L11; else goto _L10
_L10:
        i;
        JVM INSTR lookupswitch 3: default 288
    //                   16: 460
    //                   48: 448
    //                   80: 489;
           goto _L12 _L13 _L14 _L15
_L12:
        i = k1.topMargin + k2;
_L17:
        view.layout(l, i, l3 + l, i4 + i);
_L4:
        i1++;
        continue; /* Loop/switch isn't completed */
_L8:
        l = ((j2 - i2 - l3) / 2 + i2 + k1.leftMargin) - k1.rightMargin;
          goto _L16
_L9:
        l = j2 - l3 - k1.rightMargin;
          goto _L16
_L6:
        switch (l & 7)
        {
        default:
            l = k1.leftMargin + j3;
            break;

        case 1: // '\001'
            l = ((l2 - l3) / 2 + j3 + k1.leftMargin) - k1.rightMargin;
            break;

        case 5: // '\005'
            l = (j3 + l2) - l3 - k1.rightMargin;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L14:
        i = k1.topMargin + k2;
          goto _L17
_L13:
        i = ((j1 - k2 - i4) / 2 + k2 + k1.topMargin) - k1.bottomMargin;
          goto _L17
_L15:
        i = j1 - i4 - k1.bottomMargin;
          goto _L17
_L11:
        switch (i)
        {
        default:
            i = k1.topMargin + k3;
            break;

        case 48: // '0'
            i = k1.topMargin + k3;
            break;

        case 16: // '\020'
            i = ((i3 - i4) / 2 + k3 + k1.topMargin) - k1.bottomMargin;
            break;

        case 80: // 'P'
            i = (k3 + i3) - i4 - k1.bottomMargin;
            break;
        }
        if (true) goto _L17; else goto _L18
_L18:
        if (true) goto _L16; else goto _L19
_L19:
_L2:
        return;
        if (true) goto _L21; else goto _L20
_L20:
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof k;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return a();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new k(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new k(layoutparams);
    }

    protected void measureChildren(int i, int l)
    {
        int l1 = android.view.View.MeasureSpec.getSize(i);
        int i2 = android.view.View.MeasureSpec.getSize(l);
        int j2 = getChildCount();
        int i1 = 0;
        while (i1 < j2) 
        {
            View view = getChildAt(i1);
            if (view.getVisibility() != 8)
            {
                android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
                int j1;
                int k1;
                if (marginlayoutparams.width == -1)
                {
                    j1 = android.view.View.MeasureSpec.makeMeasureSpec(l1 - marginlayoutparams.leftMargin - marginlayoutparams.rightMargin, 0x40000000);
                } else
                {
                    j1 = getChildMeasureSpec(i, marginlayoutparams.leftMargin + marginlayoutparams.rightMargin, marginlayoutparams.width);
                }
                if (marginlayoutparams.height == -1)
                {
                    k1 = android.view.View.MeasureSpec.makeMeasureSpec(i2 - marginlayoutparams.topMargin - marginlayoutparams.bottomMargin, 0x40000000);
                } else
                {
                    k1 = getChildMeasureSpec(l, marginlayoutparams.topMargin + marginlayoutparams.bottomMargin, marginlayoutparams.height);
                }
                view.measure(j1, k1);
            }
            i1++;
        }
    }

    protected void onLayout(boolean flag, int i, int l, int i1, int j1)
    {
        b(i, l, i1, j1);
    }

    protected void onMeasure(int i, int l)
    {
        a(i, l);
        if (b == 0 || c == 0) goto _L2; else goto _L1
_L1:
        i = getMeasuredWidth();
        l = getMeasuredHeight();
        if (l != 0 || i == 0) goto _L4; else goto _L3
_L3:
        setMeasuredDimension(i, (int)Math.round(((double)c / (double)b) * (double)i));
_L6:
        b();
_L2:
        return;
_L4:
        if (i == 0 && l != 0)
        {
            setMeasuredDimension((int)Math.round(((double)b / (double)c) * (double)l), l);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
