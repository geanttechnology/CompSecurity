// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.activities;

import com.creditcardreader.camera.CreditCardCameraPreview;
import java.util.List;

// Referenced classes of package com.creditcardreader.activities:
//            CreditCardScanActivity

class val.bounds
    implements Runnable
{

    final CreditCardScanActivity this$0;
    final List val$bounds;

    public void run()
    {
        CreditCardScanActivity.access$200(CreditCardScanActivity.this).setBounds(val$bounds);
    }

    ()
    {
        this$0 = final_creditcardscanactivity;
        val$bounds = List.this;
        super();
    }
}
