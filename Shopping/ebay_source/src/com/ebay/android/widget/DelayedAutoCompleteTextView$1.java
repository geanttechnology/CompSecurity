// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;


// Referenced classes of package com.ebay.android.widget:
//            DelayedAutoCompleteTextView

class val.keyCode
    implements Runnable
{

    final DelayedAutoCompleteTextView this$0;
    final int val$keyCode;
    final CharSequence val$text;

    public void run()
    {
        if (val$text.length() >= DelayedAutoCompleteTextView.access$000(DelayedAutoCompleteTextView.this))
        {
            DelayedAutoCompleteTextView.access$100(DelayedAutoCompleteTextView.this, val$text, val$keyCode);
        }
    }

    ()
    {
        this$0 = final_delayedautocompletetextview;
        val$text = charsequence;
        val$keyCode = I.this;
        super();
    }
}
