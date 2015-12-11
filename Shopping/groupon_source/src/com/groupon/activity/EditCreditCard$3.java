// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.groupon.view.CreditCardOneLine;

// Referenced classes of package com.groupon.activity:
//            EditCreditCard

class this._cls0
    implements android.widget.ActionListener
{

    final EditCreditCard this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 5)
        {
            creditCardOneLine.getCreditCardNumberView().requestFocus();
        }
        return false;
    }

    Listener()
    {
        this$0 = EditCreditCard.this;
        super();
    }
}
