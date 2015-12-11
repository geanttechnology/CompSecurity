// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import com.bitstrips.imoji.util.TextValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.bitstrips.imoji.ui.views:
//            Form, FormField

public static class form extends TextValidator
{

    private final Form form;

    public void validate(FormField formfield, String s)
    {
        boolean flag;
        if (!TextUtils.isEmpty(s) && Patterns.EMAIL_ADDRESS.matcher(s).matches())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || TextUtils.isEmpty(s))
        {
            formfield.setError(null);
        } else
        {
            formfield.setError(form.getContext().getString(0x7f06008f));
        }
        formfield.setValid(flag);
        form.checkValidity();
    }

    public (FormField formfield, Form form1)
    {
        super(formfield);
        form = form1;
    }
}
