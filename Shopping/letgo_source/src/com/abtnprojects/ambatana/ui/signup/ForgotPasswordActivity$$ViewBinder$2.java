// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            ForgotPasswordActivity

class a
    implements TextWatcher
{

    final ForgotPasswordActivity a;
    final nged b;

    public void afterTextChanged(Editable editable)
    {
        a.onAfterTextChanged();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ( , ForgotPasswordActivity forgotpasswordactivity)
    {
        b = ;
        a = forgotpasswordactivity;
        super();
    }
}
