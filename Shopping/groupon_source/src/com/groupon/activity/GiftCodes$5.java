// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;

// Referenced classes of package com.groupon.activity:
//            GiftCodes

class this._cls0
    implements TextWatcher
{

    final GiftCodes this$0;

    public void afterTextChanged(Editable editable)
    {
        GiftCodes.access$300(GiftCodes.this);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (j != 0 || !GiftCodes.access$200(GiftCodes.this).getCurrentCountry().isJapan()) goto _L2; else goto _L1
_L1:
        charsequence = code.getText();
        i = charsequence.length();
        i;
        JVM INSTR lookupswitch 3: default 72
    //                   5: 73
    //                   10: 108
    //                   15: 143;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L3:
        code.setText(charsequence.insert(i - 1, " "));
        code.setSelection(i + 1);
        return;
_L4:
        code.setText(charsequence.insert(i - 1, " "));
        code.setSelection(i + 1);
        return;
_L5:
        code.setText(charsequence.delete(i - 1, i));
        code.setSelection(i - 1);
        return;
    }

    y()
    {
        this$0 = GiftCodes.this;
        super();
    }
}
