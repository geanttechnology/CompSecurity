// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItMetricHelper

class this._cls0
    implements Runnable
{

    final ViewItActivity this$0;

    public void run()
    {
        ViewItActivity.access$100(ViewItActivity.this).logCountMetricsPerSession("successes-per-session", 1);
        if (!Util.isEmpty(ViewItActivity.access$200(ViewItActivity.this)))
        {
            ViewItActivity.access$300(ViewItActivity.this, ViewItActivity.access$200(ViewItActivity.this), ultType.BARCODE);
        } else
        if (!Util.isEmpty(ViewItActivity.access$400(ViewItActivity.this)))
        {
            ViewItActivity.access$300(ViewItActivity.this, ViewItActivity.access$400(ViewItActivity.this), ultType.IMAGE);
            return;
        }
    }

    ultType()
    {
        this$0 = ViewItActivity.this;
        super();
    }
}
