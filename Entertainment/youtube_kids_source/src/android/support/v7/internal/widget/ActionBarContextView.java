// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import ep;
import fa;
import gl;
import go;
import hc;
import ib;
import ie;
import java.util.ArrayList;
import java.util.Iterator;

public class ActionBarContextView extends hc
    implements fa
{

    private View d;
    private go e;
    private boolean f;
    private int g;

    public ActionBarContextView(Context context)
    {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f010098);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = ib.a(context, attributeset, gl.d, i, 0);
        setBackgroundDrawable(context.a(3));
        context.e(1, 0);
        context.e(2, 0);
        b = context.d(0, 0);
        context.a(4);
        context.e(5, 0x7f040006);
        ((ib) (context)).a.recycle();
    }

    public final void a(int i)
    {
        b = i;
    }

    public final void a(View view)
    {
    }

    public final void b(View view)
    {
        if (g == 2)
        {
            view = e;
            if (view != null)
            {
                e = null;
                if (((go) (view)).b)
                {
                    for (Iterator iterator = ((go) (view)).a.iterator(); iterator.hasNext(); ((ep)iterator.next()).a()) { }
                    view.b = false;
                }
            }
            removeAllViews();
            d = null;
            a = null;
            f = false;
        }
        g = 0;
    }

    public final void c(View view)
    {
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new android.view.ViewGroup.MarginLayoutParams(-1, -2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new android.view.ViewGroup.MarginLayoutParams(getContext(), attributeset);
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                if (accessibilityevent.getEventType() != 32)
                {
                    break label0;
                }
                accessibilityevent.setSource(this);
                accessibilityevent.setClassName(getClass().getName());
                accessibilityevent.setPackageName(getContext().getPackageName());
                accessibilityevent.setContentDescription(null);
            }
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityevent);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        flag = ie.a(this);
        if (flag)
        {
            getPaddingRight();
        } else
        {
            getPaddingLeft();
        }
        getPaddingTop();
        getPaddingTop();
        getPaddingBottom();
        if (flag)
        {
            getPaddingLeft();
            return;
        } else
        {
            getPaddingRight();
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        boolean flag = false;
        if (android.view.View.MeasureSpec.getMode(i) != 0x40000000)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)").toString());
        }
        if (android.view.View.MeasureSpec.getMode(j) == 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used with android:layout_height=\"wrap_content\"").toString());
        }
        int l = android.view.View.MeasureSpec.getSize(i);
        int i1;
        if (b > 0)
        {
            i = b;
        } else
        {
            i = android.view.View.MeasureSpec.getSize(j);
        }
        j = getPaddingTop();
        i1 = getPaddingBottom() + j;
        getPaddingLeft();
        getPaddingRight();
        android.view.View.MeasureSpec.makeMeasureSpec(i - i1, 0x80000000);
        if (b <= 0)
        {
            int j1 = getChildCount();
            j = 0;
            i = ((flag) ? 1 : 0);
            for (; j < j1; j++)
            {
                int k = getChildAt(j).getMeasuredHeight() + i1;
                if (k > i)
                {
                    i = k;
                }
            }

            setMeasuredDimension(l, i);
            return;
        } else
        {
            setMeasuredDimension(l, i);
            return;
        }
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }
}
