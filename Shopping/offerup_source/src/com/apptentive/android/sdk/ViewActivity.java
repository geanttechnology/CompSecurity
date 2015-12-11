// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.apptentive.android.sdk.module.ActivityContent;
import com.apptentive.android.sdk.module.engagement.interaction.model.AppStoreRatingInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.model.EnjoymentDialogInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.model.FeedbackDialogInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.model.Interaction;
import com.apptentive.android.sdk.module.engagement.interaction.model.NavigateToLinkInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.model.RatingDialogInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.model.SurveyInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.model.TextModalInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.model.UpgradeMessageInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.view.AppStoreRatingInteractionView;
import com.apptentive.android.sdk.module.engagement.interaction.view.EnjoymentDialogInteractionView;
import com.apptentive.android.sdk.module.engagement.interaction.view.FeedbackDialogInteractionView;
import com.apptentive.android.sdk.module.engagement.interaction.view.NavigateToLinkInteractionView;
import com.apptentive.android.sdk.module.engagement.interaction.view.RatingDialogInteractionView;
import com.apptentive.android.sdk.module.engagement.interaction.view.TextModalInteractionView;
import com.apptentive.android.sdk.module.engagement.interaction.view.UpgradeMessageInteractionView;
import com.apptentive.android.sdk.module.engagement.interaction.view.survey.SurveyInteractionView;
import com.apptentive.android.sdk.module.messagecenter.ApptentiveMessageCenter;
import com.apptentive.android.sdk.module.messagecenter.view.MessageCenterView;
import com.apptentive.android.sdk.module.metric.MetricModule;

// Referenced classes of package com.apptentive.android.sdk:
//            ApptentiveActivity, AboutModule, Log, Apptentive

public class ViewActivity extends ApptentiveActivity
{

    private com.apptentive.android.sdk.module.ActivityContent.Type activeContentType;
    private ActivityContent activityContent;

    public ViewActivity()
    {
    }

    public void finish()
    {
        super.finish();
        overridePendingTransition(0, R.anim.slide_down_out);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j != -1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1000 1000: default 32
    //                   1000 33;
           goto _L2 _L3
_L2:
        return;
_L3:
        MessageCenterView.showAttachmentDialog(this, intent.getData());
        return;
    }

