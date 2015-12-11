// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.cardform.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;

public class b extends EditText
{

    private Paint a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private int h;

    public b(Context context)
    {
        super(context);
        d();
    }

    public b(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d();
    }

    public b(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        d();
    }

    private int a(float f1)
    {
        return Math.round(TypedValue.applyDimension(1, f1, getResources().getDisplayMetrics()));
    }

    private void d()
    {
        Object obj;
        a = new Paint(1);
        b = a(8F);
        c = a(2.0F);
        d = a(1.0F);
        e = false;
        g = getResources().getColor(0x7f0e005f);
        h = getResources().getColor(0x7f0e0062);
        obj = new TypedValue();
        if (android.os.Build.VERSION.SDK_INT < 21) goto _L2; else goto _L1
_L1:
        getContext().getTheme().resolveAttribute(0x1010435, ((TypedValue) (obj)), true);
        f = ((TypedValue) (obj)).data;
_L4:
        obj = getContext().getTheme().obtainStyledAttributes(new int[] {
            0x1010351
        });
        setTextColor(((TypedArray) (obj)).getColor(0, 0));
        ((TypedArray) (obj)).recycle();
        return;
_L2:
        int i = getResources().getIdentifier("colorAccent", "attr", getContext().getPackageName());
        getContext().getTheme().resolveAttribute(i, ((TypedValue) (obj)), true);
        f = ((TypedValue) (obj)).data;
        if (f == 0)
        {
            f = getResources().getColor(0x7f0e005b);
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1;
        setTextColor(getResources().getColor(0x7f0e005a));
        ((TypedArray) (obj)).recycle();
        return;
        obj1;
        ((TypedArray) (obj)).recycle();
        throw obj1;
    }

    public boolean a()
    {
        return true;
    }

    public final void b()
    {
        if (getImeActionId() != 2)
        {
            View view;
            try
            {
                view = focusSearch(2);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                illegalargumentexception = focusSearch(130);
            }
            if (view != null)
            {
                view.requestFocus();
                return;
            }
        }
    }

    public final void c()
    {
        if (a())
        {
            setError(false);
            return;
        } else
        {
            setError(true);
            return;
        }
    }

    protected int getErrorColor()
    {
        return h;
    }

    protected int getFocusedColor()
    {
        return f;
    }

    protected int getInactiveColor()
    {
        return g;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i = getRight();
        int j = getBottom() - b - c;
        if (e)
        {
            a.setColor(h);
            canvas.drawRect(0.0F, j, i, c + j, a);
            return;
        }
        if (!isEnabled())
        {
            a.setColor(g & 0xffffff | 0x44000000);
            canvas.drawRect(0.0F, j, i, d + j, a);
            return;
        }
        if (hasFocus())
        {
            a.setColor(f);
            canvas.drawRect(0.0F, j, i, c + j, a);
            return;
        } else
        {
            a.setColor(g & 0xffffff | 0x1e000000);
            canvas.drawRect(0.0F, j, i, d + j, a);
            return;
        }
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        super.onFocusChanged(flag, i, rect);
        if (!flag && !a())
        {
            setError(true);
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        setError(false);
    }

    public void setError(boolean flag)
    {
        e = flag;
    }
}
