// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.util.Function0;

// Referenced classes of package com.groupon.activity:
//            Purchase

class this._cls0
    implements Function0
{

    final Purchase this$0;

    public void execute()
    {
        Purchase.access$1300(Purchase.this, false);
        recreateOrderBreakdowns();
        if (bottomBar != null)
        {
            bottomBar.setVisibility(0);
        }
    }

    ()
    {
        this$0 = Purchase.this;
        super();
    }
}
