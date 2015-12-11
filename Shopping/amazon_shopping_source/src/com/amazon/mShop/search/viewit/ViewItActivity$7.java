// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import java.util.Map;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, NullGraphic

class this._cls0
    implements Runnable
{

    final ViewItActivity this$0;

    public void run()
    {
        if (ViewItActivity.access$900(ViewItActivity.this).containsKey(Integer.valueOf(1)))
        {
            ViewItActivity.access$900(ViewItActivity.this).put(Integer.valueOf(1), new NullGraphic());
        }
    }

    ()
    {
        this$0 = ViewItActivity.this;
        super();
    }
}
