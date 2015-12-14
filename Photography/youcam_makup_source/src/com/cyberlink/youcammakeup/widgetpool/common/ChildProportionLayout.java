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
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.cyberlink.youcammakeup.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            l

public class ChildProportionLayout extends ViewGroup
{

    private final ArrayList a;
    private int b;
    private int c;

    public ChildProportionLayout(Context context)
    {
        super(context);
        a = new ArrayList(1);
        b = -1;
        c = -1;
    }

    public ChildProportionLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ChildProportionLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new ArrayList(1);
        b = -1;
        c = -1;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, j.ChildProportionLayoutArgs);
        b = typedarray.getInteger(2, -1);
        c = typedarray.getInteger(3, -1);
        typedarray.recycle();
        context = context.obtainStyledAttributes(attributeset, j.FixedAspectRatioLayoutArgs);
        if (b == -1)
        {
            b = context.getInteger(0, -1);
        }
        if (c == -1)
        {
            c = context.getInteger(1, -1);
        }
        context.recycle();
    }

    public static int a(int i, int k, int i1, int j1)
    {
        if (k != -1)
        {
            if (i1 == -1)
            {
                if (j1 != -1)
                {
                    return Math.round(((float)i * (float)(k - j1)) / (float)k);
                }
            } else
            {
                return Math.round(((float)i * (float)i1) / (float)k);
            }
        }
        return i;
    }

    protected void a(int i, int k)
    {
        int i4 = getChildCount();
        int i1;
        int j1;
        int k1;
        int i2;
        int j2;
        int j4;
        int k4;
        int l4;
        int i5;
        if (android.view.View.MeasureSpec.getMode(i) != 0x40000000 || android.view.View.MeasureSpec.getMode(k) != 0x40000000)
        {
            i2 = 1;
        } else
        {
            i2 = 0;
        }
        a.clear();
        j1 = 0;
        k1 = 0;
        i1 = 0;
        j4 = android.view.View.MeasureSpec.getSize(i);
        k4 = android.view.View.MeasureSpec.getSize(k);
        l4 = getLayoutParams().width;
        i5 = getLayoutParams().height;
        j2 = 0;
        while (j2 < i4) 
        {
            View view = getChildAt(j2);
            if (view.getVisibility() != 8)
            {
                l l1 = (l)view.getLayoutParams();
                int k2;
                int j3;
                if (l4 == -1 && i5 == -2)
                {
                    measureChildWithMargins(view, android.view.View.MeasureSpec.makeMeasureSpec(a(j4, b, l1.c, l1.a), 0x40000000), 0, 0, 0);
                } else
                if (l4 == -2 && i5 == -1)
                {
                    measureChildWithMargins(view, 0, 0, android.view.View.MeasureSpec.makeMeasureSpec(a(k4, c, l1.d, l1.b), 0x40000000), 0);
                } else
                if (l4 == -1 && i5 == -1)
                {
                    int l2 = a(j4, b, l1.c, l1.a);
                    int k3 = a(k4, c, l1.d, l1.b);
                    measureChildWithMargins(view, android.view.View.MeasureSpec.makeMeasureSpec(l2, 0x40000000), 0, android.view.View.MeasureSpec.makeMeasureSpec(k3, 0x40000000), 0);
                } else
                if (l4 == -2 && i5 == -2)
                {
                    measureChildWithMargins(view, 0, 0, 0, 0);
                } else
                {
                    measureChildWithMargins(view, i, 0, k, 0);
                }
                k2 = Math.max(k1, view.getMeasuredWidth() + l1.leftMargin + l1.rightMargin);
                j3 = Math.max(j1, view.getMeasuredHeight() + l1.topMargin + l1.bottomMargin);
                k1 = combineMeasuredStates(i1, view.getMeasuredState());
                if (i2 && (l1.width == -1 || l1.height == -1))
                {
                    a.add(view);
                }
                j1 = k2;
                i1 = j3;
            } else
            {
                int i3 = k1;
                int l3 = j1;
                k1 = i1;
                j1 = i3;
                i1 = l3;
            }
            k2 = j2 + 1;
            j2 = i1;
            i1 = k1;
            k1 = j1;
            j1 = j2;
            j2 = k2;
        }
        i2 = getPaddingLeft();
        j2 = getPaddingRight();
        j1 = Math.max(getPaddingTop() + getPaddingBottom() + j1, getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSizeAndState(Math.max(i2 + j2 + k1, getSuggestedMinimumWidth()), i, i1), resolveSizeAndState(j1, k, i1 << 16));
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof l;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new l(-1, -1, -1, -1, -1, -1, 51);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new l(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new l(layoutparams);
    }

    protected void measureChildren(int i, int k)
    {
        int i2 = android.view.View.MeasureSpec.getSize(i);
        int j2 = getPaddingLeft();
        int k2 = getPaddingRight();
        int l2 = android.view.View.MeasureSpec.getSize(k);
        int i3 = getPaddingTop();
        int j3 = getPaddingBottom();
        int k3 = getChildCount();
        int i1 = 0;
        while (i1 < k3) 
        {
            View view = getChildAt(i1);
            if (view.getVisibility() != 8)
            {
                l l1 = (l)view.getLayoutParams();
                int j1 = a(i2 - j2 - k2, b, l1.c, l1.a);
                int k1 = a(l2 - i3 - j3, c, l1.d, l1.b);
                if (l1.width == -1)
                {
                    j1 = android.view.View.MeasureSpec.makeMeasureSpec(j1 - l1.leftMargin - l1.rightMargin, 0x40000000);
                } else
                {
                    j1 = getChildMeasureSpec(i, l1.leftMargin + l1.rightMargin, l1.width);
                }
                if (l1.height == -1)
                {
                    k1 = android.view.View.MeasureSpec.makeMeasureSpec(k1 - l1.topMargin - l1.bottomMargin, 0x40000000);
                } else
                {
                    k1 = getChildMeasureSpec(k, l1.topMargin + l1.bottomMargin, l1.height);
                }
                view.measure(j1, k1);
            }
            i1++;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(com/cyberlink/youcammakeup/widgetpool/common/ChildProportionLayout.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(com/cyberlink/youcammakeup/widgetpool/common/ChildProportionLayout.getName());
    }

    protected void onLayout(boolean flag, int i, int k, int i1, int j1)
    {
        int k1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        k1 = getChildCount();
        i2 = getPaddingLeft();
        j2 = i1 - i - getPaddingRight();
        k2 = getPaddingTop();
        j1 = j1 - k - getPaddingBottom();
        l2 = j2 - i2;
        i3 = j1 - k2;
        i1 = 0;
_L20:
        if (i1 >= k1) goto _L2; else goto _L1
_L1:
        View view = getChildAt(i1);
        if (view.getVisibility() == 8) goto _L4; else goto _L3
_L3:
        l l1;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        l1 = (l)view.getLayoutParams();
        j3 = view.getMeasuredWidth();
        k3 = view.getMeasuredHeight();
        i4 = Math.round(((float)l2 * (float)l1.a) / (float)b);
        l3 = Math.round(((float)i3 * (float)l1.b) / (float)c);
        k = l1.gravity;
        i = k;
        if (k == -1)
        {
            i = 51;
        }
        j4 = Gravity.getAbsoluteGravity(i, 0);
        k = i & 0x70;
        if (l1.a != -1) goto _L6; else goto _L5
_L5:
        j4 & 7;
        JVM INSTR lookupswitch 2: default 216
    //                   1: 293
    //                   5: 319;
           goto _L7 _L8 _L9
_L7:
        i = l1.leftMargin + i2;
_L15:
        if (l1.b != -1) goto _L11; else goto _L10
_L10:
        k;
        JVM INSTR lookupswitch 2: default 260
    //                   16: 497
    //                   80: 523;
           goto _L12 _L13 _L14
_L12:
        k = l1.topMargin + k2;
_L16:
        view.layout(i, k, j3 + i, k3 + k);
_L4:
        i1++;
        continue; /* Loop/switch isn't completed */
_L8:
        i = ((l2 - j3) / 2 + i2 + l1.leftMargin) - l1.rightMargin;
          goto _L15
_L9:
        i = j2 - j3 - l1.rightMargin;
          goto _L15
_L6:
        switch (j4 & 7)
        {
        default:
            if (l1.e)
            {
                i = l1.leftMargin;
            } else
            {
                i = l1.leftMargin + i4;
            }
            break;

        case 1: // '\001'
            if (l1.e)
            {
                i = ((l2 - i4 - j3) / 2 + l1.leftMargin) - l1.rightMargin;
            } else
            {
                i = (((l2 - i4 - j3) / 2 + l1.leftMargin) - l1.rightMargin) + i4;
            }
            break;

        case 5: // '\005'
            if (l1.e)
            {
                i = j2 - j3 - l1.rightMargin - i4;
            } else
            {
                i = j2 - j3 - l1.rightMargin;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
_L13:
        k = ((i3 - k3) / 2 + k2 + l1.topMargin) - l1.bottomMargin;
          goto _L16
_L14:
        k = j1 - k3 - l1.bottomMargin;
          goto _L16
_L11:
        switch (k)
        {
        default:
            if (l1.f)
            {
                k = l1.topMargin;
            } else
            {
                k = l1.topMargin + l3;
            }
            break;

        case 16: // '\020'
            if (l1.f)
            {
                k = ((i3 - l3 - k3) / 2 + l1.topMargin) - l1.bottomMargin;
            } else
            {
                k = (((i3 - l3 - k3) / 2 + l1.topMargin) - l1.bottomMargin) + l3;
            }
            break;

        case 80: // 'P'
            if (l1.f)
            {
                k = j1 - k3 - l1.bottomMargin - l3;
            } else
            {
                k = j1 - k3 - l1.bottomMargin;
            }
            break;
        }
        if (true) goto _L16; else goto _L17
_L17:
        if (true) goto _L15; else goto _L18
_L18:
_L2:
        return;
        if (true) goto _L20; else goto _L19
_L19:
    }

    protected void onMeasure(int i, int k)
    {
        a(i, k);
        measureChildren(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }
}
