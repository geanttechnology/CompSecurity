// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.view.View;
import com.amazon.retailsearch.interaction.UserInteractionListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.widget:
//            SparkleWidget

class val.url
    implements android.view.ener
{

    final SparkleWidget this$0;
    final String val$url;

    public void onClick(View view)
    {
        userInteractionListener.loadUrl(val$url);
    }

    ()
    {
        this$0 = final_sparklewidget;
        val$url = String.this;
        super();
    }
}
