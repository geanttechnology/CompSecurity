// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.boldchat.visitor.api.Chat;
import com.boldchat.visitor.api.Form;
import com.boldchat.visitor.api.FormField;
import com.boldchat.visitor.api.FormFieldOption;
import com.boldchat.visitor.api.FormFieldType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatFormView, BoldChatSession

private class <init>
    implements android.view.ner
{

    final BoldChatFormView this$0;

    public void onClick(View view)
    {
        boolean flag1 = true;
        boolean flag = true;
        int i = ((flag1) ? 1 : 0);
        if (BoldChatFormView.access$100(BoldChatFormView.this) != null)
        {
            i = ((flag1) ? 1 : 0);
            if (BoldChatFormView.access$100(BoldChatFormView.this).getFormFields() != null)
            {
                view = BoldChatFormView.access$100(BoldChatFormView.this).getFormFields().iterator();
                do
                {
                    i = ((flag) ? 1 : 0);
                    if (!view.hasNext())
                    {
                        break;
                    }
                    FormField formfield = (FormField)view.next();
                    Object obj = (View)BoldChatFormView.access$200(BoldChatFormView.this).get(formfield);
                    if (obj != null)
                    {
                        if (obj instanceof EditText)
                        {
                            formfield.setValue(((EditText)obj).getText().toString().trim());
                            if (formfield.getType() == FormFieldType.Email && !TextUtils.isEmpty(formfield.getValue()))
                            {
                                i = formfield.getValue().indexOf('@');
                                if (i <= 0 || i >= formfield.getValue().length() - 1 || !AIL_ADDRESS.matcher(formfield.getValue()).matches())
                                {
                                    ((EditText)obj).setError(BoldChatSession.getBranding("api#email#error", BoldChatFormView.access$300(BoldChatFormView.this).getBrandings(), ((View) (obj)).getContext()));
                                    if (flag)
                                    {
                                        ((View) (obj)).requestFocus();
                                        smoothScrollToCenter(((View) (obj)));
                                    }
                                    flag = false;
                                }
                            } else
                            if (formfield.isRequired() && TextUtils.isEmpty(formfield.getValue()))
                            {
                                ((EditText)obj).setError(BoldChatSession.getBranding("api#chat#required_error", BoldChatFormView.access$300(BoldChatFormView.this).getBrandings(), ((View) (obj)).getContext()));
                                if (flag)
                                {
                                    ((View) (obj)).requestFocus();
                                    smoothScrollToCenter(((View) (obj)));
                                }
                                flag = false;
                            } else
                            {
                                ((EditText)obj).setError(null);
                            }
                        } else
                        if (obj instanceof Spinner)
                        {
                            obj = (Spinner)obj;
                            FormFieldOption formfieldoption = (FormFieldOption)((Spinner) (obj)).getSelectedItem();
                            <init> <init>1 = (this._cls0)((Spinner) (obj)).getAdapter();
                            if (formfieldoption != null)
                            {
                                formfield.setValue(formfieldoption.getValue());
                                if (formfield.isRequired())
                                {
                                    <init>1.rState(false);
                                }
                            } else
                            if (formfield.isRequired())
                            {
                                <init>1.rState(true);
                                <init>1.ataSetChanged();
                                if (flag)
                                {
                                    ((Spinner) (obj)).requestFocus();
                                    smoothScrollToCenter(((View) (obj)));
                                    flag = false;
                                }
                            }
                        } else
                        if (obj instanceof RatingBar)
                        {
                            obj = (RatingBar)obj;
                            i = Math.round(((RatingBar) (obj)).getRating());
                            if (i > 0)
                            {
                                formfield.setValue(Integer.toString(i));
                            } else
                            if (formfield.isRequired())
                            {
                                TextView textview = (TextView)BoldChatFormView.access$400(BoldChatFormView.this).get(obj);
                                if (textview != null)
                                {
                                    textview.setTextColor(getResources().getColor(this._fld0));
                                }
                                if (flag)
                                {
                                    smoothScrollToCenter(((View) (obj)));
                                    flag = false;
                                }
                            }
                        }
                    }
                } while (true);
            }
        }
        if (i != 0)
        {
            ((InputMethodManager)BoldChatFormView.access$500(BoldChatFormView.this).getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
            BoldChatFormView.access$600(BoldChatFormView.this).Submit(BoldChatFormView.access$100(BoldChatFormView.this));
        }
    }

    private ()
    {
        this$0 = BoldChatFormView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
