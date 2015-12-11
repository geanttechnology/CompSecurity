// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class DelayedAutoCompleteTextView extends AutoCompleteTextView
{

    private static final int DEFAULT_DELAY = 250;
    private int delay;
    private Handler handler;
    private Runnable runnable;
    private int threshold;

    public DelayedAutoCompleteTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        delay = 250;
        handler = new Handler();
        context = context.getTheme().obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.DelayedAutoCompleteTextView, 0, 0);
        delay = context.getInteger(0, 250);
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    private void doFiltering(CharSequence charsequence, int i)
    {
        super.performFiltering(charsequence, i);
    }

    public int getDelay()
    {
        return delay;
    }

    protected void performFiltering(final CharSequence text, final int keyCode)
    {
        threshold = getThreshold();
        handler.removeCallbacks(runnable);
        runnable = new Runnable() {

            final DelayedAutoCompleteTextView this$0;
            final int val$keyCode;
            final CharSequence val$text;

            public void run()
            {
                if (text.length() >= threshold)
                {
                    doFiltering(text, keyCode);
                }
            }

            
            {
                this$0 = DelayedAutoCompleteTextView.this;
                text = charsequence;
                keyCode = i;
                super();
            }
        };
        handler.postDelayed(runnable, delay);
    }

    public void setDelay(int i)
    {
        delay = i;
    }


}
