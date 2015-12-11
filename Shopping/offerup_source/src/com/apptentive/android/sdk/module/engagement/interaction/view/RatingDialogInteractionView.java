// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.apptentive.android.sdk.module.engagement.EngagementModule;
import com.apptentive.android.sdk.module.engagement.interaction.model.RatingDialogInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.view.common.ApptentiveDialogButton;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.view:
//            InteractionView

public class RatingDialogInteractionView extends InteractionView
{

    private static final String CODE_POINT_CANCEL = "cancel";
    private static final String CODE_POINT_DECLINE = "decline";
    private static final String CODE_POINT_RATE = "rate";
    private static final String CODE_POINT_REMIND = "remind";

    public RatingDialogInteractionView(RatingDialogInteraction ratingdialoginteraction)
    {
        super(ratingdialoginteraction);
    }

    public void doOnCreate(final Activity activity, Bundle bundle)
    {
        activity.setContentView(com.apptentive.android.sdk.R.layout.apptentive_rating_dialog_interaction);
        bundle = ((RatingDialogInteraction)interaction).getTitle();
        if (bundle != null)
        {
            ((TextView)activity.findViewById(com.apptentive.android.sdk.R.id.title)).setText(bundle);
        }
        ((TextView)activity.findViewById(com.apptentive.android.sdk.R.id.body)).setText(((RatingDialogInteraction)interaction).getBody(activity));
        bundle = (ApptentiveDialogButton)activity.findViewById(com.apptentive.android.sdk.R.id.rate);
        bundle.setText(((RatingDialogInteraction)interaction).getRateText(activity));
        bundle.setOnClickListener(new _cls1());
        bundle = (ApptentiveDialogButton)activity.findViewById(com.apptentive.android.sdk.R.id.remind);
        String s = ((RatingDialogInteraction)interaction).getRemindText();
        if (s != null)
        {
            bundle.setText(s);
        }
        bundle.setOnClickListener(new _cls2());
        bundle = (ApptentiveDialogButton)activity.findViewById(com.apptentive.android.sdk.R.id.decline);
        s = ((RatingDialogInteraction)interaction).getDeclineText();
        if (s != null)
        {
            bundle.setText(s);
        }
        bundle.setOnClickListener(new _cls3());
    }

    public boolean onBackPressed(Activity activity)
    {
        EngagementModule.engageInternal(activity, interaction, "cancel");
        return true;
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final RatingDialogInteractionView this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            EngagementModule.engageInternal(activity, interaction, "rate");
            activity.finish();
        }

        _cls1()
        {
            this$0 = RatingDialogInteractionView.this;
            activity = activity1;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final RatingDialogInteractionView this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            EngagementModule.engageInternal(activity, interaction, "remind");
            activity.finish();
        }

        _cls2()
        {
            this$0 = RatingDialogInteractionView.this;
            activity = activity1;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final RatingDialogInteractionView this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            EngagementModule.engageInternal(activity, interaction, "decline");
            activity.finish();
        }

        _cls3()
        {
            this$0 = RatingDialogInteractionView.this;
            activity = activity1;
            super();
        }
    }

}
