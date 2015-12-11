// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.search;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

// Referenced classes of package com.amazon.now.search:
//            SearchActivity

class val.mic
    implements TextWatcher
{

    final SearchActivity this$0;
    final ImageView val$mic;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (i == 0)
        {
            charsequence = val$mic;
            if (k > 0)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            charsequence.setVisibility(i);
        }
    }

    ()
    {
        this$0 = final_searchactivity;
        val$mic = ImageView.this;
        super();
    }
}
