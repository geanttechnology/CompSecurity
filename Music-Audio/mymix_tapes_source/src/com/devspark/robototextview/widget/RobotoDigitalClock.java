// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.devspark.robototextview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.DigitalClock;
import com.devspark.robototextview.util.RobotoTextViewUtils;

public class RobotoDigitalClock extends DigitalClock
{

    public RobotoDigitalClock(Context context)
    {
        this(context, null);
    }

    public RobotoDigitalClock(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        if (!isInEditMode())
        {
            RobotoTextViewUtils.initTypeface(this, context, attributeset);
        }
    }
}
