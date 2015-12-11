// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.CheckBox;
import com.groupon.util.CreditCardStorageOptInHandler;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

protected class this._cls0
    implements android.view.istener
{

    final EditCreditCardEu this$0;

    public void onClick(View view)
    {
        EditCreditCardEu.access$100(EditCreditCardEu.this).doUpdateUserConsent(storageChoice.isChecked());
    }

    protected A()
    {
        this$0 = EditCreditCardEu.this;
        super();
    }
}
