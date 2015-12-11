// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.browse;

import android.content.Context;
import com.amazon.retailsearch.android.fastBrowse.RefinementsLoader;

// Referenced classes of package com.amazon.now.browse:
//            BrowseActivity

class val.context
    implements Runnable
{

    final BrowseActivity this$0;
    final Context val$context;

    public void run()
    {
        (new RefinementsLoader(new sultListener(BrowseActivity.this, val$context), null)).getRefinements();
    }

    sultListener()
    {
        this$0 = final_browseactivity;
        val$context = Context.this;
        super();
    }
}
