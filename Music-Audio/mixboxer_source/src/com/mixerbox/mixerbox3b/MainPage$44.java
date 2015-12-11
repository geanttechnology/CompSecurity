// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.View;
import android.widget.AutoCompleteTextView;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class val.textView
    implements android.view.Listener
{

    final MainPage this$0;
    final AutoCompleteTextView val$textView;

    public void onClick(View view)
    {
        val$textView.setText("");
    }

    ()
    {
        this$0 = final_mainpage;
        val$textView = AutoCompleteTextView.this;
        super();
    }
}
