// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.activities;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.creditcardreader.activities:
//            CreditCardScanActivity

class this._cls0 extends Handler
{

    final CreditCardScanActivity this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            CreditCardScanActivity.access$000(CreditCardScanActivity.this);
            break;
        }
        CreditCardScanActivity.access$100(CreditCardScanActivity.this).sendMessageDelayed(CreditCardScanActivity.access$100(CreditCardScanActivity.this).obtainMessage(1), 3000L);
    }

    (Looper looper)
    {
        this$0 = CreditCardScanActivity.this;
        super(looper);
    }
}
