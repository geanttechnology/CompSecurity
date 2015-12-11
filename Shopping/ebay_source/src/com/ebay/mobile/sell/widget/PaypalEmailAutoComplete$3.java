// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.widget;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sell.widget:
//            PaypalEmailAutoComplete

class this._cls0
    implements android.widget.tener
{

    final PaypalEmailAutoComplete this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6)
        {
            clearFocus();
            dismissDropDown();
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = PaypalEmailAutoComplete.this;
        super();
    }
}
