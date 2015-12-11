// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

// Referenced classes of package com.helpshift:
//            HSAddIssueFragment

class a
    implements TextWatcher
{

    final HSAddIssueFragment a;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        HSAddIssueFragment.f(a).setError(null);
    }

    (HSAddIssueFragment hsaddissuefragment)
    {
        a = hsaddissuefragment;
        super();
    }
}
