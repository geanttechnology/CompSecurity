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
import android.support.v4.widget.r;
import android.support.v7.internal.view.menu.h;
import android.support.v7.u;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class NavigationMenuItemView extends TextView
    implements android.support.v7.internal.view.menu.m.a
{

    private static final int a[] = {
        0x10100a0
    };
    private int b;
    private h c;
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
        b = context.getResources().getDimensionPixelSize(android.support.v7.a.c.navigation_icon_size);
    }

    private StateListDrawable b()
    {
        TypedValue typedvalue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(android.support.v7.a.b.colorControlHighlight, typedvalue, true))
        {
            StateListDrawable statelistdrawable = new StateListDrawable();
            statelistdrawable.addState(a, new ColorDrawable(typedvalue.data));
            statelistdrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            return statelistdrawable;
        } else
        {
            return null;
        }
    }

    public void a(h h1, int i)
    {
        c = h1;
        if (h1.isVisible())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        setVisibility(i);
        if (getBackground() == null)
        {
            setBackgroundDrawable(b());
        }
        setCheckable(h1.isCheckable());
        setChecked(h1.isChecked());
        setEnabled(h1.isEnabled());
        setTitle(h1.getTitle());
        setIcon(h1.getIcon());
    }

    public boolean a()
    {
        return false;
    }

    public h getItemData()
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
            drawable1 = u.c(drawable).mutate();
            drawable1.setBounds(0, 0, b, b);
            u.a(drawable1, d);
        }
        r.a(this, drawable1, null, null, null);
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
