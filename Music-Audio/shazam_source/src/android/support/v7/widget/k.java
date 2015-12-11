// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.p;
import android.support.v7.internal.widget.q;
import android.support.v7.internal.widget.r;
import android.util.AttributeSet;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import java.lang.reflect.Field;

public final class k extends Spinner
{

    private static final int a[] = {
        0x10100d4, 0x1010176
    };
    private p b;
    private p c;
    private q d;

    public k(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.b.a.a.spinnerStyle);
    }

    private k(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (!q.a) goto _L2; else goto _L1
_L1:
        context = r.a(getContext(), attributeset, a, i);
        if (context.d(0))
        {
            attributeset = context.a().a(context.e(0, -1));
            if (attributeset != null)
            {
                setInternalBackgroundTint(attributeset);
            }
        }
        if (!context.d(1)) goto _L4; else goto _L3
_L3:
        attributeset = context.a(1);
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L6; else goto _L5
_L5:
        setPopupBackgroundDrawable(attributeset);
_L4:
        d = context.a();
        ((r) (context)).a.recycle();
_L2:
        return;
_L6:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            try
            {
                Object obj = android/widget/Spinner.getDeclaredField("mPopup");
                ((Field) (obj)).setAccessible(true);
                obj = ((Field) (obj)).get(this);
                if (obj instanceof ListPopupWindow)
                {
                    ((ListPopupWindow)obj).setBackgroundDrawable(attributeset);
                }
            }
            // Misplaced declaration of an exception variable
            catch (AttributeSet attributeset)
            {
                attributeset.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (AttributeSet attributeset)
            {
                attributeset.printStackTrace();
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
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
