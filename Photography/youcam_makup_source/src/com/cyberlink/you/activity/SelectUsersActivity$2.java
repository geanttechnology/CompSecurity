// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Filter;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectUsersActivity, q

class a
    implements TextWatcher
{

    final SelectUsersActivity a;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        SelectUsersActivity.c(a).getFilter().filter(charsequence.toString());
    }

    (SelectUsersActivity selectusersactivity)
    {
        a = selectusersactivity;
        super();
    }
}
