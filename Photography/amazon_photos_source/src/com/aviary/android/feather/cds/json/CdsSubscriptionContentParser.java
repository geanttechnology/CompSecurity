// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds.json;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.cds.json:
//            CdsJsonParser

public class CdsSubscriptionContentParser extends CdsJsonParser
{

    String displayDescription;
    String displayName;
    int durationTier;
    String identifier;
    String previewURL;
    String previewVersion;
    String unlockType;
    String versionKey;

    public CdsSubscriptionContentParser()
    {
    }

    public String getDisplayDescription()
    {
        return displayDescription;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public int getDurationTier()
    {
        return durationTier;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getPreviewURL()
    {
        return previewURL;
    }

    public String getPreviewVersion()
    {
        return previewVersion;
    }

    public String getUnlockType()
    {
        return unlockType;
    }

    public String getVersionKey()
    {
        return versionKey;
    }

    protected void onParseJson(JSONObject jsonobject)
        throws JSONException
    {
        identifier = jsonobject.getString("identifier");
        versionKey = jsonobject.getString("versionKey");
        displayName = jsonobject.getString("displayName");
        displayDescription = jsonobject.getString("displayDescription");
        durationTier = jsonobject.getInt("durationTier");
        unlockType = jsonobject.getString("unlockType");
    }
}
