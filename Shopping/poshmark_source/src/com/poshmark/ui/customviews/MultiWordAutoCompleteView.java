// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class MultiWordAutoCompleteView extends AutoCompleteTextView
{

    private static final String DEFAULT_SEPARATOR = ",";
    private String mSeparator;

    public MultiWordAutoCompleteView(Context context)
    {
        super(context);
        mSeparator = ",";
    }

    public MultiWordAutoCompleteView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSeparator = ",";
    }

    public MultiWordAutoCompleteView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mSeparator = ",";
    }

    public String getSeparator()
    {
        return mSeparator;
    }

    protected void performFiltering(CharSequence charsequence, int i)
    {
        String s = charsequence.toString();
        Object obj = charsequence;
        if (s.indexOf(mSeparator) != -1)
        {
            int j = s.lastIndexOf(mSeparator);
            obj = charsequence;
            if (j != s.length() - 1)
            {
                s = s.substring(j + 1).trim();
                obj = charsequence;
                if (s.length() >= getThreshold())
                {
                    obj = s;
                }
            }
        }
        super.performFiltering(((CharSequence) (obj)), i);
    }

    protected void replaceText(CharSequence charsequence)
    {
        String s = getText().toString();
        if (s.indexOf(mSeparator) != -1)
        {
            int i = s.lastIndexOf(mSeparator);
            charsequence = (new StringBuilder()).append(s.substring(0, i + 1)).append(charsequence.toString()).toString();
        } else
        {
            charsequence = charsequence.toString();
        }
        super.replaceText((new StringBuilder()).append(charsequence).append(" ").toString());
    }

    public void setSeparator(String s)
    {
        mSeparator = s;
    }
}
