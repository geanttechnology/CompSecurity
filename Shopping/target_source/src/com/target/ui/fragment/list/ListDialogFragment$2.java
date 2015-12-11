// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.target.ui.fragment.list:
//            ListDialogFragment

class this._cls0
    implements TextWatcher
{

    final ListDialogFragment this$0;

    public void afterTextChanged(Editable editable)
    {
        ListDialogFragment.a(ListDialogFragment.this);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = ListDialogFragment.this;
        super();
    }
}
