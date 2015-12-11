// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.by;
import android.support.v7.internal.widget.m;
import android.support.v7.internal.widget.o;
import android.support.v7.internal.widget.p;
import android.support.v7.internal.widget.q;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

public class AppCompatButton extends Button
{

    private static final int TINT_ATTRS[] = {
        0x10100d4
    };
    private o mBackgroundTint;
    private o mInternalBackgroundTint;
    private p mTintManager;

    public AppCompatButton(Context context)
    {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.br.a.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (p.a)
        {
            q q1 = q.a(getContext(), attributeset, TINT_ATTRS, i, 0);
            if (q1.e(0))
            {
                ColorStateList colorstatelist = q1.c().c(q1.f(0, -1));
                if (colorstatelist != null)
                {
                    setInternalBackgroundTint(colorstatelist);
                }
            }
            mTintManager = q1.c();
            q1.b();
        }
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, android.support.v7.br.k.AppCompatTextView, i, 0);
        int j = typedarray.getResourceId(android.support.v7.br.k.AppCompatTextView_android_textAppearance, -1);
        typedarray.recycle();
        if (j != -1)
        {
            TypedArray typedarray1 = context.obtainStyledAttributes(j, android.support.v7.br.k.TextAppearance);
            if (typedarray1.hasValue(android.support.v7.br.k.TextAppearance_textAllCaps))
            {
                setAllCaps(typedarray1.getBoolean(android.support.v7.br.k.TextAppearance_textAllCaps, false));
            }
            typedarray1.recycle();
        }
        attributeset = context.obtainStyledAttributes(attributeset, android.support.v7.br.k.AppCompatTextView, i, 0);
        if (attributeset.hasValue(android.support.v7.br.k.AppCompatTextView_textAllCaps))
        {
            setAllCaps(attributeset.getBoolean(android.support.v7.br.k.AppCompatTextView_textAllCaps, false));
        }
        attributeset.recycle();
        attributeset = getTextColors();
        if (attributeset != null && !attributeset.isStateful())
        {
            if (android.os.Build.VERSION.SDK_INT < 21)
            {
                i = m.c(context, 0x1010038);
            } else
            {
                i = m.a(context, 0x1010038);
            }
            setTextColor(m.a(attributeset.getDefaultColor(), i));
        }
    }

    private void applySupportBackgroundTint()
    {
        if (getBackground() != null)
        {
            if (mBackgroundTint != null)
            {
                p.a(this, mBackgroundTint);
            } else
            if (mInternalBackgroundTint != null)
            {
                p.a(this, mInternalBackgroundTint);
                return;
            }
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorstatelist)
    {
        if (colorstatelist != null)
        {
            if (mInternalBackgroundTint == null)
            {
                mInternalBackgroundTint = new o();
            }
            mInternalBackgroundTint.a = colorstatelist;
            mInternalBackgroundTint.d = true;
        } else
        {
            mInternalBackgroundTint = null;
        }
        applySupportBackgroundTint();
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        applySupportBackgroundTint();
    }

    public ColorStateList getSupportBackgroundTintList()
    {
        if (mBackgroundTint != null)
        {
            return mBackgroundTint.a;
        } else
        {
            return null;
        }
    }

    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode()
    {
        if (mBackgroundTint != null)
        {
            return mBackgroundTint.b;
        } else
        {
            return null;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/Button.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/Button.getName());
    }

    public void setAllCaps(boolean flag)
    {
        by by1;
        if (flag)
        {
            by1 = new by(getContext());
        } else
        {
            by1 = null;
        }
        setTransformationMethod(by1);
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        super.setBackgroundDrawable(drawable);
        setInternalBackgroundTint(null);
    }

    public void setBackgroundResource(int i)
    {
        super.setBackgroundResource(i);
        ColorStateList colorstatelist;
        if (mTintManager != null)
        {
            colorstatelist = mTintManager.c(i);
        } else
        {
            colorstatelist = null;
        }
        setInternalBackgroundTint(colorstatelist);
    }

    public void setSupportBackgroundTintList(ColorStateList colorstatelist)
    {
        if (mBackgroundTint == null)
        {
            mBackgroundTint = new o();
        }
        mBackgroundTint.a = colorstatelist;
        mBackgroundTint.d = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode)
    {
        if (mBackgroundTint == null)
        {
            mBackgroundTint = new o();
        }
        mBackgroundTint.b = mode;
        mBackgroundTint.c = true;
        applySupportBackgroundTint();
    }

    public void setTextAppearance(Context context, int i)
    {
        super.setTextAppearance(context, i);
        context = context.obtainStyledAttributes(i, android.support.v7.br.k.TextAppearance);
        if (context.hasValue(android.support.v7.br.k.TextAppearance_textAllCaps))
        {
            setAllCaps(context.getBoolean(android.support.v7.br.k.TextAppearance_textAllCaps, false));
        }
        context.recycle();
    }

}
