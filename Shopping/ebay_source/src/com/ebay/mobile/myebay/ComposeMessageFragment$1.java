// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.ebay.mobile.myebay:
//            ComposeMessageFragment

class this._cls0
    implements TextWatcher
{

    final ComposeMessageFragment this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        ComposeMessageFragment composemessagefragment = ComposeMessageFragment.this;
        boolean flag;
        if (!ComposeMessageFragment.access$000(ComposeMessageFragment.this) && charsequence.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        composemessagefragment.setSendEnabled(flag);
    }

    ()
    {
        this$0 = ComposeMessageFragment.this;
        super();
    }
}
