// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.Toast;
import com.groupon.component.creditcardscanner.CreditCardScanner;

// Referenced classes of package com.groupon.activity:
//            EditCreditCard

private class <init>
    implements android.view.istener
{

    final EditCreditCard this$0;

    public void onClick(View view)
    {
        EditCreditCard.access$402(EditCreditCard.this, false);
        try
        {
            EditCreditCard.access$1000(EditCreditCard.this).startScannerActivity(EditCreditCard.this);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Toast.makeText(getApplicationContext(), 0x7f080295, 1).show();
        }
        logCreditCardVariantEvent();
    }

    private A()
    {
        this$0 = EditCreditCard.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
