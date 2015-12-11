// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.ebay.mobile.checkout:
//            ChangeCartItemQuantityActivity

class this._cls0
    implements android.view.yActivity._cls1
{

    final ChangeCartItemQuantityActivity this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 66)
        {
            i = Integer.parseInt(quantityInput.getText().toString());
            if (i > 0 && i <= quantityAvailable)
            {
                ChangeCartItemQuantityActivity.access$000(ChangeCartItemQuantityActivity.this, i);
            }
        }
        return false;
    }

    ()
    {
        this$0 = ChangeCartItemQuantityActivity.this;
        super();
    }
}
