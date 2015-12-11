// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o

final class c
    implements TextWatcher
{

    final EditText a;
    final EditText b;
    final Button c;

    public void afterTextChanged(Editable editable)
    {
        o.b(a, b, c);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (EditText edittext, EditText edittext1, Button button)
    {
        a = edittext;
        b = edittext1;
        c = button;
        super();
    }
}
