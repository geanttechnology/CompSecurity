// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;

// Referenced classes of package com.apprupt.sdk:
//            CvValueExchange, CvViewHelper

class val.context
    implements Runnable
{

    final CvValueExchange this$0;
    final int val$adSpaceId;
    final String val$categories;
    final Context val$context;
    final String val$keywords;
    final alListener val$listener;

    public void run()
    {
        CvValueExchange.access$600()._mth600(new Object[] {
            "Preparing for ve..."
        });
    /* block-local class not found */
    class _cls1 {}

        CvViewHelper.runOnUIThread(new _cls1(), true);
    }

    alListener()
    {
        this$0 = final_cvvalueexchange;
        val$adSpaceId = i;
        val$listener = allistener;
        val$categories = s;
        val$keywords = s1;
        val$context = Context.this;
        super();
    }
}
