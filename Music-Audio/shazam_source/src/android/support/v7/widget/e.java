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
import android.widget.CheckBox;

public final class e extends CheckBox
{

    private static final int a[] = {
        0x1010107
    };
    private q b;
    private Drawable c;

    public e(Context context)
    {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.b.a.a.checkboxStyle);
    }

    private e(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (q.a)
        {
            context = r.a(getContext(), attributeset, a, i);
            setButtonDrawable(context.a(0));
            ((r) (context)).a.recycle();
            b = context.a();
        }
    }

    public final int getCompoundPaddingLeft()
    {
        int j = super.getCompoundPaddingLeft();
        int i = j;
        if (android.os.Build.VERSION.SDK_INT < 17)
        {
            i = j;
            if (c != null)
            {
                i = j + c.getIntrinsicWidth();
            }
        }
        return i;
    }

    public final void setButtonDrawable(int i)
    {
        if (b != null)
        {
            setButtonDrawable(b.a(i, false));
            return;
        } else
        {
            super.setButtonDrawable(i);
            return;
        }
    }

    public final void setButtonDrawable(Drawable drawable)
    {
        super.setButtonDrawable(drawable);
        c = drawable;
    }

}
