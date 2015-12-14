// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;

// Referenced classes of package com.livemixtapes:
//            SignUp

class this._cls0
    implements TextWatcher
{

    final SignUp this$0;

    public void afterTextChanged(Editable editable)
    {
        if (SignUp.access$10(SignUp.this).length() > 0)
        {
            SignUp.access$11(SignUp.this).setVisibility(0);
            return;
        } else
        {
            SignUp.access$11(SignUp.this).setVisibility(8);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = SignUp.this;
        super();
    }
}
