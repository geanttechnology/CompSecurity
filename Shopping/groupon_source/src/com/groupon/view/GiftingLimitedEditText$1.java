// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

// Referenced classes of package com.groupon.view:
//            GiftingLimitedEditText

class this._cls0
    implements TextWatcher
{

    final GiftingLimitedEditText this$0;

    public void afterTextChanged(Editable editable)
    {
        counter.setText(String.valueOf(GiftingLimitedEditText.access$000(GiftingLimitedEditText.this) - editable.length()));
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = GiftingLimitedEditText.this;
        super();
    }
}
