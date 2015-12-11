// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.activities;

import android.view.View;
import android.widget.ImageButton;

// Referenced classes of package com.creditcardreader.activities:
//            CreditCardScanActivity

class flashOn
    implements android.view.CardScanActivity._cls8
{

    boolean flashOn;
    final CreditCardScanActivity this$0;
    final ImageButton val$torchButton;

    public void onClick(View view)
    {
        if (flashOn)
        {
            flashOn = false;
            val$torchButton.setImageResource(com.creditcardreader.Activity._cls8.val.torchButton);
            CreditCardScanActivity.access$900(CreditCardScanActivity.this);
            return;
        } else
        {
            flashOn = true;
            val$torchButton.setImageResource(com.creditcardreader.on);
            CreditCardScanActivity.access$1000(CreditCardScanActivity.this);
            return;
        }
    }

    ()
    {
        this$0 = final_creditcardscanactivity;
        val$torchButton = ImageButton.this;
        super();
        flashOn = false;
    }
}
