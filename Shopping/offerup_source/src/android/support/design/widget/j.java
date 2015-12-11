// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;

// Referenced classes of package android.support.design.widget:
//            i

final class j extends i
{

    private ColorStateList c;
    private android.graphics.PorterDuff.Mode d;
    private PorterDuffColorFilter e;

    j()
    {
        d = android.graphics.PorterDuff.Mode.SRC_IN;
    }

    private PorterDuffColorFilter a(ColorStateList colorstatelist, android.graphics.PorterDuff.Mode mode)
    {
        if (colorstatelist == null || mode == null)
        {
            return null;
        } else
        {
            return new PorterDuffColorFilter(colorstatelist.getColorForState(getState(), 0), mode);
        }
    }

    public final void draw(Canvas canvas)
    {
        boolean flag;
        if (e != null && a.getColorFilter() == null)
        {
            a.setColorFilter(e);
            flag = true;
        } else
        {
            flag = false;
        }
        super.draw(canvas);
        if (flag)
        {
            a.setColorFilter(null);
        }
    }

    public final void getOutline(Outline outline)
    {
        copyBounds(b);
        outline.setOval(b);
    }

    public final void setTintList(ColorStateList colorstatelist)
    {
        c = colorstatelist;
        e = a(colorstatelist, d);
        invalidateSelf();
    }

    public final void setTintMode(android.graphics.PorterDuff.Mode mode)
    {
        d = mode;
        e = a(c, mode);
        invalidateSelf();
    }
}
