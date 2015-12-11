// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sell:
//            TitleSpokeFragment

class this._cls0
    implements TextWatcher
{

    final TitleSpokeFragment this$0;

    public void afterTextChanged(Editable editable)
    {
        int i = 55 - editable.toString().length();
        characterCounter.setText(getView().getContext().getResources().getQuantityString(0x7f080011, i, new Object[] {
            Integer.valueOf(i)
        }));
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = TitleSpokeFragment.this;
        super();
    }
}
