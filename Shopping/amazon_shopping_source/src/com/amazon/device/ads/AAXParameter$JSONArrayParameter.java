// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, DebugProperties, Log

static class  extends AAXParameter
{

    protected volatile Object getFromDebugProperties()
    {
        return getFromDebugProperties();
    }

    protected JSONArray getFromDebugProperties()
    {
        return parseFromString(DebugProperties.getDebugPropertyAsString(getDebugName(), null));
    }

    protected volatile Object parseFromString(String s)
    {
        return parseFromString(s);
    }

    protected JSONArray parseFromString(String s)
    {
        try
        {
            s = new JSONArray(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(AAXParameter.access$100(), "Unable to parse the following value into a JSONArray: %s", new Object[] {
                getName()
            });
            return null;
        }
        return s;
    }

    (String s, String s1)
    {
        super(s, s1);
    }
}
