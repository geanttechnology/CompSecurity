// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import gl;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View
{

    private int a;
    private int b;
    private WeakReference c;

    public ViewStubCompat(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = 0;
        context = context.obtainStyledAttributes(attributeset, gl.m, i, 0);
        b = context.getResourceId(2, -1);
        a = context.getResourceId(1, 0);
        setId(context.getResourceId(0, -1));
        context.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    protected final void dispatchDraw(Canvas canvas)
    {
    }

    public final void draw(Canvas canvas)
    {
    }

    protected final void onMeasure(int i, int j)
    {
        setMeasuredDimension(0, 0);
    }

    public final void setVisibility(int i)
    {
        if (c == null) goto _L2; else goto _L1
_L1:
        View view = (View)c.get();
        if (view == null) goto _L4; else goto _L3
_L3:
        view.setVisibility(i);
_L6:
        return;
_L4:
        throw new IllegalStateException("setVisibility called on un-referenced view");
_L2:
        super.setVisibility(i);
        if (i == 0 || i == 4)
        {
            Object obj = getParent();
            if (obj != null && (obj instanceof ViewGroup))
            {
                if (a != 0)
                {
                    obj = (ViewGroup)obj;
                    View view1 = LayoutInflater.from(getContext()).inflate(a, ((ViewGroup) (obj)), false);
                    if (b != -1)
                    {
                        view1.setId(b);
                    }
                    i = ((ViewGroup) (obj)).indexOfChild(this);
                    ((ViewGroup) (obj)).removeViewInLayout(this);
                    android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
                    if (layoutparams != null)
                    {
                        ((ViewGroup) (obj)).addView(view1, i, layoutparams);
                    } else
                    {
                        ((ViewGroup) (obj)).addView(view1, i);
                    }
                    c = new WeakReference(view1);
                    return;
                } else
                {
                    throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
                }
            } else
            {
                throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
