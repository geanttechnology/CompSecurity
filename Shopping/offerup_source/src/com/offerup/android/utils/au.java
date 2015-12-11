// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.b.a.a.g;

final class au
    implements TextWatcher
{

    private EditText a;

    au(EditText edittext)
    {
        a = edittext;
        super();
    }

    public final void afterTextChanged(Editable editable)
    {
        editable = editable.toString();
        if (!editable.equalsIgnoreCase("")) goto _L2; else goto _L1
_L1:
        a.setText("$");
_L5:
        a.setSelection(a.getText().toString().length());
        return;
_L2:
        if (editable.contains("$")) goto _L4; else goto _L3
_L3:
        a.setText((new StringBuilder("$")).append(a.getText().toString()).toString());
          goto _L5
        editable;
        g.a(this, editable);
        return;
_L4:
        if (editable.indexOf("$") <= 0) goto _L5; else goto _L6
_L6:
        String s = editable.substring(0, 1);
        a.setText((new StringBuilder()).append(editable.substring(1)).append(s).toString());
          goto _L5
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        a.setSelection(a.getText().toString().length());
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        a.setSelection(a.getText().toString().length());
    }
}
