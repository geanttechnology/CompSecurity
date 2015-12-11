// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.ebay.mobile.sellsmartbox:
//            SmartboxActivity

class this._cls1
    implements TextWatcher
{

    final dateWithResults this$1;

    public void afterTextChanged(Editable editable)
    {
        dateSmartboxButton();
        dateWithResults(null, 0);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
