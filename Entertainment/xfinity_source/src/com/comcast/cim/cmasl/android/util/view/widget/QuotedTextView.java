// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class QuotedTextView extends TextView
{

    public QuotedTextView(Context context)
    {
        super(context);
    }

    public QuotedTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public QuotedTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void setText(CharSequence charsequence, android.widget.TextView.BufferType buffertype)
    {
        if (charsequence != null && charsequence.length() > 0)
        {
            super.setText((new StringBuilder()).append("\"").append(charsequence.toString().trim()).append("\"").toString(), buffertype);
            return;
        } else
        {
            super.setText(charsequence, buffertype);
            return;
        }
    }
}
