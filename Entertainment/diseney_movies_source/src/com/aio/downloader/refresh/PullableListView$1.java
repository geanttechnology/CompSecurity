// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.refresh;

import android.content.Context;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.aio.downloader.refresh:
//            PullableListView

class val.context
    implements android.view.r
{

    final PullableListView this$0;
    private final Context val$context;

    public void onClick(View view)
    {
        if (PullableListView.access$0(PullableListView.this) != 1 && PullableListView.access$1(PullableListView.this))
        {
            view = new Intent("load_more");
            val$context.sendBroadcast(view);
        }
    }

    ()
    {
        this$0 = final_pullablelistview;
        val$context = Context.this;
        super();
    }
}
