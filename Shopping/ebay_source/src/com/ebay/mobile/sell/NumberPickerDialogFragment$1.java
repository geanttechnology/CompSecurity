// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.DialogInterface;
import android.widget.NumberPicker;

// Referenced classes of package com.ebay.mobile.sell:
//            NumberPickerDialogFragment

class this._cls0
    implements android.content.er
{

    final NumberPickerDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (numberPickerListener != null)
        {
            numberPickerListener.onNumberSelected(numberPicker.getValue());
        }
        dialoginterface.dismiss();
    }

    mberPickerListener()
    {
        this$0 = NumberPickerDialogFragment.this;
        super();
    }
}
