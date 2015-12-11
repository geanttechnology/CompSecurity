// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class RoundedDivider extends View
{

    public RoundedDivider(Context context)
    {
        this(context, null);
    }

    public RoundedDivider(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RoundedDivider(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.RoundedDivider, i, 0);
        setBackgroundResource(0x7f02024a);
        i = context.getColor(0, 0);
        getBackground().setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN);
        context.recycle();
    }
}
