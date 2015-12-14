// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.aviary.android.feather.sdk.utils.TypefaceUtils;

public class AviaryTextView extends TextView
{

    public AviaryTextView(Context context)
    {
        super(context);
    }

    public AviaryTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, com.aviary.android.feather.sdk.R.attr.aviaryDefaultTextStyle);
    }

    public AviaryTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (isInEditMode())
        {
            return;
        } else
        {
            context = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviaryTextView, i, 0);
            setTypeface(context.getString(com.aviary.android.feather.sdk.R.styleable.AviaryTextView_aviary_typeface));
            context.recycle();
            return;
        }
    }

    public void setTextAppearance(Context context, int i)
    {
        super.setTextAppearance(context, i);
    }

    public void setTypeface(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        setTypeface(TypefaceUtils.createFromAsset(getContext().getAssets(), s));
        return;
        s;
    }
}
