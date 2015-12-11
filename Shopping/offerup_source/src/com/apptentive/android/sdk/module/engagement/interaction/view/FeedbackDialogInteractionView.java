// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.model.AutomatedMessage;
import com.apptentive.android.sdk.model.Message;
import com.apptentive.android.sdk.model.Payload;
import com.apptentive.android.sdk.model.Person;
import com.apptentive.android.sdk.model.TextMessage;
import com.apptentive.android.sdk.module.engagement.EngagementModule;
import com.apptentive.android.sdk.module.engagement.interaction.model.FeedbackDialogInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.view.common.ApptentiveDialogButton;
import com.apptentive.android.sdk.module.messagecenter.MessageManager;
import com.apptentive.android.sdk.storage.ApptentiveDatabase;
import com.apptentive.android.sdk.storage.PersonManager;
import com.apptentive.android.sdk.util.Util;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.view:
//            InteractionView

public class FeedbackDialogInteractionView extends InteractionView
{

    private static final String CODE_POINT_CANCEL = "cancel";
    private static final String CODE_POINT_DECLINE = "decline";
    private static final String CODE_POINT_SKIP_VIEW_MESSAGES = "skip_view_messages";
    private static final String CODE_POINT_SUBMIT = "submit";
    private static final String CODE_POINT_VIEW_MESSAGES = "view_messages";
    private static final String THANK_YOU_DIALOG_VISIBLE = "thank_you_dialog_visible";
    private CharSequence email;
    private CharSequence message;
    private boolean thankYouDialogVisible;

    public FeedbackDialogInteractionView(FeedbackDialogInteraction feedbackdialoginteraction)
    {
        super(feedbackdialoginteraction);
        thankYouDialogVisible = false;
    }

    public static void createMessageCenterAutoMessage(Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("APPTENTIVE", 0);
        boolean flag = sharedpreferences.getBoolean("autoMessageShownAutoMessage", false);
        boolean flag1 = sharedpreferences.getBoolean("autoMessageShownManual", false);
        boolean flag2 = sharedpreferences.getBoolean("autoMessageShownNoLove", false);
        if (!flag && (flag1 || flag2))
        {
            sharedpreferences.edit().putBoolean("autoMessageShownAutoMessage", true).commit();
            flag = true;
        }
        AutomatedMessage automatedmessage = null;
        if (!flag)
        {
            sharedpreferences.edit().putBoolean("autoMessageShownAutoMessage", true).commit();
            automatedmessage = AutomatedMessage.createWelcomeMessage(context);
        }
        if (automatedmessage != null)
        {
            context = ApptentiveDatabase.getInstance(context);
            context.addOrUpdateMessages(new Message[] {
                automatedmessage
            });
            context.addPayload(new Payload[] {
                automatedmessage
            });
        }
    }

    private void sendMessage(Activity activity)
    {
        activity.getSharedPreferences("APPTENTIVE", 0).edit().putBoolean("messageCenterShouldShowIntroDialog", false).commit();
        if (((FeedbackDialogInteraction)interaction).isAskForEmail() && email != null && email.length() != 0)
        {
            PersonManager.storePersonEmail(activity, email.toString());
            Object obj = PersonManager.storePersonAndReturnDiff(activity);
            if (obj != null)
            {
                Log.d("Person was updated.", new Object[0]);
                Log.v(((Person) (obj)).toString(), new Object[0]);
                ApptentiveDatabase.getInstance(activity).addPayload(new Payload[] {
                    obj
                });
            } else
            {
                Log.d("Person was not updated.", new Object[0]);
            }
        }
        obj = new TextMessage();
        ((TextMessage) (obj)).setBody(message.toString());
        ((TextMessage) (obj)).setRead(true);
        MessageManager.sendMessage(activity, ((Message) (obj)));
    }

