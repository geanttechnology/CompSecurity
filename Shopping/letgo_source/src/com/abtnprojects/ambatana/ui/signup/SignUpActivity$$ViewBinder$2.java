// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            SignUpActivity

class a
    implements TextWatcher
{

    final SignUpActivity a;
    final anged b;

    public void afterTextChanged(Editable editable)
    {
        a.onSignInTextChanged();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ( , SignUpActivity signupactivity)
    {
        b = ;
        a = signupactivity;
        super();
    }
}
