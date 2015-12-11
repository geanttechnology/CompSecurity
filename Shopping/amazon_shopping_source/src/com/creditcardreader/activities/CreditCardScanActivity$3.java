// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.activities;

import com.a9.creditcardreaderlibrary.CreditCardResult;
import com.creditcardreader.utils.CreditCardUtils;

// Referenced classes of package com.creditcardreader.activities:
//            CreditCardScanActivity

class val.result
    implements Runnable
{

    final CreditCardScanActivity this$0;
    final CreditCardResult val$result;

    public void run()
    {
        CreditCardScanActivity.access$302(CreditCardScanActivity.this, true);
        CreditCardScanActivity.access$402(CreditCardScanActivity.this, false);
        setResult(-1, CreditCardUtils.createSuccessIntent(val$result));
        finish();
    }

    ()
    {
        this$0 = final_creditcardscanactivity;
        val$result = CreditCardResult.this;
        super();
    }
}
