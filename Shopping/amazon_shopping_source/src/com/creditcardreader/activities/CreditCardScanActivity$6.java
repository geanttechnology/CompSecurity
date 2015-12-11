// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.activities;

import com.creditcardreader.camera.CreditCardCameraPreview;

// Referenced classes of package com.creditcardreader.activities:
//            CreditCardScanActivity

class this._cls0
    implements Runnable
{

    final CreditCardScanActivity this$0;

    public void run()
    {
        try
        {
            Thread.sleep(CreditCardScanActivity.access$500(CreditCardScanActivity.this));
            if (CreditCardScanActivity.access$200(CreditCardScanActivity.this).isScanning() && !CreditCardScanActivity.access$600(CreditCardScanActivity.this))
            {
                CreditCardScanActivity.access$700(CreditCardScanActivity.this);
            }
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    ()
    {
        this$0 = CreditCardScanActivity.this;
        super();
    }
}
