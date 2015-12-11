// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model;

import com.apptentive.android.sdk.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model:
//            Interactions, Interaction, Targets

public class InteractionsPayload extends JSONObject
{

    public InteractionsPayload(String s)
    {
        super(s);
    }

    public Interactions getInteractions()
    {
        Interactions interactions;
        Object obj;
        if (isNull("interactions"))
        {
            break MISSING_BLOCK_LABEL_94;
        }
        obj = get("interactions");
        if (!(obj instanceof JSONArray))
        {
            break MISSING_BLOCK_LABEL_94;
        }
        interactions = new Interactions();
        obj = (JSONArray)obj;
        int i = 0;
_L2:
        Interaction interaction;
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        interaction = Interaction.Factory.parseInteraction(((JSONArray) (obj)).getString(i));
        if (interaction == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        interactions.put(interaction.getId(), interaction);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return interactions;
        JSONException jsonexception;
        jsonexception;
        Log.w("Unable to load Interactions from InteractionsPayload.", jsonexception, new Object[0]);
        return null;
    }

    public Targets getTargets()
    {
        Targets targets;
        if (isNull("targets"))
        {
            break MISSING_BLOCK_LABEL_39;
        }
        targets = new Targets(get("targets").toString());
        return targets;
        JSONException jsonexception;
        jsonexception;
        Log.w("Unable to load Targets from InteractionsPayload.", jsonexception, new Object[0]);
        return null;
    }
}
