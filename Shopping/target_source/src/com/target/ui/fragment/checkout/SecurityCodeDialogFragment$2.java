// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

// Referenced classes of package com.target.ui.fragment.checkout:
//            SecurityCodeDialogFragment

class this._cls0
    implements TextWatcher
{

    final SecurityCodeDialogFragment this$0;

    public void afterTextChanged(Editable editable)
    {
        if (SecurityCodeDialogFragment.a(SecurityCodeDialogFragment.this).inputField.getText().toString().length() != SecurityCodeDialogFragment.b(SecurityCodeDialogFragment.this))
        {
            SecurityCodeDialogFragment.a(SecurityCodeDialogFragment.this).submitButton.setEnabled(false);
            return;
        } else
        {
            SecurityCodeDialogFragment.a(SecurityCodeDialogFragment.this).submitButton.setEnabled(true);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ews()
    {
        this$0 = SecurityCodeDialogFragment.this;
        super();
    }
}
