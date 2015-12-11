// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.content.DialogInterface;
import android.widget.EditText;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            ChangeItemQuantityFragment

class this._cls0
    implements android.content.er
{

    final ChangeItemQuantityFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i = 0;
        int j = Integer.parseInt(ChangeItemQuantityFragment.access$000(ChangeItemQuantityFragment.this).getText().toString());
        i = j;
_L2:
        if (i == 0 || i == ChangeItemQuantityFragment.access$100(ChangeItemQuantityFragment.this).antity)
        {
            dismiss();
        }
        if (i > ChangeItemQuantityFragment.access$100(ChangeItemQuantityFragment.this).antity)
        {
            return;
        } else
        {
            ChangeItemQuantityFragment.access$200(ChangeItemQuantityFragment.this).onItemQuantityChanged(ChangeItemQuantityFragment.access$100(ChangeItemQuantityFragment.this)._fld0.longValue(), i);
            dismiss();
            return;
        }
        dialoginterface;
        if (true) goto _L2; else goto _L1
_L1:
    }

    angeItemQuantityDialogListener()
    {
        this$0 = ChangeItemQuantityFragment.this;
        super();
    }
}
