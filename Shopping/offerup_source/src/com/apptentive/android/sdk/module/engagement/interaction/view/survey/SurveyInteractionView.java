// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view.survey;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.apptentive.android.sdk.ApptentiveInternal;
import com.apptentive.android.sdk.model.Configuration;
import com.apptentive.android.sdk.module.engagement.EngagementModule;
import com.apptentive.android.sdk.module.engagement.interaction.model.Interaction;
import com.apptentive.android.sdk.module.engagement.interaction.model.SurveyInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.model.survey.MultichoiceQuestion;
import com.apptentive.android.sdk.module.engagement.interaction.model.survey.MultiselectQuestion;
import com.apptentive.android.sdk.module.engagement.interaction.model.survey.Question;
import com.apptentive.android.sdk.module.engagement.interaction.model.survey.SinglelineQuestion;
import com.apptentive.android.sdk.module.engagement.interaction.model.survey.SurveyState;
import com.apptentive.android.sdk.module.engagement.interaction.view.InteractionView;
import com.apptentive.android.sdk.module.survey.OnSurveyFinishedListener;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.view.survey:
//            TextSurveyQuestionView, MultichoiceSurveyQuestionView, MultiselectSurveyQuestionView

public class SurveyInteractionView extends InteractionView
{

    private static final String EVENT_CANCEL = "cancel";
    private static final String EVENT_QUESTION_RESPONSE = "question_response";
    private static final String EVENT_SUBMIT = "submit";
    private static final String KEY_SURVEY_SUBMITTED = "survey_submitted";
    private static SurveyState surveyState;
    private boolean surveySubmitted;

    public SurveyInteractionView(SurveyInteraction surveyinteraction)
    {
        super(surveyinteraction);
        surveySubmitted = false;
        if (surveyState == null)
        {
            surveyState = new SurveyState(surveyinteraction);
        }
    }

    private void callListener(boolean flag)
    {
        OnSurveyFinishedListener onsurveyfinishedlistener = ApptentiveInternal.getOnSurveyFinishedListener();
        if (onsurveyfinishedlistener != null)
        {
            onsurveyfinishedlistener.onSurveyFinished(flag);
        }
    }

    private void cleanup()
    {
        surveyState = null;
    }

    public void doOnCreate(final Activity activity, Bundle bundle)
    {
        if (bundle != null)
        {
            surveySubmitted = bundle.getBoolean("survey_submitted", false);
        }
        if (interaction == null || surveySubmitted)
        {
            activity.finish();
            return;
        }
        activity.setContentView(com.apptentive.android.sdk.R.layout.apptentive_survey);
        bundle = activity.findViewById(com.apptentive.android.sdk.R.id.apptentive_branding_view);
        if (bundle != null && Configuration.load(activity).isHideBranding(activity))
        {
            bundle.setVisibility(8);
        }
        bundle = (TextView)activity.findViewById(com.apptentive.android.sdk.R.id.title);
        bundle.setFocusable(true);
        bundle.setFocusableInTouchMode(true);
        bundle.setText(((SurveyInteraction)interaction).getName());
        final Button send = ((SurveyInteraction)interaction).getDescription();
        if (send != null)
        {
            TextView textview = (TextView)activity.findViewById(com.apptentive.android.sdk.R.id.description);
            textview.setText(send);
            textview.setVisibility(0);
        }
        send = (Button)activity.findViewById(com.apptentive.android.sdk.R.id.send);
        send.setOnClickListener(new _cls1());
        LinearLayout linearlayout = (LinearLayout)activity.findViewById(com.apptentive.android.sdk.R.id.questions);
        linearlayout.removeAllViews();
        Iterator iterator = ((SurveyInteraction)interaction).getQuestions().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            final Question question = (Question)iterator.next();
            if (question.getType() == 1)
            {
                TextSurveyQuestionView textsurveyquestionview = new TextSurveyQuestionView(activity, surveyState, (SinglelineQuestion)question);
                textsurveyquestionview.setOnSurveyQuestionAnsweredListener(new _cls2());
                linearlayout.addView(textsurveyquestionview);
            } else
            if (question.getType() == 2)
            {
                MultichoiceSurveyQuestionView multichoicesurveyquestionview = new MultichoiceSurveyQuestionView(activity, surveyState, (MultichoiceQuestion)question);
                multichoicesurveyquestionview.setOnSurveyQuestionAnsweredListener(new _cls3());
                linearlayout.addView(multichoicesurveyquestionview);
            } else
            if (question.getType() == 3)
            {
                MultiselectSurveyQuestionView multiselectsurveyquestionview = new MultiselectSurveyQuestionView(activity, surveyState, (MultiselectQuestion)question);
                multiselectsurveyquestionview.setOnSurveyQuestionAnsweredListener(new _cls4());
                linearlayout.addView(multiselectsurveyquestionview);
            }
        } while (true);
        send.setEnabled(isSurveyValid());
        bundle.requestFocus();
    }

    public boolean isSurveyValid()
    {
        for (Iterator iterator = ((SurveyInteraction)interaction).getQuestions().iterator(); iterator.hasNext();)
        {
            Question question = (Question)iterator.next();
            if (!surveyState.isQuestionValid(question))
            {
                return false;
            }
        }

        return true;
    }

    public boolean onBackPressed(Activity activity)
    {
        if (!((SurveyInteraction)interaction).isRequired())
        {
            EngagementModule.engageInternal(activity, interaction, "cancel");
            callListener(false);
            cleanup();
            return true;
        } else
        {
            return false;
        }
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        surveySubmitted = bundle.getBoolean("survey_submitted", false);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("survey_submitted", surveySubmitted);
    }

    void sendMetricForQuestion(Activity activity, Question question)
    {
        String s = question.getId();
        if (!surveyState.isMetricSent(s) && surveyState.isQuestionValid(question))
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("id", question.getId());
            }
            // Misplaced declaration of an exception variable
            catch (Question question) { }
            EngagementModule.engageInternal(activity, interaction, "question_response", jsonobject.toString());
            surveyState.markMetricSent(s);
        }
    }


