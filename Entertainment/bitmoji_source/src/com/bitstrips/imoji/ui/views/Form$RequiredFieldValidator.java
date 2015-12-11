// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import com.bitstrips.imoji.util.TextValidator;

// Referenced classes of package com.bitstrips.imoji.ui.views:
//            Form, FormField

public static class form extends TextValidator
{

    private final Form form;

    public void validate(FormField formfield, String s)
    {
        formfield = field;
        boolean flag;
        if (s.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
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
