// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.apptentive.android.sdk.module.engagement.EngagementModule;
import com.apptentive.android.sdk.module.engagement.interaction.model.TextModalInteraction;
import com.apptentive.android.sdk.module.engagement.interaction.model.common.Action;
import com.apptentive.android.sdk.module.engagement.interaction.model.common.Actions;
import com.apptentive.android.sdk.module.engagement.interaction.view.common.ApptentiveDialogButton;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.view:
//            InteractionView

public class TextModalInteractionView extends InteractionView
{

    private static final int MAX_TEXT_LENGTH_FOR_FOUR_BUTTONS = 11;
    private static final int MAX_TEXT_LENGTH_FOR_ONE_BUTTONS = 19;
    private static final int MAX_TEXT_LENGTH_FOR_THREE_BUTTONS = 15;
    private static final int MAX_TEXT_LENGTH_FOR_TWO_BUTTONS = 17;

    public TextModalInteractionView(TextModalInteraction textmodalinteraction)
    {
        super(textmodalinteraction);
    }

    public void doOnCreate(final Activity activity, Bundle bundle)
    {
        final Action buttonAction;
        ApptentiveDialogButton apptentivedialogbutton;
        final int position;
        boolean flag = false;
        activity.setContentView(com.apptentive.android.sdk.R.layout.apptentive_textmodal_interaction_center);
        bundle = (TextView)activity.findViewById(com.apptentive.android.sdk.R.id.title);
        List list;
        if (((TextModalInteraction)interaction).getTitle() == null)
        {
            bundle.setVisibility(8);
        } else
        {
            bundle.setText(((TextModalInteraction)interaction).getTitle());
        }
        bundle = (TextView)activity.findViewById(com.apptentive.android.sdk.R.id.body);
        if (((TextModalInteraction)interaction).getBody() == null)
        {
            bundle.setVisibility(8);
        } else
        {
            bundle.setText(((TextModalInteraction)interaction).getBody());
        }
        bundle = (LinearLayout)activity.findViewById(com.apptentive.android.sdk.R.id.bottom_area);
        list = ((TextModalInteraction)interaction).getActions().getAsList();
        if (list == null || list.isEmpty())
        {
            break MISSING_BLOCK_LABEL_454;
        }
        buttonAction = list.iterator();
        for (position = 0; buttonAction.hasNext(); position = ((Action)buttonAction.next()).getLabel().length() + position) { }
        if (list.size() == 1)
        {
            position = 0;
        } else
        if (list.size() == 2)
        {
            if (position > 17)
            {
                position = 1;
            } else
            {
                position = 0;
            }
        } else
        if (list.size() == 3)
        {
            if (position > 15)
            {
                position = 1;
            } else
            {
                position = 0;
            }
        } else
        if (list.size() == 4)
        {
            if (position > 11)
            {
                position = 1;
            } else
            {
                position = 0;
            }
        } else
        {
            position = 1;
        }
        if (position != 0)
        {
            bundle.setOrientation(1);
            position = ((flag) ? 1 : 0);
        } else
        {
            bundle.setOrientation(0);
            position = ((flag) ? 1 : 0);
        }
        if (position >= list.size())
        {
            break MISSING_BLOCK_LABEL_460;
        }
        buttonAction = (Action)list.get(position);
        apptentivedialogbutton = new ApptentiveDialogButton(activity);
        apptentivedialogbutton.setText(buttonAction.getLabel());
        switch (_cls3..SwitchMap.com.apptentive.android.sdk.module.engagement.interaction.model.common.Action.Type[buttonAction.getType().ordinal()])
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_433;
_L4:
        bundle.addView(apptentivedialogbutton);
        position++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_214;
_L1:
        apptentivedialogbutton.setOnClickListener(new _cls1());
        continue; /* Loop/switch isn't completed */
        apptentivedialogbutton.setOnClickListener(new _cls2());
        if (true) goto _L4; else goto _L3
_L3:
        bundle.setVisibility(8);
    }

    public boolean onBackPressed(Activity activity)
    {
        EngagementModule.engageInternal(activity, interaction, "cancel");
        return true;
    }

    private class _cls3
    {

        static final int $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$common$Action$Type[];

        static 
        {
            $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$common$Action$Type = new int[com.apptentive.android.sdk.module.engagement.interaction.model.common.Action.Type.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$common$Action$Type[com.apptentive.android.sdk.module.engagement.interaction.model.common.Action.Type.dismiss.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$common$Action$Type[com.apptentive.android.sdk.module.engagement.interaction.model.common.Action.Type.interaction.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final TextModalInteractionView this$0;
        final Activity val$activity;
        final Action val$buttonAction;
        final int val$position;

        public void onClick(View view)
        {
            view = new JSONObject();
            try
            {
                view.put("action_id", buttonAction.getId());
                view.put("label", buttonAction.getLabel());
                view.put("position", position);
            }
            catch (JSONException jsonexception)
            {
                Log.e("Error creating Event data object.", jsonexception, new Object[0]);
            }
            EngagementModule.engageInternal(activity, interaction, "dismiss", view.toString());
            activity.finish();
        }

        _cls1()
        {
            this$0 = TextModalInteractionView.this;
            buttonAction = action;
            position = i;
            activity = activity1;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final TextModalInteractionView this$0;
        final Activity val$activity;
        final Action val$buttonAction;
        final int val$position;

        public void onClick(View view)
        {
            view = ((LaunchInteractionAction)buttonAction).getInvocations().iterator();
_L4:
            if (!view.hasNext()) goto _L2; else goto _L1
_L1:
            Object obj = (Invocation)view.next();
            if (!((Invocation) (obj)).isCriteriaMet(activity)) goto _L4; else goto _L3
_L3:
            view = ((Invocation) (obj)).getInteractionId();
_L14:
            if (view == null) goto _L6; else goto _L5
_L5:
            obj = InteractionManager.getInteractions(activity);
            if (obj == null) goto _L6; else goto _L7
_L7:
            view = ((Interactions) (obj)).getInteraction(view);
_L12:
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("action_id", buttonAction.getId());
            jsonobject.put("label", buttonAction.getLabel());
            jsonobject.put("position", position);
            if (view != null) goto _L9; else goto _L8
_L8:
            obj = JSONObject.NULL;
_L10:
            jsonobject.put("invoked_interaction_id", obj);
_L11:
            EngagementModule.engageInternal(activity, interaction, "interaction", jsonobject.toString());
            if (view != null)
            {
                EngagementModule.launchInteraction(activity, view);
            }
            activity.finish();
            return;
_L9:
            obj = view.getId();
              goto _L10
            JSONException jsonexception;
            jsonexception;
            Log.e("Error creating Event data object.", jsonexception, new Object[0]);
              goto _L11
_L6:
            view = null;
            if (true) goto _L12; else goto _L2
_L2:
            view = null;
            if (true) goto _L14; else goto _L13
_L13:
        }

        _cls2()
        {
            this$0 = TextModalInteractionView.this;
            buttonAction = action;
            activity = activity1;
            position = i;
            super();
        }
    }

}
