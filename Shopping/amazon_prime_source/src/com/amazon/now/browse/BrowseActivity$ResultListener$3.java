// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.browse;

import com.amazon.now.ChromeStyle;

// Referenced classes of package com.amazon.now.browse:
//            BrowseActivity, BrowseErrorView

class val.errorView
    implements Runnable
{

    final val.errorView this$1;
    final BrowseErrorView val$errorView;

    public void run()
    {
        setRootView(val$errorView, new ChromeStyle(com.amazon.now.ener._cls3.val.errorView));
    }

    ()
    {
        this$1 = final_;
        val$errorView = BrowseErrorView.this;
        super();
    }
}
