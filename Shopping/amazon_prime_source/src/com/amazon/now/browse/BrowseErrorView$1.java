// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.browse;

import android.view.View;

// Referenced classes of package com.amazon.now.browse:
//            BrowseErrorView

class wseRetry
    implements android.view.er
{

    final BrowseErrorView this$0;
    final wseRetry val$browseRetry;

    public void onClick(View view)
    {
        if (val$browseRetry != null)
        {
            val$browseRetry.retry();
        }
    }

    wseRetry()
    {
        this$0 = final_browseerrorview;
        val$browseRetry = wseRetry.this;
        super();
    }
}
