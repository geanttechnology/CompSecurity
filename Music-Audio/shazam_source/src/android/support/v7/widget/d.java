// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.b.a;
import android.support.v7.internal.widget.n;
import android.support.v7.internal.widget.p;
import android.support.v7.internal.widget.q;
import android.support.v7.internal.widget.r;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

public final class d extends Button
{

    private static final int a[] = {
        0x10100d4
    };
    private p b;
    private p c;
    private q d;

    public d(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.b.a.a.buttonStyle);
    }

    private d(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (q.a)
        {
            r r1 = r.a(getContext(), attributeset, a, i);
            if (r1.d(0))
            {
                ColorStateList colorstatelist = r1.a().a(r1.e(0, -1));
                if (colorstatelist != null)
                {
                    setInternalBackgroundTint(colorstatelist);
                }
            }
            d = r1.a();
            r1.a.recycle();
        }
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, android.support.v7.b.a.k.AppCompatTextView, i, 0);
        int j = typedarray.getResourceId(android.support.v7.b.a.k.AppCompatTextView_android_textAppearance, -1);
        typedarray.recycle();
        if (j != -1)
        {
            TypedArray typedarray1 = context.obtainStyledAttributes(j, android.support.v7.b.a.k.TextAppearance);
            if (typedarray1.hasValue(android.support.v7.b.a.k.TextAppearance_textAllCaps))
            {
                setAllCaps(typedarray1.getBoolean(android.support.v7.b.a.k.TextAppearance_textAllCaps, false));
            }
            typedarray1.recycle();
        }
        attributeset = context.obtainStyledAttributes(attributeset, android.support.v7.b.a.k.AppCompatTextView, i, 0);
        if (attributeset.hasValue(android.support.v7.b.a.k.AppCompatTextView_textAllCaps))
        {
            setAllCaps(attributeset.getBoolean(android.support.v7.b.a.k.AppCompatTextView_textAllCaps, false));
        }
        attributeset.recycle();
        attributeset = getTextColors();
        if (attributeset != null && !attributeset.isStateful())
        {
            if (android.os.Build.VERSION.SDK_INT < 21)
            {
                i = n.c(context, 0x1010038);
            } else
            {
                i = n.a(context, 0x1010038);
            }
            setTextColor(n.a(attributeset.getDefaultColor(), i));
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

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/Button.getName());
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/Button.getName());
    }

    public final void setAllCaps(boolean flag)
    {
        a a1;
        if (flag)
        {
            a1 = new a(getContext());
        } else
        {
            a1 = null;
        }
        setTransformationMethod(a1);
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

    public final void setTextAppearance(Context context, int i)
    {
        super.setTextAppearance(context, i);
        context = context.obtainStyledAttributes(i, android.support.v7.b.a.k.TextAppearance);
        if (context.hasValue(android.support.v7.b.a.k.TextAppearance_textAllCaps))
        {
            setAllCaps(context.getBoolean(android.support.v7.b.a.k.TextAppearance_textAllCaps, false));
        }
        context.recycle();
    }

}
