// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.n;
import android.support.v7.internal.widget.o;
import android.support.v7.internal.widget.p;
import android.support.v7.internal.widget.q;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView
{

    private static final int TINT_ATTRS[] = {
        0x10100d4, 0x1010176
    };
    private o mBackgroundTint;
    private o mInternalBackgroundTint;
    private p mTintManager;

    public AppCompatAutoCompleteTextView(Context context)
    {
        this(context, null);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.br.a.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeset, int i)
    {
        super(n.a(context), attributeset, i);
        if (p.a)
        {
            context = q.a(getContext(), attributeset, TINT_ATTRS, i, 0);
            mTintManager = context.c();
            if (context.e(0))
            {
                attributeset = context.c().c(context.f(0, -1));
                if (attributeset != null)
                {
                    setInternalBackgroundTint(attributeset);
                }
            }
            if (context.e(1))
            {
                setDropDownBackgroundDrawable(context.a(1));
            }
            context.b();
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

    public void setDropDownBackgroundResource(int i)
    {
        setDropDownBackgroundDrawable(mTintManager.a(i));
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

}
