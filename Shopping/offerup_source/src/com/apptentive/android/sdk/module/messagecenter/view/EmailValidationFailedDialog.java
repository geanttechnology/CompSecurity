// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter.view;

import android.content.Context;
import android.os.Bundle;
import com.apptentive.android.sdk.module.engagement.interaction.view.common.ApptentiveDialogButton;
import com.apptentive.android.sdk.module.rating.view.ApptentiveBaseDialog;

public class EmailValidationFailedDialog extends ApptentiveBaseDialog
{

    public EmailValidationFailedDialog(Context context)
    {
        super(context, com.apptentive.android.sdk.R.layout.apptentive_message_center_email_validation);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((ApptentiveDialogButton)findViewById(com.apptentive.android.sdk.R.id.ok)).setOnClickListener(new _cls1());
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final EmailValidationFailedDialog this$0;

        public void onClick(View view)
        {
            dismiss();
        }

        _cls1()
        {
            this$0 = EmailValidationFailedDialog.this;
            super();
        }
    }

}
