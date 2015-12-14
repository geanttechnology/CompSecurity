// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds.json;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.cds.json:
//            CdsContentParser

public static class options
{

    final String displayName;
    final String identifier;
    final byte options[];

    public static options create(JSONObject jsonobject)
        throws JSONException
    {
        return new <init>(jsonobject.getString("identifier"), jsonobject.getString("displayName"), jsonobject.optJSONObject("options"));
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public byte[] getOptions()
    {
        return options;
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("{").append(identifier).append(", ").append(displayName).append(", ");
        Object obj;
        if (options != null)
        {
            obj = options;
        } else
        {
            obj = "null";
        }
        return stringbuilder.append(obj).append("}").toString();
    }

    (String s, String s1, JSONObject jsonobject)
    {
        identifier = s;
        displayName = s1;
        if (jsonobject != null)
        {
            options = jsonobject.toString().getBytes();
            return;
        } else
        {
            options = null;
            return;
        }
    }
}
