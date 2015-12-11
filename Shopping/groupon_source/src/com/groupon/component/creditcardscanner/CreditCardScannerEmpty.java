// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.component.creditcardscanner;

import android.content.Intent;
import com.groupon.activity.EditCreditCard;

// Referenced classes of package com.groupon.component.creditcardscanner:
//            CreditCardScanner

public class CreditCardScannerEmpty
    implements CreditCardScanner
{

    public CreditCardScannerEmpty()
    {
    }

    public void handleScanResult(EditCreditCard editcreditcard, int i, int j, Intent intent)
    {
    }

    public boolean isOn()
    {
        return false;
    }

    public void startScannerActivity(EditCreditCard editcreditcard)
    {
    }
}
