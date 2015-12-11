// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.o;
import android.support.v7.internal.widget.p;
import android.support.v7.internal.widget.q;
import android.support.v7.internal.widget.r;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;

public final class h extends MultiAutoCompleteTextView
{

    private static final int a[] = {
        0x10100d4, 0x1010176
    };
    private p b;
    private p c;
    private q d;

    public h(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.b.a.a.autoCompleteTextViewStyle);
    }

    private h(Context context, AttributeSet attributeset, int i)
    {
        super(o.a(context), attributeset, i);
        if (q.a)
        {
            context = r.a(getContext(), attributeset, a, i);
            d = context.a();
            if (context.d(0))
            {
                attributeset = context.a().a(context.e(0, -1));
                if (attributeset != null)
                {
                    setInternalBackgroundTint(attributeset);
                }
            }
            if (context.d(1))
            {
                setDropDownBackgroundDrawable(context.a(1));
            }
            ((r) (context)).a.recycle();
        }
    }

    private void a()
    {
        if (getBackground() != null)
        {
            if (c != null)
            {
                q.a(this, c);
            } else
            if (b != null)
            {
                q.a(this, b);
                return;
            }
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorstatelist)
    {
        if (colorstatelist != null)
        {
            if (b == null)
            {
                b = new p();
            }
            b.a = colorstatelist;
            b.d = true;
        } else
        {
            b = null;
        }
        a();
    }

    protected final void drawableStateChanged()
    {
        super.drawableStateChanged();
        a();
    }

    public final ColorStateList getSupportBackgroundTintList()
    {
        if (c != null)
        {
            return c.a;
        } else
        {
            return null;
        }
    }

    public final android.graphics.PorterDuff.Mode getSupportBackgroundTintMode()
    {
        if (c != null)
        {
            return c.b;
        } else
        {
            return null;
        }
    }

    public final void setBackgroundDrawable(Drawable drawable)
    {
        super.setBackgroundDrawable(drawable);
        setInternalBackgroundTint(null);
    }

    public final void setBackgroundResource(int i)
    {
        super.setBackgroundResource(i);
        ColorStateList colorstatelist;
        if (d != null)
        {
            colorstatelist = d.a(i);
        } else
        {
            colorstatelist = null;
        }
        setInternalBackgroundTint(colorstatelist);
    }

    public final void setDropDownBackgroundResource(int i)
    {
        if (d != null)
        {
            setDropDownBackgroundDrawable(d.a(i, false));
            return;
        } else
        {
            super.setDropDownBackgroundResource(i);
            return;
        }
    }

    public final void setSupportBackgroundTintList(ColorStateList colorstatelist)
    {
        if (c == null)
        {
            c = new p();
        }
        c.a = colorstatelist;
        c.d = true;
        a();
    }

    public final void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode)
    {
        if (c == null)
        {
            c = new p();
        }
        c.b = mode;
        c.c = true;
        a();
    }

}
