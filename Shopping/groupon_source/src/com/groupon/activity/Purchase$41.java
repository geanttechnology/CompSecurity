// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;

// Referenced classes of package com.groupon.activity:
//            Purchase

class val.key
    implements android.view.Listener
{

    final Purchase this$0;
    final String val$key;

    public void onClick(View view)
    {
        view = Purchase.access$3700(Purchase.this, val$key);
        if (view != null && view.length > 0)
        {
            Purchase.access$3500(Purchase.this, val$key, view, null);
            return;
        } else
        {
            Purchase.access$3800(Purchase.this, val$key);
            return;
        }
    }

    ()
    {
        this$0 = final_purchase;
        val$key = String.this;
        super();
    }
}
