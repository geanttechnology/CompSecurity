// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model;

import com.apptentive.android.sdk.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model:
//            Interaction

public class Interactions extends JSONObject
{

    public static final String KEY_NAME = "interactions";

    public Interactions()
    {
    }

    public Interactions(String s)
    {
        super(s);
    }

    private boolean isLegacyInteractions()
    {
        return !isNull("interactions");
    }

    public Interaction getInteraction(String s)
    {
        if (isNull(s))
        {
            break MISSING_BLOCK_LABEL_33;
        }
        s = Interaction.Factory.parseInteraction(getJSONObject(s).toString());
        return s;
        s;
        Log.w("Exception parsing interactions array.", s, new Object[0]);
        return null;
    }

    public List getInteractionList()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = keys();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = optJSONObject((String)iterator.next());
            if (obj != null)
            {
                obj = Interaction.Factory.parseInteraction(((JSONObject) (obj)).toString());
                if (obj != null)
                {
                    arraylist.add(obj);
                }
            }
        } while (true);
        return arraylist;
    }
}
