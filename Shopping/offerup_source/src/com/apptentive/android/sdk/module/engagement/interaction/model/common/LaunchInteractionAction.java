// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model.common;

import com.apptentive.android.sdk.module.engagement.interaction.model.Invocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model.common:
//            Action

public class LaunchInteractionAction extends Action
{

    private static final String KEY_INVOKES = "invokes";

    public LaunchInteractionAction(String s)
    {
        super(s);
    }

    public List getInvocations()
    {
        ArrayList arraylist = new ArrayList();
        if (isNull("invokes")) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = getJSONArray("invokes");
        if (jsonarray != null)
        {
            int i = 0;
            do
            {
                try
                {
                    if (i >= jsonarray.length())
                    {
                        break;
                    }
                    arraylist.add(new Invocation(jsonarray.getJSONObject(i).toString()));
                }
                catch (JSONException jsonexception)
                {
                    break;
                }
                i++;
            } while (true);
        }
_L2:
        return arraylist;
    }
}
