// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.c.a.a;
import android.support.v4.widget.bj;
import android.support.v7.internal.view.menu.aa;
import android.support.v7.internal.view.menu.m;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class NavigationMenuItemView extends TextView
    implements aa
{

    private static final int a[] = {
        0x10100a0
    };
    private int b;
    private m c;
    private ColorStateList d;

    public NavigationMenuItemView(Context context)
    {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = context.getResources().getDimensionPixelSize(0x7f0b00ab);
    }

    public final void a(m m1, int i)
    {
        c = m1;
        if (m1.isVisible())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        setVisibility(i);
        if (getBackground() == null)
        {
            TypedValue typedvalue = new TypedValue();
            StateListDrawable statelistdrawable;
            if (getContext().getTheme().resolveAttribute(0x7f010110, typedvalue, true))
            {
                statelistdrawable = new StateListDrawable();
                statelistdrawable.addState(a, new ColorDrawable(typedvalue.data));
                statelistdrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            } else
            {
                statelistdrawable = null;
            }
            setBackgroundDrawable(statelistdrawable);
        }
        setCheckable(m1.isCheckable());
        setChecked(m1.isChecked());
        setEnabled(m1.isEnabled());
        setTitle(m1.getTitle());
        setIcon(m1.getIcon());
    }

    public final boolean a()
    {
        return false;
    }

    public m getItemData()
    {
        return c;
    }

    protected int[] onCreateDrawableState(int i)
    {
        int ai[] = super.onCreateDrawableState(i + 1);
        if (c != null && c.isCheckable() && c.isChecked())
        {
            mergeDrawableStates(ai, a);
        }
        return ai;
    }

    public void setCheckable(boolean flag)
    {
        refreshDrawableState();
    }

    public void setChecked(boolean flag)
    {
        refreshDrawableState();
    }

    public void setIcon(Drawable drawable)
    {
        Drawable drawable1 = drawable;
        if (drawable != null)
        {
            drawable1 = android.support.v4.c.a.a.c(drawable.getConstantState().newDrawable()).mutate();
            drawable1.setBounds(0, 0, b, b);
            android.support.v4.c.a.a.a(drawable1, d);
        }
        bj.a(this, drawable1, null, null, null);
    }

    void setIconTintList(ColorStateList colorstatelist)
    {
        d = colorstatelist;
        if (c != null)
        {
            setIcon(c.getIcon());
        }
    }

    public void setTitle(CharSequence charsequence)
    {
        setText(charsequence);
    }

}
