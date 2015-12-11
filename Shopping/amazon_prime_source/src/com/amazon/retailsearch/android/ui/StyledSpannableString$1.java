// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.res.Resources;
import android.view.View;
import com.amazon.retailsearch.android.ui.results.SearchLinkSpan;
import com.amazon.retailsearch.interaction.UserInteractionListener;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            StyledSpannableString

class init> extends SearchLinkSpan
{

    final StyledSpannableString this$0;
    final String val$url;

    public void onClick(View view)
    {
        if (userInteractionListener != null)
        {
            userInteractionListener.search(val$url);
        }
    }

    (String s)
    {
        this$0 = final_styledspannablestring;
        val$url = s;
        super(Resources.this);
    }
}
