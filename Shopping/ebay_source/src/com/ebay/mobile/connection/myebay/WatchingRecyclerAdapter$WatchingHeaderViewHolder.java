// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            WatchingRecyclerAdapter

class textContent extends com.ebay.mobile.widget.ViewHolder
{

    private final View textContent;
    final WatchingRecyclerAdapter this$0;

    protected void onBindView(int i, CharSequence charsequence)
    {
        if (getSectionFromItemPosition(i).tion() == 0)
        {
            if (textContent != null)
            {
                textContent.setVisibility(8);
            }
            return;
        }
        if (textContent != null)
        {
            textContent.setVisibility(0);
        }
        textView.setText(charsequence);
    }

    public (View view)
    {
        this$0 = WatchingRecyclerAdapter.this;
        super(view);
        textContent = view.findViewById(0x7f1003dd);
    }
}
