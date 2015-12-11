// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import com.groupon.util.Function0;

// Referenced classes of package com.groupon.activity:
//            PurchaseEu

class val.data
    implements Function0
{

    final PurchaseEu this$0;
    final Intent val$data;
    final int val$requestCode;
    final int val$resultCode;

    public void execute()
    {
        PurchaseEu.access$300(PurchaseEu.this, val$requestCode, val$resultCode, val$data);
    }

    ()
    {
        this$0 = final_purchaseeu;
        val$requestCode = i;
        val$resultCode = j;
        val$data = Intent.this;
        super();
    }
}
