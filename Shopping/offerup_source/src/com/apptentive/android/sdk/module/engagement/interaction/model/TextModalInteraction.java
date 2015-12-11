// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model;

import com.apptentive.android.sdk.module.engagement.interaction.model.common.Actions;
import org.json.JSONException;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model:
//            Interaction, InteractionConfiguration

public class TextModalInteraction extends Interaction
{

    public static final String EVENT_KEY_ACTION_ID = "action_id";
    public static final String EVENT_KEY_ACTION_POSITION = "position";
    public static final String EVENT_KEY_INVOKED_INTERACTION_ID = "invoked_interaction_id";
    public static final String EVENT_NAME_CANCEL = "cancel";
    public static final String EVENT_NAME_DISMISS = "dismiss";
    public static final String EVENT_NAME_INTERACTION = "interaction";
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_BODY = "body";
    private static final String KEY_TITLE = "title";

    public TextModalInteraction(String s)
    {
        super(s);
    }

    public Actions getActions()
    {
        Object obj = getConfiguration();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (!((InteractionConfiguration) (obj)).has("actions"))
        {
            break MISSING_BLOCK_LABEL_35;
        }
        obj = new Actions(((InteractionConfiguration) (obj)).getString("actions"));
        return ((Actions) (obj));
        JSONException jsonexception;
        jsonexception;
        return null;
    }

    public String getBody()
    {
        Object obj = getConfiguration();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (!((InteractionConfiguration) (obj)).has("body"))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj = ((InteractionConfiguration) (obj)).getString("body");
        return ((String) (obj));
        JSONException jsonexception;
        jsonexception;
        return null;
    }

    public String getTitle()
    {
        Object obj = getConfiguration();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (!((InteractionConfiguration) (obj)).has("title"))
        {
            break MISSING_BLOCK_LABEL_28;
        }
        obj = ((InteractionConfiguration) (obj)).getString("title");
        return ((String) (obj));
        JSONException jsonexception;
        jsonexception;
        return null;
    }
}
