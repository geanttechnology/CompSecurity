// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.q;
import android.support.v7.internal.widget.r;
import android.util.AttributeSet;
import android.widget.RadioButton;

public final class i extends RadioButton
{

    private static final int a[] = {
        0x1010107
    };
    private q b;
    private Drawable c;

    public i(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.b.a.a.radioButtonStyle);
    }

    private i(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        if (q.a)
        {
            context = r.a(getContext(), attributeset, a, j);
            setButtonDrawable(context.a(0));
            ((r) (context)).a.recycle();
            b = context.a();
        }
    }

    public final int getCompoundPaddingLeft()
    {
        int k = super.getCompoundPaddingLeft();
        int j = k;
        if (android.os.Build.VERSION.SDK_INT < 17)
        {
            j = k;
            if (c != null)
            {
                j = k + c.getIntrinsicWidth();
            }
        }
        return j;
    }

    public final void setButtonDrawable(int j)
    {
        if (b != null)
        {
            setButtonDrawable(b.a(j, false));
            return;
        } else
        {
            super.setButtonDrawable(j);
            return;
        }
    }

    public final void setButtonDrawable(Drawable drawable)
    {
        super.setButtonDrawable(drawable);
        c = drawable;
    }

}
