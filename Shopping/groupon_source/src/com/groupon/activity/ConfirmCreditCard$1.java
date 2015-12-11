// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            ConfirmCreditCard

class this._cls0
    implements android.widget.ionListener
{

    final ConfirmCreditCard this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6)
        {
            ConfirmCreditCard.access$000(ConfirmCreditCard.this);
        }
        return false;
    }

    tener()
    {
        this$0 = ConfirmCreditCard.this;
        super();
    }
}
