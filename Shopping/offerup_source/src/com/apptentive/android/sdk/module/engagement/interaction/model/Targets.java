// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model;

import android.content.Context;
import com.apptentive.android.sdk.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model:
//            Invocation

public class Targets extends JSONObject
{

    public static final String KEY_NAME = "targets";

    public Targets(String s)
    {
        super(s);
    }

    public String getApplicableInteraction(Context context, String s)
    {
        JSONArray jsonarray;
        int i;
        jsonarray = optJSONArray(s);
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        i = 0;
_L3:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = jsonarray.optJSONObject(i);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new Invocation(((JSONObject) (obj)).toString());
        if (!((Invocation) (obj)).isCriteriaMet(context))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((Invocation) (obj)).getInteractionId();
        return ((String) (obj));
        JSONException jsonexception;
        jsonexception;
        i++;
          goto _L3
_L2:
        Log.v("No runnable Interactions for EventLabel: %s", new Object[] {
            s
        });
        return null;
    }
}
