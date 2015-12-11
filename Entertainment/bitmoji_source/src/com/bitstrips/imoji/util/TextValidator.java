// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.util;

import android.text.Editable;
import android.text.TextWatcher;
import com.bitstrips.imoji.ui.views.FormField;

public abstract class TextValidator
    implements TextWatcher
{

    protected final FormField field;

    public TextValidator(FormField formfield)
    {
        field = formfield;
    }

    public final void afterTextChanged(Editable editable)
    {
        editable = editable.toString();
        validate(field, editable);
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public abstract void validate(FormField formfield, String s);
}
