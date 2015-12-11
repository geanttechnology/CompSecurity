// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.activities;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.creditcardreader.metrics.CreditCardMetricsRecorder;

// Referenced classes of package com.creditcardreader.activities:
//            CreditCardScanActivity

class this._cls0
    implements android.view.CardScanActivity._cls7
{

    final CreditCardScanActivity this$0;

    public void onClick(View view)
    {
        CreditCardScanActivity.access$800(CreditCardScanActivity.this).recordHelp();
        view = new Intent("android.intent.action.VIEW", Uri.parse(getString(com.creditcardreader.e_us)));
        startActivity(view);
    }

    ()
    {
        this$0 = CreditCardScanActivity.this;
        super();
    }
}