/*
    static boolean access$002(SurveyInteractionView surveyinteractionview, boolean flag)
    {
        surveyinteractionview.surveySubmitted = flag;
        return flag;
    }

*/









    private class _cls1
        implements android.view.View.OnClickListener
    {

        final SurveyInteractionView this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            Util.hideSoftKeyboard(activity, view);
            surveySubmitted = true;
            if (((SurveyInteraction)isShowSuccessMessage).isShowSuccessMessage() && ((SurveyInteraction)isShowSuccessMessage).getSuccessMessage() != null)
            {
                view = new SurveyThankYouDialog(activity);
                view.setMessage(((SurveyInteraction)isShowSuccessMessage).getSuccessMessage());
                class _cls1
                    implements android.content.DialogInterface.OnDismissListener
                {

                    final _cls1 this$1;

                    public void onDismiss(DialogInterface dialoginterface)
                    {
                        activity.finish();
                    }

                _cls1()
                {
                    this$1 = _cls1.this;
                    super();
                }
                }

                view.setOnDismissListener(new _cls1());
                view.show();
            } else
            {
                activity.finish();
            }
            EngagementModule.engageInternal(activity, isShowSuccessMessage, "submit");
            ApptentiveDatabase.getInstance(activity).addPayload(new Payload[] {
                new SurveyResponse((SurveyInteraction)isShowSuccessMessage, SurveyInteractionView.surveyState)
            });
            Log.d("Survey Submitted.", new Object[0]);
            callListener(true);
            cleanup();
        }

        _cls1()
        {
            this$0 = SurveyInteractionView.this;
            activity = activity1;
            super();
        }
    }


    private class _cls2
        implements OnSurveyQuestionAnsweredListener
    {

        final SurveyInteractionView this$0;
        final Activity val$activity;
        final Question val$question;
        final Button val$send;

        public void onAnswered()
        {
            sendMetricForQuestion(activity, question);
            send.setEnabled(isSurveyValid());
        }

        _cls2()
        {
            this$0 = SurveyInteractionView.this;
            activity = activity1;
            question = question1;
            send = button;
            super();
        }
    }


    private class _cls3
        implements OnSurveyQuestionAnsweredListener
    {

        final SurveyInteractionView this$0;
        final Activity val$activity;
        final Question val$question;
        final Button val$send;

        public void onAnswered()
        {
            sendMetricForQuestion(activity, question);
            send.setEnabled(isSurveyValid());
        }

        _cls3()
        {
            this$0 = SurveyInteractionView.this;
            activity = activity1;
            question = question1;
            send = button;
            super();
        }
    }


    private class _cls4
        implements OnSurveyQuestionAnsweredListener
    {

        final SurveyInteractionView this$0;
        final Activity val$activity;
        final Question val$question;
        final Button val$send;

        public void onAnswered()
        {
            sendMetricForQuestion(activity, question);
            send.setEnabled(isSurveyValid());
        }

        _cls4()
        {
            this$0 = SurveyInteractionView.this;
            activity = activity1;
            question = question1;
            send = button;
            super();
        }
    }

}
