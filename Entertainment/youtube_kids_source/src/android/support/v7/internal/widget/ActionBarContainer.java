// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import gl;
import he;
import hf;

public class ActionBarContainer extends FrameLayout
{

    public Drawable a;
    public Drawable b;
    public Drawable c;
    public boolean d;
    public boolean e;
    private View f;
    private View g;
    private int h;

    public ActionBarContainer(Context context)
    {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        Object obj;
        boolean flag;
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = new hf(this);
        } else
        {
            obj = new he(this);
        }
        setBackgroundDrawable(((Drawable) (obj)));
        context = context.obtainStyledAttributes(attributeset, gl.a);
        a = context.getDrawable(11);
        b = context.getDrawable(12);
        h = context.getDimensionPixelSize(1, -1);
        if (getId() == 0x7f10000d)
        {
            d = true;
            c = context.getDrawable(13);
        }
        context.recycle();
        if (d)
        {
            if (c == null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        } else
        if (a == null && b == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        setWillNotDraw(flag1);
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (a != null && a.isStateful())
        {
            a.setState(getDrawableState());
        }
        if (b != null && b.isStateful())
        {
            b.setState(getDrawableState());
        }
        if (c != null && c.isStateful())
        {
            c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            super.jumpDrawablesToCurrentState();
            if (a != null)
            {
                a.jumpToCurrentState();
            }
            if (b != null)
            {
                b.jumpToCurrentState();
            }
            if (c != null)
            {
                c.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        f = findViewById(0x7f10007c);
        g = findViewById(0x7f10007d);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return super.onInterceptTouchEvent(motionevent);
    }

    public void onLayout(boolean flag, int i, int j, int k, int l)
    {
        boolean flag2 = true;
        boolean flag1 = true;
        super.onLayout(flag, i, j, k, l);
        if (d)
        {
            if (c != null)
            {
                c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                i = ((flag1) ? 1 : 0);
            } else
            {
                i = 0;
            }
        } else
        {
            if (a != null)
            {
                if (f.getVisibility() == 0)
                {
                    a.setBounds(f.getLeft(), f.getTop(), f.getRight(), f.getBottom());
                    i = ((flag2) ? 1 : 0);
                } else
                if (g != null && g.getVisibility() == 0)
                {
                    a.setBounds(g.getLeft(), g.getTop(), g.getRight(), g.getBottom());
                    i = ((flag2) ? 1 : 0);
                } else
                {
                    a.setBounds(0, 0, 0, 0);
                    i = ((flag2) ? 1 : 0);
                }
            } else
            {
                i = 0;
            }
            e = false;
        }
        if (i != 0)
        {
            invalidate();
        }
    }

    public void onMeasure(int i, int j)
    {
        int k = j;
        if (f == null)
        {
            k = j;
            if (android.view.View.MeasureSpec.getMode(j) == 0x80000000)
            {
                k = j;
                if (h >= 0)
                {
                    k = android.view.View.MeasureSpec.makeMeasureSpec(Math.min(h, android.view.View.MeasureSpec.getSize(j)), 0x80000000);
                }
            }
        }
        super.onMeasure(i, k);
        if (f == null)
        {
            return;
        } else
        {
            android.view.View.MeasureSpec.getMode(k);
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        super.onTouchEvent(motionevent);
        return true;
    }

    public void setVisibility(int i)
    {
        super.setVisibility(i);
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (a != null)
        {
            a.setVisible(flag, false);
        }
        if (b != null)
        {
            b.setVisible(flag, false);
        }
        if (c != null)
        {
            c.setVisible(flag, false);
        }
    }

    public ActionMode startActionModeForChild(View view, android.view.ActionMode.Callback callback)
    {
        return null;
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return drawable == a && !d || drawable == b && e || drawable == c && d || super.verifyDrawable(drawable);
    }
}
