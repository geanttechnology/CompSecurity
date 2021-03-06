// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.server.api;

import com.google.android.gms.common.server.response.FastMapJsonResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class AchievementUpdateResponse extends FastMapJsonResponse
{

    private static final TreeMap sFields;

    public AchievementUpdateResponse()
    {
    }

    public final String getAchievementId()
    {
        return (String)super.mValues.get("achievementId");
    }

    public final String getCurrentState()
    {
        return (String)super.mValues.get("currentState");
    }

    public final Map getFieldMappings()
    {
        return sFields;
    }

    static 
    {
        TreeMap treemap = new TreeMap();
        sFields = treemap;
        treemap.put("achievementId", com.google.android.gms.common.server.response.FastJsonResponse.Field.forString("achievementId"));
        sFields.put("currentState", com.google.android.gms.common.server.response.FastJsonResponse.Field.forString("currentState"));
        sFields.put("currentSteps", com.google.android.gms.common.server.response.FastJsonResponse.Field.forInteger("currentSteps"));
        sFields.put("newlyUnlocked", com.google.android.gms.common.server.response.FastJsonResponse.Field.forBoolean("newlyUnlocked"));
        sFields.put("updateOccurred", com.google.android.gms.common.server.response.FastJsonResponse.Field.forBoolean("updateOccurred"));
    }
}
