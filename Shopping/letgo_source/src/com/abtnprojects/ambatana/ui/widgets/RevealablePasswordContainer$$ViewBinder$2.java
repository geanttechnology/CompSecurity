// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets:
//            RevealablePasswordContainer

class b
    implements TextWatcher
{

    final RevealablePasswordContainer a;
    final butterknife.dContainer b;
    final b c;

    public void afterTextChanged(Editable editable)
    {
        a.onSignInPasswordTextChanged((CharSequence)b.b(editable, "afterTextChanged", 0, "onSignInPasswordTextChanged", 0));
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ( , RevealablePasswordContainer revealablepasswordcontainer, butterknife.dContainer dcontainer)
    {
        c = ;
        a = revealablepasswordcontainer;
        b = dcontainer;
        super();
    }
}
