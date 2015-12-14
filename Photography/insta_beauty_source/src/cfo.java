// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;

public class cfo extends LinearLayout
{

    private static final int a[] = {
        0x1010129, 0x1010329, 0x101032a
    };
    private Drawable b;
    private int c;
    private int d;
    private int e;
    private int f;

    public cfo(Context context, int i)
    {
        super(context);
        context = context.obtainStyledAttributes(null, a, i, 0);
        setDividerDrawable(context.getDrawable(0));
        f = context.getDimensionPixelSize(2, 0);
        e = context.getInteger(1, 0);
        context.recycle();
    }

    private void a(Canvas canvas)
    {
        int k = getChildCount();
        for (int i = 0; i < k; i++)
        {
            View view = getChildAt(i);
            if (view != null && view.getVisibility() != 8 && a(i))
            {
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                a(canvas, view.getTop() - layoutparams.topMargin);
            }
        }

        if (a(k))
        {
            View view1 = getChildAt(k - 1);
            int j;
            if (view1 == null)
            {
                j = getHeight() - getPaddingBottom() - d;
            } else
            {
                j = view1.getBottom();
            }
            a(canvas, j);
        }
    }

    private void a(Canvas canvas, int i)
    {
        b.setBounds(getPaddingLeft() + f, i, getWidth() - getPaddingRight() - f, d + i);
        b.draw(canvas);
    }

    private boolean a(int i)
    {
        if (i != 0 && i != getChildCount() && (e & 2) != 0)
        {
            i--;
            while (i >= 0) 
            {
                if (getChildAt(i).getVisibility() != 8)
                {
                    return true;
                }
                i--;
            }
        }
        return false;
    }

    private void b(Canvas canvas)
    {
        int k = getChildCount();
        for (int i = 0; i < k; i++)
        {
            View view = getChildAt(i);
            if (view != null && view.getVisibility() != 8 && a(i))
            {
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                b(canvas, view.getLeft() - layoutparams.leftMargin);
            }
        }

        if (a(k))
        {
            View view1 = getChildAt(k - 1);
            int j;
            if (view1 == null)
            {
                j = getWidth() - getPaddingRight() - c;
            } else
            {
                j = view1.getRight();
            }
            b(canvas, j);
        }
    }

    private void b(Canvas canvas, int i)
    {
        b.setBounds(i, getPaddingTop() + f, c + i, getHeight() - getPaddingBottom() - f);
        b.draw(canvas);
    }

    protected void measureChildWithMargins(View view, int i, int j, int k, int l)
    {
        int i1 = indexOfChild(view);
        int j1 = getOrientation();
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
        int k1;
        if (a(i1))
        {
            if (j1 == 1)
            {
                layoutparams.topMargin = d;
            } else
            {
                layoutparams.leftMargin = c;
            }
        }
        k1 = getChildCount();
        if (i1 == k1 - 1 && a(k1))
        {
            if (j1 == 1)
            {
                layoutparams.bottomMargin = d;
            } else
            {
                layoutparams.rightMargin = c;
            }
        }
        super.measureChildWithMargins(view, i, j, k, l);
    }

    protected void onDraw(Canvas canvas)
    {
        if (b != null)
        {
            if (getOrientation() == 1)
            {
                a(canvas);
            } else
            {
                b(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void setDividerDrawable(Drawable drawable)
    {
        boolean flag = false;
        if (drawable == b)
        {
            return;
        }
        b = drawable;
        if (drawable != null)
        {
            c = drawable.getIntrinsicWidth();
            d = drawable.getIntrinsicHeight();
        } else
        {
            c = 0;
            d = 0;
        }
        if (drawable == null)
        {
            flag = true;
        }
        setWillNotDraw(flag);
        requestLayout();
    }

}
