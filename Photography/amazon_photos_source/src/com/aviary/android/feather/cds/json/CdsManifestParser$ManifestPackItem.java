// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds.json;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.cds.json:
//            CdsManifestParser

public static class versionKey
{

    final String identifier;
    final String versionKey;

    public String getIdentifier()
    {
        return identifier;
    }

    public String getVersionKey()
    {
        return versionKey;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ManifestPackItem{ identifier: ").append(identifier).append(", versionKey: ").append(versionKey).append("}").toString();
    }

    public (JSONObject jsonobject, boolean flag)
        throws JSONException
    {
        identifier = jsonobject.getString("identifier");
        if (flag)
        {
            versionKey = jsonobject.getString("versionKey");
            return;
        } else
        {
            versionKey = jsonobject.optString("versionKey");
            return;
        }
    }
}
