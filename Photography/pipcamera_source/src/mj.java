// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class mj
    implements TextWatcher
{

    private final EditText a;
    private final mk b;

    public mj(EditText edittext, mk mk1)
    {
        a = edittext;
        b = mk1;
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        b.onTextChanged(a, charsequence.toString());
    }
}
