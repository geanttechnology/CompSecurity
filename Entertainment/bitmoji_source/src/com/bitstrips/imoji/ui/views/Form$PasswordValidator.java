// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import com.bitstrips.imoji.util.TextValidator;

// Referenced classes of package com.bitstrips.imoji.ui.views:
//            Form, FormField

public static class context extends TextValidator
{

    private final Context context;
    private final Form form;

    public void validate(FormField formfield, String s)
    {
        boolean flag = false;
        s = formfield.getText().toString();
        if (s.length() > 0 && s.length() < 6)
        {
            formfield.setError(context.getString(0x7f0600b5));
            formfield.setValid(false);
        } else
        {
            formfield.setError(null);
            if (s.length() >= 6)
            {
                flag = true;
            }
            formfield.setValid(flag);
        }
        form.checkValidity();
    }

    public _cls9(FormField formfield, Form form1)
    {
        super(formfield);
        form = form1;
        context = form1.getContext();
    }
}
