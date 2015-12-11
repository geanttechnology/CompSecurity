// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.apptentive.android.sdk.module.engagement.EngagementModule;
import com.apptentive.android.sdk.module.engagement.interaction.model.EnjoymentDialogInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.view.common.ApptentiveDialogButton;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.view:
//            InteractionView

public class EnjoymentDialogInteractionView extends InteractionView
{

    private static final String CODE_POINT_CANCEL = "cancel";
    private static final String CODE_POINT_NO = "no";
    private static final String CODE_POINT_YES = "yes";

    public EnjoymentDialogInteractionView(EnjoymentDialogInteraction enjoymentdialoginteraction)
    {
        super(enjoymentdialoginteraction);
    }

    public void doOnCreate(final Activity activity, Bundle bundle)
    {
        activity.setContentView(com.apptentive.android.sdk.R.layout.apptentive_enjoyment_dialog_interaction);
        ((TextView)activity.findViewById(com.apptentive.android.sdk.R.id.title)).setText(((EnjoymentDialogInteraction)interaction).getTitle(activity));
        bundle = ((EnjoymentDialogInteraction)interaction).getNoText();
        ApptentiveDialogButton apptentivedialogbutton = (ApptentiveDialogButton)activity.findViewById(com.apptentive.android.sdk.R.id.no);
        if (bundle != null)
        {
            apptentivedialogbutton.setText(bundle);
        }
        apptentivedialogbutton.setOnClickListener(new _cls1());
        bundle = ((EnjoymentDialogInteraction)interaction).getYesText();
        apptentivedialogbutton = (ApptentiveDialogButton)activity.findViewById(com.apptentive.android.sdk.R.id.yes);
        if (bundle != null)
        {
            apptentivedialogbutton.setText(bundle);
        }
        apptentivedialogbutton.setOnClickListener(new _cls2());
    }

    public boolean onBackPressed(Activity activity)
    {
        EngagementModule.engageInternal(activity, interaction, "cancel");
        return true;
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final EnjoymentDialogInteractionView this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            EngagementModule.engageInternal(activity, interaction, "no");
            activity.finish();
        }

        _cls1()
        {
            this$0 = EnjoymentDialogInteractionView.this;
            activity = activity1;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final EnjoymentDialogInteractionView this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            EngagementModule.engageInternal(activity, interaction, "yes");
            activity.finish();
        }

        _cls2()
        {
            this$0 = EnjoymentDialogInteractionView.this;
            activity = activity1;
            super();
        }
    }

}
