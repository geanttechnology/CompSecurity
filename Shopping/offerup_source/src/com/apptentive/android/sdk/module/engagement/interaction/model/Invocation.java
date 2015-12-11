// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model:
//            InteractionCriteria

public class Invocation extends JSONObject
{

    private static final String KEY_CRITERIA = "criteria";
    private static final String KEY_INTERACTION_ID = "interaction_id";

    public Invocation(String s)
    {
        super(s);
    }

    public String getInteractionId()
    {
        String s;
        if (isNull("interaction_id"))
        {
            break MISSING_BLOCK_LABEL_19;
        }
        s = getString("interaction_id");
        return s;
        JSONException jsonexception;
        jsonexception;
        return null;
    }

    public boolean isCriteriaMet(Context context)
    {
        boolean flag;
        if (isNull("criteria"))
        {
            break MISSING_BLOCK_LABEL_33;
        }
        flag = (new InteractionCriteria(getJSONObject("criteria").toString())).isMet(context);
        return flag;
        context;
        return false;
    }
}
