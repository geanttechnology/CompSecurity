// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;

import android.widget.TextView;

// Referenced classes of package com.amazon.now.cart:
//            ActionBarCartView

class val.count
    implements Runnable
{

    final ActionBarCartView this$0;
    final int val$count;

    public void run()
    {
        float f = 12F;
        if (val$count >= 100)
        {
            f = 9F;
        }
        ActionBarCartView.access$000(ActionBarCartView.this).setTextSize(2, f);
        ActionBarCartView.access$000(ActionBarCartView.this).setText(Integer.toString(val$count));
    }

    ()
    {
        this$0 = final_actionbarcartview;
        val$count = I.this;
        super();
    }
}
