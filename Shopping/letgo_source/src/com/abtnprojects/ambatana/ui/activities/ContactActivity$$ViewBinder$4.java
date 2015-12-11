// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            ContactActivity

class a
    implements TextWatcher
{

    final ContactActivity a;
    final ed b;

    public void afterTextChanged(Editable editable)
    {
        a.afterTextChanged();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ( , ContactActivity contactactivity)
    {
        b = ;
        a = contactactivity;
        super();
    }
}