    private void validateForm(ApptentiveDialogButton apptentivedialogbutton)
    {
        boolean flag2 = true;
        boolean flag;
        boolean flag1;
        if (((FeedbackDialogInteraction)interaction).isEmailRequired() && !Util.isEmpty(PersonManager.loadInitialPersonEmail(apptentivedialogbutton.getContext())))
        {
            if (!Util.isEmpty(email))
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

    public void doOnCreate(final Activity activity, final Bundle sendButton)
    {
        activity.setContentView(com.apptentive.android.sdk.R.layout.apptentive_feedback_dialog_interaction);
        activity.getSharedPreferences("APPTENTIVE", 0).edit().putBoolean("messageCenterShouldShowIntroDialog", false).commit();
        if (sendButton != null)
        {
            thankYouDialogVisible = sendButton.getBoolean("thank_you_dialog_visible", false);
        }
        if (!thankYouDialogVisible)
        {
            final Object emailView = (AutoCompleteTextView)activity.findViewById(com.apptentive.android.sdk.R.id.email);
            Object obj1 = (EditText)activity.findViewById(com.apptentive.android.sdk.R.id.message);
            Object obj = (ApptentiveDialogButton)activity.findViewById(com.apptentive.android.sdk.R.id.decline);
            sendButton = (ApptentiveDialogButton)activity.findViewById(com.apptentive.android.sdk.R.id.submit);
            String s = ((FeedbackDialogInteraction)interaction).getTitle();
            if (s != null)
            {
                ((TextView)activity.findViewById(com.apptentive.android.sdk.R.id.title)).setText(s);
            }
            s = ((FeedbackDialogInteraction)interaction).getBody(activity);
            if (s != null)
            {
                ((TextView)activity.findViewById(com.apptentive.android.sdk.R.id.body)).setText(s);
            }
            s = PersonManager.loadPersonEmail(activity);
            if (!((FeedbackDialogInteraction)interaction).isAskForEmail())
            {
                ((AutoCompleteTextView) (emailView)).setVisibility(8);
            } else
            if (!Util.isEmpty(s))
            {
                ((AutoCompleteTextView) (emailView)).setVisibility(8);
                email = s;
            } else
            {
                String s1 = PersonManager.loadInitialPersonEmail(activity);
                if (!Util.isEmpty(s1))
                {
                    ((AutoCompleteTextView) (emailView)).setText(s1);
                    email = s1;
                }
                s1 = ((FeedbackDialogInteraction)interaction).getEmailHintText();
                if (s1 != null)
                {
                    ((AutoCompleteTextView) (emailView)).setHint(s1);
                } else
                if (((FeedbackDialogInteraction)interaction).isEmailRequired())
                {
                    ((AutoCompleteTextView) (emailView)).setHint(com.apptentive.android.sdk.R.string.apptentive_edittext_hint_email_required);
                }
                ((AutoCompleteTextView) (emailView)).setAdapter(new ArrayAdapter(activity, 0x109000a, Util.getAllUserAccountEmailAddresses(activity)));
                ((AutoCompleteTextView) (emailView)).setOnTouchListener(new _cls1());
                ((AutoCompleteTextView) (emailView)).addTextChangedListener(new _cls2());
            }
            emailView = ((FeedbackDialogInteraction)interaction).getMessageHintText();
            if (emailView != null)
            {
                ((EditText) (obj1)).setHint(((CharSequence) (emailView)));
            }
            ((EditText) (obj1)).addTextChangedListener(new _cls3());
            obj1 = ((FeedbackDialogInteraction)interaction).getDeclineText();
            if (obj1 != null)
            {
                ((ApptentiveDialogButton) (obj)).setText(((String) (obj1)));
            }
            ((ApptentiveDialogButton) (obj)).setOnClickListener(new _cls4());
            obj = ((FeedbackDialogInteraction)interaction).getSubmitText();
            if (obj != null)
            {
                sendButton.setText(((String) (obj)));
            }
            sendButton.setOnClickListener(new _cls5());
            validateForm(sendButton);
        } else
        {
            activity.findViewById(com.apptentive.android.sdk.R.id.feedback_dialog).setVisibility(8);
            activity.findViewById(com.apptentive.android.sdk.R.id.thank_you_dialog).setVisibility(0);
        }
        sendButton = (TextView)activity.findViewById(com.apptentive.android.sdk.R.id.thank_you_title);
        obj = ((FeedbackDialogInteraction)interaction).getThankYouTitle();
        if (obj != null)
        {
            sendButton.setText(((CharSequence) (obj)));
        }
        sendButton = (TextView)activity.findViewById(com.apptentive.android.sdk.R.id.thank_you_body);
        obj = ((FeedbackDialogInteraction)interaction).getThankYouBody();
        if (obj != null)
        {
            sendButton.setText(((CharSequence) (obj)));
        }
        sendButton = (ApptentiveDialogButton)activity.findViewById(com.apptentive.android.sdk.R.id.thank_you_close);
        obj = ((FeedbackDialogInteraction)interaction).getThankYouCloseText();
        if (obj != null)
        {
            sendButton.setText(((String) (obj)));
        }
        sendButton.setOnClickListener(new _cls6());
        sendButton = (ApptentiveDialogButton)activity.findViewById(com.apptentive.android.sdk.R.id.thank_you_view_messages);
        if (((FeedbackDialogInteraction)interaction).isMessageCenterEnabled())
        {
            obj = ((FeedbackDialogInteraction)interaction).getThankYouViewMessagesText();
            if (obj != null)
            {
                sendButton.setText(((String) (obj)));
            }
            sendButton.setOnClickListener(new _cls7());
            return;
        } else
        {
            sendButton.setVisibility(8);
            return;
        }
    }

    public boolean onBackPressed(Activity activity)
    {
        EngagementModule.engageInternal(activity, interaction, "cancel");
        return true;
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        thankYouDialogVisible = bundle.getBoolean("thank_you_dialog_visible", false);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("thank_you_dialog_visible", thankYouDialogVisible);
    }



/*
    static CharSequence access$002(FeedbackDialogInteractionView feedbackdialoginteractionview, CharSequence charsequence)
    {
        feedbackdialoginteractionview.email = charsequence;
        return charsequence;
    }

*/



/*
    static CharSequence access$202(FeedbackDialogInteractionView feedbackdialoginteractionview, CharSequence charsequence)
    {
        feedbackdialoginteractionview.message = charsequence;
        return charsequence;
    }

*/



/*
    static boolean access$402(FeedbackDialogInteractionView feedbackdialoginteractionview, boolean flag)
    {
        feedbackdialoginteractionview.thankYouDialogVisible = flag;
        return flag;
    }

*/

    private class _cls3
        implements TextWatcher
    {

        final FeedbackDialogInteractionView this$0;
        final ApptentiveDialogButton val$sendButton;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            message = charsequence;
            validateForm(sendButton);
        }

        _cls3()
        {
            this$0 = FeedbackDialogInteractionView.this;
            sendButton = apptentivedialogbutton;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final FeedbackDialogInteractionView this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            EngagementModule.engageInternal(activity, interaction, "decline");
            activity.finish();
        }

        _cls4()
        {
            this$0 = FeedbackDialogInteractionView.this;
            activity = activity1;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final FeedbackDialogInteractionView this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            Util.hideSoftKeyboard(activity, view);
            if (email != null && email.length() != 0 && !Util.isEmailValid(email.toString()))
            {
                (new EmailValidationFailedDialog(activity)).show();
                return;
            } else
            {
                FeedbackDialogInteractionView.createMessageCenterAutoMessage(activity);
                sendMessage(activity);
                EngagementModule.engageInternal(activity, interaction, "submit");
                thankYouDialogVisible = true;
                activity.findViewById(com.apptentive.android.sdk.R.id.feedback_dialog).setVisibility(8);
                activity.findViewById(com.apptentive.android.sdk.R.id.thank_you_dialog).setVisibility(0);
                return;
            }
        }

        _cls5()
        {
            this$0 = FeedbackDialogInteractionView.this;
            activity = activity1;
            super();
        }
    }


    private class _cls6
        implements android.view.View.OnClickListener
    {

        final FeedbackDialogInteractionView this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            EngagementModule.engageInternal(activity, interaction, "skip_view_messages");
            activity.finish();
        }

        _cls6()
        {
            this$0 = FeedbackDialogInteractionView.this;
            activity = activity1;
            super();
        }
    }


    private class _cls7
        implements android.view.View.OnClickListener
    {

        final FeedbackDialogInteractionView this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            EngagementModule.engageInternal(activity, interaction, "view_messages");
            activity.finish();
        }

        _cls7()
        {
            this$0 = FeedbackDialogInteractionView.this;
            activity = activity1;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnTouchListener
    {

        final FeedbackDialogInteractionView this$0;
        final AutoCompleteTextView val$emailView;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            emailView.showDropDown();
            return false;
        }

        _cls1()
        {
            this$0 = FeedbackDialogInteractionView.this;
            emailView = autocompletetextview;
            super();
        }
    }


    private class _cls2
        implements TextWatcher
    {

        final FeedbackDialogInteractionView this$0;
        final ApptentiveDialogButton val$sendButton;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            email = charsequence;
            validateForm(sendButton);
        }

        _cls2()
        {
            this$0 = FeedbackDialogInteractionView.this;
            sendButton = apptentivedialogbutton;
            super();
        }
    }

}
