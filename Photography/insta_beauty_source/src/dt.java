// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

class dt extends db
{

    private final ColorStateList a;
    private final android.graphics.PorterDuff.Mode b;
    private int c;

    public dt(Drawable drawable, ColorStateList colorstatelist)
    {
        this(drawable, colorstatelist, du.a);
    }

    public dt(Drawable drawable, ColorStateList colorstatelist, android.graphics.PorterDuff.Mode mode)
    {
        super(drawable);
        a = colorstatelist;
        b = mode;
    }

    private boolean a(int ai[])
    {
        if (a != null)
        {
            int i = a.getColorForState(ai, c);
            if (i != c)
            {
                if (i != 0)
                {
                    setColorFilter(i, b);
                } else
                {
                    clearColorFilter();
                }
                c = i;
                return true;
            }
        }
        return false;
    }

    public boolean isStateful()
    {
        return a != null && a.isStateful() || super.isStateful();
    }

    public boolean setState(int ai[])
    {
        boolean flag = super.setState(ai);
        return a(ai) || flag;
    }
}
