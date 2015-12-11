// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

public class cvc extends FrameLayout
    implements bn
{

    private final List a;
    public View b;
    private final List c;

    public cvc(Context context)
    {
        this(context, null);
    }

    public cvc(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new ArrayList();
        c = new ArrayList();
        setFocusable(true);
        setDescendantFocusability(0x40000);
    }

    private cvd a(AttributeSet attributeset)
    {
        return new cvd(getContext(), attributeset);
    }

    public final transient void a(cuz acuz[])
    {
        int i = 0;
        while (i < acuz.length) 
        {
            cuz cuz1 = acuz[i];
            View view = cuz1.getView();
            if (view == null)
            {
                acuz = String.valueOf(cuz1);
                throw new IllegalArgumentException((new StringBuilder(String.valueOf(acuz).length() + 49)).append("Overlay ").append(acuz).append(" does not provide a View and LayoutParams").toString());
            }
            cvd cvd1 = cuz1.generateLayoutParams();
            if (cuz1 instanceof cuy)
            {
                cuy cuy1 = (cuy)cuz1;
                cuy1.l(false);
                cuz1.setOverlayVisibility(true);
                a.add(cuy1);
            } else
            {
                cuz1.setOverlayVisibility(true);
                c.add(cuz1);
            }
            addView(view, cvd1);
            i++;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof cvd;
    }

    protected boolean fitSystemWindows(Rect rect)
    {
        return super.fitSystemWindows(rect);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    protected android.widget.FrameLayout.LayoutParams generateDefaultLayoutParams()
    {
        return new cvd(-2, -2, false);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new cvd(layoutparams);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected void onMeasure(int i, int j)
    {
        boolean flag = false;
        int i1 = android.view.View.MeasureSpec.getMode(i);
        int j1 = android.view.View.MeasureSpec.getMode(j);
        int k = android.view.View.MeasureSpec.getSize(i);
        int l = android.view.View.MeasureSpec.getSize(j);
        if (i1 != 0x40000000 || j1 != 0x40000000)
        {
            if (i1 == 0x40000000 || i1 == 0x80000000 && j1 == 0)
            {
                l = (int)((float)k / 1.777F);
            } else
            if (j1 == 0x40000000 || j1 == 0x80000000 && i1 == 0)
            {
                k = (int)((float)l * 1.777F);
            } else
            if (i1 == 0x80000000 && j1 == 0x80000000)
            {
                if ((float)l < (float)k / 1.777F)
                {
                    k = (int)((float)l * 1.777F);
                } else
                {
                    l = (int)((float)k / 1.777F);
                }
            } else
            {
                l = 0;
                k = ((flag) ? 1 : 0);
            }
        }
        i = resolveSize(k, i);
        j = resolveSize(l, j);
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000));
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }
}
