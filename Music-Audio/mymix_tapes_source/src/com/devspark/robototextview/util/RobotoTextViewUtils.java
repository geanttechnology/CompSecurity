// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.devspark.robototextview.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

// Referenced classes of package com.devspark.robototextview.util:
//            RobotoTypefaceManager

public class RobotoTextViewUtils
{

    private RobotoTextViewUtils()
    {
    }

    public static void initTypeface(TextView textview, Context context, AttributeSet attributeset)
    {
        if (attributeset != null)
        {
            attributeset = context.obtainStyledAttributes(attributeset, com.devspark.robototextview.R.styleable.RobotoTextView);
            if (attributeset.hasValue(com.devspark.robototextview.R.styleable.RobotoTextView_typeface))
            {
                context = RobotoTypefaceManager.obtainTypeface(context, attributeset.getInt(com.devspark.robototextview.R.styleable.RobotoTextView_typeface, 4));
            } else
            {
                context = RobotoTypefaceManager.obtainTypeface(context, attributeset.getInt(com.devspark.robototextview.R.styleable.RobotoTextView_fontFamily, 0), attributeset.getInt(com.devspark.robototextview.R.styleable.RobotoTextView_textWeight, 0), attributeset.getInt(com.devspark.robototextview.R.styleable.RobotoTextView_textStyle, 0));
            }
            attributeset.recycle();
        } else
        {
            context = RobotoTypefaceManager.obtainTypeface(context, 4);
        }
        setTypeface(textview, context);
    }

    public static void setTypeface(Paint paint, Typeface typeface)
    {
        paint.setFlags(paint.getFlags() | 0x80 | 1);
        paint.setTypeface(typeface);
    }

    public static void setTypeface(TextView textview, Typeface typeface)
    {
        textview.setPaintFlags(textview.getPaintFlags() | 0x80 | 1);
        textview.setTypeface(typeface);
    }
}