    public void onBackPressed()
    {
        boolean flag = true;
        _cls1..SwitchMap.com.apptentive.android.sdk.module.ActivityContent.Type[activeContentType.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 53
    //                   2 64
    //                   3 72;
           goto _L1 _L2 _L3 _L4
_L1:
        if (flag)
        {
            finish();
            super.onBackPressed();
        }
        return;
_L2:
        flag = AboutModule.getInstance().onBackPressed(this);
        continue; /* Loop/switch isn't completed */
_L3:
        flag = ApptentiveMessageCenter.onBackPressed(this);
        continue; /* Loop/switch isn't completed */
_L4:
        if (activityContent != null)
        {
            flag = activityContent.onBackPressed(this);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Object obj;
        requestWindowFeature(1);
        obj = getIntent().getStringExtra("activityContent");
        if (obj == null) goto _L2; else goto _L1
_L1:
        Log.v("Started ViewActivity normally for %s.", new Object[] {
            activityContent
        });
        activeContentType = com.apptentive.android.sdk.module.ActivityContent.Type.parse(((String) (obj)));
        _cls1..SwitchMap.com.apptentive.android.sdk.module.ActivityContent.Type[activeContentType.ordinal()];
        JVM INSTR tableswitch 1 3: default 445
    //                   1 101
    //                   2 101
    //                   3 130;
           goto _L3 _L4 _L4 _L5
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        Log.w("No Activity specified. Finishing...", new Object[0]);
        finish();
_L2:
        if (activeContentType == null)
        {
            finish();
        }
        bundle = getWindow();
        bundle.setFormat(1);
        bundle.addFlags(4096);
        return;
_L5:
        obj = com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Factory.parseInteraction(getIntent().getExtras().getCharSequence("interaction").toString());
        if (obj == null) goto _L7; else goto _L6
_L6:
        _cls1..SwitchMap.com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type[((Interaction) (obj)).getType().ordinal()];
        JVM INSTR tableswitch 1 9: default 448
    //                   1 272
    //                   2 290
    //                   3 308
    //                   4 326
    //                   5 344
    //                   6 362
    //                   7 380
    //                   8 397
    //                   9 415;
           goto _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L8:
        break; /* Loop/switch isn't completed */
_L17:
        break MISSING_BLOCK_LABEL_415;
_L7:
        if (activityContent != null)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        finish();
          goto _L2
_L9:
        activityContent = new UpgradeMessageInteractionView((UpgradeMessageInteraction)obj);
          goto _L7
_L10:
        activityContent = new EnjoymentDialogInteractionView((EnjoymentDialogInteraction)obj);
          goto _L7
_L11:
        activityContent = new RatingDialogInteractionView((RatingDialogInteraction)obj);
          goto _L7
_L12:
        activityContent = new AppStoreRatingInteractionView((AppStoreRatingInteraction)obj);
          goto _L7
_L13:
        activityContent = new FeedbackDialogInteractionView((FeedbackDialogInteraction)obj);
          goto _L7
_L14:
        activityContent = new SurveyInteractionView((SurveyInteraction)obj);
          goto _L7
_L15:
        try
        {
            getWindow().setSoftInputMode(2);
            finish();
            Apptentive.showMessageCenter(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            try
            {
                Log.e("Error starting ViewActivity.", bundle, new Object[0]);
                MetricModule.sendError(this, bundle, null, null);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Log.e("Error creating ViewActivity.", bundle, new Object[0]);
                MetricModule.sendError(this, bundle, null, null);
            }
        }
          goto _L2
_L16:
        activityContent = new TextModalInteractionView((TextModalInteraction)obj);
          goto _L7
        activityContent = new NavigateToLinkInteractionView((NavigateToLinkInteraction)obj);
          goto _L7
        activityContent.onCreate(this, bundle);
          goto _L2
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (activityContent != null)
        {
            activityContent.onRestoreInstanceState(bundle);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (activityContent != null)
        {
            activityContent.onSaveInstanceState(bundle);
        }
    }

    protected void onStart()
    {
        super.onStart();
        switch (_cls1..SwitchMap.com.apptentive.android.sdk.module.ActivityContent.Type[activeContentType.ordinal()])
        {
        default:
            Log.w("No Activity specified. Finishing...", new Object[0]);
            finish();
            // fall through

        case 3: // '\003'
            return;

        case 1: // '\001'
            AboutModule.getInstance().doShow(this);
            return;

        case 2: // '\002'
            getWindow().setSoftInputMode(1);
            break;
        }
        ApptentiveMessageCenter.doShow(this);
    }

    protected void onStop()
    {
        super.onStop();
        switch (_cls1..SwitchMap.com.apptentive.android.sdk.module.ActivityContent.Type[activeContentType.ordinal()])
        {
        case 1: // '\001'
        default:
            return;

        case 2: // '\002'
            ApptentiveMessageCenter.onStop(this);
            break;
        }
    }

    public void showAboutActivity(View view)
    {
        AboutModule.getInstance().show(this);
    }

    private class _cls1
    {

        static final int $SwitchMap$com$apptentive$android$sdk$module$ActivityContent$Type[];
        static final int $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type[];

        static 
        {
            $SwitchMap$com$apptentive$android$sdk$module$ActivityContent$Type = new int[com.apptentive.android.sdk.module.ActivityContent.Type.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$ActivityContent$Type[com.apptentive.android.sdk.module.ActivityContent.Type.ABOUT.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$ActivityContent$Type[com.apptentive.android.sdk.module.ActivityContent.Type.MESSAGE_CENTER.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$ActivityContent$Type[com.apptentive.android.sdk.module.ActivityContent.Type.INTERACTION.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type = new int[com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type[com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type.UpgradeMessage.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type[com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type.EnjoymentDialog.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type[com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type.RatingDialog.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type[com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type.AppStoreRating.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type[com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type.FeedbackDialog.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type[com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type.Survey.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type[com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type.MessageCenter.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type[com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type.TextModal.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$Interaction$Type[com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type.NavigateToLink.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
