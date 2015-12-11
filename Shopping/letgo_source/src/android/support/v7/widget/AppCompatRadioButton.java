// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.p;
import android.support.v7.internal.widget.q;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton extends RadioButton
{

    private static final int TINT_ATTRS[] = {
        0x1010107
    };
    private Drawable mButtonDrawable;
    private p mTintManager;

    public AppCompatRadioButton(Context context)
    {
        this(context, null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.br.a.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (p.a)
        {
            context = q.a(getContext(), attributeset, TINT_ATTRS, i, 0);
            setButtonDrawable(context.a(0));
            context.b();
            mTintManager = context.c();
        }
    }

    public int getCompoundPaddingLeft()
    {
        int j = super.getCompoundPaddingLeft();
        int i = j;
        if (android.os.Build.VERSION.SDK_INT < 17)
        {
            i = j;
            if (mButtonDrawable != null)
            {
                i = j + mButtonDrawable.getIntrinsicWidth();
            }
        }
        return i;
    }

    public void setButtonDrawable(int i)
    {
        if (mTintManager != null)
        {
            setButtonDrawable(mTintManager.a(i));
            return;
        } else
        {
            super.setButtonDrawable(i);
            return;
        }
    }

    public void setButtonDrawable(Drawable drawable)
    {
        super.setButtonDrawable(drawable);
        mButtonDrawable = drawable;
    }

}
