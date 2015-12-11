// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.q;
import android.support.v7.internal.widget.r;
import android.support.v7.internal.widget.s;
import android.util.AttributeSet;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import java.lang.reflect.Field;

public class j extends Spinner
{

    private static final int TINT_ATTRS[] = {
        0x10100d4, 0x1010176
    };
    private q mBackgroundTint;
    private q mInternalBackgroundTint;
    private r mTintManager;

    public j(Context context)
    {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.a.a.a.spinnerStyle);
    }

    public j(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (!r.a) goto _L2; else goto _L1
_L1:
        context = s.a(getContext(), attributeset, TINT_ATTRS, i, 0);
        if (context.e(0))
        {
            attributeset = context.c().c(context.f(0, -1));
            if (attributeset != null)
            {
                setInternalBackgroundTint(attributeset);
            }
        }
        if (!context.e(1)) goto _L4; else goto _L3
_L3:
        attributeset = context.a(1);
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L6; else goto _L5
_L5:
        setPopupBackgroundDrawable(attributeset);
_L4:
        mTintManager = context.c();
        context.b();
_L2:
        return;
_L6:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a(this, attributeset);
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    private void a()
    {
        if (getBackground() != null)
        {
            if (mBackgroundTint != null)
            {
                r.a(this, mBackgroundTint);
            } else
            if (mInternalBackgroundTint != null)
            {
                r.a(this, mInternalBackgroundTint);
                return;
            }
        }
    }

    private static void a(Spinner spinner, Drawable drawable)
    {
        try
        {
            Field field = android/widget/Spinner.getDeclaredField("mPopup");
            field.setAccessible(true);
            spinner = ((Spinner) (field.get(spinner)));
            if (spinner instanceof ListPopupWindow)
            {
                ((ListPopupWindow)spinner).setBackgroundDrawable(drawable);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Spinner spinner)
        {
            spinner.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Spinner spinner)
        {
            spinner.printStackTrace();
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorstatelist)
    {
        if (colorstatelist != null)
        {
            if (mInternalBackgroundTint == null)
            {
                mInternalBackgroundTint = new q();
            }
            mInternalBackgroundTint.a = colorstatelist;
            mInternalBackgroundTint.d = true;
        } else
        {
            mInternalBackgroundTint = null;
        }
        a();
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        a();
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

    public void setSupportBackgroundTintList(ColorStateList colorstatelist)
    {
        if (mBackgroundTint == null)
        {
            mBackgroundTint = new q();
        }
        mBackgroundTint.a = colorstatelist;
        mBackgroundTint.d = true;
        a();
    }

    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode)
    {
        if (mBackgroundTint == null)
        {
            mBackgroundTint = new q();
        }
        mBackgroundTint.b = mode;
        mBackgroundTint.c = true;
        a();
    }

}
