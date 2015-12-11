// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            AdditionalServicesFragment

private class <init>
    implements TextWatcher
{

    final AdditionalServicesFragment this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        skuTextCountDisplay.setText(getString(0x7f070877, new Object[] {
            Integer.valueOf(charsequence.length())
        }));
    }

    private ()
    {
        this$0 = AdditionalServicesFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
