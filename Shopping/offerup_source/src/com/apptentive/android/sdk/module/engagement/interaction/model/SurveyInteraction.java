// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model;

import com.apptentive.android.sdk.module.engagement.interaction.model.survey.MultichoiceQuestion;
import com.apptentive.android.sdk.module.engagement.interaction.model.survey.MultiselectQuestion;
import com.apptentive.android.sdk.module.engagement.interaction.model.survey.SinglelineQuestion;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model:
//            Interaction, InteractionConfiguration

public class SurveyInteraction extends Interaction
{

    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_NAME = "name";
    private static final String KEY_QUESTIONS = "questions";
    private static final String KEY_REQUIRED = "required";
    private static final String KEY_SHOW_SUCCESS_MESSAGE = "show_success_message";
    private static final String KEY_SUCCESS_MESSAGE = "success_message";

    public SurveyInteraction(String s)
    {
        super(s);
    }

    public String getDescription()
    {
        Object obj = getConfiguration();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (!((InteractionConfiguration) (obj)).has("description"))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj = ((InteractionConfiguration) (obj)).getString("description");
        return ((String) (obj));
        JSONException jsonexception;
        jsonexception;
        return null;
    }

    public String getName()
    {
        Object obj = getConfiguration();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (!((InteractionConfiguration) (obj)).has("name"))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj = ((InteractionConfiguration) (obj)).getString("name");
        return ((String) (obj));
        JSONException jsonexception;
        jsonexception;
        return null;
    }

    public List getQuestions()
    {
        Object obj = getConfiguration();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!((InteractionConfiguration) (obj)).has("questions")) goto _L2; else goto _L3
_L3:
        ArrayList arraylist;
        JSONArray jsonarray;
        arraylist = new ArrayList();
        jsonarray = ((InteractionConfiguration) (obj)).getJSONArray("questions");
        int i = 0;
_L13:
        if (i >= jsonarray.length()) goto _L5; else goto _L4
_L4:
        com.apptentive.android.sdk.module.engagement.interaction.model.survey.Question.Type type;
        obj = (JSONObject)jsonarray.get(i);
        type = com.apptentive.android.sdk.module.engagement.interaction.model.survey.Question.Type.valueOf(((JSONObject) (obj)).getString("type"));
        _cls1..SwitchMap.com.apptentive.android.sdk.module.engagement.interaction.model.survey.Question.Type[type.ordinal()];
        JVM INSTR tableswitch 1 3: default 165
    //                   1 115
    //                   2 130
    //                   3 145;
           goto _L6 _L7 _L8 _L9
_L11:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            arraylist.add(obj);
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L2
_L7:
        obj = new SinglelineQuestion(((JSONObject) (obj)).toString());
        continue; /* Loop/switch isn't completed */
_L8:
        obj = new MultichoiceQuestion(((JSONObject) (obj)).toString());
        continue; /* Loop/switch isn't completed */
_L9:
        obj = new MultiselectQuestion(((JSONObject) (obj)).toString());
        continue; /* Loop/switch isn't completed */
_L5:
        return arraylist;
_L2:
        return null;
_L6:
        obj = null;
        if (true) goto _L11; else goto _L10
_L10:
        i++;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public String getSuccessMessage()
    {
        Object obj = getConfiguration();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (!((InteractionConfiguration) (obj)).has("success_message"))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj = ((InteractionConfiguration) (obj)).getString("success_message");
        return ((String) (obj));
        JSONException jsonexception;
        jsonexception;
        return null;
    }

    public boolean isRequired()
    {
        InteractionConfiguration interactionconfiguration = getConfiguration();
        if (interactionconfiguration == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        boolean flag;
        if (!interactionconfiguration.has("required"))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        flag = interactionconfiguration.getBoolean("required");
        return flag;
        JSONException jsonexception;
        jsonexception;
        return false;
    }

    public boolean isShowSuccessMessage()
    {
        InteractionConfiguration interactionconfiguration = getConfiguration();
        if (interactionconfiguration == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        boolean flag;
        if (!interactionconfiguration.has("show_success_message"))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        flag = interactionconfiguration.getBoolean("show_success_message");
        return flag;
        JSONException jsonexception;
        jsonexception;
        return false;
    }

    private class _cls1
    {

        static final int $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$survey$Question$Type[];

        static 
        {
            $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$survey$Question$Type = new int[com.apptentive.android.sdk.module.engagement.interaction.model.survey.Question.Type.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$survey$Question$Type[com.apptentive.android.sdk.module.engagement.interaction.model.survey.Question.Type.singleline.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$survey$Question$Type[com.apptentive.android.sdk.module.engagement.interaction.model.survey.Question.Type.multichoice.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$survey$Question$Type[com.apptentive.android.sdk.module.engagement.interaction.model.survey.Question.Type.multiselect.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
