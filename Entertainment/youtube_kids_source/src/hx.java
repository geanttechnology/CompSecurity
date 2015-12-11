// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

final class hx extends ht
{

    private final ColorStateList a;
    private final android.graphics.PorterDuff.Mode b;
    private int c;

    public hx(Drawable drawable, ColorStateList colorstatelist)
    {
        this(drawable, colorstatelist, hy.a);
    }

    public hx(Drawable drawable, ColorStateList colorstatelist, android.graphics.PorterDuff.Mode mode)
    {
        super(drawable);
        a = colorstatelist;
        b = mode;
    }

    public final boolean isStateful()
    {
        return a != null && a.isStateful() || super.isStateful();
    }

    public final boolean setState(int ai[])
    {
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag2 = super.setState(ai);
        if (a == null) goto _L2; else goto _L1
_L1:
        int i = a.getColorForState(ai, c);
        if (i == c) goto _L2; else goto _L3
_L3:
        boolean flag;
        if (i != 0)
        {
            setColorFilter(i, b);
        } else
        {
            clearColorFilter();
        }
        c = i;
        flag = true;
_L5:
        if (flag || flag2)
        {
            flag1 = true;
        }
        return flag1;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
