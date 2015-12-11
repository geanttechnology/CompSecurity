// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import com.poshmark.utils.ViewUtils;

public class PMButton extends Button
{

    private String fontName;

    public PMButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        fontName = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.PMCommon).getString(0);
        if (fontName != null)
        {
            ViewUtils.setTypefaceForView(context, fontName, this);
        }
    }
}
