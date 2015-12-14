// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.tools;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package com.socialin.android.photo.tools:
//            ResizeDialogActivity

final class a
    implements TextWatcher
{

    private EditText a;
    private ResizeDialogActivity b;

    public final void afterTextChanged(Editable editable)
    {
        if (ResizeDialogActivity.a(b) && !editable.toString().equals(""))
        {
            int i = Math.round(((float)ResizeDialogActivity.b(b) / (float)ResizeDialogActivity.c(b)) * (float)Integer.parseInt(editable.toString()));
            a.setText(String.valueOf(i));
        }
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (ResizeDialogActivity resizedialogactivity, EditText edittext)
    {
        b = resizedialogactivity;
        a = edittext;
        super();
    }
}
