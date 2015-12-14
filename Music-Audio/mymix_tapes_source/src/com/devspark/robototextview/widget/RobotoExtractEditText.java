// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.devspark.robototextview.widget;

import android.content.Context;
import android.inputmethodservice.ExtractEditText;
import android.util.AttributeSet;
import com.devspark.robototextview.util.RobotoTextViewUtils;

public class RobotoExtractEditText extends ExtractEditText
{

    public RobotoExtractEditText(Context context)
    {
        this(context, null);
    }

    public RobotoExtractEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        if (!isInEditMode())
        {
            RobotoTextViewUtils.initTypeface(this, context, attributeset);
        }
    }

    public RobotoExtractEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (!isInEditMode())
        {
            RobotoTextViewUtils.initTypeface(this, context, attributeset);
        }
    }
}
