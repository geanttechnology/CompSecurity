// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.groupon.activity:
//            Purchase, IntentFactory

class this._cls0
    implements android.view.Listener
{

    final Purchase this$0;

    public void onClick(View view)
    {
        startActivityForResult(intentFactory.newStockCategoriesIntent(dealId, dealOptionId).putExtra("stockValue", stockValue), 10121);
    }

    y()
    {
        this$0 = Purchase.this;
        super();
    }
}
