// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            Sims

class val.e
    implements Runnable
{

    final val.e this$1;
    final Exception val$e;

    public void run()
    {
        Sims.access$700().error("Similarites Error", val$e);
        setVisibility(8);
    }

    ()
    {
        this$1 = final_;
        val$e = Exception.this;
        super();
    }
}
