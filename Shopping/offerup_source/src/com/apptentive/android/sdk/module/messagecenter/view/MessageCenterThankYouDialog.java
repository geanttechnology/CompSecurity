// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.apptentive.android.sdk.model.Configuration;
import com.apptentive.android.sdk.module.engagement.interaction.view.common.ApptentiveDialogButton;
import com.apptentive.android.sdk.module.rating.view.ApptentiveBaseDialog;

public class MessageCenterThankYouDialog extends ApptentiveBaseDialog
{

    private OnChoiceMadeListener onChoiceMadeListener;
    private boolean validEmailProvided;

    public MessageCenterThankYouDialog(Context context)
    {
        super(context, com.apptentive.android.sdk.R.layout.apptentive_message_center_thank_you_dialog);
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag = Configuration.load(getContext()).isMessageCenterEnabled(getContext());
        bundle = (TextView)findViewById(com.apptentive.android.sdk.R.id.thank_you_body);
        ApptentiveDialogButton apptentivedialogbutton = (ApptentiveDialogButton)findViewById(com.apptentive.android.sdk.R.id.close);
        ApptentiveDialogButton apptentivedialogbutton1 = (ApptentiveDialogButton)findViewById(com.apptentive.android.sdk.R.id.view_messages);
        if (!flag)
        {
            if (validEmailProvided)
            {
                bundle.setText(getContext().getResources().getText(com.apptentive.android.sdk.R.string.apptentive_thank_you_dialog_body_message_center_disabled_email_required));
            } else
            {
                bundle.setText(getContext().getResources().getText(com.apptentive.android.sdk.R.string.apptentive_thank_you_dialog_body_message_center_disabled));
            }
        }
        apptentivedialogbutton.setOnClickListener(new _cls1());
        if (!flag)
        {
            apptentivedialogbutton1.setVisibility(8);
            return;
        } else
        {
            apptentivedialogbutton1.setOnClickListener(new _cls2());
            return;
        }
    }

    public void setOnChoiceMadeListener(OnChoiceMadeListener onchoicemadelistener)
    {
        onChoiceMadeListener = onchoicemadelistener;
    }

    public void setValidEmailProvided(boolean flag)
    {
        validEmailProvided = flag;
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final MessageCenterThankYouDialog this$0;

        public void onClick(View view)
        {
            cancel();
            if (onChoiceMadeListener != null)
            {
                onChoiceMadeListener.onNo();
            }
        }

        _cls1()
        {
            this$0 = MessageCenterThankYouDialog.this;
            super();
        }

        private class OnChoiceMadeListener
        {

            public abstract void onNo();

            public abstract void onYes();
        }

    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final MessageCenterThankYouDialog this$0;

        public void onClick(View view)
        {
            dismiss();
            if (onChoiceMadeListener != null)
            {
                onChoiceMadeListener.onYes();
            }
        }

        _cls2()
        {
            this$0 = MessageCenterThankYouDialog.this;
            super();
        }
    }

}
