// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.widget.Button;
import com.bitstrips.imoji.util.TextValidator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.bitstrips.imoji.ui.views:
//            FormField

public class Form
{
    public static class EmailValidator extends TextValidator
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

        public EmailValidator(FormField formfield, Form form1)
        {
            super(formfield);
            form = form1;
        }
    }

    public static class PasswordValidator extends TextValidator
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

        public PasswordValidator(FormField formfield, Form form1)
        {
            super(formfield);
            form = form1;
            context = form1.getContext();
        }
    }

    public static class RequiredFieldValidator extends TextValidator
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

        public RequiredFieldValidator(FormField formfield, Form form1)
        {
            super(formfield);
            form = form1;
        }
    }

    public static interface ValidationCallbacksActivity
    {

        public abstract void onInvalidData();

        public abstract void onValidData();
    }


    private MenuItem actionButton;
    private ValidationCallbacksActivity context;
    private List fields;
    private Button submitButton;

    public Form(Context context1)
    {
        fields = new ArrayList();
        context = (ValidationCallbacksActivity)context1;
    }

    private boolean allFieldsValid()
    {
        for (Iterator iterator = fields.iterator(); iterator.hasNext();)
        {
            if (!((FormField)iterator.next()).isValid())
            {
                return false;
            }
        }

        return true;
    }

    public void addField(FormField formfield, TextValidator textvalidator)
    {
        fields.add(formfield);
        formfield.addTextChangedListener(textvalidator);
    }

    public void checkValidity()
    {
        if (allFieldsValid())
        {
            context.onValidData();
            return;
        } else
        {
            context.onInvalidData();
            return;
        }
    }

    public Context getContext()
    {
        return (Context)context;
    }
}
