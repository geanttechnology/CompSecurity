// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.internal.b.a;
import android.util.AttributeSet;
import android.widget.TextView;

public class l extends TextView
{

    public l(Context context)
    {
        this(context, null);
    }

    public l(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010084);
    }

    public l(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
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
        context = context.obtainStyledAttributes(attributeset, android.support.v7.b.a.k.AppCompatTextView, i, 0);
        if (context.hasValue(android.support.v7.b.a.k.AppCompatTextView_textAllCaps))
        {
            setAllCaps(context.getBoolean(android.support.v7.b.a.k.AppCompatTextView_textAllCaps, false));
        }
        context.recycle();
    }

    public void setAllCaps(boolean flag)
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

    public void setTextAppearance(Context context, int i)
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
