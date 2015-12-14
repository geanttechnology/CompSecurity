// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.melnykov.fab.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.views:
//            a

public class PredicateLayout extends ViewGroup
{

    private int a;
    private int b;
    private List c;
    private a d;

    public PredicateLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = Collections.emptyList();
        a = 0;
        b = 0;
    }

    private static int a(int i, int j, int k)
    {
        if (i == -1)
        {
            return android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
        }
        if (i == -2)
        {
            if (k == 0)
            {
                i = 0;
            } else
            {
                i = 0x80000000;
            }
            return android.view.View.MeasureSpec.makeMeasureSpec(j, i);
        } else
        {
            return android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        }
    }

    static int a(PredicateLayout predicatelayout)
    {
        return predicatelayout.a;
    }

    private List a()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < getChildCount(); i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 8)
            {
                arraylist.add(view);
            }
        }

        return arraylist;
    }

    private int b()
    {
        return getPaddingTop() + getPaddingBottom();
    }

    private int c()
    {
        return getPaddingLeft() + getPaddingRight();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int i1 = getMeasuredWidth();
        int j1 = getPaddingRight();
        i = getPaddingLeft();
        k = getPaddingTop();
        Iterator iterator = c.iterator();
        com.socialin.android.views.a a1 = (com.socialin.android.views.a)iterator.next();
        for (Iterator iterator1 = a().iterator(); iterator1.hasNext();)
        {
            View view = (View)iterator1.next();
            int k1 = view.getMeasuredWidth();
            int l1 = view.getMeasuredHeight();
            com.socialin.android.views.a a2 = a1;
            j = k;
            l = i;
            if (i + k1 > i1 - j1)
            {
                i = getPaddingLeft();
                k += a1.d + b;
                a2 = a1;
                j = k;
                l = i;
                if (iterator.hasNext())
                {
                    a2 = (com.socialin.android.views.a)iterator.next();
                    l = i;
                    j = k;
                }
            }
            view.layout(l, j, l + k1, l1 + j);
            i = a + k1 + l;
            a1 = a2;
            k = j;
        }

    }

    protected void onMeasure(int i, int j)
    {
        boolean flag1 = false;
        int i2 = android.view.View.MeasureSpec.getMode(i);
        int l1 = android.view.View.MeasureSpec.getMode(j);
        int l = android.view.View.MeasureSpec.getSize(i) - c();
        int j1 = android.view.View.MeasureSpec.getSize(j);
        int j2 = b();
        ArrayList arraylist = new ArrayList();
        com.socialin.android.views.a a1 = new com.socialin.android.views.a(this, l, i2);
        arraylist.add(a1);
        Iterator iterator = a().iterator();
        while (iterator.hasNext()) 
        {
            View view = (View)iterator.next();
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            view.measure(a(layoutparams.width, l, i2), a(layoutparams.height, j1 - j2, l1));
            int k2 = view.getMeasuredWidth();
            int l2 = view.getMeasuredHeight();
            boolean flag;
            if (a1.b != 0 && a1.a(k2) > a1.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                a1 = new com.socialin.android.views.a(this, l, i2);
                arraylist.add(a1);
            }
            a1.c = a1.a(k2);
            a1.d = Math.max(a1.d, l2);
        }
        j1 = 0;
        l = 0;
        int k = ((flag1) ? 1 : 0);
        for (int i1 = j1; i1 < arraylist.size(); i1++)
        {
            com.socialin.android.views.a a2 = (com.socialin.android.views.a)arraylist.get(i1);
            int k1 = k + a2.d;
            k = k1;
            if (i1 < arraylist.size() - 1)
            {
                k = k1 + b;
            }
            l = Math.max(l, a2.c);
        }

        if (i2 == 0x40000000)
        {
            i = android.view.View.MeasureSpec.getSize(i);
        } else
        {
            i = c() + l;
        }
        if (l1 == 0x40000000)
        {
            j = android.view.View.MeasureSpec.getSize(j);
        } else
        {
            j = b() + k;
        }
        setMeasuredDimension(i, j);
        c = Collections.unmodifiableList(arraylist);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 0: default 28
    //                   0 34;
           goto _L2 _L3
_L2:
        return super.onTouchEvent(motionevent);
_L3:
        float f = motionevent.getRawX();
        float f1 = motionevent.getRawY();
        Object obj = a();
        int ai[] = new int[2];
        obj = ((List) (obj)).iterator();
        Rect rect;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            View view = (View)((Iterator) (obj)).next();
            rect = new Rect();
            view.getHitRect(rect);
            view.getLocationOnScreen(ai);
            rect.offset(ai[0] - view.getLeft(), ai[1] - view.getTop());
        } while (!rect.contains((int)f + 5, (int)f1 + 5));
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void setHorizontalSpacing(int i)
    {
        a = i;
    }

    public void setOutsideTouchListener$5a893d08(a a1)
    {
        d = a1;
    }

    public void setSpacing(int i, int j)
    {
        a = i;
        b = j;
    }

    public void setVerticalSpacing(int i)
    {
        b = i;
    }
}
