// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.view.View;
import com.amazon.retailsearch.interaction.UserInteractionListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.widget:
//            BrandstripWidget

class val.url
    implements android.view.r
{

    final BrandstripWidget this$0;
    final String val$url;

    public void onClick(View view)
    {
        userInteractionListener.search(val$url);
    }

    Q()
    {
        this$0 = final_brandstripwidget;
        val$url = String.this;
        super();
    }
}
