// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.apptentive.android.sdk.module.engagement.interaction.view.common.ApptentiveDialogButton;
import com.apptentive.android.sdk.module.rating.view.ApptentiveBaseDialog;
import com.apptentive.android.sdk.storage.PersonManager;
import com.apptentive.android.sdk.util.Util;

public class MessageCenterIntroDialog extends ApptentiveBaseDialog
{

    private CharSequence email;
    private boolean emailRequired;
    private CharSequence message;
    private OnSendListener onSendListener;

    public MessageCenterIntroDialog(Context context)
    {
        super(context, com.apptentive.android.sdk.R.layout.apptentive_message_center_intro_dialog);
        emailRequired = false;
    }

    private void validateForm(ApptentiveDialogButton apptentivedialogbutton)
    {
        boolean flag2 = true;
        boolean flag;
        boolean flag1;
        if (emailRequired)
        {
            if (!Util.isEmpty(email) || !Util.isEmpty(PersonManager.loadPersonEmail(getContext())))
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = true;
        }
        if (!Util.isEmpty(message))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag || !flag1)
        {
            flag2 = false;
        }
        apptentivedialogbutton.setEnabled(flag2);
    }

    public boolean isEmailFieldVisible()
    {
        return ((EditText)findViewById(com.apptentive.android.sdk.R.id.email)).getVisibility() == 0;
    }

    protected void onCreate(final Bundle emailText)
    {
        super.onCreate(emailText);
        emailText = (AutoCompleteTextView)findViewById(com.apptentive.android.sdk.R.id.email);
        final EditText messageText = (EditText)findViewById(com.apptentive.android.sdk.R.id.message);
        ApptentiveDialogButton apptentivedialogbutton = (ApptentiveDialogButton)findViewById(com.apptentive.android.sdk.R.id.decline);
        final ApptentiveDialogButton submitButton = (ApptentiveDialogButton)findViewById(com.apptentive.android.sdk.R.id.submit);
        emailText.setAdapter(new ArrayAdapter(getContext(), 0x109000a, Util.getAllUserAccountEmailAddresses(getContext())));
        emailText.setOnTouchListener(new _cls1());
        emailText.addTextChangedListener(new _cls2());
        messageText.addTextChangedListener(new _cls3());
        apptentivedialogbutton.setEnabled(true);
        apptentivedialogbutton.setOnClickListener(new _cls4());
        submitButton.setEnabled(false);
        submitButton.setOnClickListener(new _cls5());
        validateForm(submitButton);
    }

    public void prePopulateEmail(String s)
    {
        ((EditText)findViewById(com.apptentive.android.sdk.R.id.email)).setText(s);
        email = s;
    }

    public void setBody(int i)
    {
        setBody(((CharSequence) (getContext().getResources().getString(i))));
    }

    public void setBody(CharSequence charsequence)
    {
        ((TextView)findViewById(com.apptentive.android.sdk.R.id.body)).setText(charsequence);
    }

    public void setEmailFieldHidden(boolean flag)
    {
        EditText edittext = (EditText)findViewById(com.apptentive.android.sdk.R.id.email);
        if (flag)
        {
            edittext.setVisibility(8);
            return;
        } else
        {
            edittext.setVisibility(0);
            return;
        }
    }

    public void setEmailRequired(boolean flag)
    {
        emailRequired = flag;
        AutoCompleteTextView autocompletetextview = (AutoCompleteTextView)findViewById(com.apptentive.android.sdk.R.id.email);
        if (flag)
        {
            autocompletetextview.setHint(com.apptentive.android.sdk.R.string.apptentive_edittext_hint_email_required);
            return;
        } else
        {
            autocompletetextview.setHint(com.apptentive.android.sdk.R.string.apptentive_edittext_hint_email);
            return;
        }
    }

    public void setOnSendListener(OnSendListener onsendlistener)
    {
        onSendListener = onsendlistener;
    }

    public void setTitle(int i)
    {
        setTitle(((CharSequence) (getContext().getResources().getString(i))));
    }

    public void setTitle(CharSequence charsequence)
    {
        ((TextView)findViewById(com.apptentive.android.sdk.R.id.title)).setText(charsequence);
    }



/*
    static CharSequence access$002(MessageCenterIntroDialog messagecenterintrodialog, CharSequence charsequence)
    {
        messagecenterintrodialog.email = charsequence;
        return charsequence;
    }

*/



/*
    static CharSequence access$202(MessageCenterIntroDialog messagecenterintrodialog, CharSequence charsequence)
    {
        messagecenterintrodialog.message = charsequence;
        return charsequence;
    }

*/


    private class _cls1
        implements android.view.View.OnTouchListener
    {

        final MessageCenterIntroDialog this$0;
        final AutoCompleteTextView val$emailText;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            emailText.showDropDown();
            return false;
        }

        _cls1()
        {
            this$0 = MessageCenterIntroDialog.this;
            emailText = autocompletetextview;
            super();
        }
    }


    private class _cls2
        implements TextWatcher
    {

        final MessageCenterIntroDialog this$0;
        final ApptentiveDialogButton val$submitButton;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            email = charsequence;
            validateForm(submitButton);
        }

        _cls2()
        {
            this$0 = MessageCenterIntroDialog.this;
            submitButton = apptentivedialogbutton;
            super();
        }
    }


    private class _cls3
        implements TextWatcher
    {

        final MessageCenterIntroDialog this$0;
        final ApptentiveDialogButton val$submitButton;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            message = charsequence;
            validateForm(submitButton);
        }

        _cls3()
        {
            this$0 = MessageCenterIntroDialog.this;
            submitButton = apptentivedialogbutton;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final MessageCenterIntroDialog this$0;

        public void onClick(View view)
        {
            cancel();
        }

        _cls4()
        {
            this$0 = MessageCenterIntroDialog.this;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final MessageCenterIntroDialog this$0;
        final AutoCompleteTextView val$emailText;
        final EditText val$messageText;

        public void onClick(View view)
        {
            if (email != null && email.length() != 0 && !Util.isEmailValid(email.toString()))
            {
                (new EmailValidationFailedDialog(getContext())).show();
            } else
            if (onSendListener != null)
            {
                onSendListener.onSend(emailText.getText().toString(), messageText.getText().toString());
                return;
            }
        }

        _cls5()
        {
            this$0 = MessageCenterIntroDialog.this;
            emailText = autocompletetextview;
            messageText = edittext;
            super();
        }

        private class OnSendListener
        {

            public abstract void onSend(String s, String s1);
        }

    }

}
